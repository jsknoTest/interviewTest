package com.casenet.builder;

import com.casenet.Diagnosis;
import com.casenet.Member;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MemberBuilder {

    private Long id;
    private String name;
    private Set<Diagnosis> diagnoses = new HashSet<>();

    public MemberBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public MemberBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public MemberBuilder addDiagnosis(Diagnosis diagnosis) {
        this.diagnoses.add(diagnosis);
        return this;
    }

    public Member build() {
        Member member = new Member(this.name);
        member.setId(this.id);
        member.setDiagnosis(this.diagnoses);
        this.diagnoses.forEach(diagnosis -> diagnosis.setMember(member));
        return member;
    }
}
