plugins {
    `java-gradle-plugin`
}

gradlePlugin {
    plugins {
        create("jooqCodeGenPlugin") {
            id = "dgroomes.jooq-code-gen"
            implementationClass = "dgroomes.JooqCodeGenPlugin"
        }
    }
}

repositories {
    mavenCentral()
}

val jooqVersion = "3.17.2" // jOOQ releases: https://www.jooq.org/notes
val sqliteVersion = "3.36.0.3" // SQLite JDBC releases: https://github.com/xerial/sqlite-jdbc/releases

dependencies {
    implementation("org.jooq:jooq-codegen:$jooqVersion")
    implementation("org.xerial:sqlite-jdbc:$sqliteVersion")
}
