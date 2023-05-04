import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class JFrameAluno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<Aluno> listaAlunos;
	private JTextField txfNome;
	private JTextField txfNota1;
	private JTextField txfNota2;
	private JTable tblAlunos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameAluno frame = new JFrameAluno();
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
	public JFrameAluno() {
		listaAlunos = new ArrayList<Aluno>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(26, 41, 47, 14);
		contentPane.add(lblNome);
		
		txfNome = new JTextField();
		txfNome.setBounds(75, 38, 96, 20);
		contentPane.add(txfNome);
		txfNome.setColumns(10);
		
		JLabel lblNota1 = new JLabel("Nota 1");
		lblNota1.setBounds(26, 69, 47, 14);
		contentPane.add(lblNota1);
		
		txfNota1 = new JTextField();
		txfNota1.setColumns(10);
		txfNota1.setBounds(75, 66, 96, 20);
		contentPane.add(txfNota1);
		
		JLabel lblNota2 = new JLabel("Nota 2");
		lblNota2.setBounds(26, 97, 47, 14);
		contentPane.add(lblNota2);
		
		txfNota2 = new JTextField();
		txfNota2.setColumns(10);
		txfNota2.setBounds(75, 94, 96, 20);
		contentPane.add(txfNota2);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();
				aluno.setNome(txfNome.getText());
				aluno.setNota1(Double.parseDouble(txfNota1.getText()));
				aluno.setNota2(Double.parseDouble(txfNota2.getText()));
				listaAlunos.add(aluno);
				
				tblAlunos.setModel(listarTodos());
				
				txfNome.setText("");
				txfNota1.setText("");
				txfNota2.setText("");
				txfNome.requestFocus();
			}
		});
		btnSalvar.setBounds(26, 131, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Aluno aluno : listaAlunos) {
					System.out.println("Nome: " + aluno.getNome()
							+ ", nota 1: " + aluno.getNota1()
							+ ", nota 2: " + aluno.getNota2()
							+ ", média: " + aluno.getMedia());
				}
			}
		});
		btnMostrar.setBounds(125, 131, 89, 23);
		contentPane.add(btnMostrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 165, 460, 214);
		contentPane.add(scrollPane);
		
		tblAlunos = new JTable();
		scrollPane.setViewportView(tblAlunos);
	}
	
	private DefaultTableModel listarTodos() {
		DefaultTableModel dados = new DefaultTableModel();
		
		dados.addColumn("Nome");
		dados.addColumn("Nota 1");
		dados.addColumn("Nota 2");
		dados.addColumn("Média");
		
		for (Aluno aluno : listaAlunos) {
			dados.addRow(new Object[] {aluno.getNome(), aluno.getNota1(), aluno.getNota2(), aluno.getMedia()});
		}
		
		return dados;
	}
}
