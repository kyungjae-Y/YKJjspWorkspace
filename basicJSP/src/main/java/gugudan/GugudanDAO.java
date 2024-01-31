package gugudan;

import java.util.ArrayList;
import java.util.Random;

public class GugudanDAO {
	private int count;
	private int score;

	ArrayList<GugudanVO> quiz;

	public GugudanDAO() {
		quiz = new ArrayList<GugudanVO>();
		makeQuiz();
		count = 0;
	}

	private void makeQuiz() {
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			GugudanVO vo = new GugudanVO(random.nextInt(8) + 2, random.nextInt(9) + 1);
			quiz.add(vo);
		}
	}

	public boolean checkAnswer(String input) {
		int answer = Integer.parseInt(input);
		GugudanVO vo = quiz.get(count);
		if (answer == vo.getNum1() * vo.getNum2()) {
			count++;
			score += 20;
			return true;
		}
		count++;
		return false;
	}

	public String getQuiz() {
		return quiz.get(count).toString();
	}

	public int getCount() {
		return count;
	}

	public int getScore() {
		return score;
	}
}
