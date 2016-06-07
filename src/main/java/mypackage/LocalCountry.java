package mypackage;

import autogen.Currency;
import lombok.Builder;
import lombok.Value;


@Value
@Builder
public class LocalCountry {
    String name;
    int population;
    String capital;
    Currency currency;
}