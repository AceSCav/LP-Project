import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
/**
 * The DataDeserializer class provides static methods to deserialize objects from files. 
 * It is designed to handle deserialization for various types of objects, including Data, ScientificExperience, Equipment, and Researcher.
 */
public class DataDeserializer {
    /**
     * Reads and deserializes a Data object from a file specified by the filename.
     */
    public static Data deserializeData(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Data) ois.readObject();  
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing object: " + e.getMessage());
            return null;
        }
    }
    /**
     * Reads and deserializes a ScientificExperience object from a file specified by the filename.
     */
    public static ScientificExperience deserializeScientificExperience(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (ScientificExperience) ois.readObject();  
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing object: " + e.getMessage());
            return null;
        }
    }
    /**
     * Reads and deserializes an Equipment object from a file specified by the filename.
     */
    public static Equipment deserializeEquipment(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Equipment) ois.readObject();  
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing object: " + e.getMessage());
            return null;
        }
    }
    /**
     * Reads and deserializes a Researcher object from a file specified by the filename.
     */
    public static Researcher deserializeResearcher(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Researcher) ois.readObject();  
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing object: " + e.getMessage());
            return null;
        }
    }
}
