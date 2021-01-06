package first;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;



public class School {

 public static void main(String[] args) {
  new Test();
 }

}



class Test extends JFrame implements ActionListener {
 JButton btn1 = null;
 JButton btn2 = null;
 JButton btn3 = null;
 JButton btn4 = null;
 JButton btn5 = null; //��ư �ټ��� ����
 JTable table = null; //���̺� ����

 public Test() {
  super("������ & �л� ���� ���α׷�");
  this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  this.setBounds(300, 300, 600, 600);
  this.setLayout(new FlowLayout()); //���� â ����

  JPanel panelComboBox = new JPanel();
  JPanel panelList = new JPanel();
  JPanel panelTable = new JPanel();
  JPanel panelNormal = new JPanel();

  panelComboBox.setLayout(new FlowLayout());
  panelList.setLayout(new FlowLayout());
  panelTable.setLayout(new FlowLayout());
  panelNormal.setLayout(new FlowLayout());

  
  String title[] = new String[3];  //���� ���̺� ����
  title[0] = "�л� �̸�";
  title[1] = "�л� ����";
  title[2] = "�л� ����";
  String data[][] = new String[0][0];
  
  table = new JTable(data, title);
  JScrollPane sp = new JScrollPane(table);
  sp.setPreferredSize(new Dimension(300, 200)); 

  panelTable.add(sp);

  
  btn1 = new JButton("�л� ���");
  btn1.addActionListener(this);
  panelNormal.add(btn1);

  btn2 = new JButton("�л� ����");
  btn2.addActionListener(this);
  panelNormal.add(btn2);

  btn3 = new JButton("�л� ���");
  btn3.addActionListener(this);
  panelNormal.add(btn3);

  btn4 = new JButton("������ ���");
  btn4.addActionListener(this);
  panelNormal.add(btn4);

  btn5 = new JButton("������  ���");
  btn5.addActionListener(this);
  panelNormal.add(btn5); //���� â ��ư  ����
  

  // �г� ����
  this.add(panelComboBox);
  this.add(panelList);
  this.add(panelTable);
  this.add(panelNormal);

  this.setVisible(true);
 }
 
 
 

 public void refreshTable() {
  String titleTemp[] = new String[3];
  titleTemp[0] = "�л� �̸�";
  titleTemp[1] = "�л� ����";
  titleTemp[2] = "�л� ����";

  int size = StuManager.list.size();
  String[][] dataStudentArray = new String[size][3];

  for (int i = 0; i < size; i++) {
   Stu dataStudent = StuManager.list.get(i); //����Ʈ�� ����

   dataStudentArray[i][0] = dataStudent.name;
   dataStudentArray[i][1] = dataStudent.gender;
   dataStudentArray[i][2] = dataStudent.age;
  }

  table.setModel(new DefaultTableModel(dataStudentArray, titleTemp));
 }
 
 
 

 @Override
 public void actionPerformed(ActionEvent e) {

  if (e.getSource() == btn1) {
   new InputStud();
  }
  if (e.getSource() == btn2) {
   if (table.getSelectedRow() == -1) {
   } else {
    int deleteIndex = table.getSelectedRow();

    StuManager.list.remove(deleteIndex);
    this.refreshTable();
   }
  }
  if (e.getSource() == btn3) {
   String titleTemp[] = new String[3];
   titleTemp[0] = "�л� �̸�";
   titleTemp[1] = "�л� ����";
   titleTemp[2] = "�л� ����";

   int size = StuManager.list.size();
   String[][] dataStudentArray = new String[size][3];

   for (int i = 0; i < size; i++) {
    Stu dataStudent = StuManager.list.get(i);

    dataStudentArray[i][0] = dataStudent.name;
    dataStudentArray[i][1] = dataStudent.gender;
    dataStudentArray[i][2] = dataStudent.age;
   }

   table.setModel(new DefaultTableModel(dataStudentArray, titleTemp));
  }
  if (e.getSource() == btn4) {
   new InputPro();
  }
  if (e.getSource() == btn5) {
   new ProPrint();
  }
 }
}//���� â ��ü




class ProPrint extends JFrame implements ActionListener {
 JButton btn1 = null;
 JButton btn2 = null;
 JTable table = null;
 JTable table2 = null;
 
