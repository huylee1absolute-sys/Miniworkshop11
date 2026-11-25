# README: Giỏ hàng online (Visitor Pattern)

Giải thích đơn giản: có những lớp nào, ai kế thừa ai, ai gọi ai, và các mũi tên trong sơ đồ nghĩa là gì.

## 1. Ý tưởng

Trong giỏ hàng có nhiều loại hàng (sách, đồ điện tử, thực phẩm). Có nhiều việc cần làm với giỏ (in, tính tiền, giảm giá, tính thuế), và mỗi việc xử lý mỗi loại hàng một kiểu.

Cách làm: **món hàng chỉ giữ thông tin của nó. Mỗi việc cần làm là một lớp riêng gọi là Visitor** (như một nhân viên đến duyệt giỏ). Muốn thêm việc mới thì thêm một Visitor mới, không phải sửa món hàng.

## 2. Các lớp

| Lớp | Là gì |
|---|---|
| `Item` | Lớp cha của mọi món hàng: tên, đơn giá, số lượng, `getTotal()` |
| `Book` | Sách (thêm: tác giả) |
| `Electronics` | Đồ điện tử (thêm: số tháng bảo hành) |
| `Food` | Thực phẩm (thêm: hạn sử dụng) |
| `ItemVisitor` | Interface: quy định mọi Visitor phải có `visit(Book)`, `visit(Electronics)`, `visit(Food)` |
| `TotalPriceVisitor` | Tính tổng tiền hàng |
| `PrintVisitor` | In thông tin giỏ hàng |
| `DiscountVisitor` | Tính tiền giảm giá (thao tác bổ sung) |
| `TaxVisitor` | Tính thuế (thao tác bổ sung) |
| `ShoppingCart` | Giỏ hàng: chứa danh sách `Item`, có `add`, `remove`, `accept` |
| `Main` | Chương trình chạy thử |

## 3. Ai kế thừa ai

```
Item (lớp cha)
 ├── Book          extends Item
 ├── Electronics   extends Item
 └── Food          extends Item

ItemVisitor (interface)
 ├── TotalPriceVisitor   implements ItemVisitor
 ├── PrintVisitor        implements ItemVisitor
 ├── DiscountVisitor     implements ItemVisitor
 └── TaxVisitor          implements ItemVisitor
```

`ShoppingCart` và `Main` không kế thừa lớp nào.

## 4. Ai gọi ai

Khi chạy `cart.accept(visitor)`:

```
1. Main      gọi   cart.accept(visitor)
2. Cart      gọi   item.accept(visitor)      (cho từng món hàng trong giỏ)
3. Item      gọi   visitor.visit(this)       (this chính là Book / Electronics / Food đó)
4. Visitor   chạy  visit(Book) hoặc visit(Electronics) hoặc visit(Food) tương ứng
5. Visitor   gọi   item.getTotal() ... để lấy dữ liệu cần tính
```

Vòng đi: **Main → Cart → Item → Visitor → (lấy dữ liệu từ) Item.**

Tại sao `Item` gọi ngược `visitor.visit(this)`? Vì chỉ món hàng mới biết chắc nó là loại nào. Nhờ vậy Visitor tự chạy đúng phương thức theo loại hàng mà không cần `if`. Cơ chế này gọi là double dispatch (xem `02-sequence-double-dispatch.puml`).

## 5. Ý nghĩa các mũi tên trong sơ đồ

| Hình | PlantUML | Ý nghĩa | Ví dụ |
|---|---|---|---|
| Nét liền, đầu tam giác rỗng | `<\|--` | Kế thừa (extends) | `Book` → `Item` |
| Nét đứt, đầu tam giác rỗng | `<\|..` | Hiện thực interface (implements) | `TotalPriceVisitor` → `ItemVisitor` |
| Nét liền, đầu hình thoi rỗng | `o--` | Chứa (bên hình thoi là cái "hộp") | `ShoppingCart` chứa nhiều `Item` |
| Nét đứt, đầu mũi tên mở | `..>` | Có dùng / có gọi | `Item` dùng `ItemVisitor` |
| Đường chấm không mũi tên | `..` | Nối ghi chú vào lớp | Ghi chú về thêm loại hàng mới |

Các ký hiệu trong ô lớp: `+` là public, `-` là private, `{abstract}` là phương thức lớp con phải tự cài, `0..*` là từ 0 đến nhiều.

Màu trong sơ đồ: xanh dương = món hàng, cam = Visitor, xanh lá = giỏ hàng, vàng = lớp mới thêm ở sơ đồ mở rộng.

## 6. Thêm chức năng thì sao

- **Thêm việc xử lý mới** (ví dụ xuất file): tạo thêm một lớp `implements ItemVisitor`. Không sửa mã cũ. Dễ.
- **Thêm loại hàng mới** (ví dụ `Clothing`): tạo lớp `Clothing extends Item`, thêm `visit(Clothing)` vào `ItemVisitor`, rồi sửa cả 4 Visitor. Khó hơn.

## 7. Các file

Code: `Item`, `Book`, `Electronics`, `Food`, `ItemVisitor`, `TotalPriceVisitor`, `PrintVisitor`, `DiscountVisitor`, `TaxVisitor`, `ShoppingCart`, `Main` (đều `.java`).
Sơ đồ: `01-class-diagram-thiet-ke-goc.puml`, `02-sequence-double-dispatch.puml`, `03-class-diagram-mo-rong.puml` (kèm ảnh trong `diagrams/`).
Báo cáo: `REPORT.md`.

Chạy thử:

```bash
javac -encoding UTF-8 *.java
java -Dfile.encoding=UTF-8 Main
```
