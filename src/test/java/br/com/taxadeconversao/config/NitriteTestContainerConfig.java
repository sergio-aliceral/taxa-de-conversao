package br.com.taxadeconversao.config;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NitriteTestContainerConfig {

	static GenericContainer<?> nitriteContainer = 
				new GenericContainer<>(DockerImageName.parse("openjdk:21-jdk-slim"))
				.withExposedPorts(8080) // API rodando no container
				.withFileSystemBind("./target", "/app") // Monta o JAR e os dados do Nitrite
				.withCommand("java", "-jar", "/app/taxa-de-conversao-1.0.0-SNAPSHOT.jar");

	@BeforeAll
	static void startContainer() {
		nitriteContainer.start();
		System.setProperty(
					"TEST_NITRITE_DB",
					nitriteContainer.getContainerIpAddress() + ":" + nitriteContainer.getFirstMappedPort());
	}

	@Bean
	public GenericContainer<?> nitriteTestContainer() {
		return nitriteContainer;
	}
	
}
