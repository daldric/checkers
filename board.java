import java.util.Scanner;
public class board
{
    Scanner keyboard = new Scanner(System.in);
    private space[][] spaceArray = new space[8][8];
    private int blackRemaining = 12;
    private int redRemaining = 12;
    private String playerMove = "Red";
    private String from;
    private String to;
    private String from2;
    private String to2;
    private int fromRow = 0;
    private int fromCol = 0;
    private int toRow = 0;
    private int toCol = 0;
    private int from2Row = 0;
    private int from2Col = 0;
    private int to2Row = 0;
    private int to2Col = 0;
    private int jumpRow = 0;
    private int jumpCol = 0;
    private boolean doubleJump = false;
    private boolean validFrom;
    private boolean validTo;
    private boolean gameOver;
    private boolean redWinner;
    private boolean blackWinner;
    public board()
    {
        // row 0
        space b8 = new space("b8", true);
        spaceArray[0][1] = b8;
        b8.setTeam('B');
        space d8 = new space("d8", true);
        spaceArray[0][3] = d8;
        d8.setTeam('B');
        space f8 = new space("f8", true);
        spaceArray[0][5] = f8;
        f8.setTeam('B');
        space h8 = new space("h8", true);
        spaceArray[0][7] = h8;
        h8.setTeam('B');
        // row 1
        space a7 = new space("a7", true);
        spaceArray[1][0] = a7;
        a7.setTeam('B');
        space c7 = new space("c7", true);
        spaceArray[1][2] = c7;
        c7.setTeam('B');
        space e7 = new space("e7", true);
        spaceArray[1][4] = e7;
        e7.setTeam('B');
        space g7 = new space("g7", true);
        spaceArray[1][6] = g7;
        g7.setTeam('B');
        // row 2
        space b6 = new space("b6", true);
        spaceArray[2][1] = b6;
        b6.setTeam('B');
        space d6 = new space("d6", true);
        spaceArray[2][3] = d6;
        d6.setTeam('B');
        space f6 = new space("f6", true);
        spaceArray[2][5] = f6;
        f6.setTeam('B');
        space h6 = new space("h6", true);
        spaceArray[2][7] = h6;
        h6.setTeam('B');
        // row 3
        space a5 = new space("a5", false);
        spaceArray[3][0] = a5;
        space c5 = new space("c5", false);
        spaceArray[3][2] = c5;
        space e5 = new space("e5", false);
        spaceArray[3][4] = e5;
        space g5 = new space("g5", false);
        spaceArray[3][6] = g5;
        // row 4
        space b4 = new space("b4", false);
        spaceArray[4][1] = b4;
        space d4 = new space("d4", false);
        spaceArray[4][3] = d4;
        space f4 = new space("f4", false);
        spaceArray[4][5] = f4;
        space h4 = new space("h4", false);
        spaceArray[4][7] = h4;
        // row 5
        space a3 = new space("a3", true);
        spaceArray[5][0] = a3;
        a3.setTeam('R');
        space c3 = new space("c3", true);
        spaceArray[5][2] = c3;
        c3.setTeam('R');
        space e3 = new space("e3", true);
        spaceArray[5][4] = e3;
        e3.setTeam('R');
        space g3 = new space("g3", true);
        spaceArray[5][6] = g3;
        g3.setTeam('R');
        // row 6
        space b2 = new space("b2", true);
        spaceArray[6][1] = b2;
        b2.setTeam('R');
        space d2 = new space("d2", true);
        spaceArray[6][3] = d2;
        d2.setTeam('R');
        space f2 = new space("f2", true);
        spaceArray[6][5] = f2;
        f2.setTeam('R');
        space h2 = new space("h2", true);
        spaceArray[6][7] = h2;
        h2.setTeam('R');
        // row 7
        space a1 = new space("a1", true);
        spaceArray[7][0] = a1;
        a1.setTeam('R');
        space c1 = new space("c1", true);
        spaceArray[7][2] = c1;
        c1.setTeam('R');
        space e1 = new space("e1", true);
        spaceArray[7][4] = e1;
        e1.setTeam('R');
        space g1 = new space("g1", true);
        spaceArray[7][6] = g1;
        g1.setTeam('R');

        gameOver = false;
    }

    public boolean getGameOver()
    {
        return gameOver;
    }

    public String getWinner()
    {
        if(redWinner)
        {
            return "Red";
        }
        else if(blackWinner)
        {
            return "Black";
        }
        return "Nobody";
    }

