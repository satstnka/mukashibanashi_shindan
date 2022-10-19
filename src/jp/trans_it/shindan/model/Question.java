package jp.trans_it.shindan.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 質問情報管理クラス
 */
public class Question {
	private String key;
	private String question;
	List<Item> items;

	/**
	 * コンストラクター
	 * @param key 質問のパラメーター名
	 * @param question 質問文
	 */
	public Question(String key, String question) {
		this.key = key;
		this.question = question;
		this.items = new ArrayList<Item>();
	}

	/**
	 * 質問のパラメーター名を取得する
	 * @return 質問のパラメーター名
	 */
	public String getKey() {
		return key;
	}

	/**
	 * 質問文を取得する
	 * @return 質問文
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * 選択肢一覧を取得する
	 * @return 選択肢一覧
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * 選択肢を追加する
	 * @param id 選択肢 ID
	 * @param description 選択肢 (文字列)
	 */
	public void addItem(int id, String description) {
		Item item = new Item(id, description);
		this.items.add(item);
	}

	/**
	 * 選択肢をシャッフルする
	 */
	public void shuffle() {
		Collections.shuffle(this.items);
	}
}
