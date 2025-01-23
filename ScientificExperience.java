import java.util.ArrayList;
import java.time.LocalDate;
import java.io.Serializable;

public class ScientificExperience implements Serializable{
    public String name;
    public String description;
    public ArrayList<Data> data;
    public ArrayList<Equipment> equipments;
    public ArrayList<Researcher> researchers;
    public LocalDate startDate;
    
    
    
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    
    /**
     implementar aqui a verificação para se o investigador ja estiver inserido nao inserir novamente
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
     implementar aqui a verificação para se o equipamento ja estiver inserido nao inserir novamente
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
            System.out.println("Equipment " + name + " added.");
        } else {

            System.out.println("Equipment " + name + " is already in the list.");
        }
    }
    
    public void listResearchers(){
        if (researchers.isEmpty()){
            System.out.println("No researchers are currently in the system.");
            return;
        }
            
        System.out.println("List of Researchers:");
        for (Researcher researchers : researchers){
            System.out.println("ID: " + researchers.getId() + ", Name: " + researchers.getName() + ", Specialties: " + researchers.getSpecialties());
        }
    }  
}
    

