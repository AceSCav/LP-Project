import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class DataSerializer {

    public static void serializeData(Data data, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);  // Escreve o objeto no arquivo
            System.out.println("Object serialized successfully!");
        } catch (IOException e) {
            System.err.println("Error serializing object: " + e.getMessage());
        }
    }
}
