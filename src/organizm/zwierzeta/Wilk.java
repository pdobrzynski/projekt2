

package organizm.zwierzeta;

import organism.Organism;
import world.World;

public class Wilk extends Zwierze {
    
    public Wilk(World s, int x, int y) {
        this.s = s;
        setX(x);
        setY(y);
        setId('W');
        setName("Wilk");
        setPower(9);
        setInitiative(5);
    }
    
    @Override
    public Organism action(Organism Wilk) {
        Organism nowy = null;
        nowy = super.action(Wilk);
        return nowy;
    }
    
    @Override
    public Organism collision(int p_x, int p_y, int r_x, int r_y, Organism Wilk) {
        Organism nowy = null;
        nowy = super.collision(p_x, p_y, r_x, r_y, Wilk);
        return nowy;
    }
};
