package com.henrique.manutencao.business;

public class Retorno<T> {

    private boolean sucesso;
    private String mensagem;
    private T objeto;

    public Retorno(boolean sucesso, String mensagem, T objeto) {
        setSucesso(sucesso);
        setMensagem(mensagem);
        setObjeto(objeto);
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }
}
