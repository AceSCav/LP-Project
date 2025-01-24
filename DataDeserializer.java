import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class DataDeserializer {

    public static Data deserializeData(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Data) ois.readObject();  
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing object: " + e.getMessage());
            return null;
        }
    }
    
    public static ScientificExperience deserializeScientificExperience(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (ScientificExperience) ois.readObject();  
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing object: " + e.getMessage());
            return null;
        }
    }
    
    public static Equipment deserializeEquipment(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Equipment) ois.readObject();  
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing object: " + e.getMessage());
            return null;
        }
    }
    
    public static Researcher deserializeResearcher(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Researcher) ois.readObject();  
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing object: " + e.getMessage());
            return null;
        }
    }
}
