package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		List<Employee> employees = new ArrayList<>();
		
		
		System.out.println("Insira a quantidade de employees: ");
		int number = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < number; i++) {
			System.out.println("Esse é outsourced? sim (s) ou não(n)?");
			String resp = sc.nextLine();
			
			if (resp.equals("s")) {				
				OutsourcedEmployee outsource = new OutsourcedEmployee();
					
				System.out.println("Digite o nome: ");
				String name = sc.nextLine();
				
				System.out.println("Digite o total de horas: ");
				Integer hours = sc.nextInt();
				
				System.out.println("Digite o valor por horas: ");
				Double valuePerHour = sc.nextDouble();
				outsource.setValuePerHour(valuePerHour);
				
				System.out.println("Digite o additional: ");
				Double additional = sc.nextDouble();
				sc.nextLine();
				
				outsource.setName(name);
				outsource.setHours(hours);
				outsource.setAdditionalCharge(additional);
					
				Double payment = outsource.payment();
				
				employees.add(outsource);	
			}
			if (resp.equals("n")) {
				Employee employee = new Employee();
				
				System.out.println("Digite o nome: ");
				String name = sc.nextLine();
				
				System.out.println("Digite o total de horas: ");
				Integer hours = sc.nextInt();
				
				System.out.println("Digite o valor por hora: ");
				Double valuePerHour = sc.nextDouble();
				sc.nextLine();
				
				employee.setName(name);
				employee.setHours(hours);
				employee.setValuePerHour(valuePerHour);
				
				Double payment = employee.payment();
				
				employees.add(employee);
			}		
		}
		
		sc.close();
		
		System.out.println("\nPAYMENTS:");
		
		for (Employee emp : employees) {
			System.out.println(emp.getName() + ": " + String.format("%.2f", emp.payment()));
		}
		
	}

}
