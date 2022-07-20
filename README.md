# jooq-playground

📚 Learning and exploring jOOQ.

> jOOQ generates Java code from your database and lets you build type safe SQL queries through its fluent API.
>
> -- <cite>https://www.jooq.org/</cite>


## Description

I've done straight JDBC and Hibernate. I'd like to learn jOOQ. In fact, I'd like to learn the full range of effective
tools for interacting with a SQL database from a Java program. Depending on the use-case, one tool can be a more appropriate
than another. I'd like to learn the JPA/Hibernate Criteria API better too. 

**NOTE**: This project was developed on macOS. It is for my own personal use.


## Standalone sub-projects

This repository illustrates different concepts, patterns and examples via standalone sub-projects. Each sub-project is
completely independent of the others and do not depend on the root project. This _standalone sub-project constraint_
forces the sub-projects to be complete and maximizes the reader's chances of successfully running, understanding, and
re-using the code.

The sub-projects include:

### `basic/`

A basic demo of jOOQ complete with Gradle-based codegen.

See the README in [basic/](basic/).

### `joins/`

NOT YET IMPLEMENTED

An illustration of table joins in jOOQ.

See the README in [joins/](joins/).

## WishList

General clean-ups, TODOs and things I wish to implement for this project:

* [x] DONE Implement `basic/`
* [x] DONE (After some reading, jOOQ really wants you to use codegen. So, I think this is pre-requisite even for
      the basic project) Create a program that does the jOOQ codegen from a Gradle plugin. The [jOOQ docs say](https://www.jooq.org/doc/3.17/manual/getting-started/tutorials/jooq-in-7-steps/jooq-in-7-steps-step3/)
      to copy the jOOQ jars and the JDBC driver jar, but that's not trivial for a Gradle project. The idiomatic thing to
      do for a Gradle project is to create a Gradle plugin that depends on those artifacts (and thus, not code directly
      to jar files).
* [ ] IN PROGRESS Make an intermediate project. I want multiple tables, I want to join across the tables, I want the query to be
      dynamically created in a way that allows different joins to happen based on user input, I want about 1,000,000
      records and I want indexes on the tables.  
