/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmtheis.yandtran.translate;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import com.rmtheis.yandtran.ApiKeys;
import com.rmtheis.yandtran.YandexTranslatorAPI;
import com.rmtheis.yandtran.language.Language;
public class Translate extends YandexTranslatorAPI{

	private static final String SERVICE_URL = "https://translate.yandex.net/api/v1.5/tr.json/translate?";
	  private static final String TRANSLATION_LABEL = "text";

	  //prevent instantiation
	  public Translate(){};

	  /**
	   * Translates text from a given Language to another given Language using Yandex.
	   * 
	   * @param text The String to translate.
	   * @param from The language code to translate from.
	   * @param to The language code to translate to.
	   * @return The translated String.
	   * @throws Exception on error.
	   */
	  public static String execute(final String text, final Language from, final Language to) throws Exception {
	    validateServiceState(text); 
	    final String params = 
	        PARAM_API_KEY + URLEncoder.encode(apiKey,ENCODING) 
	        + PARAM_LANG_PAIR + URLEncoder.encode(from.toString(),ENCODING) + URLEncoder.encode("-",ENCODING) + URLEncoder.encode(to.toString(),ENCODING) 
	        + PARAM_TEXT + URLEncoder.encode(text,ENCODING);
	    final URL url = new URL(SERVICE_URL + params);
	    return retrievePropArrString(url, TRANSLATION_LABEL).trim();
	  }

	  private static void validateServiceState(final String text) throws Exception {
	    final int byteLength = text.getBytes(ENCODING).length;
	    if(byteLength>10240) { // TODO What is the maximum text length allowable for Yandex?
	      throw new RuntimeException("TEXT_TOO_LARGE");
	    }
	    validateServiceState();
	  }
	  
//	  public static void main(String[] args) {
//	    try {
//	      Translate.setKey(ApiKeys.YANDEX_API_KEY);
//	      Scanner a= new Scanner(System.in);
//	      System.out.println("Nhập từ muốn dịch: ");
//	      String b= a.nextLine();
//	      String translation = Translate.execute(b, Language.ENGLISH, Language.VIETNAM);
//	      System.out.println("Translation: " + translation);
//	    } catch (Exception e) {
//	      // TODO Auto-generated catch block
//	      e.printStackTrace();
//	    }
//	  }
	  public String tran(String text)
	  {
		  try {
		      Translate.setKey(ApiKeys.YANDEX_API_KEY);
     	      String translation = Translate.execute(text, Language.ENGLISH, Language.VIETNAM);
              return translation;
	          //System.out.println("Translation: " + translation);
		    } catch (Exception e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
                  return "false";
	  }
}
