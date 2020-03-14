import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;

public class game_1 extends JFrame {
	
	JTable table, table1;
	final static String LABEL_TEXT = "Yahtzee";
	JFrame frame;
	JPanel contentPane;
	JPanel gamePanel;
	JButton select1_1, select2_1, select3_1, select4_1, select5_1, select6_1, select3ok_1, select4ok_1, selectfh_1, selectss_1, selectls_1, selectc_1, selecty_1;
	JButton select1_2, select2_2, select3_2, select4_2, select5_2, select6_2, select3ok_2, select4ok_2, selectfh_2, selectss_2, selectls_2, selectc_2, selecty_2;
	JButton keep1, keep2, keep3, keep4, keep5;
	JButton roll;
	JButton newgame;
	JLabel player1;
	JLabel player2;
	JLabel picture1, picture2, picture3, picture4, picture5, picture6;
	int p11, p12, p13, p14, p15, p16, p1s, p13ok, p14ok, p1fh, p1ss, p1ls, p1c, p1y, p1t;
	int p21, p22, p23, p24, p25, p26, p2s, p23ok, p24ok, p2fh, p2ss, p2ls, p2c, p2y, p2t;
	JLabel die1, die2, die3, die4, die5;
	int d1, d2, d3, d4, d5;
	int count = 0;
	boolean stay1 = false, stay2 = false, stay3 = false, stay4 = false, stay5 = false;
	boolean rolled = false;
	boolean p1 = true;
	player1 player = new player1();
	
	
	public game_1() {
		frame = new JFrame("Yahtzee");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.cyan);
		contentPane.setLayout(new GridLayout(0,5,10,5));
		
	
		String[] columnNames = {"Combination", "player1 1", "player1 2"};

		Object[][] data = {
				{"", "player1 1", "player1 2"},
				{"Ones", p11, p12},
				{"Twos", p12, p22},
				{"Threes", p13, p23},
				{"Fours", p14, p24},
				{"Fives", p15, p25},
				{"Sixes", p16, p26},
				{"", "", ""},
				{"", "", ""},
				{"Sum", "", ""},
				{"", "", ""},
		};
		
