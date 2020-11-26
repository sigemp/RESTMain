
import com.sigemp.gestion.client.online.filter.PrintOut;
import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Server
 */
public class test1 {

    @Test
    public void getTest() throws Exception {
        try {
            WebTarget target = tt();
            Response res = target
                    .path("gsyuser")
                    //.path("1")
                    .request()
                    .accept(MediaType.APPLICATION_JSON)
                    .get();

            if (res.getStatus() != Response.Status.NO_CONTENT.getStatusCode()) {
                //String str = analize(res, "creando :");
                //throw new Exception(str);
            }
            System.out.println("===================");
            String output = res.readEntity(String.class);
            System.out.println(res);
            System.out.println(output);
            System.out.println("===================");
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public WebTarget tt() {
        ClientConfig config = new ClientConfig()
                .register(new PrintOut());

        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(getBaseURI());
        return target;
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/RESTGestionServer/api").build();
    }
}
