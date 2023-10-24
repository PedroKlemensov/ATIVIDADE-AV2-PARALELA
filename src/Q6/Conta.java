package Q6;

import java.util.concurrent.atomic.AtomicInteger;

public class Conta implements Runnable {

int inici , fim, somapar =0, somainpar=0;
    AtomicInteger somaParTotal;
    AtomicInteger somaInparTotal;
int [] numeros;
    public Conta(int inici, int fim, int []numeros,AtomicInteger somaParTotal,AtomicInteger somaInparTotal) {
        this.inici = inici;
        this.fim = fim;
        this.numeros = numeros;
        this.somaParTotal = somaParTotal;
        this.somaInparTotal = somaInparTotal;

    }

    public void  run (){

        for(int i =inici; i < fim +1;i++){
            if (numeros[i] % 2 == 0) {
                somapar = somapar +numeros[i];

            } else {
                somainpar = somainpar +numeros[i];
            }
        }

        somaParTotal.getAndAdd(somapar);
        somaInparTotal.getAndAdd(somainpar);

    }

}
