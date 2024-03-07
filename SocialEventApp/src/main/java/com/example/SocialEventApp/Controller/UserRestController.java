package com.example.SocialEventApp.Controller;

import com.example.SocialEventApp.Entity.Events;
import com.example.SocialEventApp.Entity.Location;
import com.example.SocialEventApp.Entity.UsersTable;

import com.example.SocialEventApp.Model.*;
import com.example.SocialEventApp.SecurityConfig.UsersTableServices;
import com.example.SocialEventApp.Services.BookingServices;
import com.example.SocialEventApp.Services.CustomerServices;
import com.example.SocialEventApp.Services.EventServices;
import com.example.SocialEventApp.Services.LocationServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserRestController {
    @Autowired
    private EventServices eventServices;
    @Autowired
    private LocationServices locationServices;
    @Autowired
    private UsersTableServices usersTableServices;
    @Autowired
    private CustomerServices customerServices;
    @Autowired
    private BookingServices bookingServices;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    @PostMapping("/addUsers")
    public UsersTable addUsers(@RequestBody UsersTable user){
        user.setPassword(encoder.encode(user.getPassword()));
        return usersTableServices.saveUser(user);

    }
    @PostMapping("/registerCustomer")
    public ResponseEntity<CustomerModel> addOrganizer(@Valid @RequestBody CustomerModel customerModel){
        CustomerModel event=  customerServices.registerCustomer(customerModel);

        return new ResponseEntity<CustomerModel>(event, HttpStatus.CREATED);

    }
    @GetMapping("/getEvents")
    public List<EventsModel> getEvents(){
        return eventServices.getAllEvents();
    }
    @GetMapping("/getLocations")
    public List<LocationModel> getLocation(){
        return locationServices.getAllLocations();
    }
    @GetMapping("/bookEvent")
    public List<Location> bookEvent(@RequestParam("event") int event, @Valid @RequestBody BookingEventModel booking){
        System.out.println(booking);
        return eventServices.getLocation(event,booking.getCapacity());
    }


    @PostMapping("/bookingEvent")
    public BookingEventModel bookingEvent(@RequestParam("event") int eid,@RequestParam("location") int lid,@Valid @RequestBody BookingEventModel booking){
        System.out.println(booking);
        Events event=eventServices.getEventById(eid);
        Location location=locationServices.getLocationById(lid);
        if(event==null||location==null){
            return null;
        }
        booking.setEvent(event);
        booking.setLocation(location);
        return bookingServices.saveBooking(booking);

    }


}
