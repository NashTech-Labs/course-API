package io.knoldus.student;

import org.springframework.data.mongodb.core.mapping.Document;

public class Address {
    private String country;
    private String city;
    private String pinCode;

    public Address() {
    }

    public Address(String country, String city, String pinCode) {
        this.country = country;
        this.city = city;
        this.pinCode = pinCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
