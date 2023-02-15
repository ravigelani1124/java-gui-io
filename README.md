# Java GUI I/O

Developed an application to manage the product details using a binary file. The application should save the information of each field of the product using binary format and each record should be of the same size. Possible operations and sample GUI is provided for your reference.

![Screenshot 2023-02-14 at 2 51](https://user-images.githubusercontent.com/16309069/218847546-b94e7847-b541-412e-8b78-1a4b52c41890.png)

  File menu has “Exit” menu item, so when user selects this option, it will terminate theapplication.
  
  Product menu has two menu items:
  o “Add/Update” menu item, so when user selects this option, it will display Add/Updatewindow to the user (shown below).
  o “Find/Display” menu item, so when user selects this option, it will display theFind/Display window to the user (shown below).
  
 ![Screenshot 2023-02-14 at 2 52](https://user-images.githubusercontent.com/16309069/218847840-8225ba2f-eb16-40ea-8b26-4d759602ae72.png)
    
Program the buttons to perform following operations:

 Add – Should add the information of new product to the file. Product ID should be unique,quantity in hand and unit price should be number and above 0       and name is required. 

 First – Should read the first record stored in the file and display the details of it in the controls.

 Previous – if possible, should read the previous record to the current record stored in the fileand display the details of it in the controls.

 Next – if possible, should read the next record to the current record stored in the file and displaythe details of it in the controls.

 Last – Should read the last record stored in the file and display the details of it in the controls.

 Update – should update the information of currently displayed record on the GUI.
      
![Screenshot 2023-02-14 at 3 00](https://user-images.githubusercontent.com/16309069/218848432-4c89a646-8df3-4309-923e-3cd6fea4df0d.png)

Program the Find/Display button to perform following operation:

 Depending upon which radio button is selected, it should read the product details from the fileand display in the JTable/JTextArea.

 If “All” radio button is selected, it should display all the products stored in the file. 

 If “Keyword” radio button is selected, it should display all the products stored in the file whichcontains the specified keyword in their name.

 If “Price Range” radio button is selected, it should display all the products stored in the filewhich has the price specified between to and from.





https://user-images.githubusercontent.com/16309069/218857242-95992090-55a6-4e73-9209-68303c740cc5.mov



