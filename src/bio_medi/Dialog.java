package bio_medi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class HelpDialog{
	public  HelpDialog(JFrame f){
		 	Dialog HelpDia = new Dialog(f,"도움말",true);
		 	
		 	HelpDia.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					HelpDia.dispose();
				}
			});
		 	
		 	HelpDia.setSize(440, 200);
		 	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			int xpos = (int) (screen.getWidth() / 2 - HelpDia.getWidth() / 2);
			int ypos = (int) (screen.getHeight() / 2 - HelpDia.getHeight() / 2);
		 	HelpDia.setLocation(xpos, ypos);
		 	HelpDia.setLayout(new FlowLayout());
		 	
		 	JLabel Hl1 = new JLabel("<<도움말>>");
			JLabel Hl2 = new JLabel("이 프로그램은 18년도 바이오비전의 프로젝트입니다");
			JLabel Hl3 = new JLabel("도움말~~~");
			JLabel Hl4 = new JLabel("화면이 안나올시 프레임을 한번 조정해주세요");
			
			JButton Hb1 = new JButton("확인");
			
			class Hb1EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					HelpDia.dispose();
				}}
			Hb1.addActionListener(new Hb1EventHandler());
			
			Panel HelpP = new Panel();
			HelpP.setLayout(new GridLayout(5,1));
			HelpP.add(Hl1);
			HelpP.add(Hl2);
			HelpP.add(Hl3);
			HelpP.add(Hl4);
			HelpP.add(Hb1);
			HelpDia.add(HelpP, BorderLayout.CENTER);
			HelpDia.setVisible(true);
		 
	 }
	
}

class AuthorDialog{
	public AuthorDialog(JFrame f){
		 	Dialog AuthorDia = new Dialog(f,"제작자 정보",true);
		 	
		 	AuthorDia.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					AuthorDia.dispose();
				}
			});
		 	
		 	AuthorDia.setSize(440, 200);
		 	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			int xpos = (int) (screen.getWidth() / 2 - AuthorDia.getWidth() / 2);
			int ypos = (int) (screen.getHeight() / 2 - AuthorDia.getHeight() / 2);
		 	AuthorDia.setLocation(xpos,ypos);
		 	AuthorDia.setLayout(new FlowLayout());
		 	
		 	JLabel l1 = new JLabel("<<저자정보>>");
			JLabel l2 = new JLabel("Author : 숭실대 20110452 윤희문");
			JLabel l3 = new JLabel("ihaq1@naver.com");
			JLabel l4 = new JLabel("2018-4-05 제작");
			JButton b1 = new JButton("확인");
			
			
			class b1EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					AuthorDia.dispose();
				}}
			b1.addActionListener(new b1EventHandler());
			
			Panel AuthorP = new Panel();
			AuthorP.setLayout(new GridLayout(5,1));
			AuthorP.add(l1);
			AuthorP.add(l2);
			AuthorP.add(l3);
			AuthorP.add(l4);
			AuthorP.add(b1);
			AuthorDia.add(AuthorP, BorderLayout.CENTER);
			AuthorDia.setVisible(true);
		 
	 }
	
}

