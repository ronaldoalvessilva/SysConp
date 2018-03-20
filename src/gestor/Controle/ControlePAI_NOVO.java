/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PaiPsicoSocialNovo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControlePAI_NOVO {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PaiPsicoSocialNovo objPaiPsico = new PaiPsicoSocialNovo();
    int codInt;

    public PaiPsicoSocialNovo incluirPAI(PaiPsicoSocialNovo objPaiPsico) {
        buscarInternoCrc(objPaiPsico.getNomeInternoCrc(), objPaiPsico.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FICHA_CADASTRO_PAI_PSICOSOCIAL (StatusPai,DataPai,IdInternoCrc,IdadeInterno,Naturalidade,OrientacaoSexual,MunicipioRegistrado,"
                    + "TipoOrientacaoSexual,DocumentoDelega,QualDocumento,QualDelegacia,RegularizarDocumento,TipoDocumento,RGInternoPAI,Emissor,DataExpedicao,CPFInternoPAI,CartaoSUSPAI,"
                    + "TituloEleitor,Zona,Sessao,NIS,CTPS,Serie,Religiao,EstadoCivil,Endereco,Complemento,Referencia,Bairro,Cidade,Estado,Telefone,Telefone1,Celular,UsuarioInsert,DataInsert,HorarioInsert) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objPaiPsico.getStatusPai());
            pst.setTimestamp(2, new java.sql.Timestamp(objPaiPsico.getDataPai().getTime()));
            pst.setInt(3, codInt);
            pst.setInt(4, objPaiPsico.getIdadeInterno());
            pst.setString(5, objPaiPsico.getNaturalidade());
            pst.setString(6, objPaiPsico.getOrientacaoSexual());
            pst.setString(7, objPaiPsico.getMunicipioRegistrado());
            pst.setString(8, objPaiPsico.getTipoOrientacaoSexual());
            pst.setString(9, objPaiPsico.getDocumentoDelega());
            pst.setString(10, objPaiPsico.getQualDocumento());
            pst.setString(11, objPaiPsico.getQualDelegacia());
            pst.setString(12, objPaiPsico.getRegularizarDocumento());
            pst.setString(13, objPaiPsico.getTipoDocumento());
            pst.setString(14, objPaiPsico.getrGInternoPAI());
            pst.setString(15, objPaiPsico.getEmissor());
            if (objPaiPsico.getDataExpedicao() != null) {
                pst.setTimestamp(16, new java.sql.Timestamp(objPaiPsico.getDataExpedicao().getTime()));
            } else {
                pst.setDate(16, null);
            }
            pst.setString(17, objPaiPsico.getcPFInternoPAI());
            pst.setString(18, objPaiPsico.getCartaoSUSPAI());
            pst.setString(19, objPaiPsico.getTituloEleitor());
            pst.setString(20, objPaiPsico.getZona());
            pst.setString(21, objPaiPsico.getSessao());
            pst.setString(22, objPaiPsico.getnIS());
            pst.setString(23, objPaiPsico.getcTPS());
            pst.setString(24, objPaiPsico.getSerie());
            pst.setString(25, objPaiPsico.getReligiao());
            pst.setString(26, objPaiPsico.getEstadoCivil());
            pst.setString(27, objPaiPsico.getEndereco());
            pst.setString(28, objPaiPsico.getComplemento());
            pst.setString(29, objPaiPsico.getReferencia());
            pst.setString(30, objPaiPsico.getBairro());
            pst.setString(31, objPaiPsico.getCidade());
            pst.setString(32, objPaiPsico.getEstado());
            pst.setString(33, objPaiPsico.getTelefone());
            pst.setString(34, objPaiPsico.getTelefone1());
            pst.setString(35, objPaiPsico.getCelular());
            pst.setString(36, objPaiPsico.getUsuarioInsert());
            pst.setString(37, objPaiPsico.getDataInsert());
            pst.setString(38, objPaiPsico.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPaiPsico;
    }

    public PaiPsicoSocialNovo alterarPAI(PaiPsicoSocialNovo objPaiPsico) {
        buscarInternoCrc(objPaiPsico.getNomeInternoCrc(), objPaiPsico.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FICHA_CADASTRO_PAI_PSICOSOCIAL SET StatusPai=?,DataPai=?,IdInternoCrc=?,IdadeInterno=?,Naturalidade=?,OrientacaoSexual=?,MunicipioRegistrado=?,"
                    + "TipoOrientacaoSexual=?,DocumentoDelega=?,QualDocumento=?,QualDelegacia=?,RegularizarDocumento=?,TipoDocumento=?,RGInternoPAI=?,Emissor=?,DataExpedicao=?,CPFInternoPAI=?,CartaoSUSPAI=?,"
                    + "TituloEleitor=?,Zona=?,Sessao=?,NIS=?,CTPS=?,Serie=?,Religiao=?,EstadoCivil=?,Endereco=?,Complemento=?,Referencia=?,Bairro=?,Cidade=?,Estado=?,Telefone=?,Telefone1=?,Celular=?,UsuarioUp=?,DataUp=?,HorarioUp=? "
                    + "WHERE IdPai='" + objPaiPsico.getIdPai() + "'");
            pst.setString(1, objPaiPsico.getStatusPai());
            pst.setTimestamp(2, new java.sql.Timestamp(objPaiPsico.getDataPai().getTime()));
            pst.setInt(3, codInt);
            pst.setInt(4, objPaiPsico.getIdadeInterno());
            pst.setString(5, objPaiPsico.getNaturalidade());
            pst.setString(6, objPaiPsico.getOrientacaoSexual());
            pst.setString(7, objPaiPsico.getMunicipioRegistrado());
            pst.setString(8, objPaiPsico.getTipoOrientacaoSexual());
            pst.setString(9, objPaiPsico.getDocumentoDelega());
            pst.setString(10, objPaiPsico.getQualDocumento());
            pst.setString(11, objPaiPsico.getQualDelegacia());
            pst.setString(12, objPaiPsico.getRegularizarDocumento());
            pst.setString(13, objPaiPsico.getTipoDocumento());
            pst.setString(14, objPaiPsico.getrGInternoPAI());
            pst.setString(15, objPaiPsico.getEmissor());
            if (objPaiPsico.getDataExpedicao() != null) {
                pst.setTimestamp(16, new java.sql.Timestamp(objPaiPsico.getDataExpedicao().getTime()));
            } else {
                pst.setDate(16, null);
            }
            pst.setString(17, objPaiPsico.getcPFInternoPAI());
            pst.setString(18, objPaiPsico.getCartaoSUSPAI());
            pst.setString(19, objPaiPsico.getTituloEleitor());
            pst.setString(20, objPaiPsico.getZona());
            pst.setString(21, objPaiPsico.getSessao());
            pst.setString(22, objPaiPsico.getnIS());
            pst.setString(23, objPaiPsico.getcTPS());
            pst.setString(24, objPaiPsico.getSerie());
            pst.setString(25, objPaiPsico.getReligiao());
            pst.setString(26, objPaiPsico.getEstadoCivil());
            pst.setString(27, objPaiPsico.getEndereco());
            pst.setString(28, objPaiPsico.getComplemento());
            pst.setString(29, objPaiPsico.getReferencia());
            pst.setString(30, objPaiPsico.getBairro());
            pst.setString(31, objPaiPsico.getCidade());
            pst.setString(32, objPaiPsico.getEstado());
            pst.setString(33, objPaiPsico.getTelefone());
            pst.setString(34, objPaiPsico.getTelefone1());
            pst.setString(35, objPaiPsico.getCelular());
            pst.setString(36, objPaiPsico.getUsuarioUp());
            pst.setString(37, objPaiPsico.getDataUp());
            pst.setString(38, objPaiPsico.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPaiPsico;
    }

    public PaiPsicoSocialNovo excluirPAI(PaiPsicoSocialNovo objPaiPsico) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FICHA_CADASTRO_PAI_PSICOSOCIAL WHERE IdPai='" + objPaiPsico.getIdPai() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPaiPsico;
    }

    public void buscarInternoCrc(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
