package jp.trans_it.shindan.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Shindan {
	private List<Result> results;
	private List<Question> questions;

	private Shindan() {
		this.results = new ArrayList<Result>();
		this.questions = new ArrayList<Question>();
	}

	public List<Result> getResults() {
		return results;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void shuffle() {
		for(Question question : this.questions) {
			question.shuffle();
		}
		Collections.shuffle(this.questions);
	}

	private static List<Result> getResultList() {
		Result[] results = {
			new Result(
				"ももたろう",
				"だれとでも仲良くなれる素質を持っています。"
			),
			new Result(
				"かぐやひめ",
				"ずっと周りから大切にされるでしょう。"
			),
			new Result(
				"うらしまたろう",
				"とてもやさしい性格をしていますが、それでたまに失敗してしまうかもしれません。"
			),
			new Result(
				"ねずみのよめいり",
				"行動力が旺盛で移動範囲も広いです。ですが大切なものは意外と近くにあるかも"
			)
		};

		List<Result> list = Arrays.asList(results);
		return list;
	}

	private static List<Question> getQuestionList()  {
		List<Question> list = new ArrayList<Question>();

		Question question1 = new Question("q1", "次の中で行きたい場所は?");
		question1.addItem(0, "のんびりとした「島」");
		question1.addItem(1, "思い切って「月」");
		question1.addItem(2, "雄大な「海」");
		question1.addItem(3, "やっぱり「ディズニーランド」");
		list.add(question1);

		Question question2 = new Question("q2", "あなたが好きな食べ物は?");
		question2.addItem(0, "甘くてジューシーな「桃」");
		question2.addItem(1, "春の味覚「たけのこ」");
		question2.addItem(2, "やっぱり海の幸「お刺身」");
		question2.addItem(3, "香り豊かな「チーズ」");
		list.add(question2);

		Question question3 = new Question("q3", "自然な王様といえば?");
		question3.addItem(0, "川");
		question3.addItem(1, "空");
		question3.addItem(2, "海");
		question3.addItem(3, "太陽");
		list.add(question3);

		Question question4 = new Question("q4", "休日は何をしてすごす?");
		question4.addItem(0, "仲間と楽しく「ボート」に乗る");
		question4.addItem(1, "自宅で風流に「お月見」");
		question4.addItem(2, "優雅に海で「ダイビング」");
		question4.addItem(3, "のんびりと「散歩」");
		list.add(question4);

		Question question5 = new Question("q5", "あなたが好きな動物は?");
		question5.addItem(0, "犬");
		question5.addItem(1, "うさぎ");
		question5.addItem(2, "かめ");
		question5.addItem(3, "ねずみ");
		list.add(question5);

		return list;
	}

	public static Shindan createShindan() {
		Shindan shindan = new Shindan();

		List<Result> results = getResultList();
		shindan.getResults().addAll(results);

		List<Question> questions = getQuestionList();
		shindan.getQuestions().addAll(questions);

		shindan.shuffle();

		return shindan;
	}

	public Result check(List<Integer> answers) {
		int[] counters = new int[this.results.size()];
		Arrays.fill(counters, 0);

		for(Integer index : answers) {
			counters[index]++;
		}

		int index = 0;
		int maxCount = 0;
		for(int i = 0; i < counters.length; i++) {
			int counter = counters[i];
			if(counter > maxCount) {
				index = i;
				maxCount = counter;
			}
		}

		return this.results.get(index);
	}
}
