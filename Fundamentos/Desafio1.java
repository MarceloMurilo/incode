package Fundamentos;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class Desafio1 {
    public static void main(String[] args) {
        double total = 0;
        double contador = 0;
        double media = 0;
        int saida = 0;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.print("Digite uma nota ou -1 para sair: ");
            double nota = scan.nextDouble();

            if ( nota == -1){
                break;
            }

            if (nota <= 10 && nota >= 0) {
                total += nota;
                contador++;
            } else {
                System.out.println("=====Nota inválida!===== \n Digite uma nota entre 0 a 10");
            }
            media = total/contador;
            System.out.println("O valor total foi: " + total);
            System.out.println("O valor de números válidos foi: " + contador);

            if(contador > 0 ) {
                 System.out.printf("E a media foi %.2f%n",media);
            }

        } while(saida != -1);
        System.out.println("Byebye!");
        scan.close();


    }
}
