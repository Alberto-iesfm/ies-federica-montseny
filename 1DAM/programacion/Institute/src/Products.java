import java.util.Scanner;

public class Products {

    static Scanner scan = new Scanner(System.in);

    static void printArrays (String[] products, int[] stock, int[] price){
        for(int i = 0; i < products.length; i++){
            if (stock[i] > 0) {
                System.out.println("Producto: " + products[i] + ". Cantidad: " + stock[i] + ". Precio: " + price[i]);
            }
        }
    }
    static void selectProduct (String[] products, int[] stock, int[] price){
        while (stock[0] > 0 || stock[1] > 0 || stock[2] > 0){
            System.out.println("Seleccione un producto de la lista...");
            printArrays(products, stock, price);
            String product = scan.nextLine();
            while (!product.equals(products[0]) && !product.equals(products[1]) && !product.equals(products[2])){
                System.out.println("Producto desconocido. Por favor seleccione un producto de la lista...");
                printArrays(products, stock, price);
                product = scan.nextLine();
            }
            System.out.println("se ha entragado el producto");
            if (product.equals(products[0])){
                if (stock[0] > 0){
                    stock[0]--;
                } else {
                    System.out.println("No hay en stock");
                }
            } else if (product.equals(products[1])){
                if (stock[1] > 0) {
                    stock[1]--;
                } else {
                    System.out.println("No hay en stock");
                }
            } else {
                if (stock[2] > 0) {
                    stock[2]--;
                } else {
                    System.out.println("No hay en stock");
                }
            }
        }
    }

    public static void main(String[] args){
        String[] products = {"Iphone", "MotoG", "Sansung Galaxy"};
        int[] stock = {2, 3, 2};
        int[] price = {1000, 200, 600};
        selectProduct(products, stock, price);
    }
}
