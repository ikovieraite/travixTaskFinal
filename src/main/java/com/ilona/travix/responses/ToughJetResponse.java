package com.ilona.travix.responses;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * Created by ilonaK on 16/02/2017.
 */
public class ToughJetResponse implements Serializable{
    private static final long serialVersionUID = 1L;

    private String carrier;
    private double basePrice;
    private double tax;
    private double discount;
    private String departureAirportName;
    private String arrivalAirportName;
    private int departureDay;
    private int departureMonth;
    private int departureYear;
    private int returnDay;
    private int returnMonth;
    private int returnYear;

    public ToughJetResponse(String carrier, double basePrice, double tax, double discount, String departureAirportName, String arrivalAirportName, int departureDay, int departureMonth, int departureYear, int returnDay, int returnMonth, int returnYear) {
        this.carrier = carrier;
        this.basePrice = basePrice;
        this.tax = tax;
        this.discount = discount;
        this.departureAirportName = departureAirportName;
        this.arrivalAirportName = arrivalAirportName;
        this.departureDay = departureDay;
        this.departureMonth = departureMonth;
        this.departureYear = departureYear;
        this.returnDay = returnDay;
        this.returnMonth = returnMonth;
        this.returnYear = returnYear;
    }

    public ToughJetResponse(){}

    public String getCarrier() {
        return carrier;
    }
    @XmlElement
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public double getBasePrice() {
        return basePrice;
    }
    @XmlElement
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getTax() {
        return tax;
    }
    @XmlElement
    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }
    @XmlElement
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }
    @XmlElement
    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }
    @XmlElement
    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public int getDepartureDay() {
        return departureDay;
    }
    @XmlElement
    public void setDepartureDay(int departureDay) {
        this.departureDay = departureDay;
    }

    public int getDepartureMonth() {
        return departureMonth;
    }
    @XmlElement
    public void setDepartureMonth(int departureMonth) {
        this.departureMonth = departureMonth;
    }

    public int getDepartureYear() {
        return departureYear;
    }
    @XmlElement
    public void setDepartureYear(int departureYear) {
        this.departureYear = departureYear;
    }

    public int getReturnDay() {
        return returnDay;
    }
    @XmlElement
    public void setReturnDay(int returnDay) {
        this.returnDay = returnDay;
    }

    public int getReturnMonth() {
        return returnMonth;
    }
    @XmlElement
    public void setReturnMonth(int returnMonth) {
        this.returnMonth = returnMonth;
    }

    public int getReturnYear() {
        return returnYear;
    }
    @XmlElement
    public void setReturnYear(int returnYear) {
        this.returnYear = returnYear;
    }

}
