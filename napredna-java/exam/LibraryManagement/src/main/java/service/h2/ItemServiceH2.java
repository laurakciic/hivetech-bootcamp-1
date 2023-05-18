package service.h2;

import model.abstracts.LibraryItem;
import service.ItemService;
import utils.exceptions.NotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ItemServiceH2<T> implements ItemService<T> {
    private Map<UUID, T> items;

    @Override
    public void addItem(UUID id, T item) {
        items.put(id, item);
    }

    @Override
    public void removeItem(UUID id) {
        items.remove(id);
    }

    @Override
    public T getItem(UUID id) {
        return items.get(id);
    }

    @Override
    public LibraryItem findOldestItem(List<LibraryItem> items) throws NotFoundException {
        LibraryItem oldestItem = items.stream()
                .min(Comparator.comparing(LibraryItem::getPublication_year))
                .orElse(null);

        if (oldestItem != null) {
            return oldestItem;
        }

        throw new NotFoundException();
    }

    @Override
    public List<LibraryItem> findItemsByKeyword(List<LibraryItem> items, String keyword) {
        return items.stream()
                .filter(item -> item.getTitle().contains(keyword))
                .toList();
    }
}
