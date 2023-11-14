package hafta6;

public class SocialIssue {
	String name; // sosyal sorunun adı
	  int score; // sosyal sorunun puanı
	  int count; // sosyal sorunun kaç kişi tarafından puanlandığı

	  // Sosyal sorunun adını ve başlangıç puanını vererek bir nesne oluşturan bir kurucu
	  public SocialIssue(String name, int score) {
	    this.name = name;
	    this.score = score;
	    this.count = 1; // başlangıçta bir kişi tarafından puanlandığını varsayalım
	  }

	  // Sosyal sorunun ortalamasını hesaplayan bir metod
	  public double getAverage() {
	    return (double) score / count;
	  }
}
