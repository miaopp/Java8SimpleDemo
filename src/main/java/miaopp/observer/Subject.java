package miaopp.observer;

/**
 * Created by miaoping on 16/9/13.
 */
public interface Subject {

    /**
     * 消息订阅
     * @param observer
     */
    public void subscribe(Observer observer);

    /**
     * 广播消息
     */
    public void publish();

    /**
     * 退订某个服务
     * @param observer
     */
    public void unSubscribe(Observer observer);

    /**
     * 退订全部服务
     */
    public void unSubscribeAllServers();

}
