import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
/**

 */
public class Equipment implements Serializable
{
    public String name;
    public String type;
    public LocalDate lastCalibrationDate;
    public boolean operatingStatus;
    
    
    public Equipment(String name, String type){
        this.name = name;
        this.type = type;
        this.lastCalibrationDate = LocalDate.now();
        this.operatingStatus = true;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getType(){
        return type;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public LocalDate getLastCalibrationDate(){
        return lastCalibrationDate;
    }
    
    public void calibrateEquipment(LocalDate CalibrationDate){
        this.lastCalibrationDate = LocalDate.now();
        if(isOperatingStatus() == true){
            setOperatingStatus();
        }
    }
    
    public void setOperatingStatus(){
        int daysDifference = getLastCalibrationDate().compareTo(LocalDate.now());
        if(daysDifference<=-30){
            this.operatingStatus = false;  
        }else{
            this.operatingStatus = true;
        }
    }
    
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
