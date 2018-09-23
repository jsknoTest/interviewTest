// Copyright (c) 2011 by CaseNET, LLC
//
// This file is protected by Federal Copyright Law, with all rights
// reserved. No part of this file may be reproduced, stored in a
// retrieval system, translated, transcribed, or transmitted, in any
// form, or by any means manual, electric, electronic, mechanical,
// electro-magnetic, chemical, optical, or otherwise, without prior
// explicit written permission from CaseNET, LLC.
package com.casenet;

import com.casenet.builder.DiagnosisBuilder;
import com.casenet.builder.MemberBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MemberRepositoryTest extends BaseTest {

    @Autowired
    MemberRepository memberService;

    @Test
    public void testFindMembersByDiagnosis() {

        List<Member> membersWithColorBlindness = memberService.findMembersByDiagnosis("color blindness");

        Assert.assertTrue(membersWithColorBlindness.size() == 2);
        Assert.assertEquals(membersWithColorBlindness.stream().map(Member::getName).collect(Collectors.toList()),
                Arrays.asList("Michal", "Marek"));
    }

    @Test
    public void testFindMembersByDiagnosisAddingData() {

        populateDB();

        List<Member> membersWithDiagnosisB = memberService.findMembersByDiagnosis("DiagnosisB");

        Assert.assertTrue(membersWithDiagnosisB.size() == 2);
        Assert.assertEquals(membersWithDiagnosisB.stream().map(Member::getName).collect(Collectors.toList()),
                Arrays.asList("Member1", "Member3"));
    }

    @Test
    public void testFindMembersByDiagnosisNoData() {

        List<Member> membersWithDiagnosisB = memberService.findMembersByDiagnosis("DiagnosisB");

        Assert.assertTrue(membersWithDiagnosisB.size() == 0);
    }

    private void populateDB() {

        Member member1 = new MemberBuilder().withName("Member1")
                .addDiagnosis(new DiagnosisBuilder().withDescription("DiagnosisA").build())
                .addDiagnosis(new DiagnosisBuilder().withDescription("DiagnosisB").build())
                .build();

        Member member2 = new MemberBuilder().withName("Member2")
                .addDiagnosis(new DiagnosisBuilder().withDescription("DiagnosisC").build())
                .build();

        Member member3 = new MemberBuilder().withName("Member3")
                .addDiagnosis(new DiagnosisBuilder().withDescription("DiagnosisB").build())
                .addDiagnosis(new DiagnosisBuilder().withDescription("DiagnosisD").build())
                .build();

        memberService.em.persist(member1);
        memberService.em.persist(member2);
        memberService.em.persist(member3);
    }

}
