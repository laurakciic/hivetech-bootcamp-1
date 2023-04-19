import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamProcessor {

    public Double getTotalSales(List<Sale> sales) {
        return sales.stream()
                .mapToDouble(Sale::getAmount) // extract the amount from each Sale object and convert it to a Double
                .reduce(0.0, Double::sum); // add up all the Double values and return the final sum
                // initial value (0.0), second argument is the lambda expression which adds two Double values together
    }

    public List<String> getSalesByRegion(List<Sale> sales, String region) {
        return sales.stream()
                .filter(sale -> Objects.equals(sale.getRegion(), region))
                .map(Sale::getSalePerson)
                .collect(Collectors.toList());
    }

    public List<String> getTopSalesPeople(List<Sale> sales, int n) {
        return sales.stream()
                .sorted(Comparator.comparingDouble(Sale::getAmount).reversed())
                .limit(n)
                .map(Sale::getSalePerson)
                .collect(Collectors.toList());
    }

    public Double getAverageSale(List<Sale> sales) {
        return sales.stream()
                .mapToDouble(Sale::getAmount)
                .average()
                .orElse(Double.NaN);
    }
}
