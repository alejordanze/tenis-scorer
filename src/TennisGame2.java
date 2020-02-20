
public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    
    public String player1Result = "";
    public String player2Result = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
    	
        String score = "";
        score = normal();
        if (isTie())
            score = getLiteral(player1Points) + "-All";
		if (isDeuce())
            score = "Deuce";
		if (isInAdvantage(player1Points, player2Points))
            score = "Advantage player1";
        if (isInAdvantage(player2Points, player1Points))
            score = "Advantage player2";    
        score = win(score);
        return score;
    }

	private String normal() {
		String score = "";
		if (player1Points != player2Points)
        {
            player1Result = getLiteral(player1Points);
            player2Result = getLiteral(player2Points);
            score = player1Result + "-" + player2Result;
        }
		return score;
	}

	private String getLiteral(int p1point2) {
		String literal = "";
		
		if (p1point2==0)
		    literal = "Love";
		if (p1point2==1)
		    literal = "Fifteen";
		if (p1point2==2)
		    literal = "Thirty";
		if (p1point2==3)
		    literal = "Forty";
		return literal;
	}

	private String win(String score) {
		if (player1Points>=4 && player2Points>=0 && (player1Points-player2Points)>=2)
        {
            score = "Win for player1";
        }
        if (player2Points>=4 && player1Points>=0 && (player2Points-player1Points)>=2)
        {
            score = "Win for player2";
        }
		return score;
	}

	private String advantage(String score) {
		if (isInAdvantage(player1Points, player2Points))
        {
            score = "Advantage player1";
        }
        
        if (isInAdvantage(player2Points, player1Points))
        {
            score = "Advantage player2";
        }
		return score;
	}

	private boolean isInAdvantage(int player1Points, int player2Points) {
		return player1Points > player2Points && player2Points >= 3;
	}

	private boolean isDeuce() {
		return player1Points==player2Points && player1Points>=3;
	}
	
	private boolean isTie() {
		return player1Points == player2Points && player1Points < 4;
	}
    
    public void setPlayer1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            player1Score();
        }
            
    }
    
    public void setPlayer2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            player2Score();
        }
            
    }
    
    public void player1Score(){
        player1Points++;
    }
    
    public void player2Score(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            player1Score();
        else
            player2Score();
    }
}