package observer;

import java.util.ArrayList;
import java.util.List;

// 主题接口（被观察者）
interface OrderSubject {
    void registerObserver(OrderObserver observer);
    void removeObserver(OrderObserver observer);
    void notifyObservers(Order order);
}

// 观察者接口
interface OrderObserver {
    void update(Order order);
}

// 具体主题（具体被观察者）（订单）
class Order implements OrderSubject {
    private List<OrderObserver> observers;
    private int orderId;
    private String product;
    private int quantity;

    public Order(int orderId, String product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(OrderObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Order order) {
        for (OrderObserver observer : observers) {
            observer.update(order);
        }
    }

    public void placeOrder() {
        System.out.println("Order #" + orderId + " placed for " + product + " x" + quantity);
        notifyObservers(this);
    }

    public int getOrderId() {
        return orderId;
    }
}

// 具体观察者（库存管理系统）
class InventoryManagementSystem implements OrderObserver {
    @Override
    public void update(Order order) {
        System.out.println("Inventory updated for Order #" + order.getOrderId());
    }
}

// 具体观察者（邮件通知服务）
class EmailNotificationService implements OrderObserver {
    @Override
    public void update(Order order) {
        System.out.println("Email sent for Order #" + order.getOrderId());
    }
}

public class ObserverPatternExample03 {
    public static void main(String[] args) {
        Order order = new Order(123, "Laptop", 2);

        InventoryManagementSystem inventorySystem = new InventoryManagementSystem();
        EmailNotificationService emailService = new EmailNotificationService();

        // 注册观察者
        order.registerObserver(inventorySystem);
        order.registerObserver(emailService);

        // 用户下单
        order.placeOrder();
    }
}
