public class StoreMain {

    public static void main(String[] args) {

        Phone.iphone = new Phone();

        iphone.modelo = "Iphone10";
        iphone.stock = 4;
        iphone.price = 799.99;

        Phone.samsung = new Phone();

        samsung.modelo = "Samsung S10";
        samsung.stock = 8;
        samsung.price = 599.95;

        Phone.huawei = new Phone();

        huawei.modelo = "P20";
        huawei.stock = 5;
        huawei.price = 499.90;

        iphone.print();

    }
}
