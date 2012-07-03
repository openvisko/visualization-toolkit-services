
package edu.utep.trustlab.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="S" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="J" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="G" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="B" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="R" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indexOfX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indexOfY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "url",
    "s",
    "j",
    "g",
    "b",
    "r",
    "indexOfX",
    "indexOfY"
})
@XmlRootElement(name = "psxy")
public class Psxy {

    @XmlElementRef(name = "url", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> url;
    @XmlElementRef(name = "S", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> s;
    @XmlElementRef(name = "J", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> j;
    @XmlElementRef(name = "G", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> g;
    @XmlElementRef(name = "B", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> b;
    @XmlElementRef(name = "R", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> r;
    @XmlElementRef(name = "indexOfX", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> indexOfX;
    @XmlElementRef(name = "indexOfY", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> indexOfY;

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUrl(JAXBElement<String> value) {
        this.url = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the s property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getS() {
        return s;
    }

    /**
     * Sets the value of the s property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setS(JAXBElement<String> value) {
        this.s = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the j property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getJ() {
        return j;
    }

    /**
     * Sets the value of the j property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setJ(JAXBElement<String> value) {
        this.j = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the g property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getG() {
        return g;
    }

    /**
     * Sets the value of the g property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setG(JAXBElement<String> value) {
        this.g = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the b property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getB() {
        return b;
    }

    /**
     * Sets the value of the b property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setB(JAXBElement<String> value) {
        this.b = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the r property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getR() {
        return r;
    }

    /**
     * Sets the value of the r property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setR(JAXBElement<String> value) {
        this.r = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the indexOfX property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIndexOfX() {
        return indexOfX;
    }

    /**
     * Sets the value of the indexOfX property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIndexOfX(JAXBElement<String> value) {
        this.indexOfX = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the indexOfY property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIndexOfY() {
        return indexOfY;
    }

    /**
     * Sets the value of the indexOfY property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIndexOfY(JAXBElement<String> value) {
        this.indexOfY = ((JAXBElement<String> ) value);
    }

}
