public class Main {
    public static void main(String[] args) {
        // Tạo giỏ hàng với 3 loại mặt hàng
        ShoppingCart cart = new ShoppingCart();
        Book book = new Book("Design Patterns", 450_000, 2, "GoF");
        Electronics phone = new Electronics("Tai nghe Bluetooth", 1_200_000, 1, 12);
        Food milk = new Food("Sữa tươi", 30_000, 5, "2026-12-30");
        cart.add(book);
        cart.add(phone);
        cart.add(milk);

        // Thao tác 1: in giỏ hàng
        System.out.println("=== Giỏ hàng ===");
        cart.accept(new PrintVisitor());

        // Thao tác 2: tính tổng tiền
        TotalPriceVisitor total = new TotalPriceVisitor();
        cart.accept(total);
        System.out.println("Tổng tiền hàng: " + total.getTotal() + " VND");

        // Thao tác bổ sung 1: giảm giá
        DiscountVisitor discount = new DiscountVisitor();
        cart.accept(discount);
        System.out.println("Giảm giá: " + discount.getTotalDiscount() + " VND");

        // Thao tác bổ sung 2: thuế
        TaxVisitor tax = new TaxVisitor();
        cart.accept(tax);
        System.out.println("Thuế: " + tax.getTotalTax() + " VND");

        long pay = total.getTotal() - discount.getTotalDiscount() + tax.getTotalTax();
        System.out.println("Thanh toán: " + pay + " VND");

        // Xóa một mặt hàng rồi tính lại tổng
        cart.remove(milk);
        TotalPriceVisitor total2 = new TotalPriceVisitor();
        cart.accept(total2);
        System.out.println("\nSau khi xóa '" + milk.getName() + "', tổng tiền hàng: "
                + total2.getTotal() + " VND");
    }
}
