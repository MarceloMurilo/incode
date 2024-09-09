package Fundamentos;

public class DesafioFor {
    public static void main(String[] args) {
        String valor = "#";

        for (;;){
            System.out.println(valor);
            valor += "#";
            if (valor.equalsIgnoreCase("#####")){
                break;
            }


        }
    }
}
