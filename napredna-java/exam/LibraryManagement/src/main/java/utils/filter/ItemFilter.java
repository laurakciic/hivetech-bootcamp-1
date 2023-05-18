package utils.filter;

import model.abstracts.LibraryItem;

import java.util.List;
import java.util.function.Predicate;

public interface ItemFilter {
    List<LibraryItem> filterItems(List<LibraryItem> items, Predicate<LibraryItem> filter);
}
