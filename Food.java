public class Food extends Item {
    private final String expiryDate;

    public Food(String name, long price, int quantity, String expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() { return expiryDate; }

    @Override
    public void accept(ItemVisitor visitor) { visitor.visit(this); }
}
