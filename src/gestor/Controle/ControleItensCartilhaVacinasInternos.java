/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensCartilhaVacinasInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensCartilhaVacinasInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensCartilhaVacinasInternos objItensVac = new ItensCartilhaVacinasInternos();

    int codVacina;

    public ItensCartilhaVacinasInternos incluirItensCartilhaVacinaInternos(ItensCartilhaVacinasInternos objItensVac) {
        buscarVacina(objItensVac.getDescricaoVacina());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_CARTILHA_VACINAS_INTERNOS (IdCart,IdVacina,Data1Dose,Data2Dose,Data3Dose,DataReforco,Lote1Dose,Lote2Dose,Lote3Dose,LoteReforco,DataValidade1,DataValidade2,DataValidade3,DataValidadeRef,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensVac.getIdCart());
            pst.setInt(2, codVacina);
            pst.setTimestamp(3, new java.sql.Timestamp(objItensVac.getData1Dose().getTime()));
            if (objItensVac.getData2Dose() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objItensVac.getData2Dose().getTime()));
            } else {
                pst.setDate(4, null);
            }
            if (objItensVac.getData3Dose() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objItensVac.getData3Dose().getTime()));
            } else {
                pst.setDate(5, null);
            }
            if (objItensVac.getDataReforco() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objItensVac.getDataReforco().getTime()));
            } else {
                pst.setDate(6, null);
            }
            pst.setString(7, objItensVac.getLote1Dose());
            pst.setString(8, objItensVac.getLote2Dose());
            pst.setString(9, objItensVac.getLote3Dose());
            pst.setString(10, objItensVac.getLoteReforco());
            if (objItensVac.getDataValidade1() != null) {
                pst.setTimestamp(11, new java.sql.Timestamp(objItensVac.getDataValidade1().getTime()));
            } else {
                pst.setDate(11, null);
            }
            if (objItensVac.getDataValidade2() != null) {
                pst.setTimestamp(12, new java.sql.Timestamp(objItensVac.getDataValidade2().getTime()));
            } else {
                pst.setDate(12, null);
            }
            if (objItensVac.getDataValidade3() != null) {
                pst.setTimestamp(13, new java.sql.Timestamp(objItensVac.getDataValidade3().getTime()));
            } else {
                pst.setDate(13, null);
            }
            if (objItensVac.getDataValidadeRef() != null) {
                pst.setTimestamp(14, new java.sql.Timestamp(objItensVac.getDataValidadeRef().getTime()));
            } else {
                pst.setDate(14, null);
            }
            pst.setString(15, objItensVac.getUsuarioInsert());
            pst.setString(16, objItensVac.getDataInsert());
            pst.setString(17, objItensVac.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensVac;
    }

    public ItensCartilhaVacinasInternos alterarItensCartilhaVacinaInternos(ItensCartilhaVacinasInternos objItensVac) {
        buscarVacina(objItensVac.getDescricaoVacina());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_CARTILHA_VACINAS_INTERNOS SET IdCart=?,IdVacina=?,Data1Dose=?,Data2Dose=?,Data3Dose=?,DataReforco=?,Lote1Dose=?,Lote2Dose=?,Lote3Dose=?,LoteReforco=?,DataValidade1=?,DataValidade2=?,DataValidade3=?,DataValidadeRef=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemCart='" + objItensVac.getIdItemCart() + "'");
            pst.setInt(1, objItensVac.getIdCart());
            pst.setInt(1, objItensVac.getIdCart());
            pst.setInt(2, codVacina);
            pst.setTimestamp(3, new java.sql.Timestamp(objItensVac.getData1Dose().getTime()));
            if (objItensVac.getData2Dose() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objItensVac.getData2Dose().getTime()));
            } else {
                pst.setDate(4, null);
            }
            if (objItensVac.getData3Dose() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objItensVac.getData3Dose().getTime()));
            } else {
                pst.setDate(5, null);
            }
            if (objItensVac.getDataReforco() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objItensVac.getDataReforco().getTime()));
            } else {
                pst.setDate(6, null);
            }
            pst.setString(7, objItensVac.getLote1Dose());
            pst.setString(8, objItensVac.getLote2Dose());
            pst.setString(9, objItensVac.getLote3Dose());
            pst.setString(10, objItensVac.getLoteReforco());
            if (objItensVac.getDataValidade1() != null) {
                pst.setTimestamp(11, new java.sql.Timestamp(objItensVac.getDataValidade1().getTime()));
            } else {
                pst.setDate(11, null);
            }
            if (objItensVac.getDataValidade2() != null) {
                pst.setTimestamp(12, new java.sql.Timestamp(objItensVac.getDataValidade2().getTime()));
            } else {
                pst.setDate(12, null);
            }
            if (objItensVac.getDataValidade3() != null) {
                pst.setTimestamp(13, new java.sql.Timestamp(objItensVac.getDataValidade3().getTime()));
            } else {
                pst.setDate(13, null);
            }
            if (objItensVac.getDataValidadeRef() != null) {
                pst.setTimestamp(14, new java.sql.Timestamp(objItensVac.getDataValidadeRef().getTime()));
            } else {
                pst.setDate(14, null);
            }
            pst.setString(15, objItensVac.getUsuarioUp());
            pst.setString(16, objItensVac.getDataUp());
            pst.setString(17, objItensVac.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensVac;
    }

    public ItensCartilhaVacinasInternos excluirItensCartilhaVacinaInternos(ItensCartilhaVacinasInternos objItensVac) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_CARTILHA_VACINAS_INTERNOS WHERE IdItemCart='" + objItensVac.getIdItemCart() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensVac;
    }

    public void buscarVacina(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TIPOS_VACINAS WHERE DescricaoVacina='" + desc + "'");
            conecta.rs.first();
            codVacina = conecta.rs.getInt("IdVacina");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar a vacina.\nERRO: " + ex);
        }
    }
}
