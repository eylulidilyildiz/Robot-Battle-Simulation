import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Simulation
{
    private Robot [] red;
    private Robot [] blue;
    private int numberOfRobots;

    private Robot[] startingTeam;
    private Robot[] otherTeam;

    private int indexOfStartingTeam;
    private int indexOfOtherTeam;

    private final int TYPES_OF_ROBOTS = 6;

    public Simulation(int teamSize)
    {
        initialize(teamSize);
    }

    /**
     * 
     * @param teamSize
     */
    public void initialize(int teamSize)
    {
        numberOfRobots = 0;

        this.red = new Robot [teamSize];
        this.blue = new Robot[teamSize];

        //create different robots randomly
        Random random = new Random();
        for (int i = 0; i < teamSize; i++)
        {
            Robot chosenRobot;
            String code = "";
            int chosenType = random.nextInt(0,TYPES_OF_ROBOTS);
            if(chosenType == 0)
            {
                code += "S" + numberOfRobots;
                chosenRobot = new SimpleBot();
            }
            else if(chosenType == 1)
            {
                code += "P" + numberOfRobots;
                chosenRobot = new PredatorBot();
            }
            else if(chosenType == 2)
            {
                code += "D" + numberOfRobots;
                chosenRobot = new DefenceBot();
            }
            else if(chosenType == 3)
            {
                code += "X" + numberOfRobots;
                chosenRobot = new SpeedBot();
            }
            else if(chosenType == 4)
            {
                code += "K" + numberOfRobots;
                chosenRobot = new SpreadBot();
            }
            else //chosenType == 5
            {
                code += "O" + numberOfRobots;
                chosenRobot = new OneBot();
            }

            chosenRobot.setName(code);
            chosenRobot.setTeam("red");
            numberOfRobots ++;
            red[i] = chosenRobot;
        }


        for (int i = 0; i < teamSize; i++)
        {
            Robot chosenRobot;
            String code = "";
            int chosenType = random.nextInt(0,TYPES_OF_ROBOTS);
            if(chosenType == 0)
            {
                code += "S" + numberOfRobots;
                chosenRobot = new SimpleBot();
            }
            else if(chosenType == 1)
            {
                code += "P" + numberOfRobots;
                chosenRobot = new PredatorBot();
            }
            else if(chosenType == 2)
            {
                code += "D" + numberOfRobots;
                chosenRobot = new DefenceBot();
            }
            else if(chosenType == 3)
            {
                code += "X" + numberOfRobots;
                chosenRobot = new SpeedBot();
            }
            else if(chosenType == 4)
            {
                code += "K" + numberOfRobots;
                chosenRobot = new SpreadBot();
            }
            else //chosenType == 5
            {
                code += "O" + numberOfRobots;
                chosenRobot = new OneBot();
            }

            chosenRobot.setName(code);
            chosenRobot.setTeam("blue");
            numberOfRobots ++;
            blue[i] = chosenRobot;
        }

        //sort robots by speed (greater speed value appear first in team’s robot array) 
        //RED
        for(int i = 0; i < red.length - 1; i++)
        {
            for (int j = 0; j < red.length - 1; j++)
            {
                if(red[j].getSpeed() < red[j+1].getSpeed())
                {
                    Robot temp = red[j];
                    red[j] = red[j+1];
                    red[j+1] = temp;
                }
            }
        }

        //BLUE
        for(int i = 0; i < blue.length - 1; i++)
        {
            for (int j = 0; j < blue.length - 1; j++)
            {
                if(blue[j].getSpeed() < blue[j+1].getSpeed())
                {
                    Robot temp = blue[j];
                    blue[j] = blue[j+1];
                    blue[j+1] = temp;
                }
            }
        }
        displayTeams();
    }


    public void simulate() 
    {
        /*
         * Deetermines which team starts first. 
         * To this end, calculates the sum of the speed values of the robots of each team; 
         * the team whose speed sum is higher starts first.
         * If the speed sums are the same, the red team starts first. 
         */
        double sumOfRed = 0;
        double sumOfBlue = 0;
        for(Robot robot: red)
        {
            sumOfRed += robot.getSpeed();
        }
        System.out.printf("\nSpeed sum of Red: %.3f", sumOfRed);

        for(Robot robot: blue)
        {
            sumOfBlue += robot.getSpeed();
        }
        System.out.printf("\nSpeed sum of Blue: %.3f", sumOfBlue);

        if(sumOfBlue > sumOfRed)
        {
            startingTeam = this.blue;
            otherTeam = this.red;
            System.out.println("\n\nBlue starts first.\n");
        }
        else{  //if (sumOfBlue <= sumOfRed)
            startingTeam = this.red; 
            otherTeam = this.blue;
            System.out.println("\n\nRed starts first.\n");
        }
        
        
        /*
         * The robots of each team take turns to perform their attack.
         * Robots can be destroyed when attacked by the opposite team’s robots. 
         * If a robot at a specific index is destroyed, remove it from the array 
         * and shift the remaining ones accordingly
         * 
         * The simulation continues until one of the teams has all of its robots destroyed.
        */
        indexOfStartingTeam = 0;
        indexOfOtherTeam = 0;
        while(!isSimulationFinished())
        {
            if((indexOfStartingTeam >= startingTeam.length) || (indexOfStartingTeam < 0))
            {
                indexOfStartingTeam = 0;
            }

            startingTeam[indexOfStartingTeam].attack(this);
            indexOfStartingTeam ++; 


            if(!isSimulationFinished())
            {
                if((indexOfOtherTeam >= otherTeam.length) || (indexOfOtherTeam < 0))
                {
                    indexOfOtherTeam = 0;
                }
                
                otherTeam[indexOfOtherTeam].attack(this);
                indexOfOtherTeam ++; 
                
            }
        }

        if(red.length > 0) //Red wins
        {
            System.out.println("Red team wins, remaining robots:");
            for(Robot remainingRobot: red)
            {
                remainingRobot.displayRobotInformation();
            }
        }
        else //Blue wins
        {
            System.out.println("Blue team wins, remaining robots:");
            for(Robot remainingRobot: blue)
            {
                remainingRobot.displayRobotInformation();
            }
        }

    }



    public void displayTeams()
    {
        System.out.println("\nRed Team:");
        for(Robot redRobot: red)
        {
            redRobot.displayRobotInformation();
        }

        System.out.println("\nBlue Team:");
        for(Robot blueRobot: blue)
        {
            blueRobot.displayRobotInformation();
        }
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
        Random type = new Random();
        if(isRedTeam)
        {
            int targetIndex = type.nextInt(0, red.length);
            target = red[targetIndex];
        }
        else //blue team
        { 
            int targetIndex = type.nextInt(0, blue.length);
            target = blue[targetIndex];
        }
        return target;


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
        ArrayList<Robot> chosenTeam = new ArrayList<Robot>();
        if(isRedTeam)
        {
            for(Robot robot: red)
            chosenTeam.add(robot);
        }
        else
        {
            for(Robot robot: blue)
            chosenTeam.add(robot);
        }

        ArrayList<Robot> lowestSpeedRobots = new ArrayList<Robot>();

        Robot robotWithLowestSpeed1 = getLowestSpeed(chosenTeam);
        lowestSpeedRobots.add(robotWithLowestSpeed1);
        chosenTeam.remove(robotWithLowestSpeed1);
   
        if(chosenTeam.size() > 0)
        {
            Robot robotWithLowestSpeed2 = getLowestSpeed(chosenTeam);
            lowestSpeedRobots.add(robotWithLowestSpeed2);
            chosenTeam.remove(robotWithLowestSpeed2);
        }
        if(chosenTeam.size() > 0)
        {
            Robot robotWithLowestSpeed3 = getLowestSpeed(chosenTeam);
            lowestSpeedRobots.add(robotWithLowestSpeed3);
            chosenTeam.remove(robotWithLowestSpeed3);
        }

        Robot [] lowestSpeed = new Robot[lowestSpeedRobots.size()];
        for(int i = 0; i < lowestSpeedRobots.size(); i++)
        {
            lowestSpeed[i] = lowestSpeedRobots.get(i);
        }
        return lowestSpeed;
    }


    public void removeRobot(Robot r)
    {

        boolean targetIsFromStarting = isFromStartingTeam(r);
        int indexOfTarget = findIndexOfTarget(r);
        if(isFromStartingTeam(r))
        {
            if(indexOfTarget < indexOfStartingTeam)
            {
                indexOfStartingTeam --;
            }
        }
        else
        {  
            if(indexOfTarget < indexOfOtherTeam)
            {
                indexOfOtherTeam --;
            }
        }


        if(r.isRedTeam())
        {
            for(int i = 0; i < red.length; i++)
            {
                if(r.getName().equals(red[i].getName()))
                {
                    red[i] = null;
                    for(int j = i; j < red.length -1; j++)
                    {
                        red[j] = red[j+1];                    
                    }
                    break;
                }
            }
            red = Arrays.copyOf(red, red.length -1);
        }
        else{
            for(int i = 0; i < blue.length; i++)
            {
                if(r.getName().equals(blue[i].getName()))
                {
                    for(int j = i; j < blue.length -1; j++)
                    {
                        blue[j] = blue[j+1];                    
                    }
                    blue[blue.length-1] = null;
                    break;
                }

            }
            blue = Arrays.copyOf(blue, blue.length -1);
        }

        if(targetIsFromStarting == true)
        {
            if(r.isRedTeam())
            {
                startingTeam = red;
            }
            else{
                startingTeam = blue;
            }
        }
        else{
            if(r.isRedTeam())
            {
                otherTeam = red;
            }
            else{
                otherTeam = blue;
            }
        }

    }

    //The simulation continues until one of the teams has all of its robots destroyed. 
    public boolean isSimulationFinished()
    {
        return (red.length == 0 || blue.length == 0);
    }

    //helper
    public static Robot getLowestSpeed(ArrayList<Robot> team)
    {
        Robot robotWithLowestSpeed;

        robotWithLowestSpeed = team.get(0);
        for(int i = 1; i < team.size(); i++)
        {
            if(team.get(i).getSpeed() < robotWithLowestSpeed.getSpeed())
            {
                robotWithLowestSpeed = team.get(i);
            }
        }
        return robotWithLowestSpeed;
    }


    public int findIndexOfTarget(Robot target)
    {
        int index = 0;
        if(target.isRedTeam())
        {
            for(int i = 0; i < red.length; i++)
            {
                if(target.getName().equals(red[i].getName()))
                {
                    index = i;
                }
            }
        }
        else{
            for(int i = 0; i < blue.length; i++)
            {
                if(target.getName().equals(blue[i].getName()))
                {
                    index = i;
                }
            }
        }
        return index;
    }


    public boolean isFromStartingTeam(Robot r)
    {
        if(startingTeam == red)
        {
            if(r.isRedTeam())
            {
                return true;
            }
        }
        if(startingTeam == blue)
        {
            if(!r.isRedTeam())
            {
                return true;
            }
        }
        return false;
    }





}
