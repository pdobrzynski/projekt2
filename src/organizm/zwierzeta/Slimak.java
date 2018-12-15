package organizm.zwierzeta;

import organism.Organism;
import world.World;

public class Slimak extends Zwierze {
    
    public Slimak(World s, int x, int y) {
        this.s = s;
        setX(x);
        setY(y);
        setId('S');
        setName("Slimak");
        setPower(1);
        setInitiative(1);
    }
    
    @Override
    public Organism action(Organism Slimak) {
         Organism nowy = null;
        if(Slimak.getAge()%10==0){
            nowy = super.action(Slimak);
        }
        else{
            Slimak.setAge();
        }
        return nowy;
    }
    
    @Override
    public Organism collision(int p_x, int p_y, int r_x, int r_y, Organism Slimak) {
        Organism nowy = null;
        nowy = super.collision(p_x, p_y, r_x, r_y, Slimak);
        return nowy;
    }
};
