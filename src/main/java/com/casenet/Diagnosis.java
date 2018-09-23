// Copyright (c) 2011 by CaseNET, LLC
//
// This file is protected by Federal Copyright Law, with all rights
// reserved. No part of this file may be reproduced, stored in a
// retrieval system, translated, transcribed, or transmitted, in any
// form, or by any means manual, electric, electronic, mechanical,
// electro-magnetic, chemical, optical, or otherwise, without prior
// explicit written permission from CaseNET, LLC.
package com.casenet;

import javax.persistence.*;

import com.google.common.base.Objects;

@Entity
public class Diagnosis {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "diagnosis_id")
    private Long id;

    @Column(name = "diagnosis_desc")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String description;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    public Diagnosis(final Member member, final String description) {
        this.member = member;
        this.description = description;
    }

    public Diagnosis() {
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(final Member member) {
        this.member = member;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, description);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Diagnosis other = (Diagnosis) obj;
        return Objects.equal(this.id, other.id) && Objects
                .equal(this.description, other.description);
    }
}
