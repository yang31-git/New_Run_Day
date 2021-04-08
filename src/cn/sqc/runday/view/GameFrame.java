package cn.sqc.runday.view;
import javax.swing.JFrame;
import cn.sqc.runday.controller.GamePanel;
public class GameFrame extends JFrame {
    //设置窗体宽高属性
    public static final int WIDTH=800;
    public static final int HEIGHT=700;
    public GameFrame() {
        //2.4创建游戏面板对象，并添加到窗体上去
        GamePanel panel = new GamePanel();
        panel.action();//程序启动的方法
        this.addKeyListener(panel);//谁实现就监听谁
        this.add(panel);
        /**1.设置窗体基本属性*/
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new GameFrame();
    }
}
