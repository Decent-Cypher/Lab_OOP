package hust.soict.dsai.aims.screen.additem;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField costField;
    private JTextField artistField;
    private JTextField directorField;
    private JTextArea trackInfoArea;

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
    }

    @Override
    JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem backItem = new JMenuItem("Back");
        backItem.addActionListener(e -> {
            setVisible(false);
            dispose();
        });
        menu.add(backItem);
        menuBar.add(menu);
        return menuBar;
    }

    @Override
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel("Add Compact Disc");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        header.add(titleLabel, BorderLayout.CENTER);
        return header;
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel titleLabel = new JLabel("Title:");
        center.add(titleLabel, gbc);

        gbc.gridx = 1;
        titleField = new JTextField(20);
        center.add(titleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel categoryLabel = new JLabel("Category:");
        center.add(categoryLabel, gbc);

        gbc.gridx = 1;
        categoryField = new JTextField(20);
        center.add(categoryField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel costLabel = new JLabel("Cost:");
        center.add(costLabel, gbc);

        gbc.gridx = 1;
        costField = new JTextField(20);
        center.add(costField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel artistLabel = new JLabel("Artist:");
        center.add(artistLabel, gbc);

        gbc.gridx = 1;
        artistField = new JTextField(20);
        center.add(artistField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel directorLabel = new JLabel("Director:");
        center.add(directorLabel, gbc);

        gbc.gridx = 1;
        directorField = new JTextField(20);
        center.add(directorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel trackInfoLabel = new JLabel("Track Information (title-length):");
        center.add(trackInfoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        trackInfoArea = new JTextArea(5, 20);
        JScrollPane trackInfoScrollPane = new JScrollPane(trackInfoArea);
        center.add(trackInfoScrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton addButton = new JButton("Add Compact Disc");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String category = categoryField.getText();
                float cost = Float.parseFloat(costField.getText());
                String artist = artistField.getText();
                String director = directorField.getText();
                String trackInfoText = trackInfoArea.getText();
                String[] tracksArray = trackInfoText.split("\n");
                List<Track> tracks = new ArrayList<>();
                for (String trackInfo : tracksArray) {
                    String[] trackParts = trackInfo.split("-");
                    if (trackParts.length == 2) {
                        String trackTitle = trackParts[0].trim();
                        int trackLength = Integer.parseInt(trackParts[1].trim());
                        Track track = new Track(trackTitle, trackLength);
                        tracks.add(track);
                    }
                }
                CompactDisc cd = new CompactDisc(store.getItemsInStore().size() + 1, title, category, cost, 0, artist, director);
                for (Track track : tracks) {
                    cd.addTrack(track);
                }
                store.addMedia(cd);
                JOptionPane.showMessageDialog(null, "Compact Disc added to store!");
                setVisible(false);
                dispose();
            }
        });
        center.add(addButton, gbc);

        return center;
    }
}
