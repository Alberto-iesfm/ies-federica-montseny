public class hightest {

    static int maximo(int a, int b, int c) {
        int max;
        if(a > b && a > c) {
            max = a;
        } else if(b > c){
            max = b;
        } else {
            max = c;
        }
        return max;

    }

    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        int max = maximo(a, b, c);

        System.out.println("el valor maximo es igual a " + max);

    }
}