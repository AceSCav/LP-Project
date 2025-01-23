import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class DataDeserializer {

    public static Data deserializeData(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Data) ois.readObject();  // Lê o objeto do arquivo e converte de volta
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing object: " + e.getMessage());
            return null;
        }
    }
    
}
