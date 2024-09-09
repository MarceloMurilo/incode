package Fundamentos;

import javax.swing.JOptionPane;
import java.util.Scanner;
public class PrimeiroPrograma {

    public static void main(String[] args) {
/// -------- Conversão dos pontos em vírgulas ----------- ///
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um salário:");
        String salario = scanner.nextLine();
        System.out.println("Digite um salário:");
        String salario2= scanner.nextLine();
        System.out.println("Digite um salário:");
        String salario3= scanner.nextLine();



//        Fazendo a conversão dos pontos e virgulas
        double salarioC = Double.parseDouble(salario.replace(",", "."));
        double salarioC2 = Double.parseDouble(salario.replace(",", "."));
        double salarioC3 = Double.parseDouble(salario.replace(",", "."));

        double soma = salarioC + salarioC2 + salarioC3;
        double media = soma / 3;

        System.out.println("A soma dos salários foi:" + soma);
        System.out.println("A média dos salários foi:" + media);
        scanner.close();



    }
}

