// Copyright (c) 2011 by CaseNET, LLC
//
// This file is protected by Federal Copyright Law, with all rights
// reserved. No part of this file may be reproduced, stored in a
// retrieval system, translated, transcribed, or transmitted, in any
// form, or by any means manual, electric, electronic, mechanical,
// electro-magnetic, chemical, optical, or otherwise, without prior
// explicit written permission from CaseNET, LLC.
package com.casenet;

import static com.casenet.exceptions.ErrorType.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.casenet.exceptions.ExceptionHandler;
import com.casenet.xmlModel.MemberXml;
import com.casenet.xmlModel.HealtCompanyXml;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@Service
public class XmlParser {

    @Value("${xml.fileName}")//("casenet.xml")
    Resource casenetXml;

    public List<String> findDiagnoses() {

        HealtCompanyXml heatlCompany = getClassFromXmlFile(HealtCompanyXml.class, getFileFromResuroce(casenetXml));
        return heatlCompany.getMembers().stream()
                    .map(MemberXml::getDiagnoses)
                    .flatMap(x -> x.stream())
                    .collect(Collectors.toList());
    }

    private File getFileFromResuroce(Resource casenetXml) {

        File file = null;
        try {
            file = casenetXml.getFile();
        } catch (IOException e) {
            ExceptionHandler.handleException(e, FILE_EXCEPTION);
        }
        return file;
    }

    private <T> T getClassFromXmlFile(Class<T> xmlClass, File file) {

        T xmlClassInstance = null;
        try {
            xmlClassInstance = xmlClass.newInstance();
            JAXBContext jaxbContext = JAXBContext.newInstance(xmlClass);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            xmlClassInstance = (T) jaxbUnmarshaller.unmarshal(file);
        } catch (IllegalAccessException|InstantiationException e) {
            ExceptionHandler.handleException(e, XML_MAPPING_CLASS.FILE_EXCEPTION);
        } catch (JAXBException e) {
            ExceptionHandler.handleException(e, PARSING_EXCEPTION);
        }
        return xmlClassInstance;
    }

}
