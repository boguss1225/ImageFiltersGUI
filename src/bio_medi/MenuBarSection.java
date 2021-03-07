package bio_medi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class MenuBarSection{
	MenuBarSection() {}
	
	public void MakeMenuBar(JFrame f){
		//////////////////////////////////Menu_bar///////////////////////////////////////
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("file");
		JMenu edit = new JMenu("edit");
		JMenu help = new JMenu("help");
		//<<<<<<<<<<<<File Menu>>>>>>>>>>>>
		JMenuItem open = new JMenuItem("open");
		JMenuItem save = new JMenuItem("save");
		JMenuItem exit = new JMenuItem("exit");
		
		JMenuItem reset = new JMenuItem("reset");	
		JMenuItem blacknWhite = new JMenuItem("black&white");
		JMenuItem inverse = new JMenuItem("inverse");
		JMenuItem BoxBlur = new JMenuItem("Box Blur");
		JMenuItem Threshold = new JMenuItem("Threshold");
		JMenuItem Gaussian = new JMenuItem("Gaussian Blur");
		JMenuItem Unsharp = new JMenuItem("Unsharp");
		JMenuItem Canny = new JMenuItem("CannyEdgeDetector");
		JMenuItem helpwords = new JMenuItem("helpwords");
		JMenuItem author = new JMenuItem("author");
		file.add(open);
		file.add(save);
		file.addSeparator();
		file.add(exit);
		edit.add(reset);
		edit.add(blacknWhite);		
		edit.add(inverse);
		edit.add(BoxBlur);
		edit.add(Threshold);
		edit.add(Gaussian);
		edit.add(Unsharp);
		edit.add(Canny);
		help.add(helpwords);
		help.add(author);
		//<<<<<<<<<<<<Menu_SetUp>>>>>>>>>>>>
		menubar.add(file);
		menubar.add(edit);
		menubar.add(help);
		
		//<<<<<<<<<<<<MenuItem_Action>>>>>>>>>>>>
		//open
		class openEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				try {
					new openDialog(f);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}}	
		open.addActionListener(new openEventHandler());
		//save
		class saveEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				try {
					new saveDialog(f);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}}	
		save.addActionListener(new saveEventHandler());
		//���� �޴�������
		class exitEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				System.exit(0);
			}}	
		exit.addActionListener(new exitEventHandler());		
		//�ǵ����� �޴�������
		class resetEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new ResetDialog(f);
			}}
		reset.addActionListener(new resetEventHandler());
		//��� �޴�������
		class BlacknWhiteEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new BlacknWhiteDialog(f);
			}}
		blacknWhite.addActionListener(new BlacknWhiteEventHandler());
		//��� �޴�������
		class inverseEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new inverseDialog(f);
			}}
		inverse.addActionListener(new inverseEventHandler());
		//BoxBlur �޴�������
		class BoxBlurEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new BoxBlurDialog(f);
			}}
		BoxBlur.addActionListener(new BoxBlurEventHandler());
		//Threshold �޴�������
		class ThresholdEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new ThresholdDialog(f);
			}}
		Threshold.addActionListener(new ThresholdEventHandler());
		//Gaussian �޴�������
		class GaussianEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new GaussianDialog(f);
			}}
		Gaussian.addActionListener(new GaussianEventHandler());		
		//Unsharp �޴�������
		class UnsharpEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new UnsharpDialog(f);
			}}
		Unsharp.addActionListener(new UnsharpEventHandler());			
		//Canny �޴�������
		class CannyEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new CannyDialog(f);
			}}
		Canny.addActionListener(new CannyEventHandler());	
		//���� �޴�������
		class helpEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new HelpDialog(f);
			}}
		helpwords.addActionListener(new helpEventHandler());
		//������ �޴�������
		class authorEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new AuthorDialog(f);
			}}	
		author.addActionListener(new authorEventHandler());
		
		//menubar.setOpaque(true);
		f.setJMenuBar(menubar);
		f.setVisible(true);
	}
	
}
