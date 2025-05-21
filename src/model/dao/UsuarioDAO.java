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
import modelo.Usuario;

/**
 *
 * @author vagne
 */
public class UsuarioDAO {
    Conexao c = new Conexao();
    
    public void salvar(Usuario objUsuario) {
        
        
        try {
            String sql;
            System.out.println("Entra ");
            if (objUsuario.getId() == null) {
                sql = "INSERT INTO usuario(nome,cpf,dataNascimento,email,telefone,funcao) VALUES(?,?,?,?,?,?)";
                System.out.println("Entra SALVAR");
                
                PreparedStatement stmt = c.con().prepareStatement(sql);

                stmt.setString(1, objUsuario.getNome());
                stmt.setString(2, objUsuario.getCpf());
                stmt.setString(3, objUsuario.getDataNascimento());
                stmt.setString(4, objUsuario.getEmail());
                stmt.setString(5, objUsuario.getTelefone());
                stmt.setString(6, objUsuario.getFuncao());
                System.out.println("Executa");
                stmt.execute();
                stmt.close();
                c.con().close();
                

            } else {
                System.out.println("Entra UPDATE");
                sql = "UPDATE usuario SET nome = ?, cpf = ?, dataNascimento = ?, email = ?, telefone = ?, funcao = ? WHERE usuario.id = ?";

                PreparedStatement stmt = c.con().prepareStatement(sql);

                stmt.setString(7, objUsuario.getId());
                stmt.setString(2, objUsuario.getCpf());
                stmt.setString(3, objUsuario.getDataNascimento());
                stmt.setString(4, objUsuario.getEmail());
                stmt.setString(5, objUsuario.getTelefone());
                stmt.setString(6, objUsuario.getFuncao());
                stmt.execute();
                stmt.close();
                c.con().close();

            }
        } catch (SQLException e) {
            System.out.println("CATCH   ");
            e.printStackTrace();
        }
    }

    public  List<Usuario> buscar(String objUsuario, String tipo) {
        List<Usuario> list = new ArrayList<>();
        try {
            String sql = "";
            if (tipo.equals("nome")) {
                sql = "SELECT * FROM usuario WHERE nome LIKE '%" + objUsuario + "%' ";

            } else if (tipo.equals("cpf")) {
                sql = "SELECT * FROM usuario WHERE cpf LIKE '%" + objUsuario + "%' ";
            }

            PreparedStatement ps = c.con().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new Usuario(
                    rs.getString("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("dataNascimento"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getString("funcao")
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
                sql = "DELETE FROM usuario WHERE id = ?";
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

    public List<Usuario> listarTodos() {
        try {

            List<Usuario> list = new ArrayList();

            PreparedStatement ps = c.con().prepareStatement("SELECT * FROM usuario");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new Usuario(
                    rs.getString("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("dataNascimento"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getString("funcao")
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
