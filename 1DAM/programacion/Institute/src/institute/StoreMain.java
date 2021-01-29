public class StoreMain {

    public static void main(String[] args) {

        Telephone.iphone = new Telephone();

        iphone.modelo = "Iphone10";
        iphone.stock = 4;
        iphone.price = 799.99;

        Telephone.samsung = new Telephone();

        samsung.modelo = "Samsung S10";
        samsung.stock = 8;
        samsung.price = 599.95;

        Telephone.huawei = new Telephone();

        huawei.modelo = "P20";
        huawei.stock = 5;
        huawei.price = 499.90;

        iphone.print();

    }
}
