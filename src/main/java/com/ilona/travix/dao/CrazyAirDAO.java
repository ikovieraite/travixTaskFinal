package com.ilona.travix.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.ilona.travix.responses.CrazyAirResponse;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilonaK on 16/02/2017.
 */
public class CrazyAirDAO {
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
            LocalDateTime datetime = LocalDateTime.parse(crazyAirResponse.getDepartureDate(), DateTimeFormatter.ofPattern("MM-dd-yyy HH:mm:ss"));
            String newDate = datetime.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
            LocalDateTime datetime2 = LocalDateTime.parse(crazyAirResponse.getArrivalDate(), DateTimeFormatter.ofPattern("MM-dd-yyy HH:mm:ss"));
            String newDateArrival = datetime2.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
            System.out.println(newDateArrival + " "+ destination + " "+ origin+ " "+newDate);

            if(crazyAirResponse.getDepartureAirportCode().equals(origin) && crazyAirResponse.getDestinationAirportCode().equals(destination) && newDate.equals(departureDate) && newDateArrival.equals(returnDate)) {
                relevantFlights.add(crazyAirResponse);
                System.out.println(crazyAirResponse);
            }
        }
        return relevantFlights;
    }

}
