
public class TennisGame2 implements TennisGame
{
    public int Player1point = 0;
    public int Player2point = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        score = normal(score);
        score = tie(score);
        score = deuce(score);
        score = advantage(score);
        score = win(score);
        return score;
    }

	private String normal(String score) {
        String P1Literal="";
        String P2Literal="";
        if(Player2point < 4 && Player1point < 4)
            P2Literal=getLiteral(Player2point);
            P1Literal=getLiteral(Player1point);
            score = P1Literal + "-" + P2Literal;
		return score;
	}

	private String win(String score) {
		if (isWinnerOver(Player1point, Player2point))
            score = "Win for player1";
        if (isWinnerOver(Player2point, Player1point))
            score = "Win for player2";
		return score;
	}

    private boolean isWinnerOver(int player1point, int player2point) {
        return player1point >= 4 && player2point >= 0 && (player1point - player2point) >= 2;
    }

    private String advantage(String score) {
		if (hasAdvantageOver(Player1point, Player2point))
            score = "Advantage player1";
        
        if (hasAdvantageOver(Player2point, Player1point)) 
            score = "Advantage player2";
		return score;
	}

    private boolean hasAdvantageOver(int player1point, int player2point) {
        return player1point > player2point && player2point >= 3;
    }

    private String deuce(String score) {
		if (Player1point== Player2point && Player1point>=3)
            score = "Deuce";
		return score;
	}

	private String tie(String score) {
		if (Player1point == Player2point && Player1point < 4) {
            score = getLiteral(Player1point);
            score += "-All";
        }
		return score;
	}

    private String getLiteral(int playerPoint) {
        String score="";
        if (playerPoint==0)
            score = "Love";
        if (playerPoint==1)
            score = "Fifteen";
        if (playerPoint==2)
            score = "Thirty";
        if (playerPoint==3)
            score = "Forty";

        return score;
    }

    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++) {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++) {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        Player1point++;
    }
    
    public void P2Score(){
        Player2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}