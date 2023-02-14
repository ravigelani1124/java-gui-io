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
    private void setMainMenuBar() {
        //this method is used set menubar in frame
        jMenuBar = new JMenuBar();
    }
    private void setMenu() {
        //this method is used set menus in frame
        menuFile = new JMenu("File");
        menuProduct = new JMenu("Product");
        jMenuBar.add(menuFile);
        jMenuBar.add(menuProduct);
    }
    private void setMenuItem() {
        //this method is used set menu items in Menu
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
