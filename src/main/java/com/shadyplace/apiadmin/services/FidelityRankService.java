package com.shadyplace.apiadmin.services;

import com.shadyplace.apiadmin.models.FidelityRank;
import com.shadyplace.apiadmin.repository.FidelityRankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FidelityRankService {

    @Autowired
    FidelityRankRepository fidelityRankRepository;

    public FidelityRank findByLabel(String label) {
        return this.fidelityRankRepository.findFirstByLabel(label);
    }

    public void save(FidelityRank fidelityRank) {
        this.fidelityRankRepository.save(fidelityRank);
    }
}
