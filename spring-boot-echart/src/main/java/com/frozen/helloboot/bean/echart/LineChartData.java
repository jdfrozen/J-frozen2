package com.frozen.helloboot.bean.echart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author: Frozen
 * @create: 2020-08-13 14:17
 * @description:
 **/
@Data
@Builder
public class LineChartData {
	//标题
	private Title title;
	//工具箱,保存图片
	private Toolbox toolbox;
	//图例-每一条数据的名字叫销量
	private Legend legend;
	@JsonProperty("xAxis")
	private XAxis xAxis;
	@JsonProperty("yAxis")
	private YAxis yAxis;
	//数据-data是最终要显示的数据
	private List<Serie> series;

	@Data
	@ToString
	public static class Title{
		private String text;
	}

	@Data
	@ToString
	public static class Toolbox{
		private Feature feature=new Feature();
		private boolean show=true;
		@Data
		@ToString
		public static class Feature{
			private SaveAsImage saveAsImage = new SaveAsImage();
			@Data
			@ToString
			public static class SaveAsImage{
				private boolean show=true;
			}
		}
	}
	@Data
	@ToString
	public static class Legend{
		private List<String> data;
	}
	@Data
	@ToString
	public static class Serie{
		private String name;
		private String type;
		private List<Integer> data;
	}
}
