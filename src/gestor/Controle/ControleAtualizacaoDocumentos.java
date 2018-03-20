/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtualizaDocumentos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleAtualizacaoDocumentos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtualizaDocumentos objAtual = new AtualizaDocumentos();
    int codInt;

    public AtualizaDocumentos incluirAtualizacaoDocumentosInternos(AtualizaDocumentos objAtual) {
        buscarInterno(objAtual.getNomeInternoCrc(), objAtual.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATUALIZACAO_DOCUMENTOS_INTERNOS (StatusDoc,DataLanc,IdInternoCrc,RG,Orgao,Emissor,DataEmissao,CPF,CartaoSus,Escolaridade,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAtual.getStatusDoc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtual.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            pst.setString(4, objAtual.getrG());
            pst.setString(5, objAtual.getOrgao());
            pst.setString(6, objAtual.getEmissor());
            pst.setTimestamp(7, new java.sql.Timestamp(objAtual.getDataEmissao().getTime()));
            pst.setString(8, objAtual.getcPF());
            pst.setString(9, objAtual.getCartaoSus());
            pst.setString(10, objAtual.getEscolaridade());
            pst.setString(11, objAtual.getObservacao());
            pst.setString(12, objAtual.getUsuarioInsert());
            pst.setString(13, objAtual.getDataInsert());
            pst.setString(14, objAtual.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtual;
    }

    public AtualizaDocumentos alterarAtualizacaoDocumentosInternos(AtualizaDocumentos objAtual) {
        buscarInterno(objAtual.getNomeInternoCrc(), objAtual.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATUALIZACAO_DOCUMENTOS_INTERNOS SET StatusDoc=?,DataLanc=?,IdInternoCrc=?,RG=?,Orgao=?,Emissor=?,DataEmissao=?,CPF=?,CartaoSus=?,Escolaridade=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE CodigoDoc='" + objAtual.getCodigoDoc() + "'");
            pst.setString(1, objAtual.getStatusDoc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtual.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            pst.setString(4, objAtual.getrG());
            pst.setString(5, objAtual.getOrgao());
            pst.setString(6, objAtual.getEmissor());
            if (objAtual.getDataEmissao() == null) {
                pst.setDate(7, null);
            } else {
                pst.setTimestamp(7, new java.sql.Timestamp(objAtual.getDataEmissao().getTime()));
            }
            pst.setString(8, objAtual.getcPF());
            pst.setString(9, objAtual.getCartaoSus());
            pst.setString(10, objAtual.getEscolaridade());
            pst.setString(11, objAtual.getObservacao());
            pst.setString(12, objAtual.getUsuarioUp());
            pst.setString(13, objAtual.getDataUp());
            pst.setString(14, objAtual.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtual;
    }

    public AtualizaDocumentos atualizarAtualizacaoDocumentosInternosRG(AtualizaDocumentos objAtual) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRONTUARIOSCRC SET RgInternoCrc=? WHERE IdInternoCrc='" + objAtual.getIdInternoCrc() + "'");
            pst.setString(1, objAtual.getrG());          
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtual;
    }

     public AtualizaDocumentos atualizarAtualizacaoDocumentosInternosCPF(AtualizaDocumentos objAtual) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRONTUARIOSCRC SET CpfInternoCrc=? WHERE IdInternoCrc='" + objAtual.getIdInternoCrc() + "'");           
            pst.setString(1, objAtual.getcPF());           
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtual;
    }
     
      public AtualizaDocumentos atualizarAtualizacaoDocumentosInternosSUS(AtualizaDocumentos objAtual) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRONTUARIOSCRC SET CartaoSus=? WHERE IdInternoCrc='" + objAtual.getIdInternoCrc() + "'");           
            pst.setString(1, objAtual.getcPF());           
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtual;
    }
     
    public AtualizaDocumentos atualizarAtualizacaoDocumentosInternosPedagogia(AtualizaDocumentos objAtual) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRONTUARIOSCRC SET EscolaridadeCrc=? WHERE IdInternoCrc='" + objAtual.getIdInternoCrc() + "'");
            pst.setString(1, objAtual.getEscolaridade());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR a ESCOLARIDADE do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtual;
    }

    public AtualizaDocumentos finalizarAtualizacaoDocumentosInternos(AtualizaDocumentos objAtual) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATUALIZACAO_DOCUMENTOS_INTERNOS SET StatusDoc=? WHERE CodigoDoc='" + objAtual.getCodigoDoc() + "'");
            pst.setString(1, objAtual.getStatusDoc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtual;
    }

    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados da VISITA a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
