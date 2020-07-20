
package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Carl Scicluna
 */
public class StationReadings {
    
    private double maxTemp;
    private double minTemp;
    private int humidity;
    private int rainInMM;
    private WeatherStation station;
    private String prevailingWind;
    private LocalDate date;
    private int readingId;

    
    

    
    
    /**
     * @return the maxTemp
     */
    public double getMaxTemp() {
        return maxTemp;
    }

    /**
     * @param maxTemp the maxTemp to set
     */
    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    /**
     * @return the minTemp
     */
    public double getMinTemp() {
        return minTemp;
    }

    /**
     * @param minTemp the minTemp to set
     */
    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    /**
     * @return the humidity
     */
    public int getHumidity() {
        return humidity;
    }

    /**
     * @param humidity the humidity to set
     */
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    /**
     * @return the rainInMM
     */
    public int getRainInMM() {
        return rainInMM;
    }

    /**
     * @param rainInMM the rainInMM to set
     */
    public void setRainInMM(int rainInMM) {
        this.rainInMM = rainInMM;
    }

    /**
     * @return the station
     */
    public WeatherStation getStation() {
        return station;
    }

    /**
     * @param station the station to set
     */
    public void setStation(WeatherStation station) {
        this.station = station;
    }

    /**
     * @return the prevailingWind
     */
    public String getPrevailingWind() {
        return prevailingWind;
    }

    /**
     * @param prevailingWind the prevailingWind to set
     */
    public void setPrevailingWind(String prevailingWind) {
        this.prevailingWind = prevailingWind;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
//    public int comapreTo(StationReadings o){
//        return this.date.compareTo(o.date);
//    }

    /**
     * @return the readingId
     */
    public int getReadingId() {
        return readingId;
    }

    /**
     * @param readingId the readingId to set
     */
    public void setReadingId(int readingId) {
        this.readingId = readingId;
    }
    
}
