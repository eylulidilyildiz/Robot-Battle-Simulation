import java.util.Random;

public class SpeedBot extends Robot
{
    private final double MIN_HEALTH = 1;
    private final double MAX_HEALTH = 2;
    private final double MIN_ATTACK = 1;
    private final double MAX_ATTACK = 2;
    private final double MIN_SPEED = 3;
    private final double MAX_SPEED = 4;

    public SpeedBot()
    {
        Random random = new Random();
        this.health = random.nextDouble(MIN_HEALTH, MAX_HEALTH);
        this.attack = random.nextDouble(MIN_ATTACK, MAX_ATTACK);
        this.speed = random.nextDouble(MIN_SPEED, MAX_SPEED);

    }

    public void attack(Simulation s)
    {

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
