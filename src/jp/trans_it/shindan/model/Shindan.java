package jp.trans_it.shindan.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Shindan {
	private List<Result> results;
	private List<Question> questions;
	
	public Shindan() throws IOException {
		init();
	}
	
	public List<Result> getResults() {
		return results;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	private void init() throws IOException {
		InputStream stream = Shindan.class.getResourceAsStream("shindan.csv");
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		
		this.results = createResults(reader);
		this.questions = createQuestions(reader);
		shuffle();
		
		reader.close();
		stream.close();
	}

	private List<Result> createResults(BufferedReader reader) throws IOException {
		List<Result> results = new ArrayList<Result>();
		
		String line = reader.readLine();
		String[] names = line.split(",");
		
		line = reader.readLine();
		String[] descriptions = line.split(",");
		
		for(int i = 1; i < names.length && i < descriptions.length; i++) {
			Result result = new Result(names[i], descriptions[i]);
			results.add(result);
		}

		return results;
	}

	private List<Question> createQuestions(BufferedReader reader) throws IOException {
		List<Question> questions = new ArrayList<Question>();
		
		int counter = 1;
		String line = null;
		while((line = reader.readLine()) != null) {
			String[] tokens = line.split(",");
			if(tokens.length >= this.results.size() + 1) {
				Question question = new Question("q" + counter, tokens[0]);
				for(int i = 1; i < tokens.length; i++) {
					question.addItem(i - 1,  tokens[i]);
				}
				questions.add(question);
				counter++;
			}
		}
		
		return questions;
	}

	
	private void shuffle() {
		for(int i = 0; i < this.questions.size(); i++) {
			Question question = this.questions.get(i);
			question.shuffle();
		}
		Collections.shuffle(this.questions);
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
