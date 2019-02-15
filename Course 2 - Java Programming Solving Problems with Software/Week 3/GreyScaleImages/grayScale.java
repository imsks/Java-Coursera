/**
 * Converting/Inverting images using ImageResource library
 * 
 * @author (Sachin Kr. Shukla) 
 * @version (v1.0)
 * @date 13 Feb 2019
 */
import edu.duke.*;
import java.io.File;
public class grayScale{
    // Gray scale images
    public ImageResource makeGray(ImageResource inImage){
        // Makes a blank image of same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int avg = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
            pixel.setRed(avg);
            pixel.setBlue(avg);
            pixel.setGreen(avg);
        }
        return outImage;
    }
    
    public void selectManyFiles(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource ir = new ImageResource(f);
            ImageResource gray = makeGray(ir);
            gray.draw();
        }
    }
    
    public void doSave(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource ir = new ImageResource(f);
            String fName = ir.getFileName(); 
            String newName = "gray-" + fName;
            ir.setFileName(newName);
            ir.draw();
            ir.save();
        }
    }
    
    public void testerGrayScale(){
        ImageResource fr = new ImageResource();
        ImageResource gray = makeGray(fr);
        gray.draw();
    }
}
