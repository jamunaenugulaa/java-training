package com.example.SocialEventApp.Services;

import com.example.SocialEventApp.Entity.BookingEvent;
import com.example.SocialEventApp.Model.BookingEventModel;
import com.example.SocialEventApp.Repository.BookingRepository;
import com.example.SocialEventApp.Repository.EventRepository;
import com.example.SocialEventApp.Repository.LocationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServices {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private LocationRepository locationRepository;

    public BookingEventModel saveBooking(BookingEventModel booking) {
        BookingEvent bookingevent=new BookingEvent();
        BeanUtils.copyProperties(booking,bookingevent);
        bookingRepository.save(bookingevent);
        return booking;
    }
}
