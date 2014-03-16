package com.gdm.socialquiz.repository;

import com.gdm.socialquiz.domain.Statement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Statement entity.
 */
public interface StatementRepository extends JpaRepository<Statement, Long> {

}
