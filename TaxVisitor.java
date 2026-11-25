// Thao tác bổ sung 2: tính thuế theo loại hàng
// (Thuế suất là giả định: Sách 5%, Điện tử 10%, Thực phẩm 8%)
public class TaxVisitor implements ItemVisitor {
    private long totalTax = 0;

    @Override public void visit(Book book) { totalTax += book.getTotal() * 5 / 100; }
    @Override public void visit(Electronics e) { totalTax += e.getTotal() * 10 / 100; }
    @Override public void visit(Food food) { totalTax += food.getTotal() * 8 / 100; }

    public long getTotalTax() { return totalTax; }
}
