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

    public void attack( Simulation s)
    {

    }

    public boolean getHitAndIsDestroyed(double damage)
    {
        return (health <= 0);
    }
    
}
