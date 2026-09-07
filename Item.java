public abstract class Item {

    private String id;
    private String name;
    private long quantity;
    private double price;

    public Item(
            String id,
            String name,
            long quantity,
            double price) {

        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String getCategory();
}