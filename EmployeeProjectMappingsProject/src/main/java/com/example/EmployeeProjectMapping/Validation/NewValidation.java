package com.example.EmployeeProjectMapping.Validation;

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
public class NewValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return AdminModel.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {

        AdminModel adminModel= (AdminModel) target;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors,"Name","AdminName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"Role","AdminRole");
        if (adminModel.getMail() != null&& !adminModel.getMail().endsWith("@gmail.com")) {
            errors.rejectValue("Mail", "Gmail", "Gmail");

        }
        if(adminModel.getMail().isBlank()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Mail", "AdminEmail");
        }

    }
    public void validate1(Object target, Errors errors) {

        AdminModel adminModel= (AdminModel) target;


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "AdminUserName");
        if(adminModel.getPassword()!=null && adminModel.getPassword().toString().length()<4){
            errors.rejectValue("password", "AdminPassword", "AdminPassword");

        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "AdminPasswordNull");

    }


}
