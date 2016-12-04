package com.eforcers.esfs.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalesPanel extends JPanel {
	private JTable table;
	private JTable table_1;
	private DefaultTableModel model;
	private Vector<Vector<Object>> vectorModel;

	/**
	 * Create the panel.
	 */
	public SalesPanel() {
		setLayout(new MigLayout("", "[410.00,grow][grow]", "[grow]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[][][]", "[][]"));
		
		JButton btnProducto = new JButton("Producto 1");
		btnProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct(btnProducto.getText());
			}
		});
		panel.add(btnProducto, "cell 0 0");
		
		JButton btnProducto_1 = new JButton("Producto 2");
		btnProducto_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct(btnProducto_1.getText());
			}
		});
		panel.add(btnProducto_1, "cell 1 0");
		
		JButton btnProducto_2 = new JButton("Producto 3");
		btnProducto_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct(btnProducto_2.getText());
			}
		});
		panel.add(btnProducto_2, "cell 2 0");
		
		JButton btnProducto_3 = new JButton("Producto 4");
		btnProducto_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct(btnProducto_3.getText());
			}
		});
		panel.add(btnProducto_3, "cell 0 1");
		
		JButton btnProducto_4 = new JButton("Producto 5");
		btnProducto_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct(btnProducto_4.getText());
			}
		});
		panel.add(btnProducto_4, "cell 1 1");
		
		JButton btnProducto_5 = new JButton("Producto 6");
		btnProducto_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct(btnProducto_5.getText());
			}
		});
		panel.add(btnProducto_5, "cell 2 1");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 1 0,grow");
		panel_1.setLayout(new BorderLayout(0, 0));
		
		Vector<Object> columnNames = new Vector<Object>();
		columnNames.add("Producto");
		columnNames.add("Cantidad");
		
		vectorModel = new Vector<>();
		
		model = new DefaultTableModel(vectorModel, columnNames);
		
		table_1 = new JTable();
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setRowSelectionAllowed(false);
		table_1.setModel(model);
		
		Object rowData[] = { "Producto", "Cantidad"};
		model.addRow(rowData);
		
		panel_1.add(table_1, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Vender");
		panel_1.add(btnNewButton, BorderLayout.SOUTH);

	}
	
	private void addProduct(String productName){
		int vectorIndex = 0;
		Vector<Object> vectorRow = null;
		for(Vector<Object> element : vectorModel){
			if(element.get(1) instanceof String) continue;
			
			String element_name = (String) element.get(0);
			Integer element_amount = (Integer) element.get(1);
			
			if(element_name.equals(productName)){
				element_amount ++;
				element.add(1, element_amount);
				vectorRow = element;
				break;
			}
			vectorIndex ++;
			
		}
		
		if(vectorRow == null){
			vectorRow = new Vector<Object>();
			vectorRow.addElement(productName);
			vectorRow.addElement(1);
		}else{
			vectorModel.remove(vectorIndex);
		}
		
		vectorModel.add(vectorIndex,vectorRow);
		
		table_1.revalidate();
		table_1.repaint();
	}

}
