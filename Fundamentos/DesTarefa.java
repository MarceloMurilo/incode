package Fundamentos;
import java.util.Scanner;

public class DesTarefa {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String tarefas = "";
        int contador = 1;

        while (true) {
            System.out.println("Bem-vindo à Lista de Tarefas!");
            System.out.println("Escolha uma opção:\n");
            System.out.println("1- Adicionar Tarefa\n" +
                    "2- Concluir Tarefa\n" +
                    "3- Visualizar Tarefa\n" +
                    "4- Excluir Tarefa\n" +
                    "5- Sair");
            int escolha = scan.nextInt();
            scan.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println("Digite a tarefa: ");
                    String novaTarefa = scan.nextLine();
                    tarefas += "ID " + contador + ": " + novaTarefa + "\n";
                    contador++;
                    break;

                case 2:
                    System.out.println("Digite o ID da tarefa para concluir:");
                    int idConc = scan.nextInt();
                    String idTarefaStrConc = "ID " + idConc + ":";

                    if (tarefas.contains(idTarefaStrConc)) {
                        // Encontrar a tarefa a ser concluída
                        int inicioTarefaConc = tarefas.indexOf(idTarefaStrConc);
                        int fimTarefaConc = tarefas.indexOf("\n", inicioTarefaConc) + 1;

                        // Verificar se a tarefa já está concluída
                        String tarefaParaConcluir = tarefas.substring(inicioTarefaConc, fimTarefaConc);
                        if (!tarefaParaConcluir.contains("(Concluída)")) {
                            // Marcar como concluída
                            tarefas = tarefas.substring(0, inicioTarefaConc) +
                                    tarefaParaConcluir.trim() + " (Concluída)\n" +
                                    tarefas.substring(fimTarefaConc);
                            System.out.println("Tarefa concluída.");
                        } else {
                            System.out.println("A tarefa já foi concluída.");
                        }
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("Lista de Tarefas:\n" + tarefas);
                    break;

                case 4:
                    System.out.println("Informe o ID da tarefa que você deseja excluir:");
                    int idconc = scan.nextInt();
                    String idTarefaStr = "ID " + idconc + ":";

                    if (tarefas.contains(idTarefaStr)) {
                        // Passo 1: Localize o índice da tarefa a ser excluída
                        int inicioTarefa = tarefas.indexOf(idTarefaStr);
                        int fimTarefa = tarefas.indexOf("\n", inicioTarefa) + 1;

                        // Passo 2: Exclua a tarefa
                        tarefas = tarefas.substring(0, inicioTarefa) + tarefas.substring(fimTarefa);

                        // Passo 3: Reatribua os IDs das tarefas restantes
                        int idAtual = idconc;
                        while (tarefas.contains("ID " + (idAtual + 1) + ":")) {
                            String idAtualStr = "ID " + (idAtual + 1) + ":";
                            int posInicio = tarefas.indexOf(idAtualStr);
                            int posFim = tarefas.indexOf("\n", posInicio);

                            // Substituir o ID antigo pelo novo ID corretamente
                            tarefas = tarefas.substring(0, posInicio) + "ID " + idAtual + ":" + tarefas.substring(posInicio + idAtualStr.length(), posFim) + tarefas.substring(posFim);
                            idAtual++;
                        }

                        System.out.println("Tarefa excluída e IDs atualizados.");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }

                    // Atualiza o contador para o próximo ID disponível
                    contador = calcularProximoIdDisponivel(tarefas);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scan.close();
                    return;
            }
        }
    }

    // Método para calcular o próximo ID disponível
    private static int calcularProximoIdDisponivel(String tarefas) {
        int maxId = 0;
        String[] linhas = tarefas.split("\n");
        for (String linha : linhas) {
            if (linha.startsWith("ID ")) {
                int id = Integer.parseInt(linha.substring(3, linha.indexOf(":")));
                if (id > maxId) {
                    maxId = id;
                }
            }
        }
        return maxId + 1;
    }
}
