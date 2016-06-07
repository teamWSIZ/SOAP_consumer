import mypackage.MyWsdlClient;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Startowa {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        MyWsdlClient client = ctx.getBean(MyWsdlClient.class);
        client.getCountryFromSoap();
        client.getStudentFromSoap();


        ctx.close();
    }
}
