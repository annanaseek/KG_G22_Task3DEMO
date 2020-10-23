package ru.vsu.cs;

import ru.vsu.cs.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener, MouseListener {

    private ScreenConverter sc = new ScreenConverter(
            -2, 2, 4, 4, 800, 600);

    private Line xAxis = new Line(-1, 0, 1, 0);
    private Line yAxis = new Line(0, -1, 0, 1);

    public DrawPanel() {
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        sc.setScreenW(getWidth());
        sc.setScreenH(getHeight());
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(),
                BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();
        bi_g.setColor(Color.WHITE);
        bi_g.fillRect(0, 0, bi.getWidth(), bi.getHeight());
        bi_g.dispose();
        /**/
        PixelDrawer pd = new BufferedImagePixelDrawer(bi);
        LineDrawer ld = new DDALineDrawer(pd);
        drawAll(ld);
        /**/
        g.drawImage(bi, 0, 0, null);
    }

    private void drawAll(LineDrawer ld) {
        ld.drawLine(sc.r2s(xAxis.getP1()), sc.r2s(xAxis.getP2()));
        ld.drawLine(sc.r2s(yAxis.getP1()), sc.r2s(yAxis.getP2()));
    }

    private RealPoint prevPoint = null;

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) { // на нажатие

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) { // на момент нажатия
//        prevPoint = sc.s2r(mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) { // отжатия клавиши

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
