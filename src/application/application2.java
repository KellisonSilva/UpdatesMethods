package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import Entities.Product;

public class application2 {

	public static void main(String[] args) {


		String path = "C:\\Users\\Rarison\\Documents\\Drew\\MeusDocs\\Eclipse IDE\\lorem.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Product> list = new ArrayList<>();

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.trim().split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();

			}
			/**
			 * @param Price e a media (avg)
			 */
			Double avg = list.stream().map(p -> p.getPrice()).reduce(0.0, (x, y) -> x + y) / list.size();
			System.out.println("Average price: " + String.format("%.2f", avg));
			
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()); 
			
			list.stream().filter(p -> p.getPrice() < avg).map(p -> p.getName())
			.sorted(comp.reversed())
			.collect(Collectors.toList()).forEach(System.out::println);
			
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
