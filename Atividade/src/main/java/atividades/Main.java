package atividades;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número do exercício que você quer executar:");
        System.out.println(" 1 - Tabuada; \n 2 - Números primos; \n 3 - Calculadora; \n 4 - Média;");

        int numero = scanner.nextInt();

        while (numero <= 0 || numero > 4) {
            System.out.println("Por favor, digite um número de 1 a 4: ");
            numero = scanner.nextInt();
        }
        switch (numero) {
            case 1:
                Tabuada.runTabuada();
                break;

            case 2:
                NumerosPrimos.runNumerosPrimos();
                break;

            case 3:
                Calculadora.runCalculadora();
                break;

            case 4:
                Media.runMedia();
                break;
        }
    }
}
