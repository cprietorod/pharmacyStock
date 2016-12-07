package com.eforcers.esfs.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eforcers.esfs.dao.ProductsDAO;
import com.eforcers.esfs.models.Product;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

@Component
public class StockPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txtAsdf;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel label_2;
	private JTextField textField_8;
	private JTextField textField_9;
	private JLabel label_3;
	private JTextField textField_10;
	private JTextField textField_11;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	@Autowired
	public StockPanel(ProductsDAO productsDAO) {
		List<Product> products = (List<Product>) productsDAO.findAll();
		
		setLayout(new MigLayout("", "[63px][grow][grow]", "[16px][][][][][][][]"));
		
		JLabel lblInventario = new JLabel("Inventario");
		add(lblInventario, "cell 0 0,alignx left,aligny top");
		
		JLabel lblNewLabel = new JLabel(products.get(0).getName());
		add(lblNewLabel, "cell 0 1,alignx trailing");
		
		txtAsdf = new JTextField();
		txtAsdf.setText(products.get(0).getMinStock()+"");
		add(txtAsdf, "cell 1 1,growx");
		txtAsdf.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText(products.get(0).getStock()+"");
		add(textField_1, "cell 2 1,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(products.get(1).getName());
		add(lblNewLabel_1, "cell 0 2,alignx trailing");
		
		textField_2 = new JTextField();
		textField_2.setText(""+products.get(1).getMinStock());
		add(textField_2, "cell 1 2,growx");
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText(""+products.get(1).getStock());
		add(textField_3, "cell 2 2,growx");
		textField_3.setColumns(10);
		
		JLabel label = new JLabel(products.get(2).getName());
		add(label, "cell 0 3,alignx trailing");
		
		textField_4 = new JTextField();
		textField_4.setText(""+products.get(2).getMinStock());
		add(textField_4, "cell 1 3,growx");
		textField_4.setColumns(10);
		
		textField_5 = new JTextField(products.get(2).getStock());
		textField_5.setText(""+products.get(2).getStock());
		add(textField_5, "cell 2 3,growx");
		textField_5.setColumns(10);
		
		JLabel label_1 = new JLabel(products.get(3).getName());
		add(label_1, "cell 0 4,alignx trailing");
		
		textField_6 = new JTextField();
		textField_6.setText(""+products.get(3).getMinStock());
		add(textField_6, "cell 1 4,growx");
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setText(""+products.get(3).getStock());
		add(textField_7, "cell 2 4,growx");
		textField_7.setColumns(10);
		
		label_2 = new JLabel(products.get(4).getName());
		add(label_2, "cell 0 5,alignx trailing");
		
		textField_8 = new JTextField();
		textField_8.setText(products.get(4).getMinStock()+"");
		add(textField_8, "cell 1 5,growx");
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setText(""+products.get(4).getStock());
		add(textField_9, "cell 2 5,growx");
		textField_9.setColumns(10);
		
		label_3 = new JLabel(products.get(5).getName());
		add(label_3, "cell 0 6,alignx trailing");
		
		textField_10 = new JTextField();
		textField_10.setText(""+products.get(5).getMinStock());
		add(textField_10, "cell 1 6,growx");
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setText(""+products.get(5).getStock());
		add(textField_11, "cell 2 6,growx");
		textField_11.setColumns(10);
		
		btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnNewButton, "cell 2 7");
	}

}
