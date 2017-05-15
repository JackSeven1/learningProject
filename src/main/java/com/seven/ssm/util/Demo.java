package com.seven.ssm.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.awt.geom.Rectangle2D.Float;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

public class Demo {
    private static String KEY_WORD = "票";
    private static int i = 0;
    static List<float[]> arrays = new ArrayList<float[]>();
    static String sb ;
    private static List<float[]> getKeyWords(String filePath) {
        try {
            PdfReader pdfReader = new PdfReader(filePath);
            int pageNum = pdfReader.getNumberOfPages();
            PdfReaderContentParser pdfReaderContentParser = new PdfReaderContentParser(
                    pdfReader);
            for (i = 1; i < 2; i++) {
                pdfReaderContentParser.processContent(i, new RenderListener() {
                    @Override
                    public void renderText(TextRenderInfo textRenderInfo) {
                        String text = textRenderInfo.getText(); // 整页内容

                        if (null != text && text.contains(KEY_WORD)) {
                            Float boundingRectange = textRenderInfo
                                    .getBaseline().getBoundingRectange();
                            sb = boundingRectange.x+"--"+boundingRectange.y+"---";

                            float[] resu = new float[3];
                            resu[0] = boundingRectange.x;
                            resu[1] = boundingRectange.y;
                            resu[2] = i;
                            arrays.add(resu);
                        }
                    }

                    @Override
                    public void renderImage(ImageRenderInfo arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void endTextBlock() {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void beginTextBlock() {
                        // TODO Auto-generated method stub

                    }
                });
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return arrays;
    }

    public static void main(String[] args) {

        List<float[]> ff = getKeyWords("d:\\a.pdf");
        for(float[] f : ff){
            System.out.println(f[0]+"----"+f[1]+"-----"+f[2]);
        }
        System.out.println(sb);

    }

}