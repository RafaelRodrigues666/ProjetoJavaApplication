/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Produto;

/**
 *
 * @author vagne
 */
public class FornecedorDAO {
    Conexao c = new Conexao();
    
    public void salvar(Produto objProduto) {
        
        
        try {
            String sql;
            System.out.println("Entra ");
            if (objProduto.getId() == null) {
                sql = "INSERT INTO produto(descricao,precoCusto,precoVenda) VALUES(?,?,?)";
                System.out.println("Entra SALVAR");
                
                PreparedStatement stmt = c.con().prepareStatement(sql);

                stmt.setString(1, objProduto.getDescricao());
                stmt.setString(2, objProduto.getPrecoCusto());
                stmt.setString(3, objProduto.getPrecoVenda());
                stmt.setString(4, objProduto.getSku());
                stmt.setString(5, objProduto.getCategoria());
                stmt.setString(6, objProduto.getMarca());
                stmt.setString(7, objProduto.getModelo());
                stmt.setString(8, objProduto.getUnidadeMedida());
                System.out.println("Executa");
                stmt.execute();
                stmt.close();
                c.con().close();
                

            } else {
                System.out.println("Entra UPDATE");
                sql = "UPDATE produto SET descricao = ?, precoCusto = ?, precoVenda = ? WHERE produto.id = ?";

                PreparedStatement stmt = c.con().prepareStatement(sql);

                stmt.setString(9, objProduto.getId());
                stmt.setString(1, objProduto.getDescricao());
                stmt.setString(2, objProduto.getPrecoCusto());
                stmt.setString(3, objProduto.getPrecoVenda());
                stmt.setString(4, objProduto.getSku());
                stmt.setString(5, objProduto.getCategoria());
                stmt.setString(6, objProduto.getMarca());
                stmt.setString(7, objProduto.getModelo());
                stmt.setString(8, objProduto.getUnidadeMedida());
                stmt.execute();
                stmt.close();
                c.con().close();

            }
        } catch (SQLException e) {
            System.out.println("CATCH   ");
            e.printStackTrace();
        }
    }

    public  List<Produto> buscar(String objProduto, String tipo) {
        List<Produto> list = new ArrayList<>();
        try {
            String sql = "";
            if (tipo.equals("descricao")) {
                sql = "SELECT * FROM produto WHERE descricao LIKE '%" + objProduto + "%' ";

            }

            PreparedStatement ps = c.con().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new Produto(
                    rs.getString("id"),
                    rs.getString("descricao"),
                    rs.getString("precoCusto"),
                    rs.getString("precoVenda"),
                    rs.getString("sku"),
                    rs.getString("categoria"),
                    rs.getString("marca"),    
                    rs.getString("modelo"),
                    rs.getString("unidadeMedida")
                ));

            }
            ps.close();
            rs.close();
           
            c.con().close();

            return list;
        } catch (SQLException e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Erro preencher o ArrayList");
            return null;
        }
    }

    public void deletar(int id) {
        try {
            String sql;
            if (id != 0) {
                sql = "DELETE FROM produto WHERE id = ?";
                PreparedStatement stmt = c.con().prepareStatement(sql);

                stmt.setString(1, ""+ id);
                stmt.execute();
                stmt.close();
                c.con().close();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public List<Produto> listarTodos() {
        try {

            List<Produto> list = new ArrayList();

            PreparedStatement ps = c.con().prepareStatement("SELECT * FROM produto");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new Produto(
                    rs.getString("id"),
                    rs.getString("descricao"),
                    rs.getString("precoCusto"),
                    rs.getString("precoVenda"),
                    rs.getString("sku"),
                    rs.getString("categoria"),
                    rs.getString("marca"),    
                    rs.getString("modelo"),
                    rs.getString("unidadeMedida")
                ));

            }
            ps.close();
            rs.close();
            c.con().close();

            return list;
        } catch (SQLException e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Erro preencher o ArrayList");
            return null;
        }
    }

//    public static void testarConexao() throws SQLException {
//        try (Connection objConnection = new ConnectionFactory().getConnection()) {
//            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso! ");
//        }
//    }
}
