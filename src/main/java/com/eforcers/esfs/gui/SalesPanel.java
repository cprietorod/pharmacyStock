package com.eforcers.esfs.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eforcers.esfs.dao.ProductsDAO;
import com.eforcers.esfs.models.Product;

import java.util.List;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;

@Component
public class SalesPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private Vector<Vector<Object>> vectorModel;
	private JLabel labelPrice;
	
	
	/**
	 * Create the panel.
	 */
	@Autowired
	public SalesPanel(ProductsDAO productsDAO) {
		setForeground(new Color(255, 69, 0));
		setLayout(new MigLayout("", "[410.00,grow][grow]", "[][grow][]"));
		
		JLabel lblSdf = new JLabel("");
		lblSdf.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblSdf.setForeground(new Color(255, 69, 0));
		add(lblSdf, "cell 0 0");
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[grow][grow][grow]", "[][80.00]"));
		
		List<Product> products = (List<Product>) productsDAO.findAll();
		
		JPanel panel_2 = new JPanel();
		panel_2.setSize(new Dimension(0, 50));
		panel.add(panel_2, "cell 0 0,grow");
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblprod1 = new JLabel(products.get(0).getName());
		GridBagConstraints gbc_lblprod1 = new GridBagConstraints();
		gbc_lblprod1.gridwidth = 2;
		gbc_lblprod1.insets = new Insets(0, 0, 5, 0);
		gbc_lblprod1.gridx = 0;
		gbc_lblprod1.gridy = 0;
		panel_2.add(lblprod1, gbc_lblprod1);
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct(products.get(0));
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panel_2.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("-");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeProduct(products.get(0));
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 1;
		panel_2.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JPanel lblprod2 = new JPanel();
		panel.add(lblprod2, "cell 1 0,grow");
		GridBagLayout gbl_lblprod2 = new GridBagLayout();
		gbl_lblprod2.columnWidths = new int[]{0, 0, 0};
		gbl_lblprod2.rowHeights = new int[]{0, 0, 0};
		gbl_lblprod2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_lblprod2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		lblprod2.setLayout(gbl_lblprod2);
		
		JLabel label = new JLabel(products.get(1).getName());
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 2;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		lblprod2.add(label, gbc_label);
		
		JButton btnNewButton_3 = new JButton("+");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct(products.get(1));
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 1;
		lblprod2.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("-");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeProduct(products.get(1));
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 1;
		lblprod2.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, "cell 2 0,grow");
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel = new JLabel(products.get(2).getName());
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_3.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton_6 = new JButton("+");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct(products.get(2));
			}
		});
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_6.gridx = 0;
		gbc_btnNewButton_6.gridy = 1;
		panel_3.add(btnNewButton_6, gbc_btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("-");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeProduct(products.get(2));
			}
		});
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.gridx = 1;
		gbc_btnNewButton_5.gridy = 1;
		panel_3.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, "cell 0 1,grow");
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblNewLabel_1 = new JLabel(products.get(3).getName());
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_4.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton btnNewButton_7 = new JButton("+");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct(products.get(3));
			}
		});
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_7.gridx = 0;
		gbc_btnNewButton_7.gridy = 1;
		panel_4.add(btnNewButton_7, gbc_btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("-");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeProduct(products.get(3));
			}
		});
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.gridx = 1;
		gbc_btnNewButton_8.gridy = 1;
		panel_4.add(btnNewButton_8, gbc_btnNewButton_8);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, "cell 1 1,grow");
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblNewLabel_2 = new JLabel(products.get(4).getName());
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_5.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JButton btnNewButton_9 = new JButton("+");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct(products.get(4));
			}
		});
		GridBagConstraints gbc_btnNewButton_9 = new GridBagConstraints();
		gbc_btnNewButton_9.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_9.gridx = 0;
		gbc_btnNewButton_9.gridy = 1;
		panel_5.add(btnNewButton_9, gbc_btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("-");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeProduct(products.get(4));
			}
		});
		GridBagConstraints gbc_btnNewButton_10 = new GridBagConstraints();
		gbc_btnNewButton_10.gridx = 1;
		gbc_btnNewButton_10.gridy = 1;
		panel_5.add(btnNewButton_10, gbc_btnNewButton_10);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6, "cell 2 1,grow");
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JLabel lblNewLabel_3 = new JLabel(products.get(5).getName());
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_6.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JButton btnNewButton_11 = new JButton("+");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct(products.get(5));
			}
		});
		GridBagConstraints gbc_btnNewButton_11 = new GridBagConstraints();
		gbc_btnNewButton_11.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_11.gridx = 0;
		gbc_btnNewButton_11.gridy = 1;
		panel_6.add(btnNewButton_11, gbc_btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("-");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeProduct(products.get(5));
			}
		});
		GridBagConstraints gbc_btnNewButton_12 = new GridBagConstraints();
		gbc_btnNewButton_12.gridx = 1;
		gbc_btnNewButton_12.gridy = 1;
		panel_6.add(btnNewButton_12, gbc_btnNewButton_12);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 1 1,grow");
		panel_1.setLayout(new BorderLayout(0, 0));
		
		Vector<Object> columnNames = new Vector<Object>();
		columnNames.add("Producto");
		columnNames.add("Cantidad");
		columnNames.add("Precio");
		
		vectorModel = new Vector<>();
		
		model = new DefaultTableModel(vectorModel, columnNames);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setRowSelectionAllowed(false);
		table.setModel(model);
		table.setEnabled(false);
		
		panel_1.add(new JScrollPane(table), BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Vender");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean sold = false;
				for (Vector<Object> vector : vectorModel){
					if(vector.get(1) instanceof String) continue;
					String name = (String) vector.get(0);
					Integer amount = (Integer) vector.get(1);
					Product product = productsDAO.findOneByName(name);
					if(product != null){
						try {
							product.saleProduct(amount);
							productsDAO.save(product);
							sold = true;
						} catch (Exception e1) {
							lblSdf.setText("no hay suficiente existencia de : "+ product.getName());
							e1.printStackTrace();
						}
						
					}
				}
				if(sold){
					vectorModel.removeAll(vectorModel);
					labelPrice.setText("");
					table.revalidate();
					table.repaint();
				}
			}
		});
		panel_1.add(btnNewButton, BorderLayout.SOUTH);
		
		labelPrice = new JLabel("");
		panel_1.add(labelPrice, BorderLayout.NORTH);

	}
	
	private void removeProduct(Product product){
		int vectorIndex = 0;
		Vector<Object> vectorRow = null;
		Integer element_amount =0;
		for(Vector<Object> element : vectorModel){
			if(element.get(1) instanceof String) continue;
			String element_name = (String) element.get(0);
			
			if(element_name.equals(product.getName())){
				element_amount = (Integer) element.get(1);
				element_amount --;
				element.add(1, element_amount);
				element.add(2, product.getUnitPrice() * element_amount);
				vectorRow = element;
				break;
			}
			vectorIndex ++;
		}
		
		if(vectorRow != null){
			vectorModel.remove(vectorIndex);
			if(element_amount > 0)
				vectorModel.add(vectorIndex,vectorRow);
			table.revalidate();
			table.repaint();
		}
		
		int totalToSale =0;
		for(Vector<Object> element : vectorModel){
			totalToSale += (int)element.get(2); 
		}
		
		labelPrice.setText("Costo total: $"+totalToSale);
		
	}
	
	private void addProduct(Product product){
		int vectorIndex = 0;
		Vector<Object> vectorRow = null;
		Integer element_amount =0;
		for(Vector<Object> element : vectorModel){
			if(element.get(1) instanceof String) continue;
			String element_name = (String) element.get(0);
			
			if(element_name.equals(product.getName())){
				element_amount = (Integer) element.get(1);
				element_amount ++;
				element.add(1, element_amount);
				element.add(2, product.getUnitPrice() * element_amount);
				vectorRow = element;
				break;
			}
			vectorIndex ++;
		}
		
		if(vectorRow == null){
			vectorRow = new Vector<Object>();
			vectorRow.addElement(product.getName());
			element_amount = 1;
			vectorRow.addElement(element_amount);
			vectorRow.addElement(product.getUnitPrice() * element_amount);
		}else{
			vectorModel.remove(vectorIndex);
		}
		vectorModel.add(vectorIndex,vectorRow);
		table.revalidate();
		table.repaint();
		
		int totalToSale =0;
		for(Vector<Object> element : vectorModel){
			totalToSale += (int)element.get(2); 
		}
		
		labelPrice.setText("Costo total: $"+totalToSale);
	}

}
