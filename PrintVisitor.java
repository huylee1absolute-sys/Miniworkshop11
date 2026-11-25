// Thao tác 2: in thông tin giỏ hàng (mỗi loại hàng in thông tin riêng)
public class PrintVisitor implements ItemVisitor {

    @Override
    public void visit(Book book) {
        System.out.println("[Sách] " + book.getName() + " - tác giả: " + book.getAuthor()
                + " | SL: " + book.getQuantity() + " | " + book.getTotal() + " VND");
    }

    @Override
    public void visit(Electronics e) {
        System.out.println("[Điện tử] " + e.getName() + " - bảo hành: " + e.getWarrantyMonths()
                + " tháng | SL: " + e.getQuantity() + " | " + e.getTotal() + " VND");
    }

    @Override
    public void visit(Food food) {
        System.out.println("[Thực phẩm] " + food.getName() + " - HSD: " + food.getExpiryDate()
                + " | SL: " + food.getQuantity() + " | " + food.getTotal() + " VND");
    }
}
