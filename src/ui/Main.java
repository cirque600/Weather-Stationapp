package ui;
import java.util.InputMismatchException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.WeatherStation;
import model.StationReadings;
import static model.WeatherStation.stations;

/**
 *
 * @author Carl Scicluna
 */
public class Main {

    Scanner sc = new Scanner(System.in);

    void start() {
        for (;;) {
            System.out.println("Weather Station");
            System.out.println("---------------");
            System.out.println("1. Add Weather Station: ");
            System.out.println("2. Add Reading to stations");
            System.out.println("3. Check Weather stations and Readings");
            System.out.println("4. Remove Weather Station");
            System.out.println("5. Remove Station Readings");
            System.out.println("6. Generate table of readings");
            System.out.println("7. Exit program.");
            int userChoice = Byte.parseByte(sc.nextLine());

            switch (userChoice) {
                case 1:
                    addWeatherStation();
                    ;
                    break;
                case 2:
                    addReadings();
                    break;
                case 3:
                    showWeatherInfo();
                    break;
                case 4:
                    deleteStation();
                    break;
                case 5:
                    deleteStationReadings();
                    break;
                    
                case 6:
                    generateTable();
                    break;
                case 7:
                    System.exit(0);
            }
        }

    }

    public void generateTable(){
        String heading1 = "Max Temp";
        String heading2 = "Min Temp";
        String heading3 = "Humidity";
        String heading4 = "Precipitation";
        String divider = "---------------------------------------------------------------";
        System.out.println("Please enter the station you want to see table of readings ");
        System.out.println(stations.toString());
        String userInput = sc.nextLine();
        
        for(WeatherStation ws:stations){
            if(userInput.equalsIgnoreCase(ws.getName())){
                 for(StationReadings sr:ws.getReadings()){
                    System.out.printf("%-15s %15s %15s %15s%n",heading1,heading2,heading3,heading4);
                    System.out.println(divider);
                    System.out.printf("%-15s %12s %15s %10s %n%n",sr.getMaxTemp(),sr.getMinTemp(),sr.getHumidity(),sr.getRainInMM());
            }
                 
            }
           
        }
    }
    
    public void deleteStationReadings(){
        System.out.println("Please enter Weather Station: ");
        System.out.println(stations.toString());
        String userInput = sc.nextLine();
        showStationReadings(userInput);
        try {
            for(WeatherStation ws:stations){
            if(ws.getName().equalsIgnoreCase(userInput)){
                System.out.println("Enter the id of station reading to delete permanently: ");
                int stationId = Integer.parseInt(sc.nextLine());
                ws.getReadings().removeIf(id -> (id.getReadingId()== stationId));
  
            }
        }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number!");
        }
        
    }
    
    public void showStationReadings(String stationName) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (WeatherStation ws : stations) {
            if (stationName.equalsIgnoreCase(ws.getName())) {
                for (int i = 0; i < ws.getReadings().size(); i++) {
                    System.out.printf("Name: %s\nId: %d\nHighest Temperature: %-5.1f\nLowest Temperature: %.1f\nHumidity: %d\nRainfall: %d\nDate: %s\n\n", ws.getName(),ws.getReading(i).getReadingId(), ws.getReading(i).getMaxTemp(), ws.getReading(i).getMinTemp(), ws.getReading(i).getHumidity(), ws.getReading(i).getRainInMM(),dtf.format(ws.getReading(i).getDate()));
                }

            }
        }
    }
    
    public void deleteStation(){
        System.out.println("Enter Station to delete: ");
        String userInput = sc.nextLine();
        System.out.println(stations.toString());
        for(WeatherStation ws:stations){
            if(ws.getName().equalsIgnoreCase(userInput));
            int indexOfStat = stations.indexOf(ws);
            System.out.println("Are you sure You want to delete this station?(y/n)");
            String userChoise = sc.nextLine();
            if(userChoise.equalsIgnoreCase("y")){
                stations.remove(indexOfStat);
                System.out.println("Station removed");
            } start();
            
        }
        
        
    }
    
    public void showWeatherInfo() {
             for (WeatherStation ws : stations) {
                System.out.printf("Name: %s\n", ws.getName());
        }
        try {
            System.out.println("Please enter the station you want to see readings for: \n");
            String userInput = sc.nextLine();
            showStationReadings(userInput);
        } catch (Exception e) {
            System.out.println("You need to enter the Weather station name!");
        }
       

    }

    public void addWeatherStation() {
        
        try {
            WeatherStation ws = new WeatherStation();
            System.out.println("Enter Weather Station name: ");
            String userInput = sc.nextLine();
            ws.setName(userInput);
            stations.add(ws);
        } catch (Exception e) {
            System.out.println("You need to enter the Weather station name!");
        }
        
        
    }


    public void addReadings() {
        
        
            System.out.println("Enter Station to add reading to: ");
            System.out.println(stations.toString());
            String userInput = sc.nextLine();
        try {
            for (WeatherStation ws : stations) {
                if (ws.getName().equalsIgnoreCase(userInput)) {
                StationReadings sr = new StationReadings();
                int readingId = ws.getReadings().size();
                sr.setReadingId(readingId + 1);
                System.out.println("\nEnter Max Temp: ");
                sr.setMaxTemp(Double.parseDouble(sc.nextLine()));
                System.out.println("Enter Min Temp: ");
                sr.setMinTemp(Double.parseDouble(sc.nextLine()));
                System.out.println("Enter Humidity: ");
                sr.setHumidity(Integer.parseInt(sc.nextLine()));
                System.out.println("Enter Rainfall(in MM) : ");
                sr.setRainInMM(Integer.parseInt(sc.nextLine()));
                System.out.println("Enter prevailing Wind");
                sr.setPrevailingWind(sc.nextLine());
                System.out.println("Enter Date (yyyy-mm-dd): ");
                sr.setDate(LocalDate.parse(sc.nextLine(), DateTimeFormatter.ISO_DATE));
                ws.addReading(sr);
            }
        }
        } catch (InputMismatchException e) {
            System.out.println("You have entered the wrong information!");
        }
        
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.start();
    }

}
