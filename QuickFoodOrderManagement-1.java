package assign6;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class QuickFoodOrderManagement extends Frame {
    // Main window components
    private Label welcomeLabel;
    private Button viewMenuButton;
    private Button placeOrderButton;

    // Constructor
    public QuickFoodOrderManagement() {
        // Set title and size
        setTitle("QuickFood Order Management");
        setSize(600, 400);

        // Set layout
        setLayout(new FlowLayout());

        // Welcome label
        welcomeLabel = new Label("Welcome to QuickFood!");
        add(welcomeLabel);

        // View Menu button
        viewMenuButton = new Button("View Menu");
        viewMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openMenuWindow();
            }
        });
        add(viewMenuButton);

        // Place Order button
        placeOrderButton = new Button("Place Order");
        placeOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openPlaceOrderWindow();
            }
        });
        add(placeOrderButton);

        // Center the window
        setLocationRelativeTo(null);

        // Close window listener
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // Method to open the menu window
    private void openMenuWindow() {
        MenuWindow menuWindow = new MenuWindow(this);
        menuWindow.setVisible(true);
    }

    // Method to open the place order window
    private void openPlaceOrderWindow() {
        PlaceOrderWindow placeOrderWindow = new PlaceOrderWindow(this);
        placeOrderWindow.setVisible(true);
    }

    public static void main(String[] args) {
        QuickFoodOrderManagement mainFrame = new QuickFoodOrderManagement();
        mainFrame.setVisible(true);
    }
}

// Menu window class
class MenuWindow extends Frame {
    public MenuWindow(Frame parent) {
        // Set title and size
        setTitle("Menu");
        setSize(300, 200);

        // Center the window relative to the parent
        setLocation(parent.getX() + parent.getWidth() / 2 - getWidth() / 2,
                parent.getY() + parent.getHeight() / 2 - getHeight() / 2);

        // Close window listener
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // Add menu items (Labels)
        setLayout(new FlowLayout());
        add(new Label("Pizza"));
        add(new Label("Burger"));
        add(new Label("Sushi"));

        // Back button
        Button backButton = new Button("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(backButton);
    }
}

// Place order window class
class PlaceOrderWindow extends Frame {
    public PlaceOrderWindow(Frame parent) {
        // Set title and size
        setTitle("Place Your Order");
        setSize(300, 200);

        // Center the window relative to the parent
        setLocation(parent.getX() + parent.getWidth() / 2 - getWidth() / 2,
                parent.getY() + parent.getHeight() / 2 - getHeight() / 2);

        // Close window listener
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // Form components
        setLayout(new FlowLayout());
        TextField nameField = new TextField(20);
        add(new Label("Enter your name:"));
        add(nameField);

        // Submit button
        Button submitButton = new Button("Submit Order");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display confirmation message
                String name = nameField.getText();
                String message = "Order submitted for " + name + ".";
                JOptionPane.showMessageDialog(null, message);
            }
        });
        add(submitButton);

        // Back button
        Button backButton = new Button("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(backButton);
    }
}