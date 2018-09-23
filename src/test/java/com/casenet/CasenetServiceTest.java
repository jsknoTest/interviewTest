// Copyright (c) 2011 by CaseNET, LLC
//
// This file is protected by Federal Copyright Law, with all rights
// reserved. No part of this file may be reproduced, stored in a
// retrieval system, translated, transcribed, or transmitted, in any
// form, or by any means manual, electric, electronic, mechanical,
// electro-magnetic, chemical, optical, or otherwise, without prior
// explicit written permission from CaseNET, LLC.
package com.casenet;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class CasenetServiceTest extends BaseTest {

    @Autowired
    CasenetService casenetService;

    @Test
    public void testFindMembersByDiagnosesFromXml() {

        Set<Member> members = casenetService.findMembersByDiagnosesFromXml();

        Assert.assertTrue(members.size() == 3);

    }

}
