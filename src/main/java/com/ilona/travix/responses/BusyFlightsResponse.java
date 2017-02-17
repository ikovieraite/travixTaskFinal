package com.ilona.travix.responses;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * Created by ilonaK on 16/02/2017.
 */
public class BusyFlightsResponse implements Serializable{

    private static final long serialVersionUID = 1L;

    private String airline;
    private String supplier;
    private double fare;
    private String departureAirportCode;
    private String destinationAirportCode;
    private String departureDate;
    private String arrivalDate;

    public BusyFlightsResponse(String airline, String supplier, double fare, String departureAirportCode, String destinationAirportCode, String departureDate, String arrivalDate) {
        this.airline = airline;
        this.supplier = supplier;
        this.fare = fare;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }
    public BusyFlightsResponse(){}

    public String getAirline() {
        return airline;
    }
    @XmlElement
    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getSupplier() {
        return supplier;
    }
    @XmlElement
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public double getFare() {
        return fare;
    }
    @XmlElement
    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }
    @XmlElement
    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }
    @XmlElement
    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }
    @XmlElement
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }
    @XmlElement
    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

}
