import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class GameTests {
	int W = 4;
	int H = 8;
	int W2 = 5;
	int H2 = 9;
	Rock Rock1 = new Rock(W, H);
	Rock Rock2 = new Rock(W2, H2);
	@Test
	public void Rock_Constructor_GetX_GetY_Test() {
		assertTrue("xCoord must be between 0 and " + Integer.toString(W), 0 <= Rock1.getX() && Rock1.getX() < W);
		assertEquals("yCoord must be 0", 0, Rock1.getY());
		assertEquals("Model must be O", "O", Rock1.toString());
	}
	
	@Test
	public void Rock_Constructor_GetX_GetY_Test2() {
		assertTrue("xCoord must be between 0 and " + Integer.toString(W), 0 <= Rock2.getX() && Rock2.getX() < W2);
		assertEquals("yCoord must be 0", 0, Rock1.getY());
		assertEquals("Model must be O", "O", Rock1.toString());
	}
	
	@Test
	public void Rock_ToString_Test() {
		assertEquals("Model must be O", "O", Rock1.toString());
	}
	
	@Test
	public void Rock_ToString_Test2() {
		assertEquals("Model must be O", "O", Rock2.toString());
	}
	
	@Test
	public void Rock_MoveRock_SetY_Test() {
		Rock1.moveRock();
		assertEquals("yCoord must be 1", 1, Rock1.getY());
		
	}
	
	@Test
	public void Rock_MoveRock_SetY_Test2() {
		Rock2.moveRock();
		assertEquals("yCoord must be 1", 1, Rock2.getY());
		
	}
	
	@Test
	public void Rock_SetX_Test() {
		int X = Rock1.getX();
		Rock1.setxCoord(Rock1.getX() + 1);
		assertEquals("xCoord must be " + Integer.toString(X + 1), X + 1, Rock1.getX());
	}
	
	@Test
	public void Rock_SetX_Test2() {
		int X = Rock2.getX();
		Rock2.setxCoord(Rock2.getX() + 1);
		assertEquals("xCoord must be " + Integer.toString(X + 1), X + 1, Rock2.getX());
	}
	
	Player Player1 = new Player(H, W);
	Player Player2 = new Player(H2,W2);
	long createTime = System.currentTimeMillis();
	
	@Test
	public void Player_Constructor_GetX_GetY_GetScore_GetTime_Test() {
		assertEquals("Xcoord must be " + Integer.toString(W/2), W/2, Player1.getX());
		assertEquals("Ycoord must be " + Integer.toString(H), H, Player1.getY());
		assertEquals("Model must be X", "X", Player1.toString());
		assertEquals("Score must be 0", 0, Player1.getScore());
		assertTrue("Time difference must be 0 or 1", 0 <= Player1.getTime() && Player1.getTime() < 2);
	}
	
	@Test
	public void Player_Constructor_GetX_GetY_GetScore_GetTime_Test2() {
		assertEquals("Xcoord must be " + Integer.toString(W2/2), W2/2, Player2.getX());
		assertEquals("Ycoord must be " + Integer.toString(H2), H2, Player2.getY());
		assertEquals("Model must be X", "X", Player2.toString());
		assertEquals("Score must be 0", 0, Player2.getScore());
		assertTrue("Time difference must be 0 or 1", 0 <= Player2.getTime() && Player2.getTime() < 2);
	}
	
	@Test
	public void Player_ToString_Test() {
		assertEquals("Model must be X", "X", Player1.toString());
	}
	
	@Test
	public void Player_ToString_Test2() {
		assertEquals("Model must be X", "X", Player2.toString());
	}
	
	
	@Test
	public void Player_SetY_Test() {
		Player1.setYcoord(0);
		assertEquals("Ycoord must be 0", 0, Player1.getY());
	}
	
	@Test
	public void Player_SetY_Test2() {
		Player1.setYcoord(3);
		assertEquals("Ycoord must be 3", 3, Player1.getY());
	}
	
	@Test
	public void Player_SetX_Test() {
		Player1.setXcoord(0);
		assertEquals("Xcoord must be 0", 0, Player1.getX());
	}
	
	@Test
	public void Player_SetX_Test2() {
		Player1.setXcoord(3);
		assertEquals("Xcoord must be 3", 3, Player1.getX());
	}
	
	@Test
	public void Player_MoveLeft_Test() {
		Player1.moveLeft();
		assertEquals("Xcoord must be " + Integer.toString((W/2) - 1), (W/2) - 1, Player1.getX());
		assertEquals("Score must be 1", 1, Player1.getScore());
	}
	
	@Test
	public void Player_MoveLeft_Test2() {
		Player2.moveLeft();
		assertEquals("Xcoord must be " + Integer.toString((W2/2) - 1), (W2/2) - 1, Player2.getX());
		assertEquals("Score must be 1", 1, Player2.getScore());
	}
	
	@Test
	public void Player_MoveRight_Test() {
		Player1.moveRight();
		assertEquals("Xcoord must be " + Integer.toString((W/2) + 1), (W/2) + 1, Player1.getX());
		assertEquals("Score must be 1", 1, Player1.getScore());
		
	}
	
	@Test
	public void Player_MoveRight_Test2() {
		Player2.moveRight();
		assertEquals("Xcoord must be " + Integer.toString((W2/2) + 1), (W2/2) + 1, Player2.getX());
		assertEquals("Score must be 1", 1, Player2.getScore());
		
	}
	
	Board Board1 = new Board(100);
	
	@Test
	public void Board_Constructor_Test() {
		assertEquals("Difficulty must be 100", 100, Board1.difficulty);
		assertEquals("Timer must be 150", 150, Board1.timer);
		assertEquals("Lost must be False", false, Board1.lost);
		assertEquals("player score must be 0", 0, Board1.player.getScore());
		assertEquals("Rocks must be length 0", 0, Board1.getRocks().size());
		assertEquals("Screen must be length 20", 20, Board1.getScreen().length);
	}
	
	@Test
	public void Board_SetTimer_Test(){
		Board1.setTimer(1);
		assertEquals("Timer must be 1", 1, Board1.timer);
	}
	
	@Test
	public void Board_ProcessChar_Test() {
		Board1.takeTurn('o');
		assertEquals("Player Xcoord must be 9", 9, Board1.player.getX());
		Board1.takeTurn('p');
		assertEquals("Player Xcoord must be 10", 10, Board1.player.getX());
		Board1.takeTurn('k');
		assertEquals("Player Score must be 3", 3, Board1.player.getScore());
		Board1.takeTurn('j');
		assertEquals("Player Score must be 3", 3, Board1.player.getScore());
	}
	
	@Test
	public void Board_TakeTurn_Test() {
		Board1.takeTurn('o');
		assertTrue("Rocks length must be > 0", Board1.getRocks().size() > 0);
		assertEquals("Player Xcoord must be 9", 9, Board1.player.getX());
		Board1.takeTurn('o');
		assertEquals("Rock height must be 2", 2, Board1.getRocks().get(0).getY());
		Board1.setLoseTime(.5);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("Sleep problem");
		}
		Board1.takeTurn('o');
		assertEquals("Lost must be true", true, Board1.lost);
	}
	
	@Test
	public void Board_SpawnRock_Test() {
		Board1.takeTurn('o');
		assertTrue("Rocks length must be > 0", Board1.getRocks().size() > 0);
	}
	
	@Test
	public void Board_RemoveRock_Test() {
		Board1.takeTurn('o');
		Board1.player.setXcoord(-1);
		for(int r = 0; r < (Board1.getRocks().size() - 1); r++){
			Board1.getRocks().get(r).setyCoord(19);
		}
		Board1.takeTurn('k');
		for(int r = 0; r < (Board1.getRocks().size() - 1); r++){
			assertEquals("All rocks must have yCoord 1", 1, Board1.getRocks().get(r).getY());
		}
	}
	
	@Test
	public void Board_MoveLeft_Test() {
		for(int i = 0; i < 12; i++) {
			Board1.takeTurn('o');
		}
		assertEquals("Screen[19] must be X followed by spaces", "X                   ", Board1.getScreen()[19].toString());
		assertEquals("Xcoord must be 0", 0 , Board1.player.getX());
		Board1.player.setXcoord(-1);
		Board1.takeTurn('p');
		assertEquals("Xcoord must be 0", 0 , Board1.player.getX());
	}

	@Test
	public void Board_MoveRight_Test() {
		for(int i = 0; i < 12; i++) {
			Board1.takeTurn('p');
		}
		assertEquals("Screen[19] must be spaces followed by X", "                   X", Board1.getScreen()[19].toString());
		assertEquals("Xcoord must be 19", 19 , Board1.player.getX());
		Board1.player.setXcoord(20);
		Board1.takeTurn('o');
		assertEquals("Xcoord must be 19", 19 , Board1.player.getX());
	}

	@Test
	public void Board_MoveRocks_Test() {
		Board1.takeTurn('o');
		String rocks = Board1.getScreen()[1].toString();
		Board1.takeTurn('p');
		assertEquals("Screen[2] must equal previous screen[1]", rocks, Board1.getScreen()[2].toString());
		for(int i = 0; i < 1000; i++) {
			Board1.takeTurn('o');
			if (Board1.lost == true){
				break;
			}
		}
		assertEquals("Lost must be true", true, Board1.lost);
	}
	
//	@Test
//	public void Board_TakeTurn_ProcessChar_Test5() {
//		try:
//			Thread.sleep(63000);
//		assertEquals("Lost must be true", true, Board1.lost);
//	}
	
}
