package com.ilona.travix;


import com.ilona.travix.dao.BusyFlightDAO;
import com.ilona.travix.dao.CrazyAirDAO;
import com.ilona.travix.dao.ToughJetDAO;
import com.ilona.travix.responses.BusyFlightsResponse;
import com.ilona.travix.responses.CrazyAirResponse;
import com.ilona.travix.responses.ToughJetResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Created by ilonaK on 16/02/2017.
 */

@RestController
public class FlightsService {

    private CrazyAirDAO crazyAirDAO=new CrazyAirDAO();
    private ToughJetDAO toughJetDAO=new ToughJetDAO();
    private BusyFlightDAO busyFlightDAO=new BusyFlightDAO();

    @RequestMapping(value="/crazyair/{origin}/{destination}/{departureDate}/{arrivalDate}/{passengers}", method= RequestMethod.GET)
    public List<CrazyAirResponse> crazyAirGetAirline(@PathVariable("origin") String origin , @PathVariable("destination") String destination, @PathVariable("departureDate") String departureDate, @PathVariable("arrivalDate") String arrivalDate, @PathVariable("passengers") int passengers ) {
        return crazyAirDAO.getRelevantFlights(origin, destination, departureDate, arrivalDate, passengers);
    }

    @RequestMapping(value="/toughjet/{origin}/{destination}/{departureDay}/{departureMonth}/{departureYear}/{arrivalDay}/{arrivalMonth}/{arrivalYear}/{passengers}", method= RequestMethod.GET)
    public List<ToughJetResponse> toughJetGetAirline(@PathVariable("origin") String origin , @PathVariable("destination") String destination, @PathVariable("departureDay") int departureDay, @PathVariable("departureMonth") int departureMonth, @PathVariable("departureYear") int departureYear, @PathVariable("arrivalDay") int arrivalDay, @PathVariable("arrivalMonth") int arrivalMonth, @PathVariable("arrivalYear") int arrivalYear, @PathVariable("passengers") int passengers ) {
        return toughJetDAO.getRelevantFlights(origin, destination, departureDay, departureMonth, departureYear, arrivalDay, arrivalMonth, arrivalYear, passengers);
    }

    @RequestMapping(value="/busyflight/{origin}/{destination}/{departureDate}/{arrivalDate}/{passengers}", method= RequestMethod.GET)
    public List<BusyFlightsResponse> busyFlightGetAirline(@PathVariable("origin") String origin , @PathVariable("destination") String destination, @PathVariable("departureDate") String departureDate, @PathVariable("arrivalDate") String arrivalDate, @PathVariable("passengers") int passengers ) throws IOException {
        return busyFlightDAO.getFlights(origin, destination, departureDate, arrivalDate, passengers);
    }

}