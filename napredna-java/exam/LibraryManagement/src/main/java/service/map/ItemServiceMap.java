package service.map;

import model.abstracts.LibraryItem;
import service.ItemService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class ItemServiceMap implements ItemService {
    private Map<UUID, LibraryItem> items;

    public ItemServiceMap() {
        this.items = new HashMap<>();
    }

    @Override
    public void addItem(UUID id, LibraryItem item) {
        items.put(id, item);
    }

    @Override
    public void removeItem(UUID id) {
        items.remove(id);
    }

    @Override
    public Optional<LibraryItem> getItemById(UUID id) {
        return Optional.of(items.get(id));
    }
}
