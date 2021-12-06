package thalita_thiago;

import DAO.*;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {

    private Pratos_IndividuaisDAO pratosIndividuaisDAO = new Pratos_IndividuaisDAO();
    private PorcoesDAO porcoesDAO = new PorcoesDAO();
    private BebidasDAO bebidasDAO = new BebidasDAO();
    private SobremesasDAO sobremesasDAO = new SobremesasDAO();
    private ComboDAO comboDAO = new ComboDAO();

    public void listarPratos_Individuais() {
        ArrayList<Pratos_Individuais> pratosIndividuais = pratosIndividuaisDAO.buscarPratos_Individuais();
        if (pratosIndividuais.size() == 0) {
            System.out.println("Não tem pratos");
        } else {
            for (Pratos_Individuais pratoIndividual : pratosIndividuais) {
                System.out.println("--------------------------------");
                System.out.println("Prato " + pratoIndividual.getId());
                System.out.println("Nome: " + pratoIndividual.getNome());
                System.out.println("Descrição: " + pratoIndividual.getDescricao());
                System.out.println("Preço: R$" + pratoIndividual.getValor());
                pratoIndividual.tempoEspera();
                System.out.println("--------------------------------");
            }
        }
        System.out.println("\n");
    }

    public void criarPrato(Pratos_Individuais pratos_individuais) {
        boolean sucesso = pratosIndividuaisDAO.inserirPratos_Individuais(pratos_individuais);
        if (sucesso) {
            System.out.println("Prato Inserido!");
            System.out.println("");
        } else {
            System.out.println("Falha ao inserir prato!");
        }
    }

    public void editarPrato(int id, Pratos_Individuais pratos_individuais) {
        boolean sucesso = pratosIndividuaisDAO.atualizarPrato(id, pratos_individuais);
        if (sucesso) {
            System.out.println("Prato Editado!");
            System.out.println("");
        } else {
            System.out.println("Falha ao editar prato!");
        }
    }

    public void deletarPrato(int id) {
        boolean sucesso = pratosIndividuaisDAO.deletarPratos_Individuais(id);
        if (sucesso) {
            System.out.println("Prato Deletado!");
            System.out.println("");
        } else {
            System.out.println("Falha ao deletar prato!");
        }
    }

    public Pratos_Individuais obterPrato(int id) {
        return pratosIndividuaisDAO.buscarPratos_individuaisPorId(id);
    }


    public void listarPorcoes() {
        ArrayList<Porcoes> porcoes = porcoesDAO.buscarPorcoes();
        if (porcoes.size() == 0) {
            System.out.println("Não tem Porção");
            System.out.println("");
        } else {
            for (Porcoes porcao : porcoes) {
                System.out.println("--------------------------------");
                System.out.println("Porções " + porcao.getId());
                System.out.println("Nome: " + porcao.getNome());
                System.out.println("Descrição: " + porcao.getDescricao());
                System.out.println("Preço: R$" + porcao.getValor());
                System.out.println("Quantidade: " + porcao.getQuantidadePorcao());
                porcao.tempoEspera();
                System.out.println("--------------------------------");
            }
        }
        System.out.println("\n");
    }

    public void listarBebidas() {
        ArrayList<Bebidas> bebidas = bebidasDAO.buscarBebidas();
        if (bebidas.size() == 0) {
            System.out.println("Não tem Porção");
            System.out.println("");
        } else {
            for (Bebidas bebida : bebidas) {
                System.out.println("--------------------------------");
                System.out.println("Bebidas " + bebida.getId());
                System.out.println("Nome: " + bebida.getNome());
                System.out.println("Descrição: " + bebida.getDescricao());
                System.out.println("Preço: R$" + bebida.getValor());
                System.out.println("Com gelo ? " + (bebida.isComGelo() ? "Sim" : "Não"));
                System.out.println("Codigo de barras: " + bebida.getCodigoBarra());
                System.out.println("Fabricante: " + bebida.getFabricante());
                bebida.tempoEspera();
                System.out.println("--------------------------------");
            }
        }
        System.out.println("\n");
    }

    public void listarSobremesas() {
        ArrayList<Sobremesas> sobremesas = sobremesasDAO.buscarSobremesas();
        if (sobremesas.size() == 0) {
            System.out.println("Não tem Porção");
            System.out.println("");
        } else {
            for (Sobremesas sobremesa : sobremesas) {
                System.out.println("--------------------------------");
                System.out.println("Sobremesas " + sobremesa.getId());
                System.out.println("Nome: " + sobremesa.getNome());
                System.out.println("Descrição: " + sobremesa.getDescricao());
                System.out.println("Preço: R$" + sobremesa.getValor());
                System.out.println("Diet ? " + (sobremesa.isDiet() ? "Sim" : "Não"));
                sobremesa.tempoEspera();
                System.out.println("--------------------------------");
            }
        }
        System.out.println("\n");
    }

    public void criarCombo(int pratoId, int bebidaId) {
        boolean sucesso = comboDAO.inserirCombo(pratoId, bebidaId);
        if (sucesso) {
            System.out.println("Combo Inserido!");
            System.out.println("");
        } else {
            System.out.println("Falha ao inserir combo!");
        }
    }

    public void listarCombo() {
        ArrayList<Combo> combos = comboDAO.buscarCombos();
        if (combos.size() == 0) {
            System.out.println("Não tem Combo");
            System.out.println("");
        } else {
            for (Combo combo: combos) {
                System.out.println("--------------------------------");
                System.out.println("Combo: " + combo.descricao);
                System.out.println("--------------------------------");
            }
        }
        System.out.println("\n");
    }
}