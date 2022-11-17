package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class Movement implements MouseListener, MouseMotionListener {

    private int X,Y;

    public Movement(Component... pns){
        for(Component panel : pns){
            panel.addMouseListener(this);
            panel.addMouseMotionListener(this);
        }
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent event) {
        X = event.getX();
        Y = event.getY();

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent event) {
        event.getComponent().setLocation((event.getX()+event.getComponent().getX())-X,(event.getY()+event.getComponent().getY())-Y);

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
