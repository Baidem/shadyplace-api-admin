package com.shadyplace.apiadmin.repository;

import com.shadyplace.apiadmin.models.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {


}
