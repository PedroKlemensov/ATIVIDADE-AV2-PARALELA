package Q6;

import java.util.Scanner;

public class sexta {

    public static void main(String[] args) throws InterruptedException {

        Scanner s = new Scanner(System.in);
        System.out.println("vamos ate que numero?");
        int limite = s.nextInt();



        Gerente g =  new Gerente(limite);
        g.inicio();

    }
}
