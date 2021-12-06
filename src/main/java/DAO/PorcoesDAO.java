package DAO;

import thalita_thiago.Porcoes;

import java.sql.SQLException;
import java.util.ArrayList;

public class PorcoesDAO extends ConnectionDAO {

    boolean sucesso = false;

    public ArrayList<Porcoes> buscarPorcoes() {

        ArrayList<Porcoes> listaDePorcoes = new ArrayList<>();

        connectToDB();

        String sql = "SELECT * FROM Porcoes";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Porcoes: ");
            while (rs.next()) {

                Porcoes porcoesAux = new Porcoes();
                porcoesAux.setId(rs.getInt("id"));
                porcoesAux.setNome(rs.getString("nome"));
                porcoesAux.setDescricao(rs.getString("descricao"));
                porcoesAux.setValor(rs.getDouble("valor"));
                porcoesAux.setTempo(rs.getDouble("tempo"));
                porcoesAux.setQuantidadePorcao(rs.getInt("quantPorcao"));

                listaDePorcoes.add(porcoesAux);
            }
            sucesso = true;
        } catch(SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch(SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        return listaDePorcoes;
    }
}
