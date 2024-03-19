import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Simulation
{
    private Robot [] red;
    private Robot [] blue;

    /**
     * 
     * @param teamSize
     */
    public void initialize(int teamSize)
    {
        this.red = new Robot [teamSize];
        this.blue = new Robot[teamSize];

        //create different robots randomly


        //sort robots by speed (greater speed value appear first in team’s robot array) 



    }


    public void simulate() 
    {
        /*
         * Deetermines which team starts first. 
         * To this end, calculates the sum of the speed values of the robots of each team; 
         * the team whose speed sum is higher starts first.
         */




        /*
         * The robots of each team take turns to perform their attack.
         * Robots can be destroyed when attacked by the opposite team’s robots. 
         * If a robot at a specific index is destroyed, remove it from the array 
         * and shift the remaining ones accordingly
         * 
         * The simulation continues until one of the teams has all of its robots destroyed.
        */

    }

    /**
     * Return a random Robot instance from the red or blue team. 
     * If the isRedTeam parameter is true the method should choose the random robot from the red team, 
     * otherwise from the blue team.
     * @param isRedTeam
     * @return
     */
    public Robot getRandomTarget(boolean isRedTeam)
    {
        Robot target;


    }

    /**
     * : Returns the robot with the highest health from the desired team.
     * @param isRedTeam
     * @return
     */
    public Robot getHighestHealth(boolean isRedTeam)
    {
        Robot robotWithLowestHealth;
        if(isRedTeam) //is true
        {
            robotWithLowestHealth = red[0];
            for(int i = 1; i < red.length; i++)
            {
                if(red[i].getHealth() > robotWithLowestHealth.getHealth())
                {
                    robotWithLowestHealth = red[i];
                }
            }
        }
        else{
            robotWithLowestHealth = blue[0];
            for(int i = 1; i < blue.length; i++)
            {
                if(blue[i].getHealth() > robotWithLowestHealth.getHealth())
                {
                    robotWithLowestHealth = blue[i];
                }
            }
        }

        return robotWithLowestHealth;
    }

    /**
     * : Returns the robot with the lowest health from the desired team.
     * @param isRedTeam
     * @return
     */
    public Robot getLowestHealth(boolean isRedTeam)
    {
        Robot robotWithLowestHealth;
        if(isRedTeam) //is true
        {
            robotWithLowestHealth = red[0];
            for(int i = 1; i < red.length; i++)
            {
                if(red[i].getHealth() < robotWithLowestHealth.getHealth())
                {
                    robotWithLowestHealth = red[i];
                }
            }
        }
        else{
            robotWithLowestHealth = blue[0];
            for(int i = 1; i < blue.length; i++)
            {
                if(blue[i].getHealth() < robotWithLowestHealth.getHealth())
                {
                    robotWithLowestHealth = blue[i];
                }
            }
        }
        return robotWithLowestHealth;
    }

    /**
     * : Returns the robot with the lowest speed from the desired team.
     * @param isRedTeam
     * @return
     */
    public Robot getLowestSpeed(boolean isRedTeam)
    {
        Robot robotWithLowestSpeed;
        if(isRedTeam) //is true
        {
            robotWithLowestSpeed = red[0];
            for(int i = 1; i < red.length; i++)
            {
                if(red[i].getSpeed() < robotWithLowestSpeed.getSpeed())
                {
                    robotWithLowestSpeed = red[i];
                }
            }
        }
        else{
            robotWithLowestSpeed = blue[0];
            for(int i = 1; i < blue.length; i++)
            {
                if(blue[i].getSpeed() < robotWithLowestSpeed.getSpeed())
                {
                    robotWithLowestSpeed = blue[i];
                }
            }
        }
        return robotWithLowestSpeed;
    }


    /**
     * : Returns the robot with the lowest attack from the desired team.
     * @param isRedTeam
     * @return
     */
    Robot getLowestAttack(boolean isRedTeam)
    {
        Robot robotWithLowestAttack;
        if(isRedTeam) //is true
        {
            robotWithLowestAttack = red[0];
            for(int i = 1; i < red.length; i++)
            {
                if(red[i].getAttack() < robotWithLowestAttack.getAttack())
                {
                    robotWithLowestAttack = red[i];
                }
            }
        }
        else{
            robotWithLowestAttack = blue[0];
            for(int i = 1; i < blue.length; i++)
            {
                if(blue[i].getAttack() < robotWithLowestAttack.getAttack())
                {
                    robotWithLowestAttack = blue[i];
                }
            }
        }

        return robotWithLowestAttack;
    }

    /**
     * : Returns the Robot array containing the desired team's three robots with the lowest speed values. T
     * his method can return 1, 2, or 3 Robot instances based on the remaining robots of the desired team.
     * @param isRedTeam
     * @return
     */
    Robot[] getLowestSpeed3(boolean isRedTeam)
    {



    }


    public void removeRobot(Robot r)
    {
        if(r.isRedTeam())
        {
            for(int i = 0; i < red.length; i++)
            {
                if(r.getName().equals(red[i].getName()))
                {
                    //SHIFT AND REMOVE
                }
            }
        }

    }





}
