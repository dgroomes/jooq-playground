/*
 * This file is generated by jOOQ.
 */
package dgroomes.db.tables.daos;


import dgroomes.db.tables.Observations;
import dgroomes.db.tables.records.ObservationsRecord;

import java.util.List;
import java.util.Optional;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ObservationsDao extends DAOImpl<ObservationsRecord, dgroomes.db.tables.pojos.Observations, Integer> {

    /**
     * Create a new ObservationsDao without any configuration
     */
    public ObservationsDao() {
        super(Observations.OBSERVATIONS, dgroomes.db.tables.pojos.Observations.class);
    }

    /**
     * Create a new ObservationsDao with an attached configuration
     */
    public ObservationsDao(Configuration configuration) {
        super(Observations.OBSERVATIONS, dgroomes.db.tables.pojos.Observations.class, configuration);
    }

    @Override
    public Integer getId(dgroomes.db.tables.pojos.Observations object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<dgroomes.db.tables.pojos.Observations> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Observations.OBSERVATIONS.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<dgroomes.db.tables.pojos.Observations> fetchById(Integer... values) {
        return fetch(Observations.OBSERVATIONS.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public dgroomes.db.tables.pojos.Observations fetchOneById(Integer value) {
        return fetchOne(Observations.OBSERVATIONS.ID, value);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public Optional<dgroomes.db.tables.pojos.Observations> fetchOptionalById(Integer value) {
        return fetchOptional(Observations.OBSERVATIONS.ID, value);
    }

    /**
     * Fetch records that have <code>observation BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<dgroomes.db.tables.pojos.Observations> fetchRangeOfObservation(String lowerInclusive, String upperInclusive) {
        return fetchRange(Observations.OBSERVATIONS.OBSERVATION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>observation IN (values)</code>
     */
    public List<dgroomes.db.tables.pojos.Observations> fetchByObservation(String... values) {
        return fetch(Observations.OBSERVATIONS.OBSERVATION, values);
    }
}