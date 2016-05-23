package com.thedevpiece.kumuluzee.deltaspike.api.patch;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
public class Operations {
    @Produces
    @PathOp(Operation.ADD)
    @ApplicationScoped
    public PatchOperation addPatchOperation() {
        return FieldChanger::set;
    }

    @Produces
    @PathOp(Operation.REPLACE)
    @ApplicationScoped
    public PatchOperation replacePatchOperation() {
        return FieldChanger::set;
    }

    @Produces
    @PathOp(Operation.REMOVE)
    @ApplicationScoped
    public PatchOperation removePatchOperation() {
        return (fieldChanger, proposedValue) -> fieldChanger.set(null);
    }
}
