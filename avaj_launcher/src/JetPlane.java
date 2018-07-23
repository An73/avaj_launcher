import java.io.FileWriter;
import java.io.IOException;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane (String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        try {
            FileWriter fileWriter = new FileWriter("Simulation.txt", true);
            fileWriter.write("JetPlane \"" + name + "\" register [" + this.coordinates.getLongitude() + ", "
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

            fileWriter.write("JetPlane #" + name + "(" + id + "): ");
            weather = weatherTower.getWeather(coordinates);
            switch (weather) {
                case "RAIN":
                    fileWriter.write("The rain, you saw, the rain. ");
                    this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                    break;
                case "SUN":
                    fileWriter.write("Set the controls for the heart of the sun. ");
                    this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                    this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                    break;
                case "FOG":
                    fileWriter.write("I like fog and haze. ");
                    this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                    break;
                case "SNOW":
                    fileWriter.write("Let it snow, let it snow, let it snow. ");
                    this.coordinates.setHeight(this.coordinates.getHeight() - 7);
                    break;
            }
            if (this.coordinates.getHeight() <= 0) {
                weatherTower.unregister(this);
                fileWriter.write("\nJetPlane #" + name + "(" + id + "): landing. ");
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
