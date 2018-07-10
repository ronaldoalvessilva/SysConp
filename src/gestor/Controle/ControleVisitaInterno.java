/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Digital;
import gestor.Modelo.VisitaInterno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleVisitaInterno {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    VisitaInterno objVisita = new VisitaInterno();
    String pBio = null;
    public static int count = 0;
    public static int qtdVisitas = 0;
    String statusVisita = "Ativo";
    String statusRol = "ABERTO";

    public VisitaInterno incluirVisitaInterno(VisitaInterno objVisita) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO VISITASINTERNO (StatusVisita,ImagemVisita,NomeVisita,ParentescoVisita,DataNasc,SexoVisita,DataCadVisita,Classificacao,EnderecoVisita,BairroVisita,CidadeVisita,CepVisita,EstadoVisita,TelefoneVisita,Telefone1Visita,CelularVisita,Celular1Visita,RgVisita,EmissorVisita,CpfVisita,DataValiAnte,UsuarioInsert,DataInsert,HorarioInsert,VisitaIntima,Nacionalidade,DataEmissao,ImagemFrenteVI) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
            pst.setString(25, objVisita.getVisitaIntima());
            pst.setString(26, objVisita.getNacionalidade());
            pst.setTimestamp(27, new java.sql.Timestamp(objVisita.getDataEmissao().getTime()));
            pst.setBytes(28, objVisita.getImagemFrenteVI());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objVisita;
    }

    public VisitaInterno alterarVisitaInterno(VisitaInterno objVisita) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VISITASINTERNO SET StatusVisita=?,ImagemVisita=?,NomeVisita=?,ParentescoVisita=?,DataNasc=?,SexoVisita=?,DataCadVisita=?,Classificacao=?,EnderecoVisita=?,BairroVisita=?,CidadeVisita=?,CepVisita=?,EstadoVisita=?,TelefoneVisita=?,Telefone1Visita=?,CelularVisita=?,Celular1Visita=?,RgVisita=?,EmissorVisita=?,CpfVisita=?,DataValiAnte=?,UsuarioUp=?,DataUp=?,HorarioUp=?,VisitaIntima=?,Nacionalidade=?,DataEmissao=?,ImagemFrenteVI=? WHERE IdVisita='" + objVisita.getIdVisita() + "'");
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
            pst.setString(25, objVisita.getVisitaIntima());
            pst.setString(26, objVisita.getNacionalidade());
            pst.setTimestamp(27, new java.sql.Timestamp(objVisita.getDataEmissao().getTime()));
            pst.setBytes(28, objVisita.getImagemFrenteVI());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objVisita;
    }

    public VisitaInterno gravarBiometriaVisitaInterno(VisitaInterno objVisita) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VISITASINTERNO SET BiometriaDedo1=?,BiometriaDedo2=?,BiometriaDedo3=?,BiometriaDedo4=? WHERE IdVisita='" + objVisita.getIdVisita() + "'");
            pst.setBytes(1, objVisita.getBiometriaDedo1());
            pst.setBytes(2, objVisita.getBiometriaDedo2());
            pst.setBytes(3, objVisita.getBiometriaDedo3());
            pst.setBytes(4, objVisita.getBiometriaDedo4());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar biometria.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objVisita;
    }

    public VisitaInterno excluirVisitaInterno(VisitaInterno objVisita) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM VISITASINTERNO WHERE IdVisita='" + objVisita.getIdVisita() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objVisita;
    }

    public List<Digital> read() throws Exception {
        conecta.abrirConexao();
        List<Digital> listaVisitas = new ArrayList<Digital>();       
        try {
            conecta.executaSQL("SELECT * FROM VISITASINTERNO "
                    + "INNER JOIN ITENSROL "
                    + "ON VISITASINTERNO.IdVisita=ITENSROL.IdVisita "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSROL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN ROLVISITAS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ROLVISITAS.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE VISITASINTERNO.BiometriaDedo1!='" + pBio + "' "
                    + "AND ITENSROL.StatusVisita='" + statusVisita  + "' "
                    + "AND ROLVISITAS.StatusRol='" + statusRol + "'"); 
            while (conecta.rs.next()) {                      
                Digital pDigi = new Digital();
                pDigi.setIdRol(conecta.rs.getInt("IdRol"));
                pDigi.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigi.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pDigi.setRegime(conecta.rs.getString("Regime"));
                pDigi.setPavilhao(conecta.rs.getString("DescricaoPav"));
                pDigi.setIdVisita(conecta.rs.getInt("IdVisita"));                
                pDigi.setNomeVisita(conecta.rs.getString("NomeVisita"));
                pDigi.setCaminhoFotoVisita(conecta.rs.getString("ImagemVisita"));
                pDigi.setGrauParentesco(conecta.rs.getString("ParentescoVisita"));
                pDigi.setBiometriaDedo1(conecta.rs.getBytes("BiometriaDedo1"));
                pDigi.setBiometriaDedo2(conecta.rs.getBytes("BiometriaDedo2"));
                pDigi.setBiometriaDedo3(conecta.rs.getBytes("BiometriaDedo3"));
                pDigi.setBiometriaDedo4(conecta.rs.getBytes("BiometriaDedo4"));
                pDigi.setImagemFrenteVI(conecta.rs.getBytes("ImagemFrenteVI"));
                listaVisitas.add(pDigi);       
                qtdVisitas ++;
            }
            return listaVisitas;
        } catch (SQLException ex) {
            Logger.getLogger(ControleVisitaInterno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
