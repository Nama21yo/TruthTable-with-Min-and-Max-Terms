import java.util.ArrayList;
import java.util.Scanner;



public class Main {

	static ArrayList<EquationVariables> variableArray = new ArrayList<>();
	static ArrayList<Object> equationArray = new ArrayList<>();
	public static char[] equation;
	
	/**
	 * The program starts here. The main method parses a String user input.
	 * Letters are stored in EquationVariables, and other characters are stored as Characters
	 * EquationVariaables are placed in a variable array; duplicate letters are only added once
	 * Everything is placed in an Equation array
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Reads in the equation and creates variables for all letters
		
		System.out.println("Enter equation Below:");
		System.out.println("||||||||Some UseFul Instructions||||||||");
		System.out.println("Use * for 'and'");
		System.out.println("Use / for 'or'");
		System.out.println("Use ! for 'negation'");
		System.out.println("Use > for 'Implication'");
		System.out.println("Use ~ for 'BiImplication'");
		System.out.println("Use + for 'Exclusive OR'");
		System.out.println();
		System.out.println("Use this format: a * b + !c * !a  (spaces do not matter/uppercase A is the same as lowercase a)");
		String equation = input.nextLine();
		//removes spaces and upper-case letters from the user input
		equation = equation.replaceAll(" ", "");
		equation = equation.toLowerCase();
		int counter = 1;
		//loops through the equation and stores all characters between a and z in a variable array.
		for (int i = 0; i < equation.length();i++){
			//checks if the character at index i in the equation string is a lowercase letter (a to z)
			if (equation.charAt(i)>='a' && equation.charAt(i)<='z') {
				boolean alreadyExists = false;
				EquationVariables temp = new EquationVariables(equation.charAt(i),true, counter);
				
				//checks for duplicate letters and doesn't add them to the array twice
				for (EquationVariables v : variableArray){
					if (v.getName()==temp.getName()){
						alreadyExists = true;
						temp = v;
					}
				}
				if (!alreadyExists){
					variableArray.add(temp); 
					//doubles the significant bit for each variable that is added
					//First variable has 1, second has 2, third has 4, and so on
					counter = counter*2;
				}
				
				//stores the variable objects that are created in an equation array as well
				equationArray.add(temp);
			}else{
				//any non-letter characters get stored in an equation array
				equationArray.add(equation.charAt(i));
			}
		}
		input.close();
		
		if (variableArray.size() > 0){
			//Creates an instance of the truth table class with the proper parameters
			TruthTableGUI table = new TruthTableGUI(variableArray, equationArray);
			table.constructTable();
		}else{
			System.out.println("No variables found");
		}
	}
	
}
