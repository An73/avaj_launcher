import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.cert.Extension;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws Exception {
        FileWriter fileNew = new FileWriter("Simulation.txt");
        int cycle;
        WeatherTower weatherTower = new WeatherTower();
        AircraftFactory craftFactory = new AircraftFactory();
        ArrayList<Flyable> flyables = new ArrayList<>();
        Flyable newAir;

        if (args.length > 0) {
            try {
                FileReader fr = new FileReader(args[0]);
                Scanner scan = new Scanner(fr);

                cycle = scan.nextInt();
                scan.nextLine();
                while (scan.hasNextLine()) {
                    String craft = scan.nextLine();
                    String[] craftSplit = craft.split(" ");
                    if (craftSplit.length != 5) {
                        System.out.println("Invalid Input");
                        System.exit(1);
                    }
                    newAir = craftFactory.newAircraft(craftSplit[0], craftSplit[1], Integer.parseInt(craftSplit[2]), Integer.parseInt(craftSplit[3]), Integer.parseInt(craftSplit[4]));
                    newAir.registerTower(weatherTower);
                    flyables.add(newAir);
                }
                for (int i = 0; i < cycle; i++)
                    weatherTower.conditionsChanged();
                fileNew.close();
                fr.close();
            }
            catch (NoSuchElementException ex) {
                System.out.println("Invalid input");
            }
            catch (FileNotFoundException ex) {
                System.out.println("File not found");
            }
        }
    }
}
