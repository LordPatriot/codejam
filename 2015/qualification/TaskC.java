package codejam15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class TaskC {
	
	private static Map<Character, Integer> toNum = new HashMap<Character, Integer>();
	private static char[][] mult = {{'1', 'i', 'j', 'k'}, {'i', '1', 'k', 'j'}, {'j', 'k', '1', 'i'}, {'k', 'j', 'i', '1'}};
	private static boolean[][] isNegativeMult = {{false, false, false, false}, 
								{false, true, false, true}, 
								{false, true, true, false}, 
								{false, false, true, true}};
	
	private static boolean[][] isNegativeDiv = {{false, true, true, true}, 
								{false, false, true, false}, 
								{false, false, false, true}, 
								{false, true, false, false}};
	
	private static class Number {
		char value;
		boolean isNegative;
		
		public Number() {
			this.value = 'E';
			isNegative = false;
		}
		
		public Number(char value) {
			this.value = value;
			isNegative = false;
		}
		
		public Number(char value, boolean isNegative) {
			this.value = value;
			this.isNegative = isNegative;
		}
		
		public Number multiply(char ch) {
			boolean negativeTemp = getNegative(isNegative, value, ch);
			char val = mult[toNum.get(value)][toNum.get(ch)];
			return new Number(val, negativeTemp);
		}
		
		public Number multiply(Number n) {
			boolean negativeTemp = getNegative2(isNegative, n.isNegative, value, n.value);
			char val = mult[toNum.get(value)][toNum.get(n.value)];
			return new Number(val, negativeTemp);
		}
		
		public Number divide(Number n) {
			boolean negativeTemp = getNegativeDiv(isNegative, value, n.value);
			char val = mult[toNum.get(value)][toNum.get(n.value)];
			return new Number(val, negativeTemp);
		}
		
		public boolean isEmpty() {
			return(value == 'E'? true : false);
		}
		
		public void setValue(char value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/Users/vladimir/Documents/workspaceg/GGL/src/codejam15/C-small-attempt3.in"));
		int T = Integer.valueOf(br.readLine());

		PrintWriter writer = new PrintWriter("/Users/vladimir/Documents/workspaceg/GGL/src/codejam15/output.txt", "UTF-8");
				
		toNum.put('1', 0);
		toNum.put('i', 1);
		toNum.put('j', 2);
		toNum.put('k', 3);		
		
		
		for (int i = 0; i < T; i++) {				
			String[] s = br.readLine().split(" ");
			int L = Integer.valueOf(s[0]);
			int X = Integer.valueOf(s[1]);
			
			String str = br.readLine();
			String big = "";
			for(int j = 0; j < X; j++) {
				big += str;
			}
			
			str = big;
						
			boolean result = false;
			
			//inner(big, 0, mult, isNegative, toNum);
			
			int index = 0;
			Number left = new Number();			
			
			while(index < str.length()) {
				if(left.isEmpty()) {
					left.setValue(str.charAt(index));
				} else {
					left = left.multiply(str.charAt(index));									
				}
				//System.out.println(left.value + " " + left.isNegative);
				index++;				
			}
									
			Number K = new Number();			
			index = str.length() - 1;
			
			while(!result && index >= 0) {
				
				boolean foundK = false;
				while(index >= 0 && !foundK) {
					if(K.isEmpty()) {
						K.setValue(str.charAt(index));						
					} else {						
						Number leftSymbol = new Number(str.charAt(index));						
						K = leftSymbol.multiply(K);								
					}
					
					//divide
					left = left.divide(new Number(str.charAt(index)));
					
					if(K.value == 'k' && !K.isNegative) {
						foundK = true;
					}
					
					index--;
				}
				
				if(foundK) {
					System.out.println("K found at index " + index);
					// k found
					Number ij = new Number(left.value, left.isNegative);																
					int index2 = index;
					Number J = new Number();
					
					while(!result && index2 >= 0)  {
						if(J.isEmpty()) {
							J.setValue(str.charAt(index2));
							//System.out.println("J = " + J.value + " " + J.isNegative);
						} else {							
							Number leftSymbol = new Number(str.charAt(index2));
							//System.out.println("J = " + leftSymbol.value + " " + leftSymbol.isNegative + " multimplied by " + J.value + " " + J.isNegative);
							J = leftSymbol.multiply(J);	
							//System.out.println("J = " + J.value + " " + J.isNegative);
						}
						
						//divide
						ij = ij.divide(new Number(str.charAt(index2)));											
						
						if(J.value == 'j' && !J.isNegative && ij.value == 'i' && !ij.isNegative) {
							//System.out.println("J found at index " + index2);
							result = true;
							break;
						}
						index2--;
					}
				}
					
				index--;
			}					
			
			writer.println("Case #" + (i + 1) + ": " + (result? "YES" : "NO"));
		}
		writer.close();
	}		
		
	
	private static boolean getNegative(boolean neg, char mult1, char mult2) {
		boolean neg2 = isNegativeMult[toNum.get(mult1)][toNum.get(mult2)];
		
		if((neg2 && neg) || (!neg2 && !neg)) {
			return false;
		} else {
			return true;
		}
	}
	
	private static boolean getNegative2(boolean neg, boolean neg3, char mult1, char mult2) {
		boolean neg2 = isNegativeMult[toNum.get(mult1)][toNum.get(mult2)];
		
		if((neg2 && neg) || (!neg2 && !neg)) {
			return neg3 || false;
		} else {
			return neg3? false : true;
		}
	}	

	private static boolean getNegativeDiv(boolean neg, char mult1, char mult2) {
		boolean neg2 = isNegativeDiv[toNum.get(mult1)][toNum.get(mult2)];
		
		if((neg2 && neg) || (!neg2 && !neg)) {
			return false;
		} else {
			return true;
		}
	}
	
	
}
