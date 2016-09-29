package miaopp.observer;

/**
 * Created by miaoping on 16/9/13.
 */
public enum Status {
    NOT_SEND(0, "未发送"),
    SEND(1, "已发送"),
    DELETE(2, "已删除");

    int status;
    String statusName;

    Status(int status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public static Status getStatus(int status) {
        for (Status sta : Status.values()) {
            if (status == sta.status) {
                return sta;
            }
        }
        return null;
    }
}
