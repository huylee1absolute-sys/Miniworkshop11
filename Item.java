// Lớp cha của các mặt hàng (Element trong Visitor Pattern)
public abstract class Item {
    private final String name;
    private final long price;   // đơn giá (VND)
    private final int quantity;

    public Item(String name, long price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public long getPrice() { return price; }
    public int getQuantity() { return quantity; }

    // Thành tiền = đơn giá x số lượng
    public long getTotal() { return price * quantity; }

    public abstract void accept(ItemVisitor visitor);
}
