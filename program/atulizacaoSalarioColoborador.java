package program; 

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;

public class atulizacaoSalarioColoborador {
	
	public static void main(String[] args) throws ParseException {
		Scanner leitor = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department`s name: ");
		String departmentName = leitor.nextLine();
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName = leitor.nextLine();
		System.out.print("Level: ");
		String workerLevel = leitor.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = leitor.nextDouble();
		
		Worker worker = new Worker(workerName, entities.enums.workerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.print( "How many contracts to this worker? ");
		int n = leitor.nextInt();
		
		for(int i = 1; i <= n; i ++ ) {
			System.out.println("Enter contract #"+ i +" data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(leitor.next());
			System.out.print("Value per hour: ");
			double valuePerHour = leitor.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = leitor.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			
			worker.addContract(contract);
		}
		System.out.println();
		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = leitor.next();
		int month = Integer.parseInt(monthAndYear.substring(0 , 2));  
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		
	}
}
