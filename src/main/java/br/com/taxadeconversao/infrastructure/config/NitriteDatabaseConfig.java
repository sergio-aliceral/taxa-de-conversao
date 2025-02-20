package br.com.taxadeconversao.infrastructure.config;

import org.dizitart.no2.Nitrite;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NitriteDatabaseConfig {

	private static Nitrite databaseInstance;

	@Bean
	Nitrite nitriteDatabase() {
		if (databaseInstance == null) {
			databaseInstance = Nitrite.builder().compressed().filePath("database.db").openOrCreate();
		}
		return databaseInstance;
	}

}
