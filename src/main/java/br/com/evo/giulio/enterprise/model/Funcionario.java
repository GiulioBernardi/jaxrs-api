package br.com.evo.giulio.enterprise.model;


public class Funcionario {

    private Long id;
    private String nome;
    private String foto;

    private String rg;


    private String departamento;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, String foto, String rg, String departamento) {
        this.id = id;
        this.nome = nome;
        this.foto = foto;
        this.rg = rg;
        this.departamento = departamento;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
