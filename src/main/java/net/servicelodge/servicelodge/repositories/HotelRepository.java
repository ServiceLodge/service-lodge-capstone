package net.servicelodge.servicelodge.repositories;

import net.servicelodge.servicelodge.models.Hotel;
import net.servicelodge.servicelodge.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findAllByState(String state);
}
