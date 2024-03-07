package com.example.SocialEventApp.Services;

import com.example.SocialEventApp.Entity.Customer;
import com.example.SocialEventApp.Model.CustomerModel;
import com.example.SocialEventApp.Repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServices {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerModel registerCustomer(CustomerModel customerModel) {
        //Customer customer=customerRepository.findByName(customerModel.getName());
        Customer customer=customerRepository.findByPhone(customerModel.getPhnNum());

        if(customer!=null){
            return null;
        }
        customer=new Customer();
        BeanUtils.copyProperties(customerModel,customer);
        customerRepository.save(customer);
        customerModel.setUserId(customer.getUserId());
        return customerModel;
    }
}
