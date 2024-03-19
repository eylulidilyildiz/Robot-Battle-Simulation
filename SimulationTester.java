import java.util.Scanner;

public class SimulationTester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Team Size: ");
        while(!input.hasNextInt())
        {
            System.out.print("Team size should be an integer!\nTeam Size:");
            input = new Scanner(System.in);
        }
        int teamSize = input.nextInt();
        Simulation firstRound = new Simulation(teamSize);
        firstRound.simulate();


        
    }
}
