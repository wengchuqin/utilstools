package top.chuqin.utils.tools.restfulapidemo.web;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import top.chuqin.utils.tools.restfulapidemo.domain.Org;
import top.chuqin.utils.tools.restfulapidemo.service.OrgService;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/orgs")
@Validated
public class OrgController {

    @Autowired
    private OrgService orgService;


    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    @POST
    public Response add(@FormParam("name") @Length(min = 1, max = 10) String name) {
        System.out.println("name" + name);
        Org org = orgService.addOrg(name);
        return Response.ok(org).build();
    }



}
