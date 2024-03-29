package com.mitienda.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.mitienda.spring.menus.MenuController;

@SpringBootApplication

public class StartApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	@Override
	public void run(String... args) {
		/*
		 * log.info("StartApplication...");
		 * 
		 * repository.save(new Categorias("Java")); repository.save(new
		 * Categorias("Node")); repository.save(new Categorias("Python"));
		 * 
		 * System.out.println("\nfindAll()"); repository.findAll().forEach(x ->
		 * System.out.println(x));
		 * 
		 * System.out.println("\nfindById(1L)"); repository.findById(1l).ifPresent(x ->
		 * System.out.println(x));
		 * 
		 * System.out.println("\nfindByName('Node')");
		 * repository.findByName("Node").forEach(x -> System.out.println(x));
		 */

		MenuController.getInstance().callMenus();

	}

}