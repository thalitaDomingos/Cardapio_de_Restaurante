package DAO;

import thalita_thiago.Sobremesas;

import java.sql.SQLException;
import java.util.ArrayList;

public class SobremesasDAO extends ConnectionDAO{

    boolean sucesso = false;

    public ArrayList<Sobremesas> buscarSobremesas() {
        ArrayList<Sobremesas> listaDeSobremesas = new ArrayList<>();

        connectToDB();

        String sql = "SELECT * FROM Sobremesas";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Sobremesas: ");

            while (rs.next()) {
                Sobremesas instrumentoAux = new Sobremesas();
                instrumentoAux.setId(rs.getInt("id"));
                instrumentoAux.setNome(rs.getString("nome"));
                instrumentoAux.setDescricao(rs.getString("descricao"));
                instrumentoAux.setValor(rs.getDouble("valor"));
                instrumentoAux.setTempo(rs.getDouble("tempo"));
                instrumentoAux.setDiet(rs.getBoolean("diet"));

                listaDeSobremesas.add(instrumentoAux);
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

        return listaDeSobremesas;
    }

}
