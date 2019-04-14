package com.java.base.instrumentation.premain;

public class TransformerTargetMain {
   public static void main(String[] args) { 
   		System.out.println("args = " + args);
       	System.out.println(new TransformerTarget().getObject()); 
   } 
}