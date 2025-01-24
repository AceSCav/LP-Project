import java.util.*;
import java.io.*;
import java.time.LocalDate;


public class SystemManager {

    private static List<ScientificExperience> experiences = new ArrayList<>();
    private static List<Researcher> researchers = new ArrayList<>();
    private static List<Data> dataList = new ArrayList<>();
    private static List<Equipment> equipmentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static ScientificExperience currentExperience;

    public static void main(String[] args) {
        while (true) {
            showSystemMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    manageExperience();
                    break;
                case 2:
                    manageResearchers();
                    break;
                case 3:
                    manageEquipment();
                    break;
                case 4:
                    manageData();
                    break;
                case 5:
                    manageSerialization();
                    break;
                case 6:
                    exit();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showSystemMenu() {
        System.out.println("\nSystem Management Menu");
        System.out.println("1. Manage Experiences");
        System.out.println("2. Manage Researchers");
        System.out.println("3. Manage Equipment");
        System.out.println("4. Manage Data");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice() {
        return scanner.nextInt();
    }

     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    private static void manageExperience() {
        while (true) {
            System.out.println("\nExperience Management Menu");
            System.out.println("1. Create New Experience");
            System.out.println("2. Select Experience");
            System.out.println("3. Add Researcher to Experience");
            System.out.println("4. Add Data to Experience");
            System.out.println("5. Add Equipment to Experience");
            System.out.println("6. Remove Researcher from Experience");
            System.out.println("7. List Researchers");
            System.out.println("8. List Equipment");
            System.out.println("9. List Data");
            System.out.println("10. Generate Experience Report");
            System.out.println("11. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = getChoice();
            switch (choice) {
                case 1:
                    createExperience();
                    break;
                case 2:
                    chooseExperience();
                    break;
                case 3:
                    addResearcherToExperience();
                    break;
                case 4:
                    addDataToExperience();
                    break;
                case 5:
                    addEquipmentToExperience();
                    break;
                case 6:
                    removeResearcherFromExperience();
                    break;
                case 7:
                    listResearchersInExperience();
                    break;
                case 8:
                    listEquipmentInExperience();
                    break;
                case 9:
                    listDataInExperience();
                    break;
                case 10:
                    generateExperienceReport();
                    break;
                case 11:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createExperience() {
        System.out.print("Enter Experience Name: ");
        String name = scanner.next();
        System.out.print("Enter Experience Description: ");
        String description = scanner.next();
        experiences.add(new ScientificExperience(name, description));
        System.out.println("Experience created successfully.");
    }

    private static void chooseExperience() {
        if (experiences.isEmpty()) {
            System.out.println("No experiences available. Please create one first.");
            return;
        }

        System.out.println("Available Experiences:");
        for (int i = 0; i < experiences.size(); i++) {
            System.out.println((i + 1) + ". " + experiences.get(i).getName());
        }

        System.out.print("Choose an experience by number: ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > experiences.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        currentExperience = experiences.get(choice - 1);
        System.out.println("You are now managing: " + currentExperience.getName());
    }

    private static void addResearcherToExperience() {
        if (currentExperience == null) {
            System.out.println("Please select an experience first.");
            return;
        }

        System.out.print("Enter Researcher Name: ");
        String name = scanner.next();
        System.out.print("Enter Specialty: ");
        String specialty = scanner.next();

        Researcher researcher = new Researcher(specialty, name);
        currentExperience.addResearcher(researcher.getName(), researcher.getListOfSpecialties(), researcher.getId());
        System.out.println("Researcher added to experience successfully.");
    }

    private static void addDataToExperience() {
        if (currentExperience == null) {
            System.out.println("Please select an experience first.");
            return;
        }

        System.out.print("Enter Data Type: ");
        String type = scanner.next();
        System.out.print("Enter Data Value: ");
        double value = scanner.nextDouble();

        currentExperience.addData(type, value);
        System.out.println("Data added to experience successfully.");
    }

    private static void addEquipmentToExperience() {
        if (currentExperience == null) {
            System.out.println("Please select an experience first.");
            return;
        }

        System.out.print("Enter Equipment Name: ");
        String name = scanner.next();
        System.out.print("Enter Equipment Type: ");
        String type = scanner.next();

        currentExperience.addEquipment(name, type);
        System.out.println("Equipment added to experience successfully.");
    }

    private static void removeResearcherFromExperience() {
        if (currentExperience == null) {
            System.out.println("Please select an experience first.");
            return;
        }
    
        // Solicitar os três parâmetros do usuário
        System.out.print("Enter Researcher Name: ");
        String name = scanner.next();
    
        System.out.print("Enter Researcher Specialty: ");
        String specialty = scanner.next();
    
        System.out.print("Enter Researcher ID to Remove: ");
        int id = scanner.nextInt();
    
        // Chamar o método `removeResearcher` com os três parâmetros
        boolean removed = currentExperience.removeResearcher(name, specialty, id);
        if (removed) {
            System.out.println("Researcher removed successfully.");
        } else {
            System.out.println("Researcher not found.");
        }
    }


    private static void listResearchersInExperience() {
        if (currentExperience == null) {
            System.out.println("Please select an experience first.");
            return;
        }

        System.out.println(currentExperience.getListResearchers());
    }

    private static void listEquipmentInExperience() {
        if (currentExperience == null) {
            System.out.println("Please select an experience first.");
            return;
        }

        System.out.println(currentExperience.getListEquipment());
    }

    private static void listDataInExperience() {
        if (currentExperience == null) {
            System.out.println("Please select an experience first.");
            return;
        }

        System.out.println(currentExperience.getListData());
    }

    private static void generateExperienceReport() {
        if (currentExperience == null) {
            System.out.println("Please select an experience first.");
            return;
        }

        System.out.println(currentExperience.getRelatory());
    }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static void manageResearchers() {
        while (true) {
            System.out.println("\nResearcher Management Menu");
            System.out.println("1. Create New Researcher");
            System.out.println("2. List All Researchers");
            System.out.println("3. Modify Researcher Information");
            System.out.println("4. Remove Researcher");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
    
            int choice = getChoice();
            switch (choice) {
                case 1:
                    createResearcher();
                    break;
                case 2:
                    listAllResearchers();
                    break;
                case 3:
                    modifyResearcherInformation();
                    break;
                case 4:
                    removeResearcher();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void createResearcher() {
        System.out.print("Enter Researcher Name: ");
        String name = scanner.next();
        System.out.print("Enter Specialty: ");
        String specialty = scanner.next();
    
        Researcher researcher = new Researcher(specialty, name);
        researchers.add(researcher);
        System.out.println("Researcher created successfully with ID: " + researcher.getId());
    }
    
    private static void listAllResearchers() {
        if (researchers.isEmpty()) {
            System.out.println("No researchers available.");
            return;
        }
    
        System.out.println("List of Researchers:");
        for (Researcher researcher : researchers) {
            System.out.println("ID: " + researcher.getId() + ", Name: " + researcher.getName() + ", Specialties: " + researcher.getListOfSpecialties());
        }
    }
    
    private static void modifyResearcherInformation() {
        System.out.print("Enter Researcher ID to Modify: ");
        int id = scanner.nextInt();
    
        Researcher researcher = findResearcherById(id);
        if (researcher == null) {
            System.out.println("Researcher not found.");
            return;
        }
    
        System.out.println("Current Name: " + researcher.getName());
        System.out.print("Enter new name (leave blank to keep current): ");
        String newName = scanner.next();
        if (!newName.isEmpty()) {
            researcher.setName(newName);
            System.out.println("Name updated successfully.");
        }
    
        System.out.println("Current Specialties: " + researcher.getListOfSpecialties());
        System.out.print("Do you want to add a new specialty? (y/n): ");
        char addSpecialtyChoice = scanner.next().charAt(0);
        if (addSpecialtyChoice == 'y' || addSpecialtyChoice == 'Y') {
            System.out.print("Enter Specialty to add: ");
            String newSpecialty = scanner.next();
            researcher.addSpecialties(newSpecialty);
        }
    
        System.out.print("Do you want to remove a specialty? (y/n): ");
        char removeSpecialtyChoice = scanner.next().charAt(0);
        if (removeSpecialtyChoice == 'y' || removeSpecialtyChoice == 'Y') {
            System.out.print("Enter Specialty to remove: ");
            String specialtyToRemove = scanner.next();
            researcher.removeSpecialty(specialtyToRemove);
        }
    }
    
    private static void removeResearcher() {
        System.out.print("Enter Researcher ID to Remove: ");
        int id = scanner.nextInt();
    
        Researcher researcher = findResearcherById(id);
        if (researcher == null) {
            System.out.println("Researcher not found.");
            return;
        }
    
        researchers.remove(researcher);
        System.out.println("Researcher removed successfully.");
    }
    
    private static Researcher findResearcherById(int id) {
        for (Researcher researcher : researchers) {
            if (researcher.getId() == id) {
                return researcher;
            }
        }
        return null;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////// MANAGE EQUIPMENT//////////////////////////////////////////////////////////////////////////////////////////
    private static void manageEquipment() {
        while (true) {
            System.out.println("\nEquipment Management Menu");
            System.out.println("1. Create New Equipment");
            System.out.println("2. List All Equipment");
            System.out.println("3. Modify Equipment Information");
            System.out.println("4. Calibrate Equipment");
            System.out.println("5. Remove Equipment");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
    
            int choice = getChoice();
            switch (choice) {
                case 1:
                    createEquipment();
                    break;
                case 2:
                    listAllEquipment();
                    break;
                case 3:
                    modifyEquipmentInformation();
                    break;
                case 4:
                    calibrateEquipment();
                    break;
                case 5:
                    removeEquipment();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void createEquipment() {
        System.out.print("Enter Equipment Name: ");
        String name = scanner.next();
        System.out.print("Enter Equipment Type: ");
        String type = scanner.next();
    
        Equipment equipment = new Equipment(name, type);
        equipmentList.add(equipment);
        System.out.println("Equipment created successfully: " + equipment.getName());
    }
    
    private static void listAllEquipment() {
        if (equipmentList.isEmpty()) {
            System.out.println("No equipment available.");
            return;
        }
    
        System.out.println("List of Equipment:");
        for (Equipment equipment : equipmentList) {
            System.out.println("Name: " + equipment.getName() + ", Type: " + equipment.getType() + ", Calibration Date: " + equipment.getLastCalibrationDate() + ", Operating Status: " + (equipment.isOperatingStatus() ? "Operating" : "Not Operating"));
        }
    }
    
    private static void modifyEquipmentInformation() {
        System.out.print("Enter Equipment Name to Modify: ");
        String name = scanner.next();
    
        Equipment equipment = findEquipmentByName(name);
        if (equipment == null) {
            System.out.println("Equipment not found.");
            return;
        }
    
        System.out.println("Current Type: " + equipment.getType());
        System.out.print("Enter new type (leave blank to keep current): ");
        String newType = scanner.next();
        if (!newType.isEmpty()) {
            equipment.setType(newType);
            System.out.println("Type updated successfully.");
        }
    
        System.out.println("Current Name: " + equipment.getName());
        System.out.print("Enter new name (leave blank to keep current): ");
        String newName = scanner.next();
        if (!newName.isEmpty()) {
            equipment.setName(newName);
            System.out.println("Name updated successfully.");
        }
    }
    
    private static void calibrateEquipment() {
        System.out.print("Enter Equipment Name to Calibrate: ");
        String name = scanner.next();
    
        Equipment equipment = findEquipmentByName(name);
        if (equipment == null) {
            System.out.println("Equipment not found.");
            return;
        }
    
        equipment.calibrateEquipment(LocalDate.now());
        System.out.println("Equipment calibrated successfully.");
    }
    
    private static void removeEquipment() {
        System.out.print("Enter Equipment Name to Remove: ");
        String name = scanner.next();
    
        Equipment equipment = findEquipmentByName(name);
        if (equipment == null) {
            System.out.println("Equipment not found.");
            return;
        }
    
        equipmentList.remove(equipment);
        System.out.println("Equipment removed successfully.");
    }
    
    private static Equipment findEquipmentByName(String name) {
        for (Equipment equipment : equipmentList) {
            if (equipment.getName().equalsIgnoreCase(name)) {
                return equipment;
            }
        }
        return null;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static void manageData() {
        while (true) {
            System.out.println("\nData Management Menu");
            System.out.println("1. Create New Data");
            System.out.println("2. List All Data");
            System.out.println("3. Modify Data Information");
            System.out.println("4. Remove Data");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
    
            int choice = getChoice();
            switch (choice) {
                case 1:
                    createData();
                    break;
                case 2:
                    listAllData();
                    break;
                case 3:
                    modifyDataInformation();
                    break;
                case 4:
                    removeData();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void createData() {
        System.out.print("Enter Data Type: ");
        String type = scanner.next();
        System.out.print("Enter Data Value: ");
        double value = scanner.nextDouble();
    
        Data data = new Data(type, value);
        dataList.add(data);
        System.out.println("Data created successfully: " + data.getType() + ", Value: " + data.getValue());
    }
    
    private static void listAllData() {
        if (dataList.isEmpty()) {
            System.out.println("No data available.");
            return;
        }
    
        System.out.println("List of Data:");
        for (Data data : dataList) {
            System.out.println("Type: " + data.getType() + ", Value: " + data.getValue() + ", Insert Date/Time: " + data.getInsertDateTime());
        }
    }
    
    private static void modifyDataInformation() {
        System.out.print("Enter Data Type to Modify: ");
        String type = scanner.next();
    
        Data data = findDataByType(type);
        if (data == null) {
            System.out.println("Data not found.");
            return;
        }
    
        System.out.println("Current Value: " + data.getValue());
        System.out.print("Enter new value (leave blank to keep current): ");
        double newValue = scanner.nextDouble();
        data.setValue(newValue);
        System.out.println("Value updated successfully.");
    }
    
    private static void removeData() {
        System.out.print("Enter Data Type to Remove: ");
        String type = scanner.next();
    
        Data data = findDataByType(type);
        if (data == null) {
            System.out.println("Data not found.");
            return;
        }
    
        dataList.remove(data);
        System.out.println("Data removed successfully.");
    }
    
    private static Data findDataByType(String type) {
        for (Data data : dataList) {
            if (data.getType().equalsIgnoreCase(type)) {
                return data;
            }
        }
        return null;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    private static void manageSerialization() {
        while (true) {
            System.out.println("\nSerialization Menu");
            System.out.println("1. Serialize Data");
            System.out.println("2. Serialize Researcher");
            System.out.println("3. Serialize Equipment");
            System.out.println("4. Serialize Scientific Experience");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
    
            int choice = getChoice();
            switch (choice) {
                case 1:
                    serializeData();
                    break;
                case 2:
                    serializeResearcher();
                    break;
                case 3:
                    serializeEquipment();
                    break;
                case 4:
                    serializeScientificExperience();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void manageDeserialization() {
        while (true) {
            System.out.println("\nDeserialization Menu");
            System.out.println("1. Deserialize Data");
            System.out.println("2. Deserialize Researcher");
            System.out.println("3. Deserialize Equipment");
            System.out.println("4. Deserialize Scientific Experience");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
    
            int choice = getChoice();
            switch (choice) {
                case 1:
                    deserializeData();
                    break;
                case 2:
                    deserializeResearcher();
                    break;
                case 3:
                    deserializeEquipment();
                    break;
                case 4:
                    deserializeScientificExperience();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void serializeData() {
        System.out.print("Enter filename to save data: ");
        String filename = scanner.next();
        if (currentExperience != null && !currentExperience.getData().isEmpty()) {
            for (Data data : currentExperience.getData()) {
                DataSerializer.serializeData(data, filename);
            }
        } else {
            System.out.println("No data available to serialize.");
        }
    }
    
    private static void serializeResearcher() {
        System.out.print("Enter filename to save researcher: ");
        String filename = scanner.next();
        if (currentExperience != null && !currentExperience.getResearchers().isEmpty()) {
            for (Researcher researcher : currentExperience.getResearchers()) {
                DataSerializer.serializeResearcher(researcher, filename);
            }
        } else {
            System.out.println("No researchers available to serialize.");
        }
    }
    
    private static void serializeEquipment() {
        System.out.print("Enter filename to save equipment: ");
        String filename = scanner.next();
        if (currentExperience != null && !currentExperience.getEquipments().isEmpty()) {
            for (Equipment equipment : currentExperience.getEquipments()) {
                DataSerializer.serializeEquipment(equipment, filename);
            }
        } else {
            System.out.println("No equipment available to serialize.");
        }
    }
    
    private static void serializeScientificExperience() {
        System.out.print("Enter filename to save scientific experience: ");
        String filename = scanner.next();
        if (currentExperience != null) {
            DataSerializer.serializeScientificExperience(currentExperience, filename);
        } else {
            System.out.println("No scientific experience available to serialize.");
        }
    }
    
    private static void deserializeData() {
        System.out.print("Enter filename to load data: ");
        String filename = scanner.next();
        Data data = DataDeserializer.deserializeData(filename);
        if (data != null) {
            dataList.add(data);
            System.out.println("Data deserialized and added to system.");
        }
    }
    
    private static void deserializeResearcher() {
        System.out.print("Enter filename to load researcher: ");
        String filename = scanner.next();
        Researcher researcher = DataDeserializer.deserializeResearcher(filename);
        if (researcher != null) {
            researchers.add(researcher);
            System.out.println("Researcher deserialized and added to system.");
        }
    }
    
    private static void deserializeEquipment() {
        System.out.print("Enter filename to load equipment: ");
        String filename = scanner.next();
        Equipment equipment = DataDeserializer.deserializeEquipment(filename);
        if (equipment != null) {
            equipmentList.add(equipment);
            System.out.println("Equipment deserialized and added to system.");
        }
    }
    
    private static void deserializeScientificExperience() {
        System.out.print("Enter filename to load scientific experience: ");
        String filename = scanner.next();
        ScientificExperience experience = DataDeserializer.deserializeScientificExperience(filename);
        if (experience != null) {
            experiences.add(experience);
            System.out.println("Scientific experience deserialized and added to system.");
        }
    }

    
    private static void exit() {
        System.out.println("Exiting the system...");
        scanner.close();
    }
}
