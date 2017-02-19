package com.ilona.travix.tools;

import com.ilona.travix.responses.BusyFlightsResponse;
import com.ilona.travix.responses.ToughJetResponse;

/**
 * Created by ilonaK on 19/02/2017.
 */
public class ToughJetResponseConverter {

   public BusyFlightsResponse convertToBusyFlight(ToughJetResponse toughJetResponse, int passengerNumber){
       BusyFlightsResponse busyFlightsResponse=new BusyFlightsResponse();

       busyFlightsResponse.setAirline(toughJetResponse.getCarrier());
       busyFlightsResponse.setSupplier("ToughJet");
       busyFlightsResponse.setFare((toughJetResponse.getBasePrice()+toughJetResponse.getTax())*((100-toughJetResponse.getDiscount())/100)*passengerNumber);
       busyFlightsResponse.setDepartureAirportCode(toughJetResponse.getDepartureAirportName());
       busyFlightsResponse.setDestinationAirportCode(toughJetResponse.getArrivalAirportName());
       busyFlightsResponse.setDepartureDate(toughJetResponse.getDepartureYear()+"-"+toughJetResponse.getDepartureMonth()+"-"+toughJetResponse.getDepartureDay()+"'T'00:00:00.000Z");
       busyFlightsResponse.setArrivalDate(toughJetResponse.getReturnYear()+"-"+toughJetResponse.getReturnMonth()+"-"+toughJetResponse.getReturnDay()+"'T'00:00:00.000Z");

       return busyFlightsResponse;
   }

}
