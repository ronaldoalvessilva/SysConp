/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.DadosPenaisCrc;
import gestor.Modelo.ProntuarioCrc;
import static gestor.Visao.TelaProntuarioCrc.pRESPOSTA_DADOS_penais;
import static gestor.Visao.TelaProntuarioCrc.pRESPOSTA_EXCLUSÃO_fisicos;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleDadosPenais {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    DadosPenaisCrc objDadosPena = new DadosPenaisCrc();

    int codIntCrc;
    int codUnid;
    String tipo = "ENTRADA NA UNIDADE";

    // Incluir DADOS PENAIS INTERNO CRC
    public DadosPenaisCrc incluirDadosPenais(DadosPenaisCrc objDadosPena) {
        BUSCAR_CODIGO_interno(objDadosPena.getNomeInternoCrc(), objDadosPena.getNomeMaeInternoCrc());
        BUSCAR_CODIGO_unidade(objDadosPena.getNomeUnidade());
        conecta.abrirConexao();
        // Incluir Registro na tabela de INTERNOS CRC
        try (PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO DADOSPENAISINTERNOS (DataEntrada,DataCrime,DataPrisao,"
                + "DataCondenacao,Participacao,Regime,Pena,Artigo1,Artigo2,Artigo3,Paragrafo1,Paragrafo2,Paragrafo3,"
                + "CrimeEdiondo,TerminoPena,IdInternoCrc,IdUnid,Identificador,Identificador1,Identificador2,Identificador3,Perfil,RegiaoCorpo,RegiaoCorpo1,RegiaoCorpo2,"
                + "FotoPerfil,FotoCorpo,FotoCorpo1,FotoCorpo2,VaraCondenatoria,DataNovaEntrada,ImagemPerfil,ImagemCorpo,ImagemCorpo1,ImagemCorpo2) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
            pst.setTimestamp(1, new java.sql.Timestamp(objDadosPena.getDataEntrada().getTime()));
            pst.setTimestamp(2, new java.sql.Timestamp(objDadosPena.getDataCrime().getTime()));
            pst.setTimestamp(3, new java.sql.Timestamp(objDadosPena.getDataPrisao().getTime()));
            pst.setTimestamp(4, new java.sql.Timestamp(objDadosPena.getDataCondenacao().getTime()));
            pst.setString(5, objDadosPena.getParticipacao());
            pst.setString(6, objDadosPena.getRegime());
            pst.setString(7, objDadosPena.getPena());
            pst.setString(8, objDadosPena.getArtigo1());
            pst.setString(9, objDadosPena.getArtigo2());
            pst.setString(10, objDadosPena.getArtigo3());
            pst.setString(11, objDadosPena.getParagrafo1());
            pst.setString(12, objDadosPena.getParagrafo2());
            pst.setString(13, objDadosPena.getParagrafo3());
            pst.setString(14, objDadosPena.getCrimeEdiondo());
            if (objDadosPena.getTerminoPena() != null) {
                pst.setTimestamp(15, new java.sql.Timestamp(objDadosPena.getTerminoPena().getTime()));
            } else {
                pst.setDate(15, null);
            }
            pst.setInt(16, codIntCrc);
            pst.setInt(17, codUnid);
            pst.setString(18, objDadosPena.getIdentificador());
            pst.setString(19, objDadosPena.getIdentificador1());
            pst.setString(20, objDadosPena.getIdentificador2());
            pst.setString(21, objDadosPena.getIdentificador3());
            if (objDadosPena.getPerfil() != null) {
                pst.setString(22, objDadosPena.getPerfil());
            } else {
                pst.setString(22, null);
            }
            if (objDadosPena.getRegiaoCorpo() != null) {
                pst.setString(23, objDadosPena.getRegiaoCorpo());
            } else {
                pst.setString(23, null);
            }
            if (objDadosPena.getRegiaoCorpo1() != null) {
                pst.setString(24, objDadosPena.getRegiaoCorpo1());
            } else {
                pst.setString(24, null);
            }
            if (objDadosPena.getRegiaoCorpo2() != null) {
                pst.setString(25, objDadosPena.getRegiaoCorpo2());
            } else {
                pst.setString(25, null);
            }
            if (objDadosPena.getFotoPerfil() != null) {
                pst.setString(26, objDadosPena.getFotoPerfil());
            } else {
                pst.setString(26, null);
            }
            if (objDadosPena.getFotoCorpo() != null) {
                pst.setString(27, objDadosPena.getFotoCorpo());
            } else {
                pst.setString(27, null);
            }
            if (objDadosPena.getFotoCorpo1() != null) {
                pst.setString(28, objDadosPena.getFotoCorpo1());
            } else {
                pst.setString(28, null);
            }
            if (objDadosPena.getFotoCorpo2() != null) {
                pst.setString(29, objDadosPena.getFotoCorpo2());
            } else {
                pst.setString(29, null);
            }
            pst.setString(30, objDadosPena.getVaraCondenatoria());
            if (objDadosPena.getDataNovaEntrada() != null) {
                pst.setTimestamp(31, new java.sql.Timestamp(objDadosPena.getDataNovaEntrada().getTime()));
            } else {
                pst.setDate(31, null);
            }
            pst.setBytes(32, objDadosPena.getImagemPerfil());
            pst.setBytes(33, objDadosPena.getImagemCorpo());
            pst.setBytes(34, objDadosPena.getImagemCorpo1());
            pst.setBytes(35, objDadosPena.getImagemCorpo2());
            pst.execute();
            pRESPOSTA_DADOS_penais = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_DADOS_penais = "Não";
            Logger.getLogger(ControleDadosPenais.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objDadosPena;
    }

    //Método para Alterar DADOS PENAIS INTERNO CRC
    public DadosPenaisCrc alterarDadosPenais(DadosPenaisCrc objDadosPena) {
        BUSCAR_CODIGO_unidade(objDadosPena.getNomeUnidade());
        conecta.abrirConexao();
        // Alterar Registro na tabela de INTERNOS CRC
        try (PreparedStatement pst = conecta.con.prepareStatement("UPDATE DADOSPENAISINTERNOS SET DataEntrada=?,DataCrime=?,DataPrisao=?,"
                + "DataCondenacao=?,Participacao=?,Regime=?,Pena=?,Artigo1=?,Artigo2=?,Artigo3=?,Paragrafo1=?,Paragrafo2=?,Paragrafo3=?,"
                + "CrimeEdiondo=?,TerminoPena=?,IdUnid=?,IdInternoCrc=?,Identificador=?,Identificador1=?,Identificador2=?,Identificador3=?,"
                + "Perfil=?,RegiaoCorpo=?,RegiaoCorpo1=?,RegiaoCorpo2=?,FotoPerfil=?,FotoCorpo=?,FotoCorpo1=?,FotoCorpo2=?,VaraCondenatoria=?,"
                + "DataNovaEntrada=?,ImagemPerfil=?,ImagemCorpo=?,ImagemCorpo1=?,ImagemCorpo2=? WHERE IdInternoCrc='" + objDadosPena.getIdInternoCrc() + "'")) {
            pst.setTimestamp(1, new java.sql.Timestamp(objDadosPena.getDataEntrada().getTime()));
            pst.setTimestamp(2, new java.sql.Timestamp(objDadosPena.getDataCrime().getTime()));
            pst.setTimestamp(3, new java.sql.Timestamp(objDadosPena.getDataPrisao().getTime()));
            pst.setTimestamp(4, new java.sql.Timestamp(objDadosPena.getDataCondenacao().getTime()));
            pst.setString(5, objDadosPena.getParticipacao());
            pst.setString(6, objDadosPena.getRegime());
            pst.setString(7, objDadosPena.getPena());
            pst.setString(8, objDadosPena.getArtigo1());
            pst.setString(9, objDadosPena.getArtigo2());
            pst.setString(10, objDadosPena.getArtigo3());
            pst.setString(11, objDadosPena.getParagrafo1());
            pst.setString(12, objDadosPena.getParagrafo2());
            pst.setString(13, objDadosPena.getParagrafo3());
            pst.setString(14, objDadosPena.getCrimeEdiondo());
            if (objDadosPena.getTerminoPena() != null) {
                pst.setTimestamp(15, new java.sql.Timestamp(objDadosPena.getTerminoPena().getTime()));
            } else {
                pst.setDate(15, null);
            }
            pst.setInt(16, codUnid);
            pst.setInt(17, objDadosPena.getIdInternoCrc());
            pst.setString(18, objDadosPena.getIdentificador());
            pst.setString(19, objDadosPena.getIdentificador1());
            pst.setString(20, objDadosPena.getIdentificador2());
            pst.setString(21, objDadosPena.getIdentificador3());
            if (objDadosPena.getPerfil() != null) {
                pst.setString(22, objDadosPena.getPerfil());
            } else {
                pst.setString(22, null);
            }
            if (objDadosPena.getRegiaoCorpo() != null) {
                pst.setString(23, objDadosPena.getRegiaoCorpo());
            } else {
                pst.setString(23, null);
            }
            if (objDadosPena.getRegiaoCorpo1() != null) {
                pst.setString(24, objDadosPena.getRegiaoCorpo1());
            } else {
                pst.setString(24, null);
            }
            if (objDadosPena.getRegiaoCorpo2() != null) {
                pst.setString(25, objDadosPena.getRegiaoCorpo2());
            } else {
                pst.setString(25, null);
            }
            if (objDadosPena.getFotoPerfil() != null) {
                pst.setString(26, objDadosPena.getFotoPerfil());
            } else {
                pst.setString(26, null);
            }
            if (objDadosPena.getFotoCorpo() != null) {
                pst.setString(27, objDadosPena.getFotoCorpo());
            } else {
                pst.setString(27, null);
            }
            if (objDadosPena.getFotoCorpo1() != null) {
                pst.setString(28, objDadosPena.getFotoCorpo1());
            } else {
                pst.setString(28, null);
            }
            if (objDadosPena.getFotoCorpo2() != null) {
                pst.setString(29, objDadosPena.getFotoCorpo2());
            } else {
                pst.setString(29, null);
            }
            pst.setString(30, objDadosPena.getVaraCondenatoria());
            if (objDadosPena.getDataNovaEntrada() != null) {
                pst.setTimestamp(31, new java.sql.Timestamp(objDadosPena.getDataNovaEntrada().getTime()));
            } else {
                pst.setDate(31, null);
            }
            pst.setBytes(32, objDadosPena.getImagemPerfil());
            pst.setBytes(33, objDadosPena.getImagemCorpo());
            pst.setBytes(34, objDadosPena.getImagemCorpo1());
            pst.setBytes(35, objDadosPena.getImagemCorpo2());
            pst.executeUpdate();
            pRESPOSTA_DADOS_penais = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_DADOS_penais = "Não";
            JOptionPane.showMessageDialog(null, "Não foi possível alterar os dados !!!");
        }
        conecta.desconecta();
        return objDadosPena;
    }

    //Método para Alterar DADOS PENAIS ENTRADA EM LOTE (ENTRADA DE INTERNOS)
    public DadosPenaisCrc alterarDadosPenaisLote(DadosPenaisCrc objDadosPena) {
        BUSCAR_CODIGO_unidade(objDadosPena.getNomeUnidade());
        conecta.abrirConexao();
        // Alterar Registro na tabela de INTERNOS CRC
        try (PreparedStatement pst = conecta.con.prepareStatement("UPDATE DADOSPENAISINTERNOS SET DataEntrada=?,DataCrime=?,DataPrisao=?,"
                + "DataCondenacao=?,Regime=?,Pena=?,Artigo1=?,Artigo2=?,Artigo3=?,Paragrafo1=?,Paragrafo2=?,Paragrafo3=?,"
                + "TerminoPena=?,IdUnid=?,IdInternoCrc=? WHERE IdInternoCrc='" + objDadosPena.getIdInternoCrc() + "'")) {
            pst.setTimestamp(1, new java.sql.Timestamp(objDadosPena.getDataEntrada().getTime()));
            pst.setTimestamp(2, new java.sql.Timestamp(objDadosPena.getDataCrime().getTime()));
            pst.setTimestamp(3, new java.sql.Timestamp(objDadosPena.getDataPrisao().getTime()));
            pst.setTimestamp(4, new java.sql.Timestamp(objDadosPena.getDataCondenacao().getTime()));
            pst.setString(5, objDadosPena.getRegime());
            pst.setString(6, objDadosPena.getPena());
            pst.setString(7, objDadosPena.getArtigo1());
            pst.setString(8, objDadosPena.getArtigo2());
            pst.setString(9, objDadosPena.getArtigo3());
            pst.setString(10, objDadosPena.getParagrafo1());
            pst.setString(11, objDadosPena.getParagrafo2());
            pst.setString(12, objDadosPena.getParagrafo3());
            if (objDadosPena.getTerminoPena() != null) {
                pst.setTimestamp(13, new java.sql.Timestamp(objDadosPena.getTerminoPena().getTime()));
            } else {
                pst.setDate(13, null);
            }
            pst.setInt(14, codUnid);
            pst.setInt(15, objDadosPena.getIdInternoCrc());
            pst.executeUpdate();
            pRESPOSTA_DADOS_penais = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_DADOS_penais = "Não";
            JOptionPane.showMessageDialog(null, "Não foi possível alterar os dados !!!");
        }
        conecta.desconecta();
        return objDadosPena;
    }

    // EXCLUIR registro do DADOS PENAIS DO INTERNO CRC
    public DadosPenaisCrc excluirDadosPenais(DadosPenaisCrc objDadosPena) {
        conecta.abrirConexao();
        try (PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM DADOSPENAISINTERNOS WHERE IdInternoCrc='" + objDadosPena.getIdInternoCrc() + "'")) {
            pst.executeUpdate();
            pRESPOSTA_EXCLUSÃO_fisicos = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_EXCLUSÃO_fisicos = "Não";
            JOptionPane.showMessageDialog(null, "Não Existe dados (UNIDADE) a serem exibidos !!!");
        }
        conecta.desconecta();
        return objDadosPena;
    }

    public void BUSCAR_CODIGO_interno(String nomeInterno, String nomeMae) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdInternoCrc, "
                    + "NomeInternoCrc, "
                    + "MaeInternoCrc "
                    + "FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nomeInterno + "' "
                    + "AND MaeInternoCrc='" + nomeMae + "'");
            conecta.rs.last();
            codIntCrc = conecta.rs.getInt("IdInternoCrc");
            objProCrc.setIdInterno(codIntCrc);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (FISICOS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    // Buscar o código da UNIDADE PENAL para incluir junto com os dados fisicos (RELACIONAMENTO)
    public void BUSCAR_CODIGO_unidade(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdUnid, "
                    + "DescricaoUnid "
                    + "FROM UNIDADE "
                    + "WHERE DescricaoUnid='" + nome + "'");
            conecta.rs.first();
            codUnid = conecta.rs.getInt("IdUnid");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (UNIDADE) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
