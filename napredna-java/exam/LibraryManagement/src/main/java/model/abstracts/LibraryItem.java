package model.abstracts;

import model.Author;
import model.enums.ItemType;

import java.time.Year;
import java.util.UUID;

public abstract class LibraryItem {

    private UUID id;
    private String title;
    private Author author;
    private Year publication_year;
    private ItemType itemType;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Year getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(Year publication_year) {
        this.publication_year = publication_year;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
}
