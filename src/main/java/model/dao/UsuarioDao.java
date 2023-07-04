package model.dao;

import java.sql.*;

public class UsuarioDao {

    public Long  logar(String login, String senha) throws SQLException {
        Long idUsuario = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/validacaoDesktop", "root", "admin");
            pstmt = conn.prepareStatement("SELECT id_usuario FROM usuario WHERE login LIKE ? AND senha LIKE ?");
            pstmt.setString(1, login);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                idUsuario = rs.getLong("id_usuario");
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        } finally {
            conn.close();
            pstmt.close();
        }

        return idUsuario;
    }
}
