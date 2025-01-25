import java.time.LocalDateTime;
import java.io.Serializable;

/**
 The Data class represents a generic data structure that stores 
 information about a data type, an associated value, 
 and the insertion date and time. It is serializable, 
 meaning its objects can be converted into a binary format for 
 persistence or transmission.
 */
public class Data implements Serializable
{
    private String type;
    private double value;
    private LocalDateTime insertDateTime;
    
    
    /**
    Creates a new Data object, initializing the type and value attributes 
    with the provided values, and sets the insertDateTime attribute 
    to the current date and time.
     */
    public Data(String type, double value)
    {
        this.type = type;
        this.value = value;
        insertDateTime = LocalDateTime.now();
    }
    
    /**
    Returns the type of the stored data.
     */
    public String getType(){
        return type;
    }
    
    /**
    Returns the numerical value associated with the data.
     */
    public double getValue(){
        return value;
    }
    
    /**
    Returns the date and time when the object was created.
     */
    public LocalDateTime getInsertDateTime(){
        return insertDateTime;
    }
    
    /**
    Updates the type of the stored data.
     */
    public void setType(String type){
        this.type = type;
    }
    
    /**
    Updates the numerical value associated witg the data.
     */
    public void setValue(double value){
        this.value = value;
    }
}
