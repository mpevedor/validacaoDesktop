package controller;

import model.dao.UsuarioDao;

import java.sql.SQLException;

public class UsuarioController {

    public Long logar(String login, String senha) throws SQLException {
        UsuarioDao usuarioDao = new UsuarioDao();
        return usuarioDao.logar(login,senha);
    }
}
