package Telegram.utils;

public class Tuple<X, Y> {
    public final X x;
    public final Y y;
    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }
    public Y get(X x){
        return y;
    }

    public X getDescription() {
        return x;
    }

    public Y getFile() {
        return y;
    }
}
