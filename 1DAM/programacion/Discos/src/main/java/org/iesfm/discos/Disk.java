package org.iesfm.discos;

import java.util.Objects;
import java.util.Set;

public class Disk implements Comparable<Disk>{
    private String title;
    private String artist;
    private Set<String> genres;

    public Disk(String title, String artist, Set<String> genres) {
        this.title = title;
        this.artist = artist;
        this.genres = genres;
    }

    @Override
    public int compareTo(Disk disk) {
        return this.title.compareTo(disk.getTitle());
    }

    public boolean hasGenre (String genre){
        boolean found = false;
        if (genres.contains(genre)){
            found = true;
        }
        return found;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disk disk = (Disk) o;
        return Objects.equals(title, disk.title) && Objects.equals(artist, disk.artist) && Objects.equals(genres, disk.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, genres);
    }

    @Override
    public String toString() {
        return "Disk{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genres=" + genres +
                '}';
    }
}
