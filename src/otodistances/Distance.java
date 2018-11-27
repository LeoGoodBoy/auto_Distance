
package otodistances;

public class Distance {
    private int id;
    private Location origin;
    private Location destination;
    private double distance;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the origin
     */
    public Location getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    /**
     * @return the destination
     */
    public Location getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(Location destination) {
        this.destination = destination;
    }

    /**
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }
    
    
}
