package com.seven.ssm.util;

import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;

import static com.itextpdf.text.pdf.PdfContentByte.ALIGN_CENTER;

/**
 * Created by douqi on 2017/5/8.
 */
public class texttwo {

    public static void main(String[] args)throws Exception {
        PdfReader pdfReader = new PdfReader("D:\\a.pdf");
        System.out.println( pdfReader.isTampered() );

        PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("D:\\b.pdf"));
        PdfContentByte over = pdfStamper.getOverContent(1);
        int x = 200;
        int y = 200;
        int roation = 45 ;
        String content ="全国统一发票专用章";
        //增加文本
         over.beginText();
         over.setFontAndSize(BaseFont.createFont("C:/WINDOWS/Fonts/STKAITI.TTF",BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 7);
        over.setTextMatrix(200, 200);
        over.showTextAligned(Element.ALIGN_LEFT,"票",315.88f,366.08f,-10);
        over.showTextAligned(Element.ALIGN_LEFT,"国",288.75f,357.12f,50);
//         for (int i =1; i<=content.length();i++){
//             x= x + 6;
//             if (i>5){
//                 y = y - 5;
//                 roation = roation + 11;
//                 over.setTextMatrix(200, 100);
//                 over.showTextAligned(Element.ALIGN_LEFT,"你",x,y,roation);
//                 System.out.println("x:"+x+"y:"+y);
//             }else {
//                 y = y + 5;
//                 roation =roation - 11;
//                 over.setTextMatrix(200, 100);
//                 over.showTextAligned(Element.ALIGN_RIGHT,"你",x,y,roation);
//                 if (i==5){
//                     roation = -45;
//                 }
//                 System.out.println("x:"+x+"y:"+y);
//             }



//         }
       //  over.showText("page1");
         over.endText();

        //增加图形
       /* Image img = Image.getInstance("D:\\PDF\\chart.png");//选择图片
        img.setAlignment(1);
        img.scaleAbsolute(100,100);//控制图片大小
        img.setAbsolutePosition(0,200);//控制图片位置
        over.addImage(img);*/
        //over.setRGBColorStrokeF(254, 254, 254);
        //over.setLineWidth(5);
        //over.ellipse(250, 450, 350, 550);
        //over.stroke();

        pdfStamper.close();

        System.out.println( pdfReader.isTampered() );
    }
}
