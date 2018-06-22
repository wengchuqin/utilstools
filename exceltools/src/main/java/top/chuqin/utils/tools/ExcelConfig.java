package top.chuqin.utils.tools;

import java.util.List;

public class ExcelConfig {
    public static enum ExcelVersion{
        XLS,
        XLSX
    }

    public ExcelVersion version;
    public List dataList;

}
