/**
 * Converting/Inverting images using ImageResource library
 * 
 * @author (Sachin Kr. Shukla) 
 * @version (v1.0)
 * @date 13 Feb 2019
 */
import edu.duke.*;
import java.io.*;
public class abc {
    public ImageResource makeInversion(ImageResource inImage){
        // Makes a blank image of same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel pixel : outImage.pixels()){
            int val = 255;
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            //int avg = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
            pixel.setRed(val - inPixel.getRed());
            pixel.setBlue(val - inPixel.getBlue());
            pixel.setGreen(val - inPixel.getGreen());
        }
        return outImage;
    }
    
    public void selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource ir = new ImageResource(f);
            ImageResource gray = makeInversion(ir);
            gray.draw();
        }
    }
    
    public void doSave(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource ir = new ImageResource(f);
            String fName = ir.getFileName(); 
            String newName = "inverted-" + fName;
            ir.setFileName(newName);
            ir.draw();
            ir.save();
        }
    }
    
    public void tester(){
        ImageResource fr = new ImageResource();
        ImageResource gray = makeInversion(fr);
        gray.draw();
        
    }
}
