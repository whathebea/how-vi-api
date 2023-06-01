package dev.beagracia.handsonwork_imobiliaria.ImobiliariaAPI.domain.service;

import dev.beagracia.handsonwork_imobiliaria.ImobiliariaAPI.domain.Property;
import dev.beagracia.handsonwork_imobiliaria.ImobiliariaAPI.domain.repository.PropertyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceImplTest {

    @Mock
    private PropertyRepository propertyRepository;

    @InjectMocks
    private PropertyServiceImpl propertyService;

    @Test
    public void testAddNewProperty() {
        Property property = new Property();
        property.setTitle("Teste");
        property.setDescription("Teste");

        Mockito.when(propertyRepository.save(Mockito.any(Property.class))).thenReturn(property);

        Property result = propertyService.addNewProperty(property);

        assertEquals(property, result);
        Mockito.verify(propertyRepository, Mockito.times(1)).save(property);
    }

    @Test
    public void testUpdateProperty() {
        Property existingProperty = new Property();
        existingProperty.setId(1L);
        existingProperty.setTitle("Teste");
        existingProperty.setDescription("Teste");

        Property newProperty = new Property();
        newProperty.setId(1L);
        newProperty.setTitle("Teste");
        newProperty.setDescription("Teste");

        Mockito.when(propertyRepository.findById(1L)).thenReturn(Optional.of(existingProperty));
        Mockito.when(propertyRepository.save(Mockito.any(Property.class))).thenReturn(newProperty);

        Property result = propertyService.updateProperty(newProperty);

        assertEquals(newProperty.getTitle(), result.getTitle());
        assertEquals(newProperty.getDescription(), result.getDescription());
        Mockito.verify(propertyRepository, Mockito.times(1)).findById(1L);
        Mockito.verify(propertyRepository, Mockito.times(1)).save(existingProperty);
    }

    @Test
    public void testGetPropertyById() {
        Property property = new Property();
        property.setId(1L);
        property.setTitle("Teste");
        property.setDescription("Teste");

        Mockito.when(propertyRepository.findById(1L)).thenReturn(Optional.of(property));

        Optional<Property> result = propertyService.getPropertyById(1L);

        assertTrue(result.isPresent());
        assertEquals(property, result.get());
        Mockito.verify(propertyRepository, Mockito.times(1)).findById(1L);
    }

    @Test
    public void testGetAllProperties() {
        Property property1 = new Property();
        property1.setId(1L);
        property1.setTitle("Teste 1");
        property1.setDescription("Teste 1");

        Property property2 = new Property();
        property2.setId(2L);
        property2.setTitle("Teste 2");
        property2.setDescription("Teste 2");

        List<Property> propertyList = Arrays.asList(property1, property2);

        Mockito.when(propertyRepository.findAll()).thenReturn(propertyList);

        List<Property> result = propertyService.getAllProperties();

        assertEquals(propertyList, result);
        Mockito.verify(propertyRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testDeleteProperty() {
        Long propertyId = 1L;

        propertyService.deleteProperty(propertyId);

        Mockito.verify(propertyRepository, Mockito.times(1)).deleteById(propertyId);
    }
}
