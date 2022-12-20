package net.servicelodge.servicelodge.repositories;

import net.servicelodge.servicelodge.models.Drill;
import net.servicelodge.servicelodge.models.Reservation;
import net.servicelodge.servicelodge.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByUser(User user);
    Reservation findFirstByDrillIdAndUser(long drill_id, User user);
    Reservation findById(long id);
    List<Reservation> findAllByDrillWingId(long wing_id);
}
