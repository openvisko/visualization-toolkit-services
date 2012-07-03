
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
 *         &lt;element name="plotVariable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="font" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lbOrientation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cnLevelSpacingF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="colorTable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cnLinesOn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cnFillOn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="latVariable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lonVariable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "plotVariable",
    "font",
    "lbOrientation",
    "cnLevelSpacingF",
    "colorTable",
    "cnLinesOn",
    "cnFillOn",
    "latVariable",
    "lonVariable",
    "indexOfX",
    "indexOfY",
    "indexOfZ"
})
@XmlRootElement(name = "gsn_csm_contour_map")
public class GsnCsmContourMap {

    @XmlElementRef(name = "url", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> url;
    @XmlElementRef(name = "plotVariable", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> plotVariable;
    @XmlElementRef(name = "font", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> font;
    @XmlElementRef(name = "lbOrientation", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> lbOrientation;
    @XmlElementRef(name = "cnLevelSpacingF", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> cnLevelSpacingF;
    @XmlElementRef(name = "colorTable", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> colorTable;
    @XmlElementRef(name = "cnLinesOn", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> cnLinesOn;
    @XmlElementRef(name = "cnFillOn", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> cnFillOn;
    @XmlElementRef(name = "latVariable", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> latVariable;
    @XmlElementRef(name = "lonVariable", namespace = "http://services.trustlab.utep.edu", type = JAXBElement.class)
    protected JAXBElement<String> lonVariable;
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
     * Gets the value of the plotVariable property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPlotVariable() {
        return plotVariable;
    }

    /**
     * Sets the value of the plotVariable property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPlotVariable(JAXBElement<String> value) {
        this.plotVariable = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the font property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFont() {
        return font;
    }

    /**
     * Sets the value of the font property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFont(JAXBElement<String> value) {
        this.font = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the lbOrientation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLbOrientation() {
        return lbOrientation;
    }

    /**
     * Sets the value of the lbOrientation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLbOrientation(JAXBElement<String> value) {
        this.lbOrientation = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the cnLevelSpacingF property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCnLevelSpacingF() {
        return cnLevelSpacingF;
    }

    /**
     * Sets the value of the cnLevelSpacingF property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCnLevelSpacingF(JAXBElement<String> value) {
        this.cnLevelSpacingF = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the colorTable property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getColorTable() {
        return colorTable;
    }

    /**
     * Sets the value of the colorTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setColorTable(JAXBElement<String> value) {
        this.colorTable = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the cnLinesOn property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCnLinesOn() {
        return cnLinesOn;
    }

    /**
     * Sets the value of the cnLinesOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCnLinesOn(JAXBElement<String> value) {
        this.cnLinesOn = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the cnFillOn property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCnFillOn() {
        return cnFillOn;
    }

    /**
     * Sets the value of the cnFillOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCnFillOn(JAXBElement<String> value) {
        this.cnFillOn = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the latVariable property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLatVariable() {
        return latVariable;
    }

    /**
     * Sets the value of the latVariable property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLatVariable(JAXBElement<String> value) {
        this.latVariable = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the lonVariable property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLonVariable() {
        return lonVariable;
    }

    /**
     * Sets the value of the lonVariable property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLonVariable(JAXBElement<String> value) {
        this.lonVariable = ((JAXBElement<String> ) value);
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
