package org.example.util;

import org.flywaydb.core.Flyway;

public class FlywayMigration {

    public static void migrate() {

        Flyway.configure()
                .dataSource(
                        "jdbc:h2:./testdb",
                        "sa",
                        ""
                )
                .locations("classpath:db/migration")
                .load()
                .migrate();
    }
}