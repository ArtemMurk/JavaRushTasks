package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;
import java.io.StringWriter;

public class View extends JFrame implements ActionListener {
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane= new JEditorPane();
    public View() throws HeadlessException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        } catch (InstantiationException e) {
            ExceptionHandler.log(e);
        } catch (IllegalAccessException e) {
            ExceptionHandler.log(e);
        } catch (UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        }
    }

    public boolean canUndo(){
        return undoManager.canUndo();
    }

    public boolean canRedo(){
        return undoManager.canRedo();
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        switch (command){
            case "Новый":controller.createNewDocument(); break;
            case "Открыть":controller.openDocument(); break;
            case "Сохранить":controller.saveDocument(); break;
            case "Сохранить как...":controller.saveDocumentAs(); break;
            case "Выход":controller.exit(); break;
            case "О программе":showAbout(); break;

        }
    }

    public void init() {
        initGui();
        FrameListener listener  = new FrameListener(this);
        addWindowListener(listener);
        this.setVisible(true);
    }


        public void undo(){
            try {
                undoManager.undo();
            } catch (CannotUndoException e) {
                ExceptionHandler.log(e);
            }
        }
        public void redo(){
            try {
                undoManager.redo();
            } catch (CannotRedoException e) {
                ExceptionHandler.log(e);
            }
        }

        public void resetUndo(){
            undoManager.discardAllEdits();
        }



        public void initMenuBar(){
        JMenuBar  menu = new JMenuBar();
        MenuHelper.initFileMenu(this,menu);
        MenuHelper.initEditMenu(this,menu);
        MenuHelper.initStyleMenu(this,menu);
        MenuHelper.initAlignMenu(this,menu);
        MenuHelper.initColorMenu(this,menu);
        MenuHelper.initFontMenu(this,menu);
        MenuHelper.initHelpMenu(this,menu);
        getContentPane().add(menu, BorderLayout.NORTH);

    }

    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane htmlPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML",htmlPane);
        JScrollPane textPane = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст",textPane);
        tabbedPane.setPreferredSize(new Dimension(400, 400));

        TabbedPaneChangeListener changeTabbedPane = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(changeTabbedPane);
        getContentPane().add(tabbedPane,BorderLayout.CENTER);
    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();

    }

    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex()==0;

    }

    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        this.resetUndo();
    }

    public void update(){
        HTMLDocument htmlDocController = controller.getDocument();
        htmlTextPane.setDocument(htmlDocController);
    }

    public void showAbout(){
        JOptionPane.showMessageDialog(null,"Данную программу придумал Муравлев Артем.","About program.", JOptionPane.INFORMATION_MESSAGE);
    }

    public void selectedTabChanged(){
        if (tabbedPane.getSelectedIndex()==0){
            controller.setPlainText(plainTextPane.getText());
        }
        else if (tabbedPane.getSelectedIndex()==1){
            String text = controller.getPlainText();
            plainTextPane.setText(text);
        }
        this.resetUndo();
    }

    public void exit() {
        controller.exit();
    }
}
