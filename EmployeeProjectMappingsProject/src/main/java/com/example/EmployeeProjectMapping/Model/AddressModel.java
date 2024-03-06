package com.example.EmployeeProjectMapping.Model;

import jakarta.persistence.Embeddable;
import org.springframework.stereotype.Component;
@Component
public class AddressModel
{
    private Integer addressId;
    private Integer pincode;
    private String City;

    public AddressModel() {
    }

    public AddressModel(Integer addressId, Integer pincode, String city) {
        this.addressId = addressId;
        this.pincode = pincode;
        City = city;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getPincode() {
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



