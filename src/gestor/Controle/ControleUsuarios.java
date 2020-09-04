/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import Utilitarios.Criptografia;
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
public class ControleUsuarios {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ConexaoBancoDadosLF conectaLF = new ConexaoBancoDadosLF();
    ConexaoBancoDadosSSA conectaSSA = new ConexaoBancoDadosSSA();
    ConexaoBancoDadosITB conectaITB = new ConexaoBancoDadosITB();
    ConexaoBancoDadosVC conectaVC = new ConexaoBancoDadosVC();
    ConexaoBancoDadosBAR conectaBAR = new ConexaoBancoDadosBAR();
    //
    Usuarios objUser = new Usuarios();
    int codGrupo;

    public Usuarios incluirUsuarios(Usuarios objUser) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO USUARIOS (StatusUsuario,DataCadastro,NomeUsuario,NomeDepartamento,NomeCargo,LoginUsuario,SenhaUsuario,ConfirmaSenhaUsuario,AcessoTodasUnidades,DataSenha)VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objUser;
    }

    public Usuarios alterarUsuarios(Usuarios objUser) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE USUARIOS SET StatusUsuario=?,DataCadastro=?,NomeUsuario=?,NomeDepartamento=?,NomeCargo=?,LoginUsuario=?,SenhaUsuario=?,ConfirmaSenhaUsuario=?,AcessoTodasUnidades=?,DataSenha=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objUser;
    }

    public Usuarios excluirUsuarios(Usuarios objUser) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM USUARIOS WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objUser;
    }

    public Usuarios trocarSenhaUsuario(Usuarios objUser) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE USUARIOS SET DataSenha=?,SenhaUsuario=?,ConfirmaSenhaUsuario=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            pst.setString(2, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(3, Criptografia.criptografar(objUser.getSenha2()));
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO:" + ex);
        }
        conecta.desconecta();
        return objUser;
    }

    //------------------------------------------ MANTER USUARIOS DO SISTEMA PARA OUTRAS UNIDADES ---------------------------------------
    
    //------------------------------------------    LAURO DE FREITAS ---------------------------------------------------------------
    public Usuarios incluirUsuariosLF(Usuarios objUser) {

        conectaLF.abrirConexao();
        try {
            PreparedStatement pst = conectaLF.con.prepareStatement("INSERT INTO USUARIOS (StatusUsuario,DataCadastro,NomeUsuario,NomeDepartamento,NomeCargo,LoginUsuario,SenhaUsuario,ConfirmaSenhaUsuario,AcessoTodasUnidades,DataSenha)VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conectaLF.desconecta();
        return objUser;
    }

    public Usuarios alterarUsuariosLF(Usuarios objUser) {

        conectaLF.abrirConexao();
        try {
            PreparedStatement pst = conectaLF.con.prepareStatement("UPDATE USUARIOS SET StatusUsuario=?,DataCadastro=?,NomeUsuario=?,NomeDepartamento=?,NomeCargo=?,LoginUsuario=?,SenhaUsuario=?,ConfirmaSenhaUsuario=?,AcessoTodasUnidades=?,DataSenha=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conectaLF.desconecta();
        return objUser;
    }

    public Usuarios excluirUsuariosLF(Usuarios objUser) {

        conectaLF.abrirConexao();
        try {
            PreparedStatement pst = conectaLF.con.prepareStatement("DELETE FROM USUARIOS WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conectaLF.desconecta();
        return objUser;
    }

    public Usuarios trocarSenhaUsuarioLF(Usuarios objUser) {

        conectaLF.abrirConexao();
        try {
            PreparedStatement pst = conectaLF.con.prepareStatement("UPDATE USUARIOS SET DataSenha=?,SenhaUsuario=?,ConfirmaSenhaUsuario=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            pst.setString(2, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(3, Criptografia.criptografar(objUser.getSenha2()));
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO:" + ex);
        }
        conectaLF.desconecta();
        return objUser;
    }
    //-------------------------------------------- VITÓRIA DA CONQUISTA -------------------------------------------------

    public Usuarios incluirUsuariosVC(Usuarios objUser) {

        conectaVC.abrirConexao();
        try {
            PreparedStatement pst = conectaVC.con.prepareStatement("INSERT INTO USUARIOS (StatusUsuario,DataCadastro,NomeUsuario,NomeDepartamento,NomeCargo,LoginUsuario,SenhaUsuario,ConfirmaSenhaUsuario,AcessoTodasUnidades,DataSenha)VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conectaVC.desconecta();
        return objUser;
    }

    public Usuarios alterarUsuariosVC(Usuarios objUser) {

        conectaVC.abrirConexao();
        try {
            PreparedStatement pst = conectaVC.con.prepareStatement("UPDATE USUARIOS SET StatusUsuario=?,DataCadastro=?,NomeUsuario=?,NomeDepartamento=?,NomeCargo=?,LoginUsuario=?,SenhaUsuario=?,ConfirmaSenhaUsuario=?,AcessoTodasUnidades=?,DataSenha=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conectaVC.desconecta();
        return objUser;
    }

    public Usuarios excluirUsuariosVC(Usuarios objUser) {

        conectaVC.abrirConexao();
        try {
            PreparedStatement pst = conectaVC.con.prepareStatement("DELETE FROM USUARIOS WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conectaVC.desconecta();
        return objUser;
    }

    public Usuarios trocarSenhaUsuarioVC(Usuarios objUser) {

        conectaVC.abrirConexao();
        try {
            PreparedStatement pst = conectaVC.con.prepareStatement("UPDATE USUARIOS SET DataSenha=?,SenhaUsuario=?,ConfirmaSenhaUsuario=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            pst.setString(2, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(3, Criptografia.criptografar(objUser.getSenha2()));
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO:" + ex);
        }
        conectaVC.desconecta();
        return objUser;
    }

    //----------------------------------------------------- ITABUNA --------------------------------------
    public Usuarios incluirUsuariosITB(Usuarios objUser) {

        conectaITB.abrirConexao();
        try {
            PreparedStatement pst = conectaITB.con.prepareStatement("INSERT INTO USUARIOS (StatusUsuario,DataCadastro,NomeUsuario,NomeDepartamento,NomeCargo,LoginUsuario,SenhaUsuario,ConfirmaSenhaUsuario,AcessoTodasUnidades,DataSenha)VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conectaITB.desconecta();
        return objUser;
    }

    public Usuarios alterarUsuariosITB(Usuarios objUser) {

        conectaITB.abrirConexao();
        try {
            PreparedStatement pst = conectaITB.con.prepareStatement("UPDATE USUARIOS SET StatusUsuario=?,DataCadastro=?,NomeUsuario=?,NomeDepartamento=?,NomeCargo=?,LoginUsuario=?,SenhaUsuario=?,ConfirmaSenhaUsuario=?,AcessoTodasUnidades=?,DataSenha=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conectaITB.desconecta();
        return objUser;
    }

    public Usuarios excluirUsuariosITB(Usuarios objUser) {

        conectaITB.abrirConexao();
        try {
            PreparedStatement pst = conectaITB.con.prepareStatement("DELETE FROM USUARIOS WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conectaITB.desconecta();
        return objUser;
    }

    public Usuarios trocarSenhaUsuarioITB(Usuarios objUser) {

        conectaITB.abrirConexao();
        try {
            PreparedStatement pst = conectaITB.con.prepareStatement("UPDATE USUARIOS SET DataSenha=?,SenhaUsuario=?,ConfirmaSenhaUsuario=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            pst.setString(2, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(3, Criptografia.criptografar(objUser.getSenha2()));
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO:" + ex);
        }
        conectaITB.desconecta();
        return objUser;
    }

    //------------------------------------------------- SALVADOR ----------------------------------------------------------------------------------
    public Usuarios incluirUsuariosSSA(Usuarios objUser) {

        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("INSERT INTO USUARIOS (StatusUsuario,DataCadastro,NomeUsuario,NomeDepartamento,NomeCargo,LoginUsuario,SenhaUsuario,ConfirmaSenhaUsuario,AcessoTodasUnidades,DataSenha)VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conectaSSA.desconecta();
        return objUser;
    }

    public Usuarios alterarUsuariosSSA(Usuarios objUser) {

        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("UPDATE USUARIOS SET StatusUsuario=?,DataCadastro=?,NomeUsuario=?,NomeDepartamento=?,NomeCargo=?,LoginUsuario=?,SenhaUsuario=?,ConfirmaSenhaUsuario=?,AcessoTodasUnidades=?,DataSenha=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conectaSSA.desconecta();
        return objUser;
    }

    public Usuarios excluirUsuariosSSA(Usuarios objUser) {

        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("DELETE FROM USUARIOS WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conectaSSA.desconecta();
        return objUser;
    }

    public Usuarios trocarSenhaUsuarioSSA(Usuarios objUser) {

        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("UPDATE USUARIOS SET DataSenha=?,SenhaUsuario=?,ConfirmaSenhaUsuario=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            pst.setString(2, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(3, Criptografia.criptografar(objUser.getSenha2()));
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO:" + ex);
        }
        conectaSSA.desconecta();
        return objUser;
    }

    //----------------------------------------------- BARREIRAS ------------------------------------------------------------------------
    public Usuarios incluirUsuariosBAR(Usuarios objUser) {

        conectaBAR.abrirConexao();
        try {
            PreparedStatement pst = conectaBAR.con.prepareStatement("INSERT INTO USUARIOS (StatusUsuario,DataCadastro,NomeUsuario,NomeDepartamento,NomeCargo,LoginUsuario,SenhaUsuario,ConfirmaSenhaUsuario,AcessoTodasUnidades,DataSenha)VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conectaBAR.desconecta();
        return objUser;
    }

    public Usuarios alterarUsuariosBAR(Usuarios objUser) {

        conectaBAR.abrirConexao();
        try {
            PreparedStatement pst = conectaBAR.con.prepareStatement("UPDATE USUARIOS SET StatusUsuario=?,DataCadastro=?,NomeUsuario=?,NomeDepartamento=?,NomeCargo=?,LoginUsuario=?,SenhaUsuario=?,ConfirmaSenhaUsuario=?,AcessoTodasUnidades=?,DataSenha=?WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conectaBAR.desconecta();
        return objUser;
    }

    public Usuarios excluirUsuariosBAR(Usuarios objUser) {

        conectaBAR.abrirConexao();
        try {
            PreparedStatement pst = conectaBAR.con.prepareStatement("DELETE FROM USUARIOS WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conectaBAR.desconecta();
        return objUser;
    }

    public Usuarios trocarSenhaUsuarioBAR(Usuarios objUser) {

        conectaBAR.abrirConexao();
        try {
            PreparedStatement pst = conectaBAR.con.prepareStatement("UPDATE USUARIOS SET DataSenha=?,SenhaUsuario=?,ConfirmaSenhaUsuario=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            pst.setString(2, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(3, Criptografia.criptografar(objUser.getSenha2()));
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO:" + ex);
        }
        conectaBAR.desconecta();
        return objUser;
    }
}
