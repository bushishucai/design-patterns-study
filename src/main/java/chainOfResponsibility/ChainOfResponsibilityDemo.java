package chainOfResponsibility;

// 定义抽象处理者
abstract class Approver {
    protected Approver nextApprover;
    protected String name;

    public Approver(String name) {
        this.name = name;
    }

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void processRequest(PurchaseRequest request);
}

// 具体处理者：主管
class Supervisor extends Approver {
    public Supervisor(String name) {
        super(name);
    }

    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() <= 1000) {
            System.out.println("Request approved by " + name + " for amount $" + request.getAmount());
        } else if (nextApprover != null) {
            nextApprover.processRequest(request);
        } else {
            System.out.println("Request cannot be approved. No more approvers.");
        }
    }
}

// 具体处理者：经理
class Manager extends Approver {
    public Manager(String name) {
        super(name);
    }

    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() <= 5000) {
            System.out.println("Request approved by " + name + " for amount $" + request.getAmount());
        } else if (nextApprover != null) {
            nextApprover.processRequest(request);
        } else {
            System.out.println("Request cannot be approved. No more approvers.");
        }
    }
}

// 具体处理者：总经理
class GeneralManager extends Approver {
    public GeneralManager(String name) {
        super(name);
    }

    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() <= 10000) {
            System.out.println("Request approved by " + name + " for amount $" + request.getAmount());
        } else {
            System.out.println("Request cannot be approved. Contact CEO.");
        }
    }
}

// 购买请求类
class PurchaseRequest {
    private int amount;

    public PurchaseRequest(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}

public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        Approver supervisor = new Supervisor("Supervisor");
        Approver manager = new Manager("Manager");
        Approver generalManager = new GeneralManager("General Manager");

        supervisor.setNextApprover(manager);
        manager.setNextApprover(generalManager);

        PurchaseRequest request1 = new PurchaseRequest(800);
        PurchaseRequest request2 = new PurchaseRequest(4500);
        PurchaseRequest request3 = new PurchaseRequest(8000);
        PurchaseRequest request4 = new PurchaseRequest(12000);

        supervisor.processRequest(request1);
        supervisor.processRequest(request2);
        supervisor.processRequest(request3);
        supervisor.processRequest(request4);
    }
}

