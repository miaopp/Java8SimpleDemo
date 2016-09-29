package miaopp.observer;

/**
 * Created by miaoping on 16/9/13.
 * 具体的观察者
 */
public class ConcreateObserver implements Observer {

    //观察者名字
    private String name;

    //订阅主题
    private Subject subject;

    public ConcreateObserver(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
        subject.subscribe(this);
    }

    //一般仅仅只是通知的时候可以换个名字,但是有业务操作的时候就建议用update
    public void update(Subject subject) {
        ConcreateSubject concreateSubject = (ConcreateSubject) subject;
        System.out.println("observerName = " + this.name + "\n" + concreateSubject.getSubject() + " changed...." + "\n" + "status = " + Status.getStatus(concreateSubject.getStatus()).getStatusName() + "\n");
    }

    @Override
    public String toString() {
        return "ConcreateObserver{" +
                "name='" + name + '\'' +
                ", subject=" + subject +
                '}';
    }
}
