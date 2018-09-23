
package videoplayer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author SELMAKA
 */
public class UpdateVideos extends JFrame implements ActionListener {

    JTextField trackNo = new JTextField(2);
    JTextField rating = new JTextField(2);
    JButton btnUpdateRating = new JButton("Update Rating");

    /**
     * The public constructor of the class
     */
    public UpdateVideos() {
        setLayout(new BorderLayout());
        setBounds(100, 100, 500, 100);
        setTitle("Update Rating");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel top = new JPanel();
        top.add(new JLabel("Enter Video Number & Rating :"));
        top.add(trackNo);
        top.add(rating);
        top.add(btnUpdateRating);


        btnUpdateRating.addActionListener(this);
        add("North", top);
        // setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnUpdateRating) {
            if (trackNo.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Enter Video Number");
            } else if (rating.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Enter Rating Number");
            } else {
                String key = trackNo.getText();
                String name = VideoData.getName(key);
                if (name == null) {
                    JOptionPane.showMessageDialog(this, "No such video number");
                } else {
                    VideoData.setRating(key, Integer.parseInt(rating.getText()));
                    JOptionPane.showMessageDialog(this, "New Rating is " + VideoData.getRating(key) + " and play count is " + VideoData.getPlayCount(key));
                    trackNo.setText("");
                    rating.setText("");

                }
            }
        }
    }

}
