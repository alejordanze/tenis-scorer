
public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    
    public String player1LiteralPoints = "";
    public String player2LiteralPoints = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        score = tie(score);
        score = deuce(score);
        score = normal(score);
        score = advantage(score);
        score = win(score);
        
        return score;
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
		if (player1Points > player2Points && player2Points >= 3)
        {
            score = "Advantage player1";
        }
        
        if (player2Points > player1Points && player1Points >= 3)
        {
            score = "Advantage player2";
        }
		return score;
	}

	private String normal(String score) {
		if (player1Points != player2Points)
        {
			score = getLiteralScore(player1Points, player2Points);
        }
		return score;
	}
	
	private String getLiteralScore(int p1point2, int p2point2) {
		String score;
		player2LiteralPoints = getLiteral(p2point2);
		player1LiteralPoints = getLiteral(p1point2);
		score = player1LiteralPoints + "-" + player2LiteralPoints;
		return score;
	}

	private String getLiteral(int playerPoints) {
		String result = "";
		
		if (playerPoints == 0)
			result = "Love";
		if (playerPoints == 1)
			result = "Fifteen";
		if (playerPoints == 2)
			result = "Thirty";
		if (playerPoints == 3)
			result = "Forty";
		return result;
	}

	private String tie(String score) {
		if (player1Points == player2Points && player1Points < 4)
        {
			score = getLiteral(player1Points);
            score += "-All";
        }
		return score;
	}

	private String deuce(String score) {
		if (player1Points==player2Points && player1Points>=3)
            score = "Deuce";
		return score;
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