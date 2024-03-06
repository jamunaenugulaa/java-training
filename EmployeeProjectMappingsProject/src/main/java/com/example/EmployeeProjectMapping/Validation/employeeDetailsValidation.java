package com.example.EmployeeProjectMapping.Validation;


import com.example.EmployeeProjectMapping.Entity.Address;
import com.example.EmployeeProjectMapping.Model.AddressModel;
import com.example.EmployeeProjectMapping.Model.AdminModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;


import com.example.EmployeeProjectMapping.Model.AdminModel;
import com.example.EmployeeProjectMapping.Model.EmployeeModel;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.executable.ExecutableValidator;
import jakarta.validation.metadata.BeanDescriptor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
//import org.springframework.validation.Validator;

import java.util.Set;

@Component
public class employeeDetailsValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return EmployeeModel.class.equals(clazz);
    }
    public void validate(Object target, Errors errors) {
        EmployeeModel employeeModel= (EmployeeModel) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","AdminName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"role","AdminRole");
        if (employeeModel.getGmail() != null&& !employeeModel.getGmail().endsWith("@gmail.com")) {
            errors.rejectValue("gmail", "Gmail", "Gmail");

        }
        if(employeeModel.getGmail().isBlank()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gmail", "AdminEmail");
        }
    }


}


