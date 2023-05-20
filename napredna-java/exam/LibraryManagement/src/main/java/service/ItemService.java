package service;

import model.abstracts.LibraryItem;

import java.util.Optional;
import java.util.UUID;

public interface ItemService {

    void addItem(UUID id, LibraryItem item);

    void removeItem(UUID id);

    Optional<LibraryItem> getItemById(UUID id);
}
