/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FemininoAdmissaoPedago;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleFemininoPedagogia {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FemininoAdmissaoPedago objFemPedago = new FemininoAdmissaoPedago();

    int idCod;

    public FemininoAdmissaoPedago incluirAdmissaoFemininoEscolar(FemininoAdmissaoPedago objFemPedago) {
        buscarInterno(objFemPedago.getNomeInternoCrc(), objFemPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FEMININO_ADMISSAO_PEDAGOGIA (IdAdm,IdInternoCrc,FilhoDesejado,QueriaEngravidar,FoiAcidental,Perturbou,ComoFoiGestacao,ComoFoiParto,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objFemPedago.getIdAdm());
            pst.setInt(2, idCod);
            pst.setString(3, objFemPedago.getFilhoDesejado());
            pst.setString(4, objFemPedago.getQueriaEngravidar());
            pst.setString(5, objFemPedago.getFoiAcidental());
            pst.setString(6, objFemPedago.getPerturbou());
            pst.setString(7, objFemPedago.getComoFoiGestacao());
            pst.setString(8, objFemPedago.getComoFoiParto());
            pst.setString(9, objFemPedago.getUsuarioInsert());
            pst.setString(10, objFemPedago.getDataInsert());
            pst.setString(11, objFemPedago.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFemPedago;
    }

    public FemininoAdmissaoPedago alterarAdmissaoFemininoEscolar(FemininoAdmissaoPedago objFemPedago) {
        buscarInterno(objFemPedago.getNomeInternoCrc(), objFemPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FEMININO_ADMISSAO_PEDAGOGIA SET IdAdm=?,IdInternoCrc=?,FilhoDesejado=?,QueriaEngravidar=?,FoiAcidental=?,Perturbou=?,ComoFoiGestacao=?,ComoFoiParto=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdFemAdm='" + objFemPedago.getIdFemAdm() + "'");
            pst.setInt(1, objFemPedago.getIdAdm());
            pst.setInt(2, idCod);
            pst.setString(3, objFemPedago.getFilhoDesejado());
            pst.setString(4, objFemPedago.getQueriaEngravidar());
            pst.setString(5, objFemPedago.getFoiAcidental());
            pst.setString(6, objFemPedago.getPerturbou());
            pst.setString(7, objFemPedago.getComoFoiGestacao());
            pst.setString(8, objFemPedago.getComoFoiParto());
            pst.setString(9, objFemPedago.getUsuarioUp());
            pst.setString(10, objFemPedago.getDataUp());
            pst.setString(11, objFemPedago.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFemPedago;
    }

    public FemininoAdmissaoPedago excluirAdmissaoFemininoEscolar(FemininoAdmissaoPedago objFemPedago) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FEMININO_ADMISSAO_PEDAGOGIA WHERE IdFemAdm='" + objFemPedago.getIdFemAdm() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFemPedago;
    }

    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            idCod = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (PRONTUARIOS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
