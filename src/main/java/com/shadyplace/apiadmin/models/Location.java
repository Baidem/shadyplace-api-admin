package com.shadyplace.apiadmin.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, name = "line_number")
    @Max(value = 8, message = "Location line number cannot exceed 8.")
    @NotNull(message = "Location's lineNumber cannot be null.")
    @Positive(message = "Location.lineNumber must be positive.")
    private int lineNumber;
    @Column(nullable = false, name = "rank_number")
    @Max(value = 36, message = "Location.rankNumber cannot exceed 36.")
    @NotNull(message = "Location's rankNumber cannot be null.")
    @Positive(message = "Location's rankNumber must be positive.")
    private int rankNumber;
    @OneToMany(mappedBy = "location")
    private List<Booking> bookings;

    public Location() {
        this.bookings = Collections.emptyList();
    }
    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }
    public void removeBooking(Booking booking){
        this.bookings.remove(booking);
    }
    public List<Booking> getBookings(){
        return this.bookings;
    }

    public Location(int lineNumber, int rankNumber) {
        this();
        this.lineNumber = lineNumber;
        this.rankNumber = rankNumber;
    }

    public long getId() {
        return id;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getRankNumber() {
        return rankNumber;
    }
}
