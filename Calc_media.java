package calc_media;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Autoria: Tânia Lobo Viana e Betânia Lobo Viana

public class Calc_media extends JFrame implements ActionListener{

private JLabel n1,n2,n3,n4, txtmedia, resultado;
private JTextField txtn1,txtn2,txtn3,txtn4, media,situacao;
private JButton bt_calc,bt_sair,bt_limpar;

public class Aluno {

public double nota1, nota2,nota3, nota4, med_aluno;

public double c_media(){

return (nota1+nota2+nota3+nota4)/4;
}

public String result(){
med_aluno = (nota1+nota2+nota3+nota4)/4;
if(med_aluno >= 6){
return "Aprovado";
}
else {
return "Reprovado";

}
}
}

public static void main(String[] args) {
     
Calc_media tmp = new Calc_media();
tmp.setTitle("CALCULAR MÉDIAS");
tmp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

tmp.setLayout(null);//Layout Manual

//Configuração do rótulo = Nota 1
tmp.n1 = new JLabel("Nota 1: ");
tmp.n1.setBounds(10,10,50,20);
tmp.add(tmp.n1);
//Configuração da caixa de texto para digitar a Nota1
tmp.txtn1 = new JTextField(5);
tmp.txtn1.setBounds(60,10,50,20);
tmp.add(tmp.txtn1);
//Configuração do 2º rótulo = Nota 2
tmp.n2 = new JLabel("Nota 2: ");
tmp.n1.setBounds(10,10,50,20);
tmp.n2.setBounds(10,40,50,20);
tmp.add(tmp.n2);

tmp.txtn2 = new JTextField(5);
tmp.txtn2.setBounds(60,40,50,20);
tmp.add(tmp.txtn2);

tmp.n3 = new JLabel("Nota 3: ");
tmp.n1.setBounds(10,10,50,20);
tmp.n3.setBounds(10,70,50,20);
tmp.add(tmp.n3);

tmp.txtn3 = new JTextField(5);
tmp.txtn3.setBounds(60,70,50,20);
tmp.add(tmp.txtn3);

//Configuração do rótulo = Nota 4
tmp.n4 = new JLabel("Nota 4: ");
tmp.n4.setBounds(10,100,50,20);
tmp.add(tmp.n4);
//Configuração da caixa de texto para digitar a Nota4
tmp.txtn4 = new JTextField(5);
tmp.txtn4.setBounds(60,100,50,20);
tmp.add(tmp.txtn4);
//Configuração do botão calcular
tmp.bt_calc = new JButton("Calcular");
tmp.bt_calc.setBounds(170,40,100,20);
tmp.add(tmp.bt_calc);
tmp.bt_calc.addActionListener(tmp);//Definindo ação ao botão
//Configuração do botão sair
tmp.bt_sair = new JButton("Sair");
tmp.bt_sair.setBounds(170,60,100,20);
tmp.add(tmp.bt_sair);
tmp.bt_sair.addActionListener(tmp);
//Configuração limpar
tmp.bt_limpar = new JButton("Limpar");
tmp.bt_limpar.setBounds(170,80,100,20);
tmp.add(tmp.bt_limpar);
tmp.bt_limpar.addActionListener(tmp);
//Configurando rótulo
tmp.resultado = new JLabel("Resultado");
tmp.resultado.setBounds(120,130,60,20);
tmp.add(tmp.resultado);
//configurando campo nedia
tmp.txtmedia = new JLabel("Média");
tmp.txtmedia.setBounds(10,130,50,20);
tmp.add(tmp.txtmedia);
tmp.media = new JTextField(5);
tmp.media.setBounds(60,130,50,20);
tmp.add(tmp.media);
//Configurando campo para aprovado e reprovado
tmp.situacao = new JTextField(10);
tmp.situacao.setBounds(180,130,90,20);
tmp.add(tmp.situacao);

tmp.setSize(300,240);
tmp.setVisible(true);

}

@Override//Ação do botão
   public void actionPerformed(ActionEvent ae){
String cmd = ae.getActionCommand();
if ( cmd.equals("Calcular")){//Quando clicar for igual a Calcular entra no IF
Aluno aux = new Aluno();//Estanciando aux na classe Aluno
String tmp;

aux.nota1=Double.parseDouble(txtn1.getText());//txtn1.getText() está buscando a informação no JTextField da nota1.
aux.nota2=Double.parseDouble(txtn2.getText());
aux.nota3=Double.parseDouble(txtn3.getText());
aux.nota4=Double.parseDouble(txtn4.getText());

double total = aux.c_media();//Armazenando em uma double o resultado do método media(), que está na classe Aluno
String result = aux.result();

tmp = String.format( "%2.2f" , total);//Formatando a String

media.setText(tmp);//SetText() envia iformações, media.setText(tmp) esta enviando o que contém na variável TMP.
situacao.setText(result);

  }else if(cmd.equals("Limpar")){//Se ele clicar em outro botão e esse mesmo for o Limpar irá cair no atual.

txtn1.setText("");
txtn2.setText("");
txtn3.setText("");
txtn4.setText("");
media.setText("");
situacao.setText("");

}else{
System.exit(0);
}
}

}