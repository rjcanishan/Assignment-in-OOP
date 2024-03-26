package DataStructure;
import java.util.List;
import java.util.ArrayList;

class Category extends FoodItem {
    private List<FoodItem> items;

    public Category(String name) {
        super(name);
        this.items = new ArrayList<>();
    }

    public void addFoodItem(FoodItem item) {
        items.add(item);
    }

    public List<FoodItem> getItems() {
        return items;
    }

    @Override
    public void display(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(name + ":");
        for (FoodItem item : items) {
            item.display(level + 1);
        }
    }
}
