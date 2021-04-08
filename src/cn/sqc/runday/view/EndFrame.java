package cn.sqc.runday.view;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import  cn.sqc.runday.controller.WindowFrame;
import cn.sqc.runday.model.Person;
public class EndFrame extends JFrame implements MouseListener {
    //创建继续游戏按钮、返回主菜单按钮、退出按钮 组件
    JLabel again,back,exit;
    public EndFrame(Person person) {
        again = new JLabel(new ImageIcon("E:/RunDay Program/web/WEB-INF/Image/again.jpg"));
        again.setBounds(50, 100, 250, 60);
        again.addMouseListener(this);
        this.add(again);
        back = new JLabel(new ImageIcon("E:/RunDay Program/web/WEB-INF/Image/back.jpg"));
        back.setBounds(50, 220, 250, 60);
        back.addMouseListener(this);
        this.add(back);
        exit = new JLabel(new ImageIcon("E:/RunDay Program/web/WEB-INF/Image/exit.jpg"));
        exit.setBounds(50, 320, 250, 60);
        exit.addMouseListener(this);
        this.add(exit);
        EndPanel end = new EndPanel(person);
        this.add(end);//将结束面板组件添加到结束窗口上
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        //new EndFrame();
    }
    class EndPanel extends JPanel{
        Image background;
        Person p;
        public EndPanel(Person person) {//类比int a
            this.p = person;//创建对象、传值
            try {
                background = ImageIO.read(new File("E:/RunDay Program/web/WEB-INF/Image/finish.jpg"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        @Override
        public void paint(Graphics g) {
            // TODO Auto-generated method stub
            super.paint(g);
            g.drawImage(background, 0, 0,800,600 ,null);
            g.setColor(Color.CYAN);
            g.setFont(new Font("宋体",Font.BOLD,50));
            g.drawString(p.getScore()+"",600,45);// + ” “ 属实妙
            g.drawString(p.getDistance() + " ", 600, 402);
            g.setFont(new Font("宋体",Font.BOLD,50));
            g.setColor(Color.ORANGE);
            g.drawString(p.getTotalScore() + "", 600, 500);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(again)){
            //跳转到下一界面
            new WindowFrame().Start();
            //关闭当前界面
            dispose();
        }  else if(e.getSource().equals(back)){
            new MainFrame();
            dispose();
        }else if(e.getSource().equals(exit)){
            System.exit(0);
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
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
}
