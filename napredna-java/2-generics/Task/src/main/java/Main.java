public class Main {

    public static void main(String[] args) {

        GenericList<Integer> integerList = new GenericList<>();

        for(int i = 0; i < 5; i++) {
            integerList.add(i);
        }

        System.out.println("Size of the list: " + integerList.size());

        System.out.println("First element: " + integerList.get(0));
        System.out.println("Last element: " + integerList.get(integerList.size() - 1));

        integerList.remove(3);

        System.out.println("Size of the list after removing an element: " + integerList.size());

        System.out.println("Contents of the integer list: ");
        integerList.objects.forEach(object -> System.out.println(object.toString()));

        GenericList<String> stringList = new GenericList<>();
        stringList.add("object1");
        stringList.add("object2");
        stringList.add("object3");

        System.out.println("Contents of the string list: ");
        stringList.objects.forEach(System.out::println);
    }
}
