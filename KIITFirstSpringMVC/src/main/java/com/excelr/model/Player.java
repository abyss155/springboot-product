package com.excelr.model;

public class Player {
	
	private int jno;
	private String playerName;
	private int mp;
	private int rs;
	
	public Player() {}
	
	public Player(int jno, String playerName, int mp, int rs) {
		this.jno = jno;
		this.playerName = playerName;
		this.mp = mp;
		this.rs = rs;
	}

	public int getJno() {
		return jno;
	}

	public void setJno(int jno) {
		this.jno = jno;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getRs() {
		return rs;
	}

	public void setRs(int rs) {
		this.rs = rs;
	}

	@Override
	public String toString() {
		return "Player [jno=" + jno + ", playerName=" + playerName + ", mp=" + mp + ", rs=" + rs + "]";
	}
	
	
	

}
