package dev.beagracia.handsonwork_imobiliaria.ImobiliariaAPI.application.controller;

import dev.beagracia.handsonwork_imobiliaria.ImobiliariaAPI.domain.Property;
import dev.beagracia.handsonwork_imobiliaria.ImobiliariaAPI.domain.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired
    private final PropertyService service;

    @PostMapping("/create")
    public Property addNewProperty(@RequestBody Property property) {
        return service.addNewProperty(property);
    }

    @PutMapping("/update")
    public Property updateProperty(@RequestBody Property property) {
        return service.updateProperty(property);
    }

    @GetMapping("/view/{id}")
    public Optional<Property> getById(@PathVariable Long id) {
        return service.getPropertyById(id);
    }

    @GetMapping("/view")
    public List<Property> getAll() {
        return service.getAllProperties();
    }

    @DeleteMapping("/{id}/delete")
    public void deleteById(@PathVariable Long id) {
        service.deleteProperty(id);
    }
}
