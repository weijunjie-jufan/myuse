package com.wei.example.service.excleCheak.impl;

import com.wei.example.bean.excleBean.ExcleSheet;
import com.wei.example.service.excleCheak.IExcleService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: all_my_use
 * @Package: com.wei.example.service.excleCheak.impl
 * @Description: java类作用描述
 * @Author: 魏俊杰
 * @CreateDate: 2018/5/3 11:38
 * @UpdateUser: 魏俊杰
 * @Version: 1.0
 * Copyright: Copyright (c) 2018
 */
@Service
public class ExcleServiceImpl implements IExcleService {

    private final static Logger logger =  LoggerFactory.getLogger(ExcleServiceImpl.class);
    @Override
    public List<ExcleSheet> findAllUrl(){
        ArrayList<ExcleSheet> list = new ArrayList<>();
        XSSFWorkbook hwork = null;
        XSSFSheet sheet = null;
        //InputStream inputStream = getClass().getClassLoader().getResourceAsStream("xjfq20180503.xlsx")
        try(FileInputStream inputStream = new FileInputStream("D:\\testFile\\excleFile\\xjfq20180503.xlsx") ){
            hwork = new XSSFWorkbook(inputStream);
            sheet = hwork.getSheetAt(0);
            int rnum = sheet.getLastRowNum();
            System.out.println("当前要读取的行数为"+rnum);
            for (int i = 1;i<rnum;i++){
                XSSFRow row = sheet.getRow(i);
                ExcleSheet msgs = new ExcleSheet();
                msgs.setId(i);
                msgs.setFaceUrl(getValueByCcell(row.getCell(4)));
                msgs.setBackUrl(getValueByCcell(row.getCell(3)));
                msgs.setCardUrl(getValueByCcell(row.getCell(2)));
                msgs.setApplyNumber(getValueByCcell(row.getCell(0)));
                msgs.setOrderNumber(getValueByCcell(row.getCell(1)));
                msgs.setTotalUrl(getValueByCcell(row.getCell(5)));
                msgs.setName(getValueByCcell(row.getCell(6)));
                list.add(msgs);
            }
            hwork.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @return
     */
    public ExcleSheet findOne(int i){
        ArrayList<ExcleSheet> list = new ArrayList<>();
        XSSFWorkbook hwork = null;
        XSSFSheet sheet = null;
        //InputStream inputStream = getClass().getClassLoader().getResourceAsStream("xjfq20180503.xlsx")
        try(FileInputStream inputStream = new FileInputStream("D:\\testFile\\excleFile\\xjfq20180503.xlsx") ){
            hwork = new XSSFWorkbook(inputStream);
            sheet = hwork.getSheetAt(0);
            int rnum = sheet.getLastRowNum();
            if(i<rnum){
                XSSFRow row = sheet.getRow(i);
                ExcleSheet msgs = new ExcleSheet();
                msgs.setId(i);
                msgs.setFaceUrl(getValueByCcell(row.getCell(4)));
                msgs.setBackUrl(getValueByCcell(row.getCell(3)));
                msgs.setCardUrl(getValueByCcell(row.getCell(2)));
                msgs.setApplyNumber(getValueByCcell(row.getCell(0)));
                msgs.setOrderNumber(getValueByCcell(row.getCell(1)));
                msgs.setTotalUrl(getValueByCcell(row.getCell(5)));
                msgs.setName(getValueByCcell(row.getCell(6)));
                msgs.setHetongUrl(getValueByCcell(row.getCell(7)));
                hwork.close();
                return msgs;
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 设置统一返回格式
     * @param cell
     * @return
     */
    public String getValueByCcell(XSSFCell cell){
        Object value = null;
        if(cell != null){
            switch (cell.getCellType()){
                case Cell.CELL_TYPE_BOOLEAN:
                    value = cell.getBooleanCellValue();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    value = cell.getNumericCellValue();
                    break;
                case Cell.CELL_TYPE_BLANK:
                    value = "";
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    value = cell.getDateCellValue();
                    break;
                case Cell.CELL_TYPE_ERROR:
                    value = cell.getErrorCellValue();
                    break;
                default:
                    value = cell.getStringCellValue();
                    break;
            }
        }
        return value == null ? "" : value.toString();
    }
}
