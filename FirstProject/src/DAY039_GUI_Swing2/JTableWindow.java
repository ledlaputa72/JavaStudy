package DAY039_GUI_Swing2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import javax.swing.ListSelectionModel;

public class JTableWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableWindow frame = new JTableWindow();
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
	public JTableWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		table.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		table.setForeground(Color.BLACK);
		table.setBackground(Color.YELLOW);
		table.setGridColor(Color.RED);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"s10234", "\uACBD\uC11D", "010-5678-2345"},
				{"s10235", "\uBBF8\uB798", "010-1234-1234"},
				{"s10236", "\uC218\uC544", "010-2345-3456"},
				{"s10237", "\uC6B0\uC601", "010-3456-6543"},
				{"s10238", "\uC815\uBD84", "010-4567-2222"},
				{"s10239", "\uC720\uC740", "010-5678-1111"},
				{"s10240", "\uC720\uC9C4", "010-6789-7567"},
				{"s10241", "\uD604\uC815", "010-8765-4564"},
				{"s10242", "\uAE38\uB3D9", "010-7654-1212"},
				{"s10243", "\uCCA0\uC218", "010-5432-9090"},
			},
			new String[] {
				"\uBC88\uD638", "\uC774\uB984", "\uC804\uD654\uBC88\uD638"
			}
		));
		table.setRowHeight(30); 
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.getColumnModel().getColumn(1).setPreferredWidth(84);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.setBounds(0, 0, 584, 446);
		contentPane.add(table);
	}
}
