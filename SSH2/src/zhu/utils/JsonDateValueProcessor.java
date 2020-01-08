package zhu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
 //这里的是时间处理的格式
public class JsonDateValueProcessor  implements JsonValueProcessor {

	private String format = "yyyy-MM-dd";

	@Override
	public Object processArrayValue(Object paramObject, JsonConfig config) {
		return process(paramObject);
	}

	@Override
	public Object processObjectValue(String paramString, Object paramObject,
			JsonConfig config) {
		return process(paramObject);
	}
	public Object process(Object value) {
		if (value instanceof Date) {
			SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
			return sdf.format(value);
		}
		return value == null ? "" : value.toString();
	} 
 
}
