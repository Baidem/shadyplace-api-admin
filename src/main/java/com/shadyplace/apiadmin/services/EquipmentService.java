package com.shadyplace.apiadmin.services;

import com.shadyplace.apiadmin.models.Equipment;
import com.shadyplace.apiadmin.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;

    public Equipment findByOption(String option){
        return this.equipmentRepository.findFirstByOption(option);
    }

    public void save(Equipment equipment){
        this.equipmentRepository.save(equipment);
    }

    public List<Equipment> findAll(){
        return this.equipmentRepository.findAll();
    }

}
