package org.iesfm.discos;

import org.iesfm.discos.exceptions.ArtistNotExistsException;
import org.iesfm.discos.exceptions.GenreNotExistException;
import org.iesfm.discos.exceptions.PostCodeNotMembersException;

import java.util.Map;
import java.util.Set;

public interface IStore {

    public Set<Disk> getGenreDisksByTitle(String genre) throws GenreNotExistException;

    public Map<String, Member> getPostCodeMembers(int postCode) throws PostCodeNotMembersException;

    public boolean existDisk (String title);

    public Set<Disk> getArtistDisksByTitle (String artist) throws ArtistNotExistsException;

}
