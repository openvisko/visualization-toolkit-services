
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

@XmlRootElement(name = "esriGridContourResponse", namespace = "http://services.trustlab.utep.edu/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "esriGridContourResponse", namespace = "http://services.trustlab.utep.edu/")

public class EsriGridContourResponse {

    @XmlElement(name = "return")
    private java.lang.String _return;

    public java.lang.String getReturn() {
        return this._return;
    }

    public void setReturn(java.lang.String new_return)  {
        this._return = new_return;
    }

}

