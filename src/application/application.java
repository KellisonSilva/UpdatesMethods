package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import Entities.Product;
import Services.ProductService;

public class application {

	public static void main(String[] args) {

		
		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.00));
		list.add(new Product("HD case", 80.00));
		
		ProductService productService = new ProductService();
		double sum = productService.filteredSum(list, p -> p.getPrice() < 100.0 );
		
		System.out.println("Total: " + String.format("%.2f", sum));
	}

}
