package com.example.hastane_drks.Service;

import com.example.hastane_drks.Entity.Personel;
import com.example.hastane_drks.Repository.PersonelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonelService {

    @Autowired
    private PersonelRepository personelRepository;

    public Personel login(String personelNameSurname, String personelPassword) {
        return personelRepository.findByPersonelNameSurnameAndPersonelPassword(personelNameSurname, personelPassword);
    }

    public Personel findByPersonelNameSurname(String personelNameSurname) {
        return personelRepository.findByPersonelNameSurname(personelNameSurname);
    }
}
