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
        public final int id;
        public String specialty;
        public String name;
        public static final List<Researcher> researchers = new ArrayList<>();
        
        public Researcher(String specialty, String name){
            this.id = nextId++;
            this.specialty = specialty;
            this.name = name;
        }
        
        public int getId(){
            return id;
        }
           
        public String getSpecialty(){
            return specialty;
        }
        
        public void setSpecialty(String specialty){
            this.specialty = specialty;
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
    }
