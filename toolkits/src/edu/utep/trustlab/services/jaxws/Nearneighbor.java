
package edu.utep.trustlab.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.5.2
 * Tue Apr 17 15:20:30 MDT 2012
 * Generated source version: 2.5.2
 */

@XmlRootElement(name = "nearneighbor", namespace = "http://services.trustlab.utep.edu/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nearneighbor", namespace = "http://services.trustlab.utep.edu/", propOrder = {"url", "I", "S", "R", "indexOfX", "indexOfY", "indexOfZ"})

public class Nearneighbor {

    @XmlElement(name = "url")
    private java.lang.String url;
    @XmlElement(name = "I")
    private java.lang.String I;
    @XmlElement(name = "S")
    private java.lang.String S;
    @XmlElement(name = "R")
    private java.lang.String R;
    @XmlElement(name = "indexOfX")
    private java.lang.String indexOfX;
    @XmlElement(name = "indexOfY")
    private java.lang.String indexOfY;
    @XmlElement(name = "indexOfZ")
    private java.lang.String indexOfZ;

    public java.lang.String getUrl() {
        return this.url;
    }

    public void setUrl(java.lang.String newUrl)  {
        this.url = newUrl;
    }

    public java.lang.String getI() {
        return this.I;
    }

    public void setI(java.lang.String newI)  {
        this.I = newI;
    }

    public java.lang.String getS() {
        return this.S;
    }

    public void setS(java.lang.String newS)  {
        this.S = newS;
    }

    public java.lang.String getR() {
        return this.R;
    }

    public void setR(java.lang.String newR)  {
        this.R = newR;
    }

    public java.lang.String getIndexOfX() {
        return this.indexOfX;
    }

    public void setIndexOfX(java.lang.String newIndexOfX)  {
        this.indexOfX = newIndexOfX;
    }

    public java.lang.String getIndexOfY() {
        return this.indexOfY;
    }

    public void setIndexOfY(java.lang.String newIndexOfY)  {
        this.indexOfY = newIndexOfY;
    }

    public java.lang.String getIndexOfZ() {
        return this.indexOfZ;
    }

    public void setIndexOfZ(java.lang.String newIndexOfZ)  {
        this.indexOfZ = newIndexOfZ;
    }

}

