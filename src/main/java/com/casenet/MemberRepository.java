// Copyright (c) 2011 by CaseNET, LLC
//
// This file is protected by Federal Copyright Law, with all rights
// reserved. No part of this file may be reproduced, stored in a
// retrieval system, translated, transcribed, or transmitted, in any
// form, or by any means manual, electric, electronic, mechanical,
// electro-magnetic, chemical, optical, or otherwise, without prior
// explicit written permission from CaseNET, LLC.
package com.casenet;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository{

    public static final String FIND_MEMBER_BY_DESC =
            "Select m From Member m Join m.diagnosis d Where d.description = :diagnosisDescription";

    @PersistenceContext
    EntityManager em;

    public List<Member> findMembersByDiagnosis(String diagnosisDescription) {
        return em.createQuery(FIND_MEMBER_BY_DESC)
                .setParameter("diagnosisDescription", diagnosisDescription)
                .getResultList();
    }

}
