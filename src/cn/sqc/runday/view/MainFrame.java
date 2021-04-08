package cn.sqc.runday.view;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import cn.sqc.runday.controller.WindowFrame;
public class MainFrame extends JFrame implements MouseListener {
    //设置窗体的基本属性  大小
    /**
     1.创建背景面板MainPanel，实现背景图片功能
     2.图片按钮功能
     */
    //2.1创建开始按钮 帮助按钮 离开按钮 组件
    JLabel start,help,exit;
    JPanel MainPanel;
    public MainFrame() {//无参构造，创建对象。并在main函数中调用
        //2.2
        start = new JLabel(new ImageIcon("E:/RunDay Program/web/WEB-INF/Image/start.jpg"));//ImageIcon:图标
        start.setBounds(220,120,250,60);
        start.setEnabled(false);//false按钮为灰色
        start.addMouseListener(this);
        this.add(start);
        help = new JLabel(new ImageIcon("E:/RunDay Program/web/WEB-INF/Image/help.jpg"));
        help.setBounds(220,250,250,60);
        help.setEnabled(false);
        help.addMouseListener(this);
        this.add(help);
        exit = new JLabel(new ImageIcon("E:/RunDay Program/web/WEB-INF/Image/exit.jpg"));
        exit.setBounds(220, 380, 250, 60);
        exit.setEnabled(false);
        exit.addMouseListener(this);
        this.add(exit);

        /**1.实现背景图片及窗体属性*/
        MainPanel panel = new MainPanel();
        this.add(panel);
        //设置窗体基本属性大小 居中 边框隐藏 默认关闭按钮 logo图标
        this.setSize(1000,600);//大小
        this.setLocationRelativeTo(null);//居中
        this.setUndecorated(true);//边框隐藏
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认关闭
        //this.setIconImage(new ImageIcon("Image/115.png").getImage());//logo
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }

    //2、创建背景面板MainPanel，实现背景图片功能
    class MainPanel extends JPanel{//创建的MainPanel类，在MainFrame中调用
        Image background;
        public MainPanel() {
            try {
                background = ImageIO.read(new File("E:/RunDay Program/web/WEB-INF/Image/main.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(background, 0, 0,1200,730, null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //鼠标点击
        if(e.getSource().equals(start)){
            //跳转到下一界面
            new WindowFrame().Start();
            //关闭当前界面
            dispose();
        }else if(e.getSource().equals(exit)){
            dispose();
        }else if(e.getSource().equals(help)){
            JOptionPane.showMessageDialog(null, "有疑问请联系开发者：yang");
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // 鼠标移入
        if(e.getSource().equals(start)){//e指一个事件。e.getSource()获取事件
            //如果鼠标移入到（start）组件（图片按钮）
            start.setEnabled(true);
        }else if(e.getSource().equals(help)){
            help.setEnabled(true);
        }else if(e.getSource().equals(exit)){
            exit.setEnabled(true);
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        //鼠标移出
        if(e.getSource().equals(start)){
            start.setEnabled(false);
        }else if(e.getSource().equals(help)){
            help.setEnabled(false);
        }else if(e.getSource().equals(exit)){
            exit.setEnabled(false);
        }
    }
}
