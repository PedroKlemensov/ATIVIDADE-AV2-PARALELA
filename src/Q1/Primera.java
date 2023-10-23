package Q1;

import java.util.Random;
import java.util.Scanner;


class Primeira {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner s = new Scanner(System.in);

        int a,b,c;


        System.out.println("Digite \"M\" para digitar os valoes de a b c separadamente ou qualquer outra tecla para numeros aleatorio");
        if (s.next().equals("M")){
             a = s.nextInt();
             b = s.nextInt();
             c = s.nextInt();
        }else {
             a = random.nextInt(500) + 1;
             b = random.nextInt(500) + 1;
             c = random.nextInt(500) + 1;
        }

        System.out.println("a:" +a+ " b:" +b+ " c:" +c);

        int delta = b*b-4*a*c;
        System.out.println("delta igual a :"+delta);
        if (delta >= 0){

            Thread contax1 = new Thread(new calculobaskara(a,b,c,true));
            Thread contax2 = new Thread(new calculobaskara(a,b,c,false));

            contax1.start();
            contax2.start();
        }else {System.out.println("O delta é negativo. Equação não possui raízes reais.");}

    }
}

class calculobaskara implements Runnable {

    int a, b, c;
    boolean metodo;

    calculobaskara(int a,int b,int c,boolean metodo){
        this.a = a;
        this.b = b;
        this.c = c;
        this.metodo = metodo;

    }


    public void run() {
        if(metodo) {
            System.out.println("x1:" +(-b+Math.sqrt(b*b-4*a*c))/(2*a));
        } else {
            System.out.println("x2:" +(-b-Math.sqrt(b*b-4*a*c))/(2*a));
        }
    }
}