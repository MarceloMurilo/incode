package Fundamentos;

public class Ternario {
    public static void main (String[] args){
        //----------------[VALORES TERNÁRIOS]--------------------------------

        // Caso o Valor da varíavel TemDesconto for TRUE, ele recebe SIM no resultado
        var TemDesconto = false;
        String resultado = TemDesconto ? "SIM":"NAO";
        System.out.println(resultado);
        // Explicação:
        // Operadores ternários utilizam 3 partes na seguinte estrutura:
        // X = Y ? "R1" : "R2"
        // Onde:
        // - Y é a condição que será avaliada (boolean).
        // - R1 é o valor atribuído a X se Y for verdadeiro (TRUE).
        // - R2 é o valor atribuído a X se Y for falso (FALSE).

        // No exemplo acima, se TemDesconto for TRUE, o valor "SIM" será atribuído à variável resultado.
        // Caso contrário, o valor "NAO" será atribuído.
    }
}
