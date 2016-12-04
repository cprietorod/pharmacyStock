package com.eforcers.esfs.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;

import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@org.springframework.stereotype.Component
public class MainScreen extends JFrame implements CommandLineRunner{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbReports;
	private JLabel lbSales;
	private JPanel workPanel;
	
	@Autowired
	private SalesPanel salesPanel;
	
	@Autowired
	private ApplicationContext context;
	
	/**
	 * Create the frame.
	 */
	
	public MainScreen() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 537);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 204));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[220px][220px]", "[16px]"));
		
		JLabel lblNewLabel_3 = new JLabel("  Farmacia Los Cerezos");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Apple Color Emoji", Font.PLAIN, 16));
		lblNewLabel_3.setIcon(new ImageIcon(MainScreen.class.getResource("/statics/farmacia-logo2.jpg")));
		panel.add(lblNewLabel_3, "cell 0 0,grow");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 204));
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new MigLayout("", "[63px]", "[36px][36px][36px][36px][36px][36px][36px]"));
		
		lbSales = new JLabel("Ventas");
		lbSales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel newWorkPanel = salesPanel;
				setworkPanel(newWorkPanel);
			}
		});
		lbSales.setFont(new Font("Apple Color Emoji", Font.PLAIN, 13));
		lbSales.setForeground(new Color(255, 255, 255));
		lbSales.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(lbSales, "cell 0 0,grow");
		
		Component verticalGlue = Box.createVerticalGlue();
		panel_1.add(verticalGlue, "cell 0 1,grow");
		
		JLabel lbStock = new JLabel("Inventario");
		lbStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel newWorkPanel = new StockPanel();
				setworkPanel(newWorkPanel);
			}
		});
		lbStock.setFont(new Font("Apple Color Emoji", Font.PLAIN, 13));
		lbStock.setForeground(new Color(255, 255, 255));
		lbStock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(lbStock, "cell 0 2,grow");
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		panel_1.add(verticalGlue_1, "cell 0 3,grow");
		
		lbReports = new JLabel("Reportes");
		lbReports.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel newWorkPanel = new Report();
				setworkPanel(newWorkPanel);
			}
		});
		lbReports.setFont(new Font("Apple Color Emoji", Font.PLAIN, 13));
		lbReports.setForeground(new Color(255, 255, 255));
		lbReports.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(lbReports, "cell 0 4,grow");
		
		Component verticalGlue_3 = Box.createVerticalGlue();
		panel_1.add(verticalGlue_3, "cell 0 5,grow");
		
		workPanel = new JPanel();
		workPanel.setBackground(new Color(255, 255, 255));
		contentPane.add(workPanel, BorderLayout.CENTER);
	}
	
	private void setworkPanel(JPanel newComponent){
		contentPane.remove(workPanel);
		workPanel = newComponent;
		contentPane.add(workPanel, BorderLayout.CENTER);
		
		contentPane.revalidate();
		contentPane.repaint();
	}

	@Override
	public void run(String... args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	            	MainScreen frame = context.getBean(MainScreen.class);
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}

}
