package DesafioEt02;

class Ticket {
    private static int contador = 0;
    int numero;
    double valor;
    boolean pago;
    int horas;

    // Construtor para inicializar o ticket
    Ticket(int horas) {
        this.numero = ++contador;
        this.valor = 5;
        this.horas = horas;
        this.pago = false;
    }

    // Método para calcular o valor com base nas horas
    void calcularValor() {
        if (horas > 1) {
            int horasExtras = horas - 1;  // Horas além da primeira hora
            this.valor += horasExtras * 1;  // Acrescenta 1 real por cada hora adicional
        }
    }

    // Método para marcar o ticket como pago
    void pagar() {
        this.pago = true;
        System.out.println("O ticket foi pago!");
    }

    // Exibir informações do ticket
    void exibirInformacoes() {
        System.out.println("Ticket Nº: " + numero + ", Horas: " + horas + ", Valor: R$ " + valor + ", Pago: " + (pago ? "Sim" : "Não"));
    }

    public int getNumero() {
        return this.numero;
    }
}
