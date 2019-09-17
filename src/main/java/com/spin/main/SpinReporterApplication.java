package com.spin.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.spin.main.controller.ImageController;
import com.spin.main.model.Image;

@SpringBootApplication(scanBasePackages = { "com.spin.main.model", "com.spin.main.responsemodel",
		"com.spin.main.repository", "com.spin.main.Config", "com.spin.main.controller",
		"com.spin.main.restApicontroller", "com.spin.main.service", "com.spin.main.dao", "com.spin.main.storage" })
@EnableConfigurationProperties(Image.class)
public class SpinReporterApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpinReporterApplication.class, args);

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// return super.configure(builder);
		return builder.sources(SpinReporterApplication.class);
	}

}
