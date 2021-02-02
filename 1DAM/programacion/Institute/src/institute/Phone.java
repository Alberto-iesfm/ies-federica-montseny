package institute;

public class Phone {

    private String modelo;
    private int stock;
    private double price;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Phone(){
        this.modelo = modelo;
        this.stock = stock;
        this.price = price;
    }
    public void print(){
        System.out.println(modelo + stock + price);
    }

}
