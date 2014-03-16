package com.gdm.socialquiz.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.gdm.socialquiz.domain.Statement;
import com.gdm.socialquiz.repository.StatementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * REST controller for managing Statement.
 */
@RestController
@RequestMapping("/app")
public class StatementResource {

    private final Logger log = LoggerFactory.getLogger(StatementResource.class);

    @Inject
    private StatementRepository statementRepository;

    /**
     * POST  /rest/statements -> Create a new statement.
     */
    @RequestMapping(value = "/rest/statements",
            method = RequestMethod.POST,
            produces = "application/json")
    @Timed
    public void create(@RequestBody Statement statement) {
        log.debug("REST request to save Statement : {}", statement);
        statementRepository.save(statement);
    }

    /**
     * GET  /rest/statements -> get all the statements.
     */
    @RequestMapping(value = "/rest/statements",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public List<Statement> getAll() {
        log.debug("REST request to get all Statements");
        return statementRepository.findAll();
    }

    /**
     * GET  /rest/statements/:id -> get the "id" statement.
     */
    @RequestMapping(value = "/rest/statements/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public Statement get(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to get Statement : {}", id);
        Statement statement = statementRepository.findOne(id);
        if (statement == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return statement;
    }

    /**
     * DELETE  /rest/statements/:id -> delete the "id" statement.
     */
    @RequestMapping(value = "/rest/statements/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    @Timed
    public void delete(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to delete Statement : {}", id);
        statementRepository.delete(id);
    }
}
