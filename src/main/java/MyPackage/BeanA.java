package MyPackage;
import org.springframework.stereotype.Component;

/**
 * Created by pm on 11/12/15.
 */

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
