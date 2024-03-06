package com.example.EmployeeProjectMapping.Validation;

import com.example.EmployeeProjectMapping.Entity.Address;
import com.example.EmployeeProjectMapping.Model.AddressModel;
import com.example.EmployeeProjectMapping.Model.EmployeeModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class EmployeeAddressValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return AddressModel.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        AddressModel address1= (AddressModel) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "cityNull", "City is required");

        // Check for empty or whitespace addressId
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressId", "addressIdNull", "Address ID is required");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pincode", "pincodeNull", "Pincode is required");

//
//        // Check for empty or whitespace pincodeValidationUtils.rejectIfEmptyOrWhitespace(errors, "pincode", "pincodeNull", "Pincode is required");
        if (address1.getAddressId()!=null&& address1.getAddressId().toString().length() > 4) {
            errors.rejectValue("addressId", "AddressId", "AddressId");
        }

        if (address1.getPincode()!=null&&address1.getPincode().toString().length() != 6) {
            errors.rejectValue("pincode", "Pincode", "Pincode");
        }
    }


}
