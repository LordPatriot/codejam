package codejam15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class TaskD {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/Users/vladimir/Documents/workspaceg/GGL/src/codejam15/D-small-attempt1.in"));
		int T = Integer.valueOf(br.readLine());

		PrintWriter writer = new PrintWriter("/Users/vladimir/Documents/workspaceg/GGL/src/codejam15/output.txt", "UTF-8");

		for (int i = 0; i < T; i++) {				
			String[] s = br.readLine().split(" ");
			int X = Integer.valueOf(s[0]);
			int R = Integer.valueOf(s[1]);
			int C = Integer.valueOf(s[2]);
			
			boolean match = true;
			
			if(R == 1 && C == 1) {
				if(X == 1) {
					match = true;
				} else {
					match = false;
				}
			} else if((R == 2 && C == 1) || (R == 1 && C == 2)) {
				if(X == 1 || X == 2) {
					match = true;
				} else {
					match = false;
				}
			} else if((R == 3 && C == 1) || (R == 1 && C == 3)) {
				if(X == 1) {
					match = true;
				} else {
					match = false;
				}
			} else if((R == 4 && C == 1) || (R == 1 && C == 4)) {
				if(X == 1 || X == 2) {
					match = true;
				} else {
					match = false;
				}			
			} else if((R == 3 && C == 2) || (R == 2 && C == 3)) {
				if(X == 1 || X == 2 || X == 3) {
					match = true;
				} else {
					match = false;
				}
			} else if((R == 4 && C == 2) || (R == 2 && C == 4)) {
				if(X == 1 || X == 2) {
					match = true;
				} else {
					match = false;
				}
			} else if((R == 4 && C == 3) || (R == 3 && C == 4)) {
				match = true;
			} else if(R == 2 && C == 2) {
				if(X == 1 || X == 2) {
					match = true;
				} else {
					match = false;
				}
			} else if(R == 3 && C == 3) {
				if(X == 1 || X == 3) {
					match = true;
				} else {
					match = false;
				}
			} else if(R == 4 && C == 4) {
				if(X == 1 || X == 2 || X == 4) {
					match = true;
				} else {
					match = false;
				}
			} 
			
			
			writer.println("Case #" + (i + 1) + ": " + ((match)? "GABRIEL" : "RICHARD"));
		}
		writer.close();
	}
}
