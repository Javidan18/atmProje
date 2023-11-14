package hafta6;

import java.util.ArrayList;
import java.util.Scanner;

public class Survey {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // kullanıcı girdisini almak için bir tarayıcı oluşturalım
	    ArrayList<SocialIssue> issues = new ArrayList<>(); // sosyal sorunların bir listesini tutmak için bir dizi liste oluşturalım

	    // Sosyal sorunları ve başlangıç puanlarını belirleyelim
	    issues.add(new SocialIssue("İşsizlik", 5));
	    issues.add(new SocialIssue("Yoksulluk", 4));
	    issues.add(new SocialIssue("Eğitim", 3));
	    issues.add(new SocialIssue("Sağlık", 2));
	    issues.add(new SocialIssue("Çevre", 1));

	    int person = 1; // anketi yapan kişinin sayısını tutmak için bir değişken
	    boolean continueSurvey = true; // anketin devam edip etmediğini kontrol etmek için bir değişken

	    // Anketi yapmaya başlayalım
	    System.out.println("Sosyal sorunlar hakkında bir anket yapmaya hoş geldiniz.");
	    System.out.println("Lütfen aşağıdaki sosyal sorunları 1'den 5'e kadar puanlayınız.");
	    System.out.println("1: Çok önemsiz, 5: Çok önemli");

	    // Anket devam ettiği sürece döngü yapalım
	    while (continueSurvey) {
	      System.out.println(person + ". kişi olarak cevap veriyorsunuz.");

	      // Her bir sosyal sorun için kullanıcıdan bir puan isteyelim
	      for (SocialIssue issue : issues) {
	        System.out.print(issue.name + ": ");
	        int score = input.nextInt(); // kullanıcının girdiği puanı alalım
	        issue.score += score; // sosyal sorunun toplam puanını güncelleyelim
	        issue.count++; // sosyal sorunun puanlanan kişi sayısını artıralım
	      }

	      // Anketi yapacak başka bir kişi olup olmadığını sor
	      System.out.print("Anketi yapacak başka bir kişi var mı? (E/H): ");
	      String answer = input.next(); // kullanıcının girdiği cevabı alalım

	      // Cevaba göre anketin devam edip etmediğini belirleyelim
	      if (answer.equalsIgnoreCase("E")) {
	        continueSurvey = true; // anket devam etsin
	        person++; // anketi yapan kişi sayısını artıralım
	      } else if (answer.equalsIgnoreCase("H")) {
	        continueSurvey = false; // anket sona ersin
	      } else {
	        System.out.println("Lütfen E veya H harflerinden birini giriniz.");
	      }
	    }

	    // Anket bittiğinde sonuçları gösterelim
	    System.out.println("Anket sona erdi. İşte sonuçlar:");

	    // En yüksek ve en düşük puanı tutmak için değişkenler
	    int maxScore = 0;
	    int minScore = Integer.MAX_VALUE;
	    SocialIssue maxIssue = null;
	    SocialIssue minIssue = null;

	    // Her bir sosyal sorun için ortalama puanı hesaplayalım ve ekrana yazdıralım
	    for (SocialIssue issue : issues) {
	      double average = issue.getAverage(); // ortalama puanı alalım
	      System.out.println(issue.name + ": " + average); // ekrana yazdıralım

	      // En yüksek ve en düşük puanı güncelleyelim
	      if (issue.score > maxScore) {
	        maxScore = issue.score;
	        maxIssue = issue;
	      }
	      if (issue.score < minScore) {
	        minScore = issue.score;
	        minIssue = issue;
	      }
	    }

	    // En yüksek ve en düşük puan alan sosyal sorunları gösterelim
	    System.out.println("En yüksek puanı alan sosyal sorun: " + maxIssue.name + " (" + maxScore + ")");
	    System.out.println("En düşük puanı alan sosyal sorun: " + minIssue.name + " (" + minScore + ")");

	}

}
