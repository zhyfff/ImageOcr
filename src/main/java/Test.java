import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 20:51 2019/4/29
 * @Version: $version$
 */
public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver",".\\Tools\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       //ToDo 添加你要测试的地址
        driver.get("这里写你要测试的地址，也就是有图片验证码的那个页面");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ImageOcrUtil imageOcrUtil=new ImageOcrUtil();
        imageOcrUtil.startCutOutImage();
            Thread.sleep(3000);
            try {
                imageOcrUtil.scanImage();
            }catch (Exception e){
                e.printStackTrace();
            }

       Thread.sleep(3000);
        driver.quit();
    }
}

