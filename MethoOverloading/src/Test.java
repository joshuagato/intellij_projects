public class Test {
    public static  void main(String[] args){

        calculateScore("Joshua", 100);  //This is a method call to cause it to perform its actions
        int newScore = calculateScore("Joshua", 100);  //This is a method call to perform its actions and store its return value in the variable newScore
        System.out.println("New score is: " + newScore);

        System.out.println();

        calculateScore(75);


    }

    public static int calculateScore(String playerName, int score){
        System.out.println("Player " + playerName + " scored " + score + " points!");
        return score * 1000;
    }

    public static int calculateScore(int score){
        System.out.println("Unnamed player scored " + score + " points!");
        return score * 1000;
    }

    public static int calculateScore(){
        System.out.println("No player, no player score!");
        return 0;
    }

}