class ResetDialog{
	public ResetDialog(JFrame f){
		 	Dialog Dia = new Dialog(f,"Reset Image",true);
		 	Dia.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					Dia.dispose();
				}
			});
		 	
		 	Dia.setSize(240, 130);
		 	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			int xpos = (int) (screen.getWidth() / 2 - Dia.getWidth() / 2);
			int ypos = (int) (screen.getHeight() / 2 - Dia.getHeight() / 2);
			Dia.setLocation(xpos,ypos);
			Dia.setLayout(new FlowLayout());
		 	
		 	JLabel l1 = new JLabel("원본 이미지를 복원하겠습니까?");
		 	JButton b1 = new JButton("확인");
			JButton b2 = new JButton("취소");
			
			class b1EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					bio_medi.staticjpgImage = bio_medi.originalImage;
					bio_medi.staticp2.setImage(bio_medi.originalImage);
					Dia.dispose();
				}}
			b1.addActionListener(new b1EventHandler());
			
			class b2EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					Dia.dispose();
				}}
			b2.addActionListener(new b2EventHandler());
			
			Panel restartP = new Panel();
			Panel restartP3 = new Panel();
			restartP.setLayout(new GridLayout(1,1));
			restartP.add(l1);
		
			restartP3.setLayout(new GridLayout(1,2));
			restartP3.add(b1);
			restartP3.add(b2);
			Dia.add(restartP, BorderLayout.NORTH);
			Dia.add(restartP3, BorderLayout.CENTER);
			Dia.setVisible(true);
	}
}
class BlacknWhiteDialog{
	public BlacknWhiteDialog(JFrame f){
		 	Dialog Dia = new Dialog(f,"BlacknWhiten Image",true);
		 	Dia.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					Dia.dispose();
				}
			});
		 	
		 	Dia.setSize(240, 130);
		 	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			int xpos = (int) (screen.getWidth() / 2 - Dia.getWidth() / 2);
			int ypos = (int) (screen.getHeight() / 2 - Dia.getHeight() / 2);
			Dia.setLocation(xpos,ypos);
			Dia.setLayout(new FlowLayout());
		 	
		 	JLabel l1 = new JLabel("흑백이미지로 수정하겠습니까?");
		 	JButton b1 = new JButton("확인");
			JButton b2 = new JButton("취소");
			
			class b1EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					ImageOperations ImageOp = new ImageOperations();
					bio_medi.staticjpgImage=ImageOp.BlacknWhite(bio_medi.staticjpgImage);
					bio_medi.staticp2.setImage(bio_medi.staticjpgImage);
					Dia.dispose();
				}}
			b1.addActionListener(new b1EventHandler());
			
			class b2EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					Dia.dispose();
				}}
			b2.addActionListener(new b2EventHandler());
			
			Panel restartP = new Panel();
			Panel restartP3 = new Panel();
			restartP.setLayout(new GridLayout(1,1));
			restartP.add(l1);
		
			restartP3.setLayout(new GridLayout(1,2));
			restartP3.add(b1);
			restartP3.add(b2);
			Dia.add(restartP, BorderLayout.NORTH);
			Dia.add(restartP3, BorderLayout.CENTER);
			Dia.setVisible(true);
	}
}
class inverseDialog{
	public inverseDialog(JFrame f){
		 	Dialog Dia = new Dialog(f,"Inverse Image",true);
		 	Dia.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					Dia.dispose();
				}
			});
		 	
		 	Dia.setSize(240, 130);
		 	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			int xpos = (int) (screen.getWidth() / 2 - Dia.getWidth() / 2);
			int ypos = (int) (screen.getHeight() / 2 - Dia.getHeight() / 2);
			Dia.setLocation(xpos,ypos);
			Dia.setLayout(new FlowLayout());
		 	
		 	JLabel l1 = new JLabel("반전이미지로 수정하겠습니까?");
		 	JButton b1 = new JButton("확인");
			JButton b2 = new JButton("취소");
			
			class b1EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					ImageOperations ImageOp = new ImageOperations();
					bio_medi.staticjpgImage = ImageOp.inverse(bio_medi.staticjpgImage);
					bio_medi.staticp2.setImage(bio_medi.staticjpgImage);
					Dia.dispose();
				}}
			b1.addActionListener(new b1EventHandler());
			
			class b2EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					Dia.dispose();
				}}
			b2.addActionListener(new b2EventHandler());
			
			Panel restartP = new Panel();
			Panel restartP3 = new Panel();
			restartP.setLayout(new GridLayout(1,1));
			restartP.add(l1);
		
			restartP3.setLayout(new GridLayout(1,2));
			restartP3.add(b1);
			restartP3.add(b2);
			Dia.add(restartP, BorderLayout.NORTH);
			Dia.add(restartP3, BorderLayout.CENTER);
			Dia.setVisible(true);
	}
}

