package com.shadyplace.apiadmin.services;

import com.shadyplace.apiadmin.models.Booking;
import com.shadyplace.apiadmin.models.Command;
import com.shadyplace.apiadmin.models.User;
import com.shadyplace.apiadmin.repository.BookingRepository;
import com.shadyplace.apiadmin.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandService {

    @Autowired
    private CommandRepository commandRepository;
    @Autowired
    private BookingRepository bookingRepository;

    public List<Command> getCommandByUser(User user){
        return this.commandRepository.getCommandByUser(user);
    }

    public void saveWithBookingList(Command command) {
        try {
            command.setTotalPrice(computeTotalPrice(command.getBookings()));
                //bill

            for (Booking booking : command.getBookings()) {
                booking.setCommand(command);
            }
            commandRepository.save(command);
                System.out.println("hello");

        } catch (Exception e){
            throw new RuntimeException("Command save error : "+e.getMessage());
        }
    }

    private double computeTotalPrice(List<Booking> bookings){
        double sum = 0;
        for (Booking booking : bookings){
            sum += booking.getBookingPrice();
        }

        double factor = Math.pow(10, 2); // two digits after the decimal point
        sum = Math.round(sum * factor) / factor;

        return sum;
    }

}
