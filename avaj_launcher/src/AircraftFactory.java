public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Flyable newCraft;
        switch (type) {
            case "Helicopter":
                newCraft = new Helicopter(name, new Coordinates(longitude, latitude, height));
                return newCraft;
            case "JetPlane":
                newCraft = new JetPlane(name, new Coordinates(longitude, latitude, height));
                return newCraft;
            case "Baloon":
                newCraft = new Baloon(name , new Coordinates(longitude, latitude, height));
                return newCraft;
            default:
                System.out.println("Invalid type flyable");
                System.exit(1);
                return null;
        }
    }
}
