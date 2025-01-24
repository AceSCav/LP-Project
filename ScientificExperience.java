import java.util.ArrayList;
import java.time.LocalDate;
import java.io.Serializable;

public class ScientificExperience   implements Serializable{
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
    
    public ScientificExperience(String name, String description)
    {
        this.name = name;
        this.description = description;
        this.researchers = new ArrayList<>();
        this.data = new ArrayList<>(); 
        this.equipments = new ArrayList<>();
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
    
    public ArrayList<Equipment> getEquipments(){
        return equipments;
    }  
        
    public ArrayList<Researcher> getResearchers(){
        return researchers;
    }
    
    public ArrayList<Data> getData(){
        return data;
    }
    
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

        
    
    public String getRelatory() {
        StringBuilder report = new StringBuilder();
        report.append("Scientific Experience Report\n");
        report.append("===========================\n");
        report.append("Name: ").append(name).append("\n");
        report.append("Description: ").append(description).append("\n");
        report.append("Start Date: ").append(startDate).append("\n\n");

        // Listar pesquisadores
        report.append("Researchers:\n");
        if (researchers.isEmpty()) {
            report.append("  No researchers are participating in this experience.\n");
        } else {
            for (Researcher researcher : researchers) {
                report.append("  - Name: ").append(researcher.getName()).append("\n");
                report.append("    Specialties: ");
                if (researcher.getSpecialties() == null || researcher.getSpecialties().isEmpty()) {
                    report.append("None\n");
                } else {
                    report.append(String.join(", ", researcher.getSpecialties())).append("\n");
                }
            }
        }

        // Listar equipamentos
        report.append("\nEquipments:\n");
        if (equipments.isEmpty()) {
            report.append("  No equipment is being used in this experience.\n");
        } else {
            for (Equipment equipment : equipments) {
                report.append("  - Name: ").append(equipment.getName())
                      .append(", Type: ").append(equipment.getType()).append("\n");
            }
        }

        // Listar dados
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



    

