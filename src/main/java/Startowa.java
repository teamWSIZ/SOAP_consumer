import mypackage.BeanB;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Startowa {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        BeanB beanB = ctx.getBean(BeanB.class);
        beanB.useResources();
        ctx.close();
    }
}
