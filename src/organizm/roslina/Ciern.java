
package organizm.roslina;
import organism.Organism;
import world.World;

public class Ciern extends Roslina {
    
    public Ciern(World s, int x, int y) {
        this.s = s;
        setX(x);
        setY(y);
        setId('C');
        setName("Ciern");
        setPower(2);
        setInitiative(0);
    }
    
    @Override
    public Organism action(Organism Ciern) {
       Organism newOne = null;
        newOne = super.action(Ciern);
        return newOne;
    
    }
    
    @Override
    public Organism collision(int p_x, int p_y, int r_x, int r_y, Organism attacking) {
        Organism nowy = null;
        return nowy;
    }
};