class ThresholdDialog{
	public ThresholdDialog(JFrame f){
			//String ThresholdValue = "0";
		 	Dialog Dia = new Dialog(f,"Threshold",true);
		 	
		 	Dia.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					Dia.dispose();
				}
			});
		 	
		 	Dia.setSize(240, 150);
		 	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			int xpos = (int) (screen.getWidth() / 2 - Dia.getWidth() / 2);
			int ypos = (int) (screen.getHeight() / 2 - Dia.getHeight() / 2);
			Dia.setLocation(xpos,ypos);
			Dia.setLayout(new FlowLayout());
		 	
		 	JLabel l1 = new JLabel("Threshold Value입력(0~255)");
			JTextField t1 = new JTextField("0");
		 	JButton b1 = new JButton("확인");
			JButton b2 = new JButton("취소");
			
			class b1EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					String ThresholdValue = t1.getText();
				    int value = Integer.parseInt(ThresholdValue);
				    if(value<=255&&value>=0){
				    	ImageOperations ImageOp = new ImageOperations();
				    	bio_medi.staticjpgImage = ImageOp.Threshold(bio_medi.staticjpgImage, value);
				    	bio_medi.staticp2.setImage(bio_medi.staticjpgImage);
				    	Dia.dispose();
				    }else{
				    	JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
				     }
				}}
			b1.addActionListener(new b1EventHandler());
			
			class b2EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					Dia.dispose();
				}}
			b2.addActionListener(new b2EventHandler());
			
			Panel restartP = new Panel();
			Panel restartP3 = new Panel();
			restartP.setLayout(new GridLayout(2,1));
			restartP.add(l1);
			restartP.add(t1);
			restartP3.setLayout(new GridLayout(1,2));
			restartP3.add(b1);
			restartP3.add(b2);
			Dia.add(restartP, BorderLayout.NORTH);
			Dia.add(restartP3, BorderLayout.CENTER);
			Dia.setVisible(true);
	}
}

class GaussianDialog{
	public GaussianDialog(JFrame f){
			//String ThresholdValue = "0";
		 	Dialog Dia = new Dialog(f,"Gaussian",true);
		 	
		 	Dia.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					Dia.dispose();
				}
			});
		 	
		 	Dia.setSize(240, 150);
		 	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			int xpos = (int) (screen.getWidth() / 2 - Dia.getWidth() / 2);
			int ypos = (int) (screen.getHeight() / 2 - Dia.getHeight() / 2);
			Dia.setLocation(xpos,ypos);
			Dia.setLayout(new FlowLayout());
		 	
		 	JLabel l1 = new JLabel("Gaussian radius Value입력(0~50)");
			JTextField t1 = new JTextField("3");
			
		 	JButton b1 = new JButton("확인");
			JButton b2 = new JButton("취소");
			
			class b1EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					String ThresholdValue = t1.getText();
				    int value = Integer.parseInt(ThresholdValue);
				    if(value<=50&&value>=0){
				    	ImageOperations ImageOp1 = new ImageOperations();
						bio_medi.staticjpgImage = ImageOp1.inverse(bio_medi.staticjpgImage);
						bio_medi.staticjpgImage = ImageOp1.inverse(bio_medi.staticjpgImage);
						
				    	GaussianFilter ImageOp = new GaussianFilter(value);
				    	bio_medi.staticjpgImage = ImageOp.filter(bio_medi.staticjpgImage,bio_medi.staticjpgImage);
						bio_medi.staticp2.setImage(bio_medi.staticjpgImage);
						Dia.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
				    }
				}}
			b1.addActionListener(new b1EventHandler());
			
			class b2EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					Dia.dispose();
				}}
			b2.addActionListener(new b2EventHandler());
			
			Panel restartP = new Panel();
			Panel restartP3 = new Panel();
			restartP.setLayout(new GridLayout(2,1));
			restartP.add(l1);
			restartP.add(t1);
			restartP3.setLayout(new GridLayout(1,2));
			restartP3.add(b1);
			restartP3.add(b2);
			Dia.add(restartP, BorderLayout.NORTH);
			Dia.add(restartP3, BorderLayout.CENTER);
			Dia.setVisible(true);
	}
}

