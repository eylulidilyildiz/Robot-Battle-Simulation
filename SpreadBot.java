import java.util.Random;

public class SpreadBot extends Robot
{
    private final double MIN_HEALTH = 2;
    private final double MAX_HEALTH = 3;
    private final double MIN_ATTACK = 0.5;
    private final double MAX_ATTACK = 1;
    private final double MIN_SPEED = 0.5;
    private final double MAX_SPEED = 1.5;

    public SpreadBot()
    {
        Random random = new Random();
        this.health = random.nextDouble(MIN_HEALTH, MAX_HEALTH);
        this.attack = random.nextDouble(MIN_ATTACK, MAX_ATTACK);
        this.speed = random.nextDouble(MIN_SPEED, MAX_SPEED);

    }

    public void attack(Simulation s)
    {
        Robot [] targets = s.getLowestSpeed3(!isRedTeam);
        
        System.out.println(this.name + " attacks following targets:");
        for(Robot target : targets)
        {
            System.out.print(target.getName() + " ");
        }
        System.out.println("");

        //Attacking these targets
        for(Robot target: targets)
        {
            boolean isTargetDestroyed = target.getHitAndIsDestroyed(this.attack);
            if(isTargetDestroyed)
            {
                System.out.println(target.getName() + " destroyed.");
                s.removeRobot(target);
            }
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
