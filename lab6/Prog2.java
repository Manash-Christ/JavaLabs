import java.util.ArrayList;
import java.util.List;

class Item {
    int iID;
    String iName;
    int quant;

    public Item(int iID, String iName, int quant) {
        this.iID = iID;
        this.iName = iName;
        this.quant = quant;
    }
}

class Order {
    int oID;
    List<Item> items;

    public Order(int oID, List<Item> items) {
        this.oID = oID;
        this.items = items;
    }
}

class InsufficientInventoryException extends Exception {
    public InsufficientInventoryException(String message) {
        super(message);
    }
}

class OrderCancellationException extends Exception {
    public OrderCancellationException(String message) {
        super(message);
    }
}

class EnhancedOrderFulfillmentSystem {
    private List<Order> orders = new ArrayList<>();
    private List<Thread> workerThreads = new ArrayList<>();
    private boolean processingStarted = false;

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void startProcessing() {
        if (processingStarted) {
            throw new IllegalStateException("Processing has already started.");
        }

        for (Order order : orders) {
            Thread workerThread = new Thread(() -> {
                try {
                    processOrder(order);
                } catch (InsufficientInventoryException | OrderCancellationException e) {
                    System.out.println(e.getMessage());
                }
            });

            workerThreads.add(workerThread);
            workerThread.start();
        }

        processingStarted = true;
    }

    public void waitForCompletion() {
        for (Thread thread : workerThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void processOrder(Order order) throws InsufficientInventoryException, OrderCancellationException {
        // Simulate order processing
        for (Item item : order.items) {
            if (!checkInventoryAvailability(item)) {
                throw new InsufficientInventoryException("Insufficient inventory for item: " + item.iName);
            }
            updateInventory(item);
        }

        // Simulate successful order processing
        System.out.println("Order " + order.oID + " processed successfully.");
    }

    private synchronized void updateInventory(Item item) {
        // Simulate updating inventory
        System.out.println("Inventory updated for item: " + item.iName);
    }

    private synchronized boolean checkInventoryAvailability(Item item) {
        // Simulate checking inventory availability
        return item.quant > 0;
    }

    public synchronized void trackOrderStatus(int oID) {
        // Simulate tracking order status
        System.out.println("Tracking order status for order: " + oID);
    }
}

public class Prog2 {
    public static void main(String[] args) {
        EnhancedOrderFulfillmentSystem orderFulfillmentSystem = new EnhancedOrderFulfillmentSystem();

        List<Item> items1 = List.of(new Item(1, "ItemA", 2), new Item(2, "ItemB", 3));
        Order order1 = new Order(101, items1);

        List<Item> items2 = List.of(new Item(3, "ItemC", 1), new Item(4, "ItemD", 4));
        Order order2 = new Order(102, items2);

        orderFulfillmentSystem.placeOrder(order1);
        orderFulfillmentSystem.placeOrder(order2);

        orderFulfillmentSystem.startProcessing();
        orderFulfillmentSystem.waitForCompletion();

        orderFulfillmentSystem.trackOrderStatus(101);
        orderFulfillmentSystem.trackOrderStatus(102);
    }
}
