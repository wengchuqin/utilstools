package top.chuqin.utils.tools.restfulapidemo.data;

import top.chuqin.utils.tools.restfulapidemo.domain.Employee;
import top.chuqin.utils.tools.restfulapidemo.domain.Org;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticData {
    public static Map<Org, List<Employee>> orgEmployeeMap = new HashMap<>();
}
