package com.eforcers.esfs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.eforcers.esfs.dao.ProductsDAO;
import com.eforcers.esfs.models.Product;
import com.eforcers.esfs.models.ProductType;

import static org.junit.Assert.assertEquals;
import org.junit.Before;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EforcersStockFarmacySystemApplicationTests {
	private int unitPrice;
	private int amountSold;
    private int stock;
	private Product product;
	private int minStock;

	@Autowired
	private ProductsDAO productsDAO;
    
    
	@Before 
    public void initialize() {
		this.unitPrice = 15;
		this.amountSold = 205;
		this.stock = 15;
		this.minStock = 5;
		
		this.product = new Product();
		product.setUnitPrice(unitPrice);
		product.setAmountSold(amountSold);
		product.setStock(stock);
		product.setMinStock(this.minStock);
		product.setType(ProductType.analeptico);
		product.setName("Test analeptico");
		
    }

	@Test
	public void calculateSalesTest() {
		assertEquals(unitPrice * amountSold, product.getTotalSales());
	}
	
	@Test
	public void saleProduct() throws Exception{
		int sold = 5; 
		product.saleProduct(sold);
		assertEquals(this.stock - sold, product.getStock());
		assertEquals(this.amountSold + sold, product.getAmountSold());
	}
	
	@Test(expected=Exception.class)
	public void saleProductOverMin() throws Exception{
		int sold = this.stock + 5; 
		product.saleProduct(sold);
	}
	
	@Test
	public void saveProduct(){
		productsDAO.save(this.product);
		Product productAux = productsDAO.findOne(this.product.getId());
		assertEquals(productAux.getName(), product.getName());
	}
	
	@Test
	public void updateProduct(){
		productsDAO.save(this.product);
		this.product.setMinStock(minStock+2);
		productsDAO.save(this.product);
		
		Product productAux = productsDAO.findOne(this.product.getId());
		assertEquals(productAux.getMinStock(), minStock + 2);
	}
	

}
