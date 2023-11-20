package application;

import java.util.Scanner;

public class Menu {
    public static final int LAST_OPTION = 7;

    public static void show() {
        System.out.println("Opções: ");

        System.out.println("1 - Incluir paciente");
        System.out.println("2 - Alterar paciente");
        System.out.println("3 - Realizar consulta");
        System.out.println("4 - Listar pacientes");
        System.out.println("5 - Mostrar paciente");
        System.out.println("6 - Excluir paciente");
        System.out.println("7 - Sair");
    }

    public static int getSelectedOption() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a opção desejada: ");
        return scanner.nextInt();
    }
}
