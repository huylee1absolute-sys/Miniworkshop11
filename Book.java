public class Book extends Item {
    private final String author;

    public Book(String name, long price, int quantity, String author) {
        super(name, price, quantity);
        this.author = author;
    }

    public String getAuthor() { return author; }

    @Override
    public void accept(ItemVisitor visitor) { visitor.visit(this); }
}
