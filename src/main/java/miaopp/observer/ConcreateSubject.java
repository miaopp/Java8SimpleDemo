package miaopp.observer;

/**
 * Created by miaoping on 16/9/13.
 * 具体的消息
 */
public class ConcreateSubject extends AbstractSubject {

    //消息状态
    private int status;

    //消息主题
    private String subject;

    public ConcreateSubject(String subject) {
        super();
        status = Status.NOT_SEND.getStatus();
        this.subject = subject;
    }

    //消息状态变更
    public void changed(int newStatus) {
        this.status = newStatus;
        publish();
    }

    public String getSubject() {
        return subject;
    }

    public int getStatus() {
        return status;
    }
}
