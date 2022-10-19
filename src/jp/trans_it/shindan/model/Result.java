package jp.trans_it.shindan.model;


/**
 * 診断結果情報 管理クラス
 *
 */
public class Result {
	private String name;
	private String description;

	/**
	 * コンストラクター
	 * @param name 診断結果名
	 * @param description 診断結果説明
	 */
	public Result(String name, String description) {
		this.name = name;
		this.description = description;
	}

	/**
	 * 診断結果名を取得する
	 * @return 診断結果名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 診断結果の説明を取得する
	 * @return 診断結果の説明
	 */
	public String getDescription() {
		return description;
	}
}
