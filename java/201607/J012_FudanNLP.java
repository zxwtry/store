import org.fnlp.app.keyword.AbstractExtractor;
import org.fnlp.app.keyword.WordExtract;

import edu.fudan.nlp.cn.tag.CWSTagger;
import edu.fudan.nlp.corpus.StopWords;
import edu.fudan.util.exception.LoadModelException;

public class Class1 {
	public static void main(String[] args) {
		teachCase();
	}
	static void teachCase() {
		StopWords sw= new StopWords("models/stopwords");
		CWSTagger seg = null;
		try {
			seg = new CWSTagger("models/seg.m");
			AbstractExtractor key = new WordExtract(seg,sw);
			System.out.println(key.extract("科教处女干事情愿去支教", 3, true));
			System.out.println(key.extract("甬温线特别重大铁路交通事故车辆经过近24小时的清理工作，26日深夜已经全部移出事故现场，之前埋下的D301次动车车头被挖出运走", 3, true));
			System.out.println(key.extract("甬温线特别重大铁路交通事故车辆经过近24小时的清理工作，26日深夜已经全部移出事故现场，之前埋下的D301次动车车头被挖出运走", 20));
			sw=null;
			key = new WordExtract(seg,sw);
			System.out.println(key.extract("甬温线 特别 重大 铁路交通事故车辆经过近24小时的清理工作，26日深夜已经全部移出事故现场，之前埋下的D301次动车车头被挖出运走", 20));
			System.out.println(key.extract("赵嘉亿 是 好人 还是 坏人", 5));
			key = new WordExtract();
			System.out.println(key.extract("", 5));
		} catch (LoadModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
