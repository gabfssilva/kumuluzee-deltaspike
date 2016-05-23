package com.thedevpiece.kumuluzee.deltaspike.api.patch;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
public interface PatchOperation {
    void handle(FieldChanger fieldChanger, Object proposedValue);


}
