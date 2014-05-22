package com.googlecode.googleplus.model.moments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Moment {

    private MomentType type;
    private Target target;
    private Result result;

    public MomentType getType() {
        return type;
    }
    public void setType(MomentType type) {
        this.type = type;
    }
    public Target getTarget() {
        return target;
    }
    public void setTarget(Target target) {
        this.target = target;
    }
    public Result getResult() {
        return result;
    }
    public void setResult(Result result) {
        this.result = result;
    }
}
