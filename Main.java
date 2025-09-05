package br.edu.fatecpg.viacep.view;

import br.edu.fatecpg.viacep.controller.EnderecoController;
import br.edu.fatecpg.viacep.model.Endereco;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EnderecoController controller = new EnderecoController();

        int opcao = 0;
        while (opcao != 3) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Buscar Endereço");
            System.out.println("2 - Mostrar todos endereços salvos");
            System.out.println("3 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o CEP: ");
                    String cep = sc.nextLine();
                    Endereco end = controller.buscarEndereco(cep);
                    if (end != null) {
                        System.out.println("Endereço encontrado: " + end);

                        System.out.print("Deseja salvar no banco? (s/n): ");
                        String resp = sc.nextLine();
                        if (resp.equalsIgnoreCase("s")) {
                            controller.salvarEndereco(end);
                        }
                    }
                    break;

                case 2:
                    System.out.println("Endereços no banco:");
                    controller.listarEnderecos();
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }
}
