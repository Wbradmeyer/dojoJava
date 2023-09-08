import java.util.ArrayList;

public class CafeUtil {

    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        int i = 1;
        while (i <= numWeeks) {
            sum += i;
            i++;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double total = 0.0;
        for (int i = 0; i < prices.length; i++) {
            total += prices[i];
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.print(i + " ");
            System.out.println(menuItems.get(i));
        }
    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) {
            return false;
        } else {
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.printf("%d %s -- $%.2f \n", i, menuItems.get(i), prices.get(i));
            }
        }
        return true;
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String username = System.console().readLine();
        System.out.printf("Hello %s!", username);
        System.out.printf("There are %s people in front of you. \n", customers.size());
        customers.add(username);
        System.out.println(customers);
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        System.out.printf("%d - $%.2f \n", 1, price);
        double total = price;
        if (maxQuantity > 1) {
            price -= .50;
            for (int i = 2; i <= maxQuantity; i++) {
            total += price;
            System.out.printf("%d - $%.2f \n", i, total);
        }
        }
        System.out.println(" ");
    }

    public void addCustomers(ArrayList<String> manyCustomers) {
        System.out.println("Please enter customers:");
        String username = System.console().readLine();
        while (!username.equals("q")) {
            manyCustomers.add(username);
            username = System.console().readLine();
        }
        System.out.println(manyCustomers + "\n");
    }
}