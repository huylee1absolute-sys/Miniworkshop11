public class Electronics extends Item {
    private final int warrantyMonths;

    public Electronics(String name, long price, int quantity, int warrantyMonths) {
        super(name, price, quantity);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() { return warrantyMonths; }

    @Override
    public void accept(ItemVisitor visitor) { visitor.visit(this); }
}
