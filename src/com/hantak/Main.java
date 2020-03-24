package com.hantak;

import java.text.NumberFormat;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MONTHS_IN_YEAR = 12;
        final int NUM_TO_PERCENT = 100;

        System.out.println("Welcome to Mortgage Calculator!");
        System.out.print("Enter your principal amount: ");

        int principal = scanner.nextInt();

        System.out.print("Enter your annual interest rate: ");

        double monthlyInterest = scanner.nextDouble() / NUM_TO_PERCENT / MONTHS_IN_YEAR;

        System.out.print("Enter your mortgage period(in years): ");

        int mortgageMonths = scanner.nextByte() * MONTHS_IN_YEAR;

        double numerator = monthlyInterest * Math.pow((1+monthlyInterest), mortgageMonths);
        double denominator = Math.pow((1+monthlyInterest), mortgageMonths) - 1;

        double monthlyValue = principal * numerator / denominator;

        String monthlyPayment = NumberFormat.getCurrencyInstance().format(monthlyValue);

        System.out.println("Monthly Payment: " + monthlyPayment);
    }
}
