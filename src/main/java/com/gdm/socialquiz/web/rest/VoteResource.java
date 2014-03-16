package com.gdm.socialquiz.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.gdm.socialquiz.domain.Vote;
import com.gdm.socialquiz.repository.VoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * REST controller for managing Vote.
 */
@RestController
@RequestMapping("/app")
public class VoteResource {

    private final Logger log = LoggerFactory.getLogger(VoteResource.class);

    @Inject
    private VoteRepository voteRepository;

    /**
     * POST  /rest/votes -> Create a new vote.
     */
    @RequestMapping(value = "/rest/votes",
            method = RequestMethod.POST,
            produces = "application/json")
    @Timed
    public void create(@RequestBody Vote vote) {
        log.debug("REST request to save Vote : {}", vote);
        voteRepository.save(vote);
    }

    /**
     * GET  /rest/votes -> get all the votes.
     */
    @RequestMapping(value = "/rest/votes",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public List<Vote> getAll() {
        log.debug("REST request to get all Votes");
        return voteRepository.findAll();
    }

    /**
     * GET  /rest/votes/:id -> get the "id" vote.
     */
    @RequestMapping(value = "/rest/votes/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public Vote get(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to get Vote : {}", id);
        Vote vote = voteRepository.findOne(id);
        if (vote == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return vote;
    }

    /**
     * DELETE  /rest/votes/:id -> delete the "id" vote.
     */
    @RequestMapping(value = "/rest/votes/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    @Timed
    public void delete(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to delete Vote : {}", id);
        voteRepository.delete(id);
    }
}
