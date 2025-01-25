import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
/**
 * The Equipment class models a piece of equipment used in scientific experiments. It includes attributes for the equipment's name, type, last calibration date, and operating status. 
 * The class provides methods to manage and check the equipment's status and calibration.
 */
public class Equipment implements Serializable
{
    public String name;
    public String type;
    public LocalDate lastCalibrationDate;
    public boolean operatingStatus;
    
    /**
     * Creates a new Equipment object with a specified name and type, sets the last calibration date 
     * to the current date, and marks the equipment as operational.
     */
    public Equipment(String name, String type){
        this.name = name;
        this.type = type;
        this.lastCalibrationDate = LocalDate.now();
        this.operatingStatus = true;
    }
    /**
     * Returns the name of the equipment.
     */
    public String getName(){
        return name;
    }
    /**
     * Updates the name of the equipment.
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Returns the type of the stored data. 
     */
    public String getType(){
        return type;
    }
    /**
     * Returns the type of the equipment.
     */
    public void setType(String type){
        this.type = type;
    }
    /**
     * Returns the date of the last calibration.
     */
    public LocalDate getLastCalibrationDate(){
        return lastCalibrationDate;
    }
    /**
     * Updates the equipment's last calibration date to the current date. If the equipment is operational, it resets the operating status.
     */
    public void calibrateEquipment(LocalDate CalibrationDate){
        this.lastCalibrationDate = LocalDate.now();
        if(isOperatingStatus() == true){
            setOperatingStatus();
        }
    }
    /**
     * Updates the operating status based on the last calibration date. 
     * The equipment becomes non-operational if it has not been calibrated for 30 or more days.
     */
    public void setOperatingStatus(){
        int daysDifference = getLastCalibrationDate().compareTo(LocalDate.now());
        if(daysDifference<=-30){
            this.operatingStatus = false;  
        }else{
            this.operatingStatus = true;
        }
    }
    /**
     * Checks and returns the current operating status of the equipment. The status is updated based on the time since the last calibration.
     */
    public boolean isOperatingStatus(){
        int daysDifference = getLastCalibrationDate().compareTo(LocalDate.now());
        if(daysDifference<=-30){
            this.operatingStatus = false;  
        }else{
            this.operatingStatus = true;
        }
        return operatingStatus;
    }
      
}
