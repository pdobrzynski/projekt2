

package organizm.zwierzeta;

import organism.Organism;
import world.World;

public class Malpa extends Zwierze {
    
    public Malpa(World s, int x, int y) {
        this.s = s;
        setX(x);
        setY(y);
        setId('m');
        setName("Malpa");
        setPower(5);
        setInitiative(4);
    }
    
    @Override
    public Organism action(Organism Malpa) {
        Organism nowy = null;
        nowy = super.action(Malpa);
        return nowy;
    }
    
    @Override
    public Organism collision(int p_x, int p_y, int r_x, int r_y, Organism Malpa) {
        Organism nowy = null;
        nowy = super.collision(p_x, p_y, r_x, r_y, Malpa);
        return nowy;
    }
};

