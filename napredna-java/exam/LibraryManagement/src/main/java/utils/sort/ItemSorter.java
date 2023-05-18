package utils.sort;

import model.abstracts.LibraryItem;

import java.util.Comparator;
import java.util.List;

public interface ItemSorter {
    List<LibraryItem> sortItems(List<LibraryItem> items, Comparator<LibraryItem> comparator);
}
