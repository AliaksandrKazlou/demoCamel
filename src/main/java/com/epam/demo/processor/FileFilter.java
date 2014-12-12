package com.epam.demo.processor;

import org.apache.camel.Body;
import org.apache.camel.component.file.GenericFile;

/**
 * Created by Aliaksandr_Kazlou1 on 12/4/2014.
 */
public class FileFilter {

    public static final String XML_EXTENSION = ".xml";
    public static final String REGEX = ".";

    /**
     * Return true, if file extension is .xml
     *
     * @param body body of the received message of <tt>GenericFile</tt> type
     * @return true, if file extension is .xml, otherwise false
     */
    public boolean isXmlExtension(@Body GenericFile body){
        String fileName = body.getFileNameOnly();
        int delimiter_pos = fileName.lastIndexOf(REGEX);
        String extension;
        if (delimiter_pos == -1) {
            return false;
        } else {
            extension = fileName.substring(delimiter_pos);
            return extension.compareTo(XML_EXTENSION) == 0;
        }
    }
}
