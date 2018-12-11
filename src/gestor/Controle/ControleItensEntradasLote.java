/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaLote;
import gestor.Modelo.ItensEntradaLote;
import gestor.Modelo.ProntuarioCrc;
import gestor.Modelo.UnidadePenal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensEntradasLote {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaLote objEntLote = new EntradaLote();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    UnidadePenal objUnid = new UnidadePenal();
    ItensEntradaLote objItens = new ItensEntradaLote();
    //
    int codUnid;
    int codInt;
    int qtdUnit = 1; // Quantidade unitaria a ser lancada

    //Método para SALVAR ITENS
    public ItensEntradaLote incluirItensEntLote(ItensEntradaLote objItens) {
        buscarUnidade(objItens.getNomeUnidade());
        buscarInternoCrc(objItens.getNomeInterno(),objItens.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSENTRADA (IdInternoCrc,IdEntrada,IdUnid,QtdEntrada,DataEntrada,DataCrime,DataPrisao,DataCondenacao,Regime,Pena,Artigo1,Artigo2,Artigo3,Paragrafo1,Paragrafo2,Paragrafo3,TerminoPena,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItens.getIdEntrada());
            pst.setInt(3, codUnid);
            pst.setInt(4, qtdUnit);
            pst.setTimestamp(5, new java.sql.Timestamp(objItens.getDataEntrada().getTime()));
            pst.setTimestamp(6, new java.sql.Timestamp(objItens.getDataCrime().getTime()));
            pst.setTimestamp(7, new java.sql.Timestamp(objItens.getDataPrisao().getTime()));
            pst.setTimestamp(8, new java.sql.Timestamp(objItens.getDataCondenacao().getTime()));
            pst.setString(9, objItens.getRegime());
            pst.setString(10, objItens.getPena());
            pst.setString(11, objItens.getArtigo1());
            pst.setString(12, objItens.getArtigo2());
            pst.setString(13, objItens.getArtigo3());
            pst.setString(14, objItens.getParagrafo1());
            pst.setString(15, objItens.getParagrafo2());
            pst.setString(16, objItens.getParagrafo3());
            pst.setTimestamp(17, new java.sql.Timestamp(objItens.getTerminoPena().getTime()));
            pst.setString(18, objItens.getUsuarioInsert());
            pst.setString(19, objItens.getDataInsert());
            pst.setString(20, objItens.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItens;

    }
//Método para ALTERAR ITENS DE ENTRADAS EM LOTE

    public ItensEntradaLote alterarItensEntLote(ItensEntradaLote objItens) {
        buscarUnidade(objItens.getNomeUnidade());
        buscarInternoCrc(objItens.getNomeInterno(),objItens.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSENTRADA SET IdInternoCrc=?,IdEntrada=?,IdUnid=?,QtdEntrada=?,DataEntrada=?,DataCrime=?,DataPrisao=?,DataCondenacao=?,Regime=?,Pena=?,Artigo1=?,Artigo2=?,Artigo3=?,Paragrafo1=?,Paragrafo2=?,Paragrafo3=?,TerminoPena=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItens.getIdItem() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItens.getIdEntrada());
            pst.setInt(3, codUnid);
            pst.setInt(4, qtdUnit);
            pst.setTimestamp(5, new java.sql.Timestamp(objItens.getDataEntrada().getTime()));
            pst.setTimestamp(6, new java.sql.Timestamp(objItens.getDataCrime().getTime()));
            pst.setTimestamp(7, new java.sql.Timestamp(objItens.getDataPrisao().getTime()));
            pst.setTimestamp(8, new java.sql.Timestamp(objItens.getDataCondenacao().getTime()));
            pst.setString(9, objItens.getRegime());
            pst.setString(10, objItens.getPena());
            pst.setString(11, objItens.getArtigo1());
            pst.setString(12, objItens.getArtigo2());
            pst.setString(13, objItens.getArtigo3());
            pst.setString(14, objItens.getParagrafo1());
            pst.setString(15, objItens.getParagrafo2());
            pst.setString(16, objItens.getParagrafo3());
            pst.setTimestamp(17, new java.sql.Timestamp(objItens.getTerminoPena().getTime()));
            pst.setString(18, objItens.getUsuarioUp());
            pst.setString(19, objItens.getDataUp());
            pst.setString(20, objItens.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItens;
    }

//Método para excluir ITENS DE ENTRADAS
    public ItensEntradaLote excluirItensEntLote(ItensEntradaLote objItens) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM ITENSENTRADA WHERE IdItem='" + objItens.getIdItem() + "'");
            pst.executeUpdate();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItens;

    }
    // PARA INDICAR SOBRE O KIT
     public ProntuarioCrc informarkitHigiene(ProntuarioCrc objProCrc) {
        buscarInternoCrc(objProCrc.getNomeInterno(),objProCrc.getIdInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVIMENTACAO_KITS_HIGIENE_INTERNOS (IdInternoCrc,KitInicial,KitIPago,KitDecendial,KitDPago,KitQuinzenal,KitQPago,KitMensal,KitMPago,KitSemestral,KitSPago,KitAnual,KitAPago) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");            
            pst.setInt(1, codInt);
            pst.setString(2, objProCrc.getKitInicial());
            pst.setString(3, objProCrc.getKitIPago());
            pst.setString(4, objProCrc.getKitDecendial());
            pst.setString(5, objProCrc.getKitDPago());
            pst.setString(6, objProCrc.getKitQuinzenal());
            pst.setString(7, objProCrc.getKitQPago());
            pst.setString(8, objProCrc.getKitMensal());
            pst.setString(9, objProCrc.getKitMPago());
            pst.setString(10, objProCrc.getKitSemestral());
            pst.setString(11, objProCrc.getKitSPago());
            pst.setString(12, objProCrc.getKitAnual());
            pst.setString(13, objProCrc.getKitAPago());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProCrc;
    }
    
// Buscar UNIDADE PENAL
    public void buscarUnidade(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM UNIDADE WHERE DescricaoUnid='" + nome + "'");
            conecta.rs.first();
            codUnid = conecta.rs.getInt("IdUnid");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (UNIDADE PENAL) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
// Buscar INTERNO

    public void buscarInternoCrc(String nomeInterno, int codigoInterno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nomeInterno + "'AND IdInternoCrc='" + codigoInterno + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
