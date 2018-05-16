package com.wei.example.util.erweima;

import com.google.zxing.LuminanceSource;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.stream.Stream;

/**
 * @ProjectName: all_my_use
 * @Package: com.wei.example.util.erweima
 * @Description: java类作用描述
 * @Author: 魏俊杰
 * @CreateDate: 2018/5/16 17:07
 * @UpdateUser: 魏俊杰
 * @Version: 1.0
 * Copyright: Copyright (c) 2018
 */
public class MatrixToImageWriter {

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    private MatrixToImageWriter(){}

    /**
     *
     * @param matrix
     * @return
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix){
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for(int x = 0;x<width;x++){
            for(int y = 0;y<height;y++){
                image.setRGB(x,y,matrix.get(x,y)?BLACK:WHITE);
            }
        }
        return image;
    }

    /**
     *
     * @param matrix
     * @param format
     * @param stream
     * @throws IOException
     */
    public static void writeToFile(BitMatrix matrix, String format, File stream)throws IOException{
        BufferedImage image = toBufferedImage(matrix);
        if(!ImageIO.write(image,format, stream)){
            throw new IOException("Could not write an image of format"+format);
        }
    }
}
