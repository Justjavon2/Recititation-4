import java.util.Random;

public class RPS_Player {

    private final Random vergil=new Random();
    private final static int ROCK = 0;
    private final static int SCISSORS  = 1;

    private final static int PAPER  = 2;
    private int numberOfGamesWon;
    private int numberOfGamesPlayed;
    private int choice;
    private String name;

    public RPS_Player(String name){
        // TODO: replace this line with your code.
        numberOfGamesWon = 0;
        numberOfGamesPlayed = 0;
        this.name = name;

    }

    public String getName(){
        return name;
    }

    /**
     * Returns the number of games played since a clear() was issued.
     * @return returns the number of games played.
     */
    public int getNumberOfGamesPlayed(){
        // TODO: replace this line with your code.
        return numberOfGamesPlayed;
    }

    /**
     * Returns the number of games won since a clear() was issued.
     * @return returns the number of games won.
     */
    public int getNumberOfGamesWon(){
         return numberOfGamesWon;
    }

    /**
     * Returns the win percentage as number between 0 and 1.
     * @return win percentage as a double.
     */
    public double getWinPercentage(){
        return (double)numberOfGamesWon/numberOfGamesPlayed;
    }

    /**
     * Starts a new game.
     */
    public void clear(){
        this.numberOfGamesPlayed=0;
        this.numberOfGamesWon=0;
    }

    /**
     * This player challenges anotherPlayer whereby both players make a
     * random choice of rock, paper, scissors.
     * A reference to the winning
     * player is returned or null if there is a draw.
     * @param anotherPlayer an RPS_Player that this player is challenging.
     * @return Reference to the RPS_Player that won or a null if there is a draw
     */
    public RPS_Player challenge(RPS_Player anotherPlayer){
        choice=vergil.nextInt(3);
        anotherPlayer.choice = vergil.nextInt(3);
        if (choice != anotherPlayer.choice){
            if(choice == ROCK && anotherPlayer.choice== SCISSORS ||
                    choice == PAPER && anotherPlayer.choice== ROCK ||
                    choice == SCISSORS && anotherPlayer.choice== PAPER){
                numberOfGamesWon+=1;
                numberOfGamesPlayed+=1;
                anotherPlayer.numberOfGamesPlayed+=1;
                return this;
            }
            else{
                anotherPlayer.numberOfGamesPlayed+=1;
                anotherPlayer.numberOfGamesWon+=1;
                numberOfGamesPlayed+=1;
                return anotherPlayer;
            }
        }
        numberOfGamesPlayed+=1;
        anotherPlayer.numberOfGamesPlayed+=1;
        return null;
    }

    /**
     * This player challenges anotherPlayer whereby this player uses the previous
     * choice made and anotherPlayer makes a random choice of rock, paper, scissors.
     * A reference to the winning player is returned or null if there is a draw.
     * @param anotherPlayer an RPS_Player that this player is challenging.
     * @return Reference to the RPS_Player that won or a null if there is a draw
     */
    public RPS_Player keepAndChallenge(RPS_Player anotherPlayer){
        anotherPlayer.choice = vergil.nextInt(3);
        if (choice != anotherPlayer.choice){
            if(choice == ROCK && anotherPlayer.choice== SCISSORS ||
                    choice == PAPER && anotherPlayer.choice== ROCK ||
                    choice == SCISSORS && anotherPlayer.choice== PAPER){
                numberOfGamesWon+=1;
                numberOfGamesPlayed+=1;
                anotherPlayer.numberOfGamesPlayed+=1;
                return this;
            }
            else{
                anotherPlayer.numberOfGamesPlayed+=1;
                anotherPlayer.numberOfGamesWon+=1;
                numberOfGamesPlayed+=1;
                return anotherPlayer;
            }
        }
        numberOfGamesPlayed+=1;
        anotherPlayer.numberOfGamesPlayed+=1;
        return null;
    }

}
