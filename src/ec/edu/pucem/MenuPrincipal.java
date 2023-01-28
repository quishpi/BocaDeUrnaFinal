package ec.edu.pucem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import ec.edu.pucem.dominios.Prefecto;
import ec.edu.pucem.formularios.BocaDeUrna;
import ec.edu.pucem.formularios.CrearPrefecto;

import javax.swing.JMenuBar;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.BorderLayout;
import java.awt.CardLayout;

public class MenuPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contenedor;
	private JDesktopPane desktopPane;
	private JMenuItem mntmSalir;
	private JMenuItem mntmCrearPrefectos;
	private JMenuItem mntmBocaDeUrna;

	public List<Prefecto> prefectos = new ArrayList<>();
	private JMenuItem mntmResultadosBarras;
	private JMenuItem mntmResultadosPastel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setTitle("SISTEMA CONTEO DE VOTOS BOCA DE URNA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(192, 191, 188));
		setJMenuBar(menuBar);

		JMenu mnSistema = new JMenu("Sistema");
		mnSistema.setFont(new Font("Dialog", Font.BOLD, 16));
		menuBar.add(mnSistema);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setFont(new Font("Dialog", Font.BOLD, 16));
		mnSistema.add(mntmSalir);

		JMenu mnAdministracin = new JMenu("Administración");
		mnAdministracin.setFont(new Font("Dialog", Font.BOLD, 16));
		menuBar.add(mnAdministracin);

		mntmCrearPrefectos = new JMenuItem("Crear Prefectos");
		mntmCrearPrefectos.setFont(new Font("Dialog", Font.BOLD, 16));
		mntmCrearPrefectos.addActionListener(this);
		mnAdministracin.add(mntmCrearPrefectos);

		JMenu mnProceso = new JMenu("Proceso");
		mnProceso.setFont(new Font("Dialog", Font.BOLD, 16));
		menuBar.add(mnProceso);

		mntmBocaDeUrna = new JMenuItem("Boca de Urna");
		mntmBocaDeUrna.setFont(new Font("Dialog", Font.BOLD, 16));
		mntmBocaDeUrna.addActionListener(this);
		mnProceso.add(mntmBocaDeUrna);

		mntmResultadosBarras = new JMenuItem("Resultados Barras");
		mntmResultadosBarras.addActionListener(this);
		mntmResultadosBarras.setFont(new Font("Dialog", Font.BOLD, 16));
		mnProceso.add(mntmResultadosBarras);

		mntmResultadosPastel = new JMenuItem("Resultados Pastel");
		mntmResultadosPastel.addActionListener(this);
		mntmResultadosPastel.setFont(new Font("Dialog", Font.BOLD, 16));
		mnProceso.add(mntmResultadosPastel);
		contenedor = new JPanel();
		contenedor.setBackground(new Color(255, 255, 255));
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contenedor);
		contenedor.setLayout(new CardLayout(0, 0));

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 255, 255));
		contenedor.add(desktopPane, "name_35522358088801");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmSalir) {
			dispose();
		} else if (e.getSource() == mntmCrearPrefectos) {
			CrearPrefecto crearPrefecto = new CrearPrefecto(prefectos);
			desktopPane.add(crearPrefecto);
			crearPrefecto.setVisible(true);

		} else if (e.getSource() == mntmBocaDeUrna) {
			BocaDeUrna bocaUrna = new BocaDeUrna(prefectos);
			desktopPane.add(bocaUrna);
			bocaUrna.setVisible(true);
		} else if (e.getSource() == mntmResultadosBarras) {
			crearResultadosEnBarras();
		} else if (e.getSource() == mntmResultadosPastel) {
			crearResultadosEnPastel();
		}
	}

	private void crearResultadosEnBarras() {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		//dataset.addValue(34.0, "Prefecto", "Category 1");
		//TODO
		//Completar
		final JFreeChart chart = ChartFactory.createBarChart("Bar Chart", "Category", "Series", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(600, 400));

		final JInternalFrame frame = new JInternalFrame("Resultado en Barras", true);

		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		//TODO
		//Completar

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO
				//Completar
			}
		});

		//TODO
		//Completar
		desktopPane.add(frame);
		frame.pack();
		frame.setVisible(true);
	}

	private void crearResultadosEnPastel() {
		DefaultPieDataset datos = new DefaultPieDataset();
		// datos.setValue("Candidato 1",90);
		//TODO
		//Completar

		JFreeChart grafico = ChartFactory.createPieChart("Prefectos", datos);
		ChartPanel chartPanel = new ChartPanel(grafico);
		chartPanel.setBounds(10, 50, 450, 350);

		final JInternalFrame frame = new JInternalFrame("Resultado en Pastel", true);

		//TODO
		//Completar
		
		desktopPane.add(frame);
		frame.pack();
		frame.setVisible(true);
	}
}
