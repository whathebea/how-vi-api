package dev.beagracia.handsonwork_imobiliaria.ImobiliariaAPI.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {
    @Test
    public void testConstructorAndGetters() {
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

        Property property = new Property(id, title, description, imgUrl, propertyType, area, price,
                numberOfBedrooms, numberOfCarSpots, numberOfBathrooms);

        assertEquals(id, property.getId());
        assertEquals(title, property.getTitle());
        assertEquals(description, property.getDescription());
        assertEquals(imgUrl, property.getImgUrl());
        assertEquals(propertyType, property.getPropertyType());
        assertEquals(area, property.getArea());
        assertEquals(price, property.getPrice());
        assertEquals(numberOfBedrooms, property.getNumberOfBedrooms());
        assertEquals(numberOfCarSpots, property.getNumberOfCarSpots());
        assertEquals(numberOfBathrooms, property.getNumberOfBathrooms());
    }

    @Test
    public void testSetterAndGetters() {
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

        assertEquals(id, property.getId());
        assertEquals(title, property.getTitle());
        assertEquals(description, property.getDescription());
        assertEquals(imgUrl, property.getImgUrl());
        assertEquals(propertyType, property.getPropertyType());
        assertEquals(area, property.getArea());
        assertEquals(price, property.getPrice());
        assertEquals(numberOfBedrooms, property.getNumberOfBedrooms());
        assertEquals(numberOfCarSpots, property.getNumberOfCarSpots());
        assertEquals(numberOfBathrooms, property.getNumberOfBathrooms());
    }
}