    public void display()
    {
        if(blackRemaining == 0)
        {
            redWinner = true;
            gameOver = true;
        }
        if(redRemaining == 0)
        {
            blackWinner = true;
            gameOver = true;
        }
        System.out.println("    a     b     c     d     e     f     g     h");
        for(int i = 0; i < 24; i++)
        {
            if(i % 3 == 1)
            {
                System.out.print((8 - i / 3) + " ");
            }
            else
            {
                 System.out.print("  ");
            }
            for(int j = 0; j < 8; j++)
            {
                if(spaceArray[i / 3][j] != null)
                {
                    if(spaceArray[i / 3][j].getHasPiece())
                    {
                        if(spaceArray[i / 3][j].hasKing() && i % 3 == 0)
                        {
                            System.out.print("  WW  ");
                        }
                        else if(i % 3 == 1)
                        {
                            System.out.print("  " + spaceArray[i / 3][j].getTeam() + spaceArray[i / 3][j].getTeam() + "  ");
                        }
                        else
                        {
                            System.out.print("      ");
                        }
                    }
                    else
                    {
                        System.out.print("      ");
                    }
                }
                else
                {
                    System.out.print("ZZZZZZ");
                }
            }
            if(i % 3 == 1)
            {
                System.out.print(" " + (8 - i / 3));
            }
            System.out.println();
        }
        System.out.println("    a     b     c     d     e     f     g     h");
        System.out.println();
        System.out.println("Black Remaining: " + blackRemaining + "   Red Remaining: " + redRemaining);
        System.out.println("Player Move: " + playerMove + "   ");
    }

    public void move()
    {
        System.out.print("Enter Move (ex. a1b2): ");
        String move = keyboard.next();
        doubleJump = false;
        if(move.length() >= 4)
        {
            from = move.substring(0, 2);
            to = move.substring(2, 4);
            if(move.length() == 6)
            {
                doubleJump = true;
            }
            if(validMove(from, to))
            {
                if(spaceArray[fromRow][fromCol].hasKing())
                {
                    spaceArray[fromRow][fromCol].removeKing();
                    spaceArray[toRow][toCol].giveKing();
                }
                spaceArray[fromRow][fromCol].changePiece();
                spaceArray[fromRow][fromCol].setTeam('N');
                spaceArray[toRow][toCol].changePiece();
                if(playerMove == "Red")
                {
                    spaceArray[toRow][toCol].setTeam('R');
                    if(toRow == 0)
                    {
                        spaceArray[toRow][toCol].giveKing();
                    }
                }
                else if(playerMove == "Black")
                {
                    spaceArray[toRow][toCol].setTeam('B');
                    if(toRow == 7)
                    {
                        spaceArray[toRow][toCol].giveKing();
                    }
                }
                changeMove();
                display();
            }
            else if(fromRow == toRow + 2 || fromRow == toRow - 2)
            {
                jump(from, to);
                if(doubleJump)
                {
                    from2 = move.substring(2, 4);
                    to2 = move.substring(4, 6);
                    if(validMove(from2, to2))
                    {
                    
                    }
                    doubleJump = false;
                    jump(from2, to2);
                }
            }
            else
            {
                System.out.println("Invalid move. Please try again.");
            }
        }
        else
        {
            System.out.println("Invalid move. Please try again.");
        }
    }
    
