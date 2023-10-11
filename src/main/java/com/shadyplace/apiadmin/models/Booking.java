package com.shadyplace.apiadmin.models;

import com.shadyplace.apiadmin.models.enums.BookingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.Length;

import java.util.Calendar;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "booking_date", nullable = false)
    @Future(message = "Booking date must be in the future.")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "Start date cannot be null.")
    private Calendar bookingDate;
    @Column(name = "booking_price", columnDefinition = "float(10,2)", nullable = false)
    @NotNull(message = "Booking's price cannot be null.")
    @PositiveOrZero(message = "Booking price must be positive.")
    private double bookingPrice;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Booking's status cannot be null.")
    private BookingStatus bookingStatus;
    @Basic
    @Length(max = 255, message = "Booking's comment must be no more than 255 characters long.")
    private String comment;

    @ManyToOne(optional = true)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;
    @ManyToOne(optional = false)
    @NotNull(message = "Booking's equipement cannot be null.")
    @JoinColumn(name = "equipement_id", referencedColumnName = "id")
    private Equipment equipment;
    @ManyToOne(optional = false)
    @NotNull(message = "Booking's line cannot be null.")
    @JoinColumn(name = "line_id", referencedColumnName = "id")
    private Line line;
    @ManyToOne
    @NotNull(message = "Booking's fidelity rank cannot be null.")
    @JoinColumn(name = "fidelity_rank_id", referencedColumnName = "id")
    private FidelityRank fidelityRank;
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "command_id", referencedColumnName = "id")
    private Command command;

    public Booking() {
        this.bookingStatus = BookingStatus.PENDING;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Calendar bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getBookingPrice() {
        return bookingPrice;
    }

    public void setBookingPrice(double bookingPrice) {
        this.bookingPrice = bookingPrice;
    }


    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public FidelityRank getFidelityRank() {
        return fidelityRank;
    }

    public void setFidelityRank(FidelityRank fidelityRank) {
        this.fidelityRank = fidelityRank;
    }
    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
