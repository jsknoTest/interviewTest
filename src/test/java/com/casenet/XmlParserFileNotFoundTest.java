package com.casenet;


import com.casenet.exceptions.CasenetException;
import com.casenet.exceptions.ErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.Assert;
import org.testng.annotations.Test;

@TestPropertySource("classpath:testForFileNotFound.properties")
public class XmlParserFileNotFoundTest extends BaseTest {

    @Autowired
    XmlParser xmlParser;

    @Test(expectedExceptions = CasenetException.class)
    public void findDiagnosesWithFileNotFoundTest() {

        xmlParser.findDiagnoses();
    }

    @Test()
    public void findDiagnosesWithFileNotFoundCheckingErrorTypeTest() {

        CasenetException businessException = null;
        try {
            xmlParser.findDiagnoses();
        } catch(Exception e) {
            businessException = (CasenetException) e;
        }

        Assert.assertEquals(businessException.getCode(), ErrorType.FILE_EXCEPTION);


    }
}
