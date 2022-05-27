package br.com.evo.giulio.enterprise.model;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement
@Entity
@Table(name= "tb_departamento")
@SequenceGenerator(name = "departamento", sequenceName = "SQ_TB_DEPARTAMENTO", allocationSize = 1)
public class Departamento implements Serializable {

    private static final long serialVersionUID = -2494178376326221016L;
    @Id
    @GeneratedValue(generator = "departamento", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nm_depto", nullable = false, length = 50)
    private String nome;

    @Column(name = "sg_depto", length = 3)
    private String sigla;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;

    @Column(name = "st_departamento")
    private Boolean status = true;

    public Departamento() {
    }

    public Departamento(Long id, String nome, String sigla, List<Funcionario> funcionarios, Boolean status) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.funcionarios = funcionarios;
        this.status = status;
    }


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
}
