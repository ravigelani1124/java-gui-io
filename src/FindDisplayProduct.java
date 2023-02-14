import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FindDisplayProduct extends JFrame{
    private ButtonGroup radioGroup;
    private JRadioButton priceRangeRadio;
    private JRadioButton keywordRadio;
    private JRadioButton allRadio;
    private JTextField toInput;
    private JTextField fromInput;
    private JTextField keywordInput;
    private JTable table;
    private JButton btnSearch;

    FindDisplayProduct(){
        setMainFrame();
        setScreenLayout();
    }
    private void setMainFrame() {
        setTitle("Find/Display Products");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(Utils.FRAME_WIDTH, Utils.FRAME_HEIGHT);
        setLocationRelativeTo(null);
    }
    private void setScreenLayout() {
        JPanel mainFirstPanel = new JPanel();
        Box box1 = Box.createVerticalBox();

        priceRangeRadio = new JRadioButton("Price Range");
        keywordRadio = new JRadioButton("Keyword");
        allRadio = new JRadioButton("All");

        box1.add(priceRangeRadio);
        box1.add(keywordRadio);
        box1.add(allRadio);

        radioGroup = new ButtonGroup();
        radioGroup.add(priceRangeRadio);
        radioGroup.add(keywordRadio);
        radioGroup.add(allRadio);
        mainFirstPanel.add(box1);

        JPanel testPanel = new JPanel();
        JPanel fromPanel = new JPanel();
        JLabel fromLabel = new JLabel("From");
        fromInput = new JTextField();
        fromInput.setColumns(8);
        fromPanel.add(fromLabel);
        fromPanel.add(fromInput);

        JPanel toPanel = new JPanel();
        JLabel toLabel = new JLabel("To");
        toInput = new JTextField();
        toInput.setColumns(8);
        toInput.setToolTipText("To");
        toPanel.add(toLabel);
        toPanel.add(toInput);

        JPanel keywordPanel = new JPanel();
        JLabel keywordLabel = new JLabel("Keyword");
        keywordInput = new JTextField();
        keywordInput.setColumns(8);
        keywordPanel.add(keywordLabel);
        keywordPanel.add(keywordInput);

        testPanel.add(fromPanel);
        testPanel.add(toPanel);

        JPanel panel = new JPanel();
        panel.add(testPanel);
       // panel.add(keywordPanel);

        mainFirstPanel.add(panel);
        btnSearch = new JButton("Find/Display");
        mainFirstPanel.add(btnSearch);
        JPanel scrollPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        scrollPanel.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Product Id","Product Name",  "Description", "Quantity","UnitPrice" }));
        scrollPane.setViewportView(table);

        JPanel centerPanel = new JPanel((new FlowLayout(FlowLayout.LEFT) ));
        centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        centerPanel.add(mainFirstPanel);
        add(centerPanel,BorderLayout.CENTER);
        add(scrollPanel,BorderLayout.SOUTH);
        setVisible(true);
    }

}
