import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * Write a description of class Dados here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Data implements Serializable
{
    private String type;
    private double value;
    private LocalDateTime insertDateTime;
    

    /**
     * Constructor for objects of class Dados
     */
    public Data(String type, double value)
    {
        this.type = type;
        this.value = value;
        insertDateTime = LocalDateTime.now();
    }
    
    public String getType(){
        return type;
    }
    
    public double getValue(){
        return value;
    }
    
    public LocalDateTime getInsertDateTime(){
        return insertDateTime;
    }
    
}
