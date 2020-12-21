
//登録した本のタイトルと作者のデータを保持する

package bean;

public class Book implements java.io.Serializable {
	private String title;
	private String author;

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public void setTitle(String title) {
		title = this.title;
	}

	public void setAuthor(String author) {
		author = this.author;
	}
}