import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
/**
 * The DataSerializer class provides static methods to serialize objects into files. 
 * It is designed to handle serialization for different types of objects, including Data, ScientificExperience, Researcher, and Equipment.
 */
public class DataSerializer {
    /**
     * Serializes a Data object and writes it to a file specified by the filename.
     */
    public static void serializeData(Data data, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data); 
            System.out.println("Object serialized successfully!");
        } catch (IOException e) {
            System.err.println("Error serializing object: " + e.getMessage());
        }
    }
    /**
     * Serializes a ScientificExperience object and writes it to a file specified by the filename.
     */
    public static void serializeScientificExperience(ScientificExperience scientificExperience, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(scientificExperience); 
            System.out.println("scientificExperience serialized successfully!");
        } catch (IOException e) {
            System.err.println("Error serializing scientificExperience: " + e.getMessage());
        }
    }
    /**
     * Serializes a Researcher object and writes it to a file specified by the filename.
     */
    public static void serializeResearcher(Researcher researcher, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(researcher); 
            System.out.println("researcher serialized successfully!");
        } catch (IOException e) {
            System.err.println("Error serializing researcher: " + e.getMessage());
        }
    }
    /**
     * Serializes an Equipment object and writes it to a file specified by the filename.
     */
    public static void serializeEquipment(Equipment equipment, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(equipment); 
            System.out.println("equipment serialized successfully!");
        } catch (IOException e) {
            System.err.println("Error serializing equipment: " + e.getMessage());
        }
    }
}
