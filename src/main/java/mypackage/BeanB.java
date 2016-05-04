package mypackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Ten bean potrzebuje BeanA, więc BeanA zostanie stworzony.
 */

@Component
public class BeanB {
    @Autowired
    BeanA beanA;

    public void useResources() {
        System.out.println(beanA.getU());
    }
}
