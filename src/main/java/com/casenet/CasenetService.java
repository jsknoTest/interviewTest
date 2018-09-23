// Copyright (c) 2011 by CaseNET, LLC
//
// This file is protected by Federal Copyright Law, with all rights
// reserved. No part of this file may be reproduced, stored in a
// retrieval system, translated, transcribed, or transmitted, in any
// form, or by any means manual, electric, electronic, mechanical,
// electro-magnetic, chemical, optical, or otherwise, without prior
// explicit written permission from CaseNET, LLC.
package com.casenet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasenetService {

    @Autowired
    XmlParser xmlParser;

    @Autowired
    MemberRepository memberRepository;

    public Set<Member> findMembersByDiagnosesFromXml() {

        Set<Member> members = new HashSet<>();
        List<String> diagnoses = xmlParser.findDiagnoses();

        // Maybe an implementation of findMembersByDiagnoses would be more appropriate for performance reasons.
        for(String diagnosis : diagnoses) {
            members.addAll(memberRepository.findMembersByDiagnosis(diagnosis));
        }

        return members;
    }

}
