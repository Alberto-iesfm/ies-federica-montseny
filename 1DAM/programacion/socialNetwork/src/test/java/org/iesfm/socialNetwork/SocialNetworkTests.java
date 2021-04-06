package org.iesfm.socialNetwork;

import org.iesfm.socialNetwork.comparators.WallComparatorByDate;
import org.iesfm.socialNetwork.exceptions.AuthorNotFoundException;
import org.iesfm.socialNetwork.exceptions.TagNotFoundException;
import org.iesfm.socialNetwork.exceptions.UserNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class SocialNetworkTests {
    private ISocialNetwork socialNetwork;

    @Before
    public void setUp() {
        Set<String> tags1 = new HashSet<>();
        tags1.add("Food");
        tags1.add("Sports");
        Set<String> tags2 = new HashSet<>();
        tags2.add("Sports");
        tags2.add("Music");
        Set<String> tags3 = new HashSet<>();
        tags3.add("Food");

        Set<Post> wall1 = new TreeSet<>(new WallComparatorByDate());
        wall1.add(new Post("usuario1", "mensaje1", "25-03-2021", tags2));
        wall1.add(new Post("usuario3", "mensaje1.2", "22-02-2021", tags1));
        wall1.add(new Post("usuario1", "mensaje1.3", "01-04-2021", tags2));

        Set<Post> wall2 = new TreeSet<>(new WallComparatorByDate());
        wall2.add(new Post("usuario2", "mensaje2", "29-03-2021", tags3));
        wall2.add(new Post("usuario1", "mensaje2.2", "23-01-2021", tags1));
        wall2.add(new Post("usuario3", "mensaje2.3", "01-12-2020", tags2));

        Set<Post> wall3 = new TreeSet<>(new WallComparatorByDate());
        wall3.add(new Post("usuario2", "mensaje3", "25-11-2020", tags3));
        wall3.add(new Post("usuario3", "mensaje3.2", "02-04-2021", tags1));
        wall3.add(new Post("usuario3", "mensaje3.3", "01-02-2021", tags3));

        Map<String, User> users = new TreeMap<>();
        users.put("usuario1", new User("usuario1", wall1));
        users.put("usuario2", new User("usuario2", wall2));
        users.put("usuario3", new User("usuario3", wall3));

        List<Post> trendingTopics = new LinkedList<>();
        trendingTopics.add(new Post("usuario1", "mensaje1", "25-03-2021", tags2));
        trendingTopics.add(new Post("usuario3", "mensaje2.3", "01-12-2020", tags2));
        trendingTopics.add(new Post("usuario3", "mensaje3.2", "02-04-2021", tags1));

        socialNetwork = new SocialNetwork("testNetwork", users, trendingTopics);
    }

    @Test
    public void getUserWallTest() throws UserNotFoundException {
        Set<String> tags1 = new HashSet<>();
        tags1.add("Food");
        tags1.add("Sports");
        Set<String> tags2 = new HashSet<>();
        tags2.add("Sports");
        tags2.add("Music");
        Set<String> tags3 = new HashSet<>();
        tags3.add("Food");

        Set<Post> expected = new TreeSet<>(new WallComparatorByDate());
        expected.add(new Post("usuario2", "mensaje2", "29-03-2021", tags3));
        expected.add(new Post("usuario1", "mensaje2.2", "23-01-2021", tags1));
        expected.add(new Post("usuario3", "mensaje2.3", "01-12-2020", tags2));

        Set<Post> result = socialNetwork.getUserWall("usuario2");

        Assert.assertEquals(expected, result);
    }

    @Test (expected = UserNotFoundException.class)
    public void getNotExistUserWallTest() throws UserNotFoundException{
        socialNetwork.getUserWall("usuario5");
    }

    @Test
    public void getTagAndUserPostsTest() throws UserNotFoundException, TagNotFoundException {
        Set<String> tags1 = new HashSet<>();
        tags1.add("Food");
        tags1.add("Sports");
        Set<String> tags3 = new HashSet<>();
        tags3.add("Food");

        Set<Post> expected = new TreeSet<>(new WallComparatorByDate());
        expected.add(new Post("usuario2", "mensaje2", "29-03-2021", tags3));
        expected.add(new Post("usuario1", "mensaje2.2", "23-01-2021", tags1));

        Set<Post> result = socialNetwork.getTagAndUserPosts("usuario2", "Food");

        Assert.assertEquals(expected, result);
    }

    @Test (expected = UserNotFoundException.class)
    public void getTagAndNotExistsUserPostsTest() throws UserNotFoundException, TagNotFoundException {
        socialNetwork.getTagAndUserPosts("usuario5", "Food");
    }

    @Test (expected = TagNotFoundException.class)
    public void getNotExistsTagAndUserPostsTest() throws UserNotFoundException, TagNotFoundException {
        socialNetwork.getTagAndUserPosts("usuario2", "Films");
    }

    @Test
    public void addNewUserPostTest() throws UserNotFoundException{
        Set<String> tags1 = new HashSet<>();
        tags1.add("Food");
        tags1.add("Sports");
        Set<String> tags2 = new HashSet<>();
        tags2.add("Sports");
        tags2.add("Music");
        Set<String> tags3 = new HashSet<>();
        tags3.add("Food");

        Set<Post> expected = new TreeSet<>(new WallComparatorByDate());
        expected.add(new Post("usuario2", "mensaje2", "29-03-2021", tags3));
        expected.add(new Post("usuario1", "mensaje2.2", "23-01-2021", tags1));
        expected.add(new Post("usuario3", "mensaje2.3", "01-12-2020", tags2));
        expected.add(new Post("usuario2", "mensaje2.4", "05-04-2021", tags1));

        socialNetwork.addNewUserPost("usuario2", "mensaje2.4", "05-04-2021", tags1);

        Assert.assertEquals(expected, socialNetwork.getUserWall("usuario2"));
    }

    @Test (expected = UserNotFoundException.class)
    public void addNewPostNotExistsUserTest() throws UserNotFoundException{
        Set<String> tags1 = new HashSet<>();
        tags1.add("Food");
        tags1.add("Sports");

        socialNetwork.addNewUserPost("usuario5", "mensaje2.4", "05-04-2021", tags1);
    }

    @Test
    public void getAuthorPostsTest() throws AuthorNotFoundException{
        Set<String> tags1 = new HashSet<>();
        tags1.add("Food");
        tags1.add("Sports");
        Set<String> tags2 = new HashSet<>();
        tags2.add("Sports");
        tags2.add("Music");
        Set<String> tags3 = new HashSet<>();
        tags3.add("Food");

        List<Post> expected = new LinkedList<>();
        List<Post> user1ExpectedPosts = new LinkedList<>();
        user1ExpectedPosts.add(new Post("usuario3", "mensaje1.2", "22-02-2021", tags1));
        expected.addAll(user1ExpectedPosts);
        List<Post> user2ExpectedPosts = new LinkedList<>();
        user2ExpectedPosts.add(new Post("usuario3", "mensaje2.3", "01-12-2020", tags2));
        expected.addAll(user2ExpectedPosts);
        List<Post> user3ExpectedPosts = new LinkedList<>();
        user3ExpectedPosts.add(new Post("usuario3", "mensaje3.2", "02-04-2021", tags1));
        user3ExpectedPosts.add(new Post("usuario3", "mensaje3.3", "01-02-2021", tags3));
        expected.addAll(user3ExpectedPosts);

        Assert.assertEquals(expected, socialNetwork.getAuthorPosts("usuario3"));
    }

    @Test (expected = AuthorNotFoundException.class)
    public void getNotExistsAuthorPostsTest() throws AuthorNotFoundException{
        socialNetwork.getAuthorPosts("usuario5");
    }
}
