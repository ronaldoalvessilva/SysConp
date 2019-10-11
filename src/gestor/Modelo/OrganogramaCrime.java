/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Socializa TI 02
 */
public class OrganogramaCrime {

    private int idOrg;
    private String statusOrg;
    private Date dataOrg;
    private int idInternoCrc;
    private String nomeInterno;    
    private String faccao;
    private int idPav;
    private String descricaoPav;
    private int idCela;
    private String descricaoCela;
    private Double recompensa;
    private String situacaoRegistro;
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;
    private int idL1A;
    private int idInternoCrcL1A;
    private String nomeInternoL1A;    
    private int idL1B;
    private int idInternoCrcL1B;
    private String nomeInternoL1B;
    private int idL1C;
    private int IdInternoCrcL1C;
    private String nomeInternoL1C;
    private int idL1D;
    private int idInternoCrcL1D;
    private String nomeInternoL1D;
    private int idInternoCrcL2A;
    private int idInternoCrcL2B;
    private int idInternoCrcL2C;
    private int idInternoCrcL2D;
    private int idL2A;
    private int idL2B;
    private int idL2C;
    private int idL2D;
    private String observacao;
    private String observacao2;
    private String observacaoFrente;
    private byte[] cartaBaralho0;
    private byte[] cartaBaralho1;
    private byte[] cartaBaralho2;
    private byte[] cartaBaralho3;
    private byte[] cartaBaralho4;
    private byte[] cartaBaralho5;
    private byte[] cartaBaralho6;
    private byte[] cartaBaralho7;
    private byte[] cartaBaralho8;

    public OrganogramaCrime() {
    }

    public OrganogramaCrime(int idOrg, String statusOrg, Date dataOrg, int idInternoCrc, String nomeInterno, String faccao, int idPav, String descricaoPav, int idCela, String descricaoCela, Double recompensa, String situacaoRegistro, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp, int idL1A, int idInternoCrcL1A, String nomeInternoL1A, int idL1B, int idInternoCrcL1B, String nomeInternoL1B, int idL1C, int IdInternoCrcL1C, String nomeInternoL1C, int idL1D, int idInternoCrcL1D, String nomeInternoL1D, int idInternoCrcL2A, int idInternoCrcL2B, int idInternoCrcL2C, int idInternoCrcL2D, int idL2A, int idL2B, int idL2C, int idL2D, String observacao, String observacao2, String observacaoFrente, byte[] cartaBaralho0, byte[] cartaBaralho1, byte[] cartaBaralho2, byte[] cartaBaralho3, byte[] cartaBaralho4, byte[] cartaBaralho5, byte[] cartaBaralho6, byte[] cartaBaralho7, byte[] cartaBaralho8) {
        this.idOrg = idOrg;
        this.statusOrg = statusOrg;
        this.dataOrg = dataOrg;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.faccao = faccao;
        this.idPav = idPav;
        this.descricaoPav = descricaoPav;
        this.idCela = idCela;
        this.descricaoCela = descricaoCela;
        this.recompensa = recompensa;
        this.situacaoRegistro = situacaoRegistro;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
        this.idL1A = idL1A;
        this.idInternoCrcL1A = idInternoCrcL1A;
        this.nomeInternoL1A = nomeInternoL1A;
        this.idL1B = idL1B;
        this.idInternoCrcL1B = idInternoCrcL1B;
        this.nomeInternoL1B = nomeInternoL1B;
        this.idL1C = idL1C;
        this.IdInternoCrcL1C = IdInternoCrcL1C;
        this.nomeInternoL1C = nomeInternoL1C;
        this.idL1D = idL1D;
        this.idInternoCrcL1D = idInternoCrcL1D;
        this.nomeInternoL1D = nomeInternoL1D;
        this.idInternoCrcL2A = idInternoCrcL2A;
        this.idInternoCrcL2B = idInternoCrcL2B;
        this.idInternoCrcL2C = idInternoCrcL2C;
        this.idInternoCrcL2D = idInternoCrcL2D;
        this.idL2A = idL2A;
        this.idL2B = idL2B;
        this.idL2C = idL2C;
        this.idL2D = idL2D;
        this.observacao = observacao;
        this.observacao2 = observacao2;
        this.observacaoFrente = observacaoFrente;
        this.cartaBaralho0 = cartaBaralho0;
        this.cartaBaralho1 = cartaBaralho1;
        this.cartaBaralho2 = cartaBaralho2;
        this.cartaBaralho3 = cartaBaralho3;
        this.cartaBaralho4 = cartaBaralho4;
        this.cartaBaralho5 = cartaBaralho5;
        this.cartaBaralho6 = cartaBaralho6;
        this.cartaBaralho7 = cartaBaralho7;
        this.cartaBaralho8 = cartaBaralho8;
    }

