package com.example.hastane_drks.Repository;

import com.example.hastane_drks.Entity.Personel;
import org.springframework.data.jpa.repository.JpaRepository;

// PersonelRepository.java
public interface PersonelRepository extends JpaRepository<Personel, Long> {

    Personel findByPersonelNameSurname(String personelNameSurname);

    Personel findByPersonelNameSurnameAndPersonelPassword(String personelNameSurname, String personelPassword);
}
