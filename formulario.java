/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplo3_8;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author izabe
 */
public class formulario extends JFrame {

    //atributos
    JTable tabla = new JTable();
    JScrollPane sp = new JScrollPane();
    JPanel p1 = new JPanel();
    Object filas[][] = new Object[50][3];
    int x = 0;

    public void crear() {
        setTitle("Ejemplo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(800, 400);
        setVisible(true);
        p1.setBackground(Color.ORANGE);
        p1.setLayout(null);
        add(p1);

        JLabel l1 = new JLabel("Ingresa tu nombre");
        //cordenada en x, cordenada en y, ancho y alto
        l1.setBounds(600, 20, 150, 40);
        p1.add(l1);

        JTextField t1 = new JTextField("...");
        t1.setBounds(600, 50, 150, 25);
        p1.add(t1);

        JLabel l2 = new JLabel("Ingresa tu apellido");
        l2.setBounds(600, 80, 150, 40);
        p1.add(l2);

        JTextField t2 = new JTextField("...");
        t2.setBounds(600, 110, 150, 25);
        p1.add(t2);

        JLabel l3 = new JLabel("Ingresa No. telefono ");
        l3.setBounds(600, 140, 150, 25);
        p1.add(l3);

        JTextField t3 = new JTextField("...");
        t3.setBounds(600, 170, 150, 25);
        p1.add(t3);

        JButton b1 = new JButton("Guardar");
        b1.setBounds(600, 275, 150, 25);
        p1.add(b1);

        ActionListener guardar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(t1.getText().equals("")) && !(t2.getText().equals("")) && !(t3.getText().equals(""))) {
                    agregar(t1.getText(), t2.getText(), Integer.parseInt(t3.getText()));
                    t1.setText(null);
                    t2.setText(null);
                    t3.setText(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Completa los datos");
                }
            }

        };
        b1.addActionListener(guardar);
    }

    private void tabla() {
        String columnas[] = {"Nombre", "Apellido", "Telefono"};

        tabla = new JTable(filas, columnas);
        sp = new JScrollPane(tabla);
        sp.setBounds(10, 20, 500, 300);
        p1.add(sp);
        sp.setVisible(true);

    }

    private void agregar(String nombre, String apellido, int telefono) {
        if (x == 50) {
            System.out.println("Ya no se permiten mas Ingresos");
        } else {
            filas[x][0] = nombre;
            filas[x][1] = apellido;
            filas[x][2] = telefono;
            x++;
            sp.setVisible(false);
            tabla();
        }

    }

    public void ejecutar() {
        crear();
        tabla();
    }

    public static void main(String[] args) {
        formulario f = new formulario();
        f.ejecutar();
    }
}

//form boton crear que guarde
