import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * The Researcher class models a researcher involved in scientific experiments. It manages information about the researcher’s unique ID, name, and their areas of expertise (specialties). 
 * This class allows for adding, retrieving, and modifying researcher details.
 */
      
public class Researcher implements Serializable{
        
    public static int nextId = 1;
    public int id;
    public List<String> specialties;
    public String name;
     
    /**
     * Creates a new Researcher object with the specified specialty and name. 
     * Assigns a unique ID automatically and initializes the list of specialties with the given specialty.
     */    
    public Researcher(String specialty, String name){
        this.id = nextId++;
        this.specialties = new ArrayList<>();
        this.specialties.add(specialty);
        this.name = name;
    }
    /**
     * Returns the unique ID of the researcher.
     */    
    public int getId(){
        return id;
    }
    /**
     * Returns the list of specialties of the researcher.
     */
    public List<String> getSpecialties(){
        return specialties;
    }
    /**
     * Returns a formatted string containing all specialties separated by commas.
     */
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
    
    /**
     * Adds a new specialty to the list if it does not already exist. 
     * Prints a confirmation message upon successful addition or a warning if the specialty already exists.
     */    
    public void addSpecialties(String specialty){
        if (!specialties.contains(specialty)){
            specialties.add(specialty);
            System.out.println("Specialty added: " + specialty);
        } else {
            System.out.println("Specialty already exists: " + specialty);
        }
    }
    /**
     * Removes a specialty from the list if it exists. Prints a confirmation message upon successful removal or a warning if the specialty was not found.
     */
    public void removeSpecialty(String specialty){
        if (specialties.remove(specialty)) {
                System.out.println("Specialty removed: " + specialty);
        } else {
                System.out.println("Specialty not found: " + specialty);
        }
    }
    /**
     * Returns the name of the researcher.
     */      
    public String getName(){
        return name;
    }
    /**
     * Updates the name of the researcher.
     */
    public void setName(String name){
        this.name = name;
    }

}
