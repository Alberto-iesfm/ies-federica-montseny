package org.iesfm.discos;

import org.iesfm.discos.exceptions.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IStore {

    Set<Disk> getGenreDisksByTitle(String genre) throws GenreNotExistException;

    Map<String, Member> getPostCodeMembers(int postCode) throws PostCodeNotMembersException;

    boolean existDisk(String title);

    Set<Disk> getArtistDisksByTitle(String artist) throws ArtistNotExistsException;

    List<Order> getMemberOrders(String nif) throws MemberNotFoundException;

    double getMemberTotalSpending(String nif) throws MemberNotFoundException;

    int getAmountArtistDisks(String artist) throws ArtistNotExistsException;

    Map<String, Disk> removeDisk(String title) throws DiskNotExistsException;

    Map<String, Disk> insertDisk(Disk newDisk);

}
