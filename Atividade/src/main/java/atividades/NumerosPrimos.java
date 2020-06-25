package atividades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumerosPrimos {
    public static void runNumerosPrimos() {
        int numero;
        int cont = 1;
        int divisores = 0;
        List<Integer> naoPrimos = new ArrayList<Integer>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número para verificar se é primo: ");
        numero = scanner.nextInt();

        for (cont = 1; cont <= numero; cont++) {
            if (numero % cont == 0) {
                divisores = divisores + 1;
                naoPrimos.add(cont);
            }
        }
        if (divisores == 2) {
            System.out.println("O número " + numero + " é primo!");
        } else {
            System.out.println("O número " + numero + " não é primo pois é divisível por: ");
            System.out.println(naoPrimos);
        }
    }
}
