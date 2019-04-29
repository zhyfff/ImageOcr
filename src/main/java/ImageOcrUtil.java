import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 21:37 2019/4/29
 * @Version: $version$
 */
public class ImageOcrUtil {
    String fileFath = System.getProperty("user.dir") + "\\src\\main\\java\\testDatas\\vcode.jpg";
    public void startCutOutImage() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        Robot robot = null;
        try {
            robot = new Robot();
            // x,y是验证码左上角的坐标，坐标是从屏幕的左上角（0,0）开始的，
            // 这里的坐标需要根据自己的屏幕分辨率，来计算出验证码在屏幕上的坐标
            int x=d.width/2+20;
            int y=d.height/2+120;
            //这里传入验证的左上角的坐标和验证码的长度和宽度
            Rectangle rectangle = new Rectangle(x,y,140,40);
            BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
            ImageIO.write(bufferedImage, "jpg", new File(fileFath));
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void scanImage() throws IOException {
        ITesseract instance = new Tesseract();
        try {
            instance.setLanguage("eng");
            instance.setDatapath( System.getProperty("user.dir")+"\\tessdata");
            String result = instance.doOCR(new File(fileFath));
            System.out.println("识别的结果是："+result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
