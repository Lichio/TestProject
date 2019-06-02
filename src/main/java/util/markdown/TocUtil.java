package util.markdown;

import com.github.houbb.markdown.toc.core.impl.AtxMarkdownToc;

/**
 * TestProject util.markdown
 *
 * @author Lichaojie
 * @version 2019/6/2 19:17
 */
public class TocUtil {
	public static void main(String[] args){
		String path = "E:\\Java\\Code\\IdeaProjects\\webmall\\api.md";
		AtxMarkdownToc.newInstance().genTocFile(path);
	}
}
