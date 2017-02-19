package com.ilona.travix.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.ilona.travix.responses.CrazyAirResponse;
import com.ilona.travix.tools.DateConverter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilonaK on 16/02/2017.
 */
public class CrazyAirDAO {
    private DateConverter dateConverter = new DateConverter();

    public List<CrazyAirResponse> getAllFlights(){
        List<CrazyAirResponse> flightList = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("CrazyAirResponse.json").getFile());
            ObjectMapper mapper = new ObjectMapper();
            flightList= mapper.readValue(file, TypeFactory.defaultInstance().constructCollectionType(List.class, CrazyAirResponse.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flightList;
    }

    public List<CrazyAirResponse> getRelevantFlights(String origin, String destination, String departureDate, String returnDate, int numberOfPassengers){
        List<CrazyAirResponse> relevantFlights=new ArrayList<>();
        List<CrazyAirResponse> allFlights=getAllFlights();
        for(CrazyAirResponse crazyAirResponse : allFlights){
            String dateOfDeparture = dateConverter.getDate(crazyAirResponse.getDepartureDate(), "MM-dd-yyy HH:mm:ss", "MM-dd-yyyy");
            String dateOfArrival = dateConverter.getDate(crazyAirResponse.getArrivalDate(), "MM-dd-yyy HH:mm:ss", "MM-dd-yyyy");

            if(crazyAirResponse.getDepartureAirportCode().equals(origin) && crazyAirResponse.getDestinationAirportCode().equals(destination) && dateOfDeparture.equals(departureDate) && dateOfArrival.equals(returnDate)) {
                relevantFlights.add(crazyAirResponse);
            }
        }
        return relevantFlights;
    }

}
