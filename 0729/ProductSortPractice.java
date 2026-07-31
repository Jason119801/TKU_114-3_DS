class Product {
    String id, name; int price, stock;
    public Product(String id, String name, int price, int stock) {
        this.id=id; this.name=name; this.price=price; this.stock=stock;
    }
    public String toString() { return id + " " + name + " $" + price; }
}
public class ProductSortPractice {
    public static void main(String[] args) {
        Product[] p = { new Product("P1", "A", 100, 5), new Product("P2", "B", 50, 2) };
        for (int i = 1; i < p.length; i++) {
            Product key = p[i];
            int pos = i - 1;
            while (pos >= 0 && p[pos].price > key.price) {
                p[pos + 1] = p[pos];
                pos--;
            }
            p[pos + 1] = key;
        }
        for (Product pr : p) System.out.println(pr);
    }
}