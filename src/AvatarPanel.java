import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class AvatarPanel extends JPanel {
    private BufferedImage avatar;
    private String placeholderText;

    public AvatarPanel() {
        this.placeholderText = "Аватар";
        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
    }

    public void setAvatar(BufferedImage avatar) {
        this.avatar = avatar;
        repaint();
    }

    public void clearAvatar() {
        this.avatar = null;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (avatar != null) {
            int size = Math.min(getWidth(), getHeight()) - 20;
            int x = (getWidth() - size) / 2;
            int y = (getHeight() - size) / 2;
            g2d.drawImage(avatar, x, y, size, size, this);
        } else {
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillRect(10, 10, getWidth() - 20, getHeight() - 20);

            g2d.setColor(Color.DARK_GRAY);
            g2d.setFont(new Font("Arial", Font.BOLD, 16));
            FontMetrics fm = g2d.getFontMetrics();
            int textWidth = fm.stringWidth(placeholderText);
            int textHeight = fm.getHeight();
            int x = (getWidth() - textWidth) / 2;
            int y = (getHeight() + textHeight) / 2 - 5;
            g2d.drawString(placeholderText, x, y);
        }
    }
}