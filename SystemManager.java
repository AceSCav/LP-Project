import java.util.*;
import java.io.*;
import java.time.LocalDate;

/**
 * The SystemManager class serves as the entry point for managing various components of a scientific system, such as experiences, researchers, equipment, and data. 
 * It provides an interactive text-based menu for the user to perform various operations, such as adding, listing, and removing researchers, equipment, and data from scientific experiences. 
 * It also allows for searching and generating reports related to scientific experiences.
 */
public class SystemManager {
    
    private static List<ScientificExperience> experiences = new ArrayList<>();
    private static List<Researcher> researchers = new ArrayList<>();
    private static List<Data> dataList = new ArrayList<>();
    private static List<Equipment> equipmentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static ScientificExperience currentExperience;
    /**
     * The main method starts an infinite loop that displays the main menu and waits for user input. 
     * Based on the user's choice, it calls appropriate methods to manage experiences, researchers, equipment, data, serialization, or deserialization.
     */
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
                    manageDeserialization();
                    break;
                case 7:
                    exit();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    /**
     * Displays the main menu options for managing experiences, researchers, equipment, data, and more.
     */
    private static void showSystemMenu() {
        System.out.println("\nSystem Management Menu");
        System.out.println("1. Manage Experiences");
        System.out.println("2. Manage Researchers");
        System.out.println("3. Manage Equipment");
        System.out.println("4. Manage Data");
        System.out.println("5. Manage Serialization");
        System.out.println("6. Manage Deserialization");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }
    /**
     * Reads and returns the user input for menu selection (an integer corresponding to the menu option).
     */
    private static int getChoice() {
        return scanner.nextInt();
    }

     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////     MANAGE EXPERIENCE    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * This method handles the sub-menu for managing experiences. It provides options to create experiences, select an experience, add or remove researchers, data, 
     * and equipment, list current researchers, data, and equipment in an experience, and more.
     */
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
            System.out.println("10. Search Experience By Name");
            System.out.println("11. Generate Experience Report");
            System.out.println("12. Back to Main Menu");
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
                    searchExperienceName();
                    break;
                case 11:
                    generateExperienceReport();
                    break;
                case 12:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    /**
     * Prompts the user for the experience's name and description, then creates a new ScientificExperience and adds it to the list of experiences.
     */
    private static void createExperience() {
            System.out.print("Enter Experience Name: ");
            String name = scanner.next();
            System.out.print("Enter Experience Description: ");
            String description = scanner.next();
            experiences.add(new ScientificExperience(name, description));
            System.out.println("Experience created successfully.");
    }
    /**
     * Prompts the user to select a specific experience from the list of available experiences. 
     * It updates the currentExperience variable to the selected experience.
     */
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
    /**
     * Adds a new researcher to the currentExperience after prompting the user for the researcher's name and specialty.
     */
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
    /**
     * Adds data to the currentExperience after prompting the user for the data type and value.
     */
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
    /**
     * Adds equipment to the currentExperience after prompting the user for the equipment's name and type.
     */
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
    /**
     * Removes a researcher from the currentExperience based on the provided name, specialty, and ID.
     */
    private static void removeResearcherFromExperience() {
        if (currentExperience == null) {
            System.out.println("Please select an experience first.");
            return;
        }
    
        
        System.out.print("Enter Researcher Name: ");
        String name = scanner.next();
    
        System.out.print("Enter Researcher Specialty: ");
        String specialty = scanner.next();
    
        System.out.print("Enter Researcher ID to Remove: ");
        int id = scanner.nextInt();
    
        
        boolean removed = currentExperience.removeResearcher(name, specialty, id);
        if (removed) {
            System.out.println("Researcher removed successfully.");
        } else {
            System.out.println("Researcher not found.");
        }
    }

    /**
     * Lists all the researchers associated with the currentExperience.
     */
    private static void listResearchersInExperience() {
        if (currentExperience == null) {
            System.out.println("Please select an experience first.");
            return;
        }

        System.out.println(currentExperience.getListResearchers());
    }
    /**
     * Lists all the equipment associated with the currentExperience.
     */
    private static void listEquipmentInExperience() {
        if (currentExperience == null) {
            System.out.println("Please select an experience first.");
            return;
        }

        System.out.println(currentExperience.getListEquipment());
    }
    /**
     * Lists all the data associated with the currentExperience.
     */
    private static void listDataInExperience() {
        if (currentExperience == null) {
            System.out.println("Please select an experience first.");
            return;
        }

        System.out.println(currentExperience.getListData());
    }
    /**
     * Prompts the user for the name of a scientific experience and searches through the list of experiences to find and display the corresponding report.
     */
    private static void searchExperienceName() {
        System.out.print("Enter Researcher Specialty: ");
        String exName = scanner.next();
        for (ScientificExperience experience : experiences) {
            if (experience.getName().equals(exName)) {
                System.out.println(experience.getRelatory());
            }
        }
        System.out.println("No Scientific Experience found with the given name.");
    }
    
