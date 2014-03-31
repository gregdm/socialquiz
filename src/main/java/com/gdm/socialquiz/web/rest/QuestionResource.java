package com.gdm.socialquiz.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.gdm.socialquiz.domain.Question;
import com.gdm.socialquiz.domain.Statement;
import com.gdm.socialquiz.repository.QuestionRepository;
import com.gdm.socialquiz.repository.StatementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * REST controller for managing Question.
 */
@RestController
@RequestMapping("/app")
public class QuestionResource {

    private final Logger log = LoggerFactory.getLogger(QuestionResource.class);

    @Inject
    private QuestionRepository questionRepository;

    @Inject
    private StatementRepository statementRepository;

    /**
     * POST  /rest/questions -> Create a new question.
     */
    @RequestMapping(value = "/rest/questions",
            method = RequestMethod.POST,
            produces = "application/json")
    @Timed
    public void create(@RequestBody Question question) {
        log.debug("REST request to save Question : {}", question);
        //A regarder, mettre en mode debug regarder le parcours du statement
        question.setStatement(statementRepository.saveAndFlush(question.getStatement()));
        questionRepository.save(question);
    }

    /**
     * GET  /rest/questions -> get all the questions.
     */
    @RequestMapping(value = "/rest/questions",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public List<Question> getAll() {
        log.debug("REST request to get all Questions");
        return questionRepository.findAll();
    }

    /**
     * GET  /rest/questions/:id -> get the "id" question.
     */
    @RequestMapping(value = "/rest/questions/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public Question get(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to get Question : {}", id);
        Question question = questionRepository.findOne(id);
        if (question == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return question;
    }

    /**
     * DELETE  /rest/questions/:id -> delete the "id" question.
     */
    @RequestMapping(value = "/rest/questions/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    @Timed
    public void delete(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to delete Question : {}", id);
        questionRepository.delete(id);
    }
}
