/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ConexaoBancoDadosBAR;
import gestor.Dao.ConexaoBancoDadosITB;
import gestor.Dao.ConexaoBancoDadosLF;
import gestor.Dao.ConexaoBancoDadosSSA;
import gestor.Dao.ConexaoBancoDadosVC;
import gestor.Modelo.Usuarios;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleGrupoUsuarios {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ConexaoBancoDadosLF conectaLF = new ConexaoBancoDadosLF();
    ConexaoBancoDadosSSA conectaSSA = new ConexaoBancoDadosSSA();
    ConexaoBancoDadosITB conectaITB = new ConexaoBancoDadosITB();
    ConexaoBancoDadosVC conectaVC = new ConexaoBancoDadosVC();
    ConexaoBancoDadosBAR conectaBAR = new ConexaoBancoDadosBAR();
    Usuarios objUser = new Usuarios();
    int codGrupo;

    public Usuarios incluirGrupoUsuarios(Usuarios objUser) {
        pesquisarGrupoUsuarios(objUser.getNomeGrupo());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO USUARIOS_GRUPOS (IdUsuario,IdGrupo)VALUES(?,?)");
            pst.setInt(1, objUser.getIdUsuario());
            pst.setInt(2, codGrupo);
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objUser;
    }

    public Usuarios alterarGrupoUsuarios(Usuarios objUser) {
        pesquisarGrupoUsuarios(objUser.getNomeGrupo());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE USUARIOS_GRUPOS SET IdUsuario=?,IdGrupo=? WHERE IdUserGroup='" + objUser.getIdUserGroup() + "'");
            pst.setInt(1, objUser.getIdUsuario());
            pst.setInt(2, codGrupo);
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objUser;
    }

    public Usuarios excluirGrupoUsuarios(Usuarios objUser) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM USUARIOS_GRUPOS WHERE IdUserGroup='" + objUser.getIdUserGroup() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objUser;
    }

    //------------------------------------- CADASTRO PARA OUTRAS UNIDADES PRISIONAIS ----------------------------------------------
    //LAURO DE FREITAS
    public Usuarios incluirGrupoUsuariosLF(Usuarios objUser) {
        pesquisarGrupoUsuarios(objUser.getNomeGrupo());
        conectaLF.abrirConexao();
        try {
            PreparedStatement pst = conectaLF.con.prepareStatement("INSERT INTO USUARIOS_GRUPOS (IdUsuario,IdGrupo)VALUES(?,?)");
            pst.setInt(1, objUser.getIdUsuario());
            pst.setInt(2, codGrupo);
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conectaLF.desconecta();
        return objUser;
    }

    public Usuarios alterarGrupoUsuariosLF(Usuarios objUser) {
        pesquisarGrupoUsuarios(objUser.getNomeGrupo());
        conectaLF.abrirConexao();
        try {
            PreparedStatement pst = conectaLF.con.prepareStatement("UPDATE USUARIOS_GRUPOS SET IdUsuario=?,IdGrupo=? WHERE IdUserGroup='" + objUser.getIdUserGroup() + "'");
            pst.setInt(1, objUser.getIdUsuario());
            pst.setInt(2, codGrupo);
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conectaLF.desconecta();
        return objUser;
    }

    public Usuarios excluirGrupoUsuariosLF(Usuarios objUser) {
        conectaLF.abrirConexao();
        try {
            PreparedStatement pst = conectaLF.con.prepareStatement("DELETE FROM USUARIOS_GRUPOS WHERE IdUserGroup='" + objUser.getIdUserGroup() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conectaLF.desconecta();
        return objUser;
    }

    //SALVADOR
    public Usuarios incluirGrupoUsuariosSSA(Usuarios objUser) {
        pesquisarGrupoUsuarios(objUser.getNomeGrupo());
        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("INSERT INTO USUARIOS_GRUPOS (IdUsuario,IdGrupo)VALUES(?,?)");
            pst.setInt(1, objUser.getIdUsuario());
            pst.setInt(2, codGrupo);
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conectaSSA.desconecta();
        return objUser;
    }

    public Usuarios alterarGrupoUsuariosSSA(Usuarios objUser) {
        pesquisarGrupoUsuarios(objUser.getNomeGrupo());
        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("UPDATE USUARIOS_GRUPOS SET IdUsuario=?,IdGrupo=? WHERE IdUserGroup='" + objUser.getIdUserGroup() + "'");
            pst.setInt(1, objUser.getIdUsuario());
            pst.setInt(2, codGrupo);
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conectaSSA.desconecta();
        return objUser;
    }

    public Usuarios excluirGrupoUsuariosSSA(Usuarios objUser) {
        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("DELETE FROM USUARIOS_GRUPOS WHERE IdUserGroup='" + objUser.getIdUserGroup() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conectaSSA.desconecta();
        return objUser;
    }

    //ITABUNA
    public Usuarios incluirGrupoUsuariosITB(Usuarios objUser) {
        pesquisarGrupoUsuarios(objUser.getNomeGrupo());
        conectaITB.abrirConexao();
        try {
            PreparedStatement pst = conectaITB.con.prepareStatement("INSERT INTO USUARIOS_GRUPOS (IdUsuario,IdGrupo)VALUES(?,?)");
            pst.setInt(1, objUser.getIdUsuario());
            pst.setInt(2, codGrupo);
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conectaITB.desconecta();
        return objUser;
    }

    public Usuarios alterarGrupoUsuariosITB(Usuarios objUser) {
        pesquisarGrupoUsuarios(objUser.getNomeGrupo());
        conectaITB.abrirConexao();
        try {
            PreparedStatement pst = conectaITB.con.prepareStatement("UPDATE USUARIOS_GRUPOS SET IdUsuario=?,IdGrupo=? WHERE IdUserGroup='" + objUser.getIdUserGroup() + "'");
            pst.setInt(1, objUser.getIdUsuario());
            pst.setInt(2, codGrupo);
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conectaITB.desconecta();
        return objUser;
    }

    public Usuarios excluirGrupoUsuariosITB(Usuarios objUser) {
        conectaITB.abrirConexao();
        try {
            PreparedStatement pst = conectaITB.con.prepareStatement("DELETE FROM USUARIOS_GRUPOS WHERE IdUserGroup='" + objUser.getIdUserGroup() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conectaITB.desconecta();
        return objUser;
    }

    //VITÓRIA DA CONQUISTA
    public Usuarios incluirGrupoUsuariosVC(Usuarios objUser) {
        pesquisarGrupoUsuarios(objUser.getNomeGrupo());
        conectaVC.abrirConexao();
        try {
            PreparedStatement pst = conectaVC.con.prepareStatement("INSERT INTO USUARIOS_GRUPOS (IdUsuario,IdGrupo)VALUES(?,?)");
            pst.setInt(1, objUser.getIdUsuario());
            pst.setInt(2, codGrupo);
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conectaVC.desconecta();
        return objUser;
    }

    public Usuarios alterarGrupoUsuariosVC(Usuarios objUser) {
        pesquisarGrupoUsuarios(objUser.getNomeGrupo());
        conectaVC.abrirConexao();
        try {
            PreparedStatement pst = conectaVC.con.prepareStatement("UPDATE USUARIOS_GRUPOS SET IdUsuario=?,IdGrupo=? WHERE IdUserGroup='" + objUser.getIdUserGroup() + "'");
            pst.setInt(1, objUser.getIdUsuario());
            pst.setInt(2, codGrupo);
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conectaVC.desconecta();
        return objUser;
    }

    public Usuarios excluirGrupoUsuariosVC(Usuarios objUser) {
        conectaVC.abrirConexao();
        try {
            PreparedStatement pst = conectaVC.con.prepareStatement("DELETE FROM USUARIOS_GRUPOS WHERE IdUserGroup='" + objUser.getIdUserGroup() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conectaVC.desconecta();
        return objUser;
    }

    //BARREIRAS
    public Usuarios incluirGrupoUsuariosBAR(Usuarios objUser) {
        pesquisarGrupoUsuarios(objUser.getNomeGrupo());
        conectaBAR.abrirConexao();
        try {
            PreparedStatement pst = conectaBAR.con.prepareStatement("INSERT INTO USUARIOS_GRUPOS (IdUsuario,IdGrupo)VALUES(?,?)");
            pst.setInt(1, objUser.getIdUsuario());
            pst.setInt(2, codGrupo);
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conectaBAR.desconecta();
        return objUser;
    }

    public Usuarios alterarGrupoUsuariosBAR(Usuarios objUser) {
        pesquisarGrupoUsuarios(objUser.getNomeGrupo());
        conectaBAR.abrirConexao();
        try {
            PreparedStatement pst = conectaBAR.con.prepareStatement("UPDATE USUARIOS_GRUPOS SET IdUsuario=?,IdGrupo=? WHERE IdUserGroup='" + objUser.getIdUserGroup() + "'");
            pst.setInt(1, objUser.getIdUsuario());
            pst.setInt(2, codGrupo);
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conectaBAR.desconecta();
        return objUser;
    }

    public Usuarios excluirGrupoUsuariosBAR(Usuarios objUser) {
        conectaBAR.abrirConexao();
        try {
            PreparedStatement pst = conectaBAR.con.prepareStatement("DELETE FROM USUARIOS_GRUPOS WHERE IdUserGroup='" + objUser.getIdUserGroup() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conectaBAR.desconecta();
        return objUser;
    }

    public void pesquisarGrupoUsuarios(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM GRUPOUSUARIOS WHERE NomeGrupo='" + nome + "'");
            conecta.rs.first();
            codGrupo = conecta.rs.getInt("IdGrupo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
