import java.util.ArrayList;

public class Order {
    private String name;
    private boolean ready = false;
    private ArrayList<Item> items; 

    // CONSTRUCTORS
    public Order() {
        this("Guest");
    }

    public Order(String name) {
        this.name = name;
        this.items = new ArrayList<Item>();
        this.ready = false;
    }

    // ORDER METHODS
    public void addItem(Item oneItem) {
        this.items.add(oneItem);
    }

    public String getStatusMessage() {
        if(this.isOrderReady()) {
            return "Your order is ready.";
        } else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    public String getOrderTotal() {
        double total = 0;
        for(Item item : items) {
            total += item.getItemPrice();
        }
        return String.format("$%.2f", total);
    }

    public String display() {
        String outputString = "";
        outputString += String.format("Customer Name: %s\n", this.name);
        for(Item item : items) {
            outputString += String.format("%s - $%.2f\n", item.getItemName(), item.getItemPrice());
        }
        outputString += String.format("Total: %s\n", this.getOrderTotal());
        return outputString;
    }

    // GETTERS AND SETTERS
    public String getOrderName() {
        return name;
    }
    
    public void setOrderName(String name) {
        this.name = name;
    }

    public boolean isOrderReady() {
        return ready;
    }
    
    public void setOrderReady() {
        this.ready = true;
    }

    public ArrayList<Item> getItemList() {
        return items;
    }
}