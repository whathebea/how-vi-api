package dev.beagracia.handsonwork_imobiliaria.ImobiliariaAPI.domain.repository;

import dev.beagracia.handsonwork_imobiliaria.ImobiliariaAPI.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
}
