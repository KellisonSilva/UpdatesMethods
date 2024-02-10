package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import Entities.Employee;

public class application3 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter full file path: ");
		String path = sc.next();
		
		try (BufferedReader rd = new BufferedReader(new FileReader(
				path))) {

			List<Employee> empls = new ArrayList<>();
			
			String line = rd.readLine();
			while (line != null) {

				String[] separator = line.trim().split(",");

				Employee emp = new Employee(separator[0], separator[1], Double.parseDouble(separator[2]));
				empls.add(emp);
				line = rd.readLine();
			}
			
			
			System.out.print("Enter salary: ");
			double salary = sc.nextDouble();
			
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary) + ": ");
			empls.stream().filter(s -> s.getSalary() > salary).map(n -> n.getEmail()).sorted(comp).collect(Collectors.toList()).forEach(System.out::println);
			
			double sumAllSallary = empls.stream().filter(n -> n.getName().contains("M")).mapToDouble((s) -> s.getSalary()).reduce(0.0, Double::sum);
			System.out.print("Sum of salary of people whose name starts with 'M': " + String.format("%.2f",sumAllSallary));
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}

}
