
package quickfoodordermanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class QuickFoodOrderManagement extends Frame {
   
    private Label welcomeLabel;
    private Button viewMenuButton;
    private Button placeOrderButton;

   
    public QuickFoodOrderManagement() {
       
        setTitle("QuickFood Order Management");
        setSize(600, 400);

      
        setLayout(new FlowLayout());

       
        welcomeLabel = new Label("Welcome to QuickFood!!");
         welcomeLabel.setForeground(Color.blue);
        add(welcomeLabel);

       
        viewMenuButton = new Button("View Menu");
         viewMenuButton.setForeground(Color.GREEN);
        viewMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openMenuWindow();
            }
        });
        add(viewMenuButton);

       
        placeOrderButton = new Button("Place Order");
         placeOrderButton.setForeground(Color.GREEN);
        placeOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openPlaceOrderWindow();
            }
        });
        add(placeOrderButton);

       
        setLocationRelativeTo(null);

       
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    
    private void openMenuWindow() {
        MenuWindow menuWindow = new MenuWindow(this);
        menuWindow.setVisible(true);
    }

  
    private void openPlaceOrderWindow() {
        PlaceOrderWindow placeOrderWindow = new PlaceOrderWindow(this);
        placeOrderWindow.setVisible(true);
    }

    public static void main(String[] args) {
       QuickFoodOrderManagement mainFrame = new QuickFoodOrderManagement();
        mainFrame.setVisible(true);
    }
}


class MenuWindow extends Frame {
    public MenuWindow(Frame parent) {
     
        setTitle("Menu");
        setSize(300, 200);

        
        setLocation(parent.getX() + parent.getWidth() / 2 - getWidth() / 2,
                parent.getY() + parent.getHeight() / 2 - getHeight() / 2);

       
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

       
        setLayout(new FlowLayout());
       // Label l5=new Label("List Of Items:");
       add(new Label("List Of Items:"));
        add(new Label("Pizza"));
        add(new Label("Burger"));
        add(new Label("Sushi"));
        

      
        Button backButton = new Button("Close");
        backButton.setForeground(Color.pink);
        backButton .setBounds(150, 100, 50, 20);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(backButton);
    }
}


class PlaceOrderWindow extends Frame {
    public PlaceOrderWindow(Frame parent) {
       
        setTitle("Place Your Order");
        setSize(300, 200);

        
        setLocation(parent.getX() + parent.getWidth() / 2 - getWidth() / 2,
                parent.getY() + parent.getHeight() / 2 - getHeight() / 2);

       
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

       
        setLayout(new FlowLayout());
        TextField nameField = new TextField(20);
        add(new Label("Enter your name:"));
        add(nameField);

    
        Button submitButton = new Button("Submit Order");
         submitButton.setForeground(Color.blue);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String name = nameField.getText();
                String message = "thank you " + name + "."+"your order has been submitted"+".";
                JOptionPane.showMessageDialog(null, message);
            }
        });
        add(submitButton);

      
        Button backButton = new Button("Close");
        backButton.setForeground(Color.pink);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(backButton);
    }
}
