package top.chuqin.utils.tools.restfulapidemo.web;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.chuqin.utils.tools.restfulapidemo.domain.Org;
import top.chuqin.utils.tools.restfulapidemo.service.OrgService;

import javax.validation.constraints.NotNull;


@Validated
@RestController
@RequestMapping(value = "/orgs")
public class OrgController {

    @Autowired
    private OrgService orgService;

    @RequestMapping("/")
    @ApiOperation(value = "创建org", httpMethod= "POST", consumes = "application/x-www-form-urlencoded")
    @ApiParam(name = "name", value = "org的名字", required = true)
    public Org addOrgByName(@NotNull @Length(min = 1, max = 10) String name){
        Org org = orgService.addOrg(name);
        return org;
    }
}
