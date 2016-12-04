package com.eforcers.esfs.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTable;

public class SalesPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public SalesPanel() {
		setLayout(new MigLayout("", "[307.00px][226px]", "[299px]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[][][]", "[][]"));
		panel.setLayout(new MigLayout("", "[1px]", "[1px]"));
		
		JButton btnProducto = new JButton("Producto 1");
		panel.add(btnProducto, "cell 0 0,grow");
		
		JButton btnProducto_1 = new JButton("Producto2");
		panel.add(btnProducto_1, "cell 0 0,grow");
		
		JButton btnProducto_2 = new JButton("Producto 3");
		panel.add(btnProducto_2, "cell 0 0,grow");
		
		JButton btnProducto_3 = new JButton("Producto 4");
		panel.add(btnProducto_3, "cell 0 0,grow");
		
		JButton btnProducto_4 = new JButton("Producto 5");
		panel.add(btnProducto_4, "cell 0 0,grow");
		
		JButton btnProducto_5 = new JButton("Producto 6");
		panel.add(btnProducto_5, "cell 0 0,grow");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 1 0,grow");
		
		table = new JTable();
		panel_1.add(table);

	}

}
