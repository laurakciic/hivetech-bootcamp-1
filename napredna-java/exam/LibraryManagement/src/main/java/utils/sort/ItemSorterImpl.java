package utils.sort;

import model.abstracts.LibraryItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ItemSorterImpl implements ItemSorter {
    @Override
    public List<LibraryItem> sortItems(List<LibraryItem> items, Comparator<LibraryItem> comparator) {
        List<LibraryItem> itemsCopy = new ArrayList<>(items);
        itemsCopy.sort(comparator);
        return itemsCopy;
    }
}
