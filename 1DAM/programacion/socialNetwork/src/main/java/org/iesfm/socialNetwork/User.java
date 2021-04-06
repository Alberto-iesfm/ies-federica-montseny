package org.iesfm.socialNetwork;

import java.util.*;

public class User {
    private String userName;
    private Set<Post> wall;

    public User(String userName, Set<Post> wall) {
        this.userName = userName;
        this.wall = wall;
    }

    public List<Post> getAuthorPostInWall(String userName) {
        List<Post> authorPosts = new LinkedList<>();
        for (Post post:wall){
            if (post.getAuthor().equals(userName)){
                authorPosts.add(post);
            }
        }
        return authorPosts;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Post> getWall() {
        return wall;
    }

    public void setWall(Set<Post> wall) {
        this.wall = wall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(wall, user.wall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, wall);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", wall=" + wall +
                '}';
    }
}
