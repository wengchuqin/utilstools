package top.chuqin.utils.tools.json;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class JsonTest {

    /**
     * 父类的属性也能打印出来
     * 属性值为null的,没有打印出来
     * 属性值为""的,打印出来也是""
     * <p>
     * {"categoryCode":"categoryCode","categoryName":"","id":1,"updateTime":1524814268799}
     */
    @Test
    public void objectToJSONString() {
        CommonDictPo po = new CommonDictPo();
        po.setCategoryCode("categoryCode");
        po.setCategoryName("");
        po.setDeleted(null);
        po.setUpdateTime(System.currentTimeMillis());
        po.setId(1L);

        System.out.println(JSON.toJSONString(po));
    }

    @Test
    public void parseObject() {
        String jsonStr = "{'categoryCode':'categoryCode','categoryName':'','id':1,'updateTime':1524814268799}";
        CommonDictPo po = JSON.parseObject(jsonStr, CommonDictPo.class);
        System.out.println(po);
    }


    /**
     * [{"categoryCode":"categoryCode","categoryName":"","id":1,"updateTime":1524814704045}]
     */
    @Test
    public void arrayToJSONString() {
        CommonDictPo po = new CommonDictPo();
        po.setCategoryCode("categoryCode");
        po.setCategoryName("");
        po.setDeleted(null);
        po.setUpdateTime(System.currentTimeMillis());
        po.setId(1L);

        System.out.println(JSON.toJSONString(Arrays.asList(po)));
    }

    @Test
    public void parseArray() {
        String jsonStr = "[{'categoryCode':'categoryCode','categoryName':'','id':1,'updateTime':1524814268799}]";
        List<CommonDictPo> poList = JSON.parseArray(jsonStr, CommonDictPo.class);
        System.out.println(poList);
    }
}
