package utils.filter;

import model.abstracts.LibraryItem;

import java.util.List;
import java.util.function.Predicate;

public interface Filter {
    List<LibraryItem> filterItems(List<LibraryItem> items, Predicate<LibraryItem> filter);
}
