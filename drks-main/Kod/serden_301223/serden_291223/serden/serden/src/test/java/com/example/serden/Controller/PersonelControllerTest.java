package com.example.serden.Controller;

import com.example.serden.Entity.Personel;
import com.example.serden.Service.PersonelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PersonelControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PersonelService personelService;

    @InjectMocks
    private PersonelController personelController;

    @BeforeEach
    public void setup() {
        openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(personelController).build();
    }

    @Test
    public void testLoginSuccess() throws Exception {
        Personel mockPersonel = new Personel();
        mockPersonel.setPersonelNameSurname("John Doe");
        mockPersonel.setPersonelPassword("password");

        when(personelService.login("admin", "admin")).thenReturn(mockPersonel);

        mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"personelNameSurname\":\"admin\",\"personelPassword\":\"admin\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("success"));
    }

    @Test
    public void testLoginFailure() throws Exception {
        when(personelService.login("invalid", "credentials")).thenReturn(null);

        mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"personelNameSurname\":\"invalid\",\"personelPassword\":\"credentials\"}"))
                .andExpect(status().isUnauthorized())
                .andExpect(content().string("Invalid credentials"));
    }
    @Test
    public void testIndexPage() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("loggedInPersonelNameSurname", "John Doe");

        Personel mockPersonel = new Personel();
        mockPersonel.setPersonelNameSurname("admin");
        mockPersonel.setPersonelRank("Rank");
        // Diğer gerekli alanları da ayarlayın

        when(personelService.findByPersonelNameSurname("admin")).thenReturn(mockPersonel);

        mockMvc.perform(get("/index").session(session))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("personel_Rank", "personelNameSurname", "clinicName"));
    }


    // Diğer endpoint'ler için benzer testler (örneğin /index, /receteOlustur.html, vb.)
}
