package com.example.serden.Service;

import com.example.serden.Entity.Patient;
import com.example.serden.Repository.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PatientServiceTest {

    @InjectMocks
    private PatientService patientService;

    @Mock
    private PatientRepository patientRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testLogin2() {
        String nameSurname = "Ali Veli";
        String password = "12345";
        Patient mockPatient = new Patient();
        mockPatient.setPatientNameSurname(nameSurname);
        mockPatient.setPatientPassword(password);

        when(patientRepository.findByPatientNameSurnameAndPatientPassword(nameSurname, password)).thenReturn(mockPatient);

        Patient result = patientService.login2(nameSurname, password);

        assertNotNull(result);
        assertEquals(nameSurname, result.getPatientNameSurname());
        assertEquals(password, result.getPatientPassword());
    }
    @Test
    public void testFindByPatientNameSurname() {
        String nameSurname = "Ali Veli";
        Patient mockPatient = new Patient();
        mockPatient.setPatientNameSurname(nameSurname);

        when(patientRepository.findByPatientNameSurname(nameSurname)).thenReturn(mockPatient);

        Patient result = patientService.findByPatientNameSurname(nameSurname);

        assertNotNull(result);
        assertEquals(nameSurname, result.getPatientNameSurname());
    }

    // Test metotları burada tanımlanacak
}
