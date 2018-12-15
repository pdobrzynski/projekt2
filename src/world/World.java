package world;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import organism.Organism;
import java.util.Collections;
import java.util.ListIterator;
import java.awt.EventQueue;
import java.util.Comparator;
import organizm.roslina.Ciern;
import organizm.roslina.Mlecz;
import organizm.roslina.Trawa;
import organizm.zwierzeta.Malpa;
import organizm.zwierzeta.Lew;
import organizm.zwierzeta.Owca;
import organizm.zwierzeta.Wilk;
import organizm.zwierzeta.Slimak;


public class World {
    public int amount=0;
    public String text=("");
    public ArrayList<Organism> listOfOrganisms;  
    public Random random;
    public World world;
	private static Scanner keyboard;
  
    private World() {
        random = new Random();
        random.setSeed(System.currentTimeMillis());
        listOfOrganisms = new ArrayList<>();
        world=this;
        
    }

    private void firstRun() {
        int x,y;
        Organism organism = null;
        
        for(int k=0;k<5;k++){
            x=random.nextInt(20);
            y=random.nextInt(20);
                
                while (returnOrganism(listOfOrganisms,x,y)!=null)
                {
                    x=random.nextInt(20);
                    y=random.nextInt(20);
                }
                organism = new Wilk(this,x,y);
                 listOfOrganisms.add(organism);
        }           
           
            
          
          for(int k=0;k<5;k++){
            x=random.nextInt(20);
            y=random.nextInt(20);
                
                while (returnOrganism(listOfOrganisms,x,y)!=null)
                {
                    x=random.nextInt(20);
                    y=random.nextInt(20);
                }
                organism = new Owca(this,x,y);
                 listOfOrganisms.add(organism);
            }
            for(int k=0;k<5;k++){
            x=random.nextInt(20);
            y=random.nextInt(20);
                
                while (returnOrganism(listOfOrganisms,x,y)!=null)
                {
                    x=random.nextInt(20);
                    y=random.nextInt(20);
                }
                organism = new Malpa(this,x,y);
                 listOfOrganisms.add(organism);
            }
           for(int k=0;k<5;k++){
            x=random.nextInt(20);
            y=random.nextInt(20);
                
                while (returnOrganism(listOfOrganisms,x,y)!=null)
                {
                    x=random.nextInt(20);
                    y=random.nextInt(20);
                }
                organism = new Lew(this,x,y);
                 listOfOrganisms.add(organism);
            }
           for(int k=0;k<5;k++){
            x=random.nextInt(20);
            y=random.nextInt(20);
                
                while (returnOrganism(listOfOrganisms,x,y)!=null)
                {
                    x=random.nextInt(20);
                    y=random.nextInt(20);
                }
                organism = new Slimak(this,x,y);
                 listOfOrganisms.add(organism);
            }
            for(int k=0;k<3;k++){
            x=random.nextInt(20);
            y=random.nextInt(20);
                
                while (returnOrganism(listOfOrganisms,x,y)!=null)
                {
                    x=random.nextInt(20);
                    y=random.nextInt(20);
                }
                organism = new Trawa(this,x,y);
                 listOfOrganisms.add(organism);
            }
           for(int k=0;k<3;k++){
            x=random.nextInt(20);
            y=random.nextInt(20);
                
                while (returnOrganism(listOfOrganisms,x,y)!=null)
                {
                    x=random.nextInt(20);
                    y=random.nextInt(20);
                }
                organism = new Ciern(this,x,y);
                 listOfOrganisms.add(organism);
            }
            for(int k=0;k<3;k++){
            x=random.nextInt(20);
            y=random.nextInt(20);
                
                while (returnOrganism(listOfOrganisms,x,y)!=null)
                {
                    x=random.nextInt(20);
                    y=random.nextInt(20);
                }
                 organism = new Mlecz(this,x,y);
                  listOfOrganisms.add(organism);
            }
           
            
        
    }
    
   public void makeTurn() {
       
        Organism newOne = null;
        Collections.sort(listOfOrganisms, new Compare());
        ListIterator<Organism> iterator = listOfOrganisms.listIterator();//
      
        text=("");
 
        while(iterator.hasNext()) {
            Organism organism = iterator.next(); //
            if (organism.getIfAlive() == true) {
                newOne = organism.action(organism);
                if (newOne != null) {
                    iterator.add(newOne);
                }
            }
            else {
                iterator.remove(); //
            }
        }
    }

    public Organism returnOrganism(ArrayList<Organism> listOfOrganism, int px, int py) {
        ListIterator<Organism> it = listOfOrganism.listIterator();
        int a = 0;

        Organism obj = null;
        while(it.hasNext()) {
            obj = it.next();
            if (obj.getX() == px && obj.getY() == py) {
                a = 1;
                break;
            }
        }
        if (a == 0) obj = null;

        return obj;
    }
  
    public void loadWorld(String animal, int i, int j, int age) {
        Organism loaded = null;
        if ("Wilk".equals(animal)) {
            loaded = new Wilk(this,i,j);
        }
        else if("Owca".equals(animal)) {
            loaded = new Owca(this,i,j);
        }
        else if("Trawa".equals(animal)) {
            loaded = new Trawa(this,i,j);
        }
        else if("Malpa".equals(animal)) {
            loaded = new Malpa(this,i,j);
        }
        else if("Mlecz".equals(animal)) {
            loaded = new Mlecz(this,i,j);
        }
        else if("Lew".equals(animal)) {
            loaded = new Lew(this,i,j);
        }
        else if("Slimak".equals(animal)) {
            loaded = new Slimak(this,i,j);
        }
        else if("Ciern".equals(animal)) {
            loaded = new Ciern(this,i,j);
        }
        loaded.setAge2(age);
        listOfOrganisms.add(loaded);
       
    }
    
    private void createWorld() {
     
         EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               new Window (world);
            }
        });
    }
    
    
    public static void main(String[] args) {
        
        boolean x = true;
        String variable;
        World world = new World();
        world.firstRun();
        world.createWorld();
        
        while(x) {
            keyboard = new Scanner(System.in);
            variable = keyboard.nextLine();
            if ("s".equals(variable)) {
                
                world.makeTurn();
                world.createWorld();
                
            }
        }
    }
};
 class Compare implements Comparator<Organism> {
   
    @Override
    public int compare(Organism first, Organism second) {
        if(first.getInitiative() > second.getInitiative()) {
            return -1;
        }
        else if (first.getInitiative() < second.getInitiative()) {
            return 1;
        }
        else {
            if(first.getAge() > second.getAge()) {
                return -1;
            }
            else if (first.getAge() < second.getAge()) {
                return 1;
            }
            else return 0;
        }
    }
}
