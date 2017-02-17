package com.ilona.travix.responses;

/**
 * Created by ilonaK on 16/02/2017.
 */

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@XmlRootElement(name = "CrazyAirResponse")
public class CrazyAirResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String airline;
    private double price;
    private String cabinClass;
    private String departureAirportCode;
    private String destinationAirportCode;
    private String departureDate;
    private String arrivalDate;


    public CrazyAirResponse(String airline, double price, String cabinClass, String departureAirportCode, String destinationAirportCode, String departureDate, String arrivalDate) {
        this.airline = airline;
        this.price = price;
        this.cabinClass = cabinClass;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }


    public CrazyAirResponse(){}

    public String getAirline() {
        return airline;
    }
    @XmlElement
    public void setAirline(String airline) {
        this.airline = airline;
    }

    public double getPrice() {
        return price;
    }
    @XmlElement
    public void setPrice(double price) {
        this.price = price;
    }

    public String getCabinClass() {
        return cabinClass;
    }
    @XmlElement
    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
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
