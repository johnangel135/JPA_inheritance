package domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Duong Truong on 4/20/2018.
 */
@Entity
@Table(name = "CD")
@PrimaryKeyJoinColumn(name = "id")
public class CD extends Product{
    private String artist;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
