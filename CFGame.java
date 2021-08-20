//GUI play and play  sometimes play on the wrong column, watch out for that
//isGameOver also indexing issue sometimes 

//you can manually set state variable, to make it a column of red or red
//in main function or constructor


package hw4;

public class CFGame {
  //state[i][j]= 0 means the i,j slot is empty
  //state[i][j]= 1 means the i,j slot has red
  //state[i][j]=-1 means the i,j slot has black
  private final int[][] state;
  private boolean isRedTurn;

  //set up in isGameOVer(), used in winner()
  private int whichWinner = 0;

  
  //7 columns by 6 rows
  {
    state = new int[7][6];
    for (int i=0; i<7; i++)
      for (int j=0; j<6; j++)
        state[i][j] = 0;
    isRedTurn = true; //red goes first
  }
    
  public int[][] getState() {
    int[][] ret_arr = new int[7][6];
    for (int i=0; i<7; i++)
      for (int j=0; j<6; j++)
        ret_arr[i][j] = state[i][j];
    return ret_arr;
  }
  
  public boolean isRedTurn() {
    return isRedTurn;
  }
  
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////// play
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  

  public boolean play(int column) {

    int val = 0;

//if column # is greater than 7, or less than 1 return false
    if(column > 7 || column < 1)
        return false;


    column = column - 1;  //this will allow us to use the appropriate index


  //check the top of the column, since it represents a full column
  // if it is NOT empty, return false (AKA it is full)
    if(state[column][5] != 0)  //use 5 to check the 5th index, the 6th (top) value of the column
        return false;


// AFTER CHECKING THE CONDITIONS THAT MAKE THIS FALSE, WE CAN GO AHEAD AND PLAY

    for(int i = 0; i < 6; i++){
        //check the last row where there is a value is 0
        if(state[column][i] == 0){
            //update val so that we get the last position where i == 0 ( where i is empty)
             val = i;
             //once we find the first empty value, we can break
             break;
        }

    }

//depending on whose turn it is, set the value of the grid to 1 or -1, at the next empty position in the column

    if(isRedTurn == true){
        state[column][val] = 1;

        //after the play, we change the turn of the player
        isRedTurn = false;
    }
    else{
        state[column][val] = -1;
        //after the play, we change the turn of the player
        isRedTurn = true;
    }
        

        
    return true;
    }

    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////// isGameOver:
/////// Checks win condition, returns true if game is over; Updates int whichWinner to 1(red)-1(black) or 0()
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
  

  public boolean isGameOver() {

    //check for horizontal win

    for(int col = 0; col < 7-3; col++){         //col set max at 7-3 so we don't go out of range (less than 4, max 3)
        for (int row = 0; row < 6;row++){   
            if (state[col][row] == 1   && 
                state[col+1][row] == 1 &&
                state[col+2][row] == 1 &&       //check for red horizontal win
                state[col+3][row] == 1){
                    
                    whichWinner = 1;
                    return true;
                }
                
                
             else if(state[col][row] == -1   &&      //check for black horizontal win
                state[col+1][row] == -1 &&
                state[col+2][row] == -1 &&
                state[col+3][row] == -1){

                    whichWinner = -1;
                    return true;
            }
        }			
    }

    //check for vertical win

    for(int col = 0; col < 7; col++){
        for (int row = 0; row < 6-3;row++){   //row set max at 6-3 so we don't go out of range
            if (state[col][row] == 1   && 
                state[col][row+1] == 1 &&
                state[col][row+2] == 1 &&       //check for red vertical win
                state[col][row+3] == 1){
                    
                    whichWinner = 1;
                    return true;
                }

            else if(state[col][row] == -1   &&      //check for black vertical win
                state[col][row+1] == -1 &&
                state[col][row+2] == -1 &&
                state[col][row+3] == -1){
                    
                    whichWinner = -1;
                    return true;
                }
        }			
    }

    //check for down diagonal win

    for(int col = 0; col < 7-3; col++){     //col set at max 7-3 so we dont go out of range
        for (int row = 3; row < 6;row++){   //row set min 3 so we don't go out of range
            if (state[col][row] == 1   && 
                state[col+1][row-1] == 1 &&
                state[col+2][row-2] == 1 &&       //check for red vertical win
                state[col+3][row-3] == 1){
                    
                    whichWinner = 1;
                    return true;
                }

            else if(state[col][row] == -1   &&      //check for black vertical win
                state[col+1][row-1] == -1 &&
                state[col+2][row-2] == -1 &&
                state[col+3][row-3] == -1){
                    
                    whichWinner = -1;
                    return true;
                }
        }			
    }

    //check for up diagonal win    

    for(int col = 0; col < 7-3; col++){     //col set at max 7-3 so we dont go out of range
        for (int row = 0; row < 6-3;row++){   //row set min 3 so we don't go out of range
            if (state[col][row] == 1   && 
                state[col+1][row+1] == 1 &&
                state[col+2][row+2] == 1 &&       //check for red vertical win
                state[col+3][row+3] == 1){
                    
                    whichWinner = 1;
                    return true;
                }
            else if(state[col][row] == -1   &&      //check for black vertical win
                state[col+1][row+1] == -1 &&
                state[col+2][row+2] == -1 &&
                state[col+3][row+3] == -1){
                    
                    whichWinner = -1;
                    return true;
                }
        }			
    }

    //if ALL the columns are full, return true
    if(state[0][5] != 0 &&
        state[1][5] != 0 &&
        state[2][5] != 0 &&
        state[3][5] != 0 &&
        state[4][5] != 0 &&
        state[5][5] != 0 &&
        state[6][5] != 0 ){ //again, we use 5 to check the 5th index(top of the column)
            
            whichWinner = 0;
            return true;

        }   

    //lastly, return false if neither of the previous return true

    return false;


  }
  
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////// winner
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

//when gameover is called, we can tell who the winner
//^ this sets a varialbe that declares who the variable is
// winner just returns the value of the varialbe
// returns final int that depits teh winner

  public int winner() {

    return whichWinner;

  }
}