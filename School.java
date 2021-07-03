package first;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
 JButton btn5 = null; //버튼 다섯개 생성
 JTable table = null; //테이블 생성

 public Test() {
  super("선생님 & 학생 관리 프로그램");
  this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  this.setBounds(300, 300, 600, 600);
  this.setLayout(new FlowLayout()); //메인 창 생성

  JPanel panelComboBox = new JPanel();
  JPanel panelList = new JPanel();
  JPanel panelTable = new JPanel();
  JPanel panelNormal = new JPanel();

  panelComboBox.setLayout(new FlowLayout());
  panelList.setLayout(new FlowLayout());
  panelTable.setLayout(new FlowLayout());
  panelNormal.setLayout(new FlowLayout());

  
  String title[] = new String[3];  //메인 테이블 생성
  title[0] = "학생 이름";
  title[1] = "학생 성별";
  title[2] = "학생 나이";
  String data[][] = new String[0][0];
  
  table = new JTable(data, title);
  JScrollPane sp = new JScrollPane(table);
  sp.setPreferredSize(new Dimension(300, 200)); 

  panelTable.add(sp);

  
  btn1 = new JButton("학생 등록");
  btn1.addActionListener(this);
  panelNormal.add(btn1);

  btn2 = new JButton("학생 삭제");
  btn2.addActionListener(this);
  panelNormal.add(btn2);

  btn3 = new JButton("학생 출력");
  btn3.addActionListener(this);
  panelNormal.add(btn3);

  btn4 = new JButton("선생님 등록");
  btn4.addActionListener(this);
  panelNormal.add(btn4);

  btn5 = new JButton("선생님  출력");
  btn5.addActionListener(this);
  panelNormal.add(btn5); //메인 창 버튼  생성
  

  // 패널 연결
  this.add(panelComboBox);
  this.add(panelList);
  this.add(panelTable);
  this.add(panelNormal);

  this.setVisible(true);
 }
 
 
 

 public void refreshTable() {
  String titleTemp[] = new String[3];
  titleTemp[0] = "학생 이름";
  titleTemp[1] = "학생 성별";
  titleTemp[2] = "학생 나이";

  int size = StuManager.list.size();
  String[][] dataStudentArray = new String[size][3];

  for (int i = 0; i < size; i++) {
   Stu dataStudent = StuManager.list.get(i); //리스트에 저장

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
   titleTemp[0] = "학생 이름";
   titleTemp[1] = "학생 성별";
   titleTemp[2] = "학생 나이";

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
}//메인 창 전체




class ProPrint extends JFrame implements ActionListener {
 JButton btn1 = null;
 JButton btn2 = null;
 JTable table = null;
 JTable table2 = null;
 
 ArrayList<Stu> temp_list;
 public ProPrint() {
  super("선생님 출력");
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
  title[0] = "이름";
  title[1] = "성별";
  title[2] = "나이"; //선생님 출력 창에 만들어지는 테이블



  int size = ProManager.list.size();
  String[][] dataProArray = new String[size][3];

  for (int i = 0; i < size; i++) {
   Pro dataPro = ProManager.list.get(i);

   dataProArray[i][0] = dataPro.name;
   dataProArray[i][1] = dataPro.gender;
   dataProArray[i][2] = dataPro.age; //저장한 값 넣기
  }

  
  table = new JTable(dataProArray, title);
  JScrollPane sp = new JScrollPane(table);
  sp.setPreferredSize(new Dimension(300, 200));
  panelPrint.add(sp); //선생님 출력 창
  
  btn1 = new JButton("관련 학생 정보 출력");
  btn1.addActionListener(this);
  panelButton.add(btn1);

  btn2 = new JButton("확인");
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
  this.setVisible(true); //선생님 출력 창
 }
 
 
 
 

 public void refreshTable(){
  String titleTemp[] = new String[3];
  titleTemp[0] = "이름";
  titleTemp[1] = "성별";
  titleTemp[2] = "나이";
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
 //선생님 출력 창에 뜨는 테이블 
 
 
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
  
 }//값 저장
}//선생님 출력 창



class InputStud extends JFrame implements ActionListener {

 JLabel name, age, teacher;
 JTextField name_t, age_t;
 JRadioButton male, female;
 JComboBox professor_combo;
 JButton btn1, btn2;
 ButtonGroup group;

 public InputStud() {
  super("학생 입력"); //학생 입력하는 창
//  this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //setvisible
  this.setVisible(true);
  this.setBounds(200, 200, 250, 300);
  this.setLayout(new FlowLayout());

  JPanel panelName = new JPanel(); //이름 적는 칸
  JPanel panelRadio = new JPanel(); //성별 선택
  JPanel panelAge = new JPanel(); //나이 적기
  JPanel panelCombo = new JPanel(); //선생님 선택
  JPanel panelButton = new JPanel(); //확인 취소 버튼

  panelName.setLayout(new FlowLayout());
  panelRadio.setLayout(new FlowLayout());
  panelAge.setLayout(new FlowLayout());
  panelCombo.setLayout(new FlowLayout());
  panelButton.setLayout(new FlowLayout());

  name = new JLabel("이름 : ");
  age = new JLabel("나이 : ");
  teacher = new JLabel("선생님 : ");
  name_t = new JTextField(10);
  age_t = new JTextField(10);
  professor_combo = new JComboBox();
  male = new JRadioButton("남자", false);
  female = new JRadioButton("여자", false);
  btn1 = new JButton("확인");
  btn2 = new JButton("취소");
  btn1.addActionListener(this);
  btn2.addActionListener(this);
  group = new ButtonGroup();
  group.add(male);
  group.add(female); //창에 뜨는 종류들

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

  this.setVisible(true); //학생 입력하는 창 마지막
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

} //입력 버튼을 누르면 정보 저장 



class InputPro extends JFrame implements ActionListener {
 JLabel name, age, subject_l;
 JTextField name_t, age_t;
 JRadioButton male, female;
 JComboBox subject;
 JButton btn1, btn2;
 ButtonGroup group;

 public InputPro() {
  super("선생님 입력"); //선생님 입력하는 창

//  this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  this.setVisible(true);
  this.setBounds(200, 200, 250, 300);
  this.setLayout(new FlowLayout());

  JPanel panelName = new JPanel(); //이름 적는 칸
  JPanel panelRadio = new JPanel(); //성별 선택하는 칸
  JPanel panelAge = new JPanel(); //나이 적는 칸
  JPanel panelCombo = new JPanel(); //과목 선택하는 칸
  JPanel panelButton = new JPanel(); //확인 취소 버튼

  panelName.setLayout(new FlowLayout());
  panelRadio.setLayout(new FlowLayout());
  panelAge.setLayout(new FlowLayout());
  panelCombo.setLayout(new FlowLayout());
  panelButton.setLayout(new FlowLayout());

  name = new JLabel("이름 : ");
  age = new JLabel("나이 : ");
  subject_l = new JLabel("과목 : ");
  name_t = new JTextField(10);
  age_t = new JTextField(10);
  subject = new JComboBox();
  male = new JRadioButton("남자", false);
  female = new JRadioButton("여자", false);
  btn1 = new JButton("확인");
  btn2 = new JButton("취소");
  btn1.addActionListener(this);
  btn2.addActionListener(this);//버튼 상세정보
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
  subject.addItem("React"); //선생님 등록할 때 배정되는 과목표

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
  this.add(panelButton, BorderLayout.SOUTH); //버튼 아래에 두기

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
} //확인을 누르면 정보저장


class Stu {
 String name;
 String gender;
 String age;
 String teacher; //문자열

 public Stu(String name, String gender, String age,String teacher) {
  this.name = name;
  this.gender = gender;
  this.age = age;
  this.teacher = teacher; //멤버변수 선언
 }
}



class StuManager {
 public static ArrayList<Stu> list = new ArrayList<Stu>();
}//<stu>에 값 들어감



class Pro {
 String name;
 String gender;
 String age;
 String subject; //문자열 

 
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
