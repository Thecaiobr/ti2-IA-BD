import java.util.*;
public class somarDoisNumeros {
	
		public static Scanner sc = new Scanner(System.in); 
		
		public static void main(String arrgs[]) {
			//declara��o de variaveis
			int num1, num2, soma;
			
			//leituras
			System.out.println("Digite um n�mero: ");
			num1 = sc.nextInt();
			System.out.println("Digite outro n�mero: ");
			num2 = sc.nextInt();
			
			//somar
			soma = num1 + num2;
			
			//mostrar na tela
			System.out.println("Soma: " + soma);
			
		}
	
}
