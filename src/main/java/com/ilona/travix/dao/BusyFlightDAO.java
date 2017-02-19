package com.ilona.travix.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.ilona.travix.responses.BusyFlightsResponse;
import com.ilona.travix.responses.CrazyAirResponse;
import com.ilona.travix.responses.ToughJetResponse;
import com.ilona.travix.tools.CrazyAirResponseConverter;
import com.ilona.travix.tools.DateConverter;
import com.ilona.travix.tools.ToughJetResponseConverter;

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

    private DateConverter dateConverter=new DateConverter();

    private List<CrazyAirResponse> flightListCrazy;
    private List<ToughJetResponse> flightListTough;
    private List<BusyFlightsResponse> busyFlightsResponses=new ArrayList<>();

    private CrazyAirResponseConverter crazyAirResponseConverter=new CrazyAirResponseConverter();
    private ToughJetResponseConverter toughJetResponseConverter = new ToughJetResponseConverter();

    public List<BusyFlightsResponse> getFlights(String origin, String destination, String departureDate, String returnDate, int passengerNumber) throws IOException {

        LocalDateTime departureDateInDateFormat = LocalDateTime.parse(departureDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX"));
        LocalDateTime ReturnDateInDateFormat = LocalDateTime.parse(returnDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX"));

        String departureDateCrazyAir = dateConverter.getDate(departureDate, "yyyy-MM-dd'T'HH:mm:ss.SSSX", "MM-dd-yyyy");
        String returnDateCrazyAir = dateConverter.getDate(returnDate, "yyyy-MM-dd'T'HH:mm:ss.SSSX", "MM-dd-yyyy");

        ObjectMapper mapper = new ObjectMapper();

        URL url=new URL("http://localhost:8080/crazyair/"+origin+"/"+destination+"/"+departureDateCrazyAir+"/"+returnDateCrazyAir+"/"+passengerNumber);
        URL url2=new URL("http://localhost:8080/toughjet/"+origin+"/"+destination+"/"+departureDateInDateFormat.getDayOfMonth()+"/"+departureDateInDateFormat.getMonthValue()+"/"+departureDateInDateFormat.getYear()+"/"+ReturnDateInDateFormat.getDayOfMonth()+"/"+ReturnDateInDateFormat.getMonthValue()+"/"+ReturnDateInDateFormat.getYear()+"/"+passengerNumber);

        flightListCrazy = mapper.readValue(url, TypeFactory.defaultInstance().constructCollectionType(List.class, CrazyAirResponse.class));
        flightListTough = mapper.readValue(url2, TypeFactory.defaultInstance().constructCollectionType(List.class, ToughJetResponse.class));

        for(CrazyAirResponse crazyAirResponse : flightListCrazy){
            BusyFlightsResponse busyFlightsResponse=crazyAirResponseConverter.convertToBusyFlight(crazyAirResponse, passengerNumber);
            busyFlightsResponses.add(busyFlightsResponse);
        }
        for(ToughJetResponse toughJetResponse : flightListTough){
            BusyFlightsResponse busyFlightsResponse= toughJetResponseConverter.convertToBusyFlight(toughJetResponse, passengerNumber);
            busyFlightsResponses.add(busyFlightsResponse);
        }

        return busyFlightsResponses;
    }
}
