/* TicTacToe by Kevin Glenn
Description: TicTacToe game
*/
import javax.swing.JFrame;
 

public class TicTacToe
{
    public static void main(String[] args)
    {
        JFrame ticTacToe = new TicTacToeFrame();
        ticTacToe.setTitle("TicTacToe by Kevin Glenn");
        ticTacToe.setSize(1000, 1000);
        ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticTacToe.setLocationRelativeTo(null);
        ticTacToe.setVisible(true);
    }
} 