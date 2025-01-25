import java.util.ArrayList;
import java.time.LocalDate;
import java.io.Serializable;

public class ScientificExperience   implements Serializable, ScientificOperations{
    public String name;
    public String description;
    public ArrayList<Data> data;
    public ArrayList<Equipment> equipments;
    public ArrayList<Researcher> researchers;
    public LocalDate startDate;
    
    
    /**
    Description: Initializes the experiment with a name, description, and  initial researcher, equipment, and data entries.
     */
    public ScientificExperience(String name, String description, Researcher researcher, Equipment equipment, Data data)
    {
        this.name = name;
        this.description = description;
        this.researchers = new ArrayList<>();
        if(researcher != null){
            this.researchers.add(researcher);
        }
        this.data = new ArrayList<>(); 
        if(data != null){
            this.data.add(data);
        }
        this.equipments = new ArrayList<>();
        if(equipment != null){
            this.equipments.add(equipment);
        }
        startDate = LocalDate.now();
    }
    /**
     * Description: Initializes the experiment with a name and description, 
     * creating empty lists for researchers, equipment, and data.
     */
    public ScientificExperience(String name, String description)
    {
        this.name = name;
        this.description = description;
        this.researchers = new ArrayList<>();
        this.data = new ArrayList<>(); 
        this.equipments = new ArrayList<>();
        startDate = LocalDate.now();
    }
    /**
     * Returns the experiment's name.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the experiment's name.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns the experiment's description.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the experiment's description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Returns the experiment's start date.
     */
    public LocalDate getStartDate() {
        return startDate;
    }
    
    
    
