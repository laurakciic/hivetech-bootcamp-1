import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Sale sale1 = new Sale("Luka", "Brod", 4.0);
        Sale sale2 = new Sale("Laura", "Osijek", 6.0);
        Sale sale3 = new Sale("Ivan", "Bebrina", 2.0);
        Sale sale4 = new Sale("Hana", "Brod", 6.0);
        Sale sale5 = new Sale("Ivona", "Osijek", 6.0);

        List<Sale> sales = new ArrayList<>(Arrays.asList(sale1, sale2, sale3, sale4, sale5));

        StreamProcessor processor = new StreamProcessor();
        System.out.println("Total sales: " + processor.getTotalSales(sales));
        System.out.println("Sales by region: " + processor.getSalesByRegion(sales, "Brod"));
        System.out.println("Top 3 sales people: " + processor.getTopSalesPeople(sales, 3));
        System.out.println("Average sale: " + processor.getAverageSale(sales));
    }
}
