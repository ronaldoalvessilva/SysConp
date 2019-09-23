/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EscoltaInternosPSP;
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
public class ControleEscoltaInternosPSP {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EscoltaInternosPSP objEscolta = new EscoltaInternosPSP();
    int codInterno;
    int codFunc;
    public static int qtdColaboradores = 0;
    String pBio = null;
    String statusVisita = "Ativo";

    public EscoltaInternosPSP incluirEscoltaInternoPSP(EscoltaInternosPSP objEscolta) {
        buscarInternoCrc(objEscolta.getNomeInternoCrc(), objEscolta.getIdInternoCrc());
        buscarColaborador(objEscolta.getNomeColaborador(), objEscolta.getIdFunc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ESCOLTA_INTERNO_PSP (StatusEscolta,DataRegistro,IdFunc,IdInternoCrc,DataSaida,HoraSaida,AssinaturaColaboradorSaida,AssinaturaInternoSaida,AssinaturaColaboradorLiberadorSaida,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objEscolta.getStatusEscolta());
            pst.setTimestamp(2, new java.sql.Timestamp(objEscolta.getDataRegistro().getTime()));
            pst.setInt(3, codFunc);
            pst.setInt(4, codInterno);
            pst.setTimestamp(5, new java.sql.Timestamp(objEscolta.getDataSaida().getTime()));
            pst.setString(6, objEscolta.getHoraSaida());
            pst.setBytes(7, objEscolta.getAssinaturaColaboradorSaida());
            pst.setBytes(8, objEscolta.getAssinaturaInternoSaida());
            pst.setBytes(9, objEscolta.getAssinaturaColaboradorLiberadorSaida());
            pst.setString(10, objEscolta.getUsuarioInsert());
            pst.setString(11, objEscolta.getDataInsert());
            pst.setString(12, objEscolta.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEscolta;
    }

    public EscoltaInternosPSP alterarEscoltaInternoPSP(EscoltaInternosPSP objEscolta) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ESCOLTA_INTERNO_PSP SET StatusEscolta=?,DataRetorno=?,HoraRetorno=?,AssinaturaColaboradorRetorno=?,AssinaturaInternoRetorno=?,AssinaturaColaboradorLiberadorRetorno=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEsco='" + objEscolta.getIdEsco() + "'");
            pst.setString(1, objEscolta.getStatusEscolta());
            pst.setTimestamp(2, new java.sql.Timestamp(objEscolta.getDataEntrada().getTime()));
            pst.setString(3, objEscolta.getHoraEntrada());
            pst.setBytes(4, objEscolta.getAssinaturaColaboradorEntrada());
            pst.setBytes(5, objEscolta.getAssinaturaInternoEntrada());
            pst.setBytes(6, objEscolta.getAssinaturaColaboradorLiberadorRetorno());
            pst.setString(7, objEscolta.getUsuarioUp());
            pst.setString(8, objEscolta.getDataUp());
            pst.setString(9, objEscolta.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEscolta;
    }

    public void buscarInternoCrc(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nome + "' "
                    + "AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o INTERNO.\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void buscarColaborador(String nomeFunc, int codCola) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR "
                    + "WHERE NomeFunc='" + nomeFunc + "' "
                    + "AND IdFunc='" + codCola + "'");
            conecta.rs.first();
            codFunc = conecta.rs.getInt("IdFunc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o COLABORADOR.\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public List<EscoltaInternosPSP> read() throws Exception {
        conecta.abrirConexao();
        List<EscoltaInternosPSP> listaColaboradores = new ArrayList<EscoltaInternosPSP>();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR "
                    + "INNER JOIN BIOMETRIA_COLABORADORES "
                    + "ON COLABORADOR.IdFunc=BIOMETRIA_COLABORADORES.IdFunc "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON COLABORADOR.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN CARGOS "
                    + "ON COLABORADOR.IdCargo=CARGOS.IdCargo "
                    + "WHERE BIOMETRIA_COLABORADORES.BiometriaDedo1!='" + pBio + "' "
                    + "AND COLABORADOR.StatusFunc='" + statusVisita + "' ");
            while (conecta.rs.next()) {
                EscoltaInternosPSP pDigi = new EscoltaInternosPSP();
                pDigi.setIdFunc(conecta.rs.getInt("IdFunc"));
                pDigi.setNomeColaborador(conecta.rs.getString("NomeFunc"));
                pDigi.setFuncao(conecta.rs.getString("NomeCargo"));
                pDigi.setFotoColaborador(conecta.rs.getString("ImagemFunc"));
                pDigi.setBiometriaDedo1(conecta.rs.getBytes("BiometriaDedo1"));
                pDigi.setBiometriaDedo2(conecta.rs.getBytes("BiometriaDedo2"));
                pDigi.setBiometriaDedo3(conecta.rs.getBytes("BiometriaDedo3"));
                pDigi.setBiometriaDedo4(conecta.rs.getBytes("BiometriaDedo4"));
                pDigi.setImagemFrenteFunc(conecta.rs.getBytes("ImagemFrenteCO"));
                listaColaboradores.add(pDigi);
                qtdColaboradores++;
            }
            return listaColaboradores;
        } catch (SQLException ex) {
            Logger.getLogger(ControleVisitaInterno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
