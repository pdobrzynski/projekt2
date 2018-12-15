package organizm.roslina;
import organism.Organism;
import world.World;

public class Mlecz extends Roslina {
    
    public Mlecz(World s, int x, int y) {
        this.s = s;
        setX(x);
        setY(y);
        setId('M');
        setName("Mlecz");
        setPower(0);
        setInitiative(0);
    }
    
    @Override
    public Organism action(Organism Mlecz) {
        Organism newOne = null;
        newOne = super.action(Mlecz);
        if(newOne == null) {
            newOne = super.action(Mlecz);
            if (newOne == null) {
                newOne = super.action(Mlecz);
            }
        }
        return newOne;
    
    }
    
    @Override
    public Organism collision(int p_x, int p_y, int r_x, int r_y, Organism Mlecz) {
        Organism newOne = null;
        return newOne;
    }
};
