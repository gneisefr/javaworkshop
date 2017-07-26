package com.pentasys.ws.java4web.web.jaxb.report;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * Report type definition.
 */
@XmlType(name = "ReportType")
@XmlEnum(String.class)
public enum ReportType {

	USER_REPORT
}
