// Thao tác 1: tính tổng tiền hàng
public class TotalPriceVisitor implements ItemVisitor {
    private long total = 0;

    @Override public void visit(Book book) { total += book.getTotal(); }
    @Override public void visit(Electronics e) { total += e.getTotal(); }
    @Override public void visit(Food food) { total += food.getTotal(); }

    public long getTotal() { return total; }
}
