package proj1;
/**
 * Name: Eliot Carney-Seim
 *
 *
 */

//ME
public class ConnectFour {
	private boolean DEBUG = false;
	//HELPER METHODS------------------------------------------------------------	
	/**
	 * @param args
	 */
	private static void say(String string){
		System.out.printf(string);
	}
	private static void debug(String message,boolean toDebug){
		if(toDebug){
			say("\t~~"+"("+ message+")\n");
		}
	}

	

	//CONSTRUCTOR---------------------------------------------------------------
	int columns;
	int rows; 
	private String[][] gridMain;
	private int[][] p1Moves;
	private int[][] p2Moves;
	private int moveNum = 0; //used to help quantify which move we're on.
							 //becomes 1 after 2nd player finishes turn, etc.
	private String playerTurn = "Player1";
	
	ConnectFour(int columns, int rows){
		if(columns < 5 || rows < 5){
			String defaultMsg = "Invalid input and/or width entered. " +
					"Setting default size to 5x5." ;
			debug(defaultMsg, DEBUG);
			this.columns = 5;
			this.rows = 5;
		}
		else{
			this.columns = columns;
			this.rows = rows;
		}
		debug("ConnectFour object created!", DEBUG);
		debug("It has " +this.columns+ " columns, and "+this.rows+ " rows ", DEBUG);
		gridMain = new String[columns][rows];
		// the first array is the turn, the second is a 'tuple' of the x,y move
		p1Moves = new int[(columns*rows)][2];
		p2Moves = new int[(columns*rows)][2];
		
		
		// gridMain must be filled with empty slots.
		for(int x= 0; x < columns; x += 1){
			for(int y = 0; y < rows; y += 1){
				gridMain[x][y] = "_";
			}
		}
	}


	
	
	public void addPiece(int column, int row, String piece){
		
		debug(("" + column + ", " + row), DEBUG);
		//with the given column, check the row, and see if we get a match to _
		//if we do, call addPiece again, with column + 1. Keep calling addPiece
		//until either we extend past the column size, or a no-match for _.
		if(row > this.rows -1 || row <= -1 || 
				column > this.columns-1 || column<= -1){
			String defaultMsg = "Invalid column or row input entered. " +
					"Default Action: add nothing." ;
			debug(defaultMsg, DEBUG);
			return;
		}
		
		
		//recursion!!
		//if the next row goes off the board
		if((row+1 > this.rows -1)){
			//compare current row to see if it's empty
			//if empty: add piece
			if(gridMain[column][row].equals("_")){ 
				debug((""+(row)+" is a valid row to add a piece"), DEBUG);
				gridMain[column][row] = piece;
				// add to the list of moves.
				if(piece.equals("x")){
					p1Moves[moveNum][0] = 1+ column;
					p1Moves[moveNum][1] = 1+ row;
					changeTurn();
				}
				else{
					p2Moves[moveNum][0] = 1+ column;
					p2Moves[moveNum][1] = 1+ row;
					changeTurn();
				}
			}
			else{
				//if NOT empty: add piece at row-1
				gridMain[column][row-1] = piece;
				// add to the list of moves.
				if(piece.equals("x")){
					p1Moves[moveNum][0] = 1+ column;
					p1Moves[moveNum][1] = 1+ row-1;
					changeTurn();
				}
				else{
					p2Moves[moveNum][0] = 1+ column;
					p2Moves[moveNum][1] = 1+ row-1;
					changeTurn();
				}
			}
		}
		//if the next row does NOT go off the board
		else{
			//compare current row to see if it's empty
			if(gridMain[column][row].equals("_")){
				//if empty: recursively call addPiece, with row+1
				addPiece(column, row+1, piece);
				
			}
			//if current row is NOT empty, make sure it isn't the first row
			else{
				//if row is not top row:
				if(row != 0){
					// add to previous row, which we already know is empty
					gridMain[column][row-1] = piece;
					// add to the list of moves.
					if(piece.equals("x")){
						p1Moves[moveNum][0] = 1+ column;
						p1Moves[moveNum][1] = 1+ row-1;
						changeTurn();
					}
					else{
						p2Moves[moveNum][0] = 1+ column;
						p2Moves[moveNum][1] = 1+ row-1;
						changeTurn();
					}
				}
				// if row IS the top row
				else{
					// let the user know they failed.
					say("\nSorry, can't put a piece there, column full\n");
					changeTurn();
				}
			}
		}
		
	}
	
