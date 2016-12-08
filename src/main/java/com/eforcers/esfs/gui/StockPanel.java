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
import javax.swing.SwingConstants;

@Component
public class StockPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txtMin0;
	private JTextField txtAm0;
	private JTextField txtMin1;
	private JTextField txtAm1;
	private JTextField txtMin2;
	private JTextField txtAm2;
	private JTextField txtMin3;
	private JTextField txtAm3;
	private JLabel lbPro4;
	private JTextField txtMin4;
	private JTextField txtAm4;
	private JLabel lbPro5;
	private JTextField txtMin5;
	private JTextField txtAm5;
	private JButton btnNewButton;
	private List<Product> products;
	private ProductsDAO productsDAO;
	private JLabel lbPro0;
	private JLabel lbPro1;
	private JLabel lbPro2;
	private JLabel lbPro3;

	public void init(){
		products = (List<Product>) productsDAO.findAll();
		lbPro0.setText(products.get(0).getName());
		txtMin0.setText(""+products.get(0).getMinStock());
		txtAm0.setText(""+products.get(0).getStock());
		
		lbPro1.setText(products.get(1).getName());
		txtMin1.setText(""+products.get(1).getMinStock());
		txtAm1.setText(""+products.get(1).getStock());
		
		lbPro2.setText(products.get(2).getName());
		txtMin2.setText(""+products.get(2).getMinStock());
		txtAm2.setText(""+products.get(2).getStock());
		
		lbPro3.setText(products.get(3).getName());
		txtMin3.setText(""+products.get(3).getMinStock());
		txtAm3.setText(""+products.get(3).getStock());
		
		lbPro4.setText(products.get(4).getName());
		txtMin4.setText(""+products.get(4).getMinStock());
		txtAm4.setText(""+products.get(4).getStock());
		
		lbPro5.setText(products.get(5).getName());
		txtMin5.setText(""+products.get(5).getMinStock());
		txtAm5.setText(""+products.get(5).getStock());
	}
	
	/**
	 * Create the panel.
	 */
	@Autowired
	public StockPanel(ProductsDAO productsDAO) {
		this.productsDAO = productsDAO;
		
		setLayout(new MigLayout("", "[63px][grow][grow]", "[16px][][][][][][][]"));
		
		JLabel lblInventario = new JLabel("Inventario");
		add(lblInventario, "cell 0 0,alignx left,aligny top");
		
		lbPro0 = new JLabel("");
		add(lbPro0, "cell 0 1,alignx trailing");
		
		txtMin0 = new JTextField();
		add(txtMin0, "cell 1 1,growx");
		txtMin0.setColumns(10);
		
		txtAm0 = new JTextField();
		add(txtAm0, "cell 2 1,growx");
		txtAm0.setColumns(10);
		
		lbPro1 = new JLabel("");
		add(lbPro1, "cell 0 2,alignx trailing");
		
		txtMin1 = new JTextField();
		add(txtMin1, "cell 1 2,growx");
		txtMin1.setColumns(10);
		
		txtAm1 = new JTextField();
		add(txtAm1, "cell 2 2,growx");
		txtAm1.setColumns(10);
		
		lbPro2 = new JLabel("");
		add(lbPro2, "cell 0 3,alignx trailing");
		
		txtMin2 = new JTextField();
		add(txtMin2, "cell 1 3,growx");
		txtMin2.setColumns(10);
		
		txtAm2 = new JTextField("");
		add(txtAm2, "cell 2 3,growx");
		txtAm2.setColumns(10);
		
		lbPro3 = new JLabel("");
		add(lbPro3, "cell 0 4,alignx trailing");
		
		txtMin3 = new JTextField();
		add(txtMin3, "cell 1 4,growx");
		txtMin3.setColumns(10);
		
		txtAm3 = new JTextField();
		add(txtAm3, "cell 2 4,growx");
		txtAm3.setColumns(10);
		
		lbPro4 = new JLabel("");
		add(lbPro4, "cell 0 5,alignx trailing");
		
		txtMin4 = new JTextField();
		add(txtMin4, "cell 1 5,growx");
		txtMin4.setColumns(10);
		
		txtAm4 = new JTextField();
		add(txtAm4, "cell 2 5,growx");
		txtAm4.setColumns(10);
		
		lbPro5 = new JLabel("");
		add(lbPro5, "cell 0 6,alignx trailing");
		
		txtMin5 = new JTextField();
		add(txtMin5, "cell 1 6,growx");
		txtMin5.setColumns(10);
		
		txtAm5 = new JTextField();
		add(txtAm5, "cell 2 6,growx");
		txtAm5.setColumns(10);
		
		btnNewButton = new JButton("Guardar");
		add(btnNewButton, "cell 1 7 2 1,alignx center,aligny center");
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product product = null;
				
				product = products.get(0);
				product.setMinStock(Integer.parseInt(txtMin0.getText()));
				product.setStock(Integer.parseInt(txtAm0.getText()));
				
				product = products.get(1);
				product.setMinStock(Integer.parseInt(txtMin1.getText()));
				product.setStock(Integer.parseInt(txtAm1.getText()));
				productsDAO.save(product);
				
				product = products.get(2);
				product.setMinStock(Integer.parseInt(txtMin2.getText()));
				product.setStock(Integer.parseInt(txtAm2.getText()));
				productsDAO.save(product);
				
				product = products.get(3);
				product.setMinStock(Integer.parseInt(txtMin3.getText()));
				product.setStock(Integer.parseInt(txtAm3.getText()));
				productsDAO.save(product);
				
				product = products.get(4);
				product.setMinStock(Integer.parseInt(txtMin4.getText()));
				product.setStock(Integer.parseInt(txtAm4.getText()));
				productsDAO.save(product);
				
				product = products.get(5);
				product.setMinStock(Integer.parseInt(txtMin5.getText()));
				product.setStock(Integer.parseInt(txtAm5.getText()));
				productsDAO.save(product);
			}
		});
		
		this.init();
	}

}
