package inventory.errorhandling;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AppException extends Exception implements ExceptionMapper<AppException>{
	
	private static final long serialVersionUID = 1L;
	
	/** 
	 * contains redundantly the HTTP status of the response sent back to the client in case of error, so that
	 * the developer does not have to look into the response headers. If null a default 
	 */
	Integer status;
	
	/** application specific error code */
	int code; 
		
	/** link documenting request sample */	
	String link = "https://docs.google.com/document/d/14SKr2gdZZ0-Wpqvi9gEQ09z5Gv5WxOkTXcRFfliBRkw/edit?usp=sharing";
	
	/** detailed error description for developers*/
	String developerMessage;	
	
	public AppException(int status, int code, String developerMessage) {
		super();
		this.status = status;
		this.code = code;
		this.developerMessage = developerMessage;
	}

	public AppException() { }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public Response toResponse(AppException ex) {

		return Response.status(ex.code).header("Error", ex.developerMessage)
				.entity(ex.developerMessage).link(ex.link, "Refer this for a sample.")
				.type(MediaType.APPLICATION_JSON).
				build();
	}
}