package jp.trans_it.shindan.model;

/**
 * 選択肢情報 管理クラス
 */
public class Item {
	private int id;
	private String text;

	/**
	 * コンストラクター
	 * @param id 選択肢 ID
	 * @param text 選択肢 文字列
	 */
	public Item(int id, String text) {
		this.id = id;
		this.text = text;
	}

	/**
	 * 選択肢 ID を取得する
	 * @return 選択肢 ID
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 選択肢 文字列を取得する
	 * @return 選択肢 文字列
	 */
	public String getText() {
		return text;
	}
}
