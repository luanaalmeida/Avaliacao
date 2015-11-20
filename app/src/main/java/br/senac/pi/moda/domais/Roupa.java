package br.senac.pi.moda.domais;


public class Roupa {
    private long id;
    private String peca;
    private String cor;
    private String tamanho;

    public Roupa() {
    }

    public Roupa(long id, String peca, String cor, String tamanho) {
        this.id = id;
        this.peca = peca;
        this.cor = cor;
        this.tamanho = tamanho;
    }

    public String getPeca() {
        return peca;
    }

    public void setPeca(String Peca) {
        this.peca = peca;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String Cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String Tamanho) {
        this.tamanho = tamanho;
    }

    public void setPeca(long peca) {
    }

    public void setCor(long cor) {
    }

    public void getTamanho(long tamanho) {

    }
}

