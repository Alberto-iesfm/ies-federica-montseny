package org.iesfm.discos;

import org.iesfm.discos.exceptions.*;

import java.util.*;

public class Store implements IStore{
    private String name;
    private String adress;
    private Map<String,Disk> disks;
    private Map<String,Member> members;

    public Store(String name, String adress, Map<String,Disk> disks, Map<String, Member> members) {
        this.name = name;
        this.adress = adress;
        this.disks = disks;
        this.members = members;
    }

    @Override
    public Set<Disk> getGenreDisksByTitle(String genre) throws GenreNotExistException {
        Set<Disk> genreDisks = new TreeSet<>();
        for (Disk disk:disks.values()){
            if (disk.hasGenre(genre)){
                genreDisks.add(disk);
            }
        }
        if (genreDisks.isEmpty()){
            throw new GenreNotExistException();
        }
        return genreDisks;
    }

    @Override
    public Map<String, Member> getPostCodeMembers(int postCode) throws PostCodeNotMembersException {
        Map<String, Member> postCodeMembers = new HashMap<>();
        for (Member member:members.values()){
            if (member.getPostCode() == postCode){
                postCodeMembers.put(member.getNif(),member);
            }
        }
        if (postCodeMembers.isEmpty()){
            throw new PostCodeNotMembersException();
        }
        return postCodeMembers;
    }

    @Override
    public Set<Disk> getArtistDisksByTitle(String artist) throws ArtistNotExistsException{
        Set<Disk> artistDisks = new TreeSet<>();
        for (Disk disk:disks.values()){
            if (disk.getArtist().equals(artist)){
                artistDisks.add(disk);
            }
        }
        if (artistDisks.isEmpty()){
            throw new ArtistNotExistsException();
        }
        return artistDisks;
    }

    @Override
    public List<Order> getMemberOrders(String nif) throws MemberNotFoundException{
        Member memberFound = members.get(nif);
        if (memberFound == null){
            throw new MemberNotFoundException();
        }
        return memberFound.getOrders();
    }

    @Override
    public double getMemberTotalSpending(String nif) throws MemberNotFoundException {
        double totalSpending = 0;
        List<Order> memberOrders = getMemberOrders(nif);
        for (Order order: memberOrders){
            totalSpending += order.getPrice();
        }
        return totalSpending;
    }

    @Override
    public int getAmountArtistDisks(String artist) throws ArtistNotExistsException {
        Set<Disk> artistDisks = getArtistDisksByTitle(artist);
        return artistDisks.size();
    }

    @Override
    public boolean existDisk(String title) {
        return disks.containsKey(title);
    }

    @Override
    public Map<String, Disk> removeDisk(String title) throws DiskNotExistsException {
        if (!existDisk(title)){
            throw new DiskNotExistsException();
        }
        disks.remove(title);
        return disks;
    }

    @Override
    public Map<String, Disk> insertDisk(Disk newDisk) {
        disks.put(newDisk.getTitle(), newDisk);
        return disks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Map<String, Disk> getDisks() {
        return disks;
    }

    public void setDisks(Map<String,Disk> disks) {
        this.disks = disks;
    }

    public Map<String, Member> getMembers() {
        return members;
    }

    public void setMembers(Map<String, Member> members) {
        this.members = members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(name, store.name) && Objects.equals(adress, store.adress) && Objects.equals(disks, store.disks) && Objects.equals(members, store.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, adress, disks, members);
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", disks=" + disks +
                ", members=" + members +
                '}';
    }
}
