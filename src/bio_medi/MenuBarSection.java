package bio_medi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
		//exit menu event handler
		class exitEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				System.exit(0);
			}}	
		exit.addActionListener(new exitEventHandler());		
		//reset menu event handler
		class resetEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new ResetDialog(f);
			}}
		reset.addActionListener(new resetEventHandler());
		//gray scale menu event handler
		class BlacknWhiteEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new BlacknWhiteDialog(f);
			}}
		blacknWhite.addActionListener(new BlacknWhiteEventHandler());
		//inverse menu event handler
		class inverseEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new inverseDialog(f);
			}}
		inverse.addActionListener(new inverseEventHandler());
		//BoxBlur menu event handler
		class BoxBlurEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new BoxBlurDialog(f);
			}}
		BoxBlur.addActionListener(new BoxBlurEventHandler());
		//Threshold menu event handler
		class ThresholdEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new ThresholdDialog(f);
			}}
		Threshold.addActionListener(new ThresholdEventHandler());
		//Gaussian menu event handler
		class GaussianEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new GaussianDialog(f);
			}}
		Gaussian.addActionListener(new GaussianEventHandler());		
		//Unsharp menu event handler
		class UnsharpEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new UnsharpDialog(f);
			}}
		Unsharp.addActionListener(new UnsharpEventHandler());			
		//Canny menu event handler
		class CannyEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new CannyDialog(f);
			}}
		Canny.addActionListener(new CannyEventHandler());	
		//help menu event handler
		class helpEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new HelpDialog(f);
			}}
		helpwords.addActionListener(new helpEventHandler());
		//author menu event handler
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
