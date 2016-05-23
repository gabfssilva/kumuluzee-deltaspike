package com.thedevpiece.kumuluzee.deltaspike.api.patch;

import javax.enterprise.util.AnnotationLiteral;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
public class PathOpLiteral extends AnnotationLiteral<PathOp> implements PathOp {
    private Operation value;

    public PathOpLiteral(Operation value) {
        this.value = value;
    }

    @Override
    public Operation value() {
        return value;
    }
}