    /**
     Adds a researcher to the experiment if they are not already participating.
     */
    public void addResearcher(String name, String specialty, int id) {
        boolean researcherExists = false;
        for(Researcher researcher:researchers) {
            if (researcher.getId() == id && researcher.getName().equals(name)&&researcher.getSpecialties().contains(specialty)) {
                researcherExists = true;
                System.out.println("The researcher is already involved in this research.");
                break;
            }
        }
        
        if (!researcherExists) {
            Researcher newResearcher = new Researcher(name, specialty);
            researchers.add(newResearcher);
            System.out.println("Researcher " + name + " added.");
        } else {
            boolean isInList = false;
            for (Researcher researcher : researchers) {
                if(researcher.getId()==id &&researcher.getName().equals(name)) {
                    isInList = true;
                    break;
                }
            }
            
            if (!isInList) {
                Researcher newResearcher = new Researcher(name, specialty);
                researchers.add(newResearcher);
                System.out.println("Researcher " + name + " added to the list.");
            } else {
                System.out.println("Researcher " + name + " is already in the list.");
            }
        }
    }
    /**
     * Removes a researcher from the experiment by their name, specialty, and ID.
     * Returns true if the researcher is removed, false otherwise.
     */
    public boolean removeResearcher(String name, String specialty, int id) {
        boolean researcherFound = false;
        Researcher researcherToRemove = null;
    
        for (Researcher researcher : researchers) {
            if (researcher.getId() == id && researcher.getName().equals(name) && researcher.getSpecialties().contains(specialty)) {
                researcherFound = true;
                researcherToRemove = researcher;
                break;
            }
        }
    
        if (researcherFound) {
            researchers.remove(researcherToRemove);
            return true;  // return true when researcher is removed
        } else {
            return false; // return false when researcher is not found
        }
    }


    
    /**
     Adds a piece of equipment to the experiment if it is not already in use.   
     */
    public void addEquipment(String name, String type) {

        boolean equipmentExists = false;
        for (Equipment equipment : equipments) {
            if (equipment.getName().equals(name) && equipment.getType().equals(type)) {
                equipmentExists = true;
                System.out.println("The researcher is already involved in this research.");
                break;
            }
        }


        if (!equipmentExists) {
            Equipment newEquipment = new Equipment(name, type);
            equipments.add(newEquipment);
            equipments.add(newEquipment);
            System.out.println("Equipment " + name + " added.");
        } else {

            System.out.println("Equipment " + name + " is already in the list.");
        }
    }
    /**
     * Returns a formatted string of all researchers in the experiment.
     */
    public String getListResearchers() {
        if (researchers.isEmpty()) {
            return "No researchers are currently in the system.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("List of Researchers:\n");
        for (Researcher researcher : researchers) {
            sb.append("ID: ").append(researcher.getId())
              .append(", Name: ").append(researcher.getName())
              .append(", Specialties: ");
            if (researcher.getSpecialties() == null || researcher.getSpecialties().isEmpty()) {
                sb.append("None\n");
            } else {
                sb.append(String.join(", ", researcher.getSpecialties())).append("\n");
            }
        }
        return sb.toString();
    }

    /**
     * Adds a data entry to the experiment if it is not already present.
     */
    public void addData(String type,double value){
        
        boolean dataExists = false;
        for (Data data : data) {
            if (data.getType().equals(type) && data.getValue() == value) {
                dataExists = true;
                System.out.println("Data is already inserted in this research.");
                break;
            }
        }

        if (!dataExists) {
            Data newData = new Data(type, value);
            data.add(newData);
            System.out.println("Data added.");
        } else {

            System.out.println("Equipment is already in the list.");
            }
        }
    /**
     * Returns the list of equipment used.
     */
    public ArrayList<Equipment> getEquipments(){
        return equipments;
    }  
    
    /**
     * Returns the list of researchers.
     */
    public ArrayList<Researcher> getResearchers(){
        return researchers;
    }
    /**
     * Returns the list of data entries.
     */ 
    public ArrayList<Data> getData(){
        return data;
    }
    /**
     * Returns a formatted string of all data entries in the experiment.
     */
    public String getListData() {
        if (data.isEmpty()) {
            return "No data has been added to the system.";
        }
    
        StringBuilder sb = new StringBuilder();
        sb.append("List of Data:\n");
        for (Data d : data) {
            sb.append("Type: ").append(d.getType())
              .append(", Value: ").append(d.getValue())
              .append("\n");
        }
        return sb.toString();
    }
    /**
     * Returns a formatted string of all equipment used in the experiment.
     */
        public String getListEquipment() {
        if (equipments.isEmpty()) {
            return "No equipment is currently in the system.";
        }
    
        StringBuilder sb = new StringBuilder();
        sb.append("List of Equipment:\n");
        for (Equipment equipment : equipments) {
            sb.append("Name: ").append(equipment.getName())
              .append(", Type: ").append(equipment.getType())
              .append("\n");
        }
        return sb.toString();
    }

        
    /**
     * Generates a detailed report of the experiment, including its name, description, start date, researchers, equipment, and data.
     */
    public String getRelatory() {
        StringBuilder report = new StringBuilder();
        report.append("Scientific Experience Report\n");
        report.append("===========================\n");
        report.append("Name: ").append(name).append("\n");
        report.append("Description: ").append(description).append("\n");
        report.append("Start Date: ").append(startDate).append("\n\n");

        
        report.append("Researchers:\n");
        if (researchers.isEmpty()) {
            report.append("  No researchers are participating in this experience.\n");
        } else {
            for (Researcher researcher : researchers) {
                report.append("  - Specialties: ").append(researcher.getName()).append("\n");
                report.append("    Name: ");
                if (researcher.getSpecialties() == null || researcher.getSpecialties().isEmpty()) {
                    report.append("None\n");
                } else {
                    report.append(String.join(", ", researcher.getSpecialties())).append("\n");
                }
            }
        }

        report.append("\nEquipments:\n");
        if (equipments.isEmpty()) {
            report.append("  No equipment is being used in this experience.\n");
        } else {
            for (Equipment equipment : equipments) {
                report.append("  - Name: ").append(equipment.getName())
                      .append(", Type: ").append(equipment.getType()).append("\n");
            }
        }

        report.append("\nData:\n");
        if (data.isEmpty()) {
            report.append("  No data has been added to this experience.\n");
        } else {
            for (Data d : data) {
                report.append("  - Type: ").append(d.getType())
                      .append(", Value: ").append(d.getValue()).append("\n");
            }
        }

        return report.toString();
    }

}



    

