package bio_medi;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;

class JpgPanel extends JPanel{
	private Image img;
	public JpgPanel(Image img){
		this.img = img;
		setSize(1000,550);
	}
	
	public void setImage(Image img ) {
		this.img = img;
		repaint();
    }
    
    public void paint(Graphics g) {
    	int xpos = (int) (this.getWidth() / 2 - img.getWidth(null)/2);
		int ypos = (int) (this.getHeight() / 2 - img.getHeight(null)/2);
        g.drawImage(img, xpos, ypos , this);
        setOpaque(false);
        super.paint(g);
    }      
    
    public void update(Graphics g)
    {
    	int xpos = (int) (getWidth() / 4 );
		int ypos = (int) (getHeight() / 4 );
        g.drawImage(img, xpos, ypos , this);
    }
}

class JpgFrame extends JFrame{
    public JpgFrame(String string) {
    	//JFrame f = new JFrame(string);
    	this.setTitle(string);
    	addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
    	setSize(1000, 650);
    	MenuBarSection m = new MenuBarSection();
		m.MakeMenuBar(this);    	
    	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int) (screen.getWidth() / 2 - getWidth() / 2);
		int ypos = (int) (screen.getHeight() / 2 - getHeight() / 2);
		setLocation(xpos, ypos-30);
		setVisible(true);				
	}
}

public class  bio_medi {

    public JpgFrame jpgFrame;
    static JpgPanel staticp2;
    static Image staticjpgImage;
    static Image originalImage; 
    
    public static void main(String[] args) throws IOException
    {
        bio_medi bio_medi = new bio_medi();        
        bio_medi.jpgFrame = new JpgFrame("Bio_Medi_Project");
       
        File jpgImageFile = new File("initialImage.jpg");
        Image InitialImage = ImageIO.read(jpgImageFile);
        JpgPanel p2 = new JpgPanel(InitialImage);
        staticjpgImage = InitialImage;
        originalImage = InitialImage;
        InitialImage.flush();
        
        staticp2 = p2;
        bio_medi.jpgFrame.add(staticp2);
        bio_medi.jpgFrame.setVisible(true);        
        bio_medi.jpgFrame.repaint();
    }    
}
