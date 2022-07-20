# basic

A basic demo of jOOQ complete with Gradle-based codegen.


## Description

To exercise the jOOQ library, we need a database. This project uses a SQLite database.


## Instructions

These are the instructions for building and running the demo. Note that an idiomatic usage of jOOQ is to use codegen to
generate Java source that's modeled after the SQL tables. I've chosen to commit these generated files into version control.
If you add, remove or change the SQL schema then you will need to re-generate the code. Use the following command:

```shell
./gradlew jooqCodeGen
```

Follow these instructions to build and run the program:

1. Initialize a SQLite db with the schema and sample data:
   * ```shell
     sqlite3 observations.db < schema/1-observations-schema.sql
     sqlite3 observations.db < schema/2-observations-data.sql
     ```
3. Use Java 17
4. Run the program:
   * ```shell
     ./gradlew run
     ```
   * Altogether, it should look like this:
     ```text
     23:05:03 [main] INFO dgroomes.App - [Query using DSL] Found results...
     23:05:03 [main] INFO dgroomes.App - 1 The sky is blue
     23:05:03 [main] INFO dgroomes.App - 2 The speed of light can circle the earth 7 times in a second
     23:05:03 [main] INFO dgroomes.App -
     23:05:03 [main] INFO dgroomes.App - [Query using DAO] Found results...
     23:05:03 [main] INFO dgroomes.App - Observations (1, The sky is blue)
     23:05:03 [main] INFO dgroomes.App - Observations (2, The speed of light can circle the earth 7 times in a second)
     23:05:03 [main] INFO dgroomes.App -
     ```


## Reference

* [`xerial/sqlite-jdbc`: JDBC driver for SQLite](https://github.com/xerial/sqlite-jdbc)
* [jOOQ docs](https://www.jooq.org/doc/3.17/manual/)
