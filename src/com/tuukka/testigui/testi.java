package com.tuukka.testigui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

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

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class testi {

	private Level map;
	//private List<Entity> entityList = new ArrayList<Entity>();
	private Entitylist entitylist;
	private Entity entity;
	private Persister persister = new Persister();
	
	private String PROJECT_BASE_PATH = "/home/tuukka/workspace/fromscratch/";

	private JList list;
	
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
		
				list = new JList();
		list.setBounds(12, 12, 58, 414);
		map.getContentPane().add(list);
		
		JPanel panel = new JPanel();
		panel.setBounds(82, 12, 404, 429);
		map.getContentPane().add(panel);
		
		
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
			private JPanel panel = new JPanel();

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
						/*entity = persister.read(Entity.class, file);
						//System.out.println(entity.toString());
						entity.prepareThySelf(PROJECT_BASE_PATH);
						list.add(entity);
						entity.setVisible(true);*/
                    	entitylist = persister.read(Entitylist.class, file);

                    	if (entitylist.getLength() != 4 ) {
                    		// something is fucked
                    		System.out.println("entitylist length is wrong, the world is ending!");
                    		
                    	}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
			}

		});
		/*JMenuItem mntmSaveSprite = new JMenuItem("save sprite");
		final Entity testientity1 = new Entity("testi", 1, 1, "ui_ball_1.png" );
		final Entity testientity2 = new Entity("testi2", 1, 1, "ui_ball_1.png" );
		final Entity testientity3 = new Entity("testi2", 1, 1, "ui_ball_1.png" );
		final Entitylist entitylist = new Entitylist(2);
		
		entitylist.add(testientity1);
		entitylist.add(testientity2);
		entitylist.add(testientity3);
		mntmSaveSprite.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Serializer serializer = new Persister();
				File result = new File("serializertest2.xml");
				try {
					serializer.write(entitylist, result);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		);
		mnEdit.add(mntmSaveSprite);*/
		mnEdit.add(mntmLoadSpriteList);
		JMenuItem mntmSaveLevel = new JMenuItem("save level");
		final MappedEntity testientity1 = new MappedEntity("testi", 1, 1, "ui_ball_1.png" );
		testientity1.setLocation(1, 1);
		final MappedEntity testientity2 = new MappedEntity("testi2", 1, 1, "ui_ball_1.png" );
		testientity2.setLocation(2, 2);
		final MappedEntity testientity3 = new MappedEntity("testi3", 1, 1, "ui_ball_1.png" );
		testientity3.setLocation(3, 3);
		
		final Level testilevel = new Level(156, 156);
		testilevel.add(testientity1);
		testilevel.add(testientity2);
		testilevel.add(testientity3);
		
		mntmSaveLevel.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Serializer srlzr = new Persister();
				File rslt = new File("levelsavertest.xml");
				try {
					srlzr.write(testilevel, rslt);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					
			
			
				
			}
		});
		
		mnEdit.add(mntmSaveLevel);
		//frame.getContentPane().add(textArea, BorderLayout.WEST);
		map.getContentPane().add(textArea, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 438, 70, 15);
		map.getContentPane().add(lblNewLabel);
		

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
