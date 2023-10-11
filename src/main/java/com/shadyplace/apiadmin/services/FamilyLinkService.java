package com.shadyplace.apiadmin.services;

import com.shadyplace.apiadmin.models.FamilyLink;
import com.shadyplace.apiadmin.models.enums.FamilyLinkLabel;
import com.shadyplace.apiadmin.repository.FamilyLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyLinkService {

    @Autowired
    FamilyLinkRepository familyLinkRepository;

    public FamilyLink findByLabel(FamilyLinkLabel familyLinkLabel) {
        return this.familyLinkRepository.findFirstByLabel(familyLinkLabel);
    }

    public void save(FamilyLink familyLink) {
        this.familyLinkRepository.save(familyLink);
    }
}
