package bp.gui;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import bp.event.TextChangeListener;
import bp.model.util.BPKeyWords;
import bp.text.box.RootTextBox;

public class BPTextPanel extends JTextPane {

    /**
     * 
     */
    private static final long serialVersionUID = -4204064491415048407L;

    private static final Pattern FORMATTING_PATTERN;

    static {
        final StringBuilder sb = new StringBuilder();
        for (final String s : BPKeyWords.getKeyWords()) {
            sb.append("\\b");
            sb.append(s);
            sb.append("\\b");
            sb.append("|");
        }
        sb.delete(sb.length() - 1, sb.length());
        final String keywordPattern = sb.toString();
        final String valuePattern = "(\\b\\d+\\b)|((\".*?\")|(\".*\n?))";
        final String lineCommentPattern = "//.*[\n]?";
        final String commentPattern = "(?s)(/\\*(.)*?\\*/)|(/\\*.*\n?)";

        sb.delete(0, sb.length());
        sb.append("(");
        sb.append(keywordPattern);
        sb.append(")");
        sb.append("|");
        sb.append("(");
        sb.append(valuePattern);
        sb.append(")");
        sb.append("|");
        sb.append("(");
        sb.append(lineCommentPattern);
        sb.append(")");
        sb.append("|");
        sb.append("(");
        sb.append(commentPattern);
        sb.append(")");

        FORMATTING_PATTERN = Pattern.compile(sb.toString());
    }

    StyledDocument doc = getStyledDocument();
    MutableAttributeSet standardStyle;
    MutableAttributeSet keywordStyle;
    MutableAttributeSet valueStyle;
    MutableAttributeSet commentStyle;

    public BPTextPanel(final RootTextBox rootTextBox) {
        initializeStyles();

        rootTextBox.addTextChangeListener(new TextChangeListener() {

            @Override
            public void textChanged(final String text) {
                setText(text);
                try {
                    BPTextPanel.this.doc.remove(0, BPTextPanel.this.doc.getLength());
                    BPTextPanel.this.doc.insertString(0, text, null);
                } catch (final BadLocationException e) {
                    e.printStackTrace();
                }
            }
        });

        this.doc.addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(final DocumentEvent e) {
                new Thread(new Formatter()).start();
            }

            @Override
            public void insertUpdate(final DocumentEvent e) {
                new Thread(new Formatter()).start();
            }

            @Override
            public void changedUpdate(final DocumentEvent e) {

            }
        });
    }

    private void initializeStyles() {
        this.standardStyle = new SimpleAttributeSet();
        StyleConstants.setForeground(this.standardStyle, Color.BLACK);
        StyleConstants.setFontFamily(this.standardStyle, "Consolas");
        StyleConstants.setFontSize(this.standardStyle, 11);

        this.keywordStyle = new SimpleAttributeSet();
        StyleConstants.setForeground(this.keywordStyle, Color.BLUE);
        StyleConstants.setFontFamily(this.keywordStyle, "Consolas");
        StyleConstants.setFontSize(this.keywordStyle, 11);
        StyleConstants.setBold(this.keywordStyle, true);

        this.valueStyle = new SimpleAttributeSet();
        StyleConstants.setForeground(this.valueStyle, new Color(178, 34, 34));
        StyleConstants.setFontFamily(this.valueStyle, "Consolas");
        StyleConstants.setFontSize(this.valueStyle, 11);

        this.commentStyle = new SimpleAttributeSet();
        StyleConstants.setForeground(this.commentStyle, new Color(34, 139, 34));
        StyleConstants.setFontFamily(this.commentStyle, "Consolas");
        StyleConstants.setFontSize(this.commentStyle, 11);
    }


    private class Formatter implements Runnable {

        private StyledDocument getDoc() {
            return BPTextPanel.this.doc;
        }

        private AttributeSet standardStyle() {
            return BPTextPanel.this.standardStyle;
        }

        private AttributeSet keywordStyle() {
            return BPTextPanel.this.keywordStyle;
        }

        private AttributeSet valueStyle() {
            return BPTextPanel.this.valueStyle;
        }

        private AttributeSet commentStyle() {
            return BPTextPanel.this.commentStyle;
        }

        @Override
        public void run() {
            formatAll();
        }

        /**
         * Formats are returns new start position
         */
        private Integer format(final Integer start, final Integer end, final Integer oldStart, final AttributeSet style) {
            getDoc().setCharacterAttributes(start, end - start, style, false);
            getDoc().setCharacterAttributes(oldStart, start - oldStart, standardStyle(), false);
            return end;
        }

        private void formatAll() {
            try {
                final Matcher m = FORMATTING_PATTERN.matcher(getDoc().getText(0, getDoc().getLength()));
                Integer start = 0;
                while (m.find()) {
                    if (m.group(8) != null) {
                        // comment
                        start = format(m.start(8), m.end(8), start, commentStyle());
                    } else if (m.group(7) != null) {
                        // line comment
                        start = format(m.start(7), m.end(7), start, commentStyle());
                    } else if (m.group(2) != null) {
                        // value
                        start = format(m.start(2), m.end(2), start, valueStyle());
                    } else if (m.group(1) != null) {
                        // keyword
                        start = format(m.start(1), m.end(1), start, keywordStyle());
                    }
                }
                getDoc().setCharacterAttributes(start, getDoc().getLength() - start, standardStyle(), false);
            } catch (final BadLocationException e) {
                e.printStackTrace();
            }
        }

    }
}
