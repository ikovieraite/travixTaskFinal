package com.ilona.travix.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.ilona.travix.responses.ToughJetResponse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilonaK on 16/02/2017.
 */
public class ToughJetDAO {

    public List<ToughJetResponse> getAllFlights(){
        List<ToughJetResponse> flightList = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("ToughJetResponse.json").getFile());

            ObjectMapper mapper = new ObjectMapper();
            flightList= mapper.readValue(file, TypeFactory.defaultInstance().constructCollectionType(List.class, ToughJetResponse.class));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return flightList;
    }

    public List<ToughJetResponse> getRelevantFlights(String origin, String destination, int departureDay, int departureMonth, int departureYear, int returnDay, int returnMonth, int returnYear, int numberOfPassengers){
        List<ToughJetResponse> relevantFlights=new ArrayList<>();
        List<ToughJetResponse> allFlights=getAllFlights();
        for(ToughJetResponse toughJetResponse : allFlights){
            String dateOfDeparture=departureMonth+"-"+departureDay+"-"+departureYear;
            String dateOfReturn=returnMonth+"-"+returnDay+"-"+returnYear;
            String dateOfDepartureResponse=toughJetResponse.getDepartureMonth()+"-"+toughJetResponse.getDepartureDay()+"-"+toughJetResponse.getDepartureYear();
            String dateOfReturnResponse=toughJetResponse.getReturnMonth()+"-"+toughJetResponse.getReturnDay()+"-"+toughJetResponse.getReturnYear();
            if(toughJetResponse.getDepartureAirportName().equals(origin) && toughJetResponse.getArrivalAirportName().equals(destination) && dateOfDeparture.equals(dateOfDepartureResponse) && dateOfReturn.equals(dateOfReturnResponse) ){
                relevantFlights.add(toughJetResponse);
                System.out.println(toughJetResponse);
            }
        }
        return relevantFlights;
    }


}
