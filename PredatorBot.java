import java.util.Random;

public class PredatorBot extends Robot
{
    private final double MIN_HEALTH = 2;
    private final double MAX_HEALTH = 3;
    private final double MIN_ATTACK = 2;
    private final double MAX_ATTACK = 3;
    private final double MIN_SPEED = 0.5;
    private final double MAX_SPEED = 1;

    public PredatorBot()
    {
        Random random = new Random();
        this.health = random.nextDouble(MIN_HEALTH, MAX_HEALTH);
        this.attack = random.nextDouble(MIN_ATTACK, MAX_ATTACK);
        this.speed = random.nextDouble(MIN_SPEED, MAX_SPEED);

    }

    public void attack(Simulation s)
    {
        Robot target;
        if(this.isRedTeam) //if this PredatorBot is red
        {
            target = s.getHighestHealth(!isRedTeam); //chooses target from blue team
        }
        else{
            target = s.getHighestHealth(isRedTeam);
        }


        boolean isTargetDestroyed = target.getHitAndIsDestroyed(this.attack);
        if(isTargetDestroyed)
        {
            s.removeRobot(target);
        }
    }

    public boolean getHitAndIsDestroyed(double damage)
    {
        if(this.health <= damage)
        {
            this.health = 0;
        }
        else{
            this.health -= damage;
        }
 
        System.out.printf("%s receives %.3f damage -> remaining health: %.3f\n", this.name, damage, this.health);
        return (health <= 0);
    }
    
}
