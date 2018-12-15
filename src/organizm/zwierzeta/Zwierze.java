
package organizm.zwierzeta;
import organism.Organism;

public abstract class Zwierze extends Organism {
    public Zwierze(){

    }
    
    @Override
    public Organism collision(int p_x, int p_y, int r_x, int r_y, Organism Zwierzatko) {
        Organism newOne = null;
        Organism attacked = s.returnOrganism(s.listOfOrganisms, r_x, r_y);
        if (attacked.getIfAlive() == true) {
            if (attacked.getId() == 'L' && Zwierzatko.getPower()<5){
                
            }
            else if ((attacked.getId()=='S' && (Zwierzatko.getPower()<2)) || ((Zwierzatko.getPower()<4 && (attacked.getAge()%5==0 || attacked.getAge()%5==1 ||attacked.getAge()%5==2 )))) {
                int i=s.random.nextInt(20);
                int j=s.random.nextInt(20);
                
                while (s.returnOrganism(s.listOfOrganisms,i,j)!=null)
                {
                    i=s.random.nextInt(20);
                    j=s.random.nextInt(20);
                }
                Zwierzatko.setX(i);
                Zwierzatko.setY(j);       
            }
            else if (attacked.getId() != Zwierzatko.getId()) {
                if (Zwierzatko.getPower() >= attacked.getPower()) {
                   
                    s.amount=s.amount+1;
                    s.text=(s.text+Zwierzatko.getName() +" killed " +attacked.getName() +" na y: "+attacked.getX()+" x: "+attacked.getY()+"\n" );
                    Zwierzatko.setX(r_x);
                    Zwierzatko.setY(r_y);
                    attacked.setX(20);
                    attacked.setY(20);
                    attacked.setIfAlive(false);
                }
                else if (Zwierzatko.getPower() < attacked.getPower()) {
                   
                    s.amount=s.amount+1;
                    Zwierzatko.setX(20);
                    Zwierzatko.setY(20);
                    Zwierzatko.setIfAlive(false);
                    s.text=(s.text+attacked.getName() +" killed " +Zwierzatko.getName() +" y: "+attacked.getX()+" x: "+attacked.getY()+"\n" );
                }
            }
            else {
                int e=s.random.nextInt(3)+r_x-1;
                int f=s.random.nextInt(3)+r_y-1;
       
                if (e>=0 && e<=19 && f>=0 && f<=19) {
                    
                    while ((e<0 && e>19) && (f<0 && f>19) && s.returnOrganism(s.listOfOrganisms,e,f)!=null){//
                            e=s.random.nextInt(3)+r_x-1;
                            f=s.random.nextInt(3)+r_y-1;
                    }
                    if (s.returnOrganism(s.listOfOrganisms,e,f)==null) {

                        if("Owca".equals(Zwierzatko.getName())) {
                            newOne = new Owca(s,e,f);
                        }
                        else if ("Wilk".equals(Zwierzatko.getName())) {
                            newOne = new Wilk(s,e,f);
                        }
                        else if ("Malpa".equals(Zwierzatko.getName())) {
                            newOne = new Malpa(s,e,f);
                        }
                        else if ("Lew".equals(Zwierzatko.getName())) {
                            newOne = new Lew(s,e,f);
                        }
                        else if ("Slimak".equals(Zwierzatko.getName())) {
                            newOne = new Slimak(s,e,f);
                        }
                       
                     s.text=("New animal appeared: " +Zwierzatko.getName() +" y: "+newOne.getX()+" x: "+newOne.getY()+"\n" );

                    }
                }
            }
        }
        
        return newOne;
    }
    
   @Override
    public Organism action(Organism Zwierzatko) {
        Organism newOne = null;
        int a = Zwierzatko.getX();
        int b = Zwierzatko.getY();
        int c = Zwierzatko.getX()+1;
        int d = Zwierzatko.getY()+1;
        int nowy;
       
        nowy=s.random.nextInt(8);
       
        if (nowy==0) {
            c=(Zwierzatko.getX()+1);
            d=(Zwierzatko.getY()+1);
        }
        else if (nowy==1) {
            c=(Zwierzatko.getX());
            d=(Zwierzatko.getY()+1);
        }
        else if (nowy==2) {
            c=(Zwierzatko.getX()+1);
            d=(Zwierzatko.getY());
        }
        else if (nowy==3) {
            c=(Zwierzatko.getX()-1);
            d=(Zwierzatko.getY()-1);
        }
        else if (nowy==4) {
            c=(Zwierzatko.getX());
            d=(Zwierzatko.getY()-1);
        }
        else if (nowy==5) {
            c=(Zwierzatko.getX()-1);
            d=(Zwierzatko.getY());
        }
        else if (nowy==6) {
            c=(Zwierzatko.getX()-1);
            d=(Zwierzatko.getY()+1);
        }
        else if (nowy==7) {
            c=(Zwierzatko.getX()+1);
            d=(Zwierzatko.getY()-1);
        }
            if (c>=0 && c<=19 && d>=0 && d<=19 ) {
                if (s.returnOrganism(s.listOfOrganisms,c,d)==null) {
                    Zwierzatko.setX(c);
                    Zwierzatko.setY(d);
                    Zwierzatko.setAge();
                }
                else {
                   
                    newOne = Zwierzatko.collision(a,b,c,d,Zwierzatko);
                    Zwierzatko.setAge();
               }
            }
            return newOne;
    }
     
};