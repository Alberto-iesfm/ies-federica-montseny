package org.iesfm.socialNetwork;

import org.iesfm.socialNetwork.comparators.WallComparatorByDate;
import org.iesfm.socialNetwork.exceptions.AuthorNotFoundException;
import org.iesfm.socialNetwork.exceptions.TagNotFoundException;
import org.iesfm.socialNetwork.exceptions.UserNotFoundException;

import java.util.*;

public class SocialNetwork implements ISocialNetwork{
    private String name;
    private Map<String, User> users;
    private List<Post> trendingTopics;

    public SocialNetwork(String name, Map<String, User> users, List<Post> trendingTopics) {
        this.name = name;
        this.users = users;
        this.trendingTopics = trendingTopics;
    }

    @Override
    public Set<Post> getUserWall(String userName) throws UserNotFoundException{
        if (!users.containsKey(userName)){
            throw new UserNotFoundException();
        }
        return users.get(userName).getWall();
    }

    @Override
    public Set<Post> getTagAndUserPosts(String userName, String tag) throws UserNotFoundException, TagNotFoundException {
        Set<Post> tagPosts = new TreeSet<>(new WallComparatorByDate());
        for (Post post: getUserWall(userName)){
            if (post.getTags().contains(tag)){
                tagPosts.add(post);
            }
        }
        if (tagPosts.isEmpty()){
            throw new TagNotFoundException();
        }
        return tagPosts;
    }

    @Override
    public void addNewUserPost(String userName, String message, String date, Set<String> tags) throws UserNotFoundException{
        Set<Post> userWall = getUserWall(userName);
        userWall.add(new Post(userName, message, date, tags));
    }

    @Override
    public List<Post> getAuthorPosts(String userName) throws AuthorNotFoundException {
        List<Post> authorPosts = new LinkedList<>();
        for (User user:users.values()){
            authorPosts.addAll(user.getAuthorPostInWall(userName));
        }
        if (authorPosts.isEmpty()){
            throw new AuthorNotFoundException();
        }
        return authorPosts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public List<Post> getTrendingTopics() {
        return trendingTopics;
    }

    public void setTrendingTopics(List<Post> trendingTopics) {
        this.trendingTopics = trendingTopics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialNetwork that = (SocialNetwork) o;
        return Objects.equals(name, that.name) && Objects.equals(users, that.users) && Objects.equals(trendingTopics, that.trendingTopics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, users, trendingTopics);
    }

    @Override
    public String toString() {
        return "SocialNetwork{" +
                "name='" + name + '\'' +
                ", users=" + users +
                ", trendingTopics=" + trendingTopics +
                '}';
    }
}
