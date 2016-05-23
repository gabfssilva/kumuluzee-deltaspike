package com.thedevpiece.kumuluzee.deltaspike.repositories;

import com.thedevpiece.kumuluzee.deltaspike.entities.Product;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
@Repository
public interface ProductRepository extends EntityRepository<Product, Long> {
}
