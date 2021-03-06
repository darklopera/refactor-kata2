import java.util.HashMap;

public class TennisGame2 implements TennisGame
{
    public int player1Point = 0;
    public int player2Point = 0;
    public  String player1Score = "";
    public  String player2Score = "";
    private String player1Name;
    private String player2Name;
    private static final HashMap<Integer,String> SCORES= new HashMap<Integer,String>();

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    static{
        SCORES.put(0,"Love");
        SCORES.put(1,"Fifteen");
        SCORES.put(2, "Thirty");
        SCORES.put(3, "Forty");
    }

    private String getListScores(Integer points){
        return SCORES.get(points);
    }

    private String pointWhenDraw(Integer player1Point) {
        return player1Point < 3 ? SCORES.get(player1Point) + "-All" : "Deuce";
    }

    private String pointsMatch() {
        player1Score = getListScores(player1Point);
        player2Score = getListScores(player2Point);
        return player1Score + "-" + player2Score;
    }

    private String advantage() {
        return player1Point > player2Point ? "Advantage " + this.player1Name :
                "Advantage " + this.player2Name;
    }

    private String playerWin(Integer player1Point, Integer player2Point) {
        return player1Point > player2Point ? "Win for " + player1Name :
                "Win for " + player2Name;
    }


    public String getScore() {
        if (player1Point == player2Point) {
            return pointWhenDraw(player1Point);
        }

        if (player1Point >= 3 && player2Point >= 3 && Math.abs(player1Point - player2Point) == 1) {
            return advantage();
        }

        if (player1Point >= 4 || player2Point >= 4 && Math.abs(player1Point - player2Point) >= 2) {
            return playerWin(player1Point, player2Point);
        }
        return pointsMatch();

    }

    public void P1Score(){
        player1Point++;
    }
    
    public void P2Score(){
        player2Point++;
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name))
            P1Score();
        else
            P2Score();
    }


}