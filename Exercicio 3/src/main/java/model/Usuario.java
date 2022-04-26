package model;

public class Usuario {
	private int player_id;
	private int skin_id;
	private boolean mana_tip;
	private int power;
	
	public Usuario() {
		this.player_id = 0;
		this.skin_id = 0;
		this.mana_tip = true;
		this.power = 0;
	}
	
	public Usuario(int player_id, int skin_id, boolean mana_tip, int power) {
		this.player_id = player_id;
		this.skin_id = skin_id;
		this.mana_tip = mana_tip;
		this.power = power;
	}

	public int getplayer_id() {
		return player_id;
	}

	public void setplayer_id(int player_id) {
		this.player_id = player_id;
	}

	public int getskin_id() {
		return skin_id;
	}

	public void setskin_id(int skin_id) {
		this.skin_id = skin_id;
	}

	public boolean getmana_tip() {
		return mana_tip;
	}
	public void setmana_tip(boolean mana_tip) {
		this.mana_tip = mana_tip;
	}

	public int getpower() {
		return power;
	}

	public void setpower(int power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "Usuario [player_id=" + player_id + ", skin_id=" + skin_id + ", mana_tip=" + mana_tip + ", power=" + power + "]";
	}
	
}
