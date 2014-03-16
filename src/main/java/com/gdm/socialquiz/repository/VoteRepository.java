package com.gdm.socialquiz.repository;

import com.gdm.socialquiz.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Vote entity.
 */
public interface VoteRepository extends JpaRepository<Vote, Long> {

}
