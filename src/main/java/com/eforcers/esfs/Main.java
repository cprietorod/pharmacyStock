package com.eforcers.esfs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.eforcers.esfs.gui.MainScreen;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Main {
	@Autowired
	private MainScreen frame;

	public static void main(String[] args) {
		new SpringApplicationBuilder(Main.class)
        .headless(false)
        .web(false)
        .run(args);	
	}

	public MainScreen getFrame() {
		return frame;
	}
}
