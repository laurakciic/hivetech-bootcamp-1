package model;

import model.abstracts.LibraryItem;
import model.abstracts.Person;
import model.enums.Rating;

public class DVD extends LibraryItem {

    private int duration_minutes;

    private Person director;

    private Rating rating;

    public int getDuration_minutes() {
        return duration_minutes;
    }

    public void setDuration_minutes(int duration_minutes) {
        this.duration_minutes = duration_minutes;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
