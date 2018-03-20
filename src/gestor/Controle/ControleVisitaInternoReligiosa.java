/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.VisitaInterno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleVisitaInternoReligiosa {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    VisitaInterno objVisita = new VisitaInterno();

    public VisitaInterno incluirVisitaInterno(VisitaInterno objVisita) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO VISITAS_RELIGIOSA_INTERNOS (StatusVisitaRel,ImagemVisitaRel,NomeVisitaRel,ReligiaoVisitaRel,DataNascRel,SexoVisitaRel,DataCadVisitaRel,ClassificacaoRel,EnderecoVisitaRel,BairroVisitaRel,CidadeVisitaRel,CepVisitaRel,EstadoVisitaRel,TelefoneVisitaRel,Telefone1VisitaRel,CelularVisitaRel,Celular1VisitaRel,RgVisitaRel,EmissorVisitaRel,CpfVisitaRel,DataValiAnteRel,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objVisita.getStatusVisita());
            pst.setString(2, objVisita.getFoto());
            pst.setString(3, objVisita.getNomeVisita());
            pst.setString(4, objVisita.getParentescoVisita());
            pst.setTimestamp(5, new java.sql.Timestamp(objVisita.getDataNascVisita().getTime()));
            pst.setString(6, objVisita.getSexoVisita());
            pst.setTimestamp(7, new java.sql.Timestamp(objVisita.getDataCadVisita().getTime()));
            pst.setString(8, objVisita.getAdultoCrianca());
            pst.setString(9, objVisita.getEnderecoVisita());
            pst.setString(10, objVisita.getBairroVisita());
            pst.setString(11, objVisita.getCidadeVisita());
            pst.setString(12, objVisita.getCepVisita());
            pst.setString(13, objVisita.getEstadoVisita());
            pst.setString(14, objVisita.getTelefoneVisita());
            pst.setString(15, objVisita.getTelefone1Visita());
            pst.setString(16, objVisita.getCelularVisita());
            pst.setString(17, objVisita.getCelular1Visita());
            pst.setString(18, objVisita.getRg());
            pst.setString(19, objVisita.getEmissor());
            pst.setString(20, objVisita.getCpf());
            pst.setTimestamp(21, new java.sql.Timestamp(objVisita.getDataAntecedente().getTime()));
            pst.setString(22, objVisita.getUsuarioInsert());
            pst.setString(23, objVisita.getDataInsert());
            pst.setString(24, objVisita.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objVisita;
    }

    public VisitaInterno alterarVisitaInterno(VisitaInterno objVisita) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VISITAS_RELIGIOSA_INTERNOS SET StatusVisitaRel=?,ImagemVisitaRel=?,NomeVisitaRel=?,ReligiaoVisitaRel=?,DataNascRel=?,SexoVisitaRel=?,DataCadVisitaRel=?,ClassificacaoRel=?,EnderecoVisitaRel=?,BairroVisitaRel=?,CidadeVisitaRel=?,CepVisitaRel=?,EstadoVisitaRel=?,TelefoneVisitaRel=?,Telefone1VisitaRel=?,CelularVisitaRel=?,Celular1VisitaRel=?,RgVisitaRel=?,EmissorVisitaRel=?,CpfVisitaRel=?,DataValiAnteRel=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdVisitaRel='" + objVisita.getIdVisita() + "'");
            pst.setString(1, objVisita.getStatusVisita());
            pst.setString(2, objVisita.getFoto());
            pst.setString(3, objVisita.getNomeVisita());
            pst.setString(4, objVisita.getParentescoVisita());
            pst.setTimestamp(5, new java.sql.Timestamp(objVisita.getDataNascVisita().getTime()));
            pst.setString(6, objVisita.getSexoVisita());
            pst.setTimestamp(7, new java.sql.Timestamp(objVisita.getDataCadVisita().getTime()));
            pst.setString(8, objVisita.getAdultoCrianca());
            pst.setString(9, objVisita.getEnderecoVisita());
            pst.setString(10, objVisita.getBairroVisita());
            pst.setString(11, objVisita.getCidadeVisita());
            pst.setString(12, objVisita.getCepVisita());
            pst.setString(13, objVisita.getEstadoVisita());
            pst.setString(14, objVisita.getTelefoneVisita());
            pst.setString(15, objVisita.getTelefone1Visita());
            pst.setString(16, objVisita.getCelularVisita());
            pst.setString(17, objVisita.getCelular1Visita());
            pst.setString(18, objVisita.getRg());
            pst.setString(19, objVisita.getEmissor());
            pst.setString(20, objVisita.getCpf());
            pst.setTimestamp(21, new java.sql.Timestamp(objVisita.getDataAntecedente().getTime()));
            pst.setString(22, objVisita.getUsuarioUp());
            pst.setString(23, objVisita.getDataUp());
            pst.setString(24, objVisita.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objVisita;
    }

    public VisitaInterno excluirVisitaInterno(VisitaInterno objVisita) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM VISITAS_RELIGIOSA_INTERNOS WHERE IdVisitaRel='" + objVisita.getIdVisita() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO:" + ex);
        }
        conecta.desconecta();
        return objVisita;
    }
}
