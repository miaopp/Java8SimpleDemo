package miaopp.extend;

/**
 * Created by miaoping on 16/9/6.
 */
public class User {
    private FootBall footBall;
    private BasketBall basketBall;
    private PingPangBall pingPangBall;

    public User() {
        this.footBall = new FootBall();
        this.basketBall = new BasketBall();
        this.pingPangBall = new PingPangBall();
    }

    public User(FootBall footBall, BasketBall basketBall, PingPangBall pingPangBall) {
        this.footBall = footBall;
        this.basketBall = basketBall;
        this.pingPangBall = pingPangBall;
    }

    public FootBall getFootBall() {
        return footBall;
    }

    public void setFootBall(FootBall footBall) {
        this.footBall = footBall;
    }

    public BasketBall getBasketBall() {
        return basketBall;
    }

    public void setBasketBall(BasketBall basketBall) {
        this.basketBall = basketBall;
    }

    public PingPangBall getPingPangBall() {
        return pingPangBall;
    }

    public void setPingPangBall(PingPangBall pingPangBall) {
        this.pingPangBall = pingPangBall;
    }
}
