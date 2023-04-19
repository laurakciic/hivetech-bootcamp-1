import java.util.ArrayList;
import java.util.List;

public class GenericList<T> {

    List<T> objects = new ArrayList<>();

    public void add(T item) {
        objects.add(item);
    }

    public T get(int index) {
        return objects.get(index);
    }

    public void remove(int index) {
        objects.remove(index);
    }

    public int size() {
        return objects.size();
    }

    public String toString() {
        return objects.toString();
    }
}
