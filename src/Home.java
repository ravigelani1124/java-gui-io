import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {

    private JMenuBar jMenuBar;
    private JMenu menuFile,menuProduct;
    private JMenuItem menuItemExit,menuItemAddUpdate,menuItemFindDisplay;
    Home(){
        setMainFrame();
        setMainMenuBar();
        setMenu();
        setMenuItem();
    }
    private void setMainFrame() {
        setTitle("Product Display"); // set title of frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        setResizable(false); // prevent frame of being resized
        setSize(Utils.FRAME_WIDTH, Utils.FRAME_HEIGHT); // set the x and y dimension of frame
        setLocationRelativeTo(null); //centre window
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Project Management System");
        panel.add(title);
        add(panel,BorderLayout.CENTER);
    }
    private void setMainMenuBar() {
        jMenuBar = new JMenuBar();
    }
    private void setMenu() {
        menuFile = new JMenu("File");
        menuProduct = new JMenu("Product");
        jMenuBar.add(menuFile);
        jMenuBar.add(menuProduct);
    }
    private void setMenuItem() {
        menuItemExit = new JMenuItem("Exit");
        menuItemAddUpdate = new JMenuItem("Add/Update");
        menuItemFindDisplay = new JMenuItem("Find/Display");
        menuFile.add(menuItemExit);
        menuProduct.add(menuItemAddUpdate);
        menuProduct.add(menuItemFindDisplay);
        menuItemExit.addActionListener(this);
        menuItemAddUpdate.addActionListener(this);
        menuItemFindDisplay.addActionListener(this);
        setJMenuBar(jMenuBar);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==menuItemExit){
            System.exit(0);
        }else if(e.getSource()==menuItemAddUpdate){
            new AddUpdateProduct();
        }else if(e.getSource()==menuItemFindDisplay){
            new FindDisplayProduct();
        }
    }
}
