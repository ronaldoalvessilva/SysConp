/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import static gestor.Visao.BaralhoCrimeUnidadePrisional.CODIGO_CONFIRMACAO_GRAVACAO;
import gestor.Modelo.OrganogramaCrime;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleOrganogramaCrime {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    OrganogramaCrime objOrg = new OrganogramaCrime();

    int codigoInterno = 0;
    int codigoPav = 0;
    int codigoCela = 0;

    public OrganogramaCrime incluirOrganograma_PRINCIPAL(OrganogramaCrime objOrg) {
        buscarInternoCrc(objOrg.getNomeInterno(), objOrg.getIdInternoCrc());
        buscarPavilhao(objOrg.getDescricaoPav());
        buscarCela(objOrg.getDescricaoCela());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ORGANOGRAMA_CRIME (StatusOrg,DataOrg,IdInternoCrc,CartaBaralho,Faccao,IdPav,IdCela,Recompensa,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objOrg.getStatusOrg());
            pst.setTimestamp(2, new java.sql.Timestamp(objOrg.getDataOrg().getTime()));
            pst.setInt(3, codigoInterno);
            pst.setBytes(4, objOrg.getCartaBaralho());
            pst.setString(5, objOrg.getFaccao());
            pst.setInt(6, codigoPav);
            pst.setInt(7, codigoCela);
            pst.setDouble(8, objOrg.getRecompensa());
            pst.setString(9, objOrg.getUsuarioInsert());
            pst.setString(10, objOrg.getDataInsert());
            pst.setString(11, objOrg.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            CODIGO_CONFIRMACAO_GRAVACAO = 1;
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime alterarOrganograma_PRINCIPAL(OrganogramaCrime objOrg) {
        buscarInternoCrc(objOrg.getNomeInterno(), objOrg.getIdInternoCrc());
        buscarPavilhao(objOrg.getDescricaoPav());
        buscarCela(objOrg.getDescricaoCela());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ORGANOGRAMA_CRIME SET StatusOrg,DataOrg,IdInternoCrc,CartaBaralho,Faccao,IdPav,IdCela,Recompensa,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdOrg='" + objOrg.getIdOrg() + "'");
            pst.setString(1, objOrg.getStatusOrg());
            pst.setTimestamp(2, new java.sql.Timestamp(objOrg.getDataOrg().getTime()));
            pst.setInt(3, codigoInterno);
            pst.setBytes(4, objOrg.getCartaBaralho());
            pst.setString(5, objOrg.getFaccao());
            pst.setInt(6, codigoPav);
            pst.setInt(7, codigoCela);
            pst.setDouble(8, objOrg.getRecompensa());
            pst.setString(9, objOrg.getUsuarioUp());
            pst.setString(10, objOrg.getDataUp());
            pst.setString(11, objOrg.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            CODIGO_CONFIRMACAO_GRAVACAO = 1;
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime excluirOrganograma_PRINCIPAL(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ORGANOGRAMA_CRIME WHERE IdOrg='" + objOrg.getIdOrg() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    //------------ LIGAÇÕES DO ORGANOGRAMA - INCLUSÕES, ALTERAÇÕES E EXCLUSÕES ---------------------------------------
    // PRIMEIRA ESCALÃO
    public OrganogramaCrime incluirL1A_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO L1A_ORGANOGRAMA_CRIME (IdOrg,IdInternoCrc,Observacao) VALUES(?,?,?)");
            pst.setInt(1, objOrg.getIdOrg());
            pst.setInt(2, objOrg.getIdInternoCrcL1A());
            pst.setString(3, objOrg.getObservacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INCLUIR (L1A) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime alterarL1A_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE L1A_ORGANOGRAMA_CRIME SET IdInternoCrc=?,Observacao=? WHERE IdOrg='" + objOrg.getIdOrg() + "'");
            pst.setInt(1, objOrg.getIdInternoCrcL1A());
            pst.setString(2, objOrg.getObservacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (L1A) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime excluirL1A_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM L1A_ORGANOGRAMA_CRIME IdOrg='" + objOrg.getIdOrg() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (L1A) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime incluirL1B_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO L1B_ORGANOGRAMA_CRIME (IdOrg,IdInternoCrc) VALUES(?,?)");
            pst.setInt(1, objOrg.getIdOrg());
            pst.setInt(2, objOrg.getIdInternoCrcL1A());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INCLUIR (L1B) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime alterarL1B_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE L1B_ORGANOGRAMA_CRIME SET IdInternoCrc=? WHERE IdOrg='" + objOrg.getIdOrg() + "'");
            pst.setInt(1, objOrg.getIdInternoCrcL1A());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (L1B) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime excluirL1B_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM L1B_ORGANOGRAMA_CRIME IdOrg='" + objOrg.getIdOrg() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (L1B) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime incluirL1C_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO L1C_ORGANOGRAMA_CRIME (IdOrg,IdInternoCrc) VALUES(?,?)");
            pst.setInt(1, objOrg.getIdOrg());
            pst.setInt(2, objOrg.getIdInternoCrcL1A());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INCLUIR (L1C) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime alterarL1C_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE L1C_ORGANOGRAMA_CRIME SET IdInternoCrc=? WHERE IdOrg='" + objOrg.getIdOrg() + "'");
            pst.setInt(1, objOrg.getIdInternoCrcL1A());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (L1C) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime excluirL1C_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM L1C_ORGANOGRAMA_CRIME IdOrg='" + objOrg.getIdOrg() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (L1C) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime incluirL1D_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO L1D_ORGANOGRAMA_CRIME (IdOrg,IdInternoCrc) VALUES(?,?)");
            pst.setInt(1, objOrg.getIdOrg());
            pst.setInt(2, objOrg.getIdInternoCrcL1A());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INCLUIR (L1D) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime alterarL1D_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE L1D_ORGANOGRAMA_CRIME SET IdInternoCrc=? WHERE IdOrg='" + objOrg.getIdOrg() + "'");
            pst.setInt(1, objOrg.getIdInternoCrcL1A());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (L1D) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime excluirL1D_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM L1D_ORGANOGRAMA_CRIME IdOrg='" + objOrg.getIdOrg() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (L1D) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }
    //---- SEGUNDO ESCALÃO--------------------------------------------

    public OrganogramaCrime incluirL2A_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO L2A_ORGANOGRAMA_CRIME (IdOrg,IdInternoCrc,Observacao) VALUES(?,?,?)");
            pst.setInt(1, objOrg.getIdOrg());
            pst.setInt(2, objOrg.getIdInternoCrcL1A());
            pst.setString(3, objOrg.getObservacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INCLUIR (L2A) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime alterarL2A_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE L2A_ORGANOGRAMA_CRIME SET IdInternoCrc=?,Observacao=? WHERE IdOrg='" + objOrg.getIdOrg() + "'");
            pst.setInt(1, objOrg.getIdInternoCrcL1A());
            pst.setString(2, objOrg.getObservacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (L2A) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime excluirL2A_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM L2A_ORGANOGRAMA_CRIME IdOrg='" + objOrg.getIdOrg() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (L2A) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime incluirL2B_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO L2B_ORGANOGRAMA_CRIME (IdOrg,IdInternoCrc) VALUES(?,?)");
            pst.setInt(1, objOrg.getIdOrg());
            pst.setInt(2, objOrg.getIdInternoCrcL1A());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INCLUIR (L2B) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime alterarL2B_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE L2B_ORGANOGRAMA_CRIME SET IdInternoCrc=? WHERE IdOrg='" + objOrg.getIdOrg() + "'");
            pst.setInt(1, objOrg.getIdInternoCrcL1A());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (L2B) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime excluirL2B_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM L2B_ORGANOGRAMA_CRIME IdOrg='" + objOrg.getIdOrg() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (L2B) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime incluirL2C_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO L2C_ORGANOGRAMA_CRIME (IdOrg,IdInternoCrc) VALUES(?,?)");
            pst.setInt(1, objOrg.getIdOrg());
            pst.setInt(2, objOrg.getIdInternoCrcL1A());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INCLUIR (L2C) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime alterarL2C_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE L2C_ORGANOGRAMA_CRIME SET IdInternoCrc=? WHERE IdOrg='" + objOrg.getIdOrg() + "'");
            pst.setInt(1, objOrg.getIdInternoCrcL1A());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (L2C) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime excluirL2C_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM L2C_ORGANOGRAMA_CRIME IdOrg='" + objOrg.getIdOrg() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (L2C) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime incluirL2D_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO L2D_ORGANOGRAMA_CRIME (IdOrg,IdInternoCrc) VALUES(?,?)");
            pst.setInt(1, objOrg.getIdOrg());
            pst.setInt(2, objOrg.getIdInternoCrcL1A());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INCLUIR (L2D) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime alterarL2D_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE L2D_ORGANOGRAMA_CRIME SET IdInternoCrc=? WHERE IdOrg='" + objOrg.getIdOrg() + "'");
            pst.setInt(1, objOrg.getIdInternoCrcL1A());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (L2D) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime excluirL2D_Organograma(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM L2D_ORGANOGRAMA_CRIME IdOrg='" + objOrg.getIdOrg() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (L2D) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    //----------------------------------- FIM DO MÉTODO -------------------------------------------------
    public void buscarInternoCrc(String nome, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nome + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarPavilhao(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO "
                    + "WHERE DescricaoPav='" + desc + "'");
            conecta.rs.first();
            codigoPav = conecta.rs.getInt("IdPav");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (PAVILHAO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarCela(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CELAS "
                    + "WHERE EndCelaPav='" + desc + "'");
            conecta.rs.first();
            codigoCela = conecta.rs.getInt("IdCela");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (CELAS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
