package DesafioEt02;

import java.util.ArrayList;

public class Estacionamento {
    private ArrayList<Ticket> tickets = new ArrayList<>();
    private double saldo = 0;

    // Emitir um novo ticket
    void emitirTicket(int horas) {
        Ticket novoTicket = new Ticket(horas);
        novoTicket.calcularValor();
        tickets.add(novoTicket);  // Adiciona o ticket à lista
        System.out.println("Ticket de número " + novoTicket.getNumero() + " emitido com valor: R$ " + novoTicket.valor + " e horas: " + novoTicket.horas);

        // Debug: Verificar a lista de tickets após a emissão
        System.out.println("Lista de tickets após emissão:");
        for (Ticket t : tickets) {
            System.out.println("Ticket Nº: " + t.getNumero());
        }
    }

    // Pagar um ticket baseado no número
    void pagarTicket(int numero) {
        System.out.println("Tentando pagar o ticket com número: " + numero);  // Debug: Mostrar o número recebido

        if (tickets.isEmpty()) {
            System.out.println("Nenhum ticket foi emitido.");
        }

        for (Ticket ticket : tickets) {
            System.out.println("Verificando ticket: " + ticket.getNumero());  // Debug: Mostrar o número de cada ticket na lista

            if (ticket.getNumero() == numero && !ticket.pago) {  // Se o número do ticket for igual ao número fornecido e o ticket não estiver pago
                ticket.pagar();  // Pagar o ticket
                saldo += ticket.valor;  // Atualizar o saldo com o valor do ticket
                System.out.println("Ticket pago com sucesso!");
                return;
            }
        }

        // Caso nenhum ticket seja encontrado ou já tenha sido pago
        System.out.println("Ticket não encontrado ou já foi pago.");
    }

    // Exibir saldo
    void exibirSaldo() {
        System.out.println("Saldo total: R$ " + saldo);
    }

    // Exibir todos os tickets
    void exibirTickets() {
        if (tickets.isEmpty()) {
            System.out.println("Nenhum ticket emitido.");
        } else {
            for (Ticket ticket : tickets) {
                ticket.exibirInformacoes();  // Exibir informações do ticket
            }
        }
    }
}
