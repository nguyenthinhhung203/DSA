public class OrderItem {
    private int id;
    private Product item;
    private int quanity;

    public OrderItem(int id) {
        this.id = id;
    }

    public OrderItem(int id, Product item, int quanity) {
        this.id = id;
        this.item = item;
        this.quanity = quanity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", item=" + item +
                ", quanity=" + quanity +
                '}';
    }
}
