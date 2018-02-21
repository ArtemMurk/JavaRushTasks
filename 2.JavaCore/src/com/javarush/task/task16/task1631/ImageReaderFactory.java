package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

import java.lang.reflect.Type;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes type){

            if (type == ImageTypes.JPG) return new JpgReader();
            if (type == ImageTypes.BMP) return new BmpReader();
            if (type == ImageTypes.PNG) return new PngReader();
            else throw  new IllegalArgumentException("Неизвестный тип картинки");



    }
}
