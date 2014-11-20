package f_project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;;
 

public class TextDemo {
    static JTextArea output;
    JScrollPane scrollPane;
    String str;
 
    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        //Create the menu bar.
        menuBar = new JMenuBar(); 
        //Build the first menu.
        menu = new JMenu("File");       
        menuBar.add(menu); 
        //a group of JMenuItems
        menuItem = new JMenuItem("New");
        
        menuItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// Code for New button
				createAndShowGUI();
			}
		});
        
        menu.add(menuItem);        
        menuItem = new JMenuItem("Open");
        menu.add(menuItem);       
        menu.addSeparator();        
        menuItem = new JMenuItem("Save");        
        menu.add(menuItem);
        menuItem = new JMenuItem("Save As");       
        menu.add(menuItem);
        menu.addSeparator();       
        menuItem = new JMenuItem("Print");        
        menu.add(menuItem);        
        menu.addSeparator();        
        menuItem = new JMenuItem("Exit");
        menuItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// method for exit;
				
			}
		});
        
        menu.add(menuItem);        
        
        menu = new JMenu("Edit");        
        menuBar.add(menu);
        menuItem = new JMenuItem("Undo");
        menuItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// code for undo method
				
			}
		});
        
        menu.add(menuItem);        
        menu.addSeparator();
        menuItem = new JMenuItem("Copy");
        
        //method for the copy button
        //the text should be selected first
        menuItem.addMouseListener(new MouseListener() {        	
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				if (output.getSelectedText() != null){ //see if they selected something 
					str = output.getSelectedText();    			
					}			
			}
			public void mouseExited(MouseEvent arg0) {}
			
			public void mouseEntered(MouseEvent arg0) {}
			
			public void mouseClicked(MouseEvent arg0) {}

			public void mousePressed(MouseEvent arg0) {}
		});
        
        menu.add(menuItem);        
        menuItem = new JMenuItem("Paste");
        
        //paste method appends the string to the JTextArea
        menuItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				//code for the paste method		
				output.append(str);
			}
		});
        
        menu.add(menuItem);
        menu.addSeparator();
        menuItem = new JMenuItem("Find");        
        menu.add(menuItem);        
        
       
        menu = new JMenu("About");  
        menuItem = new JMenuItem("Help");
        //for the menuItem Help create an action listener which
        //displays the message dialog.
        menuItem.addActionListener(new ActionListener() {			
			
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "Information about this program");
				
			}
		});
       
        menu.add(menuItem);        
        menuBar.add(menu);
        return menuBar;
    }
    
 
    public Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
 
        //Create a scrolled text area.
        output = new JTextArea(5, 30);
        //output.setCaretColor(Color blue);
        output.setEditable(true);
        scrollPane = new JScrollPane(output);
        
 
        //Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER); 
        return contentPane;
    }
 

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Lydia, Brandon and Zafar text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //create the window in the center of the screen
        Toolkit tk = Toolkit.getDefaultToolkit();
		 Dimension dim = tk.getScreenSize();
		 int Xpos = (dim.width/5) - (frame.getWidth()/5);
		 int Ypos = (dim.height/50) - (frame.getHeight()/50);
		 frame.setLocation(Xpos, Ypos);
 
        //Create and set up the content pane.
        TextDemo demo = new TextDemo();
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(demo.createContentPane()); 
        //Display the window.
        frame.setSize(900, 600);
        frame.setVisible(true);
        
    }
 
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
 
 
         
