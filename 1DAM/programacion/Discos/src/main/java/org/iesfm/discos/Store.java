package org.iesfm.discos;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Store implements IStore{
    private String name;
    private String adress;
    private Set<Disk> disks;
    private List<Member> members;

    public Store(String name, String adress, Set<Disk> disks, List<Member> members) {
        this.name = name;
        this.adress = adress;
        this.disks = disks;
        this.members = members;
    }

    @Override
    public Set<Disk> getGenreDisksByTitle(String genre) {
        Set<Disk> genreDisks = new TreeSet<>();
        for (Disk disk:disks){
            if (disk.hasGenre(genre)){
                genreDisks.add(disk);
            }
        }
        return genreDisks;
    }

    @Override
    public Set<Member> getPostCodeMembers(int postCode) {
        return null;
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

    public Set<Disk> getDisks() {
        return disks;
    }

    public void setDisks(Set<Disk> disks) {
        this.disks = disks;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
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