		table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(1500,100));
		table.setFillsViewportHeight(true);
		table.setBackground(Color.LIGHT_GRAY);
		
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		contentPane.add(table);
		
		player1 = new JLabel("player1 1:");
		player1.setFont(new Font("Serif", Font.PLAIN, 40));
		contentPane.add(player1);
		
		select1_1 = new JButton("Ones");
		select1_1.addActionListener(new p1OneListener());
		select1_1.setFont(new Font("Serif", Font.PLAIN, 40));
		contentPane.add(select1_1);
		
		select2_1 = new JButton("Twos");
		select2_1.addActionListener(new p1TwoListener());
		select2_1.setFont(new Font("Serif", Font.PLAIN, 40));
		contentPane.add(select2_1);
		
		select3_1 = new JButton("Threes");
		select3_1.addActionListener(new p1ThreeListener());
		select3_1.setFont(new Font("Serif", Font.PLAIN, 40));
		contentPane.add(select3_1);
		
		String[] columnNames1 = {"Combination", "player1 1", "player1 2"};

		Object[][] data1 = {
				{"3 of a kind", p13ok, p23ok},
				{"4 of a kind", p14ok, p24ok},
				{"Full house", p1fh, p2fh},
				{"Short straight", p1ss, p2ss},
				{"Large straight", p1ls, p2ls},
				{"Chance", p1c, p2c},
				{"Yahtzee", p1y, p2y},
		};
		
		table1 = new JTable(data1, columnNames);
		table1.setPreferredScrollableViewportSize(new Dimension(1500,100));
		table1.setFillsViewportHeight(true);
		table1.setBackground(Color.lightGray);
		
		JScrollPane scrollPane1 = new JScrollPane(table1);
		add(scrollPane1);
		contentPane.add(table1);
		
		select4_1 = new JButton("Fours");
		select4_1.addActionListener(new p1FourListener());
		select4_1.setFont(new Font("Serif", Font.PLAIN, 40));
		contentPane.add(select4_1);
		
		select5_1 = new JButton("Fives");
		select5_1.addActionListener(new p1FiveListener());
		select5_1.setFont(new Font("Serif", Font.PLAIN, 40));
		contentPane.add(select5_1);
		
		select6_1 = new JButton("Sixes");
		select6_1.addActionListener(new p1SixListener());
		select6_1.setFont(new Font("Serif", Font.PLAIN, 40));
		contentPane.add(select6_1);
		
		select3ok_1 = new JButton("3 of a Kind");
		select3ok_1.addActionListener(new p13okListener());
		select3ok_1.setFont(new Font("Serif", Font.PLAIN, 30));
		contentPane.add(select3ok_1);
		
		select4ok_1 = new JButton("4 of a kind");
		select4ok_1.addActionListener(new p14okListener());
		select4ok_1.setFont(new Font("Serif", Font.PLAIN, 30));
		contentPane.add(select4ok_1);
		
		selectfh_1 = new JButton("Full House");
		selectfh_1.setFont(new Font("Serif", Font.PLAIN, 30));
		contentPane.add(selectfh_1);
		
		selectss_1 = new JButton("Small Straight");
		selectss_1.setFont(new Font("Serif", Font.PLAIN, 30));
		contentPane.add(selectss_1);
		
		selectls_1 = new JButton("Large straight");
		selectls_1.setFont(new Font("Serif", Font.PLAIN, 30));
		contentPane.add(selectls_1);
		
		selectc_1 = new JButton("Chance");
		selectc_1.setFont(new Font("Serif", Font.PLAIN, 40));
		contentPane.add(selectc_1);
		
		selecty_1 = new JButton("Yahtzee");
		selecty_1.setFont(new Font("Serif", Font.PLAIN, 40));
		contentPane.add(selecty_1);
		
		player2 = new JLabel("player1 2:");
		player2.setFont(new Font("Serif", Font.PLAIN, 40));
		contentPane.add(player2);
		
		select1_2 = new JButton("Ones");
		contentPane.add(select1_2);
		
		select2_2 = new JButton("Twos");
		contentPane.add(select2_2);
		
		select3_2 = new JButton("Threes");
		contentPane.add(select3_2);
		
		select4_2 = new JButton("Fours");
		contentPane.add(select4_2);
		
		select5_2 = new JButton("Fives");
		contentPane.add(select5_2);
		
		select6_2 = new JButton("Sixes");
		contentPane.add(select6_2);
		
		select3ok_2 = new JButton("3 of a Kind");
		contentPane.add(select3ok_2);
		
		select4ok_2 = new JButton("4 of a kind");
		contentPane.add(select4ok_2);
		
		selectfh_2 = new JButton("Full House");
		contentPane.add(selectfh_2);
		
		selectss_2 = new JButton("Small Straight");
		contentPane.add(selectss_2);
		
		selectls_2 = new JButton("Large straight");
		contentPane.add(selectls_2);
		
		selectc_2 = new JButton("Chance");
		contentPane.add(selectc_2);
		
		selecty_2 = new JButton("Yahtzee");
		contentPane.add(selecty_2);
		
		picture1 = new JLabel(new ImageIcon("die1.jpg"));
		picture1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		contentPane.add(picture1);
		
		picture2 = new JLabel(new ImageIcon("die2.jpg"));
		picture2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		contentPane.add(picture2);
		
		picture3 = new JLabel(new ImageIcon("die3.jpg"));
		picture3.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		contentPane.add(picture3);
		
		picture4 = new JLabel(new ImageIcon("die4.jpg"));
		picture4.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		contentPane.add(picture4);
		
		picture5 = new JLabel(new ImageIcon("die5.jpg"));
		picture5.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		contentPane.add(picture5);
		
		keep1 = new JButton("Keep");
		keep1.addActionListener(new keep1Listener());
		contentPane.add(keep1);
		
		keep2 = new JButton("Keep");
		keep2.addActionListener(new keep2Listener());
		contentPane.add(keep2);
		
		keep3 = new JButton("Keep");
		keep3.addActionListener(new keep3Listener());
		contentPane.add(keep3);
		
		keep4 = new JButton("Keep");
		keep4.addActionListener(new keep4Listener());
		contentPane.add(keep4);
		
		keep5 = new JButton("Keep");
		keep5.addActionListener(new keep5Listener());
		contentPane.add(keep5);
		
		roll = new JButton("Roll");
		roll.addActionListener(new RollListener());
		contentPane.add(roll);
		
		
		frame.setContentPane(contentPane);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	class p1OneListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			int ones = 0;
			if(p1 == true && count != 0) {
				if(d1 == 1) {
					ones ++;
				}
				if(d2 == 1) {
					ones ++;
				}
				if(d3 == 1) {
					ones ++;
				}
				if(d4 == 1) {
					ones ++;
				}
				if(d5 == 1) {
					ones ++;
				}
				p11 = ones;
				table.setValueAt(p11, 1, 1);
				p1 = false;
				select1_1.setVisible(false);
				player.addScore(0, 0, p11);
				roll.setVisible(true);
				count = 0;
			}
		}
	}
	
	class p1TwoListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			int twos = 0;
			if(p1 == true && count != 0) {
				if(d1 == 2) {
					twos ++;
				}
				if(d2 == 2) {
					twos ++;
				}
				if(d3 == 2) {
					twos ++;
				}
				if(d4 == 2) {
					twos ++;
				}
				if(d5 == 2) {
					twos ++;
				}
				p12 = twos*2;
				table.setValueAt(p12, 2, 1);
				p1 = false;
				select2_1.setVisible(false);
				player.addScore(0, 1, p12);
				roll.setVisible(true);
				count = 0;
			}
		}
	}
	
	class p1ThreeListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			int threes = 0;
			if(p1 == true && count != 0) {
				if(d1 == 3) {
					threes ++;
				}
				if(d2 == 3) {
					threes ++;
				}
				if(d3 == 3) {
					threes ++;
				}
				if(d4 == 3) {
					threes ++;
				}
				if(d5 == 3) {
					threes ++;
				}
				p13 = threes*3;
				table.setValueAt(p13, 3, 1);
				p1 = false;
				select3_1.setVisible(false);
				player.addScore(0, 3, p13);
				roll.setVisible(true);
				count = 0;
			}
		}
	}
	
	class p1FourListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			int fours = 0;
			if(p1 == true && count != 0) {
				if(d1 == 4) {
					fours ++;
				}
				if(d2 == 4) {
					fours ++;
				}
				if(d3 == 4) {
					fours ++;
				}
				if(d4 == 4) {
					fours ++;
				}
				if(d5 == 4) {
					fours ++;
				}
				p14 = fours*4;
				table.setValueAt(p14,  4,  1);
				p1 = false;
				select4_1.setVisible(false);
				player.addScore(0, 4, p14);
				roll.setVisible(true);
				count = 0;
			}
		}
	}
	
	class p1FiveListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			int fives = 0;
			if(p1 == true && count != 0) {
				if(d1 == 5) {
					fives ++;
				}
				if(d2 == 5) {
					fives ++;
				}
				if(d3 == 5) {
					fives ++;
				}
				if(d4 == 5) {
					fives ++;
				}
				if(d5 == 5) {
					fives ++;
				}
				p15 = fives*5;
				table.setValueAt(p15, 5, 1);
				p1 = false;
				select5_1.setVisible(false);
				player.addScore(0, 5, p15);
				roll.setVisible(true);
				count = 0;
			}
		}
	}
	
	class p1SixListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			int sixes = 0;
			if(p1 == true && count != 0) {
				if(d1 == 6) {
					sixes ++;
				}
				if(d2 == 6) {
					sixes ++;
				}
				if(d3 == 6) {
					sixes ++;
				}
				if(d4 == 6) {
					sixes ++;
				}
				if(d5 == 6) {
					sixes ++;
				}
				p16 = sixes*6;
				table.setValueAt(p16, 6, 1);
				p1 = false;
				select6_1.setVisible(false);
				player.addScore(0, 6, p16);
				roll.setVisible(true);
				count = 0;
			}
		}
	}
	
	class p13okListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			int[] threeok = new int[7];
			if(p1 == true && count != 0) {
				threeok[d1] ++;
				threeok[d2] ++;
				threeok[d3] ++;
				threeok[d4] ++;
				threeok[d5] ++;
			
				if(threeok[1] == 3 || threeok[2] == 3 || threeok[3] == 3 || threeok[4] == 3 || threeok[5] == 3 || threeok[6] == 3) {
					p13ok = d1 + d2 + d3 + d4 + d5;
				}
				else {
					p13ok = 0;
				}
				table1.setValueAt(p13ok, 0, 1);
				p1 = false;
				select3ok_1.setVisible(false);
				player.addScore(0, 7, p13ok);
				roll.setVisible(true);
				count = 0;
			}
		}
	}
	
	class p14okListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			int[] fourok = new int[7];
			if(p1 == true && count != 0) {
				fourok[d1] ++;
				fourok[d2] ++;
				fourok[d3] ++;
				fourok[d4] ++;
				fourok[d5] ++;
			
				if(fourok[1] == 4 || fourok[2] == 4 || fourok[3] == 4 || fourok[4] == 4 || fourok[5] == 4 || fourok[6] == 4) {
					p14ok = d1 + d2 + d3 + d4 + d5;
				}
				else {
					p14ok = 0;
				}
				table1.setValueAt(p14ok, 1, 1);
				p1 = false;
				select4ok_1.setVisible(false);
				player.addScore(0, 8, p14ok);
				roll.setVisible(true);
				count = 0;
			}
		}
	}
	
	class keep1Listener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(rolled == true) {
			if(stay1 == false) {
				stay1 = true;
				keep1.setText("Remove");
			}
			else {
				stay1 = false;
				keep1.setText("Keep");
			}
			}
		}
	}
	
	class keep2Listener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(rolled == true) {
			if(stay2 == false) {
				stay2 = true;
				keep2.setText("Remove");
			}
			else {
				stay2 = false;
				keep2.setText("Keep");
			}
			}
		}
	}
	
	class keep3Listener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(rolled == true) {
			if(stay3 == false) {
				stay3 = true;
				keep3.setText("Remove");
			}
			else {
				stay3 = false;
				keep3.setText("Keep");
			}
			}
		}
	}
	
	class keep4Listener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(rolled == true) {
			if(stay4 == false) {
				stay4 = true;
				keep4.setText("Remove");
			}
			else {
				stay4 = false;
				keep4.setText("Keep");
			}
			}
		}
	}
	
	class keep5Listener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(rolled == true) {
			if(stay5 == false) {
				stay5 = true;
				keep5.setText("Remove");
			}
			else {
				stay5 = false;
				keep5.setText("Keep");
			}
			}
		}
	}
	
	class RollListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			count ++;
			rolled = true;
			
			if(count == 3) {
				roll.setVisible(false);
			}
			
			if(stay1 == false) {
				Random rand1 = new Random();
				d1 = rand1.nextInt(6) + 1;
			}
			if(stay2 == false) {
				Random rand2 = new Random();
				d2 = rand2.nextInt(6) + 1;
			}
			if(stay3 == false) {
				Random rand3 = new Random();
				d3 = rand3.nextInt(6) + 1;
			}
			if(stay4 == false) {
				Random rand4 = new Random();
				d4 = rand4.nextInt(6) + 1;
			}
			if(stay5 == false) {
				Random rand5 = new Random();
				d5 = rand5.nextInt(6) + 1;
			}
			
			if(d1 == 1) {
				picture1.setIcon(new ImageIcon("die1.jpg"));
			}
			if(d1 == 2) {
				picture1.setIcon(new ImageIcon("die2.jpg"));
			}
			if(d1 == 3) {
				picture1.setIcon(new ImageIcon("die3.jpg"));
			}
			if(d1 == 4) {
				picture1.setIcon(new ImageIcon("die4.jpg"));
			}
			if(d1 == 5) {
				picture1.setIcon(new ImageIcon("die5.jpg"));
			}
			if(d1 == 6) {
				picture1.setIcon(new ImageIcon("die6.jpg"));
			}
			
			if(d2 == 1) {
				picture2.setIcon(new ImageIcon("die1.jpg"));
			}
			if(d2 == 2) {
				picture2.setIcon(new ImageIcon("die2.jpg"));
			}
			if(d2 == 3) {
				picture2.setIcon(new ImageIcon("die3.jpg"));
			}
			if(d2 == 4) {
				picture2.setIcon(new ImageIcon("die4.jpg"));
			}
			if(d2 == 5) {
				picture2.setIcon(new ImageIcon("die5.jpg"));
			}
			if(d2 == 6) {
				picture2.setIcon(new ImageIcon("die6.jpg"));
			}
			
			if(d3 == 1) {
				picture3.setIcon(new ImageIcon("die1.jpg"));
			}
			if(d3 == 2) {
				picture3.setIcon(new ImageIcon("die2.jpg"));
			}
			if(d3 == 3) {
				picture3.setIcon(new ImageIcon("die3.jpg"));
			}
			if(d3 == 4) {
				picture3.setIcon(new ImageIcon("die4.jpg"));
			}
			if(d3 == 5) {
				picture3.setIcon(new ImageIcon("die5.jpg"));
			}
			if(d3 == 6) {
				picture3.setIcon(new ImageIcon("die6.jpg"));
			}
			
			if(d4 == 1) {
				picture4.setIcon(new ImageIcon("die1.jpg"));
			}
			if(d4 == 2) {
				picture4.setIcon(new ImageIcon("die2.jpg"));
			}
			if(d4 == 3) {
				picture4.setIcon(new ImageIcon("die3.jpg"));
			}
			if(d4 == 4) {
				picture4.setIcon(new ImageIcon("die4.jpg"));
			}
			if(d4 == 5) {
				picture4.setIcon(new ImageIcon("die5.jpg"));
			}
			if(d4 == 6) {
				picture4.setIcon(new ImageIcon("die6.jpg"));
			}
			
			if(d5 == 1) {
				picture5.setIcon(new ImageIcon("die1.jpg"));
			}
			if(d5 == 2) {
				picture5.setIcon(new ImageIcon("die2.jpg"));
			}
			if(d5 == 3) {
				picture5.setIcon(new ImageIcon("die3.jpg"));
			}
			if(d5 == 4) {
				picture5.setIcon(new ImageIcon("die4.jpg"));
			}
			if(d5 == 5) {
				picture5.setIcon(new ImageIcon("die5.jpg"));
			}
			if(d5 == 6) {
				picture5.setIcon(new ImageIcon("die6.jpg"));
			}
		}
	}
		
	public static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		game_1 yahtzee = new game_1();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
		

	}

}
