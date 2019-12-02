/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dictionary.JFrame;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Khac Ngoc
 */
public class AddFrame extends JFrame{
    static JLabel lb0, lb1, lb2, lb3;
    static JTextField tf1, tf2;
    static JTextArea tar;
    static JButton btnSave, btnDelete;
    public AddFrame(String a)
    {
        super(a);
        addControls();
        addEvent();
    }
    public void addControls()
    {
        
        Font fontText=new Font("arial", Font.BOLD, 13);
        
        Container con= getContentPane();
        JPanel mainPanel= new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        con.add(mainPanel);
        
        JPanel jpn0= new JPanel();
        lb0= new JLabel("ADD TO DICTIONARY");
        Font font= new Font("arial", Font.BOLD, 23);
        lb0.setFont(font);
        jpn0.add(lb0);
        mainPanel.add(jpn0);
        
        JPanel jpn1= new JPanel();
        jpn1.setLayout(new FlowLayout());
        lb1= new JLabel("                    Word :");
        tf1= new JTextField(50);
        lb1.setFont(fontText);
        tf1.setFont(fontText);
        jpn1.add(lb1);
        jpn1.add(tf1);
        mainPanel.add(jpn1);
        
        JPanel jpn2= new JPanel();
        jpn2.setLayout(new FlowLayout());
        lb2= new JLabel("         Translation : ");
        tf2= new JTextField(50);
        lb2.setFont(fontText);
        tf2.setFont(fontText);
        jpn2.add(lb2);
        jpn2.add(tf2);
        mainPanel.add(jpn2);
        
        JPanel jpn3= new JPanel();
        jpn3.setLayout(new FlowLayout());
        lb3= new JLabel("Add description : ");
        tar= new JTextArea(3, 50);
        lb3.setFont(fontText);
        tar.setFont(fontText);
        jpn3.add(lb3);
        jpn3.add(tar);
        mainPanel.add(jpn3);
        
        JPanel jpn4= new JPanel();
        jpn4.setLayout(new FlowLayout());
        btnSave= new JButton("Save");
        btnDelete= new JButton("Delete");        
        btnSave.setFont(fontText);
        btnSave.setIcon(new ImageIcon("Picture//add.png"));
        btnDelete.setFont(fontText);
        btnDelete.setIcon(new ImageIcon("Picture//delete.png"));
        jpn4.add(btnSave);
        jpn4.add(btnDelete);
        mainPanel.add(jpn4);
    }
    public void addEvent()
    {
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            if(tf1.getText().trim().compareTo("")==0 || tf2.getText().trim().compareTo("")==0 || tar.getText().trim().compareTo("")==0)
            {
                JOptionPane.showMessageDialog(null, "Please, mày nhập đầy đủ vào hộ tao cái.");
            }
            else{
            try {
            File add= new File("E:\\Java\\UpdateDictionary2\\AddDictionary.txt");
            //lấy chuỗi ra lưu vào 1 chuỗi 2 chiều.
            FileReader fr= new FileReader(add);
            BufferedReader br= new BufferedReader(fr);
            ArrayList<String> oldFile= new ArrayList<String>();
            String line;
            while((line= br.readLine())!=null)
            {
                oldFile.add(line);
            }
            br.close();
            fr.close();
            String ad= tf1.getText().trim()+"<html><i>"+tf1.getText().trim()+"</i><br/><ul><li><font color='#cc0000'><b>"+tf2.getText()+"</b></font></li></ul>"+"<ul><li><font color='#cc0000'><b>"+ tar.getText().trim()+"</b></font></li></ul></html>";
            oldFile.add(ad);
            // viết tiếp vào file
            FileWriter fw= new FileWriter(add);
            BufferedWriter bw= new BufferedWriter(fw);
            for(String a: oldFile)
            {
                bw.write(a);
                bw.newLine();
            }
            bw.close();
            fw.close();
            tf1.setText("");
            tf2.setText("");
            tar.setText("");
            } catch (Exception e) {
            System.out.println(e.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Saved, Thank you <3");
            }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tf1.setText("");
                tf2.setText("");
                tar.setText("");
            }
        });
    }
    public void showFrame()
    {
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
