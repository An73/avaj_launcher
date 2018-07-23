import java.io.FileWriter;
import java.io.IOException;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        try {
            FileWriter fileWriter = new FileWriter("Simulation.txt", true);
            fileWriter.write("Helicopter \"" + name + "\" register [" + this.coordinates.getLongitude() + ", "
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

            fileWriter.write("Helicopter #" + name + "(" + id + "): ");
            weather = weatherTower.getWeather(coordinates);
            switch (weather) {
                case "RAIN":
                    fileWriter.write("Here Comes the Rain Again. ");
                    this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                    break;
                case "SUN":
                    fileWriter.write("Fun in the Sun. ");
                    this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                    break;
                case "FOG":
                    fileWriter.write("Funeral fog. ");
                    this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                    break;
                case "SNOW":
                    fileWriter.write("When will this winter end? ");
                    this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                    break;
            }
            if (this.coordinates.getHeight() <= 0) {
                weatherTower.unregister(this);
                fileWriter.write("\nHelicopter #" + name + "(" + id + "): landing. ");
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
