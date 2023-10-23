package Q2;

import java.util.Random;


class segunda {
    public static void main(String[] args) throws InterruptedException {
        long tempoicio = System.nanoTime();
        double limite = 5;

        achaprimo tarefa1 = new achaprimo(limite);
        achaprimo tarefa2 = new achaprimo(limite);

        Thread primo1 = new Thread(tarefa1);
        Thread primo2 = new Thread(tarefa2);



        primo1.start();
        primo2.start();

        primo1.join();
        primo2.join();

        long numeroPrimo1 = tarefa1.getResultado();
        long numeroPrimo2 = tarefa2.getResultado();

        long chave= numeroPrimo1*numeroPrimo2;

        long tempoPrimo1 = tarefa1.tempofinal-tarefa1.tempoicio;
        long tempoPrimo2 = tarefa2.tempofinal-tarefa2.tempoicio;
        long tempoTotal = System.nanoTime()-tempoicio;

        System.out.println("sua chave e "+chave);
        System.out.println("com a thread 1 levando um tem de "+ tempoPrimo1 );
        System.out.println("e a thread 2 levando um tem de "+ tempoPrimo2 );
        System.out.println("e um tempo total de "+ tempoTotal );


        // muito interesente ver certos tempos de threads muitos pertos e outros muito longes
    }

}

class achaprimo implements Runnable {

    double limite;
    long resultado;
    long tempoicio;
    long tempofinal;

    achaprimo(double limite ) {
        this.limite = limite;
    }

    public long getResultado() {
        return resultado;
    }

    @Override
    public void run() {
        tempoicio = System.nanoTime();

        Random random = new Random();
        while (true){
            long numero = (long) random.nextDouble(Math.pow(10,limite)+1);
            if (primo(numero)){
                System.out.println("numero primo: "+numero+" achado");
                resultado = numero;
                tempofinal = System.nanoTime();
                break;
            }
        }



    }

    private boolean primo(double numero) {
        if (numero <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }

        return true;

    }


}