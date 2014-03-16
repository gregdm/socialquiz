package com.gdm.socialquiz.repository;

import com.gdm.socialquiz.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Question entity.
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
