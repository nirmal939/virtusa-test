package com.virtusa.util;

import java.text.DecimalFormat;

import com.virtusa.constant.ConvertNumToWordConstant;

public class ConvertNumToWord {

	private ConvertNumToWord() {
	}

	private static String convertLessThanOneThousand(int number) {
		String soFar;

		if (number % 100 < 20) {
			soFar = ConvertNumToWordConstant.NUM_NAMES[number % 100];
			number /= 100;
		} else {
			soFar = ConvertNumToWordConstant.NUM_NAMES[number % 10];
			number /= 10;

			soFar = ConvertNumToWordConstant.TENS_NAME[number % 10] + soFar;
			number /= 10;
		}
		if (number == 0)
			return soFar;
		return ConvertNumToWordConstant.NUM_NAMES[number] + ConvertNumToWordConstant.HUNDRED_AND + soFar;
	}

	public static String convert(long number) {
		// 0 to 999 999 999 999
		if (number == 0) {
			return ConvertNumToWordConstant.ZERO;
		}

		String snumber = Long.toString(number);

		// pad with "0"
		String mask = ConvertNumToWordConstant.MASK;
		DecimalFormat df = new DecimalFormat(mask);
		snumber = df.format(number);

		// XXXnnnnnnnnn
		int billions = Integer.parseInt(snumber.substring(0, 3));
		// nnnXXXnnnnnn
		int millions = Integer.parseInt(snumber.substring(3, 6));
		// nnnnnnXXXnnn
		int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
		// nnnnnnnnnXXX
		int thousands = Integer.parseInt(snumber.substring(9, 12));

		String tradBillions;
		switch (billions) {
		case 0:
			tradBillions = ConvertNumToWordConstant.EMPTY;
			break;
		case 1:
			tradBillions = convertLessThanOneThousand(billions) + ConvertNumToWordConstant.BILLION;
			break;
		default:
			tradBillions = convertLessThanOneThousand(billions) + ConvertNumToWordConstant.BILLION;
		}
		String result = tradBillions;

		String tradMillions;
		switch (millions) {
		case 0:
			tradMillions = ConvertNumToWordConstant.EMPTY;
			break;
		case 1:
			tradMillions = convertLessThanOneThousand(millions) + ConvertNumToWordConstant.MILLION;
			break;
		default:
			tradMillions = convertLessThanOneThousand(millions) + ConvertNumToWordConstant.MILLION;
		}
		result = result + tradMillions;

		String tradHundredThousands;
		switch (hundredThousands) {
		case 0:
			tradHundredThousands = ConvertNumToWordConstant.EMPTY;
			break;
		case 1:
			tradHundredThousands = ConvertNumToWordConstant.ONE_THOUSAND;
			break;
		default:
			tradHundredThousands = convertLessThanOneThousand(hundredThousands) + ConvertNumToWordConstant.THOUSAND;
		}
		result = result + tradHundredThousands;

		String tradThousand;
		tradThousand = convertLessThanOneThousand(thousands);
		result = result + tradThousand;

		// remove extra spaces!
		return result.replaceAll(ConvertNumToWordConstant.EXTRA_SPACE_1, ConvertNumToWordConstant.EMPTY)
				.replaceAll(ConvertNumToWordConstant.EXTRA_SPACE_2, ConvertNumToWordConstant.EMPTY_VAL);
	}
	public static boolean isNumeric(String strNum) {
	    return strNum.matches("-?\\d+(\\.\\d+)?");
	}
}