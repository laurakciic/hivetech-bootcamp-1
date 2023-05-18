package service;

import model.abstracts.LibraryItem;
import utils.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface ItemService<T> {

    void addItem(UUID id, T item);

    void removeItem(UUID id);

    T getItem(UUID id);

    LibraryItem findOldestItem(List<LibraryItem> items) throws NotFoundException;

    List<LibraryItem> findItemsByKeyword(List<LibraryItem> items, String keyword);
}
