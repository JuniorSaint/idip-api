package com.idip.idiptecnologia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableCaching
@SpringBootApplication
@EntityScan(basePackages = { "com.idip.idiptecnologia.models.entities" })
@ComponentScan(basePackages = { "com.idip.idiptecnologia.controllers", "com.idip.idiptecnologia.services",
		"com.idip.idiptecnologia.configs", "com.idip.idiptecnologia.security", "com.idip.idiptecnologia.model.payload.request", "com.idip.idiptecnologia.model.payload.response" })
@EnableJpaRepositories(basePackages = { "com.idip.idiptecnologia.repositories" })
public class IdipTecnologiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdipTecnologiaApplication.class, args);
	}

}
