/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensEntradaSaidaReligiosaPortaria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleEntradaSaidaVisitasReligiosasPortaria {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEntradaSaidaReligiosaPortaria objItensEntSaiVistasReligiosa = new ItensEntradaSaidaReligiosaPortaria();

    int codigoInstituicao;
    int codigoVisita;

    public ItensEntradaSaidaReligiosaPortaria incluirEntSaiVisitaReligiosaP1(ItensEntradaSaidaReligiosaPortaria objItensEntSaiVistasReligiosa) {
        buscarInstituicao(objItensEntSaiVistasReligiosa.getNomeInstituicao(), objItensEntSaiVistasReligiosa.getIdCod());
        buscarVisita(objItensEntSaiVistasReligiosa.getNomeVisitaRel(), objItensEntSaiVistasReligiosa.getIdVisitaRel());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_ENTRADA_SAIDA_VISITAS_RELIGIOSA (IdEntSaiVisita,IdCod,IdVisitaRel,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensEntSaiVistasReligiosa.getIdEntSaiVisita());
            pst.setInt(2, codigoInstituicao);
            pst.setInt(3, codigoVisita);
            if (objItensEntSaiVistasReligiosa.getDataEntrada() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objItensEntSaiVistasReligiosa.getDataEntrada().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, objItensEntSaiVistasReligiosa.getHorarioEntrada());
            if (objItensEntSaiVistasReligiosa.getDataSaida() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objItensEntSaiVistasReligiosa.getDataSaida().getTime()));
            } else {
                pst.setDate(6, null);
            }
            pst.setString(7, objItensEntSaiVistasReligiosa.getHorarioSaida());
            pst.setString(8, objItensEntSaiVistasReligiosa.getUsuarioInsert());
            pst.setString(9, objItensEntSaiVistasReligiosa.getDataInsert());
            pst.setString(10, objItensEntSaiVistasReligiosa.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntSaiVistasReligiosa;
    }

    public ItensEntradaSaidaReligiosaPortaria alterarEntSaiVisitaReligiosaP1(ItensEntradaSaidaReligiosaPortaria objItensEntSaiVistasReligiosa) {
        buscarInstituicao(objItensEntSaiVistasReligiosa.getNomeInstituicao(), objItensEntSaiVistasReligiosa.getIdCod());
        buscarVisita(objItensEntSaiVistasReligiosa.getNomeVisitaRel(), objItensEntSaiVistasReligiosa.getIdVisitaRel());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_ENTRADA_SAIDA_VISITAS_RELIGIOSA SET IdEntSaiVisita=?,IdCod=?,IdVisitaRel=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensEntSaiVistasReligiosa.getIdItem() + "'");
            pst.setInt(1, objItensEntSaiVistasReligiosa.getIdEntSaiVisita());
            pst.setInt(2, codigoInstituicao);
            pst.setInt(3, codigoVisita);
            if (objItensEntSaiVistasReligiosa.getDataEntrada() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objItensEntSaiVistasReligiosa.getDataEntrada().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, objItensEntSaiVistasReligiosa.getHorarioEntrada());
            if (objItensEntSaiVistasReligiosa.getDataSaida() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objItensEntSaiVistasReligiosa.getDataSaida().getTime()));
            } else {
                pst.setDate(6, null);
            }
            pst.setString(7, objItensEntSaiVistasReligiosa.getHorarioSaida());
            pst.setString(8, objItensEntSaiVistasReligiosa.getUsuarioInsert());
            pst.setString(9, objItensEntSaiVistasReligiosa.getDataInsert());
            pst.setString(10, objItensEntSaiVistasReligiosa.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntSaiVistasReligiosa;
    }

    public ItensEntradaSaidaReligiosaPortaria excluirEntSaiVisitaReligiosaP1(ItensEntradaSaidaReligiosaPortaria objItensEntSaiVistasReligiosa) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_ENTRADA_SAIDA_VISITAS_RELIGIOSA WHERE IdItem='" + objItensEntSaiVistasReligiosa.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntSaiVistasReligiosa;
    }

    public void buscarInstituicao(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INSTITUICAO_RELIGIOSA WHERE NomeInstituicao='" + desc + "'AND IdCod='" + cod + "'");
            conecta.rs.first();
            codigoInstituicao = conecta.rs.getInt("IdCod");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INSTITUIÇÃO RELIGIOSA) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarVisita(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITAS_RELIGIOSA_INTERNOS WHERE NomeVisitaRel='" + nome + "'AND IdVisitaRel='" + codigo + "'");
            conecta.rs.first();
            codigoVisita = conecta.rs.getInt("IdVisitaRel");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (VISITA RELIGIOSA) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
