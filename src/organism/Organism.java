
package organism;
import world.World;

public abstract class Organism {
    protected World s;
    private char id;
    private String name;
    private int power;
    private int initiative;
    private boolean ifAlive;
    private int age;
    private int x, y;
    
    public Organism() {
        ifAlive = true;
        age = 0;
        id = '.';
    }
    
    public char getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public int getPower(){
        return this.power;
    }
    
    public int getInitiative(){
        return this.initiative;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public boolean getIfAlive(){
        return this.ifAlive;
    }
    
    public void setPower (int value){
        this.power = value;
    }
    
    public void setInitiative (int value){
        this.initiative = value;
    }
    
    public void setName (String value){
        this.name = value;
    }
    
    public void setId (char value){
        this.id = value;
    }
    
    public void setIfAlive(boolean value){
        this.ifAlive = value;
    }
    
    public void setX(int newX){
        this.x = newX;
    }
    
    public void setY(int newY){
        this.y = newY;
    }
    
    public void setAge() {
        this.age = this.age + 1;
    }
    
    public void setAge2(int age) {
        this.age = age;
    }
    
    abstract public Organism collision(int first_x, int first_y, int rand_x, int rand_y, Organism organizm);
    
    abstract public Organism action(Organism organizm);

}






