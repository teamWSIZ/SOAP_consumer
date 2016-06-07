package mypackage;

import autogen.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class MyWsdlClient extends WebServiceGatewaySupport {


    public void myRequest() {
//        //set up custom request;
//        //get proper response
//        //parse result
//        //  -- what if error?
//        //  -- what if timeout?
//        GetCityWeatherByZIP req = new GetCityWeatherByZIP();
//        req.setZIP("10001");
//        GetCityWeatherByZIPResponse res = (GetCityWeatherByZIPResponse)
//                getWebServiceTemplate().marshalSendAndReceive(
//                    "http://wsf.cdyne.com/WeatherWS/Weather.asmx",
//                    req,
//                    new SoapActionCallback("http://ws.cdyne.com/WeatherWS/GetCityWeatherByZIP")
//                );
//        WeatherReturn wea = res.getGetCityWeatherByZIPResult();
//        System.out.println(wea.getCity());
//        System.out.println("Wind:" + wea.getWind());
//        System.out.println("Temp:" + wea.getTemperature());
//        System.out.println("Vis:" + wea.getVisibility());
//        System.out.println("Pressure:" + wea.getPressure());
//        System.out.println(wea.getRemarks());
    }

    public void myConvert() {
//        ConversionRate req = new ConversionRate();
//        req.setFromCurrency(usd.wsdl.Currency.EUR);
//        req.setFromCurrency(usd.wsdl.Currency.USD);
//        ConversionRateResponse res = (ConversionRateResponse)
//                getWebServiceTemplate().marshalSendAndReceive(
//                        "http://www.webservicex.com/CurrencyConvertor.asmx",
//                        req,
//                        new SoapActionCallback("http://www.webserviceX.NET/ConversionRate")
//                );
//        double rate = res.getConversionRateResult();
//        System.out.println("rate: " + rate);
    }


    public void getCountryFromSoap() {
        GetCountryRequest req = new GetCountryRequest();
        req.setName("Poland");
        GetCountryResponse res = (GetCountryResponse)
                getWebServiceTemplate().marshalSendAndReceive(
                        "http://localhost:8080/ws",
                        req,
                        new SoapActionCallback("http://localhost:8080/ws")
                );
        Country c = res.getCountry();
        System.out.println(res.getCountry().getName());
    }

    public void getStudentFromSoap() {
        GetStudentRequest req = new GetStudentRequest();
        req.setName("AbraKadabra");
        GetStudentResponse res = (GetStudentResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:8080/ws",
                req,
                new SoapActionCallback("http://localhost:8080/ws")
        );
        System.out.println("name:" + res.getSss().getName() + " pesel:" + res.getSss().getPesel());
    }

}
