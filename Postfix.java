import java.util.Scanner;

public class Postfix {

	private String operators = "+-*/^()";
	
	
	public Double evaluate(String postFix){
		StackAsList <Double> stack = new StackAsList<Double>();
		//StackAsList	Stack = new StackAsList();
		Scanner sc = new Scanner(postFix);
		
		
		while (sc.hasNext()) {
			String str = sc.next();
			if(!operators.contains(str)) {
				double digit = Double.parseDouble(str);
				stack.push(digit);
			}
			else {
				double rhs = stack.pop();
				double lhs = stack.pop();
				
				if (str.equals("^")) stack.push(Math.pow(lhs, rhs));
				else if (str.equals("/")) stack.push(lhs / rhs);
				else if (str.equals("*")) stack.push(lhs * rhs);
				else if (str.equals("+")) stack.push(lhs + rhs);
				else if (str.equals("-")) stack.push(lhs - rhs);
				else System.out.print("Operator " + str + " is not implemented");
			}
		}
		
		return stack.pop();
		
	}
	
	public String getOperators(){
		return operators;
	}
	
	public String infixToPostfix (String inFix){
		StackAsList <String> stack = new StackAsList<String>();
		
		Scanner sc = new Scanner(inFix);
		String postFix = "";
		while (sc.hasNext()) {
			String str = sc.next();
			if(!operators.contains(str)) {
				if (!postFix.equals("")) {
				postFix = postFix + " " +  str;
				}
				else postFix = postFix +  str;
			}
			else if (str.equals("(")) stack.push(str);
			else if (str.equals(")")) {
				while (!stack.peek().equals("(")) {
					postFix = postFix + " " + stack.peek();
					stack.pop();
				}
				stack.pop();
			}
			else if(operators.contains(str)) {
				if (stack.isEmpty()) {
					stack.push(str);
				}
				else {
					while (!(checkPrecidence(stack.peek()) < checkPrecidence(str) ||  ((str.equals("^")   &&  checkPrecidence(stack.peek()) == checkPrecidence(str)))))
					{
					postFix = postFix +  " " + stack.peek();
					stack.pop();
					}
					stack.push(str);
				}
			}
			}
		
		while (!stack.isEmpty()) {
			postFix = postFix + " " + stack.peek();
			stack.pop();
		}
		
		return postFix;
		}
	
	public int checkPrecidence(String str){
		if (str.equals("+") || str.equals("-")) return 0;
		else if (str.equals("/") || str.equals("*")) return 1;
		else if (str.equals("^")) return 2;
		return -1;
	}
	
	}
	

