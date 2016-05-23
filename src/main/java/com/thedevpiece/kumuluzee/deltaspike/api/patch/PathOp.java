package com.thedevpiece.kumuluzee.deltaspike.api.patch;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@ApplicationScoped
public @interface PathOp {
    Operation value();
}
