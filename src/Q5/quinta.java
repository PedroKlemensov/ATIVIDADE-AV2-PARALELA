package Q5;

import java.util.Random;


public class quinta {
    public static void main(String[] args) throws InterruptedException {
        int limite = 1000;
        Random random = new Random();

        int [] valores =new int [limite];
        for (int i = 0; i < limite;i++){
            valores[i]=random.nextInt(500)+1;
        }

        for (int i = 0; i< valores.length; i++){
            System.out.print(valores[i]+" ");
        }


        Gerente g = new Gerente(valores);
        g.star();
    }
}
