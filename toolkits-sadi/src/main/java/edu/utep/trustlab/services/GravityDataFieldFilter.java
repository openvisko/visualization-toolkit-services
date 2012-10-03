
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
 *         &lt;element name="indexOfX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indexOfY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indexOfZ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "indexOfX",
    "indexOfY",
    "indexOfZ"
})
@XmlRootElement(name = "GravityDataFieldFilter")
public class GravityDataFieldFilter {

    @XmlElementRef(name = "url", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> url;
    @XmlElementRef(name = "indexOfX", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> indexOfX;
    @XmlElementRef(name = "indexOfY", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> indexOfY;
    @XmlElementRef(name = "indexOfZ", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> indexOfZ;

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

    /**
     * Gets the value of the indexOfZ property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIndexOfZ() {
        return indexOfZ;
    }

    /**
     * Sets the value of the indexOfZ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIndexOfZ(JAXBElement<String> value) {
        this.indexOfZ = ((JAXBElement<String> ) value);
    }

}
