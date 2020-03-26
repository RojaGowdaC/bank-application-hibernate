package hibernate.exception;
public class LowBalance extends RuntimeException {
    public LowBalance(String msg) {
        super(msg);
    }
}
