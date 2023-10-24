package Q6;

import java.util.concurrent.atomic.AtomicInteger;

public class Gerente {
    int limite;
    public Gerente (int limite){
        this.limite = limite;
    }

    public void inicio() throws InterruptedException {
        int numeroCPUs = Runtime.getRuntime().availableProcessors();
        int [] numeros = new int [limite];

          for (int i = 1 ;i < limite+1 ; i ++ ){
            numeros[i-1] = i;
        }

        // esse variavel atomica foi ideia do gbt e eu adorei como para adicinar ela soma o
        // sendo o atoic uma solulao pensada pro uso de varias thread assim n tendo risco da condiao de corrida
        AtomicInteger somaParTotal = new AtomicInteger(0);
        AtomicInteger somaInparTotal = new AtomicInteger(0);

        Thread[] threads = new Thread[numeroCPUs];

        int tamanhoVetor = numeros.length;
        int tamanhoParte = tamanhoVetor / numeroCPUs;

        for (int i = 0; i < numeroCPUs; i++) {
            int inicio = i * tamanhoParte;
            int fim = (i == numeroCPUs - 1) ? tamanhoVetor : (i + 1) * tamanhoParte;
            threads[i] = new Thread(new Conta(inicio, fim - 1, numeros, somaParTotal,somaInparTotal));
        }

        for (int i =0; i<threads.length;i++){
            threads[i].start();
        }

        for (int i =0; i<threads.length;i++){
            threads[i].join();
        }


        System.out.println("a soma par total e de :" + somaParTotal+" e a soma impar total deu :" + somaInparTotal);
    }

}
