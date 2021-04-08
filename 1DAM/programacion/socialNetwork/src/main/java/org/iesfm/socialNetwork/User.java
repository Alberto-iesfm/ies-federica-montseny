package org.iesfm.socialNetwork;

import java.util.*;

/**
 * Clase para definir los usuarios de la red social. Esta compuesta por:
 *
 * userName: define el nombre del usuario en la red social (String).
 * wall: define el muro de posts del usuario (Set de Post, ordenados por su fecha (de mas reciente a menos reciente)).
 *
 * Metodos: getAuthorPostInWall.
 */
public class User {
    private String userName;
    private Set<Post> wall;

    public User(String userName, Set<Post> wall) {
        this.userName = userName;
        this.wall = wall;
    }

    /**
     * permite obtener los posts de un determinado autor en el muro del usuario.
     * @param userName: nombre del usuario del que se desean buscar los post de los que es el autor (String).
     * @return authorPosts: lista de post de los que el userName es autor (List de Post).
     */
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
