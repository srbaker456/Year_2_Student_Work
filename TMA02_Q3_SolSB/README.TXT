------------------------------------------------------------------------
This is the project README file. 
------------------------------------------------------------------------

PROJECT TITLE: TMA02_Q3_SolSB

PURPOSE OF PROJECT:
This project fulfils the requirements of TMA02 Question 3.
The SIRModel class within can be used to model how an infection may 
spread in a boarding school.
The class models a school of 150 staff and pupils and starts with 4 
people being infected, then calculates the number of susceptible, 
infected and recovered people in the school per day, over a 60 day 
period. 
This calculation depends on a given transmission  rate and
recovery rate. 

DATE: 12/02/2022

HOW TO START THIS PROJECT:
Create a new object of the SIRModel class. The constructor will 
initialise the school size, the number of days the model will produce
data for, and the starting number of infected. Then input the 
transmission rate, transRate, as a double value typically between
0 and 1, and the recovery rate, again as a double value typically
between 0 and 1. 

AUTHORS: Steven Baker

USER INSTRUCTIONS:
Use the createData method to populate the 60 days with the number
of susceptible, infected, and recovered people in the school and 
then use the printGraph method to display the number of infected for 
each of the 60 days. This method prints a ‘*’ character for each
person that is infected on that day, giving the day number at the 
beginning and the number of infected in brackets at the end of 
the line. 