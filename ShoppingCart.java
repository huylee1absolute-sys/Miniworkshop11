import java.util.ArrayList;
import java.util.List;

// Giỏ hàng: chứa danh sách mặt hàng, cho phép Visitor duyệt qua
public class ShoppingCart {
    private final List<Item> items = new ArrayList<>();

    public void add(Item item) { items.add(item); }

    public void remove(Item item) { items.remove(item); }

    public void accept(ItemVisitor visitor) {
        for (Item item : items) {
            item.accept(visitor);
        }
    }
}
