package DesafioEt02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento();  // Cria a instância de Estacionamento apenas uma vez

        int opcao;

        do {
            System.out.println("\nBem-vindo ao sistema de estacionamento!");
            System.out.println("Por favor, escolha uma das opções abaixo:");
            System.out.println("1. Emitir ticket");
            System.out.println("2. Pagar ticket");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Exibir informações do ticket");
            System.out.println("5. Sair");

            opcao = scanner.nextInt();  // Lê a opção do usuário

            switch (opcao) {
                case 1:
                    System.out.print("Digite as horas que o ticket será válido: ");
                    int horas = scanner.nextInt();
                    estacionamento.emitirTicket(horas);  // Usa a mesma instância de Estacionamento para emitir o ticket
                    break;

                case 2:
                    System.out.println("Digite o número do seu ticket para pagar:");
                    int numero = scanner.nextInt();
                    estacionamento.pagarTicket(numero);  // Usa a mesma instância de Estacionamento para pagar o ticket
                    break;

                case 3:
                    estacionamento.exibirSaldo();  // Consulta o saldo acumulado
                    break;

                case 4:
                    estacionamento.exibirTickets();  // Exibe todos os tickets emitidos
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }

        } while (opcao != 5);  // Continua exibindo o menu até que o usuário escolha a opção 5 (Sair)

        scanner.close();  // Fecha o scanner
    }
}
