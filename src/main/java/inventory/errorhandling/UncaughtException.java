package inventory.errorhandling;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
 
@Provider
public class UncaughtException extends Throwable implements ExceptionMapper<Throwable>
{
    private static final long serialVersionUID = 1L;
  
    /** link documenting request sample */	
	String link = "https://docs.google.com/document/d/14SKr2gdZZ0-Wpqvi9gEQ09z5Gv5WxOkTXcRFfliBRkw/edit?usp=sharing";
	
    @Override
    public Response toResponse(Throwable exception)
    {
        return Response.serverError().header("Detail", exception.getMessage()).entity("Something bad happened. Please try again !!").link(this.link, "Refer this for a sample.").type("text/plain").build();
    }
}

