package com.eforcers.esfs.gui;

import javax.swing.JPanel;
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

@Component
public class SalesPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private Vector<Vector<Object>> vectorModel;
	
	
	/**
	 * Create the panel.
	 */
	@Autowired
	public SalesPanel(ProductsDAO productsDAO) {
		setForeground(new Color(255, 69, 0));
		setLayout(new MigLayout("", "[410.00,grow][grow]", "[][grow]"));
		
		JLabel lblSdf = new JLabel("");
		lblSdf.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblSdf.setForeground(new Color(255, 69, 0));
		add(lblSdf, "cell 0 0");
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[][][]", "[][]"));
		
		List<Product> products = (List<Product>) productsDAO.findAll();
		
		
		JButton btnProducto = new JButton(products.get(0).getName());
		btnProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct(btnProducto.getText());
			}
		});
		panel.add(btnProducto, "cell 0 0");
		
		JButton btnProducto_1 = new JButton(products.get(1).getName());
		btnProducto_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct(btnProducto_1.getText());
			}
		});
		panel.add(btnProducto_1, "cell 1 0");
		
		JButton btnProducto_2 = new JButton(products.get(2).getName());
		btnProducto_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct(btnProducto_2.getText());
			}
		});
		panel.add(btnProducto_2, "cell 2 0");
		
		JButton btnProducto_3 = new JButton(products.get(3).getName());
		btnProducto_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct(btnProducto_3.getText());
			}
		});
		panel.add(btnProducto_3, "cell 0 1");
		
		JButton btnProducto_4 = new JButton(products.get(4).getName());
		btnProducto_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct(btnProducto_4.getText());
			}
		});
		panel.add(btnProducto_4, "cell 1 1");
		
		JButton btnProducto_5 = new JButton(products.get(5).getName());
		btnProducto_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct(btnProducto_5.getText());
			}
		});
		panel.add(btnProducto_5, "cell 2 1");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 1 1,grow");
		panel_1.setLayout(new BorderLayout(0, 0));
		
		Vector<Object> columnNames = new Vector<Object>();
		columnNames.add("Producto");
		columnNames.add("Cantidad");
		
		vectorModel = new Vector<>();
		
		model = new DefaultTableModel(vectorModel, columnNames);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setRowSelectionAllowed(false);
		table.setModel(model);
		
		Object rowData[] = { "Producto", "Cantidad"};
		model.addRow(rowData);
		
		panel_1.add(table, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Vender");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Vector<Object> vector : vectorModel){
					if(vector.get(1) instanceof String) continue;
					String name = (String) vector.get(0);
					Integer amount = (Integer) vector.get(1);
					Product product = productsDAO.findOneByName(name);
					if(product != null){
						try {
							product.saleProduct(amount);
							productsDAO.save(product);
						} catch (Exception e1) {
							lblSdf.setText("no hay suficiente existencia de : "+ product.getName());
							e1.printStackTrace();
						}
						
					}
				}
			}
		});
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
		
		table.revalidate();
		table.repaint();
	}

}
