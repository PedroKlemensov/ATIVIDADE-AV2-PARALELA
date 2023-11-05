package Q5;

import Q6.Conta;

public class Gerente {
    int [] valores;


    public Gerente(int[] valores) {
        this.valores = valores;
    }

    public void star() throws InterruptedException {

        // n deixei com todoas as cpus para liberar um pouco meu pc
        int numeroCPUs = Runtime.getRuntime().availableProcessors()-1;



        int[] valoresSerial = valores;

        long tempoInicialSerial = System.nanoTime();
        Sort sort = new Sort();
        sort.quickSort(valoresSerial,0,valoresSerial.length-1);
        Long tempoFinalSerial = System.nanoTime();

        for (int i = 0; i< valoresSerial.length; i++){
            System.out.print(valoresSerial[i]+" ");
        }
        System.out.println();
        System.out.println("O tempo serial foi de : "+ (tempoFinalSerial-tempoInicialSerial) );


        Thread[] threads = new Thread[numeroCPUs];
        int[] valoresParaleno = valores;
        int tamanhoParte = valores.length / numeroCPUs;

        for (int i = 0; i < numeroCPUs; i++) {
            int low = i * tamanhoParte;
            int high = (i == numeroCPUs - 1) ? valoresParaleno.length - 1 : (i + 1) * tamanhoParte - 1;
            ParallelQuickSort sorter = new ParallelQuickSort(valoresParaleno, low, high);
            threads[i] = sorter;
        }

        long tempoParalenoInical = System.nanoTime();
        for (int i =0; i<threads.length;i++){
            threads[i].start();
        }

        for (int i =0; i<threads.length;i++){
            threads[i].join();
        }
        long tempoParalenoFinal = System.nanoTime();

        for (int i = 0; i< valoresParaleno.length; i++){
            System.out.print(valoresParaleno[i]+" ");
        }
        System.out.println();
        System.out.println("O tempo serial foi de : "+ (tempoParalenoFinal-tempoParalenoInical) );

    }


}
