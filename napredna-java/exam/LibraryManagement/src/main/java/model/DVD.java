package model;

import model.abstracts.LibraryItem;
import model.enums.Rating;

public class DVD extends LibraryItem {

    private int duration_minutes;

    private Director director;

    private Rating rating;

    public int getDuration_minutes() {
        return duration_minutes;
    }

    public void setDuration_minutes(int duration_minutes) {
        this.duration_minutes = duration_minutes;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
