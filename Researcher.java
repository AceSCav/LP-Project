/**
 * Write a description of class Investigador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
    public class Researcher
    {
        public int id;
        public String specialty;
        public String name;
        
        public Researcher(String specialty, String name){
            this.specialty = specialty;
            this.nome = nome;
        }
        
        public int getId(){
            return id;
        }
        
        public void setId(int id){
            this.id = id;
        }
           
        public String getSpecialty(){
            return specialty;
        }
        
        public void setSpecialty(String specialty){
            this.specialty = specialty;
        }
        
        public String getName(){
            return name;
        }
        
        public void setName(String name){
            this.name = name;
        }
    }
}
