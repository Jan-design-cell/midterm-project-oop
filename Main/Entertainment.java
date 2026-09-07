public class Entertainment extends Item {

    public Entertainment(
            String id,
            String name,
            long quantity,
            double price) {

        super(id, name, quantity, price);
    }

    @Override
    public String getCategory() {
        return "Entertainment";
    }
}