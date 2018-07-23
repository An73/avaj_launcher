public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {}
    public static WeatherProvider getProvider() {
        return (weatherProvider);
    }

    public static String getCurrentWeather(Coordinates coordinates) {
        int sum = coordinates.getHeight() + coordinates.getLongitude() + coordinates.getLatitude();
        sum = sum % 4;
        return (weather[sum]);
    }

}
