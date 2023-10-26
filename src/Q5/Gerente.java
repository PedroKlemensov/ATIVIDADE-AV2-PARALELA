package Q5;

import Q6.Conta;

public class Gerente {
    int [] valores;


    public Gerente(int[] valores) {
        this.valores = valores;
    }

    public void star() throws InterruptedException {

        int numeroCPUs = Runtime.getRuntime().availableProcessors();


        Thread[] threads = new Thread[numeroCPUs];

        int tamanhoParte = valores.length / numeroCPUs;

        for (int i = 0; i < numeroCPUs; i++) {
            int inicio = i * tamanhoParte;
            int fim = (i == numeroCPUs - 1) ? valores.length : (i + 1) * tamanhoParte;
            //threads[i] = new Thread(new );
        }

        for (int i =0; i<threads.length;i++){
            threads[i].start();
        }

        for (int i =0; i<threads.length;i++){
            threads[i].join();
        }

    }


}
