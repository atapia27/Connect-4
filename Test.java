package hw4;

import java.util.Random;
import java.util.Scanner;



public class Test {
  public static void main(String[] args) {


      CFPlayer a = new AlexAI();
      CFPlayer b = new RandomAI();

      new GUICF(a, b);

  }
}