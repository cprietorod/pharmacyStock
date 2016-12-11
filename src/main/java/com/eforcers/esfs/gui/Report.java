package com.eforcers.esfs.gui;

import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eforcers.esfs.dao.ProductsDAO;
import com.eforcers.esfs.models.Product;

import java.awt.Color;
import java.util.List;

import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

@Component
public class Report extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductsDAO productsDAO;
	private JLabel lblNewLabel_1;
	private JLabel lblProductoMenosVendido;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_2;

	/**
	 * Create the panel.
	 */
	@Autowired
	public Report(ProductsDAO productsDAO) {
		this.setBackground(new Color(255, 255, 255));
		this.productsDAO = productsDAO;
		setLayout(new MigLayout("", "[55px][][][][][]", "[16px][][][]"));
		
		JLabel lblReportes = new JLabel("Reportes");
		add(lblReportes, "cell 1 0 5 1,alignx left,aligny top");
		
		JLabel lblNewLabel = new JLabel("Producto mas vendido");
		add(lblNewLabel, "cell 0 1");
		
		lblNewLabel_1 = new JLabel("");
		add(lblNewLabel_1, "cell 1 1");
		
		lblProductoMenosVendido = new JLabel("Producto menos vendido");
		add(lblProductoMenosVendido, "cell 0 2");
		
		lblNewLabel_2 = new JLabel("");
		add(lblNewLabel_2, "cell 1 2");
		
		JLabel lblNewLabel_3 = new JLabel("Ventas Totales");
		add(lblNewLabel_3, "cell 0 3");
		
		lblNewLabel_4 = new JLabel("");
		add(lblNewLabel_4, "cell 1 3");

	}
	
	public void init(){
		List<Product> products = this.productsDAO.findAllByOrderByAmountSoldDesc();
		lblNewLabel_1.setText(products.get(0).getName());
		
		products = this.productsDAO.findAllByOrderByAmountSoldAsc();
		lblNewLabel_2.setText(products.get(0).getName()); 
		
		int totalSales =0;
		for(Product product: products){
			totalSales += product.getTotalSales();
		}
		
		lblNewLabel_4.setText("$"+totalSales);
		
	}

}
