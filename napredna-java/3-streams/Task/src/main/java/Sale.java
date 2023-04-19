import java.math.BigDecimal;

public class Sale {
    private String salePerson;
    private String region;
    private Double amount;

    public Sale(String salePerson, String region, Double amount) {
        this.salePerson = salePerson;
        this.region = region;
        this.amount = amount;
    }

    public String getSalePerson() {
        return salePerson;
    }

    public void setSalePerson(String salePerson) {
        this.salePerson = salePerson;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
