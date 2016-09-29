package miaopp.observer;

/**
 * Created by miaoping on 16/9/13.
 */
public class Client {

    public static void main(String args[]) {
        //定义一个主题
        ConcreateSubject subject = new ConcreateSubject("com.sankuai.sendMessage");
        //定义两个观察者
        ConcreateObserver sendObserver = new ConcreateObserver("send_message", subject);
        ConcreateObserver reSendMessage = new ConcreateObserver("re_send_message", subject);
        //更改消息状态
        subject.changed(Status.SEND.status);
    }
}
