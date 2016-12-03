package com.eforcers.esfs;

import java.awt.EventQueue;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.eforcers.esfs.gui.MainScreen;

@SpringBootApplication
public class EforcersStockFarmacySystemApplication {

	public static void main(String[] args) {
		//SpringApplication.run(EforcersStockFarmacySystemApplication.class, args);
		new SpringApplicationBuilder(EforcersStockFarmacySystemApplication.class)
        .headless(false)
        .web(false)
        .run(args);
	}
	
	public EforcersStockFarmacySystemApplication(){
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
