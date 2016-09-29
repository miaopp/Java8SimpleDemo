package miaopp.extend;

/**
 * Created by miaoping on 16/9/6.
 */
public enum BallType {
    basketBall("basketball", "篮球"),
    footBall("football", "足球"),
    pingPangBall("ping pang ball", "乒乓球");

    String name;
    String nameZh;

    BallType(String name, String nameZh) {
        this.name = name;
        this.nameZh = nameZh;
    }

    public String getName() {
    return name;
}

    public String getNameZh() {
        return nameZh;
    }
}
