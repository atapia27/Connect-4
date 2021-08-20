package hw4;
import java.util.Scanner;


public class ConsoleCF extends CFGame{
    
    //set up game and human player variable
    //idk how many variables im supposed to have???
    //CFPlayer, AlexAI, and RandomAI all contain a  int nextMove(CFGame g) argument 
    //they all have a game!
    
    private HumanPlayer h;
    private CFPlayer AI;
    private CFPlayer AI1;
    private CFPlayer AI2;



    //randomly decided
    //if this is true, then AI will become red player (constructor 1)
    private boolean isRedPlayerAI;    
    


    //randomnly decided
    //if this is true, then AI1 will become red player (constructor 2)
    private boolean isRedPlayerAI1;
    

    //checks which constructor is used
    private boolean firstConstructorUsed;



   

    public ConsoleCF(CFPlayer ai){
    
        int x = (int)(2*Math.random())+1;
        AI = ai;

        if(x == 2){
            isRedPlayerAI = true;
        }
            
        else{
            isRedPlayerAI = false;
        }

        firstConstructorUsed = true;
    }
    
    public ConsoleCF(CFPlayer ai1, CFPlayer ai2){

        int x = (int)(2*Math.random())+1;


        AI1 = ai1;
        AI2 = ai2;

        if(x == 2){
            isRedPlayerAI1 = true;
        }
            
        else{
            isRedPlayerAI1 = false;
        }
        
        firstConstructorUsed = false;
    }
    
    public void playOut(){

        boolean condition = false;

    ///////////////////////////////////////////////////////////////////
    //IF WE USED THE FIRST CONSTRUCTOR
    //////////////////////////////////////////////////////////////////
    if(firstConstructorUsed == true){

        h = new HumanPlayer();

        //red always goes first,so check who is red
       if(isRedPlayerAI){
           play(AI.nextMove(this));
       }
       if(isRedPlayerAI == false){
           play(h.nextMove(this));
       }



       while (condition == false){
           
           if(isRedPlayerAI){
               //if its red turn, play
               if(this.isRedTurn()){
                   play(AI.nextMove(this));
               }

               else{
                   play(h.nextMove(this));
               }                
           }

           if(isRedPlayerAI == false){
               //if its red turn, play
               if(this.isRedTurn()){
                   play(h.nextMove(this));
               }

               else{
                   play(AI.nextMove(this));
               }                
           }

           condition = this.isGameOver();
       }

       //display the winner / draw 

       if(isRedPlayerAI){
           if(winner() == 1)
               System.out.println("The winner is " + AI.getName());
           if(winner() == -1)
               System.out.println("The winner is " + h.getName());
       }

       if(isRedPlayerAI == false){
           if(winner() == 1)
               System.out.println("The winner is " + h.getName());
           if(winner() == -1)
               System.out.println("The winner is " + AI.getName());
       }


       if(winner() == 0)
           System.out.println("This game ends in a draw!");    
   }
      
   

    //////////////////////////////////////////////////////////////////
    //IF WE USED THE SECOND CONSTRUCTOR
    //////////////////////////////////////////////////////////////////
    if(firstConstructorUsed == false){

         //red always goes first,so check who is red
        if(isRedPlayerAI1){
            play(AI1.nextMove(this));
        }
        if(isRedPlayerAI1 == false){
            play(AI2.nextMove(this));
        }

 

        while (condition == false){
            
            if(isRedPlayerAI1){
                //if its red turn, play
                if(this.isRedTurn()){
                    play(AI1.nextMove(this));
                }

                else{
                    play(AI2.nextMove(this));
                }                
            }

            if(isRedPlayerAI1 == false){
                //if its red turn, play
                if(this.isRedTurn()){
                    play(AI2.nextMove(this));
                }

                else{
                    play(AI1.nextMove(this));
                }                
            }

            condition = this.isGameOver();
        }

       //display the winner / draw 
        printBoard();

        if(isRedPlayerAI1){
            if(winner() == 1)
                System.out.println("The winner is " + AI1.getName());
            if(winner() == -1)
                System.out.println("The winner is " + AI2.getName());
        }

        if(isRedPlayerAI1 == false){
            if(winner() == 1)
                System.out.println("The winner is " + AI2.getName());
            if(winner() == -1)
                System.out.println("The winner is " + AI1.getName());
        }


        if(winner() == 0)
            System.out.println("This game ends in a draw!");    
    }
       

            
}

    public String getWinner(){

        int x = winner();

        //if the red player wins
        if(x == 1){
            if (firstConstructorUsed == true){
                //if the red player is the AI
                if(isRedPlayerAI){ 
                    return AI.getName(); }
                //if red player is human
                else if(isRedPlayerAI == false){return h.getName();}
            }
            
                
            if (firstConstructorUsed == false){
                //if the red player is AI1
                if(isRedPlayerAI1){ return AI1.getName(); }
                //if red player is AI2
                else if(isRedPlayerAI1 == false){ return AI2.getName(); }
            }
            

                
            }
        if(x == -1){

            if (firstConstructorUsed == true){
                //if the red player is the AI
                if(isRedPlayerAI){ return h.getName(); }
                //if red player is human
                else if(isRedPlayerAI ==false){return AI.getName();}                
            }

            if (firstConstructorUsed == false){
                //if the red player is AI1
                if(isRedPlayerAI1){ return AI2.getName(); }
                //if red player is AI2
                else if(isRedPlayerAI1 == false){ return AI1.getName(); }
            }
            
                
            }
    
    //in the case it is not 1 or -1 (its    )
    return "Draw";
        
        
    }

    public void printBoard(){

                    //print the state of the board to the command line
                    int[][] myGrid = getState();

                    System.out.println("   1   2   3   4   5   6   7   ");
                    System.out.println(" - - - - - - - - - - - - - - - ");
                    for (int row = 5; row > -1; row--){
                        System.out.print(" | ");
                        for (int col = 0; col < 7; col++){
                            System.out.print(myGrid[col][row]);
                            System.out.print(" | ");
                        }
                        System.out.println();
                        System.out.println(" - - - - - - - - - - - - - - - ");
                    }
                    System.out.println("   1   2   3   4   5   6   7   ");
                    System.out.println(); 
    }

    private class HumanPlayer implements CFPlayer{

        @Override
        public int nextMove(CFGame g) {
            
            //print the state of the board to the command line
            printBoard();

            //ask the user for the next move
            System.out.println("Plese enter your next move:"); 
            Scanner reader = new Scanner(System.in);
            int i = reader.nextInt();

            //If the provided move is invalid, say so and ask again for a valid move.
            while(i < 1 || i > 7){
                System.out.println("Invalid input, please enter a number between 1 and 7");
                i = reader.nextInt();
            }

            return i; 
        }

        @Override
        public String getName() {
            return "Human Player";
        }
        
    }




}
