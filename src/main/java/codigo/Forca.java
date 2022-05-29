/*
Nome: Pedro Henrique Rocha de Castro e Thiago Rodrigues Valentim
Matricula: 
20213004828(Pedro)
20203015926(Thiago)
 */
package codigo;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Forca {
    private String palavraSorteada;
    private int tentativas;
    
    public Forca(){
        leArquivo();
        palavraSorteada=sorteiaPalavra();
        tentativas=10;//10 tentativas para acertar a palavra
    }
    
    //preenche os textos se a letra apertada no botão esteja na palavra sorteada
    public void preencheCampo(ArrayList<JTextField> campo, char letra){
        if(this.tentativas>=0){
           for(int i=0; i<palavraSorteada.length(); i++){
            if(palavraSorteada.charAt(i)==letra){
                campo.get(i).setText(letra+"");//"" para o char se tornar uma string
            }
            } 
        }
        else{//tentativas<0. Tentativas acabaram
           JOptionPane.showMessageDialog(null,"Tentativas esgotadas!! Reinicie o jogo");
           this.tentativas=0;
        }
           
    }
    //preenche os campos restantes para formar a palavra sorteada
    public void informaPalavra(ArrayList<JTextField> campo){
        int auxVencedor=0;
        
        for(int i=0; i<campo.size(); i++){
            if(campo.get(i).getText().equals(palavraSorteada.charAt(i)+"")){
                auxVencedor++;
            }
        }
        if(auxVencedor==7){
            JOptionPane.showMessageDialog(null,"Parabéns!! Você Venceu !!");
        }
        else{
            JOptionPane.showMessageDialog(null,"Errou !! Continue tentando");
            this.tentativas--;
        }
    }
    public static String sorteiaPalavra(){       
        Random seleciona;
        seleciona = new Random();
        int randomIndice;
        randomIndice=seleciona.nextInt(LerArquivo.palavras.size());//seleciona uma posicao aleatoria no ArrayList com as palavras do arquivo armazenadas.
        
        return LerArquivo.palavras.get(randomIndice);
    }
   
    public static void leArquivo(){
        LerArquivo.openFile();
        LerArquivo.readRecords();
        LerArquivo.closeFile();
    }

    public String getPalavraSorteada() {
        return palavraSorteada;
    }

    public void setPalavraSorteada(String palavraSorteada) {
        this.palavraSorteada = palavraSorteada;
    }

    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }
    
    

}
