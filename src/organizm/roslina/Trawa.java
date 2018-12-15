package organizm.roslina;
import organism.Organism;
import world.World;

public class Trawa extends Roslina {
    
    public Trawa(World s, int x, int y) {
        this.s = s;
        setX(x);
        setY(y);
        setId('T');
        setName("Trawa");
        setPower(0);
        setInitiative(0);
    }
    
    @Override
    public Organism action(Organism Trawa) {
        Organism newOne = null;
        newOne = super.action(Trawa);
        return newOne;    
    }
    
    @Override
    public Organism collision(int p_x, int p_y, int r_x, int r_y, Organism Trawa) {
        Organism newOne = null;
        return newOne;
    }
}
