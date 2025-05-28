package com.prata.dscommerce.dto;

public class FieldMassege {
    private String fieldName;
    private String massage;

    public FieldMassege(String fieldName, String massage) {
        this.fieldName = fieldName;
        this.massage = massage;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMassage() {
        return massage;
    }
}
