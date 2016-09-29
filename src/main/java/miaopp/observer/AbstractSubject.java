package miaopp.observer;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by miaoping on 16/9/13.
 */
public abstract class AbstractSubject implements Subject {

    //观察者List
    private List<Observer> observers;

    public AbstractSubject() {
        this.observers = Lists.newArrayList();
    }

    public void subscribe(Observer observer) {
        if (null == observer) {
            return;
        }
        observers.add(observer);
    }

    public void publish() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void unSubscribe(Observer observer) {
        System.out.println("unsubscribe...\n");
        observers.remove(observer);
    }

    public void unSubscribeAllServers() {
        observers.clear();
    }
}
