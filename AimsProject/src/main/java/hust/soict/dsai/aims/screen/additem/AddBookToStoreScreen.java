package hust.soict.dsai.aims.screen.additem;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField costField;
    private JTextArea authorsArea;

    public AddBookToStoreScreen(Store store, Cart cart) {
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
        JLabel titleLabel = new JLabel("Add Book");
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
        JLabel authorsLabel = new JLabel("Authors (comma separated):");
        center.add(authorsLabel, gbc);

        gbc.gridx = 1;
        authorsArea = new JTextArea(5, 20);
        JScrollPane authorsScrollPane = new JScrollPane(authorsArea);
        center.add(authorsScrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String category = categoryField.getText();
                float cost = Float.parseFloat(costField.getText());
                String[] authorsArray = authorsArea.getText().split(",");
                List<String> authors = new ArrayList<>();
                for (String author : authorsArray) {
                    authors.add(author.trim());
                }
                Book book = new Book(store.getItemsInStore().size() + 1, title, category, cost);
                store.addMedia(book);
                JOptionPane.showMessageDialog(null, "Book added to store!");
                setVisible(false);
                dispose();
            }
        });
        center.add(addButton, gbc);

        return center;
    }
}
