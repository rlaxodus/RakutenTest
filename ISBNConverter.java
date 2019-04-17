import java.util.Scanner;

public class ISBNConverter {
	
	private String generateISBN (String val) {
		
		int sum = 0, multiplier = 10;
		
		for (int i = 0; i < val.length(); i++) {
			int temp = (val.charAt(i) - '0') * multiplier--;
			sum += temp;
		}

		int checksum = 11 - (sum % 11);
		
		if (checksum == 10) {
			return val + "x";
		} else if (checksum == 11) {
			return val + "0";
		}
		
		return val + String.valueOf(checksum);

	}

	public static void main(String[] args) {
		
		//Input
		Scanner keyboardInput = new Scanner(System.in);
		
		//Converter
		ISBNConverter converter = new ISBNConverter();
		
		String choice = "Y";
		
		do {
			System.out.print("Enter your product ID: ");
			String productID = keyboardInput.nextLine();	
			String substr = productID.substring(3);
			
			//Convert Product ID to ISBN
			String generatedISBN = converter.generateISBN(substr);
	
			System.out.println("Product ID: " + productID);
			System.out.println("ISBN: " + generatedISBN);
			System.out.println("-----------------------------------");
			
			System.out.print("Another? (Y/N): ");
			choice = keyboardInput.nextLine();
			System.out.println("-----------------------------------");
			
		} while (choice.compareTo("y") == 0 || choice.compareTo("Y") == 0);
	}

}
