package top.chuqin.utils.tools;

import org.junit.Test;

public class ColumnsConfigTest {

    @Test
    public void add() {
        ColumnsConfig columnsConfig = new ColumnsConfig();
        columnsConfig.add("0", "f0")
                .set(3, "3", "f3")
                .add("4", "f4")
                .set(1, "1", "f1");
        System.out.println(columnsConfig);
    }



    @Test
    public void name() {
        throw new ColumnSequenceDuplicateException(12);
    }
}