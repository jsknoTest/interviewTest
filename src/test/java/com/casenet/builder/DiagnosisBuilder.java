package com.casenet.builder;

import com.casenet.Diagnosis;
import com.casenet.Member;

public class DiagnosisBuilder {

    private Long id;
    private String description;
    private Member member;

    public DiagnosisBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public DiagnosisBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public Diagnosis build() {
        Diagnosis diagnosis = new Diagnosis(this.member, this.description);
        diagnosis.setId(this.id);
        return diagnosis;
    }
}
