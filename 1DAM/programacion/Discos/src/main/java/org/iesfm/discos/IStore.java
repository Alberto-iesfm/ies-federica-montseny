package org.iesfm.discos;

import java.util.Set;

public interface IStore {

    public Set<Disk> getGenreDisksByTitle(String genre);

    public Set<Member> getPostCodeMembers(int postCode);

}
