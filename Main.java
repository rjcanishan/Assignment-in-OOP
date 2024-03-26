package DataStructure;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

//Main class to handle user interaction
public class Main {
 public static void main(String[] args) {
     // Instantiate food items and categories
     Category food = new Category("Food");
     Category fruits = new Category("Fruits");
     Category beverages = new Category("Beverages");
     Category vegetables = new Category("Vegetables");
     Category condiments = new Category("Condiments");
     Category dairy = new Category("Dairy Products");
     Category poultry = new Category("Poultry");

     food.addFoodItem(new Ingredient("Apple"));
     food.addFoodItem(new Ingredient("Banana"));
     food.addFoodItem(new Ingredient("Beef"));
     food.addFoodItem(new Ingredient("Chicken"));
     food.addFoodItem(new Ingredient("Rice"));
     food.addFoodItem(new Ingredient("Fish"));

     fruits.addFoodItem(new Ingredient("Orange Juice"));
     fruits.addFoodItem(new Ingredient("Grapes"));
     fruits.addFoodItem(new Ingredient("Pineapple"));

     beverages.addFoodItem(new Ingredient("Shake"));
     beverages.addFoodItem(new Ingredient("Yoghurt Cream"));
     beverages.addFoodItem(new Ingredient("Milk"));

     vegetables.addFoodItem(new Ingredient("Spinach"));
     vegetables.addFoodItem(new Ingredient("Tomato"));
     vegetables.addFoodItem(new Ingredient("Carrots"));

     condiments.addFoodItem(new Ingredient("Butter"));
     condiments.addFoodItem(new Ingredient("Soy Sauce"));
     condiments.addFoodItem(new Ingredient("Fish Sauce"));

     dairy.addFoodItem(new Ingredient("Cheese"));
     dairy.addFoodItem(new Ingredient("Milk"));

     poultry.addFoodItem(new Ingredient("Egg"));
     poultry.addFoodItem(new Ingredient("Shrimp"));

     food.addFoodItem(fruits);
     food.addFoodItem(beverages);
     food.addFoodItem(vegetables);
     food.addFoodItem(condiments);
     food.addFoodItem(dairy);
     food.addFoodItem(poultry);

  // Prompt the user for display preference
     Scanner scanner = new Scanner(System.in);
     System.out.println("How would you like to display the hierarchy?");
     System.out.println("1. ASCII Tree");
     System.out.println("2. Bullet Form");
     System.out.print("Enter your choice: ");
     int choice = scanner.nextInt();

  // Display the hierarchy based on user choice
     switch (choice) {
         case 1:
             food.display(0); // Display as ASCII tree
             break;
         case 2:
             displayBullet(food); // Display in bullet form
             break;
         default:
             System.out.println("Invalid choice. Displaying as ASCII tree by default.");
             food.display(0);
     }
 }

 // Method to display hierarchy in bullet form
 private static void displayBullet(Category category) {
     displayBulletHelper(category, "- ");
 }

 private static void displayBulletHelper(FoodItem item, String prefix) {
     if (item instanceof Category) {
         Category category = (Category) item;
         System.out.println(prefix + category.name + ":");
         for (FoodItem foodItem : category.getItems()) {
             if (foodItem != null) {
                 displayBulletHelper(foodItem, prefix + "  ");
             }
         }
     } else {
         System.out.println(prefix + item.name);
     }
 }
}