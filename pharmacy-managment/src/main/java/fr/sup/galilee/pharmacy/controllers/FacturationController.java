package fr.sup.galilee.pharmacy.controllers;

import fr.sup.galilee.pharmacy.entities.Bill;
import fr.sup.galilee.pharmacy.service.FacturationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/facturation")
public class FacturationController {

    @Autowired
    private FacturationService facturationService;

    @PostMapping("/creer")
    public ResponseEntity<Bill> createFacture(@RequestParam float total, @RequestParam Long userId) {
        Bill bill = facturationService.createFacture(total, userId);
        return new ResponseEntity<>(bill, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getFacture(@PathVariable("id") Long id) {
        Bill bill = facturationService.getFacture(id);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

}
