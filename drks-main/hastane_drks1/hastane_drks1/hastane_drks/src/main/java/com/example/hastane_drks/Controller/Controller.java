package com.example.hastane_drks.Controller;

import com.example.hastane_drks.Entity.Personel;

import com.example.hastane_drks.Service.PersonelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private PersonelService personelService;



    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Personel personel, HttpSession session) {
        Personel foundPersonel = personelService.login(personel.getPersonelNameSurname(), personel.getPersonelPassword());

        if (foundPersonel != null) {
            session.setAttribute("loggedInPersonelNameSurname", foundPersonel.getPersonelNameSurname());
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }


    // PersonelController.java
    @GetMapping("/index")
    public String index(Model model, HttpSession session) {
        String loggedInPersonelNameSurname = (String) session.getAttribute("loggedInPersonelNameSurname");
        if (loggedInPersonelNameSurname != null) {
            Personel foundPersonel = personelService.findByPersonelNameSurname(loggedInPersonelNameSurname);
            model.addAttribute("personelRank",foundPersonel.getPersonelRank());
            model.addAttribute("personelNameSurname", loggedInPersonelNameSurname);
            model.addAttribute("clinicName", foundPersonel.getClinic().getClinicName()); // clinicId'yi model'e ekle
            return "index";
        } else {
                return "redirect:/login?error";
            }

        }

    @GetMapping("/receteOlustur.html")
    public String receteOlustur(Model model,HttpSession session)
    {
        String loggedInPersonelNameSurname = (String) session.getAttribute("loggedInPersonelNameSurname");

        if (loggedInPersonelNameSurname != null) {
            Personel foundPersonel = personelService.findByPersonelNameSurname(loggedInPersonelNameSurname);
            model.addAttribute("personelRank",foundPersonel.getPersonelRank());
            model.addAttribute("personelNameSurname", loggedInPersonelNameSurname);
            model.addAttribute("clinicName", foundPersonel.getClinic().getClinicName()); // clinicId'yi model'e ekle
            return "receteOlustur";
        } else {
            return "redirect:/login?error";
        }
    }

    @GetMapping("/ilacListesi.html")
    public String ilacListesi(Model model,HttpSession session)
    {
        String loggedInPersonelNameSurname = (String) session.getAttribute("loggedInPersonelNameSurname");

        if (loggedInPersonelNameSurname != null) {
            Personel foundPersonel = personelService.findByPersonelNameSurname(loggedInPersonelNameSurname);
            model.addAttribute("personelRank",foundPersonel.getPersonelRank());
            model.addAttribute("personelNameSurname", loggedInPersonelNameSurname);
            model.addAttribute("clinicName", foundPersonel.getClinic().getClinicName()); // clinicId'yi model'e ekle
            return "ilacListesi";
        } else {
            return "redirect:/login?error";
        }
    }
    @GetMapping("/randevuSorgula.html")
    public String randevuSorgula(Model model,HttpSession session)
    {
        String loggedInPersonelNameSurname = (String) session.getAttribute("loggedInPersonelNameSurname");

        if (loggedInPersonelNameSurname != null) {
            Personel foundPersonel = personelService.findByPersonelNameSurname(loggedInPersonelNameSurname);
            model.addAttribute("personelRank",foundPersonel.getPersonelRank());
            model.addAttribute("personelNameSurname", loggedInPersonelNameSurname);
            model.addAttribute("clinicName", foundPersonel.getClinic().getClinicName()); // clinicId'yi model'e ekle
            return "randevuSorgula";
        } else {
            return "redirect:/login?error";
        }
    }
    @GetMapping("/raporOlustur.html")
    public String raporOlustur(Model model,HttpSession session)
    {
        String loggedInPersonelNameSurname = (String) session.getAttribute("loggedInPersonelNameSurname");

        if (loggedInPersonelNameSurname != null) {
            Personel foundPersonel = personelService.findByPersonelNameSurname(loggedInPersonelNameSurname);
            model.addAttribute("personelRank",foundPersonel.getPersonelRank());
            model.addAttribute("personelNameSurname", loggedInPersonelNameSurname);
            model.addAttribute("clinicName", foundPersonel.getClinic().getClinicName()); // clinicId'yi model'e ekle
            return "raporOlustur";
        } else {
            return "redirect:/login?error";
        }
    }
    @GetMapping("/receteSorgula.html")
    public String receteSorgula(Model model,HttpSession session)
    {
        String loggedInPersonelNameSurname = (String) session.getAttribute("loggedInPersonelNameSurname");

        if (loggedInPersonelNameSurname != null) {
            Personel foundPersonel = personelService.findByPersonelNameSurname(loggedInPersonelNameSurname);
            model.addAttribute("personelRank",foundPersonel.getPersonelRank());
            model.addAttribute("personelNameSurname", loggedInPersonelNameSurname);
            model.addAttribute("clinicName", foundPersonel.getClinic().getClinicName()); // clinicId'yi model'e ekle
            return "receteSorgula";
        } else {
            return "redirect:/login?error";
        }
    }
    @GetMapping("/raporSorgula.html")
    public String raporSorgula(Model model,HttpSession session)
    {
        String loggedInPersonelNameSurname = (String) session.getAttribute("loggedInPersonelNameSurname");

        if (loggedInPersonelNameSurname != null) {
            Personel foundPersonel = personelService.findByPersonelNameSurname(loggedInPersonelNameSurname);
            model.addAttribute("personelRank",foundPersonel.getPersonelRank());
            model.addAttribute("personelNameSurname", loggedInPersonelNameSurname);
            model.addAttribute("clinicName", foundPersonel.getClinic().getClinicName()); // clinicId'yi model'e ekle
            return "raporSorgula";
        } else {
            return "redirect:/login?error";
        }
    }
    @GetMapping("/randevuAl.html")
    public String randevuAl(Model model,HttpSession session)
    {
        String loggedInPersonelNameSurname = (String) session.getAttribute("loggedInPersonelNameSurname");

        if (loggedInPersonelNameSurname != null) {
            Personel foundPersonel = personelService.findByPersonelNameSurname(loggedInPersonelNameSurname);
            model.addAttribute("personelRank",foundPersonel.getPersonelRank());
            model.addAttribute("personelNameSurname", loggedInPersonelNameSurname);
            model.addAttribute("clinicName", foundPersonel.getClinic().getClinicName()); // clinicId'yi model'e ekle
            return "randevuAl";
        } else {
            return "redirect:/login?error";
        }
    }
}