class BoxBlurDialog{
	public BoxBlurDialog(JFrame f){
			//String ThresholdValue = "0";
		 	Dialog Dia = new Dialog(f,"BoxBlur",true);
		 	
		 	Dia.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					Dia.dispose();
				}
			});
		 	
		 	Dia.setSize(240, 150);
		 	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			int xpos = (int) (screen.getWidth() / 2 - Dia.getWidth() / 2);
			int ypos = (int) (screen.getHeight() / 2 - Dia.getHeight() / 2);
			Dia.setLocation(xpos,ypos);
			Dia.setLayout(new FlowLayout());
		 	
		 	JLabel l1 = new JLabel("BoxBlur radius Value입력(0~50)");
			JTextField t1 = new JTextField("3");
			
		 	JButton b1 = new JButton("확인");
			JButton b2 = new JButton("취소");
			
			class b1EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					String ThresholdValue = t1.getText();
				    int value = Integer.parseInt(ThresholdValue);
				    if(value<=50&&value>=0){
				    	ImageOperations ImageOp1 = new ImageOperations();
						bio_medi.staticjpgImage = ImageOp1.inverse(bio_medi.staticjpgImage);
						bio_medi.staticjpgImage = ImageOp1.inverse(bio_medi.staticjpgImage);
						
				    	Image tempImage = bio_medi.staticjpgImage;
				    	BoxBlurFilter ImageOp = new BoxBlurFilter();
				    	ImageOp.setRadius(value);
						bio_medi.staticjpgImage = (Image)(ImageOp.filter((BufferedImage)bio_medi.staticjpgImage, (BufferedImage)tempImage));
						bio_medi.staticp2.setImage(bio_medi.staticjpgImage);
						Dia.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
				    }
				}}
			b1.addActionListener(new b1EventHandler());
			
			class b2EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					Dia.dispose();
				}}
			b2.addActionListener(new b2EventHandler());
			
			Panel restartP = new Panel();
			Panel restartP3 = new Panel();
			restartP.setLayout(new GridLayout(2,1));
			restartP.add(l1);
			restartP.add(t1);
			restartP3.setLayout(new GridLayout(1,2));
			restartP3.add(b1);
			restartP3.add(b2);
			Dia.add(restartP, BorderLayout.NORTH);
			Dia.add(restartP3, BorderLayout.CENTER);
			Dia.setVisible(true);
	}
}

class UnsharpDialog{
	public UnsharpDialog(JFrame f){
			//String ThresholdValue = "0";
		 	Dialog Dia = new Dialog(f,"Unsharp Filter",true);
		 	
		 	Dia.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					Dia.dispose();
				}
			});
		 	
		 	Dia.setSize(240, 150);
		 	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			int xpos = (int) (screen.getWidth() / 2 - Dia.getWidth() / 2);
			int ypos = (int) (screen.getHeight() / 2 - Dia.getHeight() / 2);
			Dia.setLocation(xpos,ypos);
			Dia.setLayout(new FlowLayout());
		 	
		 	JLabel l1 = new JLabel("Unsharp Threshold Value입력(0~50)");
			JTextField t1 = new JTextField("10");
			
		 	JButton b1 = new JButton("확인");
			JButton b2 = new JButton("취소");
			
			class b1EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					String ThresholdValue = t1.getText();
				    int value = Integer.parseInt(ThresholdValue);
				    if(value<=50&&value>=0){
				    	ImageOperations ImageOp1 = new ImageOperations();
						bio_medi.staticjpgImage = ImageOp1.inverse(bio_medi.staticjpgImage);
						bio_medi.staticjpgImage = ImageOp1.inverse(bio_medi.staticjpgImage);
						
				    	UnsharpFilter ImageOp = new UnsharpFilter();
				    	ImageOp.setThreshold(value);
						bio_medi.staticjpgImage = (Image)(ImageOp.filter((BufferedImage)bio_medi.staticjpgImage));
						bio_medi.staticp2.setImage(bio_medi.staticjpgImage);
						Dia.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
				    }
				}}
			b1.addActionListener(new b1EventHandler());
			
			class b2EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					Dia.dispose();
				}}
			b2.addActionListener(new b2EventHandler());
			
			Panel restartP = new Panel();
			Panel restartP3 = new Panel();
			restartP.setLayout(new GridLayout(2,1));
			restartP.add(l1);
			restartP.add(t1);
			restartP3.setLayout(new GridLayout(1,2));
			restartP3.add(b1);
			restartP3.add(b2);
			Dia.add(restartP, BorderLayout.NORTH);
			Dia.add(restartP3, BorderLayout.CENTER);
			Dia.setVisible(true);
	}
}

