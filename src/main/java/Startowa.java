import mypackage.WeatherClient;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Startowa {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        WeatherClient client = ctx.getBean(WeatherClient.class);
//        client.printResponse(client.getCityForecastByZip("10001"));
        client.myRequest();

        ctx.close();
    }
}
