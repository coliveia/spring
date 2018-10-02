//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2016.08.17 às 11:45:30 AM BRT 
//


package br.com.indracompany.indrastore.ws.generated;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de produtoTO complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="produtoTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nomeProduto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="preco" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="descricaoProduto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "produtoTO", propOrder = {
    "nomeProduto",
    "preco",
    "descricaoProduto"
})
public class ProdutoTO {

    @XmlElement(required = true)
    protected String nomeProduto;
    @XmlElement(required = true)
    protected BigDecimal preco;
    @XmlElement(required = true)
    protected String descricaoProduto;

    /**
     * Obtém o valor da propriedade nomeProduto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * Define o valor da propriedade nomeProduto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeProduto(String value) {
        this.nomeProduto = value;
    }

    /**
     * Obtém o valor da propriedade preco.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPreco() {
        return preco;
    }

    /**
     * Define o valor da propriedade preco.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPreco(BigDecimal value) {
        this.preco = value;
    }

    /**
     * Obtém o valor da propriedade descricaoProduto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * Define o valor da propriedade descricaoProduto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricaoProduto(String value) {
        this.descricaoProduto = value;
    }

}
