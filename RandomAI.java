package hw4;

public class RandomAI implements CFPlayer {

    public int nextMove(CFGame g){
        
        return (int)(7*Math.random())+1;
    }

    public String getName(){
        
       return "Random Player";
    }
    
}
