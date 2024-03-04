package com.example.serden.Service;

import com.example.serden.Entity.Personel;
import com.example.serden.Repository.PersonelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PersonelServiceTest {

    @InjectMocks
    private PersonelService personelService;

    @Mock
    private PersonelRepository personelRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testLogin() {
        String nameSurname = "admin";
        String password = "admin";
        Personel mockPersonel = new Personel();
        mockPersonel.setPersonelNameSurname(nameSurname);
        mockPersonel.setPersonelPassword(password);

        when(personelRepository.findByPersonelNameSurnameAndPersonelPassword(nameSurname, password)).thenReturn(mockPersonel);

        Personel result = personelService.login(nameSurname, password);

        assertNotNull(result);
        assertEquals(nameSurname, result.getPersonelNameSurname());
        assertEquals(password, result.getPersonelPassword());
    }
    @Test
    public void testFindByPersonelNameSurname() {
        String nameSurname = "admin";
        Personel mockPersonel = new Personel();
        mockPersonel.setPersonelNameSurname(nameSurname);

        when(personelRepository.findByPersonelNameSurname(nameSurname)).thenReturn(mockPersonel);

        Personel result = personelService.findByPersonelNameSurname(nameSurname);

        assertNotNull(result);
        assertEquals(nameSurname, result.getPersonelNameSurname());
    }

    // Test metotları burada tanımlanacak
}
