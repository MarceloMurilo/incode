package Fundamentos;
import java.util.Scanner;
public class Ifelse {
 
        public static void main(String[] args) {
            Scanner entrada = new Scanner(System.in);

            double media = entrada.nextDouble();

            if(media >= 7.0){
                System.out.println("Aprovado!");
            }

            entrada.close();





        }
    }

