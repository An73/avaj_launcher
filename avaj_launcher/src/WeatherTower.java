public class WeatherTower extends Tower {
    WeatherProvider weatherProvider = WeatherProvider.getProvider();
    String getWeather(Coordinates coordinates) {
        return (weatherProvider.getCurrentWeather(coordinates));
    }

    void changeWeather() {
        this.conditionsChanged();
    }
}