	//HELPER FUNCTIONS FOR HASWINNER---VVV--------------------------------------
	private boolean checkHorizontal(String tPiece){
		int success = 0;
		debug(("Checking for winner using: H"+ tPiece), DEBUG);
		for(int y = 0; y < rows; y++){
			for (int x = 0; x < columns; x++){
				// if we get a match 4 times in succession, then game is over.
				if(gridMain[x][y].equals(tPiece)){
					success++;
				}
				else{
					success = 0;
				}
				if(success == 4){
					return true;
				}
			}
			success = 0; //needs to be reset after each column.
		}
		return false;
	}
	private boolean checkVertical(String tPiece){
		int success = 0;
	
		debug(("Checking for winner using: V"+ tPiece), DEBUG);
		for(int x = 0; x < columns; x++){
			for (int y = 0; y < rows; y++){
				// if we get a match 4 times in succession, then game is over.
				if(gridMain[x][y].equals(tPiece)){
					success++;
				}
				else{
					success = 0;
				}
				if(success == 4){
					return true;
				}
			}
			//needs to be reset after each row.
			success = 0;
		}
		return false;
	}
	private boolean checkDiagonalUp(String tPiece){
		int success = 0;
		int y;
		int x;
		debug(("Checking for winner using: DU"+ tPiece), DEBUG);
		debug("DU Check 1", DEBUG);
		for(x = columns - 4; x > 0; x--){
			y = rows -1;
			for(int xy = 0; (xy+x<columns && y-xy>=0); xy++){
				//debugging
				if(moveNum > 6 && DEBUG){
					debug(("Testing for: "+ "("+(x+xy)+", "+(y-xy)+")"), DEBUG);
				}
				if(gridMain[x+xy][y-xy].equals(tPiece)){
					success ++;
					debug(("Good"+success), DEBUG);
				}else{
					debug("BadMatch", DEBUG);
					success = 0;
				}
				if(success==4){
					return true;
				}
			}
			debug("Next, reset", DEBUG);
			success = 0;
		}
		success = 0;
		debug("DU Check 2", DEBUG);
		for(y = rows-1; y >= 0; y --){
			x = 0;
			for(int xy=0; (xy+x<columns && y-xy>=0); xy++){
				if(moveNum > 6 && DEBUG){
					debug(("Testing for: "+ "("+(x+xy)+", "+(y-xy)+")"), DEBUG);
				}
				if(gridMain[x+xy][y-xy].equals(tPiece)){
					success ++;
					debug(("Good"+success), DEBUG);
				}else{
					debug("BadMatch", DEBUG);
					success = 0;
				}
				if(success==4){
					return true;
				}
			}
			debug("Next, reset", DEBUG);
			success = 0;
		}
		return false;
	}
	private boolean checkDiagonalDown(String tPiece){
		int success = 0;
		int y;
		int x;
		debug(("Checking for winner using: DD"+ tPiece), DEBUG);
		debug("DD Check 1", DEBUG);
		for(x = 3; x < columns; x++){
			y = rows -1;
			for(int xy = 0; (x-xy>=0 && y-xy>=0); xy++){
				//debugging
				if(moveNum > 6 && DEBUG){
					debug(("Testing for: "+ "("+(x-xy)+", "+(y-xy)+")"), DEBUG);
				}
				if(gridMain[x-xy][y-xy].equals(tPiece)){
					success ++;
					debug(("Good"+success), DEBUG);
				}else{
					debug("BadMatch", DEBUG);
					success = 0;
				}
				if(success==4){
					return true;
				}
			}
			debug("Next, reset", DEBUG);
			success = 0;
		}
		success = 0;
		debug("DD Check 2", DEBUG);
		for(y = rows-1; y >= 0; y --){
			x = columns - 1;
			for(int xy=0; (y-xy>=0 && x-xy>=0); xy++){
				if(moveNum > 6 && DEBUG){
					debug(("Testing for: "+ "("+(x-xy)+", "+(y-xy)+")"), DEBUG);
				}
				if(gridMain[x-xy][y-xy].equals(tPiece)){
					success ++;
					debug(("Good"+success), DEBUG);
				}else{
					debug("BadMatch", DEBUG);
					success = 0;
				}
				if(success==4){
					return true;
				}
			}
			debug("Next, reset", DEBUG);
			success = 0;
		}
		return false;
	}
	//HELPER FUNCTIONS FOR HASWINNER---^^^--------------------------------------
	
	
	public boolean hasWinnner() {
		String tPiece;
		if(playerTurn.equals("Player1")){
			tPiece = "o";
		}
		else{
			tPiece = "x";
		}
		boolean winCheck = false;
		if(checkHorizontal(tPiece)){
			winCheck = true;
		}
		if(checkVertical(tPiece)){
			winCheck = true;
		}
		if(checkDiagonalUp(tPiece)){
			winCheck = true;
		}
		if(checkDiagonalDown(tPiece)){
			winCheck = true;
		}
		return winCheck;
	}
	
	
	/**
	 * @param playerTurn the playerTurn to set
	 */
	private void changeTurn(){
		if(playerTurn.equals("Player1")){
			playerTurn = "Player2";
		}
		else{
			playerTurn = "Player1";
			moveNum++;
		}
	}
	/**
	 * 
	 * @return the getTurn
	 */
	public String getTurn(){
		return playerTurn;
	}
	public void printBoard(){
		String columnStr = "";
		for(int y = 0; y < this.rows; y += 1){
			for(int x = 0; x < this.columns; x += 1)
				columnStr = columnStr + gridMain[x][y];
			columnStr = columnStr + "\n";
		}
		say("\n"+columnStr+"\n");
		if(DEBUG){
			say("Turn Number: "+moveNum);
			//show moves made so far
			say("\nPlayer1's moves so far:");
			String tempString;
			for(int turn = 0; turn < moveNum; turn += 1){
				tempString = "("+p1Moves[turn][0]+", "+p1Moves[turn][1]+")";
				say("\n"+tempString);
			}
			say("\nPlayer2's moves so far:");
			tempString = "";
			for(int turn = 0; turn < moveNum; turn += 1){
				tempString = "("+p2Moves[turn][0]+", "+p2Moves[turn][1]+")";
				say("\n"+tempString);
				
			}
		}
	}
	
	//ACCESSORS AND MODIFIERS---------------------------------------------------
	/**
	 * @return the gridMain
	 */
	public String[][] getGridMain() {
		return gridMain;
	}
	/**
	 * @param gridMain the gridMain to set
	 */
	public void setGridMain(String[][] gridMain) {
		this.gridMain = gridMain;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return columns;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return rows;
	}
}
