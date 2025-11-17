package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc = new Scanner(System.in);
		
		List<Product> products = new ArrayList<>();
		
		System.out.println("Quantos produtos serão inseridos?");
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < n; i++ ) {
			System.out.println("Coomon, used or imported (c/u/i)?");
			String type = sc.nextLine();
		
			
			if (type.equals("u")) {
				
				try {
				UsedProduct usedProduct = new UsedProduct();
				
				System.out.println("Name: ");
				String name = sc.nextLine();
				
				System.out.println("Price: ");
				Double price = sc.nextDouble();
				sc.nextLine();
				
				System.out.println("Manufacture date: ");
				String dataStr = sc.nextLine();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
				Date manufactureDate = sdf.parse(dataStr);
				
				usedProduct.setName(name);
				usedProduct.setPrice(price);
				usedProduct.setManufactureDate(manufactureDate);
				
				products.add(usedProduct); //Upcasting é automático!
				
					
				} catch (ParseException e) {
					System.out.println("Invalid date format! Please use: dd/MM/yyyy");
				}		
			}
			
			if (type.equals("i")) {
				
				ImportedProduct imported = new ImportedProduct();
				
				System.out.println("Name: ");
				String name = sc.nextLine();
				
				System.out.println("Price: ");
				Double price = sc.nextDouble();
				sc.nextLine();
				
				System.out.println("Customs fee: ");
				Double customsFee = sc.nextDouble();
				sc.nextLine();
				
				imported.setName(name);
				imported.setPrice(price);
				imported.setCustomsFree(customsFee);
				
				products.add(imported);
				
			}
			
			if (type.equals("c")) {
				
				Product product = new Product();
				
				System.out.println("Name: ");
				String name = sc.nextLine();
				
				System.out.println("Price: ");
				Double price = sc.nextDouble();
				sc.nextLine();
				
				product.setName(name);
				product.setPrice(price);
				
				
				products.add(product);
				
			}
		}
		
		System.out.println("PRICE TAGS");
		
		for (Product product : products) {
			System.out.println(product.priceTag());	
		}
		
		sc.close();
		
	}
}
