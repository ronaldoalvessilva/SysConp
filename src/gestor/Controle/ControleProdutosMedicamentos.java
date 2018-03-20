/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProdutoMedicamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleProdutosMedicamentos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProdutoMedicamento objProdMed = new ProdutoMedicamento();

    int codGrupo, codForn;
    public static int codLocal;

    public ProdutoMedicamento incluirProdutoMed(ProdutoMedicamento objProdMed) {
        buscarGrupo(objProdMed.getNomeGrupo()); // Buscar Grupo de Produtos
        buscarFornecedor(objProdMed.getDescricaoFornecedor()); // Buscar Fornecedor do Produto
        buscarLocalArmazenamento(objProdMed.getNomeLocal()); // Buscar  Local de Armazenamento de Produto.
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PRODUTOS_AC (StatusProd,CodigoBarra,DescricaoProd,UnidadeProd,ReferenciaProd,AplicarDose,QtdDoses,FotoProduto,FotoProduto2,IdGrupo,IdForn,IdLocal,DataFabricacao,DataCompra,"
                    + "DataValidade,ValorCompra,QtdCompra,DataSaida,QtdSaida,AliquotaIcms,AliquotaIpi,ClassificacaoFiscal,Observacao,Topicos,ContraIndicacoes,Substancias,AcoesTerapeuticas,Modulo,"
                    + "UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objProdMed.getStatusProd());
            pst.setString(2, objProdMed.getCodigoBarra());
            pst.setString(3, objProdMed.getDescricao());
            pst.setString(4, objProdMed.getUnidade());
            pst.setString(5, objProdMed.getReferencia());
            pst.setString(6, objProdMed.getAplicaDose());
            pst.setInt(7, objProdMed.getQdtTotalDose());
            if (objProdMed.getFotoProduto() != null) {
                pst.setString(8, objProdMed.getFotoProduto());
            } else {
                pst.setString(8, null);
            }
            if (objProdMed.getFotoProduto1() != null) {
                pst.setString(9, objProdMed.getFotoProduto1());
            } else {
                pst.setString(9, null);
            }
            pst.setInt(10, codGrupo);
            pst.setInt(11, codForn);
            pst.setInt(12, codLocal);
            if (objProdMed.getDataFabricacao() != null) {
                pst.setTimestamp(13, new java.sql.Timestamp(objProdMed.getDataFabricacao().getTime()));
            } else {
                pst.setDate(13, null);
            }
            if (objProdMed.getDataCompra() != null) {
                pst.setTimestamp(14, new java.sql.Timestamp(objProdMed.getDataCompra().getTime()));
            } else {
                pst.setDate(14, null);
            }
            if (objProdMed.getDataValidade() != null) {
                pst.setTimestamp(15, new java.sql.Timestamp(objProdMed.getDataValidade().getTime()));
            } else {
                pst.setDate(15, null);
            }
            pst.setFloat(16, objProdMed.getValorCompra());
            pst.setFloat(17, objProdMed.getQtdCompra());
            if (objProdMed.getDataSaida() != null) {
                pst.setTimestamp(18, new java.sql.Timestamp(objProdMed.getDataSaida().getTime()));
            } else {
                pst.setDate(18, null);
            }
            pst.setFloat(19, objProdMed.getQtdSaida());
            pst.setFloat(20, objProdMed.getAliquotaIcms());
            pst.setFloat(21, objProdMed.getAliquotaIpi());
            pst.setString(22, objProdMed.getClassificaoFiscal());
            pst.setString(23, objProdMed.getObservacao());
            pst.setString(24, objProdMed.getTopicos());
            pst.setString(25, objProdMed.getContraIndicaoes());
            pst.setString(26, objProdMed.getSubstancias());
            pst.setString(27, objProdMed.getAcoesTerapeuticas());
            pst.setString(28, objProdMed.getModulo());
            pst.setString(29, objProdMed.getUsuarioInsert());
            pst.setString(30, objProdMed.getDataInsert());
            pst.setString(31, objProdMed.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdMed;
    }

    public ProdutoMedicamento alterarProdutoMed(ProdutoMedicamento objProdMed) {
        buscarGrupo(objProdMed.getNomeGrupo());
        buscarFornecedor(objProdMed.getDescricaoFornecedor());
        buscarLocalArmazenamento(objProdMed.getNomeLocal());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRODUTOS_AC SET StatusProd=?,CodigoBarra=?,DescricaoProd=?,UnidadeProd=?,ReferenciaProd=?,AplicarDose=?,QtdDoses=?,FotoProduto=?,FotoProduto2=?,IdGrupo=?,IdForn=?,IdLocal=?,DataFabricacao=?,DataCompra=?,"
                    + "DataValidade=?,ValorCompra=?,QtdCompra=?,DataSaida=?,QtdSaida=?,AliquotaIcms=?,AliquotaIpi=?,ClassificacaoFiscal=?,Observacao=?,Topicos=?,ContraIndicacoes=?,Substancias=?,AcoesTerapeuticas=?,Modulo=?,"
                    + "UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdProd='" + objProdMed.getIdProd() + "'");
            pst.setString(1, objProdMed.getStatusProd());
            pst.setString(2, objProdMed.getCodigoBarra());
            pst.setString(3, objProdMed.getDescricao());
            pst.setString(4, objProdMed.getUnidade());
            pst.setString(5, objProdMed.getReferencia());
            pst.setString(6, objProdMed.getAplicaDose());
            pst.setInt(7, objProdMed.getQdtTotalDose());
            if (objProdMed.getFotoProduto() != null) {
                pst.setString(8, objProdMed.getFotoProduto());
            } else {
                pst.setString(8, null);
            }
            if (objProdMed.getFotoProduto1() != null) {
                pst.setString(9, objProdMed.getFotoProduto1());
            } else {
                pst.setString(9, null);
            }
            pst.setInt(10, codGrupo);
            pst.setInt(11, codForn);
            pst.setInt(12, codLocal);
            if (objProdMed.getDataFabricacao() != null) {
                pst.setTimestamp(13, new java.sql.Timestamp(objProdMed.getDataFabricacao().getTime()));
            } else {
                pst.setDate(13, null);
            }
            if (objProdMed.getDataCompra() != null) {
                pst.setTimestamp(14, new java.sql.Timestamp(objProdMed.getDataCompra().getTime()));
            } else {
                pst.setDate(14, null);
            }
            if (objProdMed.getDataValidade() != null) {
                pst.setTimestamp(15, new java.sql.Timestamp(objProdMed.getDataValidade().getTime()));
            } else {
                pst.setDate(15, null);
            }
            pst.setFloat(16, objProdMed.getValorCompra());
            pst.setFloat(17, objProdMed.getQtdCompra());
            if (objProdMed.getDataSaida() != null) {
                pst.setTimestamp(18, new java.sql.Timestamp(objProdMed.getDataSaida().getTime()));
            } else {
                pst.setDate(18, null);
            }
            pst.setFloat(19, objProdMed.getQtdSaida());
            pst.setFloat(20, objProdMed.getAliquotaIcms());
            pst.setFloat(21, objProdMed.getAliquotaIpi());
            pst.setString(22, objProdMed.getClassificaoFiscal());
            pst.setString(23, objProdMed.getObservacao());
            pst.setString(24, objProdMed.getTopicos());
            pst.setString(25, objProdMed.getContraIndicaoes());
            pst.setString(26, objProdMed.getSubstancias());
            pst.setString(27, objProdMed.getAcoesTerapeuticas());
            pst.setString(28, objProdMed.getModulo());
            pst.setString(29, objProdMed.getUsuarioUp());
            pst.setString(30, objProdMed.getDataUp());
            pst.setString(31, objProdMed.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdMed;
    }

    public ProdutoMedicamento excluirProdutoMed(ProdutoMedicamento objProdMed) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PRODUTOS_AC WHERE IdProd='" + objProdMed.getIdProd() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdMed;
    }

    public void buscarGrupo(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM GRUPO_PRODUTOS_AC WHERE NomeGrupo='" + nome + "'");
            conecta.rs.first();
            codGrupo = conecta.rs.getInt("IdGrupo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (GRUPO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarFornecedor(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM FORNECEDORES_AC WHERE RazaoSocial='" + nome + "'");
            conecta.rs.first();
            codForn = conecta.rs.getInt("IdForn");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (FORNECEDORES) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarLocalArmazenamento(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOCAL_ARMAZENAMENTO_AC WHERE DescricaoLocal='" + nome + "'");
            conecta.rs.first();
            codLocal = conecta.rs.getInt("IdLocal");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (LOCAL DE ARMAZENAMENTO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
