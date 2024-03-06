package com.example.EmployeeProjectMapping.Entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Embeddable
@Component
public class Address {
    private  Integer addressId;
    private Integer pincode;
    private String City;

    public Address() {
    }

    public Address(Integer addressId, Integer pincode, String city) {
        this.addressId = addressId;
        this.pincode = pincode;
        City = city;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", pincode=" + pincode +
                ", City='" + City + '\'' +
                '}';
    }
}

