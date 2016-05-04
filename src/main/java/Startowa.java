import MyPackage.BeanA;
import MyPackage.BeanB;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by pm on 11/12/15.
 */


public class Startowa {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
        BeanB beanB = ctx.getBean(BeanB.class);
        beanB.useResources();
        ctx.close();
    }
}
