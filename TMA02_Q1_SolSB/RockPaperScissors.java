import java.util.Random;

/**
 * For Q1 part a:
 * This RockPaperScissors class can be used to play a game of Rock, Paper, Scissors  
 * against the computer. The winner of the game will be whoever wins 3 rounds first.
 * Each round is decided as per the rules of a game of Rock, Paper, Scissors.
 * If the player enters something other than the three options, the computer wins the round.
 *
 * @author (Steven Baker)
 * @version (01/02/2022)
 */
public class RockPaperScissors
{
    // For Q1 part b:
    // Instance variables:
    private InputReader reader; // This will hold the response from the terminal.
    private int yourScore; // This will hold the number of rounds the player has won.
    private int computerScore; // This will hold the number of rounds the computer has won.
    private Random ran; // This will hold the random choice made by the computer.

    /**
     * For Q1 part c:
     * Constructor for objects of the RockPaperScissors class
     * with zero parameters.
     * Each player's score will be set to 0 and an instance of
     * InputReader will be used to get the player's option and
     * the Random class will be used to determine the 
     * computer's choice for each round.
     */
    public RockPaperScissors()
    {
        // Initialise the instance variables:
        
        // This will initialise the reader.
        reader = new InputReader();
        // Set the player score to 0 at the start of a game.
        int yourScore = 0;
        // Set the computer's score to 0 at the start of a game.
        int computerScore = 0;
        // Initialise the instance of Random, currently set at 1.
        ran = new Random(1);
    }

    /**
     * For Q1 part d:
     * This method prints two blank lines and then a prompt.
     * The user's input will appear on the same line as the prompt.
     *
     */
    public void printPrompt()
    {
        System.out.println();
        System.out.println(); // Two blank lines
        // The user input should be entered level with this line below.
        System.out.print("Enter your choice, paper, rock or scissors > ");
    }

    /**
     * For Q1 part e:
     * This method returns the user's input for a round of the game (i.e. rock, paper or scissors)
     * in lowercase, with any leading and trailing space trimmed.
     *
     * @return A String containing what the player has inputted.
     */
    public String userChoice()
    {
        // Get user input, trimmed and in lower case.
        String inputLine = reader.getInput().trim().toLowerCase();
        
        // return the processed input.
        return inputLine;
    }

    /**
     * For Q1 part f:
     * This method generates a random number between 0 and 2 (inclusive) 
     * and uses a switch statement to determine the computer's choice of 
     * "rock" (value 0), "paper" (value 1) or "scissors" (value 2). 
     * The method then returns the computer's choice.
     *
     * @return A String containing what the computer has generated.
     */
    public String computerChoice()
    {
        // Initialise a string to hold the return value.
        String computerOption = new String();
        // Gets user input, trimmed and in lower case.
        int index = ran.nextInt(3); 
        switch (index) {
            // If the random number generated is 0...
            case 0:
            computerOption = "rock"; // ...the computer chooses rock.
            break;
            // If the random number generated is 1...
            case 1: 
            computerOption = "paper"; // ...the computer chooses paper.
            break;
            // If the random number generated is 2...
            case 2:
            computerOption = "scissors";  // ...the computer chooses scissors.
            break;
        }
        // Returns the computer's choice for the round.
        return computerOption;
    }

    /**
     * For Q1 part g:
     * This method determines the winner of the round,
     * then either the player's or the computer's score is incremented 
     * unless both the player's and the computer's choices are the same.
     * The string "draw", "you" or "computer" is returned depending on
     * each player's options and the rules of Rock, Paper, Scissors.
     *
     * @param yourChoice A String containing what the player has inputed.
     * @param computerChoice A String containing what the computer has generated.
     * @return A String stating which player has won the round.
     */
    public String findWinner(String yourChoice, String computerChoice)
    {
        String resultStatement = new String();
        // If the player choses rock and the computer choses scissors,
        if    ((yourChoice.equals("rock") && computerChoice.equals("scissors"))
        // or the player choses paper and the computer choses rock,
            || (yourChoice.equals("paper") && computerChoice.equals("rock"))
        // or the player choses scissors and the computer choses paper,    
            || (yourChoice.equals("scissors") && computerChoice.equals("paper"))) {
                //Increment  the player's score.
                ++yourScore;
                // And the player wins the round.
                resultStatement = "you";
            }
        // If both players chose the same option,    
        else if (yourChoice.equals(computerChoice)) {
                // The round is a draw.
                resultStatement = "draw"; 
            }
        // For any other input the player makes, the computer wins the round.    
        else { 
                // Increment  the computer's score.
                ++computerScore;
                // And the computer wins the round.
                resultStatement = "computer";
            }
        // Return the result of the round.
        return resultStatement;
    }

    /**
     * For Q1 part h:
     * This method prompts the user to give their choice of 'rock', 'paper' or 'scissors',
     * get their choice and then generate the computer's choice.
     * The choices of each are then confirmed and the winner of the round is determined.
     * The scores of the game are then updated and the total scores are displayed.
     *
     */
    public void playRound()
    {
        // Prompt the user to type in their choice.
        printPrompt();
        // The user enters their choice.
        String playerChoice = userChoice();
        // The computer generates its choice.
        String computerOption = computerChoice();
        // a blank line.
        System.out.println(); 
        // The choices of the player and computer are confirmed.
        System.out.println("You have chosen " + playerChoice + 
                           " and the computer has chosen " + computerOption);
        
        switch (findWinner(playerChoice, computerOption)) {
            // If the game is a draw...
            case "draw":
            System.out.println("This game is a draw");
            break;
            // If the player wins the round...
            case "you":
            System.out.println("You are the winner"); 
            break;
            // If the computer wins the round...
            case "computer":  
            System.out.println("The computer is the winner"); 
            break;
        }
        // Print out the current scores.
        System.out.println("You have " + yourScore + " and the computer has " + computerScore);
    }

    /**
     * For Q1 part i:
     * This method plays rounds of Rock, Paper, Scissors until either the player
     * or the computer has won three rounds.
     * The overall winner is then announced.
     *
     */
    public void playGame()
    {
        // While both the player's and computer's scores are below 3...
        while (yourScore < 3 && computerScore < 3) {
            playRound();
        }
        // If the player wins three rounds...
        if (yourScore == 3) { 
            System.out.println("The overall winner is you.");
        }
        // Otherwise, then the computer would have won three rounds.
        else { 
            System.out.println("The overall winner is the computer.");
        }
        
    }
}
