import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Game lox = new Game();
//    System.out.println(lox.number);
    Scanner s = new Scanner(System.in);
    while(true) {
      int g = s.nextInt();
      int a = lox.getA(g);
      int b = lox.getB(g);
      System.out.println(a + " " + b);
      if(b == 4) {
        System.out.println("You'r genius. Number was "+lox.number);
        break;
      }
    }
  }
}
