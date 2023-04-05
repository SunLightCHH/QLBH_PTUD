/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt_qlbh;

/**
 *
 * @author tuana
 */
import javax.swing.*;

public class VerticalMenuBarExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Vertical Menu Bar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Tạo JMenuBar
        JMenuBar menuBar = new JMenuBar();
        //menuBar.setOrientation(JMenuBar.VERTICAL);
        
        // Tạo JMenu
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu viewMenu = new JMenu("View");
        JMenu helpMenu = new JMenu("Help");
        
        // Thêm JMenuItems vào JMenu
        fileMenu.add(new JMenuItem("New"));
        fileMenu.add(new JMenuItem("Open"));
        fileMenu.add(new JMenuItem("Save"));
        fileMenu.add(new JMenuItem("Save As"));
        fileMenu.addSeparator();
        fileMenu.add(new JMenuItem("Exit"));
        
        editMenu.add(new JMenuItem("Cut"));
        editMenu.add(new JMenuItem("Copy"));
        editMenu.add(new JMenuItem("Paste"));
        editMenu.add(new JMenuItem("Delete"));
        
        viewMenu.add(new JMenuItem("Zoom In"));
        viewMenu.add(new JMenuItem("Zoom Out"));
        viewMenu.add(new JMenuItem("Fit to Screen"));
        
        helpMenu.add(new JMenuItem("Help Contents"));
        helpMenu.add(new JMenuItem("About"));
        
        // Thêm JMenu vào JMenuBar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
        
        // Thêm JMenuBar vào JFrame
        frame.setJMenuBar(menuBar);
        
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
