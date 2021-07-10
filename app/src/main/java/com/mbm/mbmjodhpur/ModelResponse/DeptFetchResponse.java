package com.mbm.mbmjodhpur.ModelResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mbm.mbmjodhpur.Suitcases.DeptSuitcase;

import java.util.List;

public class DeptFetchResponse {

    @SerializedName("deptsuitcase")
    @Expose
    private List<DeptSuitcase> deptsuitcase = null;

    public List<DeptSuitcase> getDeptsuitcase() {
        return deptsuitcase;
    }

    public void setDeptsuitcase(List<DeptSuitcase> deptsuitcase) {
        this.deptsuitcase = deptsuitcase;
    }
}
