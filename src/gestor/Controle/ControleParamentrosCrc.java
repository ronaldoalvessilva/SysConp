/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ParametrosCrc;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleParamentrosCrc {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ParametrosCrc objParCrc = new ParametrosCrc();

    public ParametrosCrc alterarParametrosCrc(ParametrosCrc objParCrc) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PARAMETROSCRC SET QtdDias=?,QtdHoras=?,UsuarioAutorizado=?,RetornosPortaria=?,EntradasPortaria=?,UsuarioUp=?,DataUp=?,HorarioUp=?,"
                    + "DocAudiencia=?,DocTrans=?,DocSaidaTmp=?,DocLivraPro=?,ValAudiencia=?,Valtrans=?,ValSaidaTmp=?,ValLivraPro=?,DocPro=?,DocAlvara=?,ValPro=?,ValAlvara=?,PopulacaoBgp=?,LocacaoBgp=?,"
                    + "TransferenciaBgp=?,PavilhaoCelaBgp=?,PopulacaoBpa=?,LocacaoBpa=?,TransferenciaBpa=?,PavilhaoCelaBpa=?,CaminhoImagemServicoSocial=?,CaminhoImagemCRCInterno=?,LocalFotosAdvogados=?,"
                    + "LocalFotoVisitasDiversas=?,LocalFotosOficialJustica=?,LocalFotosVisitasInternos=?,LocalFotosInternos=?,LocalFotosColaboradores=?,CaminhoImagemColaboradores=?,BiometriaMedicos=?,"
                    + "BiometriaEnfermeiros=?,BiometriaTecnicos=?,CarcereFem=? WHERE IdPar='" + objParCrc.getIdPar() + "'");
            pst.setInt(1, objParCrc.getQtdDias());
            pst.setString(2, objParCrc.getQtdHoras());
            pst.setString(3, objParCrc.getUsuarioAutorizado());
            pst.setString(4, objParCrc.getRegRetornoPortaria());
            pst.setString(5, objParCrc.getRegEntradaPortaria());
            pst.setString(6, objParCrc.getUsuariosUp());
            pst.setString(7, objParCrc.getDataUp());
            pst.setString(8, objParCrc.getHorarioUp());
            pst.setString(9, objParCrc.getDocAudiencia());
            pst.setString(10, objParCrc.getDocTrans());
            pst.setString(11, objParCrc.getDocSaidaTmp());
            pst.setString(12, objParCrc.getDocLivraPro());
            pst.setString(13, objParCrc.getValAudiencia());
            pst.setString(14, objParCrc.getValTrans());
            pst.setString(15, objParCrc.getValSaidaTmp());
            pst.setString(16, objParCrc.getValLivraPro());
            pst.setString(17, objParCrc.getDocPro());
            pst.setString(18, objParCrc.getDocAlvara());
            pst.setString(19, objParCrc.getValPro());
            pst.setString(20, objParCrc.getValAlvara());
            pst.setString(21, objParCrc.getPopulacaoBgp());
            pst.setString(22, objParCrc.getLocacaoBgp());
            pst.setString(23, objParCrc.getTransferenciaBgp());
            pst.setString(24, objParCrc.getPavilhaoCelas());
            pst.setString(25, objParCrc.getPopulacaoBpa());
            pst.setString(26, objParCrc.getLocacaoBpa());
            pst.setString(27, objParCrc.getTransferenciaBpa());
            pst.setString(28, objParCrc.getPavilhaoCelasBpa());
            pst.setString(29, objParCrc.getCaminhoImagemSS());
            pst.setString(30, objParCrc.getCaminhoImagemCrc());
            pst.setString(31, objParCrc.getLocalFotoAdvogado());
            pst.setString(32, objParCrc.getLocalFotoVisitasDiversas());
            pst.setString(33, objParCrc.getLocalFotoOficial());
            pst.setString(34, objParCrc.getLocalFotoVisitasInternos());
            pst.setString(35, objParCrc.getLocalFotoInternos());
            pst.setString(36, objParCrc.getLocalFotoColaboradores());
            pst.setString(37, objParCrc.getCaminhoImagemFunc());
            pst.setString(38, objParCrc.getBiometriaMedicos());
            pst.setString(39, objParCrc.getBiometriaEnfermerios());
            pst.setString(40, objParCrc.getBiometriaTecnicos());
            pst.setString(41, objParCrc.getCarcereFem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objParCrc;
    }
}
