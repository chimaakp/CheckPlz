import static org.junit.Assert.*;

import org.junit.Test;

public class GameTests {
	int W = 4;
	int H = 8;
	
	Rock Rock1 = new Rock(W, H);
	
	@Test
	public void Rock_Constructor_GetX_GetY_ToString_Test() {
		assertTrue("xCoord must be between 0 and " + Integer.toString(W), 0 <= Rock1.getX() && Rock1.getX() < W);
		assertEquals("yCoord must be 0", 0, Rock1.getY());
		assertEquals("Model must be O", "O", Rock1.toString());
	}
	
	@Test
	public void Rock_MoveRock_SetY_GetY_Test() {
		Rock1.moveRock();
		assertEquals("yCoord must be 1", 1, Rock1.getY());
		
	}
	
	@Test
	public void Rock_SetX_Test() {
		int X = Rock1.getX();
		Rock1.setxCoord(Rock1.getX() + 1);
		assertEquals("xCoord must be " + Integer.toString(X + 1), X + 1, Rock1.getX());
	}
	
	Player Player1 = new Player(H, W);
	long createTime = System.currentTimeMillis();
	
	@Test
	public void Player_Constructor_GetX_GetY_GetScore_GetTime_ToString_Test() {
		assertEquals("Xcoord must be " + Integer.toString(W/2), W/2, Player1.getX());
		assertEquals("Ycoord must be " + Integer.toString(H), H, Player1.getY());
		assertEquals("Model must be X", "X", Player1.toString());
		assertEquals("Score must be 0", 0, Player1.getScore());
		assertTrue("Time difference must be 0 or 1", 0 <= Player1.getTime() && Player1.getTime() < 2);
	}
	
	@Test
	public void Player_UpScore_GetScore_Test() {
		Player1.upScore();
		assertEquals("Score must be 1", 1, Player1.getScore());
	}
	
	@Test
	public void Player_SetY_GetY_Test() {
		Player1.setYcoord(0);
		assertEquals("Ycoord must be 0", 0, Player1.getY());
	}
	
	@Test
	public void Player_MoveLeft_SetX_GetX_GetScore_Test() {
		Player1.moveLeft();
		assertEquals("Xcoord must be " + Integer.toString((W/2) - 1), (W/2) - 1, Player1.getX());
		assertEquals("Score must be 1", 1, Player1.getScore());
	}
	
	@Test
	public void Player_MoveRight_SetX_GetX_GetScore_Test() {
		Player1.moveRight();
		assertEquals("Xcoord must be " + Integer.toString((W/2) + 1), (W/2) + 1, Player1.getX());
		assertEquals("Score must be 1", 1, Player1.getScore());
		
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
	}
	
	
	
	
	@Test
	public void Board_MoveRight_Test() {
		for(int i = 0; i < 12; i++) {
			Board1.takeTurn('o');
		}
		assertEquals("Xcoord must be 0", 0 , Board1.player.getX());
		Board1.player.setXcoord(-1);
		Board1.takeTurn('p');
		assertEquals("Xcoord must be 0", 0 , Board1.player.getX());
	}
	
	@Test
	public void Board_MoveLeft_Test() {
		for(int i = 0; i < 12; i++) {
			Board1.takeTurn('p');
		}
		assertEquals("Xcoord must be 19", 19 , Board1.player.getX());
		Board1.player.setXcoord(20);
		Board1.takeTurn('o');
		assertEquals("Xcoord must be 19", 19 , Board1.player.getX());
	}

	@Test
	public void Board_MoveRocks_Test() {
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
