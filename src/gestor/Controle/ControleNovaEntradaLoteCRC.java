/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.DadosPenaisCrc;
import gestor.Modelo.ProntuarioCrc;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleNovaEntradaLoteCRC {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    DadosPenaisCrc objDadosPena = new DadosPenaisCrc();

    int codIntCrc;
    int codUnid;
    String tipo = "ENTRADA NA UNIDADE";

    public DadosPenaisCrc incluirDadosPenaisInterno(DadosPenaisCrc objDadosPena) {
        buscarIdInternoCrc(objDadosPena.getNomeInternoCrc(), objDadosPena.getIdInternoCrc());
        buscarUnid(objDadosPena.getNomeUnidade());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO HISTORICO_DADOS_PENAIS_INTERNOS (IdInternoCrc,IdUnid,IdEntrada,IdItem,DataEntrada,DataCrime,DataPrisao,"
                    + "DataCondenacao,DataNovaEntrada,VaraCondenatoria,Regime,Pena,Artigo1,Artigo2,Artigo3,Paragrafo1,Paragrafo2,Paragrafo3,"
                    + "TerminoPena,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codIntCrc);
            pst.setInt(2, codUnid);
            pst.setInt(3, objDadosPena.getIdEntrada());
            pst.setInt(4, objDadosPena.getIdItem());
            if (objDadosPena.getDataEntrada() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objDadosPena.getDataEntrada().getTime()));
            } else {
                pst.setDate(5, null);
            }
            if (objDadosPena.getDataCrime() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objDadosPena.getDataCrime().getTime()));
            } else {
                pst.setDate(6, null);
            }
            if (objDadosPena.getDataPrisao() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objDadosPena.getDataPrisao().getTime()));
            } else {
                pst.setDate(7, null);
            }
            if (objDadosPena.getDataCondenacao() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objDadosPena.getDataCondenacao().getTime()));
            } else {
                pst.setDate(8, null);
            }
            if (objDadosPena.getDataNovaEntrada() != null) {
                pst.setTimestamp(9, new java.sql.Timestamp(objDadosPena.getDataNovaEntrada().getTime()));
            } else {
                pst.setDate(9, null);
            }
            pst.setString(10, objDadosPena.getVaraCondenatoria());
            pst.setString(11, objDadosPena.getRegime());
            pst.setString(12, objDadosPena.getPena());
            pst.setString(13, objDadosPena.getArtigo1());
            pst.setString(14, objDadosPena.getArtigo2());
            pst.setString(15, objDadosPena.getArtigo3());
            pst.setString(16, objDadosPena.getParagrafo1());
            pst.setString(17, objDadosPena.getParagrafo2());
            pst.setString(18, objDadosPena.getParagrafo3());
            if (objDadosPena.getTerminoPena() != null) {
                pst.setTimestamp(19, new java.sql.Timestamp(objDadosPena.getTerminoPena().getTime()));
            } else {
                pst.setDate(19, null);
            }
            pst.setString(20, objDadosPena.getUsuarioInsert());
            pst.setString(21, objDadosPena.getDataInsert());
            pst.setString(22, objDadosPena.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível INCLUIR OS DADOS DO INTERNO.\nERROR:" +ex);
        }
        conecta.desconecta();
        return objDadosPena;
    }

    public DadosPenaisCrc alterarDadosPenaisInterno(DadosPenaisCrc objDadosPena) {
        buscarIdInternoCrc(objDadosPena.getNomeInternoCrc(), objDadosPena.getIdInternoCrc());
        buscarUnid(objDadosPena.getNomeUnidade());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICO_DADOS_PENAIS_INTERNOS SET IdInternoCrc=?,IdUnid=?,IdEntrada=?,IdItem=?,DataEntrada=?,DataCrime=?,DataPrisao=?,"
                    + "DataCondenacao=?,DataNovaEntrada=?,VaraCondenatoria=?,Regime=?,Pena=?,Artigo1=?,Artigo2=?,Artigo3=?,Paragrafo1=?,Paragrafo2=?,Paragrafo3=?,"
                    + "TerminoPena=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE IdInternoCrc='" + objDadosPena.getIdInternoCrc() + "' "
                    + "AND IdItem='" + objDadosPena.getIdItem() + "' "
                    + "AND IdEntrada='" + objDadosPena.getIdEntrada() + "'");
            pst.setInt(1, codIntCrc);
            pst.setInt(2, codUnid);
            pst.setInt(3, objDadosPena.getIdEntrada());
            pst.setInt(4, objDadosPena.getIdItem());
            if (objDadosPena.getDataEntrada() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objDadosPena.getDataEntrada().getTime()));
            } else {
                pst.setDate(5, null);
            }
            if (objDadosPena.getDataCrime() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objDadosPena.getDataCrime().getTime()));
            } else {
                pst.setDate(6, null);
            }
            if (objDadosPena.getDataPrisao() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objDadosPena.getDataPrisao().getTime()));
            } else {
                pst.setDate(7, null);
            }
            if (objDadosPena.getDataCondenacao() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objDadosPena.getDataCondenacao().getTime()));
            } else {
                pst.setDate(8, null);
            }
            if (objDadosPena.getDataNovaEntrada() != null) {
                pst.setTimestamp(9, new java.sql.Timestamp(objDadosPena.getDataNovaEntrada().getTime()));
            } else {
                pst.setDate(9, null);
            }
            pst.setString(10, objDadosPena.getVaraCondenatoria());
            pst.setString(11, objDadosPena.getRegime());
            pst.setString(12, objDadosPena.getPena());
            pst.setString(13, objDadosPena.getArtigo1());
            pst.setString(14, objDadosPena.getArtigo2());
            pst.setString(15, objDadosPena.getArtigo3());
            pst.setString(16, objDadosPena.getParagrafo1());
            pst.setString(17, objDadosPena.getParagrafo2());
            pst.setString(18, objDadosPena.getParagrafo3());
            if (objDadosPena.getTerminoPena() != null) {
                pst.setTimestamp(19, new java.sql.Timestamp(objDadosPena.getTerminoPena().getTime()));
            } else {
                pst.setDate(19, null);
            }
            pst.setString(20, objDadosPena.getUsuarioUp());
            pst.setString(21, objDadosPena.getDataUp());
            pst.setString(22, objDadosPena.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível ALTERAR os dados do interno.\nERROR: " +ex);
        }
        conecta.desconecta();
        return objDadosPena;
    }

    public DadosPenaisCrc excluirDadosPenaisInterno(DadosPenaisCrc objDadosPena) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELET FROM HISTORICO_DADOS_PENAIS_INTERNOS "
                    + "WHERE IdInternoCrc='" + objDadosPena.getIdInternoCrc() + "' "
                    + "AND IdItem='" + objDadosPena.getIdItem() + "' "
                    + "AND IdEntrada='" + objDadosPena.getIdEntrada() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível EXCLUIR os dados do interno. !!!");
        }
        conecta.desconecta();
        return objDadosPena;
    }

    public void buscarIdInternoCrc(String nome, int id) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nome + "' "
                    + "AND IdInternoCrc='" + id + "'");
            conecta.rs.first();
            codIntCrc = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (FISICOS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    // Buscar o código da UNIDADE PENAL para incluir junto com os dados fisicos (RELACIONAMENTO)
    public void buscarUnid(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM UNIDADE "
                    + "WHERE DescricaoUnid='" + nome + "'");
            conecta.rs.first();
            codUnid = conecta.rs.getInt("IdUnid");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (UNIDADE) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
