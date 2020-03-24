package com.hantak;

import java.text.NumberFormat;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MONTHS_IN_YEAR = 12;
        final int NUM_TO_PERCENT = 100;

        System.out.println("Welcome to Mortgage Calculator!");

        int principal = inputPrincipal(scanner);

        double monthlyInterest = inputAnnualInterest(scanner) / MONTHS_IN_YEAR / NUM_TO_PERCENT;

        int mortgageMonths = inputMortgagePeriod(scanner) * MONTHS_IN_YEAR;

        double numerator = monthlyInterest * Math.pow((1+monthlyInterest), mortgageMonths);
        double denominator = Math.pow((1+monthlyInterest), mortgageMonths) - 1;

        double monthlyValue = principal * numerator / denominator;

        String monthlyPayment = NumberFormat.getCurrencyInstance().format(monthlyValue);

        System.out.println("Monthly Payment: " + monthlyPayment);
    }

    public static int inputPrincipal(Scanner scanner) {
        int principal = 0;
        while(principal <= 1_000 || principal >= 1_000_000) {
            System.out.println("Mortgage principal must be between $1,000 and $1,000,000");
            System.out.print("Enter your principal amount: ");
            principal = scanner.nextInt();
        }
        return principal;
    }

    public static double inputAnnualInterest(Scanner scanner) {
        double annualInterest = 0;
        while (annualInterest <=0 || annualInterest > 30) {
            System.out.println("Annual interest rate must be greater than 0% and less than or equal to 30%");
            System.out.print("Enter your annual interest rate: ");
            annualInterest = scanner.nextDouble();
        }
        return annualInterest;
    }

    public static int inputMortgagePeriod(Scanner scanner) {
        int mortgageMonths = 0;
        while (mortgageMonths < 12 || mortgageMonths > 360) {
            System.out.println("Mortgage period must be between 1 year to 30 years");
            System.out.print("Enter your mortgage period(in years): ");
            mortgageMonths = scanner.nextByte();
        }
        return mortgageMonths;
    }
}
