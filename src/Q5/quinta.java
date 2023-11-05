package Q5;

import java.util.Random;


public class quinta {
    public static void main(String[] args) throws InterruptedException {

        //se eu almentar o limite em mais um zero meu computando n conseque fazer o metodo paralelo
        int limite = 1000;
        Random random = new Random();

        int [] valores =new int [limite];
        for (int i = 0; i < limite;i++){
            valores[i]=random.nextInt(1000)+1;
        }




        Gerente g = new Gerente(valores);
        g.star();
    }
}