    public boolean validMove(String from, String to)
    {
        validFrom = false;
        validTo = false;
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(spaceArray[i][j] != null && spaceArray[i][j].getHasPiece()
                && spaceArray[i][j].getLabel().equals(from))
                {
                    if(playerMove == "Red" && spaceArray[i][j].getTeam() == 'R')
                    {
                        validFrom = true;
                        fromRow = i;
                        fromCol = j;
                    }
                    else if(playerMove == "Black" && spaceArray[i][j].getTeam() == 'B')
                    {
                         validFrom = true;
                    }
                    fromRow = i;
                    fromCol = j;
                }
            }
        }
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(spaceArray[i][j] != null && spaceArray[i][j].getHasPiece() == false
                && spaceArray[i][j].getLabel().equals(to))
                {
                    validTo = true;
                    toRow = i;
                    toCol = j;
                }
            }
        }
        if(validFrom && validTo)
        {
            if(spaceArray[fromRow][fromCol].hasKing() && (fromCol == toCol + 1 || fromCol == toCol - 1)
             && (fromRow == toRow - 1 || fromRow == toRow + 1))
            {
                return true;
            }
            else if(playerMove == "Red" && (fromRow == toRow + 1 && (fromCol == toCol + 1 || fromCol == toCol - 1)))
            {
                return true;
            }
            else if (playerMove == "Black" && (fromRow == toRow - 1 && (fromCol == toCol + 1 || fromCol == toCol - 1)))
            {
                return true;
            }
        }
        return false;
    }

    public boolean validJump(String jFrom, String jTo)
    {
        fromRow = 0;
        fromCol = 0;
        toRow = 0;
        toCol = 0;
        validMove(jFrom, jTo);
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(validFrom && spaceArray[i][j] != null && spaceArray[i][j].getHasPiece() && spaceArray[i][j].getLabel().equals(jFrom))
                {
                    fromRow = i;
                    fromCol = j;
                }
                if(validTo && spaceArray[i][j] != null && spaceArray[i][j].getHasPiece() == false && spaceArray[i][j].getLabel().equals(jTo))
                {
                    toRow = i;
                    toCol = j;
                }
            }
        }
        if(playerMove == "Red")
        {
            if(spaceArray[fromRow][fromCol].hasKing())
            {
                if(fromCol < toCol && spaceArray[fromRow + 1][fromCol + 1].getHasPiece() &&
                spaceArray[fromRow + 1][fromCol + 1].getTeam() == 'B' && validFrom && validTo)
                {
                    jumpRow = fromRow + 1;
                    jumpCol = fromCol + 1;
                    return true;
                }
                else if(fromCol > toCol && spaceArray[fromRow + 1][fromCol - 1].getHasPiece() &&
                spaceArray[fromRow + 1][fromCol - 1].getTeam() == 'B' && validFrom && validTo)
                {
                    jumpRow = fromRow + 1;
                    jumpCol = fromCol - 1;
                    return true;
                }
            }
            else if(fromCol < toCol && spaceArray[fromRow - 1][fromCol + 1].getHasPiece() &&
            spaceArray[fromRow - 1][fromCol + 1].getTeam() == 'B' && validFrom && validTo  && fromRow > toRow)
            {
                jumpRow = fromRow - 1;
                jumpCol = fromCol + 1;
                return true;
            }
            else if(fromCol > toCol && spaceArray[fromRow - 1][fromCol - 1].getHasPiece() &&
            spaceArray[fromRow - 1][fromCol - 1].getTeam() == 'B' && validFrom && validTo && fromRow > toRow)
            {
                jumpRow = fromRow - 1;
                jumpCol = fromCol - 1;
                return true;
            }
        }
        if(playerMove == "Black")
        {
            if(spaceArray[fromRow][fromCol].hasKing())
            {
                if(fromCol < toCol && spaceArray[fromRow - 1][fromCol + 1].getHasPiece() &&
                spaceArray[fromRow - 1][fromCol + 1].getTeam() == 'R' && validFrom && validTo)
                {
                    jumpRow = fromRow - 1;
                    jumpCol = fromCol + 1;
                    return true;
                }
                else if(fromCol > toCol && spaceArray[fromRow - 1][fromCol - 1].getHasPiece() &&
                spaceArray[fromRow - 1][fromCol - 1].getTeam() == 'R' && validFrom && validTo)
                {
                    jumpRow = fromRow - 1;
                    jumpCol = fromCol - 1;
                    return true;
                }
            }
            else if(fromCol < toCol && spaceArray[fromRow + 1][fromCol + 1].getHasPiece() &&
            spaceArray[fromRow + 1][fromCol + 1].getTeam() == 'R'&& validFrom && validTo && fromRow < toRow)
            {
                jumpRow = fromRow + 1;
                jumpCol = fromCol + 1;
                return true;
            }
            else if(fromCol > toCol && spaceArray[fromRow + 1][fromCol - 1].getHasPiece() &&
            spaceArray[fromRow + 1][fromCol - 1].getTeam() == 'R' && validFrom && validTo && fromRow < toRow)
            {
                jumpRow = fromRow + 1;
                jumpCol = fromCol - 1;
                return true;
            }
        }
        return false;
    }
    
    public void jump(String fromJ, String toJ)
    {
        if(validJump(fromJ, toJ))
        {
            spaceArray[jumpRow][jumpCol].changePiece();
            spaceArray[jumpRow][jumpCol].removeKing();
            spaceArray[jumpRow][jumpCol].setTeam('N');
            if(playerMove == "Red")
            {
                blackRemaining -= 1;
            }
            else
            {
                redRemaining -= 1;
            }
            spaceArray[fromRow][fromCol].changePiece();
            spaceArray[fromRow][fromCol].setTeam('N');
            spaceArray[toRow][toCol].changePiece();
            if(spaceArray[fromRow][fromCol].hasKing())
            {
                spaceArray[fromRow][fromCol].removeKing();
                spaceArray[toRow][toCol].giveKing();
            }
            if(playerMove == "Red")
            {
                spaceArray[toRow][toCol].setTeam('R');
                if(toRow == 0)
                {
                    spaceArray[toRow][toCol].giveKing();
                }
            }
            else if(playerMove == "Black")
            {
                spaceArray[toRow][toCol].setTeam('B');
                if(toRow == 7)
                {
                    spaceArray[toRow][toCol].giveKing();


                }
            }
            if(doubleJump == false)
            {
                changeMove();
            }
            
        }
        else
        {
             System.out.println("Invalid move. Please try again.");   
        }
    }

    public void changeMove()
    {
        if(playerMove == "Red")
        {
            playerMove = "Black";
        }
        else
        {
            playerMove = "Red";
        }
    }
}
