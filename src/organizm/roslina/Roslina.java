package organizm.roslina;
import organism.Organism;
 
public abstract class Roslina extends Organism{
    public Roslina() {
   
    }
   
    @Override
    public Organism collision(int p_x, int p_y, int r_x, int r_y, Organism Roslinka) {
        return null;
   
    }
   
    @Override
    public Organism action(Organism Roslinka) {
        Organism newOne = null;
        int c = Roslinka.getX()+1;
        int d = Roslinka.getY()+1;
        int rand,number;
       
        rand=s.random.nextInt(8);
        number=s.random.nextInt(1000);
        if (rand==0) {
            c=(Roslinka.getX()+1);
            d=(Roslinka.getY()+1);
        }
        else if (rand==1) {
            c=(Roslinka.getX());
            d=(Roslinka.getY()+1);
        }
        else if (rand==2) {
            c=(Roslinka.getX()+1);
            d=(Roslinka.getY());
        }
        else if (rand==3) {
            c=(Roslinka.getX()-1);
            d=(Roslinka.getY()-1);
        }
        else if (rand==4) {
            c=(Roslinka.getX());
            d=(Roslinka.getY()-1);
        }
        else if (rand==5) {
            c=(Roslinka.getX()-1);
            d=(Roslinka.getY());
        }
        else if (rand==6) {
            c=(Roslinka.getX()-1);
            d=(Roslinka.getY()+1);
        }
        else if (rand==7) {
            c=(Roslinka.getX()+1);
            d=(Roslinka.getY()-1);
        }
       
        if (c>=0 && c<=19 && d>=0 && d<=19 ) {
            if(Roslinka.getId() != 'C') {
                if (s.returnOrganism(s.listOfOrganisms,c,d)==null && (number)%4 != 3 ) {
                   
                    if ("Trawa".equals(Roslinka.getName())) {
                        newOne = new Trawa(s,c,d);
                    }
                    else if (Roslinka.getName() == "Mlecz") {
                        newOne = new Mlecz(s,c,d);
                    }
                    s.text=(s.text+Roslinka.getName() +" spread on x: "+newOne.getY()+" y: "+newOne.getX()+"\n" );
                    Roslinka.setAge();
                }
            }
            else {
                if (s.returnOrganism(s.listOfOrganisms,c,d)==null) {
                 
                    newOne = new Ciern(s,c,d);
                    s.text=(s.text+Roslinka.getName() +" spread on x: "+newOne.getY()+" y: "+newOne.getX()+"\n" );
                    Roslinka.setAge();
                }
            }
        }
       
        return newOne;
    }
};