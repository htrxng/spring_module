package com.codgym.final_exam_api.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedicineType {
    @Id
    private String medicineTypeId;
    @UniqueElements
    private String medicineTypeName;
    Boolean flag;

    public MedicineType() {
    }

    public String getMedicineTypeId() {
        return medicineTypeId;
    }

    public void setMedicineTypeId(String medicineTypeId) {
        this.medicineTypeId = medicineTypeId;
    }

    public String getMedicineTypeName() {
        return medicineTypeName;
    }

    public void setMedicineTypeName(String medicineTypeName) {
        this.medicineTypeName = medicineTypeName;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
