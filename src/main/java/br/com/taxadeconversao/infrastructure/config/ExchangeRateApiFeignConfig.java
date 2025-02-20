package br.com.taxadeconversao.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class ExchangeRateApiFeignConfig {

	@Value("${exchangerate.token}")
	private String token;

	@Bean
	RequestInterceptor requestInterceptor() {
		return template -> template.header("Authorization", "Bearer " + token);
	}

}
