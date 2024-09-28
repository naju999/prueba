package co.edu.uptc.views.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.plaf.metal.MetalToggleButtonUI;

import co.edu.uptc.views.constants.ColorPalette;

public class JToggleButtonCustom extends JToggleButton {

  private static final int RADIUS = 35;
  private boolean isEntered = false;

  private Color backgroundSelected = Color.RED;
  public Color background = new Color(100, 100, 0);

  public JToggleButtonCustom() {
    setFocusPainted(false);
    setBorderPainted(false);
    setFocusable(false);
    background = getBackground();
    setHorizontalAlignment(SwingConstants.LEFT);
    setHideActionText(false);
    setCursor(new Cursor(Cursor.HAND_CURSOR));

    addMouseListener(new MouseAdapter() {
      public void mouseEntered(MouseEvent e) {
        isEntered = true;        
        repaint();
      }

      @Override
      public void mouseExited(MouseEvent e) {
        isEntered = false;
        repaint();
      }
    });

    setUI(
        new MetalToggleButtonUI() {
          @Override
          protected Color getSelectColor() {
            return new Color(0, 0, 0, 0);
          }
        });
  }

  public void setBackgroundSelected(Color color) {
    this.backgroundSelected = color;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (isSelected()) {
      g.setColor(backgroundSelected);
      g.fillRoundRect(0, 0, getWidth(), getHeight(), RADIUS, RADIUS);
      g.setColor(getForeground());
      g.drawString(getText(), getInsets().left, (getHeight() / 2) + 5);
    }
    if (isEntered) {
      g.setColor(ColorPalette.COLOR_ENTERED_MAIN_MENU);
      g.fillRoundRect(0, 0, getWidth(), getHeight(), RADIUS, RADIUS);
      g.setColor(getForeground());
      g.drawString(getText(), getInsets().left, (getHeight() / 2) + 5);
    }
  }
}
