package net.servicelodge.servicelodge.repositories;

import net.servicelodge.servicelodge.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
