/* TicTacToe by Kevin Glenn
Description: swing components for TicTacToe
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
 

public class TicTacToeFrame extends JFrame

{
   
   private char playerTurn = 'X';
   private boolean gameOver = false;
 
   private Grid[][] squares = new Grid[3][3];
 
   JLabel labelStatus = new JLabel("PLAYER X'S TURN                                   PROGRAM BY KEVIN GLENN");

   public TicTacToeFrame()
   {
      /*JMenuBar menuBar;
      JMenu menu;
      JMenuItem startItem;
      JMenuItem quitItem;

      menuBar = new JMenuBar();
      this.setJMenuBar(menuBar);
      menu = new JMenu("Game");
      menuBar.add(menu);
      */
      
      JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));
       for (int i = 0; i < 3; i++)
       {
           for (int j = 0; j < 3; j++)
           {
               panel.add(squares[i][j] = new Grid());
            }
        }
 
       panel.setBorder(new LineBorder(Color.orange, 10));
       labelStatus.setBorder(new LineBorder(Color.black, 10));
 
       add(panel, BorderLayout.CENTER);
       add(labelStatus, BorderLayout.SOUTH);
   }
 
    public boolean boardFull()
    {
       for (int i = 0; i < 3; i++)
       {
           for (int j = 0; j < 3; j++)
           {
               if (squares[i][j].getToken() == ' ')
               {
                   return false;
                }
            }
        }
       return true;
    }
 
   public boolean gameWon(char token)
   {
       // rows
       for (int i = 0; i < 3; i++)
       {
           if ((squares[i][0].getToken() == token)
                   && (squares[i][1].getToken() == token)
                   && (squares[i][2].getToken() == token))
           {
               return true;
           }
        }
 
       // columns
       for (int j = 0; j < 3; j++)
       {
           if ((squares[0][j].getToken() == token)
               && (squares[1][j].getToken() == token)
               && (squares[2][j].getToken() == token))
           {
               return true;
           }
        }

       // diagonal
       if ((squares[0][0].getToken() == token)
               && (squares[1][1].getToken() == token)
               && (squares[2][2].getToken() == token))
           {
               return true;
           }
        
 
       if ((squares[0][2].getToken() == token)
               && (squares[1][1].getToken() == token)
               && (squares[2][0].getToken() == token))
           {
               return true;
           }
        
 
       return false;
   }
 

    public class Grid extends JPanel
    {
       private char token = ' ';
 

       public Grid()
       {
           setBorder(new LineBorder(Color.black, 1));
           addMouseListener(new MouseListener());
       }
 
       public char getToken()
       {
           return token;
       }
 
       public void setToken(char c)
       {
           token = c;
           repaint();
       }
 
       
       public void paintComponent(Graphics graphics)
       {
           super.paintComponent(graphics);
 
           if (token == 'X')
           {
               graphics.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
               graphics.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
           }
 
           else if (token == 'O')
           {
               graphics.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
           }
       }
 
       private class MouseListener extends MouseAdapter
       {
           
           public void mouseClicked(MouseEvent e)
           {
            //startItem.addActionListener(this);
            //quitItem.addActionListener(this);


              if (gameOver)
              {
                  return;
              }
               
              if (token == ' ' && playerTurn != ' ')
              {
                 setToken(playerTurn);
              }


 
             
               if (gameWon(playerTurn))
               {
                   labelStatus.setText(playerTurn + " WINS. GAME OVER.                                   PROGRAM BY KEVIN GLENN");
                   playerTurn = ' ';
                   gameOver = true;
               }
               else if (boardFull())
               {
                   labelStatus.setText("NOBODY WON - IT'S A TIE.                                  PROGRAM BY KEVIN GLENN");
                   playerTurn = ' ';
                   gameOver = true;
               }
               else
               {
                   playerTurn = (playerTurn == 'X') ? 'O' : 'X';
                   labelStatus.setText(playerTurn + "'S TURN.                                   PROGRAM BY KEVIN GLENN");
               }
           }
           
       }
    } 
 
}
