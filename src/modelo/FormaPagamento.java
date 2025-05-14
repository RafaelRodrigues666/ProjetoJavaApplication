package modelo;

/**
 *
 * @author Senai
 */
public class FormaPagamento {
    private String id;
    private String formaPagamento;
    private String valorTotal;
    private String codigoFP;
    private String tipoPagamento;
    private String categoria;
    private String[] colunas = new String[]{"ID", "FORMAPAGMENTO", "VALORTOTAL", "CODIGOFP", "TIPOPAGAMENTO", "CATEGORIA"};

    public FormaPagamento() {
    }

    public FormaPagamento(String id, String formaPagamento, String valorTotal, String codigoFP, String tipoPagamento, String categoria) {
        this.id = id;
        this.formaPagamento = formaPagamento;
        this.valorTotal = valorTotal;
        this.codigoFP = codigoFP;
        this.tipoPagamento = tipoPagamento;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }


    public String getCodigoFP() {
        return codigoFP;
    }

    public void setCodigoFP(String codigoFP) {
        this.codigoFP = codigoFP;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

    

    
    
    
}
