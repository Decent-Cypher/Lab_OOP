package hust.soict.dsai.aims.screen.additem;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField costField;
    private JTextField lengthField;
    private JTextField directorField;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
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
        JLabel titleLabel = new JLabel("Add Digital Video Disc");
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
        JLabel lengthLabel = new JLabel("Length:");
        center.add(lengthLabel, gbc);

        gbc.gridx = 1;
        lengthField = new JTextField(20);
        center.add(lengthField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel directorLabel = new JLabel("Director:");
        center.add(directorLabel, gbc);

        gbc.gridx = 1;
        directorField = new JTextField(20);
        center.add(directorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String category = categoryField.getText();
                float cost = Float.parseFloat(costField.getText());
                int length = Integer.parseInt(lengthField.getText());
                String director = directorField.getText();
                DigitalVideoDisc dvd = new DigitalVideoDisc(store.getItemsInStore().size() + 1, title, category, cost, length, director);
                store.addMedia(dvd);
                JOptionPane.showMessageDialog(null, "DVD added to store!");
                setVisible(false);
                dispose();
            }
        });
        center.add(addButton, gbc);

        return center;
    }
}
