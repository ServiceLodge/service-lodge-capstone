package net.servicelodge.servicelodge.repositories;

import net.servicelodge.servicelodge.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
