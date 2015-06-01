package gud;

import java.util.Arrays;
import java.util.Scanner;

public class tictactoe {
	static int mat[][] = new int[3][3];
	static int[] pos = new int[2];
	static int[] pos_win = new int[2];
	static int X = 1;
	static int O = -1;
	static int user_x = 0;
	static int user_y = 0;
	static int comp_x = 0;
	static int comp_y = 0;
	static boolean comp_won = false;
	static boolean user_won = false;
	static boolean user_move;
	static int moves = 0;
public static void main(String args[]){
		
		Scanner s = new Scanner(System.in);
		System.out.println("input the row and matrix u want to mark between 1 to 3");
		double first_move = Math.random();
		user_move = first_move>0.5? true : false ;
		while(moves<=9 && !comp_won && !user_won)
		{
		
		if(user_move){
		System.out.print("your turn : ");
		user_x = s.nextInt() - 1;
		user_y = s.nextInt() - 1;
		mat[user_x][user_y] = 1;
		user_move = false;
		}
		//comp move
		else{
			Arrays.fill(pos_win,-10);
			pos_win = check_win(-2);		//see if comp can win
			if(pos_win[0]>-1 && pos_win[1]>-1){
				
				mat[pos_win[0]][pos_win[1]] = -1;
				comp_x = pos_win[0];
				comp_y = pos_win[1];
				comp_won = true;
			}
			else{							//comp must mark
			pos_win = check_win(2);			//comp winning position
			if(pos_win[0]>-1 && pos_win[1]>-1){
				mat[pos_win[0]][pos_win[1]] = -1;
				comp_x = pos_win[0];
				comp_y = pos_win[1];
			}
			
			
			else if(mat[1][1] == 0 ){		//see if center is unmarked
				mat[1][1] = -1;
				comp_x = 1;
				comp_y = 1;
			}
			
			else{														//corner or plus
				if(mat[0][0]+mat[0][2]+mat[2][0]+mat[2][2]>=2){			//the two corner block
					if(mat[0][1]+mat[1][1]+mat[2][1]==-1){
						mat[0][1]=-1;
						comp_x = 0;
						comp_y = 1;
					}
					else{
						mat[1][0]=-1;
						comp_x = 1;
						comp_y = 0;
					}
				}
				
				else if(corner_free()>0){								//see if corner are free
					boolean marked = false;
					if((sum_diag1()<sum_diag2() || (mat[0][2]!=0 && mat[2][0]!=0)) && ( mat[0][0]==0 || mat[2][2]==0)){
						
						if(mat[0][0]==0)
						{ mat[0][0] = -1; 
						comp_x = 0;
						comp_y = 0;
						marked = true;
						}
						else if(mat[2][2]==0){
							comp_x = 2; comp_y =2;
							mat[2][2] = -1;
							marked = true;
						}
					}
					if(!marked){
						
						if(mat[0][2]==0)
						{ mat[0][2] = -1; comp_x = 0; comp_y =2;  }
						else if(mat[2][0]==0)
						{mat[2][0] = -1;
						
						comp_x = 2; comp_y =0;
						}
					}
						
				}
				
				else{											//in plus places
					
					boolean marked = false;
					if(sum_row(1)<=sum_column(1)){
						if( mat[1][0]==0){ mat[1][0]= -1; marked = true; comp_x = 1; comp_y =0; }
						else if( mat[1][2]==0){ mat[1][2]= -1; marked = true; comp_x = 1; comp_y =2;}
					}
					
					if(!marked) {
						if( mat[0][1]==0){ mat[0][1]= -1; marked = true; comp_x = 0; comp_y =1;}
						else if( mat[2][1]==0){ mat[2][1]= -1; marked = true;comp_x = 2; comp_y =1;}
					}
				}
				
			}
			
			
			}//comp must mark
			comp_x++;
			comp_y++;
		System.out.println(comp_x+" "+ comp_y);
		user_move = true;
		}//comp turn
		
		moves++;
		display();
		}//while
		
		if(comp_won){
			System.out.println("computer won");
		}
		else if(user_won){
			System.out.println("user won");
		}
		else{
			System.out.println("Its a draw");
		}
}

static int[] check_win(int val){
	Arrays.fill(pos,-10);
	if(moves>=3 ){
		//see if comp can win
		//row win
		for(int row=0;row<3;row++){
			if(sum_row(row)==val){
				for(int column=0;column<3;column++){
					if(mat[row][column]==0){
						pos[0]=row;
						pos[1]=column;
					}
				}
			}
		}
		//column win
		for(int column=0;column<3;column++){
			if(mat[0][column]+mat[1][column]+mat[2][column]==val){
				for(int row=0;row<3;row++){
					if(mat[row][column]==0){
						pos[0]=row;
						pos[1]=column;
					}
				}
			}
		}
		//positive diag win
		if(sum_diag1()==val){
			for(int rc=0;rc<3;rc++){
				if(mat[rc][rc]==0){
					pos[0]=rc;
					pos[1]=rc;
				}
			}
		}
		
		//negative diag win
		if(sum_diag2()==val){
			if(mat[0][2]==0){ pos[0]=0; pos[1]=2; }
			else if(mat[1][1]==0){ pos[0]=1; pos[1]=1; }
			else{ pos[0]=2; pos[1]=0; }
		}
	} //if moves
	return pos;
} //check_win()

static int sum_row(int row){
	return mat[row][0]+mat[row][1]+mat[row][2];
}

static int sum_column(int column){
	return mat[0][column]+mat[1][column]+mat[2][column];
}

static int sum_diag1(){
	return mat[0][0]+mat[1][1]+mat[2][2];
}

static int sum_diag2(){
	return mat[0][2]+mat[1][1]+mat[2][0];
}

static int corner_free(){
	int count = 0;
	if(mat[0][0]==0){count++;}
	if(mat[0][2]==0){count++;}
	if(mat[2][0]==0){count++;}
	if(mat[2][2]==0){count++;}
	return count;
}

static void display(){

	for(int i = 0;i<3;i++){
		for(int j=0;j<3;j++){
			char m = ' ';
			switch(mat[i][j]){
			case 0 : m = ' ';
			break;
			case 1 : m = 'X';
			break;
			case -1 : m = 'O';
			break;
			}
			System.out.print("|"+" "+m+" ");
		}
		System.out.print("|");
		System.out.println();
	}
}

}
