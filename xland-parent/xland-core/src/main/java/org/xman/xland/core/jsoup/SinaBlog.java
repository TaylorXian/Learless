package org.xman.xland.core.jsoup;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SinaBlog {

	public static void main(String[] args) {
		String url_p1 = "http://blog.sina.com.cn/s/articlelist_1780059090_0_1.html";
		String url_p2 = "http://blog.sina.com.cn/s/articlelist_1780059090_0_2.html";
		extractBlogLink(url_p1);
		extractBlogLink(url_p2);
	}

	private static void extractBlogLink(String url_p1) {
		try {
			Document document = Jsoup.connect(url_p1).get();
			String cssQuery = "span.atc_title > a";
			Elements elements = document.select(cssQuery);
			int i = 0;
			for (Iterator<Element> iterator = elements.iterator(); iterator
					.hasNext();) {
				Element element = iterator.next();
				String blogUrl = element.attr("href");
				System.out.println(++i + " " + element.text());
				System.out.println(blogUrl);
				extractBlog(blogUrl);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void extractBlog(String blogUrl) {
		try {
			Document document = Jsoup.connect(blogUrl).get();
			String cssTitle = "div.articalTitle h2.titName";
			String title = getElementContent(document, cssTitle);
			String cssTime = "div.articalTitle span.time";
			String time = getElementContent(document, cssTime);
			String cssContent = "div.articalContent";
			String htmlContent = document.select(cssContent).first().html();
			String cssCategory = "td.blog_class a";
			String category = getElementContent(document, cssCategory);
			System.out.println(title);
			System.out.println(time);
			System.out.println(category);
			System.out.println(htmlContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getElementContent(Document document, String cssQuery) {
		Elements es = document.select(cssQuery);
		if (es.size() > 0) {
			return es.first().text();
		}
		return null;
	}

}