    /**
     * @return the idOrg
     */
    public int getIdOrg() {
        return idOrg;
    }

    /**
     * @param idOrg the idOrg to set
     */
    public void setIdOrg(int idOrg) {
        this.idOrg = idOrg;
    }

    /**
     * @return the statusOrg
     */
    public String getStatusOrg() {
        return statusOrg;
    }

    /**
     * @param statusOrg the statusOrg to set
     */
    public void setStatusOrg(String statusOrg) {
        this.statusOrg = statusOrg;
    }

    /**
     * @return the dataOrg
     */
    public Date getDataOrg() {
        return dataOrg;
    }

    /**
     * @param dataOrg the dataOrg to set
     */
    public void setDataOrg(Date dataOrg) {
        this.dataOrg = dataOrg;
    }

    /**
     * @return the idInternoCrc
     */
    public int getIdInternoCrc() {
        return idInternoCrc;
    }

    /**
     * @param idInternoCrc the idInternoCrc to set
     */
    public void setIdInternoCrc(int idInternoCrc) {
        this.idInternoCrc = idInternoCrc;
    }

    /**
     * @return the nomeInterno
     */
    public String getNomeInterno() {
        return nomeInterno;
    }

    /**
     * @param nomeInterno the nomeInterno to set
     */
    public void setNomeInterno(String nomeInterno) {
        this.nomeInterno = nomeInterno;
    }

    /**
     * @return the faccao
     */
    public String getFaccao() {
        return faccao;
    }

    /**
     * @param faccao the faccao to set
     */
    public void setFaccao(String faccao) {
        this.faccao = faccao;
    }

    /**
     * @return the idPav
     */
    public int getIdPav() {
        return idPav;
    }

    /**
     * @param idPav the idPav to set
     */
    public void setIdPav(int idPav) {
        this.idPav = idPav;
    }

    /**
     * @return the descricaoPav
     */
    public String getDescricaoPav() {
        return descricaoPav;
    }

    /**
     * @param descricaoPav the descricaoPav to set
     */
    public void setDescricaoPav(String descricaoPav) {
        this.descricaoPav = descricaoPav;
    }

    /**
     * @return the idCela
     */
    public int getIdCela() {
        return idCela;
    }

    /**
     * @param idCela the idCela to set
     */
    public void setIdCela(int idCela) {
        this.idCela = idCela;
    }

    /**
     * @return the descricaoCela
     */
    public String getDescricaoCela() {
        return descricaoCela;
    }

    /**
     * @param descricaoCela the descricaoCela to set
     */
    public void setDescricaoCela(String descricaoCela) {
        this.descricaoCela = descricaoCela;
    }

    /**
     * @return the recompensa
     */
    public Double getRecompensa() {
        return recompensa;
    }

    /**
     * @param recompensa the recompensa to set
     */
    public void setRecompensa(Double recompensa) {
        this.recompensa = recompensa;
    }

    /**
     * @return the situacaoRegistro
     */
    public String getSituacaoRegistro() {
        return situacaoRegistro;
    }

    /**
     * @param situacaoRegistro the situacaoRegistro to set
     */
    public void setSituacaoRegistro(String situacaoRegistro) {
        this.situacaoRegistro = situacaoRegistro;
    }

