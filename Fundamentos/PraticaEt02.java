package Fundamentos;
import java.util.Scanner;

public class PraticaEt02 {
    public static void main(String[] args) {
        String tarefas = "";
        int idCounter = 1; // Contador para os IDs
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Bem-vindo à Lista de Tarefas\nEscolha uma das opções:");
            System.out.println("1- Adicionar Tarefa\n" +
                    "2- Concluir Tarefa\n" +
                    "3- Visualizar Tarefas na lista\n" +
                    "4- Sair");

            int escolha = input.nextInt();
            input.nextLine(); // Consumir a nova linha

            switch (escolha) {
                case 1:
                    System.out.println("Digite a tarefa: ");
                    String novaTarefa = input.nextLine();
                    tarefas += "ID " + idCounter + ": " + novaTarefa + "\n";
                    idCounter++;
                    break;

                case 2:
                    System.out.println("Digite o ID da tarefa que deseja concluir: ");
                    String idConcluir = input.nextLine();
                    if (tarefas.contains("ID " + idConcluir + ":")) {
                        String tarefaConcluir = tarefas.substring(tarefas.indexOf("ID " + idConcluir + ":"), tarefas.indexOf("\n", tarefas.indexOf("ID " + idConcluir + ":")) + 1);
                        tarefas = tarefas.replace(tarefaConcluir, tarefaConcluir.trim() + " (Concluída)\n");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("Aqui está a lista de tarefas:\n" + tarefas);
                    break;

                case 4:
                    System.out.println("Saindo...");
                    input.close();
                    return;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
