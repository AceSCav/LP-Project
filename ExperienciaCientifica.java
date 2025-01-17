import java.util.ArrayList;

public class ExperienciaCientifica
{
    public String name;
    public String description;
    public ArrayList<Data> data;
    public ArrayList<Equipment> equipment;
    public ArrayList<Researcher> researcher;
    
    
    public ExperienciaCientifica(String name, String description, ArrayList<Data>data, ArrayList<Researcher> researcher,ArrayList<Equipment> equipment)
    {
        this.name = name;
        this.description = setDescription();
        researchers = new ArrayList<>();
        data = new ArrayList<>(); 
        equipments = new ArrayList<>();
    }
    /**
     aqui penso em implementar um log de alteração na descrição
     */
    public void setDescription(String description){
        this.description = description;
    }
    /**
     implementar aqui a verificação para se o investigador ja estiver inserido nao inserir novamente
     */
    public void addResearcher(Researcher researcher){
        if (researchers = null){
            new Researcher();
        }
        researcher.add(researcher);
    }
    
    /**
     implementar aqui a verificação para se o equipamento ja estiver inserido nao inserir novamente
     */
    public void addEquipment(Equipment equipment){
        if (equipment = null){
            new Equipment();
        }
        equipments.add(equipment);
    }
    
    
}
