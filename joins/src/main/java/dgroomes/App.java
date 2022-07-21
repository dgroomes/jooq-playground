package dgroomes;

import dgroomes.db.tables.daos.ObservationsDao;
import dgroomes.db.tables.pojos.Observations;
import org.jooq.Record;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static dgroomes.db.tables.Observations.OBSERVATIONS;

/**
 * A jOOQ example program. See the README for more information.
 */
public class App {

  private static final Logger log = LoggerFactory.getLogger(App.class);
  public static final String JDBC_URL = "jdbc:sqlite:observations.db";

  public static void main(String[] args) {
    // You will likely want to turn off the jOOQ startup-time logging.
    System.setProperty("org.jooq.no-logo", "true");
    System.setProperty("org.jooq.no-tips", "true");

    try (var connection = getConnection()) {

      queryViaDsl(connection);
      queryWithDao(connection);
    } catch (SQLException e) {
      log.error("Unexpected error while using the SQLite database", e);
    }
  }

  private static Connection getConnection() throws SQLException {
    var config = new SQLiteConfig();
    config.enforceForeignKeys(true);

    Properties properties = config.toProperties();

    return DriverManager.getConnection(JDBC_URL, properties);
  }

  /**
   * Query the database using jOOQ's DSL (Domain Specific Language).
   */
  private static void queryViaDsl(Connection connection) {
    DSLContext create = DSL.using(connection, SQLDialect.MYSQL);
    Result<Record> result = create.select(OBSERVATIONS.asterisk(), OBSERVATIONS.observationTypes().asterisk())
            .from(OBSERVATIONS)
            .fetch();

    log.info("[Query using DSL] Found results...");
    for (Record record : result) {
      int id = record.getValue(OBSERVATIONS.ID);
      String observation = record.getValue(OBSERVATIONS.OBSERVATION);
      String type = record.getValue(OBSERVATIONS.observationTypes().DESCRIPTION);
      log.info("id={} observation='{}' type='{}'", id, observation, type);
    }
    log.info("");
  }

  /**
   * Query the database using a jOOQ DAO (Data Access Object).
   *
   * It is not possible to use jOOQ's DAO for fetching an object graph. That's just not a feature of jOOQ. Instead, use
   * the jOOQ DSL.
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
