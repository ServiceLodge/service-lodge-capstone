package net.servicelodge.servicelodge.repositories;

import net.servicelodge.servicelodge.models.Reservation;
import net.servicelodge.servicelodge.models.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnitRepository extends JpaRepository<Unit, Long> {
    Unit findById(long id);
    List<Unit> findByUnitName(String name);
}
