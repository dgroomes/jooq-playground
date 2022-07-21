# joins

NOT YET IMPLEMENTED

An illustration of table joins in jOOQ.


## Description

How do you do joins in jOOQ? It's one thing to express a join query, but it's another to map the result data into a
convenient shape. For example, with JPA, given an instance of type `A`, you can access this object's collection of instances
of type `B` with a method like `@OneToMany public List<B> getBs()`. What does jOOQ offer in this regard?     

Note: This project features most of the same boilerplate as the `basic/` sub-project.


## Instructions

Follow these instructions to setup the database, and build and run the program:

1. Initialize a SQLite db with the schema and sample data:
   * ```shell
     sqlite3 observations.db < schema/1-observations-schema.sql
     sqlite3 observations.db < schema/2-observations-data.sql
     ```
2. Optionally, re-generate the Java database classes:
    * ```shell
      ./gradlew jooqCodeGen
      ```
3. Use Java 17
4. Run the program:
   * ```shell
     ./gradlew run
     ```
   * Altogether, it should look like this:
     ```text
     todo
     ```


## Reference

* [SQLite foreign key support](https://www.sqlite.org/foreignkeys.html)
  * Interestingly, SQLite does not enable foreign key support by default.
* [`sqlite-jdbc` config](https://github.com/xerial/sqlite-jdbc/blob/master/Usage.md)
