package bp.gui;

import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class BPTextPanel extends JTextPane {

    /**
     * 
     */
    private static final long serialVersionUID = -4204064491415048407L;


    StyledDocument doc = getStyledDocument();
    MutableAttributeSet standard;
    MutableAttributeSet keyword;

    public BPTextPanel() {
        setEditable(false);
        initializeStyles();

        appendKeyword("process");
        appendStandard(" untitledProcess {");
        appendStandard("\n  ");
        appendStandard("\n}");
    }

    private void initializeStyles() {
        standard = new SimpleAttributeSet();
        StyleConstants.setForeground(standard, Color.BLACK);
        // StyleConstants.setFontFamily(standard, "Consolas");
        StyleConstants.setFontSize(standard, 12);

        keyword = new SimpleAttributeSet();
        StyleConstants.setForeground(keyword, Color.BLUE);
        // StyleConstants.setFontFamily(keyword, "Consolas");
        StyleConstants.setFontSize(keyword, 12);
        StyleConstants.setBold(keyword, true);
    }

    private void insertStandard(String text, Integer offset) throws BadLocationException {
        doc.insertString(offset, text, standard);
    }

    private void insertKeyword(String text, Integer offset) throws BadLocationException {
        doc.insertString(offset, text, keyword);
    }

    private void appendStandard(String text) {
        try {
            insertStandard(text, doc.getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private void appendKeyword(String text) {
        try {
            insertKeyword(text, doc.getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}
