package com.eddk.veterinaire_g10.controllers;
import com.eddk.veterinaire_g10.repositories.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.eddk.veterinaire_g10.models.Medicament;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/medicaments/")
public class MedicamentsController {
}
