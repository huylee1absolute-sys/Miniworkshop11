// Visitor: mỗi loại mặt hàng có một phương thức visit
public interface ItemVisitor {
    void visit(Book book);
    void visit(Electronics electronics);
    void visit(Food food);
}
