package com.casenet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.test.context.TestPropertySource;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlParserSuccessTest extends BaseTest {

    @Autowired
    XmlParser xmlParser;

    @Autowired
    ConfigurableEnvironment env;

    @Test
    public void findDiagnosesWithSuccessTest() {
        List<String> diagnosisFromFile = xmlParser.findDiagnoses();

        Assert.assertTrue(diagnosisFromFile.size() == 3);
        Assert.assertEquals(diagnosisFromFile, Arrays.asList("color blindness", "fatness", "deafness"));
    }
}
