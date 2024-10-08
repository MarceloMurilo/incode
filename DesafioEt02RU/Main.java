package DesafioEt02RU;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Classe Refeicao
class Refeicao {
    private String salada;
    private String pratoPrincipal;
    private String sobremesa;

    public Refeicao(String salada, String pratoPrincipal, String sobremesa) {
        this.salada = salada;
        this.pratoPrincipal = pratoPrincipal;
        this.sobremesa = sobremesa;
    }

    @Override
    public String toString() {
        return "Salada: " + salada + ", Prato Principal: " + pratoPrincipal + ", Sobremesa: " + sobremesa;
    }
}

public class Main {
    public static void main(String[] args) {
        // Listas para armazenar os alimentos
        ArrayList<String> listaDeSaladas = new ArrayList<>();
        ArrayList<String> listaDePratos = new ArrayList<>();
        ArrayList<String> listaDeSobremesas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Cardápio semanal: Map para armazenar refeições por dia e turno
        Map<String, Map<String, Refeicao>> cardapioSemanal = new HashMap<>();
        String[] dias = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta"};
        String[] turnos = {"Almoço", "Jantar"};

        // Inicializar o cardápio semanal com "Refeição Padrão"
        for (String dia : dias) {
            Map<String, Refeicao> turnosDoDia = new HashMap<>();
            for (String turno : turnos) {
                turnosDoDia.put(turno, new Refeicao("Salada P", "Prato P", "Sobremesa P"));
            }
            cardapioSemanal.put(dia, turnosDoDia);
        }

        while (true) {
            System.out.println("\nMenu Principal:");
            System.out.println("1 - Menu da Semana");
            System.out.println("2 - Alimentos");
            System.out.println("3 - Montar Refeição");
            System.out.println("4 - Atualizar Menu");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    // MENU DA SEMANA
                    System.out.println("Cardápio Semanal:");
                    for (String dia : dias) {
                        System.out.println(dia + ":");
                        for (String turno : turnos) {
                            System.out.println("  " + turno + ": " + cardapioSemanal.get(dia).get(turno));
                        }
                    }
                    break;

                case 2:
                    // CADASTRAR ALIMENTOS
                    System.out.println("\nEscolha o que você quer fazer com alimentos:");
                    System.out.println("1 - Listar");
                    System.out.println("2 - Cadastrar");
                    System.out.print("Escolha uma opção: ");
                    int tipoAlimento = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    if (tipoAlimento == 1) {
                        // Verificar e exibir mensagem se cada lista estiver vazia
                        if (listaDeSaladas.isEmpty()) {
                            System.out.println("Não há saladas cadastradas.");
                        } else {
                            System.out.println("Saladas cadastradas: " + listaDeSaladas);
                        }

                        if (listaDePratos.isEmpty()) {
                            System.out.println("Não há pratos principais cadastrados.");
                        } else {
                            System.out.println("Pratos principais cadastrados: " + listaDePratos);
                        }

                        if (listaDeSobremesas.isEmpty()) {
                            System.out.println("Não há sobremesas cadastradas.");
                        } else {
                            System.out.println("Sobremesas cadastradas: " + listaDeSobremesas);
                        }
                    } else if (tipoAlimento == 2) {
                        // Cadastrar alimentos
                        System.out.println("\nEscolha o tipo de alimento para cadastrar:");
                        System.out.println("1 - Salada");
                        System.out.println("2 - Prato Principal");
                        System.out.println("3 - Sobremesa");
                        int opcaoCadastro = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha

                        switch (opcaoCadastro) {
                            case 1:
                                System.out.print("Digite o nome da salada: ");
                                String salada = scanner.nextLine();
                                listaDeSaladas.add(salada);
                                System.out.println("Salada cadastrada com sucesso!");
                                break;

                            case 2:
                                System.out.print("Digite o nome do prato principal: ");
                                String prato = scanner.nextLine();
                                listaDePratos.add(prato);
                                System.out.println("Prato principal cadastrado com sucesso!");
                                break;

                            case 3:
                                System.out.print("Digite o nome da sobremesa: ");
                                String sobremesa = scanner.nextLine();
                                listaDeSobremesas.add(sobremesa);
                                System.out.println("Sobremesa cadastrada com sucesso!");
                                break;

                            default:
                                System.out.println("Opção inválida! Escolha 1, 2 ou 3.");
                                break;
                        }
                    } else {
                        System.out.println("Opção inválida! Escolha 1 ou 2.");
                    }
                    break;

                case 3:
                    // MONTAR REFEIÇÃO
                    if (listaDeSaladas.isEmpty() || listaDePratos.isEmpty() || listaDeSobremesas.isEmpty()) {
                        System.out.println("Não é possível montar a refeição. Certifique-se de que todos os tipos de alimentos (salada, prato principal e sobremesa) estejam cadastrados.");
                    } else {
                        System.out.println("\nMontar Refeição:");

                        // Escolher Salada
                        System.out.println("Escolha uma salada:");
                        for (int i = 0; i < listaDeSaladas.size(); i++) {
                            System.out.println((i + 1) + " - " + listaDeSaladas.get(i));
                        }
                        System.out.print("Digite o número da salada: ");
                        int escolhaSalada = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha
                        String saladaEscolhida = listaDeSaladas.get(escolhaSalada - 1);

                        // Escolher Prato Principal
                        System.out.println("\nEscolha um prato principal:");
                        for (int i = 0; i < listaDePratos.size(); i++) {
                            System.out.println((i + 1) + " - " + listaDePratos.get(i));
                        }
                        System.out.print("Digite o número do prato principal: ");
                        int escolhaPrato = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha
                        String pratoEscolhido = listaDePratos.get(escolhaPrato - 1);

                        // Escolher Sobremesa
                        System.out.println("\nEscolha uma sobremesa:");
                        for (int i = 0; i < listaDeSobremesas.size(); i++) {
                            System.out.println((i + 1) + " - " + listaDeSobremesas.get(i));
                        }
                        System.out.print("Digite o número da sobremesa: ");
                        int escolhaSobremesa = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha
                        String sobremesaEscolhida = listaDeSobremesas.get(escolhaSobremesa - 1);

                        // Exibir a refeição montada
                        System.out.println("\nRefeição montada com sucesso:");
                        System.out.println("Salada: " + saladaEscolhida);
                        System.out.println("Prato Principal: " + pratoEscolhido);
                        System.out.println("Sobremesa: " + sobremesaEscolhida);
                    }
                    break;

                case 4:
                    // ATUALIZAR MENU
                    System.out.println("\nAtualizar Menu:");
                    System.out.println("Escolha o dia da semana para atualizar:");
                    for (int i = 0; i < dias.length; i++) {
                        System.out.println((i + 1) + " - " + dias[i]);
                    }
                    int diaEscolhido = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    String diaSelecionado = dias[diaEscolhido - 1];

                    System.out.println("Escolha o turno (1 - Almoço, 2 - Jantar):");
                    int turnoEscolhido = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    String turnoSelecionado = (turnoEscolhido == 1) ? "Almoço" : "Jantar";

                    // Montar nova refeição
                    System.out.println("\nMontando nova refeição para " + diaSelecionado + " (" + turnoSelecionado + "):");

                    // Escolher Salada
                    System.out.println("Escolha uma salada:");
                    for (int i = 0; i < listaDeSaladas.size(); i++) {
                        System.out.println((i + 1) + " - " + listaDeSaladas.get(i));
                    }
                    int novaSalada = scanner.nextInt();
                    scanner.nextLine();
                    String saladaAtualizada = listaDeSaladas.get(novaSalada - 1);

                    // Escolher Prato Principal
                    System.out.println("Escolha um prato principal:");
                    for (int i = 0; i < listaDePratos.size(); i++) {
                        System.out.println((i + 1) + " - " + listaDePratos.get(i));
                    }
                    int novoPrato = scanner.nextInt();
                    scanner.nextLine();
                    String pratoAtualizado = listaDePratos.get(novoPrato - 1);

                    // Escolher Sobremesa
                    System.out.println("Escolha uma sobremesa:");
                    for (int i = 0; i < listaDeSobremesas.size(); i++) {
                        System.out.println((i + 1) + " - " + listaDeSobremesas.get(i));
                    }
                    int novaSobremesa = scanner.nextInt();
                    scanner.nextLine();
                    String sobremesaAtualizada = listaDeSobremesas.get(novaSobremesa - 1);

                    // Atualizar o cardápio com a nova refeição
                    Refeicao novaRefeicao = new Refeicao(saladaAtualizada, pratoAtualizado, sobremesaAtualizada);
                    cardapioSemanal.get(diaSelecionado).put(turnoSelecionado, novaRefeicao);
                    System.out.println("Refeição atualizada com sucesso para " + diaSelecionado + " (" + turnoSelecionado + ").");
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
}
