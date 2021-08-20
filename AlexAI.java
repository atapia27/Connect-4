package hw4;

public class AlexAI implements CFPlayer {

 @Override
    public int nextMove(CFGame g) {

    //we set g.getState to our own state
    int[][] a = g.getState();


    //we want to make the AI play the column that has a potnetial to be won by either red or black
    //we want to check every single option to win, including when there's 3 RED OR BLACK in a row

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//// check for POSSIBLE up HORIZONTAL win for RED (1) AND BLACK (-1)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
        for(int col = 0; col < 7-3; col++){         //col set max at 7-3 so we don't go out of range
        for (int row = 0; row < 6;row++){   
            if ((a[col][row] == 1   && 
                a[col+1][row] == 1 &&
                a[col+2][row] == 1) ||
                (a[col][row] == -1   && 
                a[col+1][row] == -1 &&
                a[col+2][row] == -1)){
                
                    if(a[col+3][row] == 0)
                        return col+4; //will have a +1 so that we are playing a "legal column"
                }
           if ((a[col][row] == 1   && 
                a[col+1][row] == 1 &&
                a[col+3][row] == 1) ||
                (a[col][row] == -1   && 
                a[col+1][row] == -1 &&
                a[col+3][row] == -1)){
                
                    if(a[col+2][row] == 0)                    
                        return col+3;   //will have a +1 so that we are playing a "legal column"
                }
            if ((a[col][row] == 1   && 
                a[col+2][row] == 1 &&
                a[col+3][row] == 1) ||
                (a[col][row] == -1   && 
                a[col+2][row] == -1 &&
                a[col+3][row] == -1)){

                    if(a[col+1][row] == 0)                    
                        return col+2;   //will have a +1 so that we are playing a "legal column"
                }
             if ((a[col+1][row] == 1   && 
                a[col+2][row] == 1 &&
                a[col+3][row] == 1) ||
                (a[col+1][row] == -1   && 
                a[col+2][row] == -1 &&
                a[col+3][row] == -1)){
                
                    if(a[col][row] == 0)                    
                        return col+1;   //will have a +1 so that we are playing a "legal column"
                }
            }
        }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//// check for POSSIBLE  VERTICAL win for RED (1) AND BLACK (-1)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //SINCE THESE ARE VERTICAL, IT CANNOT BE POSSIBLE TO HAVE ONE MISSING PIECE BETWEEN RED OR BLACK
        //therefore we only check if the bottom threw rows have the same values

        for(int col = 0; col < 7; col++){
        for (int row = 0; row < 6-3;row++){   //row set max at 6-3 so we don't go out of range
            if ((a[col][row] == 1   && 
                a[col][row+1] == 1 &&
                a[col][row+2] == 1) ||
                (a[col][row] == -1   && 
                a[col][row+1] == -1 &&
                a[col][row+2] == -1)){
                   
                    if(a[col][row+3] == 0)   
                        return col+1;   //will have a +1 so that we are playing a "legal column"
                }
        }			
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//// check for POSSIBLE DOWN DIAGONAL win for RED (1) AND BLACK (-1)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        for(int col = 0; col < 7-3; col++){     //col set at max 7-3 so we dont go out of range
        for (int row = 3; row < 6;row++){   //row set min 2 so we don't go out of range
            if ((a[col][row] == 1   && 
                a[col+1][row-1] == 1 &&
                a[col+2][row-2] == 1) ||
                (a[col][row] == -1   && 
                a[col+1][row-1] == -1 &&
                a[col+2][row-2] == -1)){
                    
                if(a[col+3][row-3] == 0)
                    return col + 4; //will have a +1 so that we are playing a "legal column"
                }
            if ((a[col][row] == 1   && 
                a[col+1][row-1] == 1 &&
                a[col+3][row-3] == 1) ||
                (a[col][row] == -1   && 
                a[col+1][row-1] == -1 &&
                a[col+3][row-3] == -1)){

                if(a[col+2][row-2] == 0)                    
                    return col + 3;     //will have a +1 so that we are playing a "legal column"
                }
            if ((a[col][row] == 1   && 
                a[col+3][row-3] == 1 &&
                a[col+2][row-2] == 1) ||
                (a[col][row] == -1   && 
                a[col+3][row-3] == -1 &&
                a[col+2][row-2] == -1)){
              
                if(a[col+1][row-1] == 0)                    
                    return col + 2;     //will have a +1 so that we are playing a "legal column"
                }
            if ((a[col+3][row-3] == 1   && 
                a[col+1][row-1] == 1 &&
                a[col+2][row-2] == 1) ||
                (a[col+3][row-3] == -1   && 
                a[col+1][row-1] == -1 &&
                a[col+2][row-2] == -1)){
                    
                if(a[col][row] == 0)                   
                    return col + 1;     //will have a +1 so that we are playing a "legal column"
                }
        
        }			
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//// check for POSSIBLE UP DIAGONAL win for RED (1) AND BLACK (-1)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        for(int col = 0; col < 7-3; col++){     //col set at max 7-3 so we dont go out of range
        for (int row = 0; row < 6-3;row++){   //row set min 3 so we don't go out of range
            if ((a[col][row] == 1   && 
                a[col+1][row+1] == 1 &&
                a[col+2][row+2] == 1 )||
                (a[col][row] == -1   &&      
                a[col+1][row+1] == -1 &&
                a[col+2][row+2] == -1)){
                    
                    if(a[col+3][row+3] == 0)
                        return col + 4;     //will have a +1 so that we are playing a "legal column"
                }
            if ((a[col][row] == 1   && 
                a[col+1][row+1] == 1 &&
                a[col+3][row+3] == 1 )||
                (a[col][row] == -1   &&      
                a[col+1][row+1] == -1 &&
                a[col+3][row+3] == -1)){
                    
                    if(a[col+2][row+2] == 0)
                        return col + 3;     //will have a +1 so that we are playing a "legal column"
                }
            if ((a[col][row] == 1   && 
                a[col+3][row+3] == 1 &&
                a[col+2][row+2] == 1 )||
                (a[col][row] == -1   &&      
                a[col+3][row+3] == -1 &&
                a[col+2][row+2] == -1)){
                    
                    if(a[col+1][row+1] == 0)
                        return col + 2;     //will have a +1 so that we are playing a "legal column"
                }
            if ((a[col+3][row+3] == 1   && 
                a[col+1][row+1] == 1 &&
                a[col+2][row+2] == 1 )||
                (a[col+3][row+3] == -1   &&      
                a[col+1][row+1] == -1 &&
                a[col+2][row+2] == -1)){
                    
                    if(a[col][row] == 0)
                        return col + 1; //will have a +1 so that we are playing a "legal column"
                }

        }			


    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//// RANDOM PLAY
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//this will occur if the AI does not detect any of the previous patterns

    int whichColumn = ((int)(6*Math.random()));

    //set col to a random int between 0 and 6

    //runs an infiinte loop that can break 
    //this will never crash the program since isGameOver() will not allow another play
    //however, this will be useful in the case that almost all columns are full
    //and we still need to play
    while(whichColumn > -1){
        if(a[whichColumn][5] != 0){   //check the row isn't full
            break;
        }      
        break;
    }

    return whichColumn +1;  //will have a +1 so that we are playing a "legal column"
}
        
    public int nextMove(CFGame g, int[][] a) {

    //we set g.getState to our own state


    //we want to make the AI play the column that has a potnetial to be won by either red or black
    //we want to check every single option to win, including when there's 3 RED OR BLACK in a row

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//// check for POSSIBLE up HORIZONTAL win for RED (1) AND BLACK (-1)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
        for(int col = 0; col < 7-3; col++){         //col set max at 7-3 so we don't go out of range
        for (int row = 0; row < 6;row++){   
            if ((a[col][row] == 1   && 
                a[col+1][row] == 1 &&
                a[col+2][row] == 1) ||
                (a[col][row] == -1   && 
                a[col+1][row] == -1 &&
                a[col+2][row] == -1)){
                
                if(row > 0){
                    if(a[col+3][row] == 0 && a[col+3][row-1] != 0)
                        return col+4;                    
                }

                    if(a[col+3][row] == 0 )
                        return col+4; //will have a +1 so that we are playing a "legal column"
                }
           if ((a[col][row] == 1   && 
                a[col+1][row] == 1 &&
                a[col+3][row] == 1) ||
                (a[col][row] == -1   && 
                a[col+1][row] == -1 &&
                a[col+3][row] == -1)){
                
                if(row > 0){
                    if(a[col+2][row] == 0 && a[col+2][row-1] != 0)                    
                        return col+3;
                }

                    if(a[col+2][row] == 0 )                    
                        return col+3;  //will have a +1 so that we are playing a "legal column"
                }
            if ((a[col][row] == 1   && 
                a[col+2][row] == 1 &&
                a[col+3][row] == 1) ||
                (a[col][row] == -1   && 
                a[col+2][row] == -1 &&
                a[col+3][row] == -1)){
                
                if(row>0)
                    if(a[col+1][row] == 0 && a[col+1][row-1] != 0)                    
                        return col+2;
                    if(a[col+1][row] == 0)                    
                        return col+2;   //will have a +1 so that we are playing a "legal column"
                }
             if ((a[col+1][row] == 1   && 
                a[col+2][row] == 1 &&
                a[col+3][row] == 1) ||
                (a[col+1][row] == -1   && 
                a[col+2][row] == -1 &&
                a[col+3][row] == -1)){
                
                if(row>0)
                    if(a[col][row] == 0 && a[col][row-1] != 0)                    
                        return col+1;
                    if(a[col][row] == 0 )                    
                        return col+1;   //will have a +1 so that we are playing a "legal column"
                }
            }
        }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//// check for POSSIBLE  VERTICAL win for RED (1) AND BLACK (-1)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //SINCE THESE ARE VERTICAL, IT CANNOT BE POSSIBLE TO HAVE ONE MISSING PIECE BETWEEN RED OR BLACK
        //therefore we only check if the bottom threw rows have the same values

        for(int col = 0; col < 7; col++){
        for (int row = 0; row < 6-3;row++){   //row set max at 6-3 so we don't go out of range
            if ((a[col][row] == 1   && 
                a[col][row+1] == 1 &&
                a[col][row+2] == 1) ||
                (a[col][row] == -1   && 
                a[col][row+1] == -1 &&
                a[col][row+2] == -1)){
                   
                    if(a[col][row+3] == 0)   
                        return col+1;   //will have a +1 so that we are playing a "legal column"
                }
        }			
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//// check for POSSIBLE DOWN DIAGONAL win for RED (1) AND BLACK (-1)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        for(int col = 0; col < 7-3; col++){     //col set at max 7-3 so we dont go out of range
        for (int row = 3; row < 6;row++){   //row set min 2 so we don't go out of range
            if ((a[col][row] == 1   && 
                a[col+1][row-1] == 1 &&
                a[col+2][row-2] == 1) ||
                (a[col][row] == -1   && 
                a[col+1][row-1] == -1 &&
                a[col+2][row-2] == -1)){
                
            if(row > 3)
                if(a[col+3][row-3] == 0 && a[col+3][row-4] != 0)
                    return col + 4; //will have a +1 so that we are playing a "legal column"
                

                if(a[col+3][row-3] == 0)
                    return col + 4; //will have a +1 so that we are playing a "legal column"
                }
                
            if ((a[col][row] == 1   && 
                a[col+1][row-1] == 1 &&
                a[col+3][row-3] == 1) ||
                (a[col][row] == -1   && 
                a[col+1][row-1] == -1 &&
                a[col+3][row-3] == -1)){
                    
                if(a[col+2][row-2] == 0 && a[col+2][row-3] != 0)                    
                    return col + 3;     //will have a +1 so that we are playing a "legal column"
                
                if(a[col+2][row-2] == 0)                    
                    return col + 3; 
                }    //will have a +1 so that we are playing a "legal column"
            if ((a[col][row] == 1   && 
                a[col+3][row-3] == 1 &&
                a[col+2][row-2] == 1) ||
                (a[col][row] == -1   && 
                a[col+3][row-3] == -1 &&
                a[col+2][row-2] == -1)){
              
                if(a[col+1][row-1] == 0 && a[col+1][row-2] != 0)                    
                    return col + 2;  
                if(a[col+1][row-1] == 0)                    
                    return col + 2;     //will have a +1 so that we are playing a "legal column"
                }
            if ((a[col+3][row-3] == 1   && 
                a[col+1][row-1] == 1 &&
                a[col+2][row-2] == 1) ||
                (a[col+3][row-3] == -1   && 
                a[col+1][row-1] == -1 &&
                a[col+2][row-2] == -1)){
                    
                if(a[col][row] == 0 && a[col][row-1] != 0)                   
                    return col + 1; 
                if(a[col][row] == 0)                   
                    return col + 1;     //will have a +1 so that we are playing a "legal column"
                }
        
        }			
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//// check for POSSIBLE UP DIAGONAL win for RED (1) AND BLACK (-1)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        for(int col = 0; col < 7-3; col++){     //col set at max 7-3 so we dont go out of range
        for (int row = 0; row < 6-3;row++){   //row set min 3 so we don't go out of range
            if ((a[col][row] == 1   && 
                a[col+1][row+1] == 1 &&
                a[col+2][row+2] == 1 )||
                (a[col][row] == -1   &&      
                a[col+1][row+1] == -1 &&
                a[col+2][row+2] == -1)){
                    
                    if(a[col+3][row+3] == 0 && a[col+3][row+2] != 0)
                        return col + 4;     //will have a +1 so that we are playing a "legal column"
                }
            if ((a[col][row] == 1   && 
                a[col+1][row+1] == 1 &&
                a[col+3][row+3] == 1 )||
                (a[col][row] == -1   &&      
                a[col+1][row+1] == -1 &&
                a[col+3][row+3] == -1)){
                    
                    if(a[col+2][row+2] == 0 && a[col+2][row+1] != 0)
                        return col + 3;     //will have a +1 so that we are playing a "legal column"
                }
            if ((a[col][row] == 1   && 
                a[col+3][row+3] == 1 &&
                a[col+2][row+2] == 1 )||
                (a[col][row] == -1   &&      
                a[col+3][row+3] == -1 &&
                a[col+2][row+2] == -1)){
                    
                    if(a[col+1][row+1] == 0 && a[col+1][row] != 0)
                        return col + 2;     //will have a +1 so that we are playing a "legal column"
                }
            if ((a[col+3][row+3] == 1   && 
                a[col+1][row+1] == 1 &&
                a[col+2][row+2] == 1 )||
                (a[col+3][row+3] == -1   &&      
                a[col+1][row+1] == -1 &&
                a[col+2][row+2] == -1)){
                    
                    if(a[col][row] == 0 && a[col][row-1] != 0)
                        return col + 1; //will have a +1 so that we are playing a "legal column"
                }

        }			


    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//// RANDOM PLAY
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//this will occur if the AI does not detect any of the previous patterns

    int whichColumn = ((int)(6*Math.random()));

    //set col to a random int between 0 and 6

    //runs an infiinte loop that can break 
    //this will never crash the program since isGameOver() will not allow another play
    //however, this will be useful in the case that almost all columns are full
    //and we still need to play
    while(whichColumn > -1){
        if(a[whichColumn][5] != 0){   //check the row isn't full
            break;
        }      
        break;
    }

    return whichColumn +1;  //will have a +1 so that we are playing a "legal column"
}

    @Override
    public String getName() {
        return "Alex’s AI";
    }
    
}
