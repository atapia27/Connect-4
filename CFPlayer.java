package hw4;

public interface CFPlayer {
  int nextMove(CFGame g);
  int nextMove(CFGame g, int[][] b);
  //return value of getName cannot be "draw"
  String getName();
}