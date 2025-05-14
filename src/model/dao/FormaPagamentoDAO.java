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
import modelo.FormaPagamento;

/**
 *
 * @author vagne
 */
public class FormaPagamentoDAO {
    Conexao c = new Conexao();
    
    public void salvar(FormaPagamento objFormaPagamento) {
        
        
        try {
            String sql;
            System.out.println("Entra ");
            if (objFormaPagamento.getId() == null) {
                sql = "INSERT INTO formaPagamento(formaPagamento,valorTotal,codigoFP,tipoPagamento,categoria) VALUES(?,?,?,?,?)";
                System.out.println("Entra SALVAR");
                
                PreparedStatement stmt = c.con().prepareStatement(sql);

                stmt.setString(1, objFormaPagamento.getFormaPagamento());
                stmt.setString(2, objFormaPagamento.getValorTotal());
                stmt.setString(3, objFormaPagamento.getCodigoFP());
                stmt.setString(4, objFormaPagamento.getTipoPagamento());
                stmt.setString(5, objFormaPagamento.getCategoria());
                System.out.println("Executa");
                stmt.execute();
                stmt.close();
                c.con().close();
                

            } else {
                System.out.println("Entra UPDATE");
                sql = "UPDATE formaPagamento SET formaPagamento = ?, valorTotal = ?, codigoFP = ?, tipoPagamento = ?, categoria = ? WHERE formaPagamento.id = ?";

                PreparedStatement stmt = c.con().prepareStatement(sql);

                stmt.setString(6, objFormaPagamento.getId());
                stmt.setString(1, objFormaPagamento.getFormaPagamento());
                stmt.setString(2, objFormaPagamento.getValorTotal());
                stmt.setString(3, objFormaPagamento.getCodigoFP());
                stmt.setString(4, objFormaPagamento.getTipoPagamento());
                stmt.setString(5, objFormaPagamento.getCategoria());
                stmt.execute();
                stmt.close();
                c.con().close();

            }
        } catch (SQLException e) {
            System.out.println("CATCH   ");
            e.printStackTrace();
        }
    }

    public  List<FormaPagamento> buscar(String objFormaPagamento, String tipo) {
        List<FormaPagamento> list = new ArrayList<>();
        try {
            String sql = "";
            if (tipo.equals("formaPagamento")) {
                sql = "SELECT * FROM formaPagamento WHERE formaPagamento LIKE '%" + objFormaPagamento + "%' ";

            }

            PreparedStatement ps = c.con().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new FormaPagamento(
                    rs.getString("id"),
                    rs.getString("formaPagamento"),
                    rs.getString("valorTotal"),
                    rs.getString("codigoFP"),
                    rs.getString("tipoPagamento"),
                    rs.getString("categoria")
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
                sql = "DELETE FROM formaPagamento WHERE id = ?";
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

    public List<FormaPagamento> listarTodos() {
        try {

            List<FormaPagamento> list = new ArrayList();

            PreparedStatement ps = c.con().prepareStatement("SELECT * FROM formaPagamento");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new FormaPagamento(
                    rs.getString("id"),
                    rs.getString("formaPagamento"),
                    rs.getString("valorTotal"),
                    rs.getString("codigoFP"),
                    rs.getString("tipoPagamento"),
                    rs.getString("categoria")
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
