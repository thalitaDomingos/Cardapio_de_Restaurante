package thalita_thiago;

import java.util.ArrayList;
import java.util.Collections;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        int id;
        String nome, descricao;
        double valor, tempo;
        Scanner sc = new Scanner(System.in);

        Cardapio cardapio = new Cardapio();

        boolean flag = true;

        while (flag) {

            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Pratos Individuais");
            System.out.println("2 - Porções");
            System.out.println("3 - Bebibas");
            System.out.println("4 - Sobremesas");
            System.out.println("5 - Criar Prato Individual");
            System.out.println("6 - Editar Prato Individual");
            System.out.println("7 - Deletar Prato Individual");
            System.out.println("8 - Criar combo");
            System.out.println("9 - Listar combo");
            System.out.println("10 - Sair");
            System.out.println(" ");
            System.out.println("Sua opção: ");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    cardapio.listarPratos_Individuais();
                    break;
                case 2:
                    cardapio.listarPorcoes();
                    break;
                case 3:
                    cardapio.listarBebidas();
                    break;
                case 4:
                    cardapio.listarSobremesas();
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("Entre com o nome do prato a ser inserido: ");
                    nome = sc.nextLine();
                    System.out.println("Entre com o descricao do prato a ser inserido: ");
                    descricao = sc.nextLine();
                    System.out.println("Entre com o valor do prato a ser inserido: ");
                    valor = sc.nextDouble();
                    System.out.println("Entre com o tempo do prato a ser inserido: ");
                    tempo = sc.nextDouble();
                    cardapio.criarPrato(new Pratos_Individuais(nome, descricao, valor, tempo));
                    break;
                case 6:
                    System.out.println("Entre com o id do prato a ser editado: ");
                    id = sc.nextInt();

                    Pratos_Individuais prato = cardapio.obterPrato(id);

                    if(prato == null) {
                        System.out.println("PRATO NÂO EXISTE!");
                        break;
                    }

                    sc.nextLine();
                    System.out.println("Entre com o nome do prato a ser editado. Nome atual = " + prato.getNome() + ": ");
                    nome = sc.nextLine();
                    System.out.println("Entre com a descricao do prato a ser editado. Descricao atual = " + prato.getDescricao() + ": ");
                    descricao = sc.nextLine();
                    System.out.println("Entre com o valor do prato a ser editado. valor atual = " + prato.getValor() + ": ");
                    valor = sc.nextDouble();
                    System.out.println("Entre com o tempo do prato a ser editado. tempo atual = " + prato.getTempo() + ": ");
                    tempo = sc.nextDouble();
                    cardapio.editarPrato(id, new Pratos_Individuais(nome, descricao, valor, tempo));
                    break;
                case 7:
                    System.out.println("Entre com o id do prato a ser deletado: ");
                    id = sc.nextInt();
                    cardapio.deletarPrato(id);
                    break;
                case 8:
                    System.out.println("Adicionar combo");
                    System.out.println("Entre com o id do prato a ser parte do combo: ");
                    int pratoId = sc.nextInt();
                    System.out.println("Entre com o id da bebida a ser parte do combo: ");
                    int bebidaId = sc.nextInt();
                    cardapio.criarCombo(pratoId, bebidaId);
                    break;
                case 9:
                    cardapio.listarCombo();
                    break;
                case 10:
                    System.out.println("Você saiu!");
                    flag = false;
                    break;
                default:
                    System.out.println("Opção inválida! Digite novamente!");
                    System.out.println();
                    break;


            }
        }
    }
}
