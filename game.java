import java.util.Scanner;
import java.util.ArrayList;
public class game
{
    public static void main (String[] args)
   {
       Scanner keyboard = new Scanner(System.in);
       board gameBoard = new board();
       gameBoard.display();
       gameBoard.move();
       
        while(gameBoard.getGameOver() == false)
       {
           gameBoard.move();
           gameBoard.display();
        }
        
        System.out.println(gameBoard.getWinner() + " is the winner!");
    }
}

