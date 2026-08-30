package sptech.school.jogadores;

import javax.xml.crypto.Data;
import java.util.Date;

public class Jogador {
    private Integer id;
    private String nome;
    private Integer numero;
    private Date dtNasc;
    private String sexo;
    private String time;
    private String posicao;
    private String pe;
    private String caracteristicas;

    public Jogador(Integer id, String nome, Integer numero, Date dtNasc, String sexo, String time, String posicao, String pe, String caracteristicas) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.dtNasc = dtNasc;
        this.sexo = sexo;
        this.time = time;
        this.posicao = posicao;
        this.pe = pe;
        this.caracteristicas = caracteristicas;
    }

    public Jogador() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getPe() {
        return pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
