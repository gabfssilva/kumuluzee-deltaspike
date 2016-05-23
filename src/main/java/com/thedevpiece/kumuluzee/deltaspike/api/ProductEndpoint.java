package com.thedevpiece.kumuluzee.deltaspike.api;

import com.thedevpiece.kumuluzee.deltaspike.api.utils.OperationRequest;
import com.thedevpiece.kumuluzee.deltaspike.api.utils.PATCH;
import com.thedevpiece.kumuluzee.deltaspike.entities.base.Envelop;
import com.thedevpiece.kumuluzee.deltaspike.api.exceptions.GenericHttpException;
import com.thedevpiece.kumuluzee.deltaspike.entities.Product;
import com.thedevpiece.kumuluzee.deltaspike.repositories.ProductRepository;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static javax.ws.rs.core.Response.created;
import static javax.ws.rs.core.Response.ok;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
@Path("/products")
@Produces("application/json")
@ApplicationScoped
@Transactional
public class ProductEndpoint {
    @Inject
    private ProductRepository repository;

    @Inject
    private EntityManager entityManager;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        final Product product = repository.findBy(id);
        if (product == null) throw new GenericHttpException(404, "Resource not found");
        return ok(new Envelop().addResource(product)).build();
    }

    @GET
    public Response findAll() {
        return ok(new Envelop().addResources("products", repository.findAll()).addLink("self", "/api/products")).build();
    }

    @POST
    @Consumes("application/json")
    public Response create(Product product) throws URISyntaxException {
        final Product result = repository.saveAndFlush(product);
        return created(new URI("/api/products/" + result.getId())).build();
    }

    @PATCH
    @Path("/{id}")
    @Consumes("application/json")
    public Response update(@PathParam("id") Long id, List<OperationRequest> operations) throws URISyntaxException {
        final Product product = repository.findBy(id);
        if (product == null) throw new GenericHttpException(404, "Resource not found");

        operations.forEach(e -> {
            final String property = e.getPath().replace("/", "");

            switch (property) {
                case "description":
                    product.setDescription((String) e.getValue());
                    break;
                case "value":
                    product.setValue(new BigDecimal((Double) e.getValue()));
                    break;
            }
        });

        repository.saveAndFlush(product);
        return ok().location(new URI("/api/products/" + id)).build();
    }
}