    /**
     * Generates and displays a report of the currentExperience
     */
    private static void generateExperienceReport() {
        if (currentExperience == null) {
            System.out.println("Please select an experience first.");
            return;
        }

        System.out.println(currentExperience.getRelatory());
    }
    
    /**
     * Displays the menu for managing researchers, which includes options to create a new researcher, list all researchers, modify researcher information, remove a researcher, and search for researchers by name or specialty.
     */
    private static void manageResearchers() {
        while (true) {
            System.out.println("\nResearcher Management Menu");
            System.out.println("1. Create New Researcher");
            System.out.println("2. List All Researchers");
            System.out.println("3. Modify Researcher Information");
            System.out.println("4. Remove Researcher");
            System.out.println("5. Search Researcher By Name");
            System.out.println("6. Search Researcher By Specialty");
            System.out.println("7. Back to Main Menu");
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
                    searchResearcherName();
                    break;
                case 6:
                    searchResearcherSpecialty();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    /**
     * Prompts the user to enter the name and specialty of a researcher. A new Researcher object is created and added to the list of researchers. The researcher’s ID is displayed after creation.
     */
    private static void createResearcher() {
        System.out.print("Enter Researcher Name: ");
        String name = scanner.next();
        System.out.print("Enter Specialty: ");
        String specialty = scanner.next();
    
        Researcher researcher = new Researcher(specialty, name);
        researchers.add(researcher);
        System.out.println("Researcher created successfully with ID: " + researcher.getId());
    }
    
    /**
     * Lists all researchers in the system, displaying their ID, name, and specialties. If no researchers are available, it informs the user.
     */
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
    /**
     * Allows the user to modify an existing researcher's name and specialties. 
     * The researcher is identified by their ID. The user can choose to add or remove specialties as part of the modification process.
     */
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
    
    /**
     * Prompts the user to enter a researcher’s ID to remove them from the list. If the researcher is found, they are removed; otherwise, an error message is displayed.
     */
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
    
    /**
     * Allows the user to search for a researcher by name. If the researcher is found, their name and specialties are displayed.
     */
    private static void searchResearcherName() {
        System.out.print("Enter Researcher name: ");
        String rName = scanner.next();
        for (Researcher researcher : researchers) {
            if (researcher.getName().equals(rName)) {
                System.out.println("researcher:" + rName + "/n" + "Specialty: " + researcher.getListOfSpecialties());
            }
        }
        System.out.println("No researcher found with the given name.");
    }
    
    /**
     * Allows the user to search for researchers by specialty. If any researchers are found with the given specialty, their names are displayed.
     */
    private static void searchResearcherSpecialty() {
        System.out.print("Enter Researcher Specialty: ");
        String rSpecialty = scanner.next();
        for (Researcher researcher : researchers) {
            if (researcher.getSpecialties().contains(rSpecialty)) {
                System.out.println("Researcher:" + researcher.getName());
            }
        }
        System.out.println("No researcher found with the given specialty.");
    }
    /**
     * A helper method that searches the list of researchers for a researcher with the specified ID. 
     * If found, the researcher is returned; otherwise, null is returned.
     */
    private static Researcher findResearcherById(int id) {
        for (Researcher researcher : researchers) {
            if (researcher.getId() == id) {
                return researcher;
            }
        }
        return null;
    }

    /**
     * This method controls the Equipment Management Menu and handles user inputs for managing equipment. 
     * It runs an infinite loop until the user decides to exit or navigate back.
     */
    private static void manageEquipment() {
        while (true) {
            System.out.println("\nEquipment Management Menu");
            System.out.println("1. Create New Equipment");
            System.out.println("2. List All Equipment");
            System.out.println("3. Modify Equipment Information");
            System.out.println("4. Calibrate Equipment");
            System.out.println("5. Remove Equipment");
            System.out.println("6. Search Equipment By Name");
            System.out.println("7. Search Equipment By Type");
            System.out.println("8. Back to Main Menu");
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
                    searchEquipmentName();
                    break;
                case 7:
                    searchEquipmentType();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    /**
     * This method creates a new piece of equipment using data provided by the user. It prompts for the name and type of the equipment, then creates an Equipment object with these details. 
     * The equipment is added to the equipmentList, and a success message is displayed.
     */
    private static void createEquipment() {
        System.out.print("Enter Equipment Name: ");
        String name = scanner.next();
        System.out.print("Enter Equipment Type: ");
        String type = scanner.next();
    
        Equipment equipment = new Equipment(name, type);
        equipmentList.add(equipment);
        System.out.println("Equipment created successfully: " + equipment.getName());
    }
    
    /**
     * This method displays all the equipment in the equipmentList. 
     * It checks if there are any equipment items in the list and then prints the details of each one, including the name, type, calibration date, and operational status (whether it is operating or not).
     */
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
    
    /**
     * This method allows the user to modify the details of an existing equipment item. It prompts for the name and type of the equipment to identify it, and then offers the option to change the name and/or type. 
     * If the user provides new values, the equipment's details are updated.
     */
    private static void modifyEquipmentInformation() {
        System.out.print("Enter Equipment Name to Modify: ");
        String name = scanner.next();
        System.out.print("Enter Equipment Type to Modify: ");
        String type = scanner.next();
    
        Equipment equipment = findEquipmentByTypeName(name,type);
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
    
    /**
     * This method allows the user to calibrate a specific piece of equipment. 
     * It prompts for the name and type of the equipment to identify it, and then updates its calibration date to the current date.
     */
    private static void calibrateEquipment() {
        System.out.print("Enter Equipment Name to Calibrate: ");
        String name = scanner.next();
        System.out.print("Enter Equipment Type to Calibrate: ");
        String type = scanner.next();
    
        Equipment equipment = findEquipmentByTypeName(name, type);
        if (equipment == null) {
            System.out.println("Equipment not found.");
            return;
        }
    
        equipment.calibrateEquipment(LocalDate.now());
        System.out.println("Equipment calibrated successfully.");
    }
    
    /**
     * This method removes a specific piece of equipment from the list. 
     * It prompts for the name and type of the equipment to identify it, and then removes the corresponding equipment item from the equipmentList.
     */
    private static void removeEquipment() {
        System.out.print("Enter Equipment Name to Remove: ");
        String name = scanner.next();
        System.out.print("Enter Equipment Type to Remove: ");
        String type = scanner.next();
    
        Equipment equipment = findEquipmentByTypeName(name, type);
        if (equipment == null) {
            System.out.println("Equipment not found.");
            return;
        }
    
        equipmentList.remove(equipment);
        System.out.println("Equipment removed successfully.");
    }
    
    /**
     * This method searches for an equipment item by its name. It prompts the user to input the equipment's name, then checks the equipmentList for a match. If found, it displays the equipment's details; otherwise, 
     * it informs the user that no equipment was found with the given name.
     */
    private static void searchEquipmentName() {
        System.out.print("Enter Equipment name: ");
        String eName = scanner.next();
        for (Equipment equipment : equipmentList) {
            if (equipment.getName().equalsIgnoreCase(eName)){
                System.out.println("Equipment:" + equipment.getName() + "Type:" + equipment.getType());
            }
        }
        System.out.println("Equipment not found with the given name.");
    }
    
    /**
     * This method searches for equipment by its type. It prompts the user to input the equipment's type and then checks the equipmentList for matching items. 
     * If any equipment of the specified type is found, it displays their names.
     */
    private static void searchEquipmentType() {
        System.out.print("Enter Equipment Type: ");
        String eType = scanner.next();
        for (Equipment equipment : equipmentList) {
            if (equipment.getType().equalsIgnoreCase(eType)){
                System.out.println("Equipment:" + equipment.getName());
            }
        }
        System.out.println("Equipment not found with the given type.");
    }
    
    /**
     * This helper method finds a specific piece of equipment based on its name and type. 
     * It is used in multiple operations, such as modifying, calibrating, and removing equipment.
     */
    private static Equipment findEquipmentByTypeName(String name, String type) {
        for (Equipment equipment : equipmentList) {
            if (equipment.getName().equalsIgnoreCase(name) && equipment.getType().equalsIgnoreCase(type)){
                return equipment;
            }
        }
        return null;
    }
    
    
    
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
    
    /**
     * This method allows the user to create a new data entry. It prompts the user to input the type and value of the data, then creates a Data object with these details. 
     * The new data is added to the dataList, and a success message is displayed.
     */
    private static void createData() {
        System.out.print("Enter Data Type: ");
        String type = scanner.next();
        System.out.print("Enter Data Value: ");
        double value = scanner.nextDouble();
    
        Data data = new Data(type, value);
        dataList.add(data);
        System.out.println("Data created successfully: " + data.getType() + ", Value: " + data.getValue());
    }
    
    /**
     * This method displays all the data entries stored in dataList. 
     * It checks if the list is empty and if not, it prints the details of each data entry, including its type, value, and insert date/time.
     */
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
    
    /**
     * This method allows the user to modify an existing data entry. It prompts the user to input the type and value of the data to identify it. Then, it allows the user to update the value of the data. 
     * If the data is found, it updates the value and confirms the change.
     */
    private static void modifyDataInformation() {
        System.out.print("Enter Data Type to Remove: ");
        String type = scanner.next();
        System.out.print("Enter Data Value to Remove: ");
        Double value = scanner.nextDouble();
        
        Data data = findDataByTypeValue(type,value);
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
    
    /**
     * This method removes a specific data entry from the list. The user is prompted to input the type and value of the data to identify it. 
     * Once found, the data entry is removed from the dataList, and a success message is displayed.
     */
    private static void removeData() {
        System.out.print("Enter Data Type to Remove: ");
        String type = scanner.next();
        System.out.print("Enter Data Value to Remove: ");
        double value = scanner.nextDouble();
        
        Data data = findDataByTypeValue(type, value);
        if (data == null) {
            System.out.println("Data not found.");
            return;
        }
    
        dataList.remove(data);
        System.out.println("Data removed successfully.");
    }
    
    /**
     * This helper method is used to find a specific data entry by its type and value. It is used in operations like modifying and removing data.
     */
    private static Data findDataByTypeValue(String type, double value) {
        for (Data data : dataList) {
            if (data.getType().equalsIgnoreCase(type) && data.getValue() == value ) {
                return data;
            }
        }
        return null;
    }
  
    
    
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
    
    /**
     * This method serializes data (either specific data or all data associated with the current scientific experience) to a file.
     */
    private static void serializeData() {
        System.out.print("Enter filename to save data: ");
        String filename = scanner.next();
        System.out.print("Do you want to serialize a specific data object? (yes/no): ");
        String choice = scanner.next().toLowerCase();
    
        if ("yes".equals(choice)) {
            System.out.print("Enter Data Type: ");
            String type = scanner.next();
            System.out.print("Enter Data Value to serialize: ");
            Double value = scanner.nextDouble();
            Data dataToSerialize = findDataByTypeValue(type,value);
            if (dataToSerialize != null) {
                DataSerializer.serializeData(dataToSerialize, filename);
            } else {
                System.out.println("Data not found.");
            }
        } else {
            if (currentExperience != null && !currentExperience.getData().isEmpty()) {
                for (Data data : currentExperience.getData()) {
                    DataSerializer.serializeData(data, filename);
                }
            } else {
                System.out.println("No data available to serialize.");
            }
        }
    }
    
    /**
     * This method serializes a researcher (either a specific researcher or all researchers associated with the current scientific experience) to a file.
     */
    private static void serializeResearcher() {
        System.out.print("Enter filename to save researcher: ");
        String filename = scanner.next();
        System.out.print("Do you want to serialize a specific researcher? (yes/no): ");
        String choice = scanner.next().toLowerCase();
    
        if ("yes".equals(choice)) {
            System.out.print("Enter ID of the researcher to serialize: ");
            int Id = scanner.nextInt();
            Researcher researcherToSerialize = findResearcherById(Id);
            if (researcherToSerialize != null) {
                DataSerializer.serializeResearcher(researcherToSerialize, filename);
            } else {
                System.out.println("Researcher not found.");
            }
        } else {
            if (currentExperience != null && !currentExperience.getResearchers().isEmpty()) {
                for (Researcher researcher : currentExperience.getResearchers()) {
                    DataSerializer.serializeResearcher(researcher, filename);
                }
            } else {
                System.out.println("No researchers available to serialize.");
            }
        }
    }
    
    /**
     * This method serializes equipment (either specific equipment or all equipment associated with the current scientific experience) to a file.
     */
    private static void serializeEquipment() {
        System.out.print("Enter filename to save equipment: ");
        String filename = scanner.next();
        System.out.print("Do you want to serialize a specific equipment? (yes/no): ");
        String choice = scanner.next().toLowerCase();
    
        if ("yes".equals(choice)) {
            System.out.print("Enter name of the equipment to serialize: ");
            String name = scanner.next();
            System.out.print("Enter type of the equipment to serialize: ");
            String type = scanner.next();
            
            Equipment equipmentToSerialize = findEquipmentByTypeName(name,type);
            if (equipmentToSerialize != null) {
                DataSerializer.serializeEquipment(equipmentToSerialize, filename);
            } else {
                System.out.println("Equipment not found.");
            }
        } else {
            if (currentExperience != null && !currentExperience.getEquipments().isEmpty()) {
                for (Equipment equipment : currentExperience.getEquipments()) {
                    DataSerializer.serializeEquipment(equipment, filename);
                }
            } else {
                System.out.println("No equipment available to serialize.");
            }
        }
    }
    
    /**
     * This method serializes the entire scientific experience (including associated data, researchers, and equipment) to a file.
     */
    private static void serializeScientificExperience() {
        System.out.print("Enter filename to save scientific experience: ");
        String filename = scanner.next();
        if (currentExperience != null) {
            // Serialize the scientific experience first
            DataSerializer.serializeScientificExperience(currentExperience, filename);
    
            // Then serialize associated data, equipment, and researchers
            if (!currentExperience.getData().isEmpty()) {
                for (Data data : currentExperience.getData()) {
                    DataSerializer.serializeData(data, filename);
                }
            }
            if (!currentExperience.getResearchers().isEmpty()) {
                for (Researcher researcher : currentExperience.getResearchers()) {
                    DataSerializer.serializeResearcher(researcher, filename);
                }
            }
            if (!currentExperience.getEquipments().isEmpty()) {
                for (Equipment equipment : currentExperience.getEquipments()) {
                    DataSerializer.serializeEquipment(equipment, filename);
                }
            }
        } else {
            System.out.println("No scientific experience available to serialize.");
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
    
    /**
     * This method deserializes data from a file and adds it to the data list.
     */
    private static void deserializeData() {
        System.out.print("Enter filename to load data: ");
        String filename = scanner.next();
        Data data = DataDeserializer.deserializeData(filename);
        if (data != null) {
            // If only data is deserialized, just add it to the data list
            dataList.add(data);
            System.out.println("Data deserialized and added to system.");
        }
    }
    
    
    /**
     * This method deserializes a researcher from a file and adds them to the researchers list.
     */
    private static void deserializeResearcher() {
        System.out.print("Enter filename to load researcher: ");
        String filename = scanner.next();
        Researcher researcher = DataDeserializer.deserializeResearcher(filename);
        if (researcher != null) {
            // If only researcher is deserialized, just add it to the researchers list
            researchers.add(researcher);
            System.out.println("Researcher deserialized and added to system.");
        }
    }
    
    /**
     * This method deserializes equipment from a file and adds it to the equipment list.
     */
    private static void deserializeEquipment() {
        System.out.print("Enter filename to load equipment: ");
        String filename = scanner.next();
        Equipment equipment = DataDeserializer.deserializeEquipment(filename);
        if (equipment != null) {
            // If only equipment is deserialized, just add it to the equipment list
            equipmentList.add(equipment);
            System.out.println("Equipment deserialized and added to system.");
        }
    }
    
    /**
     * This method deserializes an entire scientific experience (including associated data, researchers, and equipment) from a file and adds it to the system.
     */
    private static void deserializeScientificExperience() {
        System.out.print("Enter filename to load scientific experience: ");
        String filename = scanner.next();
        ScientificExperience experience = DataDeserializer.deserializeScientificExperience(filename);
        if (experience != null) {
            // If scientific experience is deserialized, add everything related to it (data, researchers, equipment)
            experiences.add(experience);
            System.out.println("Scientific experience deserialized and added to system.");
    
            // Deserialize related data (if any)
            if (experience.getData() != null && !experience.getData().isEmpty()) {
                for (Data data : experience.getData()) {
                    dataList.add(data);
                }
                System.out.println("Associated data deserialized and added to system.");
            }

            if (experience.getResearchers() != null && !experience.getResearchers().isEmpty()) {
                for (Researcher researcher : experience.getResearchers()) {
                    researchers.add(researcher);
                }
                System.out.println("Associated researchers deserialized and added to system.");
            }

            if (experience.getEquipments() != null && !experience.getEquipments().isEmpty()) {
                for (Equipment equipment : experience.getEquipments()) {
                    equipmentList.add(equipment);
                }
                System.out.println("Associated equipment deserialized and added to system.");
            }
        }
    }

    
    private static void exit() {
        System.out.println("Exiting the system...");
        scanner.close();
    }
}
