package cn.sqc.runday.controller;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
public class WindowFrame extends JFrame implements Runnable{
    JLabel background;
    //进度条
    JProgressBar jdt;
    //创建一个线程并启动
    public void Start(){
        WindowFrame frame = new WindowFrame();
        Thread t = new Thread(frame);//t代表线程
        //启动线程
        t.start();
        dispose();
    }
    public WindowFrame() {
        background = new JLabel(new ImageIcon("E:/RunDay Program/web/WEB-INF/Image/loading2.bmp"));
        this.add(BorderLayout.NORTH,background);//放在窗口上面
        jdt = new JProgressBar();
        jdt.setStringPainted(true);//加载以字符串形式呈现出来。0%
        jdt.setBackground(Color.YELLOW);
        this.add(BorderLayout.SOUTH,jdt);
        //大小 478 * 360
        this.setSize(478,360);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setUndecorated(true);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new WindowFrame().Start();
    }
    @Override
    public void run() {
        //启动线程后，线程具体执行的内容
        int [] values = {0,1,3,10,23,32,40,47,55,66,76,86,89,95,99,99,99,100};
        for(int i=0; i<values.length; i++){//循环遍历赋值
            jdt.setValue(values[i]);
            //线程休眠
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }//200毫秒
        }
        dispose();
    }
}
