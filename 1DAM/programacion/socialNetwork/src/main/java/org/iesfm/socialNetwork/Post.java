package org.iesfm.socialNetwork;

import org.iesfm.socialNetwork.comparators.WallComparatorByDate;

import java.util.Objects;
import java.util.Set;

public class Post {
    private String author;
    private String message;
    private String date;
    private Set<String> tags;

    public Post(String author, String message, String date, Set<String> tags) {
        this.author = author;
        this.message = message;
        this.date = date;
        this.tags = tags;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(author, post.author) && Objects.equals(message, post.message) && Objects.equals(date, post.date) && Objects.equals(tags, post.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, message, date, tags);
    }

    @Override
    public String toString() {
        return "Post{" +
                "author='" + author + '\'' +
                ", message='" + message + '\'' +
                ", date='" + date + '\'' +
                ", tags=" + tags +
                '}';
    }
}
