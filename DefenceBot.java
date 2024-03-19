import java.util.Random;

/**
 * DefenceBot
 */
public class DefenceBot extends Robot
{
    private final double MIN_HEALTH = 3;
    private final double MAX_HEALTH = 6;
    private final double MIN_ATTACK = 0.5;
    private final double MAX_ATTACK = 1;
    private final double MIN_SPEED = 0.5;
    private final double MAX_SPEED = 1;

    public DefenceBot()
    {
        Random random = new Random();
        this.health = random.nextDouble(MIN_HEALTH, MAX_HEALTH);
        this.attack = random.nextDouble(MIN_ATTACK, MAX_ATTACK);
        this.speed = random.nextDouble(MIN_SPEED, MAX_SPEED);
    }

    public void attack()
    {

    }

    public boolean getHitAndIsDestroyed(double damage)
    {
        return (health <= 0);
    }
    
}
