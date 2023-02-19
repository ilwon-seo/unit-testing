package mockinjection;

public class Composer {
	private Score score;

	public Composer(Score score) {
		this.score = score;
	}

	public Composer() {

	}

	public void composeMusic(Score score){
		this.score = score;
	}

	public String getScore(){
		return score.getStr();
	}
}
