package net.servicelodge.servicelodge.repositories;

import net.servicelodge.servicelodge.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
