package atividades;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner (System.in);
            System.out.println("Digite o número do exercício que você quer executar:");

            int numero = scanner.nextInt();

            switch (numero) {
                case 1:
                    Tabuada.runTabuada();
                break;

                case 2:
                    Primo.runPrimo();
                    break;
            }



        }
}
