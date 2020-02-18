
public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    final int _LOVE = 0;
    final int _FIFTEEN = 1;
    final int _THIRTY = 2;
    final int _FORTY = 3;
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getLiteralScore(){
        String literalScore = "";
    	if (isNormal())
			literalScore = getLiteral(player1Points) + "-" + getLiteral(player2Points);
        if (isTie())
			literalScore = getLiteral(player1Points) + "-All";
        if (isDeuce())
            literalScore = "Deuce";
    	if (isAdvantage(player1Points, player2Points))
            literalScore = "Advantage player1";
        if (isAdvantage(player2Points, player1Points))
            literalScore = "Advantage player2";
    	if (isWinner(player1Points,player2Points))
            literalScore = "Win for player1";
        if (isWinner(player2Points,player1Points))
            literalScore = "Win for player2";
        return literalScore;
    }

	private boolean isNormal() {
		return player1Points != player2Points;
	}

	private boolean isWinner(int player1Points, int player2Points) {
		return player1Points>=4 && player2Points>=0 && (player1Points-player2Points)>=2;
	}

	private boolean isAdvantage(int player1Points, int player2Points) {
		return player1Points > player2Points && player2Points >= 3;
	}
	
	private String getLiteral(int playerPoints) {
		String result = "";
		
		if (playerPoints == _LOVE)
			result = "Love";
		if (playerPoints == _FIFTEEN)
			result = "Fifteen";
		if (playerPoints == _THIRTY)
			result = "Thirty";
		if (playerPoints == _FORTY)
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