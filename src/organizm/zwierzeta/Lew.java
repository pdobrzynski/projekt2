package organizm.zwierzeta;

import organism.Organism;
import world.World;

public class Lew extends Zwierze {
    
    public Lew(World s, int x, int y) {
        this.s = s;
        setX(x);
        setY(y);
        setId('L');
        setName("Lew");
        setPower(11);
        setInitiative(7);
    }
    
    @Override
    public Organism action(Organism Lew) {
        Organism newOne = null;
        newOne = super.action(Lew);
        return newOne;
    }
    
    @Override
    public Organism collision(int p_x, int p_y, int r_x, int r_y, Organism Lew) {
        Organism newOne = null;
        newOne = super.collision(p_x, p_y, r_x, r_y, Lew);
        return newOne;
    }
};
