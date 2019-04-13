/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.GravarInternosKitCompleto;
import gestor.Modelo.ProgramacaoKit;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleProgramacaoKit {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProgramacaoKit objProg = new ProgramacaoKit();

    int codigoPavilhao;

    public ProgramacaoKit incluirProgramacaoKit(ProgramacaoKit objProg) {
        buscarPavilhao(objProg.getDescricaoPav());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PROGRAMACAO_PAGAMENTO_KITS_INTERNOS (DataUltimoPagto,DataPROG,DataPrevisao,TipoKit,IdPav,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objProg.getDataUltimoPagto().getTime()));
            pst.setTimestamp(2, new java.sql.Timestamp(objProg.getDataPROG().getTime()));
            pst.setTimestamp(3, new java.sql.Timestamp(objProg.getDataPrevisao().getTime()));
            pst.setInt(4, objProg.getTipoKit());
            pst.setInt(5, codigoPavilhao);
            pst.setString(6, objProg.getUsuarioInsert());
            pst.setString(7, objProg.getDataInsert());
            pst.setString(8, objProg.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR PROGRAMAÇÃO DE KIT.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProg;
    }

    public void buscarPavilhao(String nomePav) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO "
                    + "WHERE DescricaoPav='" + nomePav + "'");
            conecta.rs.first();
            codigoPavilhao = conecta.rs.getInt("IdPav");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
