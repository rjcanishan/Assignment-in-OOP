package DataStructure;

//Leaf subclass representing individual food items
class Ingredient extends FoodItem {
 public Ingredient(String name) {
     super(name);
 }

 @Override
 public void display(int level) {
     for (int i = 0; i < level; i++) {
         System.out.print("  ");
     }
     System.out.println("- " + name);
 }
}