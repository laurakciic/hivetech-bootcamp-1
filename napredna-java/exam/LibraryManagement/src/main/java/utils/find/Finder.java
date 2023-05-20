package utils.find;

import model.abstracts.LibraryItem;
import utils.exceptions.NotFoundException;

import java.util.List;

public interface Finder {

    LibraryItem findOldestItem(List<LibraryItem> items) throws NotFoundException;

    List<LibraryItem> findItemsByKeyword(List<LibraryItem> items, String keyword);
}
