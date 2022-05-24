package br.com.evo.giulio.enterprise.model;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@Entity
@Table(name= "tb_departamento")
@SequenceGenerator(name = "departamento", sequenceName = "SQ_TB_DEPARTAMENTO", allocationSize = 1)
public class Departamento implements Serializable {

    private static final long serialVersionUID = -2494178376326221016L;
    @Id
    @GeneratedValue(generator = "departamento", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nm_depto")
    private String nome;

    @Column(name = "sg_depto")
    private String sigla;

    public Departamento() {
    }


    public Departamento(Long id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "";
    }
}