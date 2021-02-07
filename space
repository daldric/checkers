public class space
{
    private String label;
    private boolean hasPiece;
    private boolean king;
    private char team;
    /**
     * Constructor for objects of class space
     */
    public space(String label, boolean hasPiece)
    {
        this.label = label;
        this.hasPiece = hasPiece;
        king = false;
    }

    public boolean getHasPiece()
    {
        return hasPiece;
    }
    
    public void setTeam(char newTeam)
    {
        team = newTeam;
    }
    
    public char getTeam()
    {
        return team;
    }
    
    public void giveKing()
    {
        king = true;
    }
    
    public void removeKing()
    {
        king = false;
    }
    
    public boolean hasKing()
    {
        return king;
    }
    
    public String getLabel()
    {
        return label;
    }
    
    public void changePiece()
    {
        if(hasPiece == true)
        {
            hasPiece = false;
        }
        else
        {
            hasPiece = true;
        }
    }
}
