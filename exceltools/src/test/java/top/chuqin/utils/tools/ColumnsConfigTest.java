package top.chuqin.utils.tools;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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


    @Test
    public void excelExport() {
        try (XSSFWorkbook workBook = new XSSFWorkbook()) {
            XSSFSheet sheet = workBook.createSheet();
            workBook.setSheetName(0, "sheet1");

            XSSFRow titleRow = sheet.createRow(0);
            for (int i = 0; i < 10; i++) {
                titleRow.createCell(i).setCellValue(String.valueOf(i));
            }

            File file = new File("/home/wengchuqin/Desktop/hello.xlsx");
            if (!file.exists()) {
                file.createNewFile();
            }
            //文件输出流
            FileOutputStream outStream = new FileOutputStream(file);
            workBook.write(outStream);
            outStream.flush();
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void createWorkbookTest() throws IOException {
        String[][] datas = new String[][]{
                {"1", "2"},
                {"3", "4"}
        };
//        XSSFWorkbook workBook = SimpleExcelUtils.createWorkbook(datas);
//        wordbookToFile(workBook, "/home/wengchuqin/Desktop/hello.xlsx");
    }


    @Test
    public void test() throws IOException {
        SimpleXlsxExportor simpleXlsxExportor = new SimpleXlsxExportor();
        List<People> datas = new ArrayList<>();
        datas.add(new People("wengchuqin", 23));
        datas.add(new People("fang", 23));

        ColumnsConfig columnsConfig = new ColumnsConfig();
        columnsConfig.add("名字", "name");
        columnsConfig.set(2, "年龄", "age");

        File file = new File("/home/wengchuqin/Desktop/hello.xlsx");
        if (!file.exists()) {
            file.createNewFile();
        }
        //文件输出流
        FileOutputStream out = new FileOutputStream(file);

        simpleXlsxExportor.export(datas, columnsConfig, out);
    }

    public void wordbookToFile(XSSFWorkbook workBook, String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        //文件输出流
        FileOutputStream outStream = new FileOutputStream(file);
        workBook.write(outStream);
        outStream.flush();
        outStream.close();
    }
}

class People {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}