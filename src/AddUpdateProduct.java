import data.ProductInfo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class AddUpdateProduct extends JFrame implements ActionListener{
    private JTextField idInput,nameInput,quantityInput,priceInput;
    private JTextArea descInput;
    private JButton btnAdd,btnUpdate,btnFirst,btnPrevious,btnNext,btnLast;
    private ArrayList<ProductInfo> productList = new ArrayList<>();
    private int currentProductIndex=0;
    AddUpdateProduct(){
        productList=Utility.getProductList();
        setMainFrame();
        setScreenLayout();
    }

    /*
     * @ Function Name      : setMainFrame
     * @ Function Params    : None
     * @ Function Purpose   : This method is used set main frame
     */
    private void setMainFrame() {
        setTitle("Add/Update"); // set title of frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false); // prevent frame of being resized
        setSize(Utility.FRAME_WIDTH, Utility.FRAME_HEIGHT); // set the x and y dimension of frame
        setLocationRelativeTo(null); //centre window
    }

    /*
     * @ Function Name      : setScreenLayout
     * @ Function Params    : None
     * @ Function Purpose   : This method is used set GUI components in frame
     */
    private void setScreenLayout() {
        JLabel idLabel = new JLabel("Product ID : ");
        idInput = new JTextField(12);
        JLabel nameLabel = new JLabel("Name :         ");
        nameInput = new JTextField(20);
        JLabel descLabel = new JLabel("Description : ");
        descInput = new JTextArea(6,18);
        JLabel quantityLabel = new JLabel("Quantity In Hand :");
        quantityInput = new JTextField(10);
        JLabel priceLabel = new JLabel("Unit Price :           ");
        priceInput = new JTextField(10);
        btnAdd = new JButton("Add");
        btnAdd.setPreferredSize(new Dimension(138, 38));
        btnFirst = new JButton("First");
        btnFirst.setPreferredSize(new Dimension(138, 38));
        btnPrevious = new JButton("Previous");
        btnPrevious.setPreferredSize(new Dimension(138, 38));
        btnNext = new JButton("Next");
        btnNext.setPreferredSize(new Dimension(138, 38));
        btnLast = new JButton("Last");
        btnLast.setPreferredSize(new Dimension(138, 38));
        btnUpdate = new JButton("Update");
        btnUpdate.setPreferredSize(new Dimension(138, 38));

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(4, 1));

        JPanel idPanel = new JPanel();
        idPanel.add(idLabel);
        idPanel.add(idInput);

        JPanel namePanel = new JPanel();
        namePanel.add(nameLabel);
        namePanel.add(nameInput);

        JPanel descPanel = new JPanel();
        descPanel.add(descLabel);
        descPanel.add(descInput);

        JPanel quantityPanel = new JPanel();
        quantityPanel.add(quantityLabel);
        quantityPanel.add(quantityInput);

        JPanel pricePanel = new JPanel();
        pricePanel.add(priceLabel);
        pricePanel.add(priceInput);

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(2, 1));
        gridPanel.add(quantityPanel);
        gridPanel.add(pricePanel);
        descPanel.add(gridPanel);
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.setBorder(new EmptyBorder(20, 10, 10, 10));

        JPanel addUpdateButtonPanel = new JPanel((new FlowLayout(FlowLayout.LEADING)));
        addUpdateButtonPanel.add(btnAdd);
        addUpdateButtonPanel.add(btnUpdate);

        JPanel firstLastPanel = new JPanel((new FlowLayout(FlowLayout.LEADING) ));
        firstLastPanel.add(btnFirst);
        firstLastPanel.add(btnPrevious);
        firstLastPanel.add(btnNext);
        firstLastPanel.add(btnLast);

        buttonPanel.add(addUpdateButtonPanel);
        buttonPanel.add(firstLastPanel);

        btnAdd.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnFirst.addActionListener(this);
        btnPrevious.addActionListener(this);
        btnNext.addActionListener(this);
        btnLast.addActionListener(this);

        JPanel centerPanel = new JPanel((new FlowLayout(FlowLayout.LEFT) ));
        centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        centerPanel.add(idPanel);
        centerPanel.add(namePanel);
        centerPanel.add(descPanel);
        add(centerPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnAdd) {
            addProduct();
        }else if(e.getSource()==btnUpdate){
            updateProduct();
        }else if(e.getSource()==btnFirst){
            getFirstProduct();
        }else if(e.getSource()==btnPrevious){
            getPreviousProduct();
        }else if(e.getSource()==btnNext){
            getNextProduct();
        }else if(e.getSource()==btnLast){
            getLastProduct();
        }
    }

    /*
     * @ Function Name      : addProduct
     * @ Function Params    : None
     * @ Function Purpose   : This method is used to validate user data and add into file.
     */
    private void addProduct() {
        if(validateData()) {
            String name = nameInput.getText().trim();
            String description = descInput.getText().trim();
            int productID = Integer.parseInt(idInput.getText().trim());
            int quantity = Integer.parseInt(quantityInput.getText().trim());
            double unitPrice = Double.parseDouble(priceInput.getText().trim());

            boolean isDataInFile = false;
            for(int i=0 ; i<=productList.size()-1;i++){
                if(productList.get(i).getId()==productID){
                    isDataInFile=true;
                    break;
                }
            }
            if(!isDataInFile){
                ProductInfo product = new ProductInfo(productID, name, description,unitPrice,quantity);
                productList.add(product);
                saveProductData();
                JOptionPane.showMessageDialog(this, "Product added successfully.");
            }else {
                JOptionPane.showMessageDialog(this, "Sorry! Product id is already in the file");
            }
        }
    }

    /*
     * @ Function Name      : updateProduct
     * @ Function Params    : None
     * @ Function Purpose   : This method is used to validate user data and update into file.
     */
    private void updateProduct() {
        if(validateData()) {
            String name = nameInput.getText().trim();
            String description = descInput.getText().trim();
            int productID = Integer.parseInt(idInput.getText().trim());
            int quantity = Integer.parseInt(quantityInput.getText().trim());
            double unitPrice = Double.parseDouble(priceInput.getText().trim());

            boolean isDataInFile = false;
            for(int i=0 ; i<=productList.size()-1;i++){
                if(productList.get(i).getId()==productID){
                    productList.get(i).setId(productID);
                    productList.get(i).setName(name);
                    productList.get(i).setDescription(description);
                    productList.get(i).setPrice(unitPrice);
                    productList.get(i).setQuantity(quantity);
                    isDataInFile=true;
                }
            }
            if(isDataInFile){
                saveProductData();
                JOptionPane.showMessageDialog(this, "Product update successfully.");
            }else {
                JOptionPane.showMessageDialog(this, "Sorry! Not any product is belong to this ProductID");
            }

        }
    }

    /*
     * @ Function Name      : validateData
     * @ Function Params    : None
     * @ Function Purpose   : This method is used to validate user data
     */
    public boolean validateData() {
        String productId= idInput.getText().trim();
        String name = nameInput.getText().trim();
        String description = descInput.getText().trim();
        String quantity = quantityInput.getText().trim();
        String price= priceInput.getText().trim();

        boolean isValid = false;
        if (!Utility.isValidNumber(productId) || productId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter valid ID.");
        } else if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter valid name.");
        }
        else if (description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter valid description.");
        }
        else if (!Utility.isValidNumber(quantity) || quantity.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter valid quantity");
        } else if (!Utility.isValidNumber(price) || price.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Please enter valid price");
        } else {
            isValid = true;
        }
        return isValid;
    }

    /*
     * @ Function Name      : saveProductData
     * @ Function Params    : None
     * @ Function Purpose   : This method is used to validate save data into.
     */
    private void saveProductData() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/productsInfo.dat"));
            oos.writeObject(productList);
            oos.close();
            idInput.setText("");
            nameInput.setText("");
            descInput.setText("");
            quantityInput.setText("");
            priceInput.setText("");
            currentProductIndex = productList.size()-1;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Not able to find file.");
        } catch (IOException e) {
            System.out.println("Something happen while writing data into file." + e.getLocalizedMessage());
        }
    }
    /*
     * @ Function Name      : getFirstProduct
     * @ Function Params    : None
     * @ Function Purpose   : This method is used to get first data from file and set into label.
     */
    private void getFirstProduct() {
        if(productList.size()>0){
            currentProductIndex=0;
            setDataInLabel(currentProductIndex);
        }else {
            JOptionPane.showMessageDialog(this, "Sorry! No any product found");
        }
    }

    /*
     * @ Function Name      : getPreviousProduct
     * @ Function Params    : None
     * @ Function Purpose   : This method is used to get previous data from file and set into label.
     */
    private void getPreviousProduct() {
        if(currentProductIndex>0){
            currentProductIndex--;
            setDataInLabel(currentProductIndex);
        }else {
            JOptionPane.showMessageDialog(this, "Sorry! No any previous product found");
        }
    }

    /*
     * @ Function Name      : getNextProduct
     * @ Function Params    : None
     * @ Function Purpose   : This method is used to get next data from file and set into label.
     */
    private void getNextProduct() {
        if (currentProductIndex < productList.size() - 1) {
            currentProductIndex++;
            setDataInLabel(currentProductIndex);
        }else {
            JOptionPane.showMessageDialog(this, "Sorry! No any next product found");
        }
    }

    /*
     * @ Function Name      : getLastProduct
     * @ Function Params    : None
     * @ Function Purpose   : This method is used to get last data from file and set into label.
     */
    public void getLastProduct() {
        if (productList.size()>0) {
            currentProductIndex = productList.size() - 1;
            setDataInLabel(currentProductIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Sorry! No any next product found");
        }
    }

    /*
     * @ Function Name      : setDataInLabel
     * @ Function Params    : currentProductIndex : Int
     * @ Function Purpose   : This method is used to set data based on index from file and set into label.
     */
    public void setDataInLabel(int currentProductIndex){
        idInput.setText(String.valueOf(productList.get(currentProductIndex).getId()));
        nameInput.setText(productList.get(currentProductIndex).getName());
        descInput.setText(productList.get(currentProductIndex).getDescription());
        quantityInput.setText(String.valueOf(productList.get(currentProductIndex).getQuantity()));
        priceInput.setText(String.valueOf(productList.get(currentProductIndex).getPrice()));
    }
}