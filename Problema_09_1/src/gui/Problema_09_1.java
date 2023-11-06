package gui;

import clase.Alumno;
import arreglo.ArregloAlumnos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;

public class Problema_09_1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblNota1;
	private JLabel lblNota2;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JButton btnAdicionar;
	private JButton btnReportar;
	private JScrollPane scrollPaneA;
	private JScrollPane scrollPaneB;
	private JTextArea txtS;
	private JTable tblTabla;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Problema_09_1 frame = new Problema_09_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Problema_09_1() {
		setTitle("Problema_09_1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 11, 40, 28);
		contentPane.add(lblCodigo);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(120, 11, 50, 28);
		contentPane.add(lblNombre);

		lblNota1 = new JLabel("Nota 1");
		lblNota1.setBounds(255, 11, 40, 28);
		contentPane.add(lblNota1);

		lblNota2 = new JLabel("Nota 2");
		lblNota2.setBounds(358, 11, 40, 28);
		contentPane.add(lblNota2);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(54, 11, 40, 28);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(170, 11, 60, 28);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtNota1 = new JTextField();
		txtNota1.setBounds(295, 11, 40, 28);
		contentPane.add(txtNota1);
		txtNota1.setColumns(10);

		txtNota2 = new JTextField();
		txtNota2.setBounds(402, 11, 40, 28);
		contentPane.add(txtNota2);
		txtNota2.setColumns(10);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(450, 50, 155, 23);
		contentPane.add(btnAdicionar);

		btnReportar = new JButton("Reportar");
		btnReportar.setBounds(450, 75, 155, 23);
		btnReportar.addActionListener(this);
		contentPane.add(btnReportar);

		scrollPaneA = new JScrollPane();
		scrollPaneA.setBounds(10, 50, 432, 200);
		contentPane.add(scrollPaneA);

		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPaneA.setViewportView(tblTabla);

		modelo = new DefaultTableModel();
		modelo.addColumn("c�digo");
		modelo.addColumn("nombre");
		modelo.addColumn("nota 1");
		modelo.addColumn("nota 2");
		modelo.addColumn("promedio");
		tblTabla.setModel(modelo);

		scrollPaneB = new JScrollPane();
		scrollPaneB.setBounds(10, 250, 432, 100);
		contentPane.add(scrollPaneB);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPaneB.setViewportView(txtS);

		listar();
	}

	// Declaraci�n global
	ArregloAlumnos aa = new ArregloAlumnos();

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnReportar) {
			actionPerformedBtnReportar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}

	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		/**
		 * Adiciona un nuevo alumno
		 */
		try {

			int codigo = leerCodigo();
			String nombre = leerNombre();
			int nota1 = leerNota1();
			int nota2 = leerNota2();
			if (nota1 >= 0 && nota1 <= 20 && nota2 >= 0 && nota2 <= 20) {
				Alumno nuevo = new Alumno(codigo, nombre, nota1, nota2);
				aa.adicionar(nuevo);
				listar();
				limpieza();
			} else {
				mensaje("error de ingreso");
			}
		} catch (Exception e) {
			mensaje("error de ingreso");
		}
	}

	protected void actionPerformedBtnReportar(ActionEvent arg0) {
		/**
		 * Visualiza un reporte
		 */
		txtS.setText("");
		imprimir("cantidad de alumnos :  " + aa.tamanio());
		imprimir("cantidad de aprobados :  " + aa.cantAprobados());
		imprimir("Nombre del primer alumno desaprobado: " + aa.nombrePrimerDesaprobado());
		imprimir("Nombre del último alumno aprobado: " + aa.nombreUltimoAprobado());
		imprimir("Nombre del segundo alumno desaprobado: " + aa.nombreSegundoDesaprobado());
		imprimir("Nombre del penúltimo alumno aprobado: " + aa.nombrePenultimoAprobado());
	}

	// M�todos tipo void (sin par�metros)
	void imprimir() {
		imprimir("");
	}

	void limpieza() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtNota1.setText("");
		txtNota2.setText("");
		txtS.setText("");
		txtCodigo.requestFocus();
	}

	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < aa.tamanio(); i++) {
			Object[] fila = { aa.obtener(i).getCodigo(), aa.obtener(i).getNombre(), aa.obtener(i).getNota1(),
					aa.obtener(i).getNota2(), aa.obtener(i).promedio() };
			modelo.addRow(fila);
		}
	}

	// M�todos tipo void (con par�metros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	// M�todos que retornan valor (sin par�metros)
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}

	String leerNombre() {
		return txtNombre.getText().trim();
	}

	int leerNota1() {
		return Integer.parseInt(txtNota1.getText().trim());
	}

	int leerNota2() {
		return Integer.parseInt(txtNota2.getText().trim());
	}

}