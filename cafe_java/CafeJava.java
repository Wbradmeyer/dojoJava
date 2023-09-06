public class CafeJava {
    public static void main(String[] args) {
        // messages
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";

        // menu items
        double mochaPrice = 3.5;
        double dripCoffeePrice = 2.5;
        double lattePrice = 4.0;
        double cappuccinoPrice = 4.5;

        // customers
        String customer1 = "Cindihuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        // order status
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;

        // customer interactions
        System.out.println(generalGreeting + customer1);
        System.out.println(customer1 + pendingMessage);

        System.out.println(generalGreeting + customer4);
        if(isReadyOrder4) {
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + cappuccinoPrice);
        } else {
            System.out.println(customer4 + pendingMessage);
        }

        System.out.println(generalGreeting + customer2);
        System.out.println(displayTotalMessage + lattePrice * 2);
        if(isReadyOrder3) {
            System.out.println(customer2 + readyMessage);
        } else {
            System.out.println(customer2 + pendingMessage);
        }

        System.out.println(generalGreeting + customer3);
        System.out.println(customer3 + readyMessage);
        System.out.println(displayTotalMessage + (lattePrice - dripCoffeePrice));
    }
}