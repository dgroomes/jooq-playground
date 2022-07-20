package dgroomes;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * A custom Gradle plugin for jOOQ codegen.
 *
 * This plugin registers the task "jooqCodeGen" to execute jOOQ's codegen library to generate Java source code based on
 * the SQL table definitions. Read about jOOQ codegen here: https://www.jooq.org/doc/3.17/manual/code-generation/
 *
 * Note that there is a popular open source Gradle plugin to do jOOQ code generation. It's called 'gradle-jooq-plugin'.
 * See the source code here: https://github.com/etiennestuder/gradle-jooq-plugin/tree/master/example
 * The 'gradle-jooq-plugin' is not maintained by the jOOQ project.
 */
public class JooqCodeGenPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.getTasks().register("jooqCodeGen", JooqCodeGenTask.class);
    }
}
