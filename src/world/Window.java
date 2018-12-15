package world;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import organizm.roslina.Ciern;
import organizm.roslina.Mlecz;
import organizm.roslina.Trawa;
import organizm.zwierzeta.Lew;
import organizm.zwierzeta.Malpa;
import organizm.zwierzeta.Owca;
import organizm.zwierzeta.Slimak;
import organizm.zwierzeta.Wilk;

 
class Window extends JFrame implements ActionListener {
    private JButton buttons[][];
    private JButton makeTurn;
    private JTextArea texts;
    private World world;
    private JScrollPane scroll;
   
    GridBagConstraints gridbag = new GridBagConstraints();
   
    int x=0,y=0;
   
    public Window(World s) {
 
        super("World");
 
        this.world=s;
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setPreferredSize(new Dimension(1300, 900));   
       setLayout(new GridBagLayout());
       
        buttons=new JButton[20][20];
        makeTurn=new JButton("Make a turn");
        makeTurn.addActionListener(this);
        
        gridbag.gridx = 21;
        gridbag.gridy = 0;
        
       
        add(makeTurn,gridbag);
        
        
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                if(world.returnOrganism(world.listOfOrganisms,i,j)==null){
                    buttons[i][j] = new JButton(new ImageIcon("puste.jpg"));
                    
                    
                }
                else if(world.returnOrganism(world.listOfOrganisms,i,j).getId()=='W'){
                    buttons[i][j] = new JButton(new ImageIcon("wilk.jpg"));
                    
                }
                else if(world.returnOrganism(world.listOfOrganisms,i,j).getId()=='O'){
                    buttons[i][j] = new JButton(new ImageIcon("owca.jpg"));
                    
                }
                else if(world.returnOrganism(world.listOfOrganisms,i,j).getId()=='T'){
                    buttons[i][j] = new JButton(new ImageIcon("trawa.jpg"));
                    
                }
                else if(world.returnOrganism(world.listOfOrganisms,i,j).getId()=='m'){
                    buttons[i][j] = new JButton(new ImageIcon("malpa.jpg"));
                }
                else if(world.returnOrganism(world.listOfOrganisms,i,j).getId()=='S'){
                    buttons[i][j] = new JButton(new ImageIcon("slimak.jpg"));
                    
                }
                else if(world.returnOrganism(world.listOfOrganisms,i,j).getId()=='C'){
                    buttons[i][j] = new JButton(new ImageIcon("ciern.jpg"));
                    
                }
                else if(world.returnOrganism(world.listOfOrganisms,i,j).getId()=='L'){
                    buttons[i][j] = new JButton(new ImageIcon("lew.jpg"));
                    
                }
                else if(world.returnOrganism(world.listOfOrganisms,i,j).getId()=='M'){
                    buttons[i][j] = new JButton(new ImageIcon("mlecz.jpg"));
                    
                }
                buttons[i][j].setPreferredSize(new Dimension(30, 30));
                buttons[i][j].addActionListener(this);
                gridbag.gridx = x;
                gridbag.gridy = y;
                add(buttons[i][j], gridbag);
                
                x++;
            }
            x=0;
            y++;
        }
        
       
       
        texts = new JTextArea(world.text);
        scroll =new JScrollPane(texts);    
         gridbag.gridx = 21;
         gridbag.gridy = 1;
         gridbag.gridheight=17;
         gridbag.gridwidth=17;      
        scroll.setPreferredSize(new Dimension(300,500));
        add(scroll, gridbag);
       
        setVisible(true);
        pack();
        
}
   
    public void resfreshButtons() {
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                if(world.returnOrganism(world.listOfOrganisms,i,j)==null){
                    buttons[i][j].setIcon(new ImageIcon("puste.jpg"));
                    
                }
                else if(world.returnOrganism(world.listOfOrganisms,i,j).getId()=='W'){
                    buttons[i][j].setIcon(new ImageIcon("wilk.jpg"));
                    
                }
                else if(world.returnOrganism(world.listOfOrganisms,i,j).getId()=='O'){
                    buttons[i][j].setIcon(new ImageIcon("owca.jpg"));
                    
                }
                else if(world.returnOrganism(world.listOfOrganisms,i,j).getId()=='T'){
                    buttons[i][j].setIcon(new ImageIcon("trawa.jpg"));
                    
                }
                else if(world.returnOrganism(world.listOfOrganisms,i,j).getId()=='m'){
                    buttons[i][j].setIcon(new ImageIcon("malpa.jpg"));
                    
                }
                else if(world.returnOrganism(world.listOfOrganisms,i,j).getId()=='S'){
                    buttons[i][j].setIcon(new ImageIcon("Slimak.jpg"));
                    
                }
                else if(world.returnOrganism(world.listOfOrganisms,i,j).getId()=='C'){
                    buttons[i][j].setIcon(new ImageIcon("ciern.jpg"));
                    
                }
                else if(world.returnOrganism(world.listOfOrganisms,i,j).getId()=='L'){
                    buttons[i][j].setIcon(new ImageIcon("lew.jpg"));
                    
                }
                else if(world.returnOrganism(world.listOfOrganisms,i,j).getId()=='M'){
                    buttons[i][j].setIcon(new ImageIcon("mlecz.jpg"));
                    
                }
                
                x++;
            }
            x=0;
            y++;
        }
        
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == makeTurn){
            world.makeTurn();
            resfreshButtons();
            texts.setText(null);
            texts.append(world.text);
        }
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                if (source==buttons[i][j] && world.returnOrganism(world.listOfOrganisms,i,j)==null){
                    new Window2(world,i,j,this);
                    resfreshButtons();
                }
    }
        }
    }    
      
   public void loadFromFile(String path) throws IOException{
       
       FileReader fileReader = new FileReader(path);
       BufferedReader bufferedReader = new BufferedReader(fileReader);
 
        try {
            String name = bufferedReader.readLine();
            do {
                String p_x = bufferedReader.readLine();
                int P_X = Integer.valueOf(p_x);
                String p_y = bufferedReader.readLine();
                int P_Y = Integer.valueOf(p_y);
                String lata = bufferedReader.readLine();
                int Lata = Integer.valueOf(lata);
                world.loadWorld(name,P_X,P_Y,Lata);
                name = bufferedReader.readLine();
                } while (name != null);
        } finally {
            bufferedReader.close();
        }
   }
}

