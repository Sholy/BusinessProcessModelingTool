package bp.text;

import java.awt.Color;
import java.awt.Font;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

public class StandardStyle implements StyledDocument {

    @Override
    public void addDocumentListener(DocumentListener arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addUndoableEditListener(UndoableEditListener arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public Position createPosition(int arg0) throws BadLocationException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Element getDefaultRootElement() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Position getEndPosition() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getLength() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object getProperty(Object arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Element[] getRootElements() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Position getStartPosition() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getText(int arg0, int arg1) throws BadLocationException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void getText(int arg0, int arg1, Segment arg2) throws BadLocationException {
        // TODO Auto-generated method stub

    }

    @Override
    public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
        // TODO Auto-generated method stub

    }

    @Override
    public void putProperty(Object arg0, Object arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void remove(int arg0, int arg1) throws BadLocationException {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeDocumentListener(DocumentListener arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeUndoableEditListener(UndoableEditListener arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void render(Runnable arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public Style addStyle(String nm, Style parent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Color getBackground(AttributeSet attr) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Element getCharacterElement(int pos) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Font getFont(AttributeSet attr) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Color getForeground(AttributeSet attr) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Style getLogicalStyle(int p) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Element getParagraphElement(int pos) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Style getStyle(String nm) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeStyle(String nm) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setCharacterAttributes(int offset, int length, AttributeSet s, boolean replace) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLogicalStyle(int pos, Style s) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setParagraphAttributes(int offset, int length, AttributeSet s, boolean replace) {
        // TODO Auto-generated method stub

    }

}
