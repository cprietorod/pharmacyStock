package com.eforcers.esfs;

import java.awt.EventQueue;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.eforcers.esfs.gui.MainScreen;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Main.class)
        .headless(false)
        .web(false)
        .run(args);
	}
	
	public Main(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	
}
