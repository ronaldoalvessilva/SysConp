/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensAtividadesComplementaresPedagogia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleInternosAtividadesComplementares {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensAtividadesComplementaresPedagogia objItens = new ItensAtividadesComplementaresPedagogia();
    int codigoInterno = 0;

    public ItensAtividadesComplementaresPedagogia incluir_INTERNO_AC(ItensAtividadesComplementaresPedagogia objItens) {
        pesquisarInterno(objItens.getNomeInterno(), objItens.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA (IdAC,IdInternoCrc,Observacao,DiaSeg,DiaTer,DiaQua,DiaQui,DiaSex,DiaSab,DiaDom,HoraEntSeg,HoraEntTer,HoraEntQua,HoraEntQui,HoraEntSex,HoraEntSab,HoraEntDom,HoraSaiSeg,HoraSaiTer,HoraSaiQua,HoraSaiQui,HoraSaiSex,HoraSaiSab,HoraSaiDom,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItens.getIdAC());
            pst.setInt(2, codigoInterno);
            pst.setString(3, objItens.getObservacao());
            pst.setInt(4, objItens.getDiaSeg());
            pst.setInt(5, objItens.getDiaTer());
            pst.setInt(6, objItens.getDiaQua());
            pst.setInt(7, objItens.getDiaQui());
            pst.setInt(8, objItens.getDiaSex());
            pst.setInt(9, objItens.getDiaSab());
            pst.setInt(10, objItens.getDiaDom());
            pst.setString(11, objItens.getHoraEntSeg());
            pst.setString(12, objItens.getHoraEntTer());
            pst.setString(13, objItens.getHoraEntQua());
            pst.setString(14, objItens.getHoraEntQui());
            pst.setString(15, objItens.getHoraEntSex());
            pst.setString(16, objItens.getHoraEntSab());
            pst.setString(17, objItens.getHoraEntDom());
            pst.setString(18, objItens.getHoraSaiSeg());
            pst.setString(19, objItens.getHoraSaiTer());
            pst.setString(20, objItens.getHoraSaiQua());
            pst.setString(21, objItens.getHoraSaiQui());
            pst.setString(22, objItens.getHoraSaiSex());
            pst.setString(23, objItens.getHoraSaiSab());
            pst.setString(24, objItens.getHoraSaiDom());
            pst.setString(25, objItens.getUsuarioInsert());
            pst.setString(26, objItens.getDataInsert());
            pst.setString(27, objItens.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItens;
    }

    public ItensAtividadesComplementaresPedagogia alterar_INTERNO_AC(ItensAtividadesComplementaresPedagogia objItens) {
        pesquisarInterno(objItens.getNomeInterno(), objItens.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA SET IdAC=?,IdInternoCrc=?,Observacao=?,DiaSeg=?,DiaTer=?,DiaQua=?,DiaQui=?,DiaSex=?,DiaSab=?,DiaDom=?,HoraEntSeg=?,HoraEntTer=?,HoraEntQua=?,HoraEntQui=?,HoraEntSex=?,HoraEntSab=?,HoraEntDom=?,HoraSaiSeg=?,HoraSaiTer=?,HoraSaiQua=?,HoraSaiQui=?,HoraSaiSex=?,HoraSaiSab=?,HoraSaiDom=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemAC='" + objItens.getIdItemAC() + "'");
            pst.setInt(1, objItens.getIdAC());
            pst.setInt(2, codigoInterno);
            pst.setString(3, objItens.getObservacao());
            pst.setInt(4, objItens.getDiaSeg());
            pst.setInt(5, objItens.getDiaTer());
            pst.setInt(6, objItens.getDiaQua());
            pst.setInt(7, objItens.getDiaQui());
            pst.setInt(8, objItens.getDiaSex());
            pst.setInt(9, objItens.getDiaSab());
            pst.setInt(10, objItens.getDiaDom());
            pst.setString(11, objItens.getHoraEntSeg());
            pst.setString(12, objItens.getHoraEntTer());
            pst.setString(13, objItens.getHoraEntQua());
            pst.setString(14, objItens.getHoraEntQui());
            pst.setString(15, objItens.getHoraEntSex());
            pst.setString(16, objItens.getHoraEntSab());
            pst.setString(17, objItens.getHoraEntDom());
            pst.setString(18, objItens.getHoraSaiSeg());
            pst.setString(19, objItens.getHoraSaiTer());
            pst.setString(20, objItens.getHoraSaiQua());
            pst.setString(21, objItens.getHoraSaiQui());
            pst.setString(22, objItens.getHoraSaiSex());
            pst.setString(23, objItens.getHoraSaiSab());
            pst.setString(24, objItens.getHoraSaiDom());
            pst.setString(25, objItens.getUsuarioUp());
            pst.setString(26, objItens.getDataUp());
            pst.setString(27, objItens.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItens;
    }

    public ItensAtividadesComplementaresPedagogia excluir_INTERNO_AC(ItensAtividadesComplementaresPedagogia objItens) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA WHERE IdItemAC='" + objItens.getIdItemAC() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItens;
    }

    public void pesquisarInterno(String nome, int id) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nome + "' "
                    + "AND IdInternoCrc='" + id + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
