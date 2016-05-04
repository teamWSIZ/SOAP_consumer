package mypackage;
import org.springframework.stereotype.Component;


@Component
public class BeanA {
    int u;
    public BeanA() {
        u = 12;
    }

    public int getU() {
        return u;
    }
}
