// Thao tác bổ sung 1: tính tiền giảm giá theo loại hàng
// (Tỉ lệ giảm là giả định: Sách 10%, Điện tử 5%, Thực phẩm 2%)
public class DiscountVisitor implements ItemVisitor {
    private long totalDiscount = 0;

    @Override public void visit(Book book) { totalDiscount += book.getTotal() * 10 / 100; }
    @Override public void visit(Electronics e) { totalDiscount += e.getTotal() * 5 / 100; }
    @Override public void visit(Food food) { totalDiscount += food.getTotal() * 2 / 100; }

    public long getTotalDiscount() { return totalDiscount; }
}