 ArrayList<Stu> temp_list;
 public ProPrint() {
  super("������ ���");
//  this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  this.setVisible(true);
  this.setBounds(200, 200, 500, 600);
  this.setLayout(new FlowLayout());

  JPanel panelPrint = new JPanel();
  JPanel panelButton = new JPanel();
  JPanel panelRelated = new JPanel();
  
  panelPrint.setLayout(new FlowLayout());
  panelButton.setLayout(new FlowLayout());
  panelRelated.setLayout(new FlowLayout());
  
  String title[] = new String[3];
  title[0] = "�̸�";
  title[1] = "����";
  title[2] = "����"; //������ ��� â�� ��������� ���̺�



  int size = ProManager.list.size();
  String[][] dataProArray = new String[size][3];

  for (int i = 0; i < size; i++) {
   Pro dataPro = ProManager.list.get(i);

   dataProArray[i][0] = dataPro.name;
   dataProArray[i][1] = dataPro.gender;
   dataProArray[i][2] = dataPro.age; //������ �� �ֱ�
  }

  
  table = new JTable(dataProArray, title);
  JScrollPane sp = new JScrollPane(table);
  sp.setPreferredSize(new Dimension(300, 200));
  panelPrint.add(sp); //������ ��� â
  
  btn1 = new JButton("���� �л� ���� ���");
  btn1.addActionListener(this);
  panelButton.add(btn1);

  btn2 = new JButton("Ȯ��");
  btn2.addActionListener(this);
  panelButton.add(btn2);
  
  
  String data[][] = new String[0][0];
  table2 = new JTable(data,title);
  JScrollPane sp2 = new JScrollPane(table2);
  sp2.setPreferredSize(new Dimension(300, 200));
  panelRelated.add(sp2); 
  
  this.add(panelPrint);
  this.add(panelButton);
  this.add(panelRelated);
  this.setVisible(true); //������ ��� â
 }
 
 
 
 

 public void refreshTable(){
  String titleTemp[] = new String[3];
  titleTemp[0] = "�̸�";
  titleTemp[1] = "����";
  titleTemp[2] = "����";
  int size = temp_list.size();
  String[][] dataStudentArray = new String[size][3];

  for (int i = 0; i < size; i++) {
   Stu dataStudent = temp_list.get(i);

   dataStudentArray[i][0] = dataStudent.name;
   dataStudentArray[i][1] = dataStudent.gender;
   dataStudentArray[i][2] = dataStudent.age;
  }

  table2.setModel(new DefaultTableModel(dataStudentArray, titleTemp));
 }
 //������ ��� â�� �ߴ� ���̺� 
 
 
 @Override
 public void actionPerformed(ActionEvent e) {
  if(e.getSource()==btn1){
   if (table.getSelectedRow() == -1) {
   } else {
    int deleteIndex = table.getSelectedRow();
    Pro temp = ProManager.list.get(deleteIndex);
    temp_list = new ArrayList<Stu>();
    for(Stu s : StuManager.list){
     if(s.teacher.equals(temp.name)){
      temp_list.add(s);
     }
    }


    this.refreshTable();
   }
  }
  if(e.getSource()==btn2){
   dispose();
  }
  
 }//�� ����
}//������ ��� â



class InputStud extends JFrame implements ActionListener {

 JLabel name, age, teacher;
 JTextField name_t, age_t;
 JRadioButton male, female;
 JComboBox professor_combo;
 JButton btn1, btn2;
 ButtonGroup group;

 public InputStud() {
  super("�л� �Է�"); //�л� �Է��ϴ� â
//  this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //setvisible
  this.setVisible(true);
  this.setBounds(200, 200, 250, 300);
  this.setLayout(new FlowLayout());

  JPanel panelName = new JPanel(); //�̸� ���� ĭ
  JPanel panelRadio = new JPanel(); //���� ����
  JPanel panelAge = new JPanel(); //���� ����
  JPanel panelCombo = new JPanel(); //������ ����
  JPanel panelButton = new JPanel(); //Ȯ�� ��� ��ư

  panelName.setLayout(new FlowLayout());
  panelRadio.setLayout(new FlowLayout());
  panelAge.setLayout(new FlowLayout());
  panelCombo.setLayout(new FlowLayout());
  panelButton.setLayout(new FlowLayout());

  name = new JLabel("�̸� : ");
  age = new JLabel("���� : ");
  teacher = new JLabel("������ : ");
  name_t = new JTextField(10);
  age_t = new JTextField(10);
  professor_combo = new JComboBox();
  male = new JRadioButton("����", false);
  female = new JRadioButton("����", false);
  btn1 = new JButton("Ȯ��");
  btn2 = new JButton("���");
  btn1.addActionListener(this);
  btn2.addActionListener(this);
  group = new ButtonGroup();
  group.add(male);
  group.add(female); //â�� �ߴ� ������

  for (Pro p : ProManager.list) {
   professor_combo.addItem(p.name);
  }

  panelName.add(name);
  panelName.add(name_t);

  panelRadio.add(male);
  panelRadio.add(female);

  panelAge.add(age);
  panelAge.add(age_t);

  panelCombo.add(teacher);
  panelCombo.add(professor_combo);

  panelButton.add(btn1);
  panelButton.add(btn2); 

  this.add(panelName);
  this.add(panelRadio);
  this.add(panelAge);
  this.add(panelCombo);
  this.add(panelButton, BorderLayout.SOUTH);

  this.setVisible(true); //�л� �Է��ϴ� â ������
 }

