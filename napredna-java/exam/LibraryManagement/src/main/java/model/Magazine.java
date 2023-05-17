package model;

import model.abstracts.LibraryItem;
import model.abstracts.Person;

public class Magazine extends LibraryItem {

    private int issue_number;

    private Person publisher;

    public int getIssue_number() {
        return issue_number;
    }

    public void setIssue_number(int issue_number) {
        this.issue_number = issue_number;
    }

    public Person getPublisher() {
        return publisher;
    }

    public void setPublisher(Person publisher) {
        this.publisher = publisher;
    }
}
