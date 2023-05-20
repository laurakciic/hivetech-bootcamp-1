package utils.find;

import model.abstracts.LibraryItem;
import utils.exceptions.NotFoundException;

import java.util.Comparator;
import java.util.List;

public class FinderImpl implements Finder {

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
