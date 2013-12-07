package com.googlecode.googleplus.model.moments;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include=Inclusion.NON_NULL)
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
