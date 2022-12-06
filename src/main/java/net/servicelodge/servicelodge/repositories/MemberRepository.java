package net.servicelodge.servicelodge.repositories;

import net.servicelodge.servicelodge.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
