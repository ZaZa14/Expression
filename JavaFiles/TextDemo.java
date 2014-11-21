//*************************************************************************************
// Program:			TextDemo.java
// Programmers:		
// Last Modified:	Nov 10, 2014
// Description:		Creates the GUI for the Expression text editor.
//*************************************************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class TextDemo 
{
    JTextArea output;
    JScrollPane scrollPane;
    String str;
 
    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu file, edit, about;
        JMenuItem newDoc, open, save, saveAs, print, exit, undo, copy, paste, find, help;
        //Create the menu bar.
        menuBar = new JMenuBar(); 
        //Build the first menu.
        file = new JMenu("File");       
        menuBar.add(file); 
        //a group of JMenuItems
        newDoc = new JMenuItem("New"); 
        file.add(newDoc);        
        open = new JMenuItem("Open");
        file.add(open);       
        file.addSeparator();        
        save = new JMenuItem("Save");        
        file.add(save);
        saveAs = new JMenuItem("Save As");       
        file.add(saveAs);
        file.addSeparator();       
        print = new JMenuItem("Print");        
        file.add(print);        
        file.addSeparator();        
        exit = new JMenuItem("Exit");        
        file.add(exit);        
        
        edit = new JMenu("Edit");        
        menuBar.add(edit);
        undo = new JMenuItem("Undo");
        edit.add(undo);        
        edit.addSeparator();
        copy = new JMenuItem("Copy");       
        edit.add(copy); 
        
        
        //method for the copy button
        //the text should be selected first
        copy.addMouseListener(new MouseListener() {        	
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
        
        paste = new JMenuItem("Paste");  
        
        //paste method appends the string to the JTextArea
        paste.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				//code for the paste method		
				output.append(str);
			}
		});
        
        edit.add(paste);
        edit.addSeparator();
        find = new JMenuItem("Find");        
        edit.add(find);        
        
        about = new JMenu("About"); 
        help = new JMenuItem("Help");
        about.add(help);  
        menuBar.add(about);
        
        newDoc.addActionListener(new ActionListener() 
        {
			
			public void actionPerformed(ActionEvent arg0) {
				// Code for New button
				createAndShowGUI();
			}
		});
        
      //for the menuItem Help create an action listener which
        //displays the message dialog.
        help.addActionListener(new ActionListener() 
        {			
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane.showMessageDialog(null, "Information about this program");
          	}
      	});
                 
        
        return menuBar;
    }
 
    public Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
        
         //create the window in the center of the screen
        Toolkit tk = Toolkit.getDefaultToolkit();
     		 Dimension dim = tk.getScreenSize();
     		 int Xpos = (dim.width/5) - (contentPane.getWidth()/5);
     		 int Ypos = (dim.height/50) - (contentPane.getHeight()/50);
     		contentPane.setLocation(Xpos, Ypos);
 
        //Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setEditable(true);
        scrollPane = new JScrollPane(output);
 
        //Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER); 
        return contentPane;
    }
 

    private static void createAndShowGUI() 
    {
        //Create and set up the window.
        JFrame frame = new JFrame("Expression");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        TextDemo demo = new TextDemo();
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(demo.createContentPane()); 
        //Display the window.
        frame.setSize(900, 600);
        frame.setVisible(true);
        
    }
 
    public static void main(String[] args) 
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                createAndShowGUI();
            }
        });
    }
}