package codejam15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskA {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("/Users/vladimir/Documents/workspaceg/GGL/src/codejam15/A-small-attempt3.in"));
    int T = Integer.valueOf(br.readLine());
    
    PrintWriter writer = new PrintWriter("/Users/vladimir/Documents/workspaceg/GGL/src/codejam15/output.txt", "UTF-8");    
    
    for(int i = 0; i < T; i++) {
      String[] s = br.readLine().split(" ");
      Integer smax = Integer.valueOf(s[0]);
      
      int friends = 0;
      int number = 0;
      
      for(int j = 0; j <= smax; j++) {
        Integer cur = Character.getNumericValue(s[1].charAt(j));
        
        if(number >= j) {          
          number += cur;
        } else if (cur != 0) {
          friends += (j - number);
          number += (cur + friends);
        }
        System.out.println(friends);
      }
      writer.println("Case #" + (i + 1) + ": " + friends);
    } 
    writer.close();
  }
}
