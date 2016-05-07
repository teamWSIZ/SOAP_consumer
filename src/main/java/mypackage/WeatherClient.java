package mypackage;

import hello.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.text.SimpleDateFormat;

public class WeatherClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(WeatherClient.class);

    public GetCityForecastByZIPResponse getCityForecastByZip(String zipCode) {

        GetCityForecastByZIP request = new GetCityForecastByZIP();
        request.setZIP(zipCode);

        GetCityForecastByZIPResponse response = (GetCityForecastByZIPResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://wsf.cdyne.com/WeatherWS/Weather.asmx",
                        request,
                        new SoapActionCallback("http://ws.cdyne.com/WeatherWS/GetCityForecastByZIP"));

        return response;
    }

    public void myRequest() {
        //set up custom request;
        //get proper response
        //parse result
        //  -- what if error?
        //  -- what if timeout?
        GetCityWeatherByZIP req = new GetCityWeatherByZIP();
        req.setZIP("10001");
        GetCityWeatherByZIPResponse res = (GetCityWeatherByZIPResponse)
                getWebServiceTemplate().marshalSendAndReceive(
                    "http://wsf.cdyne.com/WeatherWS/Weather.asmx",
                    req,
                    new SoapActionCallback("http://ws.cdyne.com/WeatherWS/GetCityWeatherByZIP")
                );
        WeatherReturn wea = res.getGetCityWeatherByZIPResult();
        System.out.println(wea.getCity());
        System.out.println("Wind:" + wea.getWind());
        System.out.println("Temp:" + wea.getTemperature());
        System.out.println("Vis:" + wea.getVisibility());
        System.out.println("Pressure:" + wea.getPressure());
        System.out.println(wea.getRemarks());
    }

    public void printResponse(GetCityForecastByZIPResponse response) {
        ForecastReturn forecastReturn = response.getGetCityForecastByZIPResult();

        if (forecastReturn.isSuccess()) {
            log.info("Forecast for " + forecastReturn.getCity() + ", " + forecastReturn.getState());

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            for (Forecast forecast : forecastReturn.getForecastResult().getForecast()) {

                Temp temperature = forecast.getTemperatures();

                log.info(String.format("%s %s %s°-%s°", format.format(forecast.getDate().toGregorianCalendar().getTime()),
                        forecast.getDesciption(), temperature.getMorningLow(), temperature.getDaytimeHigh()));
                log.info("");
            }
        } else {
            log.info("No forecast received");
        }
    }

}
