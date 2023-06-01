package dev.beagracia.handsonwork_imobiliaria.ImobiliariaAPI.domain.service;

import dev.beagracia.handsonwork_imobiliaria.ImobiliariaAPI.domain.Property;
import dev.beagracia.handsonwork_imobiliaria.ImobiliariaAPI.domain.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService{
    @Autowired
    private final PropertyRepository repository;

    @Override
    public Property addNewProperty(Property property) {
        return repository.save(property);
    }

    @Override
    public Property updateProperty(Property newProperty) {
        Property existingProperty = repository.findById(newProperty.getId())
                .orElseThrow(() -> new IllegalArgumentException("Property not found"));
        existingProperty.setTitle(newProperty.getTitle());
        existingProperty.setDescription(newProperty.getDescription());
        existingProperty.setImgUrl(newProperty.getImgUrl());
        existingProperty.setPropertyType(newProperty.getPropertyType());
        existingProperty.setArea(newProperty.getArea());
        existingProperty.setPrice(newProperty.getPrice());
        existingProperty.setNumberOfBathrooms(newProperty.getNumberOfBathrooms());
        existingProperty.setNumberOfBedrooms(newProperty.getNumberOfBedrooms());
        existingProperty.setNumberOfCarSpots(newProperty.getNumberOfCarSpots());
        return repository.save(existingProperty);
    }

    @Override
    public Optional<Property> getPropertyById(Long propertyId) {
        return repository.findById(propertyId);
    }

    @Override
    public List<Property> getAllProperties() {
        return repository.findAll();
    }

    @Override
    public void deleteProperty(Long propertyId) {
        repository.deleteById(propertyId);
    }
}
