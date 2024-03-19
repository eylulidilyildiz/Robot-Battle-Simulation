import java.util.Scanner;

public class SimulationTester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean inputIsValid = false;
        int teamSize = 0;
        System.out.print("Team Size: ");
        while(!inputIsValid)
        {
            if(!input.hasNextInt())
            {
                System.out.print("Team size should be an integer!\nTeam Size:");
                input = new Scanner(System.in);
            }
            else{
                teamSize = input.nextInt();
                if(teamSize <= 0)
                {
                    System.out.print("Team size should be positive!\nTeam Size:");
                    input = new Scanner(System.in);
                }
                else{
                    inputIsValid = true;
                }
            }
        }
        Simulation firstRound = new Simulation(teamSize);
        firstRound.simulate();


        
    }
}
