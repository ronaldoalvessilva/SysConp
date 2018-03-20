/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AbrirMovimentos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAbrirMovimentacao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AbrirMovimentos objAbriNov = new AbrirMovimentos();

    public AbrirMovimentos alterarEntradaFamiliar(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASFAMILIAR SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarEntradaAdvogadosInternos(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASADVINTERNOS SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarEntradaAdvogadosDepartamento(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASADVOGADOS SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarEntradaVisitasDiversas(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASVISITAS SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarEntradaColaboradores(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASFUNC SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarEntradaVeiculosUnidade(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAVEICULOSUNIDADE SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarEntradaVeiculosCarga(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAVEICULOCARGA SET StatusEnt=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarEntradaVeiculosTerceiro(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAVEICULOSTERCEIRO SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarEntradaLaborativa(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADALABORINTERNO SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarRetornoInternos(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGRETORNO SET StatusRet=? WHERE IdRetorno='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarEntradaInterUnidade(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAINTERNOSPORTARIA SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }
     public AbrirMovimentos alterarSaidaInterUnidade(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGSAIDACRC SET StatusSai=? WHERE IdSaida='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }
     
      public AbrirMovimentos alterarMovPertences(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAPERTENCES SET SituacaoEnt=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }
      public AbrirMovimentos alterarMovDeposito(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DEPOSITOPORTARIA SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }
      public AbrirMovimentos alterarOcorrenciasP1(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_P1 SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }
}
