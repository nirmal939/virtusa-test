package com.virtusa.client;

import java.util.Scanner;

import com.virtusa.util.ConvertNumToWord;

public class ConvertNumToWordClient {
	/**
	 * testing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.print("Please Enter a number : ");
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			String inputNum = scanner.nextLine();
			long enteredVal = 0;
			while(true) {
				boolean flag = ConvertNumToWord.isNumeric(inputNum);
				if(flag) {
					enteredVal = Long.parseLong(inputNum);
					break;
				} else {
					System.out.print("Please Enter a valid number : ");
					inputNum = scanner.nextLine();
				}
			}
			
			System.out.println(enteredVal + " = " + ConvertNumToWord.convert(enteredVal));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
