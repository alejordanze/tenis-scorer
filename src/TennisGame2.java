
public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
    	if (isNormal())
			score = getLiteralScore(player1Points, player2Points);
        if (isTie())
			score = getLiteral(player1Points) + "-All";
        if (isDeuce())
            score = "Deuce";
    	if (isAdvantage(player1Points, player2Points))
            score = "Advantage player1";
        if (isAdvantage(player2Points, player1Points))
            score = "Advantage player2";
        score = win(score);
        
        return score;
    }

	private boolean isNormal() {
		return player1Points != player2Points;
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

	private boolean isAdvantage(int player1Points, int player2Points) {
		return player1Points > player2Points && player2Points >= 3;
	}
	
	private String getLiteralScore(int p1point2, int p2point2) {
		return getLiteral(p1point2) + "-" + getLiteral(p2point2);
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

	private boolean isTie() {
		return player1Points == player2Points && player1Points < 4;
	}
	private boolean isDeuce() {
		return player1Points==player2Points && player1Points>=3;
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