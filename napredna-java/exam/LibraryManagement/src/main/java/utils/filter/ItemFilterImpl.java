package utils.filter;

import model.abstracts.LibraryItem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ItemFilterImpl implements ItemFilter {
    @Override
    public List<LibraryItem> filterItems(List<LibraryItem> items, Predicate<LibraryItem> filter) {
        List<LibraryItem> result = new ArrayList<>();

        for (LibraryItem item: items) {
            if (filter.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
