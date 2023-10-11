package com.shadyplace.apiadmin.repository;

import com.shadyplace.apiadmin.models.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

}
