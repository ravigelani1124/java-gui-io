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

    /*
     * @ Function Name      : setMainFrame
     * @ Function Params    : None
     * @ Function Purpose   : This method is used to set main frame.
     */
    private void setMainFrame() {
        //this method is used set main frame
        setTitle("Product Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(Utility.FRAME_WIDTH, Utility.FRAME_HEIGHT);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Project Management System");
        Font font = new Font("Courier", Font.BOLD,22);
        title.setFont(font);
        panel.add(title);
        panel.setBounds(90,130,450,100);
        setLayout(null);
        add(panel);
    }

    /*
     * @ Function Name      : setMainMenuBar
     * @ Function Params    : None
     * @ Function Purpose   : This method is used set menubar in frame
     */
    private void setMainMenuBar() {
        jMenuBar = new JMenuBar();
    }

    /*
     * @ Function Name      : setMenu
     * @ Function Params    : None
     * @ Function Purpose   : This method is used set menus in frame.
     */
    private void setMenu() {
        menuFile = new JMenu("File");
        menuProduct = new JMenu("Product");
        jMenuBar.add(menuFile);
        jMenuBar.add(menuProduct);
    }

    /*
     * @ Function Name      : setMenuItem
     * @ Function Params    : None
     * @ Function Purpose   : This method is used set menu items in Menu
     */
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
    /*
     * @ Function Name      : main
     * @ Function Params    : None
     * @ Function Purpose   : This method is used execute the program
     */
    public static void main(String[] args) {
        new Home();
    }
}
