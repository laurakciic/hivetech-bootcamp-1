package model;

import model.abstracts.LibraryItem;

public class Magazine extends LibraryItem {

    private int issue_number;

    private Publisher publisher;

    public int getIssue_number() {
        return issue_number;
    }

    public void setIssue_number(int issue_number) {
        this.issue_number = issue_number;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
