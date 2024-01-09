import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

// Customer class with basic details
class Customer {
    String customerId;
    String name;
    // other customer details and interactions

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

// Product class with basic details
class Product {
    String productId;
    String name;
    // other product details and inventory management

    public Product(String productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}

// Order class with basic details
class Order {
    String orderId;
    // other order details and history

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}

public class AmazonCRMSystem {
    public static void main(String[] args) {
        // Using Java Collections for data storage
        ArrayList<Customer> customerList = new ArrayList<>();
        HashMap<String, Product> productMap = new HashMap<>();
        HashSet<Product> uniqueProductsSet = new HashSet<>();
        TreeSet<Customer> sortedCustomersSet = new TreeSet<>((c1, c2) -> c1.name.compareTo(c2.name));

        // Adding sample data
        Customer customer1 = new Customer("C1", "John Doe");
        Customer customer2 = new Customer("C2", "Jane Smith");

        Product product1 = new Product("P1", "Laptop");
        Product product2 = new Product("P2", "Smartphone");

        Order order1 = new Order("O1");
        Order order2 = new Order("O2");

        // Managing customers
        customerList.add(customer1);
        customerList.add(customer2);

        // Managing products
        productMap.put(product1.productId, product1);
        productMap.put(product2.productId, product2);

        uniqueProductsSet.add(product1);
        uniqueProductsSet.add(product2);

        // Managing orders
        // ...

        // Sorting customers
        sortedCustomersSet.addAll(customerList);

        // Accessing data
        System.out.println("Customer List: " + customerList.toString());
        System.out.println("Product Map: " + productMap);
        System.out.println("Unique Products Set: " + uniqueProductsSet);
        System.out.println("Sorted Customers Set: " + sortedCustomersSet);
    }
}
