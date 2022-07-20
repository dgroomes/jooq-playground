package dgroomes;

import dgroomes.db.tables.daos.ObservationsDao;
import dgroomes.db.tables.pojos.Observations;
import org.jooq.Record;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static dgroomes.db.tables.Observations.OBSERVATIONS;

/**
 * A jOOQ example program. See the README for more information.
 */
public class App {

  private static final Logger log = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {
    // You will likely want to turn off the jOOQ startup-time logging.
    System.setProperty("org.jooq.no-logo", "true");
    System.setProperty("org.jooq.no-tips", "true");

    try (var connection = DriverManager.getConnection("jdbc:sqlite:observations.db"); var statement = connection.createStatement()) {

      queryViaDsl(connection);
      queryWithDao(connection);
    } catch (SQLException e) {
      log.error("Unexpected error while using the SQLite database", e);
    }
  }

  /**
   * Query the database using jOOQ's DSL (Domain Specific Language).
   */
  private static void queryViaDsl(Connection connection) {
    DSLContext create = DSL.using(connection, SQLDialect.MYSQL);
    Result<Record> result = create.select().from(OBSERVATIONS).fetch();

    log.info("[Query using DSL] Found results...");
    for (Record record : result) {
      int id = record.getValue(OBSERVATIONS.ID);
      String observation = record.getValue(OBSERVATIONS.OBSERVATION);
      log.info("{} {}", id, observation);
    }
    log.info("");
  }

  /**
   * Query the database using a jOOQ DAO (Data Access Object).
   */
  private static void queryWithDao(Connection connection) {
    Configuration configuration = new DefaultConfiguration().set(connection).set(SQLDialect.SQLITE);
    ObservationsDao dao = new ObservationsDao(configuration);
    List<Observations> observations = dao.findAll();

    log.info("[Query using DAO] Found results...");
    for (var observation : observations) {
      log.info("{}", observation);
    }
    log.info("");
  }
}
