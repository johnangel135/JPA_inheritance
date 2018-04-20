package domain;

import javax.persistence.Embeddable;

/**
 * Created by Duong Truong on 4/20/2018.
 */
public class Book extends Product {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
