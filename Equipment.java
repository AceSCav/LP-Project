import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Equipamento here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Equipment
{
    public String name;
    public String type;
    public LocalDate lastCalibrationDate;
    public boolean operatingStatus;
    public List<Equipment> equipmentList;
    
    public Equipment(String name, String type, LocalDate lastCalibrationDate, boolean operatingStatus){
        this.name = name;
        this.type = type;
        this.lastCalibrationDate = lastCalibrationDate;
        this.operatingStatus = operatingStatus;
        this.equipmentList = new ArrayList<>();
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
    
    public void setLastCalibrationDate(LocalDate lastCalibrationDate){
        this.lastCalibrationDate = lastCalibrationDate;
    }
    
    public boolean isOperatingStatus(){
        return operatingStatus;
    }
    
    public void addEquipment(String name, String type, LocalDate lastCalibrationDate, boolean operatingStatus){
        Equipment newEquipment = new Equipment(name, type, lastCalibrationDate, operatingStatus);
        equipmentList.add(newEquipment);
        System.out.println("Equipment added: " + name);
    }   
}
