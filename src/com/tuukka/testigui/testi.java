package com.tuukka.testigui;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import org.simpleframework.xml.core.Persister;

public class testi {

	private Level map;
	//private List<Entity> entityList = new ArrayList<Entity>();
	private Entitylist entitylist;
	private Persister persister = new Persister();


	private JTextArea textArea = new JTextArea();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testi window = new testi();
					window.map.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public testi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/*frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		map = new Level(800, 800);
		map.setBounds(400, 400, 500, 500);
		map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		map.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("file");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("new");
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("save");
		mnFile.add(mntmSave);
		
		JRadioButtonMenuItem rdbtnmntmSaveAs = new JRadioButtonMenuItem("save as");
		mnFile.add(rdbtnmntmSaveAs);
		
		JMenuItem mntmQuit = new JMenuItem("quit");
		mnFile.add(mntmQuit);
		
		JMenu mnEdit = new JMenu("edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmLoadSpriteList = new JMenuItem("load sprite list");
		mntmLoadSpriteList.addActionListener(new ActionListener() {
			private Component panel;

			public void actionPerformed(ActionEvent arg0) {

                JFileChooser fileopen = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("xml files", "xml");
                fileopen.addChoosableFileFilter(filter);

                int ret = fileopen.showDialog(panel, "Open file");

                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    //String text = readFile(file);
                    //parseDOM(file);
                    //textArea.setText(text);
                    try {
						entitylist = persister.read(Entitylist.class, file);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
			}

		});
		
		mnEdit.add(mntmLoadSpriteList);
		
		//frame.getContentPane().add(textArea, BorderLayout.WEST);
		map.getContentPane().add(textArea, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 438, 70, 15);
		map.getContentPane().add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(12, 12, 58, 414);
		map.getContentPane().add(list);
		
		JPanel panel = new JPanel();
		panel.setBounds(82, 12, 404, 429);
		map.getContentPane().add(panel);
		
	}

		
	    public String readFile(File file) {

        StringBuffer fileBuffer = null;
        String line = null;

        String fileString;
		try {
            FileReader in = new FileReader(file);
            BufferedReader brd = new BufferedReader(in);
            fileBuffer = new StringBuffer();

            while ((line = brd.readLine()) != null) {
                fileBuffer.append(line).append(
                        System.getProperty("line.separator"));
            }

            in.close();
            fileString = fileBuffer.toString();
        } catch (IOException e) {
            return null;
        }
        return fileString;
    }	
}
