package br.com.evo.giulio.enterprise.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@Entity
@Table(name= "tb_funcionario")
@SequenceGenerator(name = "funcionario", sequenceName = "SQ_TB_FUNCIONARIO", allocationSize = 1)
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1592313067732063043L;
    @Id
    @GeneratedValue(generator = "funcionario", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nm_funcionario", length = 55, nullable = false)
    private String nome;

    @Column(name = "ds_foto_funcionario")
    private String foto;

    @Column(name = "ds_rg_funcionario", length = 15, nullable = false)
    private String rg;

    @ManyToOne
    @JoinColumn(name = "departamentoId")
    private Departamento departamento;

    @Column(name = "st_funcionario", updatable = false)
    private Boolean status = true;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Funcionario() {
    }

    public Funcionario(String rg) {
        this.rg = rg;
    }

    public Funcionario(Long id, String nome, String foto, String rg, Departamento departamento, Boolean status) {
        this.id = id;
        this.nome = nome;
        this.foto = foto;
        this.rg = rg;
        this.departamento = departamento;
        this.status = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }


    @Override
    public String toString() {
        return this.getRg();
    }
}
