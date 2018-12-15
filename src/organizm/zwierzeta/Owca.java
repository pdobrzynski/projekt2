
package organizm.zwierzeta;

import organism.Organism;
import world.World;

public class Owca extends Zwierze {
    
    public Owca(World s, int x, int y) {
        this.s = s;
        setX(x);
        setY(y);
        setId('O');
        setName("Owca");
        setPower(4);
        setInitiative(4);
    }
    
    @Override
    public Organism action(Organism Owca) {
        Organism nowy = null;
        nowy = super.action(Owca);
        return nowy;
    }
    
    @Override
    public Organism collision(int p_x, int p_y, int r_x, int r_y, Organism Owca) {
        Organism nowy = null;
        nowy = super.collision(p_x, p_y, r_x, r_y, Owca);
        return nowy;
    }
};
