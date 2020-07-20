
package model;




import java.util.ArrayList;

/**
 *
 * @author Carl Scicluna
 */
public class WeatherStation{
    
    public static  ArrayList<WeatherStation> stations = new ArrayList();
    private String name;
    private String location;
    private final ArrayList<StationReadings> readings = new ArrayList<>();
    
    

    
    public  WeatherStation(String name, String location){
        this.name = name;
        this.location = location;
        
    }

    public WeatherStation() {
    }
    

    
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    

    /**
     * @return the stations
     */
    public static ArrayList<WeatherStation> getStations() {
        return stations;
    }

   

    
    public void addReading(StationReadings reading) {
        this.readings.add(reading);
    }

    public StationReadings getReading(int index) {
        return this.readings.get(index);
    }

    public ArrayList<StationReadings> getReadings() {
        return this.readings;
    }

    
    @Override
    public String toString() {
        return this.name;

    }
    
    
   
    
}
