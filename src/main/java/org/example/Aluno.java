package org.example;

public class Aluno
{
    private String tipoPlano;
    private int quantidadeCursos;
    private int cursosCompletos;
    private int quantidadeMoedas;
    private boolean recebeVoucher;

    public String getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(String tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    public int getQuantidadeCursos() {
        return quantidadeCursos;
    }

    public void setQuantidadeCursos(int quantidadeCursos) {
        this.quantidadeCursos = quantidadeCursos;
    }

    public int getCursosCompletos() {
        return cursosCompletos;
    }

    public void setCursosCompletos(int cursosCompletos) {
        this.cursosCompletos = cursosCompletos;
    }

    public int getQuantidadeMoedas() {
        return quantidadeMoedas;
    }

    public void setQuantidadeMoedas(int quantidadeMoedas) {
        this.quantidadeMoedas = quantidadeMoedas;
    }

    public boolean isRecebeVoucher() {
        return recebeVoucher;
    }

    public void setRecebeVoucher(boolean recebeVoucher) {
        this.recebeVoucher = recebeVoucher;
    }

    public boolean mudaPlano(){

        int quantidadeMinimoCursos = 12;
        boolean muda = false;
        setTipoPlano("Basico");

        if (quantidadeCursos >= quantidadeMinimoCursos && cursosCompletos >= quantidadeMinimoCursos) {
            muda = true;
            setTipoPlano("Premium");
        }

        return muda;
    }

    public boolean recebeRecompensas(){
        setQuantidadeMoedas(0);
        setRecebeVoucher(false);
        boolean recompensas = false;
        boolean validaCursos = quantidadeCursos>=12 && cursosCompletos>=12;

        if (validaCursos){
            int moedas = getQuantidadeMoedas();
            setQuantidadeMoedas(moedas+=3);
            setRecebeVoucher(true);
            recompensas = true;
        }

        return recompensas;
    }
}
