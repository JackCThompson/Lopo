package com.weebly.jackthompsonjava.game2.input;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.weebly.jackthompsonjava.game2.Handler;

public class MouseHandler implements MouseListener, MouseMotionListener{
	
	private Handler handler;
	
	private Point p;
	
	public MouseHandler(Handler handler) {
		this.handler = handler;
		
		p = new Point(1, 1);
	}
	public void mouseDragged(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {
		updatePoint(e);
	}

	public void mouseClicked(MouseEvent e) {
		handler.getGame().mouseClicked(p);
	}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	private void updatePoint(MouseEvent e) {
		p = e.getPoint();
	}
	
	public Point getPoint() {
		return p;
	}
}
