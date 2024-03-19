import java.util.Random;

public class OneBot extends Robot
{
    private final double MIN_HEALTH = 0.5;
    private final double MAX_HEALTH = 1;
    private final double MIN_ATTACK = 4;
    private final double MAX_ATTACK = 5;
    private final double MIN_SPEED = 0.5;
    private final double MAX_SPEED = 1;

    public OneBot()
    {
        Random random = new Random();
        this.health = random.nextDouble(MIN_HEALTH, MAX_HEALTH);
        this.attack = random.nextDouble(MIN_ATTACK, MAX_ATTACK);
        this.speed = random.nextDouble(MIN_SPEED, MAX_SPEED);

    }

    public void attack(Simulation s)
    {
        // OneBot: Attacks the opposite team's robot with the lowest health.
        Robot target = s.getLowestHealth(!isRedTeam); 

        System.out.println(this.name + " attacks " + target.getName());
        boolean isTargetDestroyed = target.getHitAndIsDestroyed(this.attack);
        if(isTargetDestroyed)
        {
            System.out.println(target.getName() + " destroyed.");
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
