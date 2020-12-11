package com.eddk.veterinaire_g10.controllers;

import com.eddk.veterinaire_g10.models.Medicament;
import com.eddk.veterinaire_g10.models.Prescription;
import com.eddk.veterinaire_g10.repositories.PrescriptionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/prescriptions/")
public class PrescriptionsController {
}
