package DataStructure;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Abstract class representing a food item
abstract class FoodItem {
    protected String name;

    public FoodItem(String name) {
        this.name = name;
    }

    public abstract void display(int level);
}
