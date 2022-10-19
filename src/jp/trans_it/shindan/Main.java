package jp.trans_it.shindan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.trans_it.shindan.model.Item;
import jp.trans_it.shindan.model.Question;
import jp.trans_it.shindan.model.Result;
import jp.trans_it.shindan.model.Shindan;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		start(reader);
		
		reader.close();
	}
	
	private static void start(BufferedReader reader) throws IOException {
		System.out.println("===  むかしばなし診断 ===");
		Shindan shindan = new Shindan();
		List<Integer> answers = new ArrayList<Integer>();
		
		for(Question question : shindan.getQuestions()) {
			System.out.println("");
			System.out.println("● " + question.getQuestion());
			
			int counter = 1;
			Map<Integer, Item> itemMap = new HashMap<Integer, Item>();
			for(Item item : question.getItems()) {
				
				System.out.println("   " + counter + " - " + item.getText());
				itemMap.put(counter, item);
				counter++;
			}
			
			int answer = getAnswer(shindan, reader);
			int id = itemMap.get(answer).getId();
			answers.add(id);
		}
		
		Result result = shindan.check(answers);
		showResult(result);
	}
	
	private static int getAnswer(Shindan shindan, BufferedReader reader) throws IOException {
		int answer = 0;

		boolean loop = true; 
		while(loop) {
			String line = reader.readLine();
			try {
				answer = Integer.parseInt(line);
				if(answer >= 1 && answer <= shindan.getResults().size()) {
					loop = false;
				}
				else {
					System.out.println("1 ～ " + shindan.getResults().size() + " の数字を入力してください。");
				}
			}
			catch(Exception e) {
				System.out.println("数値を入力してください。");
			}
		}
		
		return answer;
	}
	
	private static void showResult(Result result) {
		System.out.println("");
		System.out.println("あなたの診断結果は ■ " + result.getName() + " ■ です。");
		System.out.println("   " + result.getDescription());
	}
}
