import model.*;
import model.enums.ItemType;
import model.enums.Rating;
import service.ItemService;
import service.PersonService;
import service.map.ItemServiceMap;
import service.map.PersonServiceMap;

import java.time.Year;
import java.util.UUID;

public class DataLoader {

    private static final ItemService itemService = new ItemServiceMap();
    private static final PersonService personService = new PersonServiceMap();

    public static void main(String[] args) {
        createLibraryItems();
    }

    private static void createLibraryItems() {
        Author author = new Author();
        author.setId(UUID.randomUUID());
        author.setFirst_name("Mirko");
        author.setLast_name("Filipovic");

        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle("Top 100");
        book.setAuthor(author);
        book.setItemType(ItemType.BOOK);
        book.setPages(127);
        book.setGenre("Autobiography");
        book.setIsbn("31229");
        book.setPublication_year(Year.now());

        Director director = new Director();
        director.setId(UUID.randomUUID());
        director.setFirst_name("Ivan");
        director.setLast_name("Direktorov");

        DVD dvd = new DVD();
        dvd.setId(UUID.randomUUID());
        dvd.setItemType(ItemType.DVD);
        dvd.setAuthor(author);
        dvd.setTitle("Cro cop");
        dvd.setDirector(director);
        dvd.setRating(Rating.G);
        dvd.setDuration_minutes(45);
        dvd.setPublication_year(Year.now());

        Publisher publisher = new Publisher();
        publisher.setId(UUID.randomUUID());
        publisher.setFirst_name("Marko");
        publisher.setLast_name("Markovic");

        Magazine magazine = new Magazine();
        magazine.setId(UUID.randomUUID());
        magazine.setAuthor(author);
        magazine.setPublisher(publisher);
        magazine.setTitle("Top 100 Magazine");
        magazine.setPublication_year(Year.now());
        magazine.setIssue_number(12);
        magazine.setItemType(ItemType.MAGAZINE);

        personService.addPerson(author.getId(), author);
        personService.addPerson(publisher.getId(), publisher);
        personService.addPerson(director.getId(), director);

        itemService.addItem(book.getId(), book);
        itemService.addItem(dvd.getId(), dvd);
        itemService.addItem(magazine.getId(), magazine);

        System.out.println(itemService.getItemById(book.getId()));
    }
}
