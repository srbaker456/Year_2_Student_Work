
/**
 * * For Q3 part a:
 * This SIRModel class can be used to model how an infection may spread in a boarding school.
 * The class models a school of 150 staff and pupils and starts with 4 people being infected. 
 * It then calculates the number of susceptible, infected and recovered people in the school
 * per day, over a 60 day period. This calculation depends on a given transmission  rate and
 * recovery rate. 
 *
 * @author (Steven Baker)
 * @version (12/02/2022)
 */
public class SIRModel
{
    // For Q3 part b:
    // Instance variables:
    private static final int POPULATION = 150; // Total population of the boarding school.
    private static final int INITIAL_INFECTIONS = 4; // Initial number of infected people.
    private static final int DAYS = 60; // Days over which the model will run.
    
    private final double TRANS_RATE; // The constant transmission rate.
    private final double REC_RATE; // The constant recovery rate.
    
    private double[] susceptible; // Number of people susceptible at any given day.
    private double[] infected; // Number of people infected at any given day.
    private double[] recovered; // Number of people recovered at any given day.
    
    /**
     * For Q3 part c:
     * Constructor for objects of class SIRModel. It will initialise the
     * transmission rate and recovery rate according to the user's input.
     * Then it will add the starting number of infected people to the 
     * first day of the model and update the number of people susceptible
     * on the first day.
     * 
     * @param transRate A double representing a transmission rate in the model.
     * @param recRate A double representing a recovery rate in the model.
     */
    public SIRModel(double transRate, double recRate)
    {
        // Initialise instance variables:
        
        // This initialises the constant transmission rate to the user's input.
        TRANS_RATE = transRate;
        // This initialises the constant recovery rate to the user's input.
        REC_RATE = recRate;
        
        // The susceptible array will have indexes  0 - 59 for 60 days.
        susceptible = new double[DAYS + 1];
        // The infected array will have indexes  0 - 59 for 60 days.
        infected = new double[DAYS + 1];
        // The recovered array will have indexes  0 - 59 for 60 days.
        recovered = new double[DAYS + 1];
        
        // The first element in this array is initialised to 
        // the number of people infected on day 0.
        infected[0] = INITIAL_INFECTIONS;
        // The number of susceptible people is equal to  the total population 
        // minus the number of infected.
        susceptible[0] = POPULATION - INITIAL_INFECTIONS;
    }

    /**
     * For Q3 part d:
     * This method calculates and returns the expected number of
     * new people infected in a day.
     *
     * @param currentInfected A double representing the number of currently infected.
     * @param currentSusceptible A double representing the number of currently susceptible.
     * @return A double representing the number of newly infected.
     */
    public double newlyInfected(double currentInfected, double currentSusceptible)
    {
        // This equation represents the density-dependent model of transmission.
        double infectedOnDay = ((TRANS_RATE * currentInfected * currentSusceptible) / POPULATION);
        // Return the value.
        return infectedOnDay;
    }
    
    /**
     * For Q3 part e:
     * This method returns the number of people expected to recover in a day
     * from the number of people currently infected.
     *
     * @param currentInfected A double representing the number of currently infected.
     * @return A double representing the number of newly recovered.
     */
    public double newlyRecovered(double currentInfected)
    {
        // This equation calculates the number of infected that will recover on the day...
        double recoveredOnDay = (REC_RATE * currentInfected);
        // ...and returns the value.
        return recoveredOnDay;
    }
    
    /**
     * For Q3 part f:
     * This method returns the change in the expected number of
     * infected after a day has passed. This value can be
     * positive or negative.
     *
     * @param currentInfected A double representing the number of currently infected.
     * @param currentSusceptible A double representing the number of currently susceptible.
     * @return A double representing the change in the number of people infected.
     */
    public double changeInInfected(double currentInfected, double currentSusceptible)
    {
        // This equation calculates the change in the number of infected... 
        double infectedChange = (newlyInfected(currentInfected, currentSusceptible) - 
                                 newlyRecovered(currentInfected));
        // ...and returns the value.
        return infectedChange;
    }
    
    /**
     * For Q3 part g:
     * This method gives the number of infected, recovered, and susceptible 
     * people based on the previous day's data.
     *
     * @param prevDay An int representing an index of the previous number of susceptible, 
     * infected and recovered.
     */
    public void nextDay(int prevDay)
    {
        // The below calculates the number of infected people for the day.
        double I = (infected[prevDay] + changeInInfected(infected[prevDay], susceptible[prevDay]));
        // Then adds it to the infected array at the next day's index.
        infected[prevDay + 1] = I;
        // The below calculates the number of recovered people for the day.
        double R = (recovered[prevDay] + newlyRecovered(infected[prevDay]));
        // Then adds it to the recovered array at the next day's index.
        recovered[prevDay + 1] = R;
        // The below calculates the number of susceptible people for the day.
        double S = (POPULATION - (I + R));
        // Then adds it to the susceptible array at the next day's index.
        susceptible[prevDay + 1] = S;
    }
    
    /**
     * For Q3 part h:
     * This method uses a loop to call the nextDay method for each
     * day of the model, with a day's susceptible, infected and recovered  
     * values stored at the appropriate indexes.  
     *
     */
    public void createData()
    {
        // This loop will populate the susceptible, infected and recovered arrays...
        for (int day = 0; day < DAYS ; day++) {
            // ...by running the nextDay method for each of the 60 days.
            nextDay(day);
        }
    }
    
    /**
     * For Q3 part i:
     * This method prints a graph of the number of infected people.
     * It prints a ???*??? character for each person that is infected
     * on that day, giving the day number at the beginning, and
     * the number of infected in brackets at the end of the printed
     * line. 
     */
    public void printGraph()
    {
        // This outer loop will print out rows for each day.
        for (int day = 0; day < DAYS ; day++) {
            int numInfected = (int) Math.round(infected[day]);
            System.out.print(day + "  ");
            // This inner loop will print out "*" for each infected person on that day. 
            for (int person = 0; person < numInfected; person++) {
                 System.out.print("*");
                }
            // The outer loop will then finish by printing the number of 
            // infected for that day and set up a new line.
            System.out.print("   " + "(" + numInfected + ")");
            System.out.println();
        }
    }
    
}
