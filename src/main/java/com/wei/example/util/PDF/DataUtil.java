package com.wei.example.util.PDF;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description: 分割路径返回分割后的路径
 * @Author: 魏俊杰
 * @CreateDate: 2018/5/9 15:26
 * @UpdateUser: 魏俊杰
 * @Version: 1.0
 */
public class DataUtil {
    public static String[] separatePath(String path){
        if(StringUtils.isBlank(path)){
            return null;
        }else{
            String[] seq = path.split("\\.");
            return new String[]{seq[0],seq[1]};
        }
    }
}
