package Crops;
class Crop {
    String name;
    int quantity;

    public Crop(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}


public class Crops {
    private static Crop[] crops = new Crop[10]; 
    private static int cropCount = 0; 

    public static void addCrop(String name, int quantity) {
        if (cropCount < crops.length) {
            crops[cropCount] = new Crop(name, quantity);
            cropCount++;
            System.out.println("New Crop added: " + name);
        } else {
            System.out.println("Inventory full, cannot add more crops.");
        }
    }

 
    public static void updateQuantity(String name, int newQuantity) {
        for (Crop crop : crops) {
            if (crop != null && crop.name.equals(name)) {
                crop.quantity = newQuantity;
                System.out.println("Quantity updated for " + name);
                return;
            }
        }
        System.out.println("Crop not found in inventory: " + name);
    }

    
    public static void viewInventory() {
        System.out.println("Current Inventory:");
        for (Crop crop : crops) {
            if (crop != null) {
                System.out.println(crop.name + ": " + crop.quantity);
            }
        }
    }

    
    public static void main(String[] args) {
        addCrop("Wheat", 100);
        addCrop("Corn", 50);
        
        updateQuantity("Wheat", 150);

        viewInventory();
    }
}