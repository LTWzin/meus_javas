package application;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Type the department name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print(" -Name: ");
		String workerName = sc.nextLine();
		System.out.print(" -Worker Level: ");
		String workerLevel = sc.nextLine();
		System.out.print(" -Base salary: ");
		double workerSalary = sc.nextDouble();	
		Worker worker = new Worker(new Department(departmentName), workerName, WorkerLevel.valueOf(workerLevel), workerSalary);
		
		System.out.print("How many contracts to this worker?  ");
		int x = sc.nextInt();
		for (int i=0;i<x;i++) {
			System.out.printf("Enter #%d contract data:", i + 1);
			System.out.print("\n -Date (DD/MM/YYYY): ");
			sc.nextLine();
			LocalDate localDate = LocalDate.parse(sc.next(), fmt1);
			System.out.print(" -Value per hours: ");
			Double perHour = sc.nextDouble();
			System.out.print(" -Duration (hours): ");
			Integer hours = sc.nextInt();
			HourContract contract = new HourContract(localDate, perHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println();
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("R$ %.2f", worker.income(month, year)));
		sc.close();
	}
}
