import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 

public class TextDemo {

    JTextArea output;
    JScrollPane scrollPane;
 
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
        menu.add(menuItem);        
        
        menu = new JMenu("Edit");        
        menuBar.add(menu);
        menuItem = new JMenuItem("Undo");
        menu.add(menuItem);        
        menu.addSeparator();
        menuItem = new JMenuItem("Copy");       
        menu.add(menuItem);        
        menuItem = new JMenuItem("Paste");        
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
 

    private static void createAndShowGUI() {
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
 
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}