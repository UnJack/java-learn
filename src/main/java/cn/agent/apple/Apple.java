package cn.agent.apple;

import cn.agent.TraceMetadataProvider;

public class Apple implements TraceMetadataProvider
{
	public void setup(){
		System.out.println("apple jar");
	}
}