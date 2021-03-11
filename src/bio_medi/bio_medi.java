package bio_medi;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;

/*
* Copyright 2018 Authors. All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
* ==========================================================================
*
* This file is part of bio-medical-image convertor program.
*
* Made in Soongsil University, Korea.
*
* @Authors : Heemoon Yoon (jcjc7890@gmail.com)
*
* Date : Initial Development in 2018
*
* For the latest version, please check the github 
* (https://github.com/boguss1225/ImageFiltersGUI)
* 
* ==========================================================================
*/

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
