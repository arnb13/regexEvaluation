import java.util.*;


public class regularExpression {
  public static void main(String[] args) {
  
    Scanner arn = new Scanner(System.in);
    System.out.println("How many regular expressions do you want to give as input ?");
    int f = arn.nextInt();
    String [] regex = new String[f];
    for (int i = 0; i < f; i++) {
      System.out.println("Enter Regular Expression " + (i + 1));
      String a = arn.nextLine();
      while(a.length() == 0) {
       a = arn.nextLine(); 
      }
      regex[i] = a;
      }
    
    System.out.println("enter input string");
    String t = arn.nextLine();
    
    NFA n = new NFA(regex[f - 1]);
    if (n.matched(t)) { 
      System.out.println("YES"); 
    }
  }
}