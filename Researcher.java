import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Write a description of class Investigador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
      
public class Researcher implements Serializable{
        
    public static int nextId = 1;
    public int id;
    public List<String> specialties;
    public String name;
     
        
    public Researcher(String specialty, String name){
        this.id = nextId++;
        this.specialties = new ArrayList<>();
        this.specialties.add(specialty);
        this.name = name;
    }
        
    public int getId(){
        return id;
    }
    public List<String> getSpecialties(){
        return specialties;
    }
    
    public String getListOfSpecialties() {
        StringBuilder specialtiesList = new StringBuilder();
        for (String specialty : specialties) {
            specialtiesList.append(specialty).append(", "); 
        }

        if (specialtiesList.length() > 0) {
            specialtiesList.setLength(specialtiesList.length() - 2);
        }

        return specialtiesList.toString();
    }
    
        
    public void addSpecialties(String specialty){
        if (!specialties.contains(specialty)){
            specialties.add(specialty);
            System.out.println("Specialty added: " + specialty);
        } else {
            System.out.println("Specialty already exists: " + specialty);
        }
    }
        
    public void removeSpecialty(String specialty){
        if (specialties.remove(specialty)) {
                System.out.println("Specialty removed: " + specialty);
        } else {
                System.out.println("Specialty not found: " + specialty);
        }
    }
            
    public String getName(){
        return name;
    }
        
    public void setName(String name){
        this.name = name;
    }

}
