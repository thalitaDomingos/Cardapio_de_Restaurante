package DAO;

import thalita_thiago.Pratos_Individuais;

import java.sql.SQLException;
import java.util.ArrayList;

public class Pratos_IndividuaisDAO extends ConnectionDAO {

    public boolean inserirPratos_Individuais(Pratos_Individuais pratos_individuais) {
        connectToDB();
        String sql = "INSERT INTO Pratos_Individuais (id, nome,descricao,valor,tempo) values(?,?,?,?,?)";

        boolean sucesso = false;

        try {
            pst = con.prepareStatement(sql);
            pst.setDouble(1, pratos_individuais.getId());
            pst.setString(2, pratos_individuais.getNome());
            pst.setString(3, pratos_individuais.getDescricao());
            pst.setDouble(4, pratos_individuais.getValor());
            pst.setDouble(5, pratos_individuais.getTempo());
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


    public boolean atualizarPrato(int id, Pratos_Individuais pratos_individuais) {
        connectToDB();
        String sql = "UPDATE Pratos_Individuais SET nome=?, descricao=?, valor=?, tempo=? where id=?";
        boolean sucesso = false;

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, pratos_individuais.getNome());
            pst.setString(2, pratos_individuais.getDescricao());
            pst.setDouble(3, pratos_individuais.getValor());
            pst.setDouble(4, pratos_individuais.getTempo());
            pst.setInt(5, id);
            pst.execute();
            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
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


    public boolean deletarPratos_Individuais(int id) {
        connectToDB();
        String sql = "DELETE FROM Pratos_Individuais where id=?";
        boolean sucesso = false;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
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


    public ArrayList<Pratos_Individuais> buscarPratos_Individuais() {
        ArrayList<Pratos_Individuais> listaDePratos_Individuais = new ArrayList<>();

        connectToDB();

        String sql = "SELECT * FROM Pratos_Individuais";
        boolean sucesso = false;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Pratos Individuais: ");

            while (rs.next()) {

                Pratos_Individuais pratos_individuaisAux = new Pratos_Individuais();
                pratos_individuaisAux.setId(rs.getInt("id"));
                pratos_individuaisAux.setNome(rs.getString("nome"));
                pratos_individuaisAux.setDescricao(rs.getString("descricao"));
                pratos_individuaisAux.setValor(rs.getInt("valor"));
                pratos_individuaisAux.setTempo(rs.getInt("tempo"));

                listaDePratos_Individuais.add(pratos_individuaisAux);
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

        return listaDePratos_Individuais;
    }

    public Pratos_Individuais buscarPratos_individuaisPorId(int id) {

        connectToDB();
        Pratos_Individuais pratos_individuaisAux = null;
        String sql = "SELECT * FROM pratos_individuais WHERE id = ?";
        boolean sucesso = false;

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                String aux = rs.getString("Nome");
                if(aux.isEmpty())
                {
                    sucesso = false;
                } else {

                    pratos_individuaisAux = new Pratos_Individuais();
                    pratos_individuaisAux.setId(rs.getInt("id"));
                    pratos_individuaisAux.setNome(rs.getString("nome"));
                    pratos_individuaisAux.setDescricao(rs.getString("descricao"));
                    pratos_individuaisAux.setValor(rs.getInt("valor"));
                    pratos_individuaisAux.setTempo(rs.getInt("tempo"));

                    System.out.println("id = " + pratos_individuaisAux.getId());
                    System.out.println("nome = " + pratos_individuaisAux.getNome());
                    System.out.println("descricao = " + pratos_individuaisAux.getDescricao());
                    System.out.println("valor = " + pratos_individuaisAux.getValor());
                    System.out.println("tempo = " + pratos_individuaisAux.getTempo());
                    System.out.println("--------------------------------");
                }
            }
            sucesso = true;

        } catch(SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return pratos_individuaisAux;
    }
}