package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式（Observer Pattern）是一种行为设计模式，
 * 它定义了一种一对多的依赖关系，让一个对象（主题或被观察者）的状态发生变化时，所有依赖于它的对象（观察者）都会得到通知并自动更新。
 * 这种模式通常用于处理对象之间的松耦合关系，其中一个对象的变化可以通知多个其他对象。
 *
 * 观察者模式的核心思想是主题（被观察者）和观察者之间的解耦，主题不需要知道观察者的具体实现，只需维护一个观察者列表，通知它们即可。观察者模式在实际应用中有广泛的用途，帮助构建松耦合的系统，提高代码的可维护性和可扩展性。
 */

// 主题（被观察者）
class EventSource {
    private List<EventListener> listeners = new ArrayList<>();

    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    public void fireEvent(String event) {
        for (EventListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}

// 观察者
interface EventListener {
    void onEvent(String event);
}

class TaccNotice implements EventListener{

    @Override
    public void onEvent(String event) {
        System.out.println("通知tacc："+ event);
    }
}

class APaasNotice implements EventListener{

    @Override
    public void onEvent(String event) {
        System.out.println("通知apaas："+ event);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        EventSource source = new EventSource();

        // 创建观察者并订阅事件
        EventListener aPaasNotice = new APaasNotice();
        EventListener taccNotice = new TaccNotice();

        source.addListener(aPaasNotice);
        source.addListener(taccNotice);

        // 发送事件通知观察者
        source.fireEvent("Event1");
        source.fireEvent("Event2");
    }
}
