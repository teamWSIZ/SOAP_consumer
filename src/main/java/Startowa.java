import mypackage.UsdClient;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Startowa {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        UsdClient client = ctx.getBean(UsdClient.class);
        client.getCountryInfo();

        ctx.close();
    }
}
