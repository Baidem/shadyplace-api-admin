package com.shadyplace.apiadmin.repository;

import com.shadyplace.apiadmin.models.FamilyLink;
import com.shadyplace.apiadmin.models.enums.FamilyLinkLabel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyLinkRepository extends CrudRepository<FamilyLink, Long> {


    FamilyLink findFirstByLabel(FamilyLinkLabel familyLinkLabel);
}
