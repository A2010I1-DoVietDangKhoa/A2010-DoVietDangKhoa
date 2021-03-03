package bai12_Java_Collection_Framework.bai_tap.LuyenTapSuDungArrayListLinkedListTrongJavaCollectionFramework;

public class Product implements Comparable<Product>{
    private String name;
    private int id;
    private long price;

    public Product(String name, int id, long price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public Product() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + this.id +
                ", Product name: " + this.name +
                ", Price: " + this.price;
    }

    @Override
    public int compareTo(Product p) {
        if (getId() > p.getId()) return 1;
        else if (getId() < p.getId()) return -1;
        else return 1;
    }
}
