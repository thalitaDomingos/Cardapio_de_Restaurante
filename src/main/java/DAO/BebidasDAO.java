package DAO;

import thalita_thiago.Bebidas;

import java.sql.SQLException;
import java.util.ArrayList;

public class BebidasDAO extends ConnectionDAO{

    boolean sucesso = false;

    public ArrayList<Bebidas> buscarBebidas() {
        ArrayList<Bebidas> listaDeBebidas = new ArrayList<>();

        connectToDB();

        String sql = "select *, FabricanteBebida.nome as fabricante from Bebidas, CodigoBarra, FabricanteBebida" +
                " where Bebidas.codigoBarraId = CodigoBarra.id and Bebidas.fabricanteId = FabricanteBebida.id";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Bebidas: ");
            while (rs.next()) {

                Bebidas bebidasAux = new  Bebidas();
                bebidasAux.setId(rs.getInt("id"));
                bebidasAux.setNome(rs.getString("nome"));
                bebidasAux.setDescricao(rs.getString("descricao"));
                bebidasAux.setValor(rs.getDouble("valor"));
                bebidasAux.setTempo(rs.getDouble("tempo"));
                bebidasAux.setComGelo(rs.getBoolean("comGelo"));
                bebidasAux.setCodigoBarra(rs.getString("codigo"));
                bebidasAux.setFabricante(rs.getString("fabricante"));

                listaDeBebidas.add(bebidasAux);
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

        return listaDeBebidas;
    }
}
