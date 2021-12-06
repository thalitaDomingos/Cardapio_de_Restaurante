package DAO;

import thalita_thiago.Combo;
import thalita_thiago.Pratos_Individuais;

import java.sql.SQLException;
import java.util.ArrayList;

public class ComboDAO extends ConnectionDAO {

    public boolean inserirCombo(int pratoId, int bebidaId) {
        connectToDB();
        String sql = "INSERT INTO Combo (Pratos_IndividuaisId, Bebidas_id) values(?,?)";
        boolean sucesso = false;

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, pratoId);
            pst.setInt(2, bebidaId);
            pst.execute();
            sucesso = true;

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public ArrayList<Combo> buscarCombos() {
        ArrayList<Combo> combos = new ArrayList<>();

        connectToDB();

        String sql = "select Pratos_Individuais.nome as prato, Bebidas.nome as bebida from Pratos_Individuais, Bebidas, Combo " +
                "where Combo.Pratos_IndividuaisId = Pratos_Individuais.id and Combo.Bebidas_id = Bebidas.id";
        boolean sucesso = false;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Combo combo = new Combo();
                combo.descricao = rs.getString("prato") + " com " + rs.getString("bebida");
                combos.add(combo);
            }

            sucesso = true;

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;

        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return combos;
    }
}
