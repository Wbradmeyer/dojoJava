import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {

        // ORDERS
        Order first = new Order();
        Order second = new Order();
        Order third = new Order("Becky");
        Order fourth = new Order("Justin");
        Order fifth = new Order("Susie");

        // MENU ITEMS
        Item item1 = new Item("mocha", 3.00);
        Item item2 = new Item("latte", 4.50);
        Item item3 = new Item("drip coffee", 2.50);
        Item item4 = new Item("cappuccino", 3.50);
        
        // ADDING ITEMS TO ORDERS
        first.addItem(item2);
        first.addItem(item3);
        second.addItem(item4);
        second.addItem(item1);
        third.addItem(item1);
        third.addItem(item2);
        fourth.addItem(item3);
        fourth.addItem(item4);
        fifth.addItem(item2);
        fifth.addItem(item1);

        first.setOrderReady();
        third.setOrderReady();

        // CHECK ORDER STATUS
        System.out.println(first.getStatusMessage());
        System.out.println(second.getStatusMessage());
        System.out.println(third.getStatusMessage());
        System.out.println(fourth.getStatusMessage());
        System.out.println(fifth.getStatusMessage());
        System.out.println("\n");

        // CHECK TOTALS
        System.out.println(first.getOrderTotal());
        System.out.println(second.getOrderTotal());
        System.out.println(third.getOrderTotal());
        System.out.println(fourth.getOrderTotal());
        System.out.println(fifth.getOrderTotal());
        System.out.println("\n");

        // DISPLAY METHOD
        System.out.println(first.display());
        System.out.println(second.display());
        System.out.println(third.display());
        System.out.println(fourth.display());
        System.out.println(fifth.display());
    }
}