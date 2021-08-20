package hw4;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class GUICF extends CFGame {

    private CFPlayer AI;
    private CFPlayer AI1;
    private CFPlayer AI2;
    private boolean isRedPlayerAI;
    private boolean isRedPlayerAI1;
    private boolean isRedTurn;
    private boolean condition;
    private boolean wasItClicked;
    private int whichWinner;

    private JFrame frame;
    private JPanel panel;
    private JPanel grid;
    private GameBoard this_board; // represents the graphics for the 6x7 board, but not the buttons
    private JLabel slots[][];
    private JButton[] buttons;

    // going to use this to check the myBoard
    private int[][] myBoard;

    private class BL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            clicked();
        }
    }
    
    private class BL1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //lets say this is for button 1
            //we want it to access grid and change using paint
            
            //these should call playGUI, which will in turn call paint

            //slots[7][6] for reference:
            //paint(c, row, 1(red) or -1(black)
            //in this case, (0,x,1(red) -1(black))

            //maybe add a statement about how play will only work if its your turn
            playGUI(1);
        }

    }

    private class BL2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //lets say this is for button 1
            //we want it to access grid and change using paint
            
            //paint(c, row, 1(red) or -1(black)
            //in this case, (0,x,1(red) -1(black))
            //maybe add a statement about how play will only work if its your turn
            playGUI(2);
        }

    }
    
    private class BL3 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //lets say this is for button 1
            //we want it to access grid and change using paint
            
            //paint(c, row, 1(red) or -1(black)
            //in this case, (0,x,1(red) -1(black))
            //maybe add a statement about how play will only work if its your turn
            playGUI(3);
        }

    }

    private class BL4 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //lets say this is for button 1
            //we want it to access grid and change using paint
            
            //paint(c, row, 1(red) or -1(black)
            //in this case, (0,x,1(red) -1(black))
            //maybe add a statement about how play will only work if its your turn
            playGUI(4);
        }

    }

    private class BL5 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //lets say this is for button 1
            //we want it to access grid and change using paint
            
            //paint(c, row, 1(red) or -1(black)
            //in this case, (0,x,1(red) -1(black))
            //maybe add a statement about how play will only work if its your turn
            playGUI(5);
        }

    }

    private class BL6 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //lets say this is for button 1
            //we want it to access grid and change using paint
            
            //paint(c, row, 1(red) or -1(black)
            //in this case, (0,x,1(red) -1(black))
            //maybe add a statement about how play will only work if its your turn
            playGUI(6);
        }

    }

    private class BL7 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //lets say this is for button 1
            //we want it to access grid and change using paint
            
            //paint(c, row, 1(red) or -1(black)
            //in this case, (0,x,1(red) -1(black))
            //maybe add a statement about how play will only work if its your turn
            playGUI(7);
        }

    }











    public boolean isGUIGameOver(){
            //check for horizontal win

    for(int col = 0; col < 7-3; col++){         //col set max at 7-3 so we don't go out of range (less than 4, max 3)
    for (int row = 0; row < 6;row++){   
        if (myBoard[col][row] == 1   && 
            myBoard[col+1][row] == 1 &&
            myBoard[col+2][row] == 1 &&       //check for red horizontal win
            myBoard[col+3][row] == 1){
                
                whichWinner = 1;
                return true;
            }
            
            
         else if(myBoard[col][row] == -1   &&      //check for black horizontal win
            myBoard[col+1][row] == -1 &&
            myBoard[col+2][row] == -1 &&
            myBoard[col+3][row] == -1){

                whichWinner = -1;
                return true;
        }
    }			
}

//check for vertical win

for(int col = 0; col < 7; col++){
    for (int row = 0; row < 6-3;row++){   //row set max at 6-3 so we don't go out of range
        if (myBoard[col][row] == 1   && 
            myBoard[col][row+1] == 1 &&
            myBoard[col][row+2] == 1 &&       //check for red vertical win
            myBoard[col][row+3] == 1){
                
                whichWinner = 1;
                return true;
            }

        else if(myBoard[col][row] == -1   &&      //check for black vertical win
            myBoard[col][row+1] == -1 &&
            myBoard[col][row+2] == -1 &&
            myBoard[col][row+3] == -1){
                
                whichWinner = -1;
                return true;
            }
    }			
}

//check for down diagonal win

for(int col = 0; col < 7-3; col++){     //col set at max 7-3 so we dont go out of range
    for (int row = 3; row < 6;row++){   //row set min 3 so we don't go out of range
        if (myBoard[col][row] == 1   && 
            myBoard[col+1][row-1] == 1 &&
            myBoard[col+2][row-2] == 1 &&       //check for red vertical win
            myBoard[col+3][row-3] == 1){
                
                whichWinner = 1;
                return true;
            }

        else if(myBoard[col][row] == -1   &&      //check for black vertical win
            myBoard[col+1][row-1] == -1 &&
            myBoard[col+2][row-2] == -1 &&
            myBoard[col+3][row-3] == -1){
                
                whichWinner = -1;
                return true;
            }
    }			
}

//check for up diagonal win    

for(int col = 0; col < 7-3; col++){     //col set at max 7-3 so we dont go out of range
    for (int row = 0; row < 6-3;row++){   //row set min 3 so we don't go out of range
        if (myBoard[col][row] == 1   && 
            myBoard[col+1][row+1] == 1 &&
            myBoard[col+2][row+2] == 1 &&       //check for red vertical win
            myBoard[col+3][row+3] == 1){
                
                whichWinner = 1;
                return true;
            }
        else if(myBoard[col][row] == -1   &&      //check for black vertical win
            myBoard[col+1][row+1] == -1 &&
            myBoard[col+2][row+2] == -1 &&
            myBoard[col+3][row+3] == -1){
                
                whichWinner = -1;
                return true;
            }
    }			
}

//if ALL the columns are full, return true
if(myBoard[0][5] != 0 &&
    myBoard[1][5] != 0 &&
    myBoard[2][5] != 0 &&
    myBoard[3][5] != 0 &&
    myBoard[4][5] != 0 &&
    myBoard[5][5] != 0 &&
    myBoard[6][5] != 0 ){ //again, we use 5 to check the 5th index(top of the column)
        
        whichWinner = 0;
        return true;

    }   

//lastly, return false if neither of the previous return true

return false;


    }

    public boolean clicked(){

        wasItClicked = true;

        return wasItClicked;

    }

    public GUICF(CFPlayer ai) {

        ///////////////////////////////////////////////////////////////////////////////////
        /// Decide Red Player
        ///////////////////////////////////////////////////////////////////////////////////
        
        int x = (int)(2*Math.random())+1;
        AI = ai;

        if(x == 2){
            isRedPlayerAI = true;
        }
            
        else{
            isRedPlayerAI = false;
        }

        isRedTurn = true;


        
        ///////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////

        //initiate the grid
        this_board = new GameBoard();        

        
		frame = new JFrame("Connect 4");
        //this will contain the buttons(NORTH) and the grid(CENTER) from this_board
		panel = new JPanel(new BorderLayout());
        //creates a JPanel grid that will contain 7 buttons in a row
        JPanel topButtons = new JPanel(new GridLayout(1, 7));
        //buttons to be
        buttons = new JButton[7];  

        //this should probably be inside of the playOut function
        for (int i = 0; i < 7; i++) {
            buttons[i] = new JButton("\u2193");
            topButtons.add(buttons[i], BorderLayout.CENTER);
        }

        //assign a unique actionListener to each
        buttons[0].addActionListener(new BL1());
        buttons[1].addActionListener(new BL2());
        buttons[2].addActionListener(new BL3());
        buttons[3].addActionListener(new BL4());
        buttons[4].addActionListener(new BL5());
        buttons[5].addActionListener(new BL6());
        buttons[6].addActionListener(new BL7());        


        
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(2);
		     

        panel.add(topButtons, BorderLayout.NORTH);
		panel.add(grid, BorderLayout.CENTER);	

                
        frame.add(panel);

        frame.setVisible(true);



        //////////////////////////////////////////////////////////////////////////
        //PLAY THE GAME
        ////////////////////////////////////////////////////////////////////////

        // we only want to make the AI move here since we click to play


        //if AI is red and its his turn, he plays
    
        condition = false; 

        while(condition == false){

            if(isRedPlayerAI && this.isRedTurn){
                playGUI(AI.nextMove(this, myBoard));
            }

            //if AI is not red, and it is its turn
            if(isRedPlayerAI == false && this.isRedTurn == false){        
                playGUI(AI.nextMove(this, myBoard));
            }

            condition = this.isGUIGameOver();
        }
        
               //display the winner / draw 

       if(isRedPlayerAI){
            if(whichWinner == 1)
                System.out.println("The winner is " + AI.getName());
            if(whichWinner == -1)
                System.out.println("The winner is " + "Human Player");
        }

        if(isRedPlayerAI == false){
            if(whichWinner == 1)
                System.out.println("The winner is " + "Human Player");
            if(whichWinner == -1)
                System.out.println("The winner is " + AI.getName());
        }


        if(whichWinner == 0)
            System.out.println("This game ends in a draw!");
    
        frame.setVisible(false);
        frame.dispose();
    }

    public GUICF (CFPlayer ai1, CFPlayer ai2) {


        ///////////////////////////////////////////////////////////////////////////////////
        /// Decide Red Player
        ///////////////////////////////////////////////////////////////////////////////////
        
        int x = (int)(2*Math.random())+1;
        AI1 = ai1;
        AI2 = ai2;

        if(x == 2){
            isRedPlayerAI1 = true;
        }
            
        else{
            isRedPlayerAI1 = false;
        }

        isRedTurn = true;

        ///////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////

        //initiate the grid
        this_board = new GameBoard();        

        
		frame = new JFrame("Connect 4");
        //this will contain the button(NORTH) and the grid(CENTER) from this_board
		panel = new JPanel(new BorderLayout());
        
        JButton button = new JButton("Play");

        //creates a JPanel grid that will contain button in the middle
        JPanel topButtons = new JPanel(new GridLayout(1, 7));

        
        topButtons.add(button, BorderLayout.CENTER);
    

        //assign a unique actionListener to each
        button.addActionListener(new BL());

        frame.setSize(500, 500);
		frame.setDefaultCloseOperation(2);
		     

        panel.add(topButtons, BorderLayout.NORTH);
		panel.add(grid, BorderLayout.CENTER);	

                
        frame.add(panel);

        frame.setVisible(true);



        //////////////////////////////////////////////////////////////////////////
        //PLAY THE GAME
        ////////////////////////////////////////////////////////////////////////
        condition = false; 

        while(condition == false){
        
            if(wasItClicked == true){
                
                    if(isRedPlayerAI1){
                    //if its red turn, play
                    if(this.isRedTurn()){
                        playGUI(AI1.nextMove(this));
                    }

                    else{
                        playGUI(AI2.nextMove(this));
                    }                
                }

                if(isRedPlayerAI1 == false){
                    //if its red turn, play
                    if(this.isRedTurn()){
                        playGUI(AI2.nextMove(this));
                    }

                    else{
                        playGUI(AI1.nextMove(this));
                    }                
                }
                wasItClicked = false;
            }


            condition = this.isGUIGameOver();
        }
        
        //display the winner / draw 

        if(isRedPlayerAI1){
            if(whichWinner == 1)
                System.out.println("The winner is " + AI1.getName());
            if(whichWinner == -1)
                System.out.println("The winner is " + AI2.getName());
        }

        if(isRedPlayerAI1 == false){
            if(whichWinner == 1)
                System.out.println("The winner is " + AI2.getName());
            if(whichWinner == -1)
                System.out.println("The winner is " + AI1.getName());
        }


        if(whichWinner == 0)
            System.out.println("This game ends in a draw!");
    
        frame.setVisible(false);
        frame.dispose();

		
	}
	
	private boolean playGUI(int c) {
    
        int val = 0;

            if(c > 7 || c < 1)
                return false;
        
            c = c - 1;  
        
        
            if(myBoard[c][5] != 0)  
                return false;
        
            for(int i = 0; i < 6; i++){
                if(myBoard[c][i] == 0){
                     val = i;
                     break;
                }
        
            }
        
            //BY CALLING PAINT WE UPDATE BOTH 
            //grid AND myBoard
        
            if(isRedTurn == true){
                this_board.paint(c,val,1);
                
        
                //after the play, we change the turn of the player
                isRedTurn = false;
            }
            else{
                this_board.paint(c,val,-1);
                //after the play, we change the turn of the player
                isRedTurn = true;
            }
                
        
                
            return true;
        
    }
	
	private class GameBoard extends javax.swing.JPanel {
		
        //NOTE
        //I want GameBoard members to update both JLabel slots and
        //int[][] myBoard so that I can use CFGame logic to decide when to end

		private GameBoard() {
			
            //Graphical Interface of the Gameboard 
			grid = new JPanel(new GridLayout(6, 7));
			grid.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			slots = new JLabel[7][6];

			for (int row = 5; row > -1; row--) {
				for (int col = 0; col < 7; col++) {
					slots[col][row] = new JLabel();
					slots[col][row].setBorder(BorderFactory.createLineBorder(Color.BLACK));
					grid.add(slots[col][row], BorderLayout.CENTER);
				}
			}

            //Here, I want to check the actual int[][] myBoard
            //since getState is initialized within a block in CFGame, getState() should return a matrix = 0
            
            myBoard = new int[7][6];
            for (int i=0; i<7; i++)
              for (int j=0; j<6; j++)
                myBoard[i][j] = 0;
			
    
		}
		
        //1 is red
        //-1 is black
		private void paint(int x, int y, int color) {
                        
            //again, I want to change the actual int[][] myBoard
            myBoard[x][y] = color;
            // System.out.println(x + " , " + y + " displays: " + myBoard[x][y]);
            // System.out.println();

            //this will update the graphical interface
			if (color == 1) {
				slots[x][y].setBackground(Color.RED);
				slots[x][y].setOpaque(true);
			}
			if (color == -1) {
				slots[x][y].setBackground(Color.BLACK);
				slots[x][y].setOpaque(true);
			}




		}
	
    }
        
}
