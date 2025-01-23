import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Investigador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
      
public class Researcher{
        
    public static int nextId = 1;
    public int id;
    public List<String> specialties;
    public String name;
    public static final List<Researcher> researchers = new ArrayList<>();
        
    public Researcher(String specialty, String name){
        this.id = nextId++;
        this.specialties = new ArrayList<>();
        this.specialties.add(specialty);
        this.name = name;
    }
        
    public int getId(){
        return id;
        }

    public String getSpecialties(){
        for(String specialities:specialities){
            System.out.println(specialities);
        };
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
        
    public static void addResearcher(String specialty, String name){
        Researcher newResearcher = new Researcher(specialty, name);
        researchers.add(newResearcher);
        System.out.println("Researcher added: " + newResearcher.getName());
    }
        
    public static void removeResearcher(int id){
        boolean found = false;
              
        for (int i = 0; i < researchers.size(); i++){
            if (researchers.get(i).getId() == id){
                System.out.println("Researcher removed: " + researchers.get(i).getName());
                researchers.remove(i);
                found = true;
                break;
            }
        }
            
        if (!found){
            System.out.println("No researcher found with ID:" + id);
        }
    }
        
    public static void listResearchers(){
        if (researchers.isEmpty()){
            System.out.println("No researchers are currently in the system.");
            return;
        }
            
        System.out.println("List of Researchers:");
        for (Researcher r : researchers){
            System.out.println("ID: " + r.getId() + ", Name: " + r.getName() + ", Specialties: " + r.getSpecialties());
        }
    }  
}
