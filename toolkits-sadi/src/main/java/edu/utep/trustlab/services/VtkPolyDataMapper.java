
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
 *         &lt;element name="scalarRange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xRotation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="yRotation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="zRotation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="backgroundColor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="magnification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "scalarRange",
    "xRotation",
    "yRotation",
    "zRotation",
    "size",
    "backgroundColor",
    "magnification"
})
@XmlRootElement(name = "vtkPolyDataMapper")
public class VtkPolyDataMapper {

    @XmlElementRef(name = "url", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> url;
    @XmlElementRef(name = "scalarRange", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> scalarRange;
    @XmlElementRef(name = "xRotation", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> xRotation;
    @XmlElementRef(name = "yRotation", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> yRotation;
    @XmlElementRef(name = "zRotation", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> zRotation;
    @XmlElementRef(name = "size", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> size;
    @XmlElementRef(name = "backgroundColor", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> backgroundColor;
    @XmlElementRef(name = "magnification", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> magnification;

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
     * Gets the value of the scalarRange property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getScalarRange() {
        return scalarRange;
    }

    /**
     * Sets the value of the scalarRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setScalarRange(JAXBElement<String> value) {
        this.scalarRange = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the xRotation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getXRotation() {
        return xRotation;
    }

    /**
     * Sets the value of the xRotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setXRotation(JAXBElement<String> value) {
        this.xRotation = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the yRotation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getYRotation() {
        return yRotation;
    }

    /**
     * Sets the value of the yRotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setYRotation(JAXBElement<String> value) {
        this.yRotation = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the zRotation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getZRotation() {
        return zRotation;
    }

    /**
     * Sets the value of the zRotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setZRotation(JAXBElement<String> value) {
        this.zRotation = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the size property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSize(JAXBElement<String> value) {
        this.size = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the backgroundColor property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Sets the value of the backgroundColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBackgroundColor(JAXBElement<String> value) {
        this.backgroundColor = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the magnification property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMagnification() {
        return magnification;
    }

    /**
     * Sets the value of the magnification property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMagnification(JAXBElement<String> value) {
        this.magnification = ((JAXBElement<String> ) value);
    }

}
