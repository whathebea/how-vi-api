package dev.beagracia.handsonwork_imobiliaria.ImobiliariaAPI.domain.service;

import dev.beagracia.handsonwork_imobiliaria.ImobiliariaAPI.domain.Property;

import java.util.List;
import java.util.Optional;

public interface PropertyService {

    Property addNewProperty(Property property);
    Property updateProperty(Property newProperty);

    Optional<Property> getPropertyById(Long propertyId);

    List<Property> getAllProperties();

    void deleteProperty(Long propertyId);
}
