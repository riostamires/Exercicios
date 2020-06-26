package atividades;

import java.util.Scanner;

public class Media {
    public static void runMedia() {
        int codigoAluno;
        double n1;
        double n2;
        double n3;
        double me;
        double mediaAproveitamento;
        String resultado = null;
        char conceito = 'A';


        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o código de identificação do aluno: ");
        codigoAluno = scanner.nextInt();

        System.out.println("Informe a primeira nota: ");
        n1 = scanner.nextDouble();

        System.out.println("Informe a segunda nota: ");
        n2 = scanner.nextDouble();

        System.out.println("Informe terceira nota: ");
        n3 = scanner.nextDouble();

        me = ((n1 + n2 + n3) / 3);

        mediaAproveitamento = ((n1 + (n2 * 2) + (n3 * 3) + me) / 7);

        if (mediaAproveitamento >= 9) {
            conceito = 'A';
        } else if (mediaAproveitamento < 9 && mediaAproveitamento >= 7.5) {
            conceito = 'B';
        } else if (mediaAproveitamento < 7.5 && mediaAproveitamento >= 6) {
            conceito = 'C';
        } else if (mediaAproveitamento < 6 && mediaAproveitamento >= 4) {
            conceito = 'D';
        } else if (mediaAproveitamento < 4) {
            conceito = 'E';
        }

        switch (conceito) {
            case 'A':
            case 'B':
            case 'C':
                resultado = "Aprovado!";
                break;
            case 'D':
            case 'E':
                resultado = "Reprovado!";
                break;
        }
        System.out.printf("O Aluno código: %d possui as seguintes notas:" +
                        "\n N1 = %.2f \n N2 = %.2f \n N3 = %.2f \n ME = %.2f" +
                        "\n A sua média de aproveitamento é %.2f" +
                        "\n Portanto, seu conceito é: %s , e está %s",
                codigoAluno, n1, n2, n3, me, mediaAproveitamento , conceito, resultado);
    }
}

