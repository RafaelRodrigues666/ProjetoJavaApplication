package modelo;

/**
 *
 * @author Senai
 */
public class Produto {
    private String id;
    private String descricao;
    private String precoCusto;
    private String precoVenda;
    private String sku;
    private String categoria;
    private String marca;
    private String modelo;
    private String unidadeMedida;
    
    
    private String[] colunas = new String[]{"ID", "DESCRICAO", "PRECOCUSTO", "PRECOVENDA", "SKU", "CATEGORIA"};

    public Produto() {
    }

    public Produto(String id, String descricao, String precoCusto, String precoVenda, String sku, String categoria, String marca, String modelo, String unidadeMedida) {
        this.id = id;
        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.sku = sku;
        this.categoria = categoria;
        this.marca = marca;
        this.modelo = modelo;
        this.unidadeMedida = unidadeMedida;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(String precoCusto) {
        this.precoCusto = precoCusto;
    }

    public String getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(String precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

    
    
    
}
