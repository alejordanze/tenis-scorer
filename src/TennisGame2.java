
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
        score = normal1(score);
        
        score = normal2(score);
        score = normal3(score);
        
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

	private String normal3(String score) {
		int p2point2 = player2Points;
		int p1point2 = player1Points;
		if (p2point2>p1point2 && p2point2 < 4)
        {
			score = getLiteralScore(p1point2, p2point2);
        }
		return score;
	}

	private String normal2(String score) {
		if (player1Points>player2Points && player1Points < 4)
        {
			score = getLiteralScore(player1Points, player2Points);
        }
		return score;
	}

	private String normal1(String score) {
		if (player2Points > 0 && player1Points==0)
        {
			score = getLiteralScore(player1Points, player2Points);
        }
		return score;
	}

	private String normal(String score) {
		int p1point2 = player1Points;
		if (p1point2 > 0 && player2Points==0)
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

	private String getLiteral(int p1point2) {
		String playerRes = "";
		
		if (p1point2==0)
			playerRes = "Love";
		if (p1point2==1)
			playerRes = "Fifteen";
		if (p1point2==2)
			playerRes = "Thirty";
		if (p1point2==3)
			playerRes = "Forty";
		return playerRes;
	}

	private String tie(String score) {
		if (player1Points == player2Points && player1Points < 4)
        {
            if (player1Points==0)
                score = "Love";
            if (player1Points==1)
                score = "Fifteen";
            if (player1Points==2)
                score = "Thirty";
            score += "-All";
        }
		return score;
	}

	private String deuce(String score) {
		if (player1Points==player2Points && player1Points>=3)
            score = "Deuce";
		return score;
	}
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        player1Points++;
    }
    
    public void P2Score(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}