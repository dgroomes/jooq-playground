/*
 * This file is generated by jOOQ.
 */
package dgroomes.db;


import dgroomes.db.tables.Observations;
import dgroomes.db.tables.records.ObservationsRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in the
 * default schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ObservationsRecord> OBSERVATIONS__PK_OBSERVATIONS = Internal.createUniqueKey(Observations.OBSERVATIONS, DSL.name("pk_observations"), new TableField[] { Observations.OBSERVATIONS.ID }, true);
}
