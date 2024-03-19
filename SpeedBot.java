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
        return (health <= 0);
    }
    
}
