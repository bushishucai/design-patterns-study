package observer;

import java.util.ArrayList;
import java.util.List;


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

public class ObserverPatternExample01 {
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