 @Override
 public void actionPerformed(ActionEvent e) {
  if (e.getSource() == btn1) {
   String str = (String) professor_combo.getSelectedItem();
   int selectedIndex = professor_combo.getSelectedIndex();
   String gender = "";
   if (male.isSelected()) {
    gender = male.getText().toString();
   } else {
    gender = female.getText().toString();
   }
   Stu s = new Stu(name_t.getText().toString().trim(), gender, age_t.getText().toString().trim(),str);
   StuManager.list.add(s);
   male.setSelected(false);
   female.setSelected(false);
   name_t.setText(null);
   age_t.setText(null);

  }
  if (e.getSource() == btn2) {
   dispose();
  }
 }

} //�Է� ��ư�� ������ ���� ���� 



class InputPro extends JFrame implements ActionListener {
 JLabel name, age, subject_l;
 JTextField name_t, age_t;
 JRadioButton male, female;
 JComboBox subject;
 JButton btn1, btn2;
 ButtonGroup group;

 public InputPro() {
  super("������ �Է�"); //������ �Է��ϴ� â

//  this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  this.setVisible(true);
  this.setBounds(200, 200, 250, 300);
  this.setLayout(new FlowLayout());

  JPanel panelName = new JPanel(); //�̸� ���� ĭ
  JPanel panelRadio = new JPanel(); //���� �����ϴ� ĭ
  JPanel panelAge = new JPanel(); //���� ���� ĭ
  JPanel panelCombo = new JPanel(); //���� �����ϴ� ĭ
  JPanel panelButton = new JPanel(); //Ȯ�� ��� ��ư

  panelName.setLayout(new FlowLayout());
  panelRadio.setLayout(new FlowLayout());
  panelAge.setLayout(new FlowLayout());
  panelCombo.setLayout(new FlowLayout());
  panelButton.setLayout(new FlowLayout());

  name = new JLabel("�̸� : ");
  age = new JLabel("���� : ");
  subject_l = new JLabel("���� : ");
  name_t = new JTextField(10);
  age_t = new JTextField(10);
  subject = new JComboBox();
  male = new JRadioButton("����", false);
  female = new JRadioButton("����", false);
  btn1 = new JButton("Ȯ��");
  btn2 = new JButton("���");
  btn1.addActionListener(this);
  btn2.addActionListener(this);//��ư ������
  group = new ButtonGroup();
  group.add(male);
  group.add(female);
  subject.addItem("C");
  subject.addItem("C++");
  subject.addItem("C#");
  subject.addItem("Python");
  subject.addItem("Java");
  subject.addItem("Swift");
  subject.addItem("Node.js");
  subject.addItem("React"); //������ ����� �� �����Ǵ� ����ǥ

  panelName.add(name);
  panelName.add(name_t);

  panelRadio.add(male);
  panelRadio.add(female);

  panelAge.add(age);
  panelAge.add(age_t);

  panelCombo.add(subject_l);
  panelCombo.add(subject);

  panelButton.add(btn1);
  panelButton.add(btn2);

  this.add(panelName);
  this.add(panelRadio);
  this.add(panelAge);
  this.add(panelCombo);
  this.add(panelButton, BorderLayout.SOUTH); //��ư �Ʒ��� �α�

  this.setVisible(true);

 }

 public void actionPerformed(ActionEvent e) {
  if (e.getSource() == btn1) {
   String str = (String) subject.getSelectedItem();
   int selectedIndex = subject.getSelectedIndex();
   String gender = "";
   if (male.isSelected()) {
    gender = male.getText().toString();
   } else {
    gender = female.getText().toString();
   }
   Pro p = new Pro(name_t.getText().toString().trim(), gender, age_t.getText().toString().trim(), str);
   ProManager.list.add(p);
   male.setSelected(false);
   female.setSelected(false);
   name_t.setText(null);
   age_t.setText(null);

  }
  if (e.getSource() == btn2) {
   dispose();
  }
 }
} //Ȯ���� ������ ��������


class Stu {
 String name;
 String gender;
 String age;
 String teacher; //���ڿ�

 public Stu(String name, String gender, String age,String teacher) {
  this.name = name;
  this.gender = gender;
  this.age = age;
  this.teacher = teacher; //������� ����
 }
}



class StuManager {
 public static ArrayList<Stu> list = new ArrayList<Stu>();
}//<stu>�� �� ��



class Pro {
 String name;
 String gender;
 String age;
 String subject; //���ڿ� 

 
 public Pro(String name, String gender, String age, String subject) {
  this.name = name;
  this.gender = gender;
  this.age = age;
  this.subject = subject; //
 }
}



class ProManager {
 public static ArrayList<Pro> list = new ArrayList<Pro>();
}