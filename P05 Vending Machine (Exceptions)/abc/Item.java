import java.util.Objects;

public class Item {

    private String description;

    private int expirationDate;

    public Item(String description, int expirationDate) {
        try {
            if (description != null && description.length() > 0) {
                this.description = description;
            }else {
                throw new IllegalArgumentException("description exception");
            }
            if (expirationDate > 0) {
                this.expirationDate = expirationDate;
            }else throw new IllegalArgumentException("expirationDate exception");
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }

    }

    public String getDescription() {
        return description;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public void setDescription(String description) {
        if (description == null || description.equals("")){
            throw new IllegalArgumentException("description is null or blank");
        }
        this.description = description;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return this.description + ": " + this.expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        Item item;
        if (o instanceof Item){
            item = (Item) o;
            if (item.getDescription() == null) {
                return false;
            }
        }else {
            return false;
        }
        return item.getDescription().equals(this.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}
