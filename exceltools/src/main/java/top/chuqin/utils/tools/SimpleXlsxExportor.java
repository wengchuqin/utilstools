package top.chuqin.utils.tools;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joor.Reflect;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SimpleXlsxExportor {

    public void export(List dataList, ColumnsConfig columnsConfig, OutputStream out) throws IOException {
        List<List<String>> datas = createDatas(dataList, columnsConfig);
        try (XSSFWorkbook workBook = createWorkbook(datas)) {
            workBook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private List<List<String>> createDatas(List dataList, ColumnsConfig columnsConfig) {
        int r = dataList.size() + 1;
        int c = columnsConfig.getConfigItems().size();

        List<List<String>> strDatas = new ArrayList<>(r);

        //设置头部
        strDatas.add(getHeadStrList(columnsConfig));
        //设置数据
        for (Object object : dataList) {
            strDatas.add(getObjectData(object, columnsConfig));
        }

        return strDatas;
    }

    private List<String> getObjectData(Object object, ColumnsConfig columnsConfig) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i <= columnsConfig.getConfigItems().last().sequence; i++) {
            data.add("");
        }

        for (ConfigItem item : columnsConfig.getConfigItems()) {
            System.out.println(item.field);


            String value = Objects.toString(Reflect.on(object).get(item.field));
            data.set(item.sequence, value);
        }

        return data;
    }

    private List<String> getHeadStrList(ColumnsConfig columnsConfig) {
        List<String> header = new ArrayList<>();
        for (int i = 0; i <= columnsConfig.getConfigItems().last().sequence; i++) {
            header.add("");
        }
        for (ConfigItem item : columnsConfig.getConfigItems()) {
            header.set(item.sequence, item.label);
        }
        return header;
    }


    private XSSFWorkbook createWorkbook(List<List<String>> datas) {
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet();
        workBook.setSheetName(0, "sheet1");

        for (int i = 0; i < datas.size(); i++) {
            XSSFRow row = sheet.createRow(i);
            for (int j = 0; j < datas.get(i).size(); j++) {
                row.createCell(j).setCellValue(datas.get(i).get(j) == null ? "" : datas.get(i).get(j));
            }
        }

        return workBook;
    }


}
