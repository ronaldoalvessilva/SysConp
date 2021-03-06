/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;


import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PagamentoKitInterno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class PagamentoKit {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PagamentoKitInterno objPag = new PagamentoKitInterno();

    int codPav;

    public PagamentoKitInterno incluirPagamentoKit(PagamentoKitInterno objPag) {
        buscarPavilhao(objPag.getDescricaoPavilhao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PAGAMENTO_KIT_INTERNOS (StatusLanc,DataLanc,Responsavel,HoraInicio,HoraTermino,IdKit,TipoKit,IdRegistro,IdPav,Observacao,UsuarioInsert,DataInsert,HorarioInsert,KitPersonalizado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objPag.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objPag.getDataLanc().getTime()));
            pst.setString(3, objPag.getResponsavel());
            pst.setString(4, objPag.getHoraInicio());
            pst.setString(5, objPag.getHoraTermino());
            pst.setInt(6, objPag.getIdKit());
            pst.setString(7, objPag.getTipoKit());
            pst.setInt(8, objPag.getIdRegistroComp());
            pst.setInt(9, codPav);
            pst.setString(10, objPag.getObservacao());
            pst.setString(11, objPag.getUsuarioInsert());
            pst.setString(12, objPag.getDataInsert());
            pst.setString(13, objPag.getHorarioInsert());
            pst.setString(14, objPag.getKitPersonalizado());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objPag;
    }

    public PagamentoKitInterno alterarPagamentoKit(PagamentoKitInterno objPag) {
        buscarPavilhao(objPag.getDescricaoPavilhao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PAGAMENTO_KIT_INTERNOS SET StatusLanc=?,DataLanc=?,Responsavel=?,HoraInicio=?,HoraTermino=?,IdKit=?,TipoKit=?,IdRegistro=?,IdPav=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=?,KitPersonalizado=? WHERE IdPagto='" + objPag.getIdPagto() + "'");
            pst.setString(1, objPag.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objPag.getDataLanc().getTime()));
            pst.setString(3, objPag.getResponsavel());
            pst.setString(4, objPag.getHoraInicio());
            pst.setString(5, objPag.getHoraTermino());
            pst.setInt(6, objPag.getIdKit());
            pst.setString(7, objPag.getTipoKit());
            pst.setInt(8, objPag.getIdRegistroComp());
            pst.setInt(9, codPav);
            pst.setString(10, objPag.getObservacao());
            pst.setString(11, objPag.getUsuarioUp());
            pst.setString(12, objPag.getDataUp());
            pst.setString(13, objPag.getHorarioUp());
            pst.setString(14, objPag.getKitPersonalizado());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objPag;
    }

    public PagamentoKitInterno excluirPagamentoKit(PagamentoKitInterno objPag) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE PAGAMENTO_KIT_INTERNOS WHERE IdPagto='" + objPag.getIdPagto() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objPag;
    }

    public PagamentoKitInterno finalizarPagamentoKit(PagamentoKitInterno objPag) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PAGAMENTO_KIT_INTERNOS SET StatusLanc=? WHERE IdPagto='" + objPag.getIdPagto() + "'");
            pst.setString(1, objPag.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objPag;
    }

    public void buscarPavilhao(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO WHERE DescricaoPav='" + desc + "'");
            conecta.rs.first();
            codPav = conecta.rs.getInt("IdPav");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (PAVILHÃO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
