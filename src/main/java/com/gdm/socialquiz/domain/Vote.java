package com.gdm.socialquiz.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateDeserializer;
import com.gdm.socialquiz.domain.util.CustomLocalDateSerializer;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * A Vote.
 */
@Entity
@Table(name = "T_VOTE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Vote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    private Integer difficulty;

    private Boolean up;

    @JsonIgnore
    @ManyToOne
    private Question question;

    @ManyToOne
    private User voting;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getVoting() {
        return voting;
    }

    public void setVoting(User voting) {
        this.voting = voting;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Boolean getUp() {
        return up;
    }

    public void setUp(Boolean up) {
        this.up = up;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vote vote = (Vote) o;

        if (id != vote.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                '}';
    }
}
