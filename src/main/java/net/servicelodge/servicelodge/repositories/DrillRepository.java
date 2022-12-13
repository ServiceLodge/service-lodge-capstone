package net.servicelodge.servicelodge.repositories;

import net.servicelodge.servicelodge.models.Drill;
import net.servicelodge.servicelodge.models.Reservation;
import net.servicelodge.servicelodge.models.User;
import net.servicelodge.servicelodge.models.Wing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrillRepository extends JpaRepository<Drill, Long> {
    List<Drill> findAllByWingId(long wing_id);

    Drill findByName(String name);
    Drill findById(long id);
}