class CannyDialog{
	public CannyDialog(JFrame f){
			//String ThresholdValue = "0";
		 	Dialog Dia = new Dialog(f,"CannyEdgeDetector",true);
		 	
		 	Dia.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					Dia.dispose();
				}
			});
		 	
		 	Dia.setSize(240, 150);
		 	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			int xpos = (int) (screen.getWidth() / 2 - Dia.getWidth() / 2);
			int ypos = (int) (screen.getHeight() / 2 - Dia.getHeight() / 2);
			Dia.setLocation(xpos,ypos);
			Dia.setLayout(new FlowLayout());
		 	
		 	JLabel l1 = new JLabel("Threashold Value입력(0이상)");
		 	JLabel l2 = new JLabel("High : ");
		 	JTextField t1 = new JTextField("1");
		 	JLabel l3 = new JLabel("Low : ");
			JTextField t2 = new JTextField("0.5");
			
		 	JButton b1 = new JButton("확인");
			JButton b2 = new JButton("취소");
			
			class b1EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					String ThresholdValue = t1.getText();
					String ThresholdValue2 = t2.getText();
				    float value = Float.parseFloat(ThresholdValue);
				    float value2 = Float.parseFloat(ThresholdValue2);
				    if(value<=500&&value>=0&&value2<=500&&value2>=0){
				    	ImageOperations ImageOp1 = new ImageOperations();
						bio_medi.staticjpgImage = ImageOp1.inverse(bio_medi.staticjpgImage);
						bio_medi.staticjpgImage = ImageOp1.inverse(bio_medi.staticjpgImage);
						//create the detector
						CannyEdgeDetector detector = new CannyEdgeDetector();

						//adjust its parameters as desired
						detector.setLowThreshold(value);
						detector.setHighThreshold(value2);

						//apply it to an image
						detector.setSourceImage((BufferedImage)bio_medi.staticjpgImage);
						detector.process();
						BufferedImage edges = detector.getEdgesImage();
						bio_medi.staticjpgImage = (Image)edges;
						bio_medi.staticp2.setImage(bio_medi.staticjpgImage);
						Dia.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
				    }
				}}
			b1.addActionListener(new b1EventHandler());
			
			class b2EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					Dia.dispose();
				}}
			b2.addActionListener(new b2EventHandler());
			
			Panel restartP = new Panel();
			Panel restartP2 = new Panel();
			Panel restartP3 = new Panel();
			restartP.setLayout(new BorderLayout());
			restartP.add(l1);
			restartP2.setLayout(new GridLayout(1,4,1,1));
			restartP2.add(l2);
			restartP2.add(t1);
			restartP2.add(l3);
			restartP2.add(t2);
			restartP3.setLayout(new GridLayout(1,2));
			restartP3.add(b1);
			restartP3.add(b2);
			Dia.add(restartP, BorderLayout.NORTH);
			Dia.add(restartP2, BorderLayout.CENTER);
			Dia.add(restartP3, BorderLayout.SOUTH);
			Dia.setVisible(true);
	}
}
class openDialog{
	public openDialog(JFrame f) throws IOException{
		 	FileDialog Dia = new FileDialog(f,"Open Image",FileDialog.LOAD);
		 	Dia.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					Dia.dispose();
				}
			});
		 	Dia.setFile("*.*");
		 	Dia.setVisible(true);
		 	String DirName = Dia.getDirectory();
		 	String FileName = Dia.getFile();
		 	String strName = DirName + FileName;
		 	
		 	File jpgImageFile = new File(strName);
	        bio_medi.staticjpgImage = ImageIO.read(jpgImageFile);
	        bio_medi.staticp2.setImage(bio_medi.staticjpgImage);
	        bio_medi.originalImage = bio_medi.staticjpgImage;
	}
}

class saveDialog{
	public saveDialog(JFrame f) throws IOException{
		 	FileDialog Dia = new FileDialog(f,"Save Image",FileDialog.SAVE);
		 	Dia.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					Dia.dispose();
				}
			});
		 	Dia.setFile("*.jpg");
		 	Dia.setVisible(true);
		 	
		 	String DirName = Dia.getDirectory();
		 	String FileName = Dia.getFile();
		 	String strName = DirName + FileName;
		 	BufferedImage img = (BufferedImage)bio_medi.staticjpgImage;
		 	ImageIO.write(img, "jpg", new File(strName));
	}
}
