package top.chuqin.utils.tools.restfulapidemo.service;

import org.apache.commons.lang3.mutable.MutableInt;
import org.springframework.stereotype.Service;
import top.chuqin.utils.tools.restfulapidemo.data.StaticData;
import top.chuqin.utils.tools.restfulapidemo.domain.Employee;
import top.chuqin.utils.tools.restfulapidemo.domain.Org;
import top.chuqin.utils.tools.restfulapidemo.enumeration.ResourceEnum;
import top.chuqin.utils.tools.restfulapidemo.exception.DuplicateOrgNameException;
import top.chuqin.utils.tools.restfulapidemo.exception.NoSuchElementException;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Service
public class OrgService {


    /**
     * @param name
     * @return
     */
    public Org addOrg(String name) {
        final MutableInt maxId = new MutableInt(0);
        StaticData.orgEmployeeMap.keySet().stream().forEach(org -> {
            if (org.getName().equals(name)) {
                throw new DuplicateOrgNameException(name);
            }

            if (org.getId() > maxId.getValue()) {
                maxId.setValue(org.getId());
            }
        });


        int newId = maxId.getValue() + 1;
        Org org = new Org(newId, name);
        StaticData.orgEmployeeMap.put(org, new ArrayList<>());

        return org;
    }

    public Org updateOrg(Integer id, String name) {
        Org org = StaticData.orgEmployeeMap.keySet().stream().filter(o -> o.getId().equals(id))
                .findAny().orElseThrow(() -> new NoSuchElementException(ResourceEnum.ORGS.getName(), id));

        org.setName(name);
        return org;
    }


}
