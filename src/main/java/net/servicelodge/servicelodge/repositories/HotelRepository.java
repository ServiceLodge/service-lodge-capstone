package net.servicelodge.servicelodge.repositories;

import net.servicelodge.servicelodge.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}