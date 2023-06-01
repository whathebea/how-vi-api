package dev.beagracia.handsonwork_imobiliaria.ImobiliariaAPI.application.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.beagracia.handsonwork_imobiliaria.ImobiliariaAPI.domain.Property;
import dev.beagracia.handsonwork_imobiliaria.ImobiliariaAPI.domain.PropertyType;
import dev.beagracia.handsonwork_imobiliaria.ImobiliariaAPI.domain.service.PropertyService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.RequestEntity.post;

@WebMvcTest(PropertyController.class)
class PropertyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PropertyService propertyService;

    @Test
    public void createProperty() throws Exception {
        Property property = new Property();
        Long id = 1L;
        String title = "Casa";
        String description = "Casa";
        String imgUrl = "sample-img.jpg";
        PropertyType propertyType = PropertyType.CASA;
        String area = "100 m";
        Long price = 100000L;
        int numberOfBedrooms = 3;
        int numberOfCarSpots = 2;
        int numberOfBathrooms = 2;
        property.setId(id);
        property.setTitle(title);
        property.setDescription(description);
        property.setImgUrl(imgUrl);
        property.setPropertyType(propertyType);
        property.setArea(area);
        property.setPrice(price);
        property.setNumberOfBedrooms(numberOfBedrooms);
        property.setNumberOfCarSpots(numberOfCarSpots);
        property.setNumberOfBathrooms(numberOfBathrooms);

        String propertyJson = objectMapper.writeValueAsString(property);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(propertyJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateProperty() throws Exception {
        Property property = new Property();
        Long id = 1L;
        String title = "Casa";
        String description = "Casa";
        String imgUrl = "sample-img.jpg";
        PropertyType propertyType = PropertyType.CASA;
        String area = "100 m";
        Long price = 100000L;
        int numberOfBedrooms = 3;
        int numberOfCarSpots = 2;
        int numberOfBathrooms = 2;
        property.setId(id);
        property.setTitle(title);
        property.setDescription(description);
        property.setImgUrl(imgUrl);
        property.setPropertyType(propertyType);
        property.setArea(area);
        property.setPrice(price);
        property.setNumberOfBedrooms(numberOfBedrooms);
        property.setNumberOfCarSpots(numberOfCarSpots);
        property.setNumberOfBathrooms(numberOfBathrooms);

        String propertyJson = objectMapper.writeValueAsString(property);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(propertyJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void testGetById() throws Exception {
        Property property = new Property();
        Long id = 1L;
        String title = "Casa";
        String description = "Casa";
        String imgUrl = "sample-img.jpg";
        PropertyType propertyType = PropertyType.CASA;
        String area = "100 m";
        Long price = 100000L;
        int numberOfBedrooms = 3;
        int numberOfCarSpots = 2;
        int numberOfBathrooms = 2;
        property.setId(id);
        property.setTitle(title);
        property.setDescription(description);
        property.setImgUrl(imgUrl);
        property.setPropertyType(propertyType);
        property.setArea(area);
        property.setPrice(price);
        property.setNumberOfBedrooms(numberOfBedrooms);
        property.setNumberOfCarSpots(numberOfCarSpots);
        property.setNumberOfBathrooms(numberOfBathrooms);



        Mockito.when(propertyService.getPropertyById(id)).thenReturn(Optional.of(property));


        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/view/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(id.intValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is(property.getTitle())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description", Matchers.is(property.getDescription())));

    }

    @Test
    public void testDeleteById() throws Exception {
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/{id}/delete", id))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(propertyService, Mockito.times(1)).deleteProperty(id);
    }
}