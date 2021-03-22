package org.iesfm.discos;

import org.iesfm.discos.exceptions.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IStore {

    public Set<Disk> getGenreDisksByTitle(String genre) throws GenreNotExistException;

    public Map<String, Member> getPostCodeMembers(int postCode) throws PostCodeNotMembersException;

    public boolean existDisk (String title);

    public Set<Disk> getArtistDisksByTitle (String artist) throws ArtistNotExistsException;

    public List<Order> getMemberOrders (String nif) throws MemberNotFoundException;

    public double getMemberTotalSpending (String nif) throws MemberNotFoundException;

    public int getAmountArtistDisks (String artist) throws ArtistNotExistsException;

    public Map<String, Disk> removeDisk (String title) throws DiskNotExistsException;

    public Map<String, Disk> insertDisk (Disk newDisk);

}