class Window2 extends JFrame implements ActionListener {
        private JButton wilk;
        private JButton owca;
        private JButton lew;
        private JButton slimak;
        private JButton malpa;
        private JButton trawa;
        private JButton mlecz;
        private JButton ciern;
        private int X,Y;
        private World world;
        private Window p;
        GridBagConstraints gridbag = new GridBagConstraints();
    public  Window2(World s,int x,int y,Window buttons)  {
       
      super("World");
      X=x;
      Y=y;
      world=s;
     p =buttons;

      
    
      setSize(300, 100);    
      setLayout(new GridBagLayout());
       
       
         
                     
                 wilk = new JButton(new ImageIcon("wilk.jpg"));                    
                 add(wilk);
                 wilk.addActionListener(this);
                 wilk.setPreferredSize(new Dimension(30, 30));
                 owca = new JButton(new ImageIcon("owca.jpg"));  
                 add(owca);
                 owca.addActionListener(this);
                 owca.setPreferredSize(new Dimension(30, 30));
                 malpa= new JButton(new ImageIcon("malpa.jpg"));                    
                 add(malpa);
                 malpa.addActionListener(this);
                 malpa.setPreferredSize(new Dimension(30, 30));
                 slimak = new JButton(new ImageIcon("slimak.jpg"));                    
                 add(slimak);
                 slimak.addActionListener(this);
                 slimak.setPreferredSize(new Dimension(30, 30));
                 lew = new JButton(new ImageIcon("lew.jpg"));                    
                 add(lew);
                 lew.addActionListener(this);
                 lew.setPreferredSize(new Dimension(30, 30));
                 trawa = new JButton(new ImageIcon("trawa.jpg"));                    
                 add(trawa);
                 trawa.addActionListener(this);
                 trawa.setPreferredSize(new Dimension(30, 30));
                 ciern = new JButton(new ImageIcon("ciern.jpg"));                    
                 add(ciern);
                 ciern.addActionListener(this);
                 ciern.setPreferredSize(new Dimension(30, 30));
                 mlecz = new JButton(new ImageIcon("mlecz.jpg"));                    
                 add(mlecz);
                 mlecz.addActionListener(this);
                 mlecz.setPreferredSize(new Dimension(30, 30));
       setVisible(true);
       
    }
 
   
     @Override
     public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == wilk){
            world.listOfOrganisms.add(new Wilk(world,X,Y));
            p.resfreshButtons();
        }
          else  if(source == owca){
            world.listOfOrganisms.add(new Owca(world,X,Y));
            p.resfreshButtons();
                  }
           else  if(source == malpa){
            world.listOfOrganisms.add(new Malpa(world,X,Y));
            p.resfreshButtons();
           }
           else  if(source == slimak){
            world.listOfOrganisms.add(new Slimak(world,X,Y));
            p.resfreshButtons();
           }
           else  if(source == lew){
            world.listOfOrganisms.add(new Lew(world,X,Y));
            p.resfreshButtons();
           }
          else  if(source == trawa){
            world.listOfOrganisms.add(new Trawa(world,X,Y));
            p.resfreshButtons();
           }
           else  if(source == ciern){
            world.listOfOrganisms.add(new Ciern(world,X,Y));
            p.resfreshButtons();
           }
           else  if(source == mlecz){
            world.listOfOrganisms.add(new Mlecz(world,X,Y));
             p.resfreshButtons();
             
           }
        }    
    }
class Statement extends JFrame  {
   
    private JTextArea text;  
  
    GridBagConstraints gridbag = new GridBagConstraints();
    String inscription="There aren't any saved organisms";
   
   
    public Statement() {
 
        super("World");
       
       
        setPreferredSize(new Dimension(400, 200));
        setLayout(new GridBagLayout());
        text = new JTextArea();     
       
        gridbag.gridx = 0;
        gridbag.gridy = 0;
        gridbag.gridheight=10;
        gridbag.gridwidth=10;
      
      text.setPreferredSize(new Dimension(300,50));
       add(text,gridbag);
       
       text.append(inscription);
     
        setVisible(true);
        pack();
        
    }
   
   
}

class VerException extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VerException()
    {
    }
};
