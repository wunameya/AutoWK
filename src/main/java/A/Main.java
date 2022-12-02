package A;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static String find(String keyImagePath) {
        ImageFindDemo demo = new ImageFindDemo(keyImagePath);
        if(demo.result){
            return  demo.findImgData[0][0][1]+","+demo.findImgData[0][0][0];
        }
        return "";
    }
    public static void main(String[] args) throws Exception{
        System.out.println(find("C:\\Users\\wuname_1880361474123\\IdeaProjects\\BZWM\\src\\main\\resources\\p\\10.png"));
            System.out.println("如果程序出现问题，请关闭此程序和钉钉并重新启动");
            Thread.sleep(5000);
            System.out.println("钉钉半自动网课辣鸡程序启动，请打开钉钉,并最小化此窗口");
            Thread.sleep(5000);
            System.out.println("请最小化此窗口");
            Thread.sleep(5000);
            while (true){
                Thread.sleep(10000);
                String s=find("C:\\Users\\wuname_1880361474123\\IdeaProjects\\BZWM\\src\\main\\resources\\p\\8.png");
                if(!s.equals("")) {
                    log("发现开始直播，进入直播间");
                    Mouse(Integer.parseInt(s.split(",")[0]),Integer.parseInt(s.split(",")[1]));
                    Thread.sleep(3000);
                    //Mouse(119,651);
                    //Mouse(525,371);
                }
                while (!s.equals("")){
                    String s1=find("C:\\Users\\wuname_1880361474123\\IdeaProjects\\BZWM\\src\\main\\resources\\p\\9.png");
                    String s2=find("C:\\Users\\wuname_1880361474123\\IdeaProjects\\BZWM\\src\\main\\resources\\p\\10.png");
                    Thread.sleep((20000));
                    //观测直播间是否有签到
                    if(!s1.equals("")){
                        log("直播间发起签到，进行自动签到");
                        Mouse(Integer.parseInt(s1.split(",")[0]),Integer.parseInt(s1.split(",")[1]));
                    }
                    //观察是否结束
                    if(!s2.equals("")){
                        log("发现直播结束，退出直播");
                        String s3=find("C:\\Users\\wuname_1880361474123\\IdeaProjects\\BZWM\\src\\main\\resources\\p\\2.png");
                        Mouse(Integer.parseInt(s3.split(",")[0]),Integer.parseInt(s3.split(",")[1]));
                        break;
                    }
                }

            }
        }



    public static void Mouse(int x,int y) throws Exception {
        Robot robot  = new Robot();
        robot.mouseMove(x,y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(20);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
    public static String time(){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }
    public static void log(String message){
        System.out.println(time()+" "+message);
    }
}
