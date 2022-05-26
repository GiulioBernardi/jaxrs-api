package br.com.evo.giulio.enterprise.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErroMensagem {

    private String mensagemDeErro;
    private int codigoDoErro;
    private String documentacao;

    public ErroMensagem() {
    }

    public ErroMensagem(String mensagemDeErro, int codigoDoErro, String documentacao) {
        super();
        this.mensagemDeErro = mensagemDeErro;
        this.codigoDoErro = codigoDoErro;
        this.documentacao = documentacao;
    }

    public String getMensagemDeErro() {
        return mensagemDeErro;
    }

    public void setMensagemDeErro(String mensagemDeErro) {
        this.mensagemDeErro = mensagemDeErro;
    }

    public int getCodigoDoErro() {
        return codigoDoErro;
    }

    public void setCodigoDoErro(int codigoDoErro) {
        this.codigoDoErro = codigoDoErro;
    }

    public String getDocumentacao() {
        return documentacao;
    }

    public void setDocumentacao(String documentacao) {
        this.documentacao = documentacao;
    }
}
