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

    }

    public boolean getHitAndIsDestroyed(double damage)
    {
        return (health <= 0);
    }
    
}
