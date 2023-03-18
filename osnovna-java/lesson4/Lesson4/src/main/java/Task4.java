import java.util.*;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> booksMap = new HashMap<>();
        String book;
        String author;

        System.out.println("Enter your favourite books and authors. Enter 'stop' to finish.");

        do {
            System.out.print("Book title: ");
            book = scanner.next();
            if (Objects.equals(book, "stop")) break;

            System.out.print("Author name: ");
            author = scanner.next();
            if (Objects.equals(author, "stop")) break;

            booksMap.put(book, author);
        } while(true);

        // converting Map into a Set
        Set<String> keySet = new LinkedHashSet<>(booksMap.keySet());
        Set<String> valueSet = new LinkedHashSet<>(booksMap.values());

        // converting keySet and valueSet back into a Map
        if(keySet.size() != valueSet.size()) throw new IllegalArgumentException("Sets are of different sizes");

        Iterator<String> keyIterator = keySet.iterator();
        Iterator<String> valueIterator = valueSet.iterator();

        Map<String, String> map = new HashMap<>();
        while (keyIterator.hasNext() && valueIterator.hasNext()) {
            String key = keyIterator.next();
            String value = valueIterator.next();
            map.put(key, value);
        }

        // converting Map into a List
        List<Map.Entry<String, String>> list = new LinkedList<>(map.entrySet());

        list.sort(new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (Map.Entry<String, String> entry : list) {
            System.out.println(entry.getKey() + " by " + entry.getValue());
        }
    }
}
