import java.io.FileWriter;
import java.io.IOException;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon (String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        try {
            FileWriter fileWriter = new FileWriter("Simulation.txt", true);
            fileWriter.write("Baloon \"" + name + "\" register [" + this.coordinates.getLongitude() + ", "
                    + this.coordinates.getLatitude() + ", " + this.coordinates.getHeight() + "]\n");
            fileWriter.close();
        }
        catch (IOException e) {
            System.err.print("Error FileWrite\n");
        }
    }

    @Override
    public void updateConditions() {
        String weather;
        try {
            FileWriter fileWriter = new FileWriter("Simulation.txt", true);

            fileWriter.write("Baloon #" + name + "(" + id + "): ");
            weather = weatherTower.getWeather(coordinates);
            switch (weather) {
                case "RAIN":
                    fileWriter.write("Rain down on me. ");
                    this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                    break;
                case "SUN":
                    fileWriter.write("Lucky old sun. ");
                    this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                    this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                    break;
                case "FOG":
                    fileWriter.write("Lost in a fog without you. ");
                    this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                    break;
                case "SNOW":
                    fileWriter.write("Race the snow. ");
                    this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                    break;
            }
            if (this.coordinates.getHeight() <= 0) {
                weatherTower.unregister(this);
                fileWriter.write("\nBaloon #" + name + "(" + id + "): landing. ");
                this.coordinates.setHeight(0);
            } else if (this.coordinates.getHeight() > 100) {
                this.coordinates.setHeight(100);
            }
            fileWriter.write("[" + this.coordinates.getLongitude() + ", "
                    + this.coordinates.getLatitude() + ", " + this.coordinates.getHeight() + "]\n");
            fileWriter.close();
        }
        catch (IOException e) {
            System.err.print("Error FileWrite\n");
        }
    }
}