    /**
     * @return the usuarioInsert
     */
    public String getUsuarioInsert() {
        return usuarioInsert;
    }

    /**
     * @param usuarioInsert the usuarioInsert to set
     */
    public void setUsuarioInsert(String usuarioInsert) {
        this.usuarioInsert = usuarioInsert;
    }

    /**
     * @return the dataInsert
     */
    public String getDataInsert() {
        return dataInsert;
    }

    /**
     * @param dataInsert the dataInsert to set
     */
    public void setDataInsert(String dataInsert) {
        this.dataInsert = dataInsert;
    }

    /**
     * @return the horarioInsert
     */
    public String getHorarioInsert() {
        return horarioInsert;
    }

    /**
     * @param horarioInsert the horarioInsert to set
     */
    public void setHorarioInsert(String horarioInsert) {
        this.horarioInsert = horarioInsert;
    }

    /**
     * @return the usuarioUp
     */
    public String getUsuarioUp() {
        return usuarioUp;
    }

    /**
     * @param usuarioUp the usuarioUp to set
     */
    public void setUsuarioUp(String usuarioUp) {
        this.usuarioUp = usuarioUp;
    }

    /**
     * @return the dataUp
     */
    public String getDataUp() {
        return dataUp;
    }

    /**
     * @param dataUp the dataUp to set
     */
    public void setDataUp(String dataUp) {
        this.dataUp = dataUp;
    }

    /**
     * @return the horarioUp
     */
    public String getHorarioUp() {
        return horarioUp;
    }

