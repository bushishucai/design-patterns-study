package templateMethod;

/**
 * 在这个示例中，CaffeineBeverage 是一个抽象类，它包含了制备咖啡因饮料的模板方法 prepareRecipe()，
 * 该方法定义了一系列具体步骤：烧水、冲泡、倒入杯子和添加调料。其中 brew() 和 addCondiments() 是抽象方法，由子类实现以定制步骤。
 *
 * Coffee 和 Tea 是具体的子类，分别实现了 brew() 和 addCondiments() 方法。
 * 通过创建不同的子类，我们可以定制不同种类的咖啡因饮料，但不需要改变模板方法的结构。
 *
 * 在 TemplateMethodDemo 主类中，我们创建了咖啡和茶的实例，并调用它们的 prepareRecipe() 方法来制备咖啡和茶。
 * 这个示例演示了模板方法模式的核心思想，即定义算法的骨架，将一些具体步骤延迟到子类中实现，以实现定制化的行为。
 */

// 抽象类：咖啡因饮料
abstract class CaffeineBeverage {
    // 模板方法，定义了算法的骨架
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // 具体步骤：烧水
    void boilWater() {
        System.out.println("Boiling water");
    }

    // 具体步骤：冲泡
    abstract void brew();

    // 具体步骤：倒入杯子
    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // 具体步骤：添加调料
    abstract void addCondiments();
}

// 具体类：咖啡
class Coffee extends CaffeineBeverage {
    // 实现冲泡咖啡的步骤
    void brew() {
        System.out.println("Dripping coffee through filter");
    }

    // 实现添加咖啡调料的步骤
    void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

// 具体类：茶
class Tea extends CaffeineBeverage {
    // 实现冲泡茶的步骤
    void brew() {
        System.out.println("Steeping the tea");
    }

    // 实现添加柠檬的步骤
    void addCondiments() {
        System.out.println("Adding lemon");
    }
}

public class TemplateMethodDemo {
    public static void main(String[] args) {
        CaffeineBeverage coffee = new Coffee();
        CaffeineBeverage tea = new Tea();

        System.out.println("Making coffee:");
        coffee.prepareRecipe();

        System.out.println("\nMaking tea:");
        tea.prepareRecipe();
    }
}

