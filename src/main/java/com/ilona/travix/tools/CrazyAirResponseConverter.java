package com.ilona.travix.tools;

import com.ilona.travix.responses.BusyFlightsResponse;
import com.ilona.travix.responses.CrazyAirResponse;

/**
 * Created by ilonaK on 19/02/2017.
 */
public class CrazyAirResponseConverter {

    DateConverter dateConverter=new DateConverter();

    public BusyFlightsResponse convertToBusyFlight(CrazyAirResponse crazyAirResponse, int passengerNumber){
        BusyFlightsResponse busyFlightsResponse=new BusyFlightsResponse();

        String dateOfDeparture = dateConverter.getDate(crazyAirResponse.getDepartureDate(), "MM-dd-yyy HH:mm:ss", "yyyy-MM-dd")+"'T'00:00:00.000Z";
        String dateOfReturn = dateConverter.getDate(crazyAirResponse.getArrivalDate(), "MM-dd-yyy HH:mm:ss", "yyyy-MM-dd")+"'T'00:00:00.000Z";

        busyFlightsResponse.setAirline(crazyAirResponse.getAirline());
        busyFlightsResponse.setSupplier("CrazyAir");
        busyFlightsResponse.setFare(crazyAirResponse.getPrice()*passengerNumber);
        busyFlightsResponse.setDepartureAirportCode(crazyAirResponse.getDepartureAirportCode());
        busyFlightsResponse.setDestinationAirportCode(crazyAirResponse.getDestinationAirportCode());
        busyFlightsResponse.setDepartureDate(dateOfDeparture);
        busyFlightsResponse.setArrivalDate(dateOfReturn);

        return busyFlightsResponse;
    }

}
