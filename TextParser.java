import java.util.ArrayList;
import javax.swing.JOptionPane;
public class TextParser {
	public static double parse (String input){
		
		ArrayList<Character> operators = new ArrayList<>();
		ArrayList<Double> numbers = new ArrayList<>();
		int decimalAmount = 0;
		double result;
		double num1 = 0;
		double num2 = 0;
		double temporaryValue = 0;
		
		boolean isNumFinished = true;
		boolean isdecimalPartFishished = true;
		
		for (char c: input.toCharArray()){
			String stringedChar = "" + c;
			if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '=') {
				operators.add(c);
				numbers.add(temporaryValue);
				isNumFinished = true;
				isdecimalPartFishished = true;
				System.out.println("added number "+ temporaryValue);
				System.out.println("length of number  "+ numbers.size());
			}
			else if (c >= '0' && c <= '9') {
				if(isNumFinished){
					
					temporaryValue = Double.parseDouble(stringedChar);
				System.out.println("num is finished "+ temporaryValue);
					isNumFinished = false;
				} else{
					
				System.out.println("num is not finished "+ temporaryValue);
					temporaryValue = temporaryValue*10 + Double.parseDouble(stringedChar);
				}
			}
			else if(c == ',' || c == '.'){
				if(isdecimalPartFishished){
					decimalAmount = 10;
					temporaryValue += Double.parseDouble(stringedChar)/decimalAmount;
					isdecimalPartFishished = false;
				} else{
					decimalAmount *= 10;
					temporaryValue += Double.parseDouble(stringedChar)/decimalAmount;
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"You entered wrong format");
			}
		}
		result = calculate(operators, numbers);
		return result;	
	}
	
	
	private static double calculate(ArrayList<Character> operator, ArrayList<Double> number){
		double temporaryValue = number.get(0);
		
		try{
			for(int i = 0; i < operator.size(); i++){
				switch(operator.get(i)){
					case '+':
					temporaryValue+=number.get(i+1);
					break;
					case '-':
					temporaryValue-=number.get(i+1);
					break;
					case '*':
					temporaryValue*=number.get(i+1);
					break;
					case '/':
					temporaryValue/=number.get(i+1);
					break;
					case '%':
					temporaryValue%=number.get(i+1);
					break;
					default:
					break;
				}
			}
		}
		catch(IndexOutOfBoundsException e){
					System.out.println("number size "+ number.size());
					System.out.println("operator size "+ operator.size());
		}
		return temporaryValue;
	}
}