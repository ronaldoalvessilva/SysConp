/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.GravarInternosKitCompleto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7 TI 02
 */
public class ControleProximoKitDecendial {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    GravarInternosKitCompleto objGravaIntComp = new GravarInternosKitCompleto();

    int codInterno;

    public GravarInternosKitCompleto incluirProximoKitDecendial(GravarInternosKitCompleto objGravaIntComp) {
        buscarInterno(objGravaIntComp.getNomeInternoCrc(), objGravaIntComp.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO KITS_DECENDIAL_INTERNOS (DataPagto,IdInternoCrc,ProximaData,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objGravaIntComp.getDataPagamento().getTime()));
            pst.setInt(2, codInterno);
            pst.setTimestamp(3, new java.sql.Timestamp(objGravaIntComp.getDataPrevisao().getTime()));
            pst.setString(4, objGravaIntComp.getUsuarioInsert());
            pst.setString(5, objGravaIntComp.getDataInsert());
            pst.setString(6, objGravaIntComp.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR internos do kit decendial.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objGravaIntComp;
    }

    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nome + "' "
                    + "AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do INTERNO a ser exibido !!!");
        }
        conecta.desconecta();
    }
}
