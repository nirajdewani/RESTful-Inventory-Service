package inventory.services.rest;

import java.net.URI;
 
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
 
import inventory.entities.Product;
import inventory.errorhandling.*;
 
@Path("/product")
@Produces ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Stateless
public class ProductRestService {

    @PersistenceContext(unitName = "testPU")
    private EntityManager em;
 
    @Context
    private UriInfo uriInfo;
 
    @GET
    @Path("/getProductCountByStoreNumber")
    @Produces(MediaType.TEXT_PLAIN)
    public int getProductCountByStoreNumber(@QueryParam("sku") Integer sku, @QueryParam("storeNumber") Integer storeNumber) throws AppException{
    	if (sku == null){
    		throw new AppException(Response.Status.BAD_REQUEST.getStatusCode(), 400, "Expecting a value for SKU of the product.");
    	}
    	
    	if (storeNumber == null){
    		throw new AppException(Response.Status.BAD_REQUEST.getStatusCode(), 400, "Expecting a value for storeNumber.");
    	}
    	
    	Query query = em.createNamedQuery("Product.findProductCountByStoreNumber");
    	query.setParameter("sku", sku);
    	query.setParameter("storeNumber", storeNumber);
    	
        return (int) query.getSingleResult();
    }
    
    @PUT
    @Path("/updateCountForStore")
    public Response updateCountForStore(@QueryParam("sku") Integer sku, @QueryParam("storeNumber") Integer storeNumber, @QueryParam("productCount") Integer productCount) throws AppException{
    	if (sku == null){
    		throw new AppException(Response.Status.BAD_REQUEST.getStatusCode(), 400, "Expecting a value for SKU of the product.");
    	}
    	
    	if (storeNumber == null){
    		throw new AppException(Response.Status.BAD_REQUEST.getStatusCode(), 400, "Expecting a value for storeNumber.");
    	}
    	
    	if (productCount == null){
    		throw new AppException(Response.Status.BAD_REQUEST.getStatusCode(), 400, "Expecting a value for productCount.");
    	}
    	
    	Query query = em.createNamedQuery("Product.updateCountForStore");
    	query.setParameter("sku", sku);
    	query.setParameter("storeNumber", storeNumber);
    	query.setParameter("productCount", productCount);
    	query.executeUpdate();
    	
    	return Response.noContent().build();
    } 
    
    @POST
    public Response createProduct(Product product) {   	
    	if(product == null){
            throw new BadRequestException();
        }
        em.persist(product); 
        URI productUri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(product.getSku())).build();

        return Response.created(productUri).build();
    }
}