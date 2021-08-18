import java.util.ArrayList;
import java.util.Scanner;

class Main {
  public static void main(String... args) {
    ArrayList<Short> open = new ArrayList<Short>();
    for(short i=0000; i<10000; i++) {
      if(checkNumber(i))
        open.add(i);
    }

    Scanner s = new Scanner(System.in);
    while(open.size() != 1) {
      int guess = open.get(0);
      System.out.println(open.size() + " " + nym(guess));
      System.out.print("Type A: ");
      int a = s.nextInt();
      System.out.print("Type B: ");
      int b = s.nextInt();

      ArrayList<Short> newOpen = new ArrayList<Short>();
      for(int i=0; i<open.size(); i++) {
        Game g1 = new Game((int) open.get(i));
        int a1 = g1.getA(guess);
        int b1 = g1.getB(guess);
        if(a1 == a && b == b1)
          newOpen.add(open.get(i));
      }
      open = newOpen;
      if(open.size() < 5) {
        System.out.print("Check mine guess: ");
        for(int i=0; i<open.size(); i++) {
          System.out.print(nym(open.get(i)) + ", ");
        }
        System.out.println("");
      }
    }
    System.out.println(nym(open.get(0)));
  }
  private static boolean checkNumber(int n) {
    int a1 = n % 10;
    int a2 = (int) (n / 10) % 10;
    int a3 = (int) (n / 100) % 10;
    int a4 = (int) (n / 1000) % 10;
    if(a1 == a2 || a1 == a3 || a1 == a4 || a2 == a3 || a2 == a4 || a3 == a4) {
      return false;
    }
    return true;
  }
  private static String nym(int n) {
    if(n < 1000) {
      return "0" + n;
    }
    return ""+n;
  }
}
