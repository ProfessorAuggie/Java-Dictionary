import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import java.io.IOException;
import java.net.URISyntaxException;

public class Dictionary {
    private String[] keywords = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
            "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
            "for", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package",
            "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized",
            "this", "throw", "throws", "transient", "try", "void", "volatile", "while"};

    private String[] meanings = {
            "A non-access modifier used for classes and methods.",
            "Enables assertion, a debugging aid that tests a boolean expression.",
            "A data type representing true or false values.",
            "Used to exit from a loop or switch statement.",
            "A data type representing 8-bit signed integers.",
            "Used in switch statements to define different cases.",
            "Catches exceptions generated during program execution.",
            "A data type representing a single 16-bit Unicode character.",
            "Defines a class in Java.",
            "Not used in Java. Reserved for future use.",
            "Skips the rest of a loop's code and continues with the next iteration.",
            "Specifies the default case in a switch statement.",
            "Starts a do-while loop.",
            "A data type representing 64-bit double-precision floating-point.",
            "Specifies the code to execute if the condition in an if statement is false.",
            "Introduced in Java 5.0, defines a fixed set of constants.",
            "Indicates that a class is derived from another class or interface.",
            "A modifier applicable to classes, methods, and variables. Indicates that something cannot be changed.",
            "A block of code that is executed after a try block completes, regardless of whether an exception is thrown.",
            "A data type representing 32-bit single-precision floating-point.",
            "Used to create a for loop.",
            "Used to create an if statement.",
            "Indicates that a class implements an interface.",
            "Used to include a package or class in the program.",
            "Tests whether an object is an instance of a particular class or interface.",
            "A data type representing 32-bit signed integers.",
            "Defines a contract for a class to implement.",
            "A data type representing 64-bit signed integers.",
            "Indicates that a method is implemented in a non-Java programming language.",
            "Creates a new instance of a class or array.",
            "Declares a Java package.",
            "Indicates that something is accessible only within its own class.",
            "Indicates that something is accessible within its own package and by subclasses.",
            "Indicates that something is accessible from any other class.",
            "Used to finish the execution of a method and return a value.",
            "A data type representing 16-bit signed integers.",
            "Indicates that something belongs to the class rather than an instance of the class.",
            "Ensures that floating-point calculations follow the IEEE 754 standard.",
            "Refers to the immediate parent class object.",
            "Evaluates an expression and executes code based on matching cases.",
            "Ensures that only one thread executes the synchronized code at a time.",
            "Refers to the current object.",
            "Throws an exception.",
            "Indicates that a method may throw one or more exceptions.",
            "Indicates that a variable should not be serialized.",
            "Encloses a block of code that might throw an exception.",
            "A data type representing the lack of any type.",
            "Indicates that a variable may be changed by multiple threads.",
            "Used to create a while loop."
    };

    public Dictionary() {
        Frame f = new Frame("Java Dictionary");
        Label titleLabel = new Label("JAVA DICTIONARY");
        Label subTitleLabel = new Label("Welcome to Java Dictionary!");
        Label instructionLabel = new Label("This is a sample dictionary. Try searching these keywords:");
        Panel p = new Panel();
        TextField text = new TextField(60);
        Font titleFont = new Font("Verdana", Font.BOLD, 32);
        Font subTitleFont = new Font("Arial", Font.ITALIC, 18);
        Font instructionFont = new Font("Arial", Font.PLAIN, 16);
        Color titleColor = new Color(255, 69, 0); // Red-Orange
        Color subTitleColor = new Color(0, 128, 128); // Teal
        Button searchButton = new Button("Search");
        Button creators = new Button("Creators");
        Button[] keywordButtons = new Button[keywords.length];
        Font buttonFont = new Font("Calibri", Font.PLAIN, 16);
        Color buttonColor = new Color(0, 191, 255); // Deep Sky Blue
        Color hoverColor = new Color(135, 206, 250); // Light Sky Blue
        Color backgroundColor = new Color(255, 255, 240); // Ivory

        titleLabel.setPreferredSize(new Dimension(700, 30));
        subTitleLabel.setPreferredSize(new Dimension(700, 30));

        titleLabel.setFont(titleFont);
        titleLabel.setForeground(titleColor);

        subTitleLabel.setFont(subTitleFont);
        subTitleLabel.setForeground(subTitleColor);

        instructionLabel.setFont(instructionFont);

        p.add(titleLabel);
        p.add(subTitleLabel);
        p.add(instructionLabel);
        p.add(text);
        p.add(searchButton);
        p.add(creators);

        p.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 12));

        for (int i = 0; i < keywords.length; i++) {
            keywordButtons[i] = new Button((i + 1) + ". " + keywords[i]);
            keywordButtons[i].setPreferredSize(new Dimension(420, 25));
            keywordButtons[i].setFont(buttonFont);
            keywordButtons[i].setBackground(buttonColor);

            keywordButtons[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    ((Button) e.getSource()).setBackground(hoverColor);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    ((Button) e.getSource()).setBackground(buttonColor);
                }
            });

            keywordButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String buttonText = ((Button) e.getSource()).getLabel();
                    String[] parts = buttonText.split("\\. ");
                    if (parts.length == 2) {
                        String keyword = parts[1];
                        displayMeaning(keyword);
                    } else {
                        System.out.println("Error extracting keyword");
                    }
                }
            });
            p.add(keywordButtons[i]);
        }

        f.setLocation(350, 150);
        f.setBackground(backgroundColor);
        f.add(p);

        f.setSize(700, 400);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                searchButton.setBackground(new Color(0, 0, 0));
                searchButton.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                searchButton.setBackground(new Color(255, 255, 255));
                searchButton.setForeground(new Color(0, 0, 0));
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchKeyword = text.getText().trim().toLowerCase();
                for (int i = 0; i < keywords.length; i++) {
                    if (searchKeyword.equals(keywords[i])) {
                        displayMeaning(keywords[i]);
                        return;
                    }
                }
                System.out.println("Keyword not found");
            }
        });

        creators.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                creators.setBackground(new Color(0, 0, 0));
                creators.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                creators.setBackground(new Color(255, 255, 255));
                creators.setForeground(new Color(0, 0, 0));
            }
        });

        creators.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCreatedByLabels();
            }
        });
    }

    private void displayMeaning(String keyword) {
        Frame meaningFrame = new Frame("Keyword Meaning");
        Label keywordLabel = new Label("Keyword: " + keyword);
        Label meaningLabel = new Label();

        for (int i = 0; i < keywords.length; i++) {
            if (keyword.equals(keywords[i])) {
                meaningLabel.setText("Meaning: " + meanings[i]);
                break;
            }
        }
        keywordLabel.setForeground(new Color(255, 0, 0));
        meaningLabel.setForeground(new Color(0, 128, 128));
        Font f = new Font("Calibri", Font.BOLD, 13);
        keywordLabel.setFont(f);
        meaningLabel.setFont(f);

        Panel meaningPanel = new Panel();
        meaningPanel.add(keywordLabel);
        meaningPanel.add(meaningLabel);

        meaningFrame.add(meaningPanel);
        meaningFrame.setSize(500, 150);
        meaningFrame.setLocation(400, 200);
        meaningFrame.setVisible(true);

        meaningFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                meaningFrame.dispose();
            }
        });

    }

    private void addCreatedByLabels() {
        Frame createdByFrame = new Frame("Created by");

        Label person1Label = createClickableLabel("Vaibhav Kushwaha", "https://www.linkedin.com/in/professorauggie");
        Font b = new Font("Calibri", Font.BOLD, 16);
        Panel createdByPanel = new Panel();
        createdByPanel.setLayout(new GridLayout(4, 1, 0, 2));
        person1Label.setFont(b);
        createdByPanel.add(person1Label);

        createdByFrame.add(createdByPanel);
        createdByFrame.setSize(300, 200);
        createdByFrame.setLocation(500, 200);
        createdByFrame.setVisible(true);

        createdByFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                createdByFrame.dispose();
            }
        });
    }

    private Label createClickableLabel(String name, String linkedInURL) {
        Label label = new Label(name);
        label.setForeground(new Color(0, 0, 255)); // Blue color for link
        Font font = new Font("Calibri", Font.PLAIN, 14);
        label.setFont(font);

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openLinkedInProfile(linkedInURL);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        return label;
    }

    private void openLinkedInProfile(String linkedInURL) {
        if (!linkedInURL.isEmpty()) {
            try {
                Desktop.getDesktop().browse(new URI(linkedInURL));
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Dictionary();
    }
}
