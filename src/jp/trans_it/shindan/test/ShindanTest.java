package jp.trans_it.shindan.test;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import jp.trans_it.shindan.model.Item;
import jp.trans_it.shindan.model.Question;
import jp.trans_it.shindan.model.Result;
import jp.trans_it.shindan.model.Shindan;

class ShindanTest {
	@Test
	void testDisplay() throws IOException {
		Shindan shindan = new Shindan();
		
		System.out.println("■ 結果一覧");
		for(Result result : shindan.getResults()) {
			System.out.println("   ● " + result.getName());
			System.out.println("      " + result.getDescription());
		}
		
		System.out.println("■ 質問一覧");
		for(Question question : shindan.getQuestions()) {
			System.out.println("   ●" + question.getQuestion());
			for(Item item : question.getItems()) {
				System.out.println("      " + item.getId() + " - " + item.getText());
			}
		}
	}
}
