/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EvadidoIndividual;
import gestor.Modelo.ItensEntradaSaidaLaborInterno;
import gestor.Modelo.ItensSaidaInterno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleObitoInterno {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EvadidoIndividual objEvadidoInd = new EvadidoIndividual();
    ItensEntradaSaidaLaborInterno objItenLabor = new ItensEntradaSaidaLaborInterno();
    ItensSaidaInterno objItemSaida = new ItensSaidaInterno();

    public EvadidoIndividual incluirObitoInterno(EvadidoIndividual objEvadidoInd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO OBITOS_INTERNOS_EXTERNO (StatusLanc,TipoOp,DataLanc,TipoObito,IdInternoCrc,NrDocSaida,Observacao,UsuarioInsert,DataInsert,HorarioInsert,IdSaida,DataSaida) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objEvadidoInd.getStatusLanc());
            pst.setString(2, objEvadidoInd.getTipoOperacao());
            pst.setTimestamp(3, new java.sql.Timestamp(objEvadidoInd.getDataEvasao().getTime()));
            pst.setInt(4, objEvadidoInd.getTipoEvasao());
            pst.setInt(5, objEvadidoInd.getIdInternoCrc());
            pst.setInt(6, objEvadidoInd.getNrDocSaida());
            pst.setString(7, objEvadidoInd.getObservacao());
            pst.setString(8, objEvadidoInd.getUsuarioInsert());
            pst.setString(9, objEvadidoInd.getDataInsert());
            pst.setString(10, objEvadidoInd.getHorarioInsert());
            pst.setInt(11, objEvadidoInd.getIdSaida());
            if (objEvadidoInd.getDataLanc() != null) {
                pst.setTimestamp(12, new java.sql.Timestamp(objEvadidoInd.getDataLanc().getTime()));
            } else {
                pst.setDate(12, null);
            }
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEvadidoInd;
    }

    public EvadidoIndividual alterarObitoInterno(EvadidoIndividual objEvadidoInd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OBITOS_INTERNOS_EXTERNO SET StatusLanc=?,TipoOp=?,DataLanc=?,TipoObito=?,IdInternoCrc=?,NrDocSaida=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=?,IdSaida=?,DataSaida=? WHERE IdInternoCrc='" + objEvadidoInd.getIdInternoCrc() + "'AND IdLanc='" + objEvadidoInd.getIdLanc() + "'");
            pst.setString(1, objEvadidoInd.getStatusLanc());
            pst.setString(2, objEvadidoInd.getTipoOperacao());
            pst.setTimestamp(3, new java.sql.Timestamp(objEvadidoInd.getDataLanc().getTime()));
            pst.setInt(4, objEvadidoInd.getTipoEvasao());
            pst.setInt(5, objEvadidoInd.getIdInternoCrc());
            pst.setInt(6, objEvadidoInd.getNrDocSaida());
            pst.setString(7, objEvadidoInd.getObservacao());
            pst.setString(8, objEvadidoInd.getUsuarioUp());
            pst.setString(9, objEvadidoInd.getDataUp());
            pst.setString(10, objEvadidoInd.getHorarioUp());
            pst.setInt(11, objEvadidoInd.getIdSaida());
            if (objEvadidoInd.getDataLanc() != null) {
                pst.setTimestamp(12, new java.sql.Timestamp(objEvadidoInd.getDataLanc().getTime()));
            } else {
                pst.setDate(12, null);
            }
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEvadidoInd;
    }

    public EvadidoIndividual excluirObitoInterno(EvadidoIndividual objEvadidoInd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM OBITOS_INTERNOS_EXTERNO WHERE IdInternoCrc='" + objEvadidoInd.getIdInternoCrc() + "'AND IdLanc='" + objEvadidoInd.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEvadidoInd;
    }

    public EvadidoIndividual finalizarObitoInterno(EvadidoIndividual objEvadidoInd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OBITOS_INTERNOS_EXTERNO SET StatusLanc=? WHERE IdInternoCrc='" + objEvadidoInd.getIdInternoCrc() + "'AND IdLanc='" + objEvadidoInd.getIdLanc() + "'");
            pst.setString(1, objEvadidoInd.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEvadidoInd;
    }
//---------------------------------------------------------------- SAIDA LABORATIVA ÓBITO ------------------------
    // SAIDA LABORATIVA ÓBITO   

    public ItensEntradaSaidaLaborInterno incluirEvasaoInterno(ItensEntradaSaidaLaborInterno objItenLabor) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSLABORINTERNO SET Obito=? WHERE IdInternoCrc='" + objItenLabor.getIdInternoCrc() + "'AND IdLanc='" + objItenLabor.getIdLanc() + "'");
            pst.setString(1, objItenLabor.getInternoEvadido());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR Óbito do Interno\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItenLabor;
    }

    // ATUALIZAR STATUS DA TABELA ENTRADALABORINTERNO
    public ItensEntradaSaidaLaborInterno atualizarStatus(ItensEntradaSaidaLaborInterno objItenLabor) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADALABORINTERNO SET StatusLanc=? WHERE IdLanc='" + objItenLabor.getIdLanc() + "'");
            pst.setString(1, objItenLabor.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR Entrada/Saída laborativa do Interno\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItenLabor;
    }

    // SAIDA LABORATIVA EVASÃO MANUAL (MOVISR) INCLUIR O REGISTRO PARA CAPTURA DO INTERNO
    public ItensSaidaInterno incluirEvasaoInternoSaidaLaborativa(ItensSaidaInterno objItemSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVISR (IdInternoCrc,IdSaida,DataSaida,NrDocSaida,DataEvasao,ConfirmaEvasao) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objItemSaida.getIdInternoSaida());
            pst.setInt(2, objItemSaida.getIdSaida());
            pst.setTimestamp(3, new java.sql.Timestamp(objItemSaida.getDataSaida().getTime()));
            pst.setString(4, objItemSaida.getDocumento());
            pst.setTimestamp(5, new java.sql.Timestamp(objItemSaida.getDataEvasaoTmp().getTime()));
            pst.setString(6, objItemSaida.getConfirmaEvasao());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INCLUIR Evasão do Interno\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }

    // SAIDA LABORATIVA EVASÃO MANUAL (MOVISR) ALTERAR O REGISTRO PARA CAPTURA DO INTERNO
    public ItensSaidaInterno alterarEvasaoInternoSaidaLaborativa(ItensSaidaInterno objItemSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVISR SET IdInternoCrc=?,IdSaida=?,DataSaida=?,NrDocSaida=?,DataEvasao=?,ConfirmaEvasao=? WHERE IdInternoCrc'" + objItemSaida.getIdInternoSaida() + "'AND IdSaida='" + objItemSaida.getIdSaida() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objItemSaida.getDataSaida().getTime()));
            pst.setString(2, objItemSaida.getDocumento());
            pst.setTimestamp(3, new java.sql.Timestamp(objItemSaida.getDataEvasaoTmp().getTime()));
            pst.setString(4, objItemSaida.getConfirmaEvasao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR Evasão do Interno\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }

    //----------------------------------------- SAIDA TEMPORARIA EVASÃO  -------------------------------------------
    public ItensSaidaInterno alterarObitoInternoSaidaTmp(ItensSaidaInterno objItemSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSSAIDA SET Obito=?,ConfirmaObito=? WHERE IdInternoCrc='" + objItemSaida.getIdInternoSaida() + "'AND DocumentoSaida='" + objItemSaida.getDocumento() + "'");
            pst.setString(1, objItemSaida.getInternoEvadido());
            pst.setString(2, objItemSaida.getConfirmaEvasao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR Óbito do Interno\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }

    public ItensSaidaInterno confirmaEvasaoInternoSaidaTmp(ItensSaidaInterno objItemSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVISR SET ConfirmaEvasao=?,DataEvasao=? WHERE IdInternoCrc='" + objItemSaida.getIdInternoSaida() + "'AND NrDocSaida='" + objItemSaida.getDocumento() + "'");
            pst.setString(1, objItemSaida.getConfirmaEvasao());
            if (objItemSaida.getDataEvasaoTmp() == null) {
                pst.setTimestamp(2, null);
            } else {
                pst.setTimestamp(2, new java.sql.Timestamp(objItemSaida.getDataEvasaoTmp().getTime()));
            }
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR Evasão do Interno\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }

    //------------------------------ SAIDA EDUCACIONAL - PORTARIA E PEDAGOGIA --------------------------------------------
    public ItensEntradaSaidaLaborInterno incluirEvasaoEducacionalInternoPortaria(ItensEntradaSaidaLaborInterno objItenLabor) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INTERNOS_ENTRADA_SAIDA_EDUCACAO SET Observacao=?,Obito=? WHERE IdInternoCrc='" + objItenLabor.getIdInternoCrc() + "'AND HorarioEntrada='" + objItenLabor.getHorarioEntrada() + "'");
            pst.setString(1, objItenLabor.getInternoEvadido());
            pst.setString(2, objItenLabor.getObservacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR Evasão do Interno\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItenLabor;
    }

    // ------------------------------ PEDAGOGIA -----------------------------------------
    public ItensEntradaSaidaLaborInterno incluirEvasaoEducacionalInternoPedagogia(ItensEntradaSaidaLaborInterno objItenLabor) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INTERNOS_SAIDA_EDUCACIONAL SET Obito=? WHERE IdInternoCrc='" + objItenLabor.getIdInternoCrc() + "'");
            pst.setString(1, objItenLabor.getInternoEvadido());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR Evasão do Interno\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItenLabor;
    }

    //----- SAIDA AUDIENCIA - OBITO
    public ItensSaidaInterno alterarObitoInternoSaidaAudiencia(ItensSaidaInterno objItemSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSSAIDA SET Obito=?,ConfirmaObito=? WHERE IdInternoCrc='" + objItemSaida.getIdInternoSaida() + "'AND DocumentoSaida='" + objItemSaida.getDocumento() + "'");
            pst.setString(1, objItemSaida.getObito());
            pst.setString(2, objItemSaida.getConfirmaObito());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR óbito do Interno\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }

    public ItensSaidaInterno alterarObitoInternoSaidaPD(ItensSaidaInterno objItemSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSSAIDA SET Obito=?,ConfirmaObito=? WHERE IdInternoCrc='" + objItemSaida.getIdInternoSaida() + "'AND DocumentoSaida='" + objItemSaida.getDocumento() + "'");
            pst.setString(1, objItemSaida.getInternoEvadido());
            pst.setString(2, objItemSaida.getConfirmaEvasao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR Óbito do Interno\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }
}
