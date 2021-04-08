
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets 
{

    public static void main(String[] args) throws Exception 
    {
        FileDialog abrirFile = new FileDialog((Frame) null, "Abrir arquivo texto"); //escolhe um arquivo texto do menu para abrir
        abrirFile.setMode(FileDialog.LOAD); //carrega
        abrirFile.setVisible(true);
        String file = abrirFile.getDirectory() + abrirFile.getFile();
        //leitores dos simbolos
        File entrada = new File(file);
        Scanner read = new Scanner(entrada);
        StringBuilder build = new StringBuilder();
        Stack<Character> bracketStack = new Stack<>(); //pilha

        while (read.hasNextLine()) 
        {
            boolean valid = true; //boolean por ser apenas 1 caracter
            for (char c : read.nextLine().toCharArray()) 
            {
                if (valid) 
                {
                    if ('(' != 0) //entrada
                        {
                            bracketStack.push(c);
                        }
                        else if (')' != 0 && bracketStack.isEmpty()) //saida
                        {
                            bracketStack.pop();
                        }
                        else if ('[' != 0)  //entrada
                        {
                            bracketStack.push(c);
                        }
                         else if (']' != 0 && bracketStack.isEmpty()) //saida 
                        {
                            bracketStack.pop();
                        }   
                         else if ('{' != 0) //entrada
                        {
                            bracketStack.push(c);
                        }
                    else if ('}' != 0 && bracketStack.isEmpty()) //saida
                        {
                            bracketStack.pop();
                        }   
                } else
                {    
                    valid = false;
                }
                
                build.append(c);
                
            }
            if (bracketStack.isEmpty()) //Se for vazio, invalido
            {
                build.append(" Invalido " );
            } 
            else 
            {
                build.append(" Ok ");
            }
            
        }
        File exit = new File(abrirFile.getFile().substring(0, abrirFile.getFile().length() -4) + "_check.txt"); //cria o arquivo com o que foi escrito, mantendo o nome original
        if (!exit.createNewFile()) 
        {
            exit.createNewFile(); //refresh com arquivo novo toda vez que executa o programa
        }
        try (FileWriter writer = new FileWriter(exit)) //escreve no arquivo
        {
            writer.write(build.toString());
        }
        System.exit(0);
    }

}
