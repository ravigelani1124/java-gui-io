import data.ProductInfo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class FindDisplayProduct extends JFrame implements ActionListener {
    private ButtonGroup radioGroup;
    private JRadioButton priceRangeRadio,keywordRadio,allRadio;
    private JTextField toInput,fromInput,keywordInput;
    private JTable table;
    private JButton btnSearch;

    private ArrayList<ProductInfo> productList;
    FindDisplayProduct(){
        setMainFrame();
        setScreenLayout();
    }

    /*
     * @ Function Name      : setMainFrame
     * @ Function Params    : None
     * @ Function Purpose   : This method is used to set main frame.
     */
    private void setMainFrame() {
        setTitle("Find/Display Products");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(Utility.FRAME_WIDTH, Utility.FRAME_HEIGHT);
        setLocationRelativeTo(null);
    }

    /*
     * @ Function Name      : setScreenLayout
     * @ Function Params    : None
     * @ Function Purpose   : This method is used set GUI components in frame
     */
    private void setScreenLayout() {
        //this method is used set GUI components in frame
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

        JPanel inputsPanel = new JPanel();
        
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
        toPanel.add(toLabel);
        toPanel.add(toInput);

        JPanel keywordPanel = new JPanel();
        JLabel keywordLabel = new JLabel("Keyword");
        keywordInput = new JTextField();
        keywordInput.setColumns(8);
        keywordPanel.add(keywordLabel);
        keywordPanel.add(keywordInput);

        inputsPanel.add(fromPanel);
        inputsPanel.add(toPanel);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));

        panel.add(inputsPanel);
        panel.add(keywordPanel);
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
        btnSearch.addActionListener(this);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSearch){
            findProduct();
        }
    }

    /*
     * @ Function Name      : findProduct
     * @ Function Params    : None
     * @ Function Purpose   : This method is used to find data from file based on user selection.
     */
    private void findProduct() {
        String keyword = keywordInput.getText().trim();
        String fromPrice = fromInput.getText().trim();
        String toPrice = toInput.getText().trim();

        if (allRadio.isSelected()) {
            displayAllProducts();
        } else if (keywordRadio.isSelected()) {
            displayProductByKeyword(keyword);
        } else if (priceRangeRadio.isSelected()) {
            displayProductByPriceRange(fromPrice, toPrice);
        } else {
            JOptionPane.showMessageDialog(null, "Please select any search option such as All,Keyword and Price");
        }
    }

    /*
     * @ Function Name      : displayProductByKeyword
     * @ Function Params    : keyword : String
     * @ Function Purpose   : This method is used to get all product data based on keywords.
     */
    private void displayProductByKeyword(String keyword) {
        try {
            productList = Utility.getProductList();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            boolean isDataFound=false;
            model.setRowCount(0);
            for (ProductInfo product : productList) {
                if (product.getName().toLowerCase().contains(keyword.toLowerCase()) || product.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                    model.addRow(new Object[] { product.getId(), product.getName(),product.getDescription(),product.getQuantity() ,product.getPrice() });
                    isDataFound=true;
                }
            }
            if (!isDataFound) {
                JOptionPane.showMessageDialog(null, "Sorry! Not any product found while searching the keyword " + keyword + ".");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
     * @ Function Name      : displayAllProducts
     * @ Function Params    : None
     * @ Function Purpose   : This method is used to get all product data.
     */
    private void displayAllProducts() {
        try {
            productList = Utility.getProductList();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            for (ProductInfo product : productList) {
                model.addRow(new Object[] { product.getId(), product.getName(),product.getDescription(),product.getQuantity() ,product.getPrice() });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sorry! No data found");
        }
    }

    /*
     * @ Function Name      : displayAllProducts
     * @ Function Params    : String fromPrice, String toPrice
     * @ Function Purpose   : This method is used to get all product data based on price range.
     */
    private void displayProductByPriceRange(String fromPrice, String toPrice) {
        try {
            productList = Utility.getProductList();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            boolean isDataFound=false;
            double from = Double.parseDouble(fromPrice);
            double to = Double.parseDouble(toPrice);
            model.setRowCount(0);
            for (ProductInfo product : productList) {
                if (product.getPrice() >= from && product.getPrice() <= to) {
                    System.out.println(product.getPrice());
                    model.addRow(new Object[] { product.getId(), product.getName(),product.getDescription(),product.getQuantity() ,product.getPrice() });
                    isDataFound=true;
                }
            }
            if (!isDataFound) {
                JOptionPane.showMessageDialog(null, "Sorry! Not products is found in this price range.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong " +" "+ e.getMessage());
        }
    }

}
