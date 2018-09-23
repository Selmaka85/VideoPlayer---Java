
package videoplayer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
/**
 *
 * @author SELMAKA
 */
public class CreateVideoList extends JFrame implements ActionListener {

    JTextField trackNo = new JTextField(2);
    TextArea information = new TextArea(6, 50);
    JButton btnAddToPlayList = new JButton("Add To Play List");
    JButton btnPlay = new JButton("Play");
    JButton btnReset = new JButton("Reset");

    Vector<String> vKey = new Vector<String>();

    /**
     * The public constructor of the class
     */
    public CreateVideoList() {
        setLayout(new BorderLayout());
        setBounds(100, 100, 500, 200);
        setTitle("Create Video List");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel top = new JPanel();
        top.add(new JLabel("Enter Video Number:"));
        top.add(trackNo);
        top.add(btnAddToPlayList);
        top.add(btnPlay);
        top.add(btnReset);

        btnAddToPlayList.addActionListener(this);
        btnPlay.addActionListener(this);
        btnReset.addActionListener(this);
        add("North", top);
        JPanel middle = new JPanel();
        middle.add(information);
        add("Center", middle);

        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddToPlayList) {
            if (trackNo.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Enter Video Number");
            } else {
                String key = trackNo.getText();
                String name = VideoData.getName(key);
                if (name == null) {
                    JOptionPane.showMessageDialog(this, "No such video number");
                } else {
                    if (information.getText().length() != 0) {
                        information.setText(information.getText() + "\n" + key + " " + name + " - " + VideoData.getDirector(key));
                    } else {
                        information.setText(key + " " + name + " - " + VideoData.getDirector(key));
                    }
                    vKey.add(key);
                    trackNo.setText("");
                }
            }
        } else if (e.getSource() == btnPlay) {
            for (String s : vKey) {
                VideoData.incrementPlayCount(s);
            }
            JOptionPane.showMessageDialog(this, "Video List Play Completed");
        } else if (e.getSource() == btnReset) {

            vKey.clear();
            information.setText("");
        }

    }

    private String stars(int rating) {
        String stars = "";
        for (int i = 0; i < rating; ++i) {
            stars += "*";
        }
        return stars;
    }
}