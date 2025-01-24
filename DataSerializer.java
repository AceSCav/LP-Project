import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class DataSerializer {

    public static void serializeData(Data data, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data); 
            System.out.println("Object serialized successfully!");
        } catch (IOException e) {
            System.err.println("Error serializing object: " + e.getMessage());
        }
    }
    
    public static void serializeScientificExperience(ScientificExperience scientificExperience, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(scientificExperience); 
            System.out.println("scientificExperience serialized successfully!");
        } catch (IOException e) {
            System.err.println("Error serializing scientificExperience: " + e.getMessage());
        }
    }
    
    public static void serializeResearcher(Researcher researcher, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(researcher); 
            System.out.println("researcher serialized successfully!");
        } catch (IOException e) {
            System.err.println("Error serializing researcher: " + e.getMessage());
        }
    }
    
    public static void serializeEquipment(Equipment equipment, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(equipment); 
            System.out.println("equipment serialized successfully!");
        } catch (IOException e) {
            System.err.println("Error serializing equipment: " + e.getMessage());
        }
    }
}
