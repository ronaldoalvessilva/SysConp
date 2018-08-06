/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.GravarInternosKitCompleto;
import gestor.Modelo.ItensRequisicaoMateriaisInternos;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleSelecaoKitsCompleto {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    GravarInternosKitCompleto objGravaIntComp = new GravarInternosKitCompleto();

    int codInterno;

    public GravarInternosKitCompleto incluirInternosKitCompleto(GravarInternosKitCompleto objGravaIntComp) {
        buscarInterno(objGravaIntComp.getNomeInternoCrc(), objGravaIntComp.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO (IdRegistroComp,IdInternoCrc,TipoKitCI,Gravado,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objGravaIntComp.getIdRegistroComp());
            pst.setInt(2, codInterno);
            pst.setInt(3, objGravaIntComp.getGravado());
            pst.setInt(4, objGravaIntComp.getTipoKitCI());
            pst.setString(5, objGravaIntComp.getUsuarioInsert());
            pst.setString(7, objGravaIntComp.getDataInsert());
            pst.setString(8, objGravaIntComp.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR internos com kit completo.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objGravaIntComp;
    }

    //INSERT INTO INTERNOS_PAVILHAO_KIT_LOTE
    public GravarInternosKitCompleto atualizarInternosPavilhao(GravarInternosKitCompleto objGravaIntComp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INTERNOS_PAVILHAO_KIT_LOTE SET Utili=? WHERE IdRegistroComp='" + objGravaIntComp.getIdRegistroComp() + "' AND IdInternoCrc='" + objGravaIntComp.getIdInternoCrc() + "'");
            pst.setString(1, objGravaIntComp.getUtili());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR interno.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objGravaIntComp;
    }

    public GravarInternosKitCompleto excluirInternosKitCompleto(GravarInternosKitCompleto objGravaIntComp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO WHERE IdRegistroComp='" + objGravaIntComp.getIdRegistroComp() + "' AND IdInternoCrc='" + objGravaIntComp.getIdInternoCrc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR internos com kit completo.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objGravaIntComp;
    }

    public GravarInternosKitCompleto excluirTodosInternosKitCompleto(GravarInternosKitCompleto objGravaIntComp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO WHERE IdRegistroComp='" + objGravaIntComp.getIdRegistroComp() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR internos com kit completo.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objGravaIntComp;
    }

    public List<GravarInternosKitCompleto> read() throws Exception {
        conecta.abrirConexao();
        List<GravarInternosKitCompleto> listaInternosKitComp = new ArrayList<GravarInternosKitCompleto>();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=INTERNOS_PAVILHAO_KIT_LOTE.IdInternoCrc "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            while (conecta.rs.next()) {
                GravarInternosKitCompleto pDigi = new GravarInternosKitCompleto();
                pDigi.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigi.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                listaInternosKitComp.add(pDigi);
                qtdInternos = qtdInternos + 1;
            }
            return listaInternosKitComp;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePavilhaoInternosMontaKit.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "' AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do INTERNO a ser exibido !!!");
        }
        conecta.desconecta();
    }
}
