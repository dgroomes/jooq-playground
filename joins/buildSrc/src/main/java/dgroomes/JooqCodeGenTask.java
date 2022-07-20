package dgroomes;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Use jOOQ's codegen library to generate Java source code based on the SQL table definitions.
 */
public class JooqCodeGenTask extends DefaultTask {

  private static final Logger log = LoggerFactory.getLogger(JooqCodeGenTask.class);

  /**
   * Run the code gen
   *
   * @throws IOException
   */
  @TaskAction
  public void codeGen() throws IOException {
    try {
      doCodeGen();
    } catch (Exception e) {
      throw new IllegalStateException("Unexpected exception performing jOOQ codegen. Check the configuration.", e);
    }
  }

  private void doCodeGen() throws Exception {
    Path projectDir = getProject().getProjectDir().toPath();
    Path dbFileUrl = projectDir.resolve("observations.db");
    String jdbcUrl = "jdbc:sqlite:%s".formatted(dbFileUrl);
    log.info("jOOQ codegen: The JDBC url is '{}'", jdbcUrl);

    String javaSrc = projectDir.resolve("src/main/java").toString();
    log.info("jOOQ codegen: The Java classes will be generated to '{}'", javaSrc);

    GenerationTool.generate(new Configuration()
            .withJdbc(new Jdbc()
                    .withDriver("org.sqlite.JDBC")
                    .withUrl(jdbcUrl))
            .withGenerator(new Generator()
                    .withDatabase(new Database())
                    .withGenerate(new Generate()
                            .withPojos(true)
                            .withDaos(true))
                    .withTarget(new Target()
                            .withPackageName("dgroomes.db")
                            .withDirectory(javaSrc))));
  }
}
