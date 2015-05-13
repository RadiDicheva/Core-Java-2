package com.hackbulgaria.corejava;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Problems2Impl implements Problems2 {

	@Override
	public boolean isOdd(int number) {
		return number % 2 != 0;
	}

	@Override
	public boolean isPrime(int number) {
		if (number == 2)
			return true;

		if (number % 2 == 0)
			return false;

		for (int i = 3; i * i <= number; i += 2) {
			if (number % i == 0)
				return false;
		}

		return true;
	}

	@Override
	public int min(int... array) {
		int minNumber = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < minNumber)
				minNumber = array[i];
		}

		return minNumber;
	}

	@Override
	public int kthMin(int k, int[] array) {
		Arrays.sort(array);

		return array[k - 1];
	}

	@Override
	public float getAverage(int[] array) {
		float sum = 0;

		int i = 0;
		while (i < array.length) {
			sum += array[i];
			i++;
		}

		float average = sum / array.length;

		return average;
	}

	private static long lcm(long x, long y) {
		long result = 1, temp = 1;

		for (int i = 1;; i++) {
			result = x * i;

			for (int j = 1; temp < result; j++)
				temp = y * j;

			if (result == temp)
				break;
		}

		return result;
	}

	@Override
	public long getSmallestMultiple(int upperBound) {
		long result = 1;

		for (int i = upperBound; i > 1; i--)
			result = (int) lcm(i, result);

		return result;
	}

	private static boolean isPalindrome(long number) {
		long palindrome = number;
		long reverse = 0;

		while (palindrome != 0) {
			long remainder = palindrome % 10;
			reverse = reverse * 10 + remainder;
			palindrome = palindrome / 10;
		}

		if (number == reverse) {
			return true;
		} else
			return false;
	}

	@Override
	public long getLargestPalindrome(long N) {
		do
			N--;
		while (!isPalindrome(N));

		return N;
	}

	@Override
	public int[] histogram(short[][] image) {
		int[] resultArr = new int[256];

		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[i].length; j++)
				resultArr[image[i][j]] += 1;
		}

		return resultArr;
	}

	@Override
	public long doubleFac(int n) {
		if (n < 0)
			throw new IllegalArgumentException(
					"Invalid number! Please input a positive number!");

		long dFactorial = 1;

		for (int i = 1; i <= n; i++)
			dFactorial *= i;

		for (int i = (int) dFactorial; i > n; i--)
			dFactorial *= i;

		return dFactorial;
	}

	@Override
	public long kthFac(int k, int n) {
		long factorial = 1;
        long limit = n;
        
        for (long i = 2; i <= limit; i++) {
            factorial *= i;
            if (i == limit) {
                k--;
                limit = factorial;
            }
            if (k == 0)
            	break;
        }
        
        return factorial;
	}

	@Override
	public int getOddOccurrence(int[] array) {
		Arrays.sort(array);

		int counter = 1, result = 0, i = 1;

		while (i <= array.length) {
			if (array[i - 1] == array[i]) {
				counter++;
				i++;
			}

			if (counter % 2 != 0)
				result = array[i - 1];

			counter = 1;
			i++;
		}

		return result;
	}

	@Override
	public long pow(int a, int b) {
		if (b == 0)
			return 1;

		long result = pow(a, b / 2);
		result *= result;

		if (b % 2 != 0)
			result *= a;

		return result;
	}

	@Override
	public long maximalScalarSum(int[] a, int[] b) {
		Arrays.sort(a);
		Arrays.sort(b);

		long sum = 0;

		for (int i = 0; i < a.length; i++)
			sum += a[i] * b[i];

		return sum;
	}

	@Override
	public int maxSpan(int[] array) {
		int result = 0;

		for (int i = 0; i < array.length; i++) {
			int j = array.length - 1;

			while (array[i] != array[j])
				j--;

			if (result < j - i + 1)
				result = j - i + 1;
		}

		return result;
	}

	@Override
	public boolean canBalance(int[] array) {
		boolean result = false;

		for (int i = 0; i < array.length; i++) {
			int left = 0, right = 0, j = 0, k = i;

			while (j < i) {
				left += array[j];
				j++;
			}

			while (k < array.length) {
				right += array[k];
				k++;
			}

			if (left == right)
				result = true;
		}

		return result;
	}

	@Override
	public int[][] rescale(int[][] original, int newWidth, int newHeight) {
		int[][] result = new int[newWidth][newHeight];
        int width = original.length / newWidth;
        int height = original[0].length / newHeight;
        
        int i = 0;
        while (i < width) {
        	for (int j = 0; j < height; j++)
                result[i][j] = original[width * i][height * j];
        	i++;
        }
        
        return result;
	}

	@Override
	public String reverseMe(String argument) {
		char[] argumentArr = argument.toCharArray();
		int i = 0, j = argumentArr.length - 1;

		while (i <= j) {
			char temp = argumentArr[i];
			argumentArr[i] = argumentArr[j];
			argumentArr[j] = temp;
			j--;
			i++;
		}

		return new String(argumentArr);
	}

	@Override
	public String copyEveryChar(String input, int k) {
		char[] inputArr = input.toCharArray();
		ArrayList<Character> resultArr = new ArrayList<Character>();

		for (int i = 0; i < inputArr.length; i++)
			for (int j = k; j > 0; j--)
				resultArr.add(inputArr[i]);
		
		StringBuilder sb = new StringBuilder(resultArr.size());
	    for(Character ch: resultArr)
	        sb.append(ch);
	    
	    return sb.toString();
	}

	@Override
	public String reverseEveryWord(String arg) {
		char[] argArr = arg.toCharArray();
		StringBuilder currentWord = new StringBuilder();
		StringBuilder resultWord = new StringBuilder();

		for (int i = 0; i < arg.length(); i++) {
			if (argArr[i] != argArr.length - 1 && argArr[i] != ' ')
				currentWord.append(argArr[i]);
			else {
				resultWord.append(currentWord.reverse());
				resultWord.append(" ");
				currentWord.setLength(0);
			}
		}
		resultWord.append(currentWord.reverse());
		
		return resultWord.toString();
	}

	@Override
	public boolean isPalindrome(String argument) {
		char[] argumentArr = argument.toCharArray();
		int i = 0, j = argumentArr.length - 1;

		while (j > i) {
			if (argumentArr[i] != argumentArr[j])
				return false;
			i++;
			j--;
		}

		return true;
	}

	@Override
	public boolean isPalindrome(int number) {
		int palindrome = number;
		int reverse = 0;

		while (palindrome != 0) {
			int remainder = palindrome % 10;
			reverse = reverse * 10 + remainder;
			palindrome = palindrome / 10;
		}

		if (number == reverse) {
			return true;
		} else
			return false;
	}

	@Override
	public int getPalindromeLength(String input) {
		char[] argumentArr = input.toCharArray();
		StringBuilder left = new StringBuilder();
		StringBuilder right = new StringBuilder();

		for (int i = 0; i < argumentArr.length; i++) {
			while (argumentArr[i] != '*') {
				left.append(argumentArr[i]);
				i++;
			}
			if (argumentArr[i] == '*') {
				while (i < argumentArr.length - 1) {
					right.append(argumentArr[i + 1]);
					i++;
				}
			}
		}
		left.reverse();

		int index;
		if (right.length() <= left.length())
			index = right.length();
		else
			index = left.length();

		int counter = 0, i = 0, j = 0;

		while (i < index) {
			if (left.charAt(0) != right.charAt(0))
				break;
			if (left.charAt(i) == right.charAt(j))
				counter++;
			i++;
			j++;
		}

		return counter;
	}

	@Override
	public int countOcurrences(String needle, String haystack) {
		return haystack.split(needle, -1).length - 1;
	}

	@Override
	public String decodeURL(String input) {
		return input.replaceAll("%20", " ").replaceAll("%3A", ":")
				.replaceAll("%3D", "?").replaceAll("%2F", "/");
	}

	private static boolean isNumeric(String str) {
		try {
			int number = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	@Override
	public int sumOfNumbers(String input) {
		char[] inputArr = input.toCharArray();
		int sum = 0;

		for (int i = 0; i < inputArr.length; i++) {
			if (!Character.isDigit(inputArr[i])
					&& (inputArr[i] != '-' || !Character
							.isDigit(inputArr[i + 1])))
				inputArr[i] = ' ';
		}

		String newInput = String.valueOf(inputArr);
		String[] splitStr = newInput.split("\\s+");

		for (int i = 0; i < splitStr.length; i++) {
			if (isNumeric(splitStr[i])) {
				int temp = Integer.parseInt(splitStr[i]);
				sum += temp;
			}
		}

		return sum;
	}

	@Override
	public boolean areAnagrams(String A, String B) {
		A = A.toLowerCase().replaceAll("\\s+", "");
		B = B.toLowerCase().replaceAll("\\s+", "");
		char[] aArray = A.toCharArray(), bArray = B.toCharArray();

		Arrays.sort(aArray);
		Arrays.sort(bArray);

		return Arrays.equals(aArray, bArray);
	}

	@Override
	public boolean hasAnagramOf(String string, String string2) {
		string = string.toLowerCase().replaceAll("\\s+", "");
		string2 = string2.toLowerCase().replaceAll("\\s+", "");

		char[] aArray = string.toCharArray(), bArray = string2.toCharArray();

		ArrayList<Character> aList = new ArrayList<Character>();
		ArrayList<Character> bList = new ArrayList<Character>();

		for (Character ch : aArray)
			aList.add(ch);

		for (Character ch : bArray)
			bList.add(ch);

		while (!aList.isEmpty()) {
			if (string2.contains(aList.get(0).toString()))
				aList.remove(0);
			else
				break;
		}

		return aList.isEmpty();
	}

	public static void convertToGreyscale(String imgPath) {
		try {
			File file = new File(imgPath);

			BufferedImage bImg = null;
			bImg = ImageIO.read(file);

			for (int i = 0; i < bImg.getWidth(); ++i)
				for (int j = 0; j < bImg.getHeight(); ++j) {

					Color rgb = new Color(bImg.getRGB(i, j));
					int red = (int) (rgb.getRed() * 0.299);
					int green = (int) (rgb.getGreen() * 0.587);
					int blue = (int) (rgb.getBlue() * 0.114);

					int sum = red + green + blue;
					Color newColor = new Color(sum, sum, sum);

					bImg.setRGB(j, i, newColor.getRGB());
				}

			File outputFile = new File("D:/root/toGrayscale.jpg");
			ImageIO.write(bImg, "jpg", outputFile);
		} catch (Exception e) {
		}
	}

}
