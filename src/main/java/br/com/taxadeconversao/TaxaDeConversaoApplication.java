package br.com.taxadeconversao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TaxaDeConversaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxaDeConversaoApplication.class, args);
	}

}
