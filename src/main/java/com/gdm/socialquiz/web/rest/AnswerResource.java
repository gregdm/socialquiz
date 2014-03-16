package com.gdm.socialquiz.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.gdm.socialquiz.domain.Answer;
import com.gdm.socialquiz.repository.AnswerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * REST controller for managing Answer.
 */
@RestController
@RequestMapping("/app")
public class AnswerResource {

    private final Logger log = LoggerFactory.getLogger(AnswerResource.class);

    @Inject
    private AnswerRepository answerRepository;

    /**
     * POST  /rest/answers -> Create a new answer.
     */
    @RequestMapping(value = "/rest/answers",
            method = RequestMethod.POST,
            produces = "application/json")
    @Timed
    public void create(@RequestBody Answer answer) {
        log.debug("REST request to save Answer : {}", answer);
        answerRepository.save(answer);
    }

    /**
     * GET  /rest/answers -> get all the answers.
     */
    @RequestMapping(value = "/rest/answers",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public List<Answer> getAll() {
        log.debug("REST request to get all Answers");
        return answerRepository.findAll();
    }

    /**
     * GET  /rest/answers/:id -> get the "id" answer.
     */
    @RequestMapping(value = "/rest/answers/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public Answer get(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to get Answer : {}", id);
        Answer answer = answerRepository.findOne(id);
        if (answer == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return answer;
    }

    /**
     * DELETE  /rest/answers/:id -> delete the "id" answer.
     */
    @RequestMapping(value = "/rest/answers/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    @Timed
    public void delete(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to delete Answer : {}", id);
        answerRepository.delete(id);
    }
}
