package com.ilona.travix.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.ilona.travix.responses.BusyFlightsResponse;
import com.ilona.travix.responses.CrazyAirResponse;
import com.ilona.travix.responses.ToughJetResponse;
import org.joda.time.DateTime;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilonaK on 16/02/2017.
 */
public class BusyFlightDAO {

    public List<BusyFlightsResponse> getFlights(String origin, String destination, String departureDate, String returnDate, int passengerNumber) throws IOException {
        List<CrazyAirResponse> flightListCrazy=null;
        List<ToughJetResponse> flightListTough=null;
        List<BusyFlightsResponse> busyFlightsResponses=new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        LocalDateTime datetime = LocalDateTime.parse(departureDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX"));
        DateTime dt = new DateTime(departureDate);
        DateTime dr = new DateTime(returnDate);
        String newDateCrazy = datetime.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        LocalDateTime datetimereturn = LocalDateTime.parse(returnDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX"));
        String newReturnDateCrazy = datetimereturn.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        ObjectMapper mapper = new ObjectMapper();
        String newUrl="http://localhost:8080/toughjet/"+origin+"/"+destination+"/"+datetime.getDayOfMonth()+"/"+datetime.getMonthValue()+"/"+datetime.getYear()+"/"+datetimereturn.getDayOfMonth()+"/"+datetimereturn.getMonthValue()+"/"+datetimereturn.getYear()+"/"+passengerNumber;
        System.out.println(newUrl);
        URL url=new URL("http://localhost:8080/crazyair/"+origin+"/"+destination+"/"+newDateCrazy+"/"+newReturnDateCrazy+"/"+passengerNumber);
        URL url2=new URL(newUrl);
        System.out.println("http://localhost:8080/crazyair/"+origin+"/"+destination+"/"+newDateCrazy+"/"+newReturnDateCrazy+"/"+passengerNumber);
        flightListCrazy= mapper.readValue(url, TypeFactory.defaultInstance().constructCollectionType(List.class, CrazyAirResponse.class));
        flightListTough=mapper.readValue(url2, TypeFactory.defaultInstance().constructCollectionType(List.class, ToughJetResponse.class));

        for(CrazyAirResponse crazyAirResponse : flightListCrazy){
            System.out.println(crazyAirResponse.getAirline());
            BusyFlightsResponse busyFlightsResponse=new BusyFlightsResponse();
            busyFlightsResponse.setAirline(crazyAirResponse.getAirline());
            busyFlightsResponse.setSupplier("CrazyAir");
            busyFlightsResponse.setFare(crazyAirResponse.getPrice()*passengerNumber);
            busyFlightsResponse.setDepartureAirportCode(crazyAirResponse.getDepartureAirportCode());
            busyFlightsResponse.setDestinationAirportCode(crazyAirResponse.getDestinationAirportCode());
            busyFlightsResponse.setDepartureDate(crazyAirResponse.getDepartureDate()+"'T'00:00:00.000Z");
            busyFlightsResponse.setArrivalDate(crazyAirResponse.getArrivalDate()+"'T'00:00:00.000Z");

            busyFlightsResponses.add(busyFlightsResponse);
        }
        for(ToughJetResponse toughJetResponse : flightListTough){
            BusyFlightsResponse busyFlightsResponse=new BusyFlightsResponse();
            busyFlightsResponse.setAirline(toughJetResponse.getCarrier());
            busyFlightsResponse.setSupplier("ToughJet");
            busyFlightsResponse.setFare((toughJetResponse.getBasePrice()+toughJetResponse.getTax())*((100-toughJetResponse.getDiscount())/100)*passengerNumber);
            busyFlightsResponse.setDepartureAirportCode(toughJetResponse.getDepartureAirportName());
            busyFlightsResponse.setDestinationAirportCode(toughJetResponse.getArrivalAirportName());
            busyFlightsResponse.setDepartureDate(toughJetResponse.getDepartureDay()+"-"+toughJetResponse.getDepartureMonth()+"-"+toughJetResponse.getDepartureYear()+"'T'00:00:00.000Z");
            busyFlightsResponse.setArrivalDate(toughJetResponse.getReturnDay()+"="+toughJetResponse.getReturnMonth()+"-"+toughJetResponse.getReturnYear()+"'T'00:00:00.000Z");

            busyFlightsResponses.add(busyFlightsResponse);
        }
        System.out.println(busyFlightsResponses);
        return busyFlightsResponses;

    }

//    2010-10-12T08:50Z





}
