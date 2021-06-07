import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		new Main();
	}
	
	
	public Main() {
		Postfix pfCalculator = new Postfix();
		
		System.out.println("Geben Sie eine Infx ein:");
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		
		
		
		String postFix = pfCalculator.infixToPostfix(input);
		
		Double result = pfCalculator.evaluate(postFix);
		
		System.out.println("Das Ergebnis ist: " + result);
	}
	
}
