package org.schedulerX;

import com.alibaba.edas.schedulerx.ProcessResult;
import com.alibaba.edas.schedulerx.ScxSimpleJobContext;
import com.alibaba.edas.schedulerx.ScxSimpleJobProcessor;

import java.util.Date;

/**
 * TestProject org.schedulerX
 *
 * @author Lichaojie
 * @version 2019/4/11 11:43
 */
public class HelloWordSimpleJobProcessor implements ScxSimpleJobProcessor {
	@Override
	public ProcessResult process(ScxSimpleJobContext scxSimpleJobContext) {
		System.out.println("Hello World! " + new Date());
		//true 表示执行成功，false 表示失败
		return new ProcessResult(true);
	}
}