    /**
     * @param horarioUp the horarioUp to set
     */
    public void setHorarioUp(String horarioUp) {
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idL1A
     */
    public int getIdL1A() {
        return idL1A;
    }

    /**
     * @param idL1A the idL1A to set
     */
    public void setIdL1A(int idL1A) {
        this.idL1A = idL1A;
    }

    /**
     * @return the idInternoCrcL1A
     */
    public int getIdInternoCrcL1A() {
        return idInternoCrcL1A;
    }

    /**
     * @param idInternoCrcL1A the idInternoCrcL1A to set
     */
    public void setIdInternoCrcL1A(int idInternoCrcL1A) {
        this.idInternoCrcL1A = idInternoCrcL1A;
    }

    /**
     * @return the nomeInternoL1A
     */
    public String getNomeInternoL1A() {
        return nomeInternoL1A;
    }

    /**
     * @param nomeInternoL1A the nomeInternoL1A to set
     */
    public void setNomeInternoL1A(String nomeInternoL1A) {
        this.nomeInternoL1A = nomeInternoL1A;
    }

    /**
     * @return the idL1B
     */
    public int getIdL1B() {
        return idL1B;
    }

    /**
     * @param idL1B the idL1B to set
     */
    public void setIdL1B(int idL1B) {
        this.idL1B = idL1B;
    }

    /**
     * @return the idInternoCrcL1B
     */
    public int getIdInternoCrcL1B() {
        return idInternoCrcL1B;
    }

    /**
     * @param idInternoCrcL1B the idInternoCrcL1B to set
     */
    public void setIdInternoCrcL1B(int idInternoCrcL1B) {
        this.idInternoCrcL1B = idInternoCrcL1B;
    }

    /**
     * @return the nomeInternoL1B
     */
    public String getNomeInternoL1B() {
        return nomeInternoL1B;
    }

    /**
     * @param nomeInternoL1B the nomeInternoL1B to set
     */
    public void setNomeInternoL1B(String nomeInternoL1B) {
        this.nomeInternoL1B = nomeInternoL1B;
    }

    /**
     * @return the idL1C
     */
    public int getIdL1C() {
        return idL1C;
    }

    /**
     * @param idL1C the idL1C to set
     */
    public void setIdL1C(int idL1C) {
        this.idL1C = idL1C;
    }

    /**
     * @return the IdInternoCrcL1C
     */
    public int getIdInternoCrcL1C() {
        return IdInternoCrcL1C;
    }

    /**
     * @param IdInternoCrcL1C the IdInternoCrcL1C to set
     */
    public void setIdInternoCrcL1C(int IdInternoCrcL1C) {
        this.IdInternoCrcL1C = IdInternoCrcL1C;
    }

    /**
     * @return the nomeInternoL1C
     */
    public String getNomeInternoL1C() {
        return nomeInternoL1C;
    }

    /**
     * @param nomeInternoL1C the nomeInternoL1C to set
     */
    public void setNomeInternoL1C(String nomeInternoL1C) {
        this.nomeInternoL1C = nomeInternoL1C;
    }

    /**
     * @return the idL1D
     */
    public int getIdL1D() {
        return idL1D;
    }

    /**
     * @param idL1D the idL1D to set
     */
    public void setIdL1D(int idL1D) {
        this.idL1D = idL1D;
    }

    /**
     * @return the idInternoCrcL1D
     */
    public int getIdInternoCrcL1D() {
        return idInternoCrcL1D;
    }

    /**
     * @param idInternoCrcL1D the idInternoCrcL1D to set
     */
    public void setIdInternoCrcL1D(int idInternoCrcL1D) {
        this.idInternoCrcL1D = idInternoCrcL1D;
    }

    /**
     * @return the nomeInternoL1D
     */
    public String getNomeInternoL1D() {
        return nomeInternoL1D;
    }

    /**
     * @param nomeInternoL1D the nomeInternoL1D to set
     */
    public void setNomeInternoL1D(String nomeInternoL1D) {
        this.nomeInternoL1D = nomeInternoL1D;
    }

    /**
     * @return the idInternoCrcL2A
     */
    public int getIdInternoCrcL2A() {
        return idInternoCrcL2A;
    }

    /**
     * @param idInternoCrcL2A the idInternoCrcL2A to set
     */
    public void setIdInternoCrcL2A(int idInternoCrcL2A) {
        this.idInternoCrcL2A = idInternoCrcL2A;
    }

    /**
     * @return the idInternoCrcL2B
     */
    public int getIdInternoCrcL2B() {
        return idInternoCrcL2B;
    }

    /**
     * @param idInternoCrcL2B the idInternoCrcL2B to set
     */
    public void setIdInternoCrcL2B(int idInternoCrcL2B) {
        this.idInternoCrcL2B = idInternoCrcL2B;
    }

    /**
     * @return the idInternoCrcL2C
     */
    public int getIdInternoCrcL2C() {
        return idInternoCrcL2C;
    }

    /**
     * @param idInternoCrcL2C the idInternoCrcL2C to set
     */
    public void setIdInternoCrcL2C(int idInternoCrcL2C) {
        this.idInternoCrcL2C = idInternoCrcL2C;
    }

    /**
     * @return the idInternoCrcL2D
     */
    public int getIdInternoCrcL2D() {
        return idInternoCrcL2D;
    }

    /**
     * @param idInternoCrcL2D the idInternoCrcL2D to set
     */
    public void setIdInternoCrcL2D(int idInternoCrcL2D) {
        this.idInternoCrcL2D = idInternoCrcL2D;
    }

    /**
     * @return the idL2A
     */
    public int getIdL2A() {
        return idL2A;
    }

    /**
     * @param idL2A the idL2A to set
     */
    public void setIdL2A(int idL2A) {
        this.idL2A = idL2A;
    }

    /**
     * @return the idL2B
     */
    public int getIdL2B() {
        return idL2B;
    }

    /**
     * @param idL2B the idL2B to set
     */
    public void setIdL2B(int idL2B) {
        this.idL2B = idL2B;
    }

    /**
     * @return the idL2C
     */
    public int getIdL2C() {
        return idL2C;
    }

    /**
     * @param idL2C the idL2C to set
     */
    public void setIdL2C(int idL2C) {
        this.idL2C = idL2C;
    }

    /**
     * @return the idL2D
     */
    public int getIdL2D() {
        return idL2D;
    }

    /**
     * @param idL2D the idL2D to set
     */
    public void setIdL2D(int idL2D) {
        this.idL2D = idL2D;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the observacao2
     */
    public String getObservacao2() {
        return observacao2;
    }

    /**
     * @param observacao2 the observacao2 to set
     */
    public void setObservacao2(String observacao2) {
        this.observacao2 = observacao2;
    }

    /**
     * @return the observacaoFrente
     */
    public String getObservacaoFrente() {
        return observacaoFrente;
    }

    /**
     * @param observacaoFrente the observacaoFrente to set
     */
    public void setObservacaoFrente(String observacaoFrente) {
        this.observacaoFrente = observacaoFrente;
    }

    /**
     * @return the cartaBaralho0
     */
    public byte[] getCartaBaralho0() {
        return cartaBaralho0;
    }

    /**
     * @param cartaBaralho0 the cartaBaralho0 to set
     */
    public void setCartaBaralho0(byte[] cartaBaralho0) {
        this.cartaBaralho0 = cartaBaralho0;
    }

    /**
     * @return the cartaBaralho1
     */
    public byte[] getCartaBaralho1() {
        return cartaBaralho1;
    }

    /**
     * @param cartaBaralho1 the cartaBaralho1 to set
     */
    public void setCartaBaralho1(byte[] cartaBaralho1) {
        this.cartaBaralho1 = cartaBaralho1;
    }

    /**
     * @return the cartaBaralho2
     */
    public byte[] getCartaBaralho2() {
        return cartaBaralho2;
    }

    /**
     * @param cartaBaralho2 the cartaBaralho2 to set
     */
    public void setCartaBaralho2(byte[] cartaBaralho2) {
        this.cartaBaralho2 = cartaBaralho2;
    }

    /**
     * @return the cartaBaralho3
     */
    public byte[] getCartaBaralho3() {
        return cartaBaralho3;
    }

    /**
     * @param cartaBaralho3 the cartaBaralho3 to set
     */
    public void setCartaBaralho3(byte[] cartaBaralho3) {
        this.cartaBaralho3 = cartaBaralho3;
    }

    /**
     * @return the cartaBaralho4
     */
    public byte[] getCartaBaralho4() {
        return cartaBaralho4;
    }

    /**
     * @param cartaBaralho4 the cartaBaralho4 to set
     */
    public void setCartaBaralho4(byte[] cartaBaralho4) {
        this.cartaBaralho4 = cartaBaralho4;
    }

    /**
     * @return the cartaBaralho5
     */
    public byte[] getCartaBaralho5() {
        return cartaBaralho5;
    }

    /**
     * @param cartaBaralho5 the cartaBaralho5 to set
     */
    public void setCartaBaralho5(byte[] cartaBaralho5) {
        this.cartaBaralho5 = cartaBaralho5;
    }

    /**
     * @return the cartaBaralho6
     */
    public byte[] getCartaBaralho6() {
        return cartaBaralho6;
    }

    /**
     * @param cartaBaralho6 the cartaBaralho6 to set
     */
    public void setCartaBaralho6(byte[] cartaBaralho6) {
        this.cartaBaralho6 = cartaBaralho6;
    }

    /**
     * @return the cartaBaralho7
     */
    public byte[] getCartaBaralho7() {
        return cartaBaralho7;
    }

    /**
     * @param cartaBaralho7 the cartaBaralho7 to set
     */
    public void setCartaBaralho7(byte[] cartaBaralho7) {
        this.cartaBaralho7 = cartaBaralho7;
    }

    /**
     * @return the cartaBaralho8
     */
    public byte[] getCartaBaralho8() {
        return cartaBaralho8;
    }

    /**
     * @param cartaBaralho8 the cartaBaralho8 to set
     */
    public void setCartaBaralho8(byte[] cartaBaralho8) {
        this.cartaBaralho8 = cartaBaralho8;
    }
}
