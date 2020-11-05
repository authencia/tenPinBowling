import java.util.Scanner;

public class bowling
{
    public static void main(String[] args)
    {
        int score1, score2, scoreTot, total, strikeStreak, strike;
        boolean spareEven, spareOdd, strikeEven, strikeOdd;
        char choice;
        strike = 0; strikeStreak = 0; total = 0; score2 = 0;
        spareOdd = false; spareEven = false; strikeOdd = false; strikeEven = false;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("***welcome to ten-pin bowling***");
        do // do while loop for multiple games
        {
            for(int i=1; i<=10; i++) // for loop for 10 rounds per game
            {
                System.out.println();
                System.out.println("it is now turn " + i);
                System.out.println("please input the number of pins knocked down by ball 1 below:");
                score1 = keyboard.nextInt();
                while (score1 > 10) // while loop for error checking
                {
                    System.out.println("invalid value, please re-enter below:");
                    score1 = keyboard.nextInt();
                }
                if(score1 == 10) // if loop to test for a strike
                {
                    System.out.println("STRIKE");
                    strike = strike + 1;
                    strikeStreak = strikeStreak + 1;
                    if (strikeStreak >= 3) // if loop to test for 3 strikes in a row
                    {
                        System.out.println("TURKEY");
                    }
                    if (i%2 == 1) // if loops to record the strike for scoring
                    {
                        strikeOdd = true;
                    }
                    if (i%2 == 0)
                    {
                        strikeEven = true;
                    }
                }
                if (score1 < 10) // if loop to run if not a strike
                {
                    strikeStreak = 0; // resets strike streak counter
                    System.out.println("please input the number of pins knocked down by ball 2 below:");
                    score2 = keyboard.nextInt();
                    while (score2 > 10 - score1) // while loop for error
                    {
                        System.out.println("invalid value, please re-enter below:");
                        score2 = keyboard.nextInt();
                    }
                    if (score1 + score2 == 10) // if loop to test for a spare
                    {
                        System.out.println("SPARE");
                        if (i % 2 == 1) // if loops to record the spare for scoring
                        {
                            spareOdd = true;
                        }
                        if (i % 2 == 0)
                        {
                            spareEven = true;
                        }
                    }
                    else // totals score if there is no strike/ spare
                    {
                        total = total + score1 + score2;
                    }
                }
                if (strikeStreak == 2) // program that runs if 2 strikes in row, skips the whole loop and waits for 3rd round
                {
                    strikeStreak = strikeStreak;
                }
                else if (strikeStreak >= 3 || strike == 2) // if loop to total score in the event of 2 strikes in a row
                {
                    total = total + 20 + score1;
                    strike = strike - 1;
                    if (strikeStreak <= 2) // if loop to reset booleans values for the rounds which scores have been totaled
                    {
                        if (i % 2 == 0)
                        {
                            strikeEven = false;
                        }
                        else
                        {
                            strikeOdd = false;
                        }
                    }
                }
                if (i % 2 == 0 && strikeOdd && strike == 1) // if loops to total score for not consecutive strikes
                {
                    total = total + 10 + score1 + score2;
                    strike = strike - 1;
                    strikeOdd = false;
                }
                if (i % 2 == 1 && strikeEven && strike == 1)
                {
                    total = total + 10 + score1 + score2;
                    strike = strike - 1;
                    strikeEven = false;
                }

                if (i%2 == 0 && spareOdd) // if loops to total score for spares
                {
                    total = total + 10 + score1;
                    spareOdd = false;
                }
                if (i%2 == 1 && spareEven)
                {
                    total = total + 10 + score1;
                    spareEven = false;
                }
                scoreTot = score1 + score2; // totals round score
                System.out.println("in turn " + i + ", you knocked down " + scoreTot + " pins");
                System.out.println("your current confirmed total is " + total);
            }
            System.out.println("would you like to score another game? (y/n)"); // offers another game
            choice = keyboard.next().charAt(0);
        }
        while(choice== 'y' || choice == 'Y');
    }
}
