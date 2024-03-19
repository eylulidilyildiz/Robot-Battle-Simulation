
/**
 * Robot
 */
public abstract class Robot 
{
    protected double health;
    protected double attack;
    protected double speed;
    protected String name;
    protected boolean isRedTeam;


    /**
    * This method will handle the robot’s attack and needs access to the Simulation class to choose a target opponent. 
     * Different robots prefer different targets, 
     * and subclasses of Robot will override this method based on their specifications.
     */
    public abstract void attack(Simulation s);


    /**
     * This method will handle receiving damage for the robot. 
     * You will subtract the given damage from the robot's health; 
     * if the health becomes zero or less, the robot is destroyed. 
     * Return true if the robot is destroyed after receiving the damage; return false otherwise.
     */
        public abstract boolean getHitAndIsDestroyed(double damage);

    //helper
    public void displayRobotInformation()
    {
        System.out.printf("%s Health: %.3f Attack: %.3f Speed: %.3f\n" , this.name, this.health, this.attack, this.speed);
    }

    //GETTERS
    public double getHealth()
    {
        return health;
    }
    public double getAttack()
    {
        return attack;
    }
    public double getSpeed()
    {
        return speed;
    }
    public String getName()
    {
        return name;
    }
    public boolean isRedTeam()
    {
        return isRedTeam;
    }
     
    //SETTERS
    public void setName(String s)
    {
        this.name = s;
    }

    public void setTeam(String team)
    {
        if(team.equals("red"))
        {
            this.isRedTeam = true;
        }
        else if(team.equals("blue"))
        {
            this.isRedTeam = false;
        }
    }

}
