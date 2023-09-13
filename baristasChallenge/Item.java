public class Item {
    private String name;
    private double price;

    // CONSTRUCTORS
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // GETTERS AND SETTERS
    public String getItemName() {
        return name;
    }

    public void setItemName(String name) {
        this.name = name;
    }

    public double getItemPrice() {
        return price;
    }

    public void setItemPrice(double price) {
        this.price = price;
    }
}