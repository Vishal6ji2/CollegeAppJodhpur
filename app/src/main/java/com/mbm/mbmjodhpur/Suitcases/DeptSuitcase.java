package com.mbm.mbmjodhpur.Suitcases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeptSuitcase {

    @SerializedName("dept_name")
    @Expose
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
