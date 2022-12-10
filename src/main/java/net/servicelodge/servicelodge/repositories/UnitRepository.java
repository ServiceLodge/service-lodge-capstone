package net.servicelodge.servicelodge.repositories;

import net.servicelodge.servicelodge.models.Reservation;
import net.servicelodge.servicelodge.models.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Long> {
    Unit findById(long id);
}
