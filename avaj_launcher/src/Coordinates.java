public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates (int longitude, int latitude, int height) {
        if (height < 0) {
            System.out.println("Error coordinates");
            System.exit(1);
        }
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
        if (height > 100)
            this.height = 100;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
