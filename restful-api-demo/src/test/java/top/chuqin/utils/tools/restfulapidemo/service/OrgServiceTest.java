package top.chuqin.utils.tools.restfulapidemo.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import top.chuqin.utils.tools.restfulapidemo.data.StaticData;
import top.chuqin.utils.tools.restfulapidemo.domain.Org;
import top.chuqin.utils.tools.restfulapidemo.exception.DuplicateOrgNameException;
import top.chuqin.utils.tools.restfulapidemo.exception.NoSuchElementException;

import java.util.HashMap;

public class OrgServiceTest {
    private OrgService orgService = new OrgService();

    @Before
    public void setUp() throws Exception {
        StaticData.orgEmployeeMap = new HashMap<>();
    }

    @Test
    public void addOrg() {
        Org org = orgService.addOrg("企业平台");
        Assert.assertEquals(org, new Org(1, "企业平台"));
        org = orgService.addOrg("企业平台2");
        Assert.assertEquals(org, new Org(2, "企业平台2"));
    }

    @Test(expected = DuplicateOrgNameException.class)
    public void addSameOrg() {
        orgService.addOrg("企业平台");
        orgService.addOrg("企业平台");
    }

    @Test
    public void updateOrg() {
        Org old = orgService.addOrg("企业平台");
        String newName = "new企业平台";
        Org newOrg = orgService.updateOrg(1, newName);
        Assert.assertEquals(newOrg.getName(), newName);
    }

    @Test(expected = NoSuchElementException.class)
    public void updateInexistentOrg() {
        Org newOrg = orgService.updateOrg(1, "");
    }

}