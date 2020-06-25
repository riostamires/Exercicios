package atividades;

import java.util.Scanner;

public class Calculadora {
    public static void runCalculadora() {

        double num1;
        double num2;
        double resultado = 0.0;
        String operador;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o primeiro número: ");
        num1 = scanner.nextDouble();

        System.out.println("Informe o segundo número: ");
        num2 = scanner.nextDouble();

        System.out.println("Informe a operação a ser realizada \n ( + , - , * , / ou % ): ");
        operador = scanner.next();

        if (operador.equals("+")) {
            resultado = num1 + num2;
        } else if (operador.equals("-")) {
            resultado = num1 - num2;
        } else if (operador.equals("*")) {
            resultado = num1 * num2;
        } else if (operador.equals("/")) {
            resultado = num1 / num2;
        } else if (operador.equals("%")) {
            resultado = num1 % num2;
        }

        System.out.printf("O resultado da operação: %.2f %s %.2f é %.2f !"
                , num1, operador, num2, resultado);

    }
}
