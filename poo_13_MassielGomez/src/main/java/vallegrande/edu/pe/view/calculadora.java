package vallegrande.edu.pe.view;

import javax.swing.*;
import java.awt.*;

public class calculadora extends JFrame {
    private JTextField textnumero1;
    private JTextField textnumero2;
    private JButton btnsumar;
    private JButton btnrestar;
    private JButton btnmultiplicar;
    private JButton btndividir;
    private JLabel lblresultado;

    private double numero1;
    private double numero2;

    public calculadora() {
        setTitle("calculadora"); // título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null); // centrar ventana

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2, 5, 5));

        // Componentes
        textnumero1 = new JTextField();
        textnumero2 = new JTextField();
        btnsumar = new JButton("Sumar");
        btnrestar = new JButton("Restar");
        btnmultiplicar = new JButton("Multiplicar");
        btndividir = new JButton("Dividir");
        lblresultado = new JLabel("Resultado: ");

        // Añadir al panel
        mainPanel.add(new JLabel("Número 1:"));
        mainPanel.add(textnumero1);
        mainPanel.add(new JLabel("Número 2:"));
        mainPanel.add(textnumero2);
        mainPanel.add(btnsumar);
        mainPanel.add(btnrestar);
        mainPanel.add(btnmultiplicar);
        mainPanel.add(btndividir);

        // Panel inferior para el resultado
        JPanel resultPanel = new JPanel();
        resultPanel.add(lblresultado);

        // Layout de la ventana
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(resultPanel, BorderLayout.SOUTH);

        // Listeners
        btnsumar.addActionListener(e -> calcularYMostrar("sumar"));
        btnrestar.addActionListener(e -> calcularYMostrar("restar"));
        btnmultiplicar.addActionListener(e -> calcularYMostrar("multiplicar"));
        btndividir.addActionListener(e -> calcularYMostrar("dividir"));
    }

    private double sumar() {
        return numero1 + numero2;
    }

    private double restar() {
        return numero1 - numero2;
    }

    private double multiplicar() {
        return numero1 * numero2;
    }

    private double dividir() {
        if (numero2 == 0) {
            JOptionPane.showMessageDialog(this, "No se puede dividir entre cero.");
            return 0;
        }
        return numero1 / numero2;
    }

    private void calcularYMostrar(String operacion) {
        try {
            numero1 = Double.parseDouble(textnumero1.getText());
            numero2 = Double.parseDouble(textnumero2.getText());

            double resultado;
            switch (operacion) {
                case "sumar":
                    resultado = sumar();
                    break;
                case "restar":
                    resultado = restar();
                    break;
                case "multiplicar":
                    resultado = multiplicar();
                    break;
                case "dividir":
                    resultado = dividir();
                    break;
                default:
                    resultado = 0;
            }

            lblresultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa números válidos.");
        }
    }

    // Método main para ejecutar la ventana
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new calculadora().setVisible(true));
    }
}
