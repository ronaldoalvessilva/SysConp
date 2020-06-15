/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EvadidoIndividual;
import gestor.Modelo.ItensEntradaLote;
import gestor.Modelo.ItensRecaptura;
import gestor.Modelo.ItensRetornoEspontaneo;
import gestor.Modelo.ItensRetornoInterno;
import gestor.Modelo.ItensRetornoMedico;
import gestor.Modelo.ItensRetornoTransferencia;
import gestor.Modelo.ItensSaidaInterno;
import gestor.Modelo.ItensTransInterno;
import gestor.Modelo.MovimentoCrc;
import gestor.Modelo.ProntuarioCrc;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleMovInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProntuarioCrc objProCrc = new ProntuarioCrc();    
    ItensEntradaLote objItens = new ItensEntradaLote();
    ItensSaidaInterno objItemSaida = new ItensSaidaInterno();
    MovimentoCrc movCrc = new MovimentoCrc();
    ItensRetornoInterno objItensRetorno = new ItensRetornoInterno();
    ItensTransInterno objItensTrans = new ItensTransInterno();
    EvadidoIndividual objEvadidoInd = new EvadidoIndividual();
    ItensRetornoEspontaneo objItensRetEsp = new ItensRetornoEspontaneo();
    int codInt;
    String nomeOpeEntrada = "Entrada na Unidade Penal";
    String nomeOpeSaida = "Saida da Unidade Penal";
    String nomeOpeRetorno = "Retorno a Unidade Penal";
    String nomeOpeTrans = "Transferência da Unidade Penal";
    String nomeOpeRecaptura = "Nova Entrada - Retorno por Recaptura";
    String nomeOpeEvadido = "Evadido - Saída Laborativa";
    String nomeOpeEvadidoSaidaTmp = "Evadido - Saída Temporária";
    String nomeOpeEvadidoSaidaEduca = "Evadido - Saída Educação";
    String nomeOpeEvadidoMedico = "Evadido - Saída Médico";
    String nomeOpeRetornoAudiencia = "Retorno de Interno Audiência";
    String nomeOpeRetornoEspontaeo = "Retorno de Interno Espontâneo";
    String nomeOpeRetornoMedico = "Retorno Médico/Outros Retornos";
    String nomeOpeRetornoTransferencia = "Nova Entrada Retorno por Transferência";

    //Método para SALVAR ITENS ENTRADA
    public ItensEntradaLote incluirMovInterno(ItensEntradaLote objItens) {

        buscarInternoCrc(objItens.getNomeInterno(), objItens.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVIMENTOCRC (IdInternoCrc,IdDoc,NomeOpe,DataMov,OrigemDestino,StMov) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItens.getIdEntrada());
            pst.setString(3, nomeOpeEntrada);
            pst.setTimestamp(4, new java.sql.Timestamp(objItens.getDataEntrada().getTime()));
            pst.setString(5, objItens.getNomeUnidade());
            pst.setInt(6, objItens.getIdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItens;
    }

    // Método para ALTERAR  ITENS ENTRADA
    public ItensEntradaLote alterarMovInterno(ItensEntradaLote objItens) {
        buscarInternoCrc(objItens.getNomeInterno(), objItens.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVIMENTOCRC SET IdInternoCrc=?,IdDoc=?,NomeOpe=?,DataMov=?,OrigemDestino=?,StMov=? WHERE IdDoc='" + objItens.getIdEntrada() + "' AND NomeOpe='" + nomeOpeEntrada + "'AND StMov='" + objItens.getIdItem() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItens.getIdEntrada());
            pst.setString(3, nomeOpeEntrada);
            pst.setTimestamp(4, new java.sql.Timestamp(objItens.getDataEntrada().getTime()));
            pst.setString(5, objItens.getNomeUnidade());
            pst.setInt(6, objItens.getIdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItens;
    }

    // Método para EXCLUIR ITENS ENTRADA
    public ItensEntradaLote excluirMovInterno(ItensEntradaLote objItens) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM MOVIMENTOCRC WHERE IdDoc='" + objItens.getIdEntrada() + "' AND NomeOpe='" + nomeOpeEntrada + "'AND StMov='" + objItens.getIdItem() + "'");
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os dados na movimentação\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItens;

    }
    //// ------------------------------------------*****-------------------------------------------------------////
    // Métodos de SAIDA (INCLUIR, ALTERAR, E EXCLUIR ITENS SAIDA)

    //Método para INCLUIR ITENS SAIDA
    public ItensSaidaInterno incluirMovSaida(ItensSaidaInterno objItemSaida) {

        buscarInternoCrc(objItemSaida.getNomeInterno(), objItemSaida.getIdInternoSaida());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVIMENTOCRC (IdInternoCrc,IdDoc,NomeOpe,DataMov,OrigemDestino,StMov) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItemSaida.getIdSaida());
            pst.setString(3, nomeOpeSaida);
            pst.setTimestamp(4, new java.sql.Timestamp(objItemSaida.getDataSaida().getTime()));
            pst.setString(5, objItemSaida.getNomeDestino());
            pst.setInt(6, objItemSaida.getIdItemSaida());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel inserir os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }
    
    //Método para ALTERAR ITENS SAIDA
    public ItensSaidaInterno alterarMovSaida(ItensSaidaInterno objItemSaida) {

        buscarInternoCrc(objItemSaida.getNomeInterno(), objItemSaida.getIdInternoSaida());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVIMENTOCRC SET IdInternoCrc=?,IdDoc=?,NomeOpe=?,DataMov=?,OrigemDestino=?,StMov=? WHERE IdDoc='" + objItemSaida.getIdSaida() + "' AND NomeOpe='" + nomeOpeSaida + "'AND StMov='" + objItemSaida.getIdItemSaida() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItemSaida.getIdSaida());
            pst.setString(3, nomeOpeSaida);
            pst.setTimestamp(4, new java.sql.Timestamp(objItemSaida.getDataSaida().getTime()));
            pst.setString(5, objItemSaida.getNomeDestino());
            pst.setInt(6, objItemSaida.getIdItemSaida());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel alterar os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }

    // Método para EXCLUIR ITENS SAIDA NO MOVIMENTOCRC
    public ItensSaidaInterno excluirMovSaida(ItensSaidaInterno objItemSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM MOVIMENTOCRC WHERE IdDoc='" + objItemSaida.getIdSaida() + "' AND NomeOpe='" + nomeOpeSaida + "'AND StMov='" + objItemSaida.getIdItemSaida() + "'");
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os dados na movimentação\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItemSaida;

    }

    ///-------------------------- ***************---------------------------------////
    // RETORNO
    //Método para INCLUIR ITENS RETORNO
    public ItensRetornoInterno incluirMovRetorno(ItensRetornoInterno objItensRetorno) {

        buscarInternoCrc(objItensRetorno.getNomeInterno(), objItensRetorno.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVIMENTOCRC (IdInternoCrc,IdDoc,NomeOpe,DataMov,OrigemDestino,StMov) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetorno.getIdRetorno());
            pst.setString(3, nomeOpeRetorno);
            pst.setTimestamp(4, new java.sql.Timestamp(objItensRetorno.getDataRetorno().getTime()));
            pst.setString(5, objItensRetorno.getNomerOrigem());
            pst.setInt(6, objItensRetorno.getIdItemRetorno());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel inserir os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetorno;
    }

    //Método para ALTERAR ITENS RETORNO
    public ItensRetornoInterno alterarMovRetorno(ItensRetornoInterno objItensRetorno) {

        buscarInternoCrc(objItensRetorno.getNomeInterno(), objItensRetorno.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVIMENTOCRC SET IdInternoCrc=?,IdDoc=?,NomeOpe=?,DataMov=?,OrigemDestino=?, StMov=? WHERE IdDoc='" + objItensRetorno.getIdRetorno() + "' AND NomeOpe='" + nomeOpeRetorno + "'AND StMov='" + objItensRetorno.getIdItemRetorno() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetorno.getIdRetorno());
            pst.setString(3, nomeOpeRetorno);
            pst.setTimestamp(4, new java.sql.Timestamp(objItensRetorno.getDataRetorno().getTime()));
            pst.setString(5, objItensRetorno.getNomerOrigem());
            pst.setInt(6, objItensRetorno.getIdItemRetorno());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel alterar os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetorno;
    }

    // Método para EXCLUIR ITENS RETORNO
    public ItensRetornoInterno excluirMovRetorno(ItensRetornoInterno objItensRetorno) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM MOVIMENTOCRC WHERE IdDoc='" + objItensRetorno.getIdRetorno() + "' AND NomeOpe='" + nomeOpeRetorno + "'AND StMov='" + objItensRetorno.getIdItemRetorno() + "'");
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os dados na movimentação\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItensRetorno;
    }

    ///-------------------------------------------*******---------------------------------------///
    //Métodos de TRANSFERÊNCIA
    //Método para INCLUIR ITENS TRANSFERÊNCIA
    public ItensTransInterno incluirMovTransf(ItensTransInterno objItensTrans) {
        buscarInternoCrc(objItensTrans.getNomeInterno(), objItensTrans.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVIMENTOCRC (IdInternoCrc,IdDoc,NomeOpe,DataMov,OrigemDestino,StMov) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensTrans.getIdTrans());
            pst.setString(3, nomeOpeTrans);
            pst.setTimestamp(4, new java.sql.Timestamp(objItensTrans.getDataTrans().getTime()));
            pst.setString(5, objItensTrans.getNomeUnidade());
            pst.setInt(6, objItensTrans.getIdItemTrans());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel inserir os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensTrans;
    }

    //Método para ALTERAR ITENS TRANSFERENCIAS
    public ItensTransInterno alterarMovTransf(ItensTransInterno objItensTrans) {
        buscarInternoCrc(objItensTrans.getNomeInterno(), objItensTrans.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVIMENTOCRC SET IdInternoCrc=?,IdDoc=?,NomeOpe=?,DataMov=?,OrigemDestino=?,StMov=? WHERE IdDoc='" + objItensTrans.getIdTrans() + "' AND NomeOpe='" + nomeOpeTrans + "'AND StMov='" + objItensTrans.getIdItemTrans() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensTrans.getIdTrans());
            pst.setString(3, nomeOpeTrans);
            pst.setTimestamp(4, new java.sql.Timestamp(objItensTrans.getDataTrans().getTime()));
            pst.setString(5, objItensTrans.getNomeDestino());
            pst.setInt(6, objItensTrans.getIdItemTrans());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel alterar os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensTrans;
    }

    // Método para EXCLUIR ITENS TRANSFERENCIA
    public ItensTransInterno excluirMovTransf(ItensTransInterno objItensTrans) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM MOVIMENTOCRC WHERE IdDoc='" + objItensTrans.getIdTrans() + "' AND NomeOpe='" + nomeOpeTrans + "'AND StMov='" + objItensTrans.getIdItemTrans() + "'");
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os dados na movimentação\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItensTrans;
    }

    // Buscar o nome do interno
    public void buscarInternoCrc(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    //Método para INCLUIR ITENS RECAPTURA
    public ItensRecaptura incluirMovRecaptura(ItensRecaptura objItensRecap) {

        buscarInternoCrc(objItensRecap.getNomeInterno(),objItensRecap.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVIMENTOCRC (IdInternoCrc,IdDoc,NomeOpe,DataMov,OrigemDestino,StMov) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRecap.getIdRecaptura());
            pst.setString(3, nomeOpeRecaptura);
            pst.setTimestamp(4, new java.sql.Timestamp(objItensRecap.getDataRetorno().getTime()));
            pst.setString(5, objItensRecap.getOrigemRetorno());
            pst.setInt(6, objItensRecap.getIdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel inserir os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRecap;
    }

    //Método para ALTERAR ITENS RECAPTURA
    public ItensRecaptura alterarMovRecaptura(ItensRecaptura objItensRecap) {

        buscarInternoCrc(objItensRecap.getNomeInterno(),objItensRecap.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVIMENTOCRC SET IdInternoCrc=?,IdDoc=?,NomeOpe=?,DataMov=?,OrigemDestino=?, StMov=? WHERE IdDoc='" + objItensRecap.getIdRecaptura() + "' AND NomeOpe='" + nomeOpeRecaptura + "'AND StMov='" + objItensRecap.getIdItem() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRecap.getIdRecaptura());
            pst.setString(3, nomeOpeRecaptura);
            pst.setTimestamp(4, new java.sql.Timestamp(objItensRecap.getDataRetorno().getTime()));
            pst.setString(5, objItensRecap.getOrigemRetorno());
            pst.setInt(6, objItensRecap.getIdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel alterar os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRecap;
    }

    // Método para EXCLUIR ITENS RECAPTURA
    public ItensRecaptura excluirMovRecaptura(ItensRecaptura objItensRecap) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM MOVIMENTOCRC WHERE IdDoc='" + objItensRecap.getIdRecaptura() + "' AND NomeOpe='" + nomeOpeRetorno + "'AND StMov='" + objItensRecap.getIdItem() + "'");
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os dados na movimentação\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItensRecap;
    }
    //Método para INCLUIR INTERNO EVASÃO (ATIVIDADE LABORATIA)

    public EvadidoIndividual incluirMovEvasao(EvadidoIndividual objEvadidoInd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVIMENTOCRC (IdInternoCrc,IdDoc,NomeOpe,DataMov,OrigemDestino) VALUES(?,?,?,?,?)");
            pst.setInt(1, objEvadidoInd.getIdInternoCrc());
            pst.setInt(2, objEvadidoInd.getIdLanc());
            pst.setString(3, nomeOpeEvadido);
            pst.setTimestamp(4, new java.sql.Timestamp(objEvadidoInd.getDataLanc().getTime()));
            pst.setString(5, objEvadidoInd.getTipoOperacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel inserir os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvadidoInd;
    }

    // Método para INCLUIR INTERNO EVASÃO (SAIDA TEMPORARIA) no MOVIMENTOCRC (HISTÓRICO)ras
    public EvadidoIndividual incluirMovEvasaoSaidaTmp(EvadidoIndividual objEvadidoInd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVIMENTOCRC (IdInternoCrc,IdDoc,NomeOpe,DataMov,OrigemDestino) VALUES(?,?,?,?,?)");
            pst.setInt(1, objEvadidoInd.getIdInternoCrc());
            pst.setInt(2, objEvadidoInd.getIdLanc());
            pst.setString(3, nomeOpeEvadidoSaidaTmp);
            pst.setTimestamp(4, new java.sql.Timestamp(objEvadidoInd.getDataLanc().getTime()));
            pst.setString(5, objEvadidoInd.getTipoOperacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel inserir os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvadidoInd;
    }
    public EvadidoIndividual incluirMovEvasaoSaidaEduca(EvadidoIndividual objEvadidoInd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVIMENTOCRC (IdInternoCrc,IdDoc,NomeOpe,DataMov,OrigemDestino) VALUES(?,?,?,?,?)");
            pst.setInt(1, objEvadidoInd.getIdInternoCrc());
            pst.setInt(2, objEvadidoInd.getIdLanc());
            pst.setString(3, nomeOpeEvadidoSaidaTmp);
            pst.setTimestamp(4, new java.sql.Timestamp(objEvadidoInd.getDataLanc().getTime()));
            pst.setString(5, objEvadidoInd.getTipoOperacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel inserir os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvadidoInd;
    }
      // Método para INCLUIR INTERNO EVASÃO (SAIDA PARA MÉDICO) no MOVIMENTOCRC (HISTÓRICO)
    public EvadidoIndividual incluirMovEvasaoSaidaMedico(EvadidoIndividual objEvadidoInd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVIMENTOCRC (IdInternoCrc,IdDoc,NomeOpe,DataMov,OrigemDestino) VALUES(?,?,?,?,?)");
            pst.setInt(1, objEvadidoInd.getIdInternoCrc());
            pst.setInt(2, objEvadidoInd.getIdLanc());
            pst.setString(3, nomeOpeEvadidoMedico);
            pst.setTimestamp(4, new java.sql.Timestamp(objEvadidoInd.getDataLanc().getTime()));
            pst.setString(5, objEvadidoInd.getTipoOperacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel inserir os Dados.\nERRO:" + ex);
        }
        conecta.desconecta();
        return objEvadidoInd;
    }

    // 05/06/2015
    public EvadidoIndividual alterarMovEvasaoSaidaTmp(EvadidoIndividual objEvadidoInd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVIMENTOCRC SET DataMov=? WHERE IdDoc='" + objEvadidoInd.getIdLanc() + "'AND IdInternoCrc='" + objEvadidoInd.getIdInternoCrc() + "'");
            pst.setInt(1, objEvadidoInd.getIdInternoCrc());
            pst.setInt(2, objEvadidoInd.getIdLanc());
            pst.setString(3, nomeOpeEvadidoSaidaTmp);
            pst.setTimestamp(4, new java.sql.Timestamp(objEvadidoInd.getDataLanc().getTime()));
            pst.setString(5, objEvadidoInd.getTipoOperacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvadidoInd;
    }

    public EvadidoIndividual excluirMovEvasaoSaidaTmp(EvadidoIndividual objEvadidoInd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVIMENTOCRC WHERE IdDoc='" + objEvadidoInd.getIdLanc() + "'AND IdInternoCrc='" + objEvadidoInd.getIdInternoCrc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvadidoInd;
    }

 // -------------------------------------- RETORNO AUDIENCIA -----------------------------------------------------
    //Método para INCLUIR ITENS RETORNO AUDIÊNCIA
    public ItensRetornoEspontaneo incluirMovRetornoAudiencia(ItensRetornoEspontaneo objItensRetEsp) {

        buscarInternoCrc(objItensRetEsp.getNomeInterno(),objItensRetEsp.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVIMENTOCRC (IdInternoCrc,IdDoc,NomeOpe,DataMov,OrigemDestino,StMov) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetEsp.getIdRetorno());
            pst.setString(3, nomeOpeRetornoAudiencia);
            pst.setTimestamp(4, new java.sql.Timestamp(objItensRetEsp.getDataRetorno().getTime()));
            pst.setString(5, objItensRetEsp.getOrigemRetorno());
            pst.setInt(6, objItensRetEsp.getIdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel inserir os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetEsp;
    }

    //Método para ALTERAR ITENS RETORNO ESPOTANEO
    public ItensRetornoEspontaneo alterarMovRetornoAudiencia(ItensRetornoEspontaneo objItensRetEsp) {

        buscarInternoCrc(objItensRetEsp.getNomeInterno(),objItensRetEsp.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVIMENTOCRC SET IdInternoCrc=?,IdDoc=?,NomeOpe=?,DataMov=?,OrigemDestino=?, StMov=? WHERE IdDoc='" + objItensRetEsp.getIdRetorno() + "' AND NomeOpe='" + nomeOpeRetornoEspontaeo + "'AND StMov='" + objItensRetEsp.getIdItem() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetEsp.getIdRetorno());
            pst.setString(3, nomeOpeRetornoAudiencia);
            pst.setTimestamp(4, new java.sql.Timestamp(objItensRetEsp.getDataRetorno().getTime()));
            pst.setString(5, objItensRetEsp.getOrigemRetorno());
            pst.setInt(6, objItensRetEsp.getIdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel alterar os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetEsp;
    }

    // Método para EXCLUIR ITENS RETORNO AUDIENCIA
    public ItensRetornoEspontaneo excluirMovRetornoAudiencia(ItensRetornoEspontaneo objItensRetEsp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM MOVIMENTOCRC WHERE IdDoc='" + objItensRetEsp.getIdRetorno() + "'AND NomeOpe='" + nomeOpeRetornoAudiencia + "'AND StMov='" + objItensRetEsp.getIdItem() + "'");
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os dados na movimentação\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItensRetEsp;
    }
///----------------------------------------------------------------------------------------------------------------
    //Método para INCLUIR ITENS RETORNO ESPONTAENO

    public ItensRetornoEspontaneo incluirMovRetornoEspontaneo(ItensRetornoEspontaneo objItensRetEsp) {

        buscarInternoCrc(objItensRetEsp.getNomeInterno(),objItensRetEsp.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVIMENTOCRC (IdInternoCrc,IdDoc,NomeOpe,DataMov,OrigemDestino,StMov) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetEsp.getIdRetorno());
            pst.setString(3, nomeOpeRetornoEspontaeo);
            pst.setTimestamp(4, new java.sql.Timestamp(objItensRetEsp.getDataRetorno().getTime()));
            pst.setString(5, objItensRetEsp.getOrigemRetorno());
            pst.setInt(6, objItensRetEsp.getIdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel inserir os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetEsp;
    }

    //Método para ALTERAR ITENS RETORNO ESPOTANEO
    public ItensRetornoEspontaneo alterarMovRetornoEspontaneo(ItensRetornoEspontaneo objItensRetEsp) {

        buscarInternoCrc(objItensRetEsp.getNomeInterno(),objItensRetEsp.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVIMENTOCRC SET IdInternoCrc=?,IdDoc=?,NomeOpe=?,DataMov=?,OrigemDestino=?, StMov=? WHERE IdDoc='" + objItensRetEsp.getIdRetorno() + "' AND NomeOpe='" + nomeOpeRetornoEspontaeo + "'AND StMov='" + objItensRetEsp.getIdItem() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetEsp.getIdRetorno());
            pst.setString(3, nomeOpeRetornoEspontaeo);
            pst.setTimestamp(4, new java.sql.Timestamp(objItensRetEsp.getDataRetorno().getTime()));
            pst.setString(5, objItensRetEsp.getOrigemRetorno());
            pst.setInt(6, objItensRetEsp.getIdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel alterar os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetEsp;
    }

    // Método para EXCLUIR ITENS RETORNO ESPONTANEO
    public ItensRetornoEspontaneo excluirMovRetornoEspontaneo(ItensRetornoEspontaneo objItensRetEsp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM MOVIMENTOCRC WHERE IdDoc='" + objItensRetEsp.getIdRetorno() + "' AND NomeOpe='" + nomeOpeRetornoEspontaeo + "'AND StMov='" + objItensRetEsp.getIdItem() + "'");
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os dados na movimentação\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItensRetEsp;
    }

    ///---------------------------------- ITENS RETORNO MEDICO ------------------------------------
//    ItensRetornoMedico objItensRetMed = new ItensRetornoMedico();
    public ItensRetornoMedico incluirMovRetornoMedico(ItensRetornoMedico objItensRetMed) {

        buscarInternoCrc(objItensRetMed.getNomeInterno(),objItensRetMed.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVIMENTOCRC (IdInternoCrc,IdDoc,NomeOpe,DataMov,OrigemDestino,StMov) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetMed.getIdRetorno());
            pst.setString(3, nomeOpeRetornoMedico);
            pst.setTimestamp(4, new java.sql.Timestamp(objItensRetMed.getDataRetorno().getTime()));
            pst.setString(5, objItensRetMed.getOrigemRetorno());
            pst.setInt(6, objItensRetMed.getIdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel inserir os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetMed;
    }

    //Método para ALTERAR ITENS RETORNO MÉDICO
    public ItensRetornoMedico alterarMovRetornoMedico(ItensRetornoMedico objItensRetMed) {

        buscarInternoCrc(objItensRetMed.getNomeInterno(),objItensRetMed.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVIMENTOCRC SET IdInternoCrc=?,IdDoc=?,NomeOpe=?,DataMov=?,OrigemDestino=?, StMov=? WHERE IdDoc='" + objItensRetMed.getIdRetorno() + "' AND NomeOpe='" + nomeOpeRetornoMedico + "'AND StMov='" + objItensRetMed.getIdItem() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetMed.getIdRetorno());
            pst.setString(3, nomeOpeRetornoMedico);
            pst.setTimestamp(4, new java.sql.Timestamp(objItensRetMed.getDataRetorno().getTime()));
            pst.setString(5, objItensRetMed.getOrigemRetorno());
            pst.setInt(6, objItensRetMed.getIdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel alterar os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetMed;
    }

    // Método para EXCLUIR ITENS RETORNO MÉDICO
    public ItensRetornoMedico excluirMovRetornoMedico(ItensRetornoMedico objItensRetMed) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM MOVIMENTOCRC WHERE IdDoc='" + objItensRetMed.getIdRetorno() + "' AND NomeOpe='" + nomeOpeRetornoMedico + "'AND StMov='" + objItensRetMed.getIdItem() + "'");
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os dados na movimentação\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItensRetMed;
    }
    ///---------------------------- RETORNO POR TRANSFERENCIA -----------------------------------
    //   ItensRetornoTransferencia objItensRetTrans = new ItensRetornoTransferencia();

    public ItensRetornoTransferencia incluirMovRetornoTransferencia(ItensRetornoTransferencia objItensRetTrans) {

        buscarInternoCrc(objItensRetTrans.getNomeInterno(),objItensRetTrans.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVIMENTOCRC (IdInternoCrc,IdDoc,NomeOpe,DataMov,OrigemDestino,StMov) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetTrans.getIdRetorno());
            pst.setString(3, nomeOpeRetornoTransferencia);
            pst.setTimestamp(4, new java.sql.Timestamp(objItensRetTrans.getDataRetorno().getTime()));
            pst.setString(5, objItensRetTrans.getOrigemRetorno());
            pst.setInt(6, objItensRetTrans.getIdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel inserir os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetTrans;
    }

    //Método para ALTERAR ITENS RETORNO MÉDICO
    public ItensRetornoTransferencia alterarMovRetornoTransferencia(ItensRetornoTransferencia objItensRetTrans) {

        buscarInternoCrc(objItensRetTrans.getNomeInterno(),objItensRetTrans.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVIMENTOCRC SET IdInternoCrc=?,IdDoc=?,NomeOpe=?,DataMov=?,OrigemDestino=?, StMov=? WHERE IdDoc='" + objItensRetTrans.getIdRetorno() + "' AND NomeOpe='" + nomeOpeRetornoTransferencia + "'AND StMov='" + objItensRetTrans.getIdItem() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetTrans.getIdRetorno());
            pst.setString(3, nomeOpeRetornoTransferencia);
            pst.setTimestamp(4, new java.sql.Timestamp(objItensRetTrans.getDataRetorno().getTime()));
            pst.setString(5, objItensRetTrans.getOrigemRetorno());
            pst.setInt(6, objItensRetTrans.getIdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel alterar os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetTrans;
    }

    // Método para EXCLUIR ITENS RETORNO MÉDICO
    public ItensRetornoTransferencia excluirMovRetornoTransferencia(ItensRetornoTransferencia objItensRetTrans) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM MOVIMENTOCRC WHERE IdDoc='" + objItensRetTrans.getIdRetorno() + "' AND NomeOpe='" + nomeOpeRetornoTransferencia + "'AND StMov='" + objItensRetTrans.getIdItem() + "'");
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os dados na movimentação\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItensRetTrans;
    }
}
