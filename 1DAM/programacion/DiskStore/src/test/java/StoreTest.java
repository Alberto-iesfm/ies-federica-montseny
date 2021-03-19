import org.iesfm.discos.Disk;
import org.iesfm.discos.Member;
import org.iesfm.discos.Order;
import org.iesfm.discos.Store;
import org.iesfm.discos.exceptions.ArtistNotExistsException;
import org.iesfm.discos.exceptions.GenreNotExistException;
import org.iesfm.discos.exceptions.PostCodeNotMembersException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class StoreTest {
    private Store store;

    @Before
    public void setUp (){
        Set<String> genres1 = new HashSet<>();
        genres1.add("Rock");
        genres1.add("Pop");
        Set<String> genres2 = new HashSet<>();
        genres2.add("Rock");
        genres2.add("Hard-rock");
        Set<String> genres3 = new HashSet<>();
        genres3.add("Metal");
        genres3.add("Hard-rock");

        Map<String,Disk> disks = new HashMap<>();
        disks.put("Dulce introduccion al caos", new Disk("Dulce introduccion al caos", "Extremoduro", genres1));
        disks.put("Fear of the dark", new Disk("Fear of the dark", "Iron maiden", genres3));
        disks.put("Black ice", new Disk("Black ice", "AC/DC", genres2));
        disks.put("The trooper", new Disk("The trooper", "Iron maiden", genres3));

        List<Order> orders1 = new LinkedList<>();
        orders1.add(new Order(15.99, (new Date(2018, Calendar.JUNE, 12))));
        orders1.add(new Order(19.99, (new Date(2015, Calendar.MARCH, 2))));

        List<Order> orders2 = new LinkedList<>();
        orders2.add(new Order(10.99, (new Date(2009, Calendar.AUGUST, 21))));
        orders2.add(new Order(15.99, (new Date(2017, Calendar.DECEMBER, 12))));

        List<Order> orders3 = new LinkedList<>();
        orders3.add(new Order(19.99, (new Date(2020, Calendar.FEBRUARY, 15))));
        orders3.add(new Order(10.99, (new Date(2005, Calendar.FEBRUARY, 24))));

        Map<String, Member> members = new HashMap<>();
        members.put("01237895L", new Member("Juan", "Perez Diaz", "01237895L", 28214, orders2));
        members.put("32068465T", new Member("Diana", "Marquez Fernandez", "32068465T", 28214, orders3));
        members.put("49567214V", new Member("Pedro", "Blanco Hernando", "49567214V", 28925, orders1));

        store = new Store("Todo discos", "av. europa, 25", disks, members);
    }

    @Test
    public void getGenreDisksByTitleTest () throws GenreNotExistException {
        Set<String> genres2 = new HashSet<>();
        genres2.add("Rock");
        genres2.add("Hard-rock");
        Set<String> genres3 = new HashSet<>();
        genres3.add("Metal");
        genres3.add("Hard-rock");

        Set<Disk> expected = new TreeSet<>();
        expected.add(new Disk("Black ice", "AC/DC", genres2));
        expected.add(new Disk("Fear of the dark", "Iron maiden", genres3));
        expected.add(new Disk("The trooper", "Iron maiden", genres3));

        Set<Disk> result = store.getGenreDisksByTitle("Hard-rock");

        Assert.assertEquals(expected, result);
    }

    @Test (expected = GenreNotExistException.class)
    public void getNotExistsGenreDisksByTitleTest () throws GenreNotExistException{
        store.getGenreDisksByTitle("Electronica");
    }

    @Test
    public void getPostCodeMembersTest () throws PostCodeNotMembersException {
        List<Order> orders2 = new LinkedList<>();
        orders2.add(new Order(10.99, (new Date(2009, Calendar.AUGUST, 21))));
        orders2.add(new Order(15.99, (new Date(2017, Calendar.DECEMBER, 12))));
        List<Order> orders3 = new LinkedList<>();
        orders3.add(new Order(19.99, (new Date(2020, Calendar.FEBRUARY, 15))));
        orders3.add(new Order(10.99, (new Date(2005, Calendar.FEBRUARY, 24))));

        Map<String, Member> expected = new HashMap<>();
        expected.put("01237895L", new Member("Juan", "Perez Diaz", "01237895L", 28214, orders2));
        expected.put("32068465T", new Member("Diana", "Marquez Fernandez", "32068465T", 28214, orders3));

        Map<String, Member> result = store.getPostCodeMembers(28214);

        Assert.assertEquals(expected, result);
    }

    @Test (expected = PostCodeNotMembersException.class)
    public void getPostCodeNotMembersTest () throws PostCodeNotMembersException {
        store.getPostCodeMembers(28234);
    }

    @Test
    public void existDiskTest () {
        Assert.assertTrue(store.existDisk("Black ice"));
    }

    @Test
    public void notExistDiskTest () {
        Assert.assertFalse(store.existDisk("And justice for all"));
    }

    @Test
    public void getArtistDisksByTitleTest () throws ArtistNotExistsException{
        Set<String> genres3 = new HashSet<>();
        genres3.add("Metal");
        genres3.add("Hard-rock");

        Set<Disk> expected = new TreeSet<>();
        expected.add(new Disk("Fear of the dark", "Iron maiden", genres3));
        expected.add(new Disk("The trooper", "Iron maiden", genres3));

        Set<Disk> result = store.getArtistDisksByTitle("Iron maiden");

        Assert.assertEquals(expected, result);
    }

    @Test (expected = ArtistNotExistsException.class)
    public void getNotExistsArtistDisksByTitleTest () throws ArtistNotExistsException{
        store.getArtistDisksByTitle("Marea");
    }
}
