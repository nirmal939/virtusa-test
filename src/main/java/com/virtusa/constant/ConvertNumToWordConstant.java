package com.virtusa.constant;

public interface ConvertNumToWordConstant {
	public static final String[] TENS_NAME = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
			" seventy", " eighty", " ninety" };

	public static final String[] NUM_NAMES = { "", " one", " two", " three", " four", " five", " six", " seven",
			" eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
			" seventeen", " eighteen", " nineteen" };
	
	public static final String HUNDRED_AND = " hundred and";
	public static final String ZERO = "zero";
	public static final String MASK = "000000000000";
	public static final String EMPTY = "";
	public static final String EMPTY_VAL = " ";
	public static final String BILLION = " billion ";
	public static final String MILLION = " million ";
	public static final String ONE_THOUSAND = "one thousand ";
	public static final String THOUSAND = " thousand ";
	public static final String EXTRA_SPACE_1 = "^\\s+";
	public static final String EXTRA_SPACE_2 = "\\b\\s{2,}\\b";
